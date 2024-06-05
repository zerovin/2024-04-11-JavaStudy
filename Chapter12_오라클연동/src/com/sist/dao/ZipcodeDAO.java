package com.sist.dao;
//오라클 연결 - 사용자 요청에 맞는 데이터를 찾아온다
import java.util.*; //ArrayList
import java.sql.*; //오라클 연결 라이브러리
/*
 *  데이터베이스 연동
 *  jdbc => web dbcp => orm - MyBatis(SQL문장=>반복기능제거) / JPA(SQL없이 접속)
 *   1차         2차           3차(실무에서 많이 사용-압축,코드간결)  개인 
 */
public class ZipcodeDAO {
	//오라클 연결 클래스
	private Connection conn;
	//SQL 전송하는 클래스(결과값 받기)
	private PreparedStatement ps; //SQL전송, 결과값 읽기 => 송수신 클래스
	//오라클 연결에 필요한 URL(오라클 주소), 변경금지 / thin-연결만 하는 드라이버
	/*
	 *  localhost => 본인 컴퓨터, 외부에서는 IP로 접근
	 *  1521 => PORT / 1521(oracle), 1433(MsSQL), 3306(MySQL, MariaDB)
	 *  XE => table이 저장된 데이터 베이스 연습용-XE / 유료-ORCL/ORA
	 */
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	// 1. 드라이버 등록 - 한번만 등록 => 생성자
	public ZipcodeDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //jar파일에 있는 클래스등록
		}catch(Exception ex) {}
	}
	
	// 2. 오라클 연결
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL, "hr", "happy"); //conn hr/happy
		}catch(Exception ex) {}
	}
	
	// 3. 오라클 연결해제
	public void disConnection() {
		try {
			if(ps!=null) {
				ps.close(); //통신중단
			}
			if(conn!=null) { // conn ex)전화 => 통신 끊고 전화 닫아
				conn.close();
			}
		}catch(Exception ex) {}
	}
	
	// 4. 기능설정
	// 우편번호 검색, 검색결과 수
	public ArrayList<ZipcodeVO> postFind(String dong){
		ArrayList<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
		try {
			//오라클 연결 => 값 읽기
			// 1. 오라클 연결
			getConnection();
			
			// 2. SQL문장
			String sql="SELECT zipcode, sido, gugun, dong, NVL(bunji,' ') "
					+"FROM zipcode "
					+"WHERE dong LIKE '%'||?||'%'";
			       // WHERE dong LIKE CONCAT('%',?,'%') => MySQL/MariaDB
			       // NVL = ISNULL => MySQL/MariaDB 
			ps=conn.prepareStatement(sql); //미리 SQL문장을 전송하고 나중에 값(?)을 채워준다
			ps.setString(1, dong); // ?에 값을 채워서 실행
			
			//오라클에 실행요청 => 결과값을 메모리에 저장 => ResultSet
			ResultSet rs=ps.executeQuery();
			//메모리를 실행하다보면 커서의 위치가 가장 마지막에 위치 => 처음부터 읽어올 수 있게 첫줄로 이동 => next()
			while(rs.next()) {
				ZipcodeVO vo=new ZipcodeVO();
				vo.setZipcode(rs.getString(1));
				vo.setSido(rs.getString(2));
				vo.setGugun(rs.getString(3));
				vo.setDong(rs.getString(4));
				vo.setBunji(rs.getString(5));
				list.add(vo);
			}
			rs.close(); //메모리 닫기
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			//닫기
			disConnection();
		}
		return list;
	}
	
}
