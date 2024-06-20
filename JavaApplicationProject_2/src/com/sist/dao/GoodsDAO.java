package com.sist.dao;
import java.util.*;
import java.sql.*;
/*
 *  1. JDBC - 자바에서 데이터베이스 연결하는 라이브러리
 *            java.sql
 *     1) 드라이버 등록
 *        Class.forName("드라이버 클래스") - 각 데이터베이스 업체마다 다름
 *        └ 클래스의 정보를 읽어서 메모리 할당, 멤버변수 값 주입, 메소드 호출
 *          리플렉션(스프링, 스프링부트, MyBatis)
 *     2) 데이터베이스 연결
 *        Connection - Connection conn=DriverManager.getConnection(URL, username, password) => java
 *                     conn username/password => sql
 *                     URL - jdbc:업체명:드라이버명:@IP:PORT:데이터베이스명
 *                           jdbc:oracle:thin:@localhost:1521:XE
 *                           thin - 연결만 담당, 속도가 늦다
 *     3) SQL 문장 생성 - String
 *          String sql="SELECT ~", "INSERT", "UPDATE", "DELETE" => DML, 데이터 제어
 *          DDL - CREATE, ALTER, DROP, RENAME, TRUNCATE, GRANT, REVOKE => 오라클 자체처리
 *        SQL문장을 오라클 전송
 *          PreparedStatement ps=conn.preparedStatement(sql)
 *     4) SQL문장 실행 후에 결과값 받기 - SELECT
 *          INSERT / UPDATE / DELETE => executeUpdate() : commit()호출 포함, 데이터 갱신
 *          SELECT => executeQuery() : 실행된 결과값을 읽어온다
 *          ResultSet rs=ps.excuteQuery()
 *            => SELECT id, name, gender
 *               ------------------------
 *               컬럼명 ID    NAME   GENDER
 *               ------------------------
 *                   aaa    홍길동    남자   ===> next()
 *               ------------------------
 *                   bbb    심청이    여자
 *               ------------------------
 *                   ccc    춘향이    여자   ===> previous()
 *               ------------------------
 *       rs.getString(1)     (2)    (3)   ===> getString(), getInt(), getDate(), getDouble()
 *      rs.getString("id")("name")("gender")
 *          ==> JDBC => SQL관련 - 오라클 문법 적용 => 번호 1번부터
 *     5) 닫기
 *        rs.close()
 *        ps.close()
 *        conn.close()
 *        => 1. Connection 반드시 닫기 => 닫기가 안되면 Connection 사용하지 않는데 연결중
 *           2. 사용자가 Connection을 한개만 사용할 수 있게 만든다 => 싱글턴
 *           3. JDBC - 연결시마다 Connection 생성
 *              웹에서는 DBCP 이용 - Connection 미리 연결
 *              라이브러리 MyBatis(실무), Hibernate(자동으로 SQL문장 생성=JPA)
 *     주의점!
 *        문자열로 되어있다 => 컴파일시에 에러가 없다, 실행시 에러, 공백 주의
 *                          ex) String sql="SELECT" 
 *                        오라클 SQL문장과 다른 점 주의
 *                          ex) LIKE
 *                        1) SQL - 오라클 먼저 실행 => 자바에 전송
 *                        2) 웹 - SQL 85%
 *                        
 *  인라인뷰 - 페이징
 *           1. 총페이지
 *           2. 검색
 */
