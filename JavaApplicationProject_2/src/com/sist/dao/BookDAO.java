package com.sist.dao;
import java.util.*;
import java.util.Date;

import javax.swing.text.SimpleAttributeSet;
import java.sql.*;
import java.text.SimpleDateFormat;
public class BookDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@192.168.10.124:1521:XE";
	private static BookDAO dao; //싱글턴
	
	//1.드라이버 등록
	public BookDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	
	//2.오라클 연결
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr2","happy"); //conn hr/happy
		}catch(Exception ex) {}
	}
	
	//3.오라클 해제
	public void disConnection() {
		try {
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}catch(Exception ex) {}
	}
	
	//4.싱글턴 => 한사람당 한개의 DAO만 사용 => 메모리 누수현상 방지
	public static BookDAO newInstance() {
		if(dao==null) {
			dao=new BookDAO();
		}
		return dao; //null이 아니면 기존에 저장된 dao 전송
	}
	
	//기능 설정
	//1.emp, dept 데이터 출력 (웹, 윈도우) => DAO는 변경이 없다 React,Vue,Ajax 가능
	// DAO / VO는 변경X
	// SQL은 검색언어 => SELECT 중요
	
	// 총페이지 구하기
	public int bookTotalPage() {
		int total=0;
		try {
			//1.연결
			getConnection();
			//2.SQL문장
			String sql="SELECT CEIL(COUNT(*)/15.0) FROM wiki";
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
	public ArrayList<BookVO> bookListData(int page){
		ArrayList<BookVO> list=new ArrayList<BookVO>();
		try {
			getConnection();
			String sql="SELECT num, image, bookname, no "
					+"FROM (SELECT num, image, bookname, rownum as no "
					+"FROM (SELECT num, image, bookname "
					+"FROM wiki ORDER BY num ASC)) "
					+"WHERE no BETWEEN ? AND ?";
			int rowSize=15;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps=conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				BookVO vo=new BookVO();
				vo.setNum(rs.getInt(1));
				vo.setImage(rs.getString(2));
				vo.setBookname(rs.getString(3));
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
	public BookVO bookDetailData(int num) {
		BookVO vo=new BookVO();
		try {
			getConnection();
			//조회수 증가
			String sql="UPDATE wiki SET "
					+"hit=hit+1 "
					+"WHERE num=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate(); //commit()포함
			
			//데이터 읽기
			sql="SELECT num, bookname, writer, translator, series, "
					+"pubdate, isbn, price, image "
					+"FROM wiki "
					+"WHERE num=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, num);
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			//값을 VO에 저장
			vo.setNum(rs.getInt(1));
			vo.setBookname(rs.getString(2));
			vo.setWriter(rs.getString(3));
			vo.setTranslator(rs.getString(4));
			vo.setSeries(rs.getString(5));
			vo.setPubdate(rs.getDate(6));
			vo.setIsbn(rs.getLong(7));
			vo.setPrice(rs.getInt(8));
			vo.setImage(rs.getString(9));
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally { 
			disConnection();
		}
		return vo;
	}
	
	public ArrayList<BookVO> bookFindData(String name){
		ArrayList<BookVO> list=new ArrayList<BookVO>();
		try {
			getConnection();
			String sql="SELECT num, image, bookname, writer, price, series "
					+"FROM wiki "
					+"WHERE bookname LIKE '%'||?||'%' "
					+"ORDER BY num ASC";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				BookVO vo=new BookVO();
				vo.setNum(rs.getInt(1));
				vo.setImage(rs.getString(2));
				vo.setBookname(rs.getString(3));
				vo.setWriter(rs.getString(4));
				vo.setPrice(rs.getInt(5));
				vo.setSeries(rs.getString(6));
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
			String sql="SELECT cno, price, account, "
					+"(SELECT goods_poster FROM goods_all WHERE no=cart.gno), "
					+"(SELECT goods_name FROM goods_all WHERE no=cart.gno, "
					+"(SELECT goods_price FROM goods_all WHERE no=cart.gno) "
					+"FROM cart "
					+"WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
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