public class GoodsDAO {
	//오라클 연결
	private Connection conn;
	//SQL문장 송수신
	private PreparedStatement ps;
	//오라클 주소 저장 => 변경불가 => 상수
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	//싱글턴 - 메모리 누수현상 방지
	private static GoodsDAO dao;
	//1.드라이버 등록 => 한번만 수행 => 생성자
	public GoodsDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	
	//2.오라클 연결 => SQL문장 => 재사용
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL, "hr", "happy");
		}catch(Exception ex) {}
	}
	//3.오라클 해제
	public void disConnection() {
		try {
			if(ps!=null) { //null이면 생성이 안된거
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}catch(Exception ex) {}
	}
	//4.싱글턴, static은 메모리 공간 1개만 생성
	public static GoodsDAO newInstance() {
		if(dao==null) {
			dao=new GoodsDAO();
		}
		return dao;
	}
	//---------------------------------- DAO 필수 공통 코드
	
	// 기능
	// 총페이지 구하기
	public int goodsTotalPage() {
		int total=0;
		try {
			//1.연결
			getConnection();
			//2.SQL문장
			String sql="SELECT CEIL(COUNT(*)/12.0) FROM goods_all";
			//3.오라클로 전송
			ps=conn.prepareStatement(sql);
			//4.SQL문장 실행결과 요청 => 실행결과 저장 ResultSet
			ResultSet rs=ps.executeQuery();
			//5.커서위치를 데이터가 출력된 첫번째 위치로 이동
			rs.next();
			total=rs.getInt(1);
			//6.메모리 닫기
			rs.close();
			
			//쉬운 프로그램은 모든 개발자가 동일한 코딩을 하는 프로그램 => 표준화
			//=> 라이브러리 사용 MyBatis, Spring
		}catch(Exception ex) {
			//에러확인 => 복구는 불가
			ex.printStackTrace();
		}finally {
			//닫기
			disConnection();
		}
		return total;
	}
	// 목록출력 => 페이징 => 인라인뷰
	// 기능설정 => 리턴형 => 사용자로부터 어떤 값을 받는지(매개변수)
	/*
	 *                          파이썬/C#/C/C++/코틀린
	 *            브라우저 ============== 자바 ================ 오라클 
	 *     HTML/CSS/JavaScript    브라우저-오라클 연결   사이트,윈도우에 필요한 데이터 저장
	 *   
	 *   HTML, XML - 브라우저에서 실행 가능한 언어
	 *   Ajax/VueJS/ReactJS - 오라클에서 받은 데이터를 화면상으로 뿌리는 역할
	 *   파이썬 - 장고
	 *   C# - ASP.net
	 *   자바, 코틀린 - 스프링
	 */
	public ArrayList<GoodsVO> goodsListData(int page){
		ArrayList<GoodsVO> list=new ArrayList<GoodsVO>();
		//VO - 상품 한개에 대한 모든 정보 저장
		try {
			getConnection();
			//오라클에서 페이지 나누기, 인라인뷰 => 가상컬럼 rownum 자르기
			//rownum => Top-N => 처음부터 자르기만 가능, 중간을 자르는 건 불가
			String sql="SELECT no, goods_name, goods_poster, num "
					+"FROM (SELECT no, goods_name, goods_poster, rownum as num "
					+"FROM (SELECT no, goods_name, goods_poster "
					+"FROM goods_all ORDER BY no ASC)) "
					+"WHERE num BETWEEN ? AND ?";
			//물음표에 값 채우기
			//rownum 1번부터 시작
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps=conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			//실행요청
			ResultSet rs=ps.executeQuery();
			//첫번째줄부터 읽기
			while(rs.next()) {
				GoodsVO vo=new GoodsVO();
				vo.setNo(rs.getInt(1));
				vo.setGoods_name(rs.getString(2));
				vo.setGoods_poster(rs.getString(3));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
	
	// 상세보기 - 한개에 대한 정보
	/*
	NO                                                 NUMBER(38)
	GOODS_NAME                                         VARCHAR2(4000)
	GOODS_SUB                                          VARCHAR2(4000)
	GOODS_PRICE                                        VARCHAR2(26)
	GOODS_DISCOUNT                                     NUMBER(38)
	GOODS_FIRST_PRICE                                  VARCHAR2(26)
	GOODS_DELIVERY                                     VARCHAR2(26)
	GOODS_POSTER                                       VARCHAR2(4000)
	HIT                                                NUMBER(38) 
	*/
	public GoodsVO goodsDetailData(int no) {
		GoodsVO vo=new GoodsVO();
		try {
			getConnection();
			//조회수 증가
			String sql="UPDATE goods_all SET "
					+"hit=hit+1 "
					+"WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate(); //commit()포함
			
			//데이터 읽기
			sql="SELECT no, goods_name, goods_sub, goods_price, goods_discount, "
					+"goods_first_price, goods_delivery, goods_poster "
					+"FROM goods_all "
					+"WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			//깂을 VO에 저장
			vo.setNo(rs.getInt(1));
			vo.setGoods_name(rs.getString(2));
			vo.setGoods_sub(rs.getString(3));
			vo.setGoods_price(rs.getString(4));
			vo.setGoods_discount(rs.getInt(5));
			vo.setGoods_first_price(rs.getString(6));
			vo.setGoods_delivery(rs.getString(7));
			vo.setGoods_poster(rs.getString(8));
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return vo;
	}
	// 검색 => LIKE
	public ArrayList<GoodsVO> goodsFindData(String name){
		ArrayList<GoodsVO> list=new ArrayList<GoodsVO>();
		try {
			getConnection();
			String sql="SELECT no, goods_name, goods_poster, goods_price "
					+"FROM goods_all "
					+"WHERE goods_name LIKE '%'||?||'%' "
					+"ORDER BY no ASC";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				GoodsVO vo=new GoodsVO();
				vo.setNo(rs.getInt(1));
				vo.setGoods_name(rs.getString(2));
				vo.setGoods_poster(rs.getString(3));
				vo.setGoods_price(rs.getString(4));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
	//구매 => INSERT, UPDATE, DELETE
	/*
	 * private int cno, gno, price, account;
	   private String id;
	   private Date regdate;
	 */
	public void cartInsert(CartVO vo) {
		try {
			getConnection();
			String sql="INSERT INTO cart(cno, gno, id, price, account) "
					+"VALUES(cart_cno_seq.nextval, ?, ?, ?, ?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo.getGno());
			ps.setString(2, vo.getId());
			ps.setInt(3, vo.getPrice());
			ps.setInt(4, vo.getAccount());
			ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
	}
	public void cartCancel(int cno) {
		try {
			getConnection();
			String sql="DELETE FROM cart WHERE cno="+cno;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
	}
	/*
	 *  설계 => 테이블 설계 => 6,7장
	 *  시퀀스
	 *  인덱스 : 자주 검색 / 데이터 출력이 많은 경우 => 속도 최적화
	 *  자주 사용하는 SQL : View
	 *  테이블 여러개 연결 : Join / SubQuery
	 *  반복 수행 => 댓글 => 함수 => PL/SQL
	 *  SQL소스량을 줄인다 => 자동화 처리 => Trigger 
	 */
	public List<CartVO> cartSelect(String id){ //마이페이지에서 내 아이디 내역만 불러오기
		List<CartVO> list=new ArrayList<CartVO>();
		try {
			getConnection();
			 String sql="SELECT cno,price,account,"
  				   +"(SELECT goods_poster FROM goods_all WHERE no=cart.gno),"
  				   +"(SELECT goods_name FROM goods_all WHERE no=cart.gno),"
  				   +"(SELECT goods_price FROM goods_all WHERE no=cart.gno) "
  				   +"FROM cart "
  				   +"WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CartVO vo=new CartVO();
				vo.setCno(rs.getInt(1));
				vo.setPrice(rs.getInt(2));
				vo.setAccount(rs.getInt(3));
				vo.getGvo().setGoods_poster(rs.getString(4));
				vo.getGvo().setGoods_name(rs.getString(5));
				vo.getGvo().setGoods_price(rs.getString(6));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
}
