package com.sist.dao;
import java.util.*;
import javax.swing.text.SimpleAttributeSet;
import java.sql.*;
import java.text.SimpleDateFormat;
public class WikiDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@192.168.10.124:1521:XE";
	private static WikiDAO dao; //싱글턴
	
	//1.드라이버 등록
	public WikiDAO() {
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
	public static WikiDAO newInstance() {
		if(dao==null) {
			dao=new WikiDAO();
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
			String sql="SELECT CEIL(COUNT(*)/12.0) FROM wiki";
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
	public ArrayList<WikiVO> bookListData(int page){
		ArrayList<WikiVO> list=new ArrayList<WikiVO>();
		try {
			getConnection();
			String sql="SELECT num, image, bookname, no "
					+"FROM (SELECT num, image, bookname, rownum as no "
					+"FROM (SELECT num, image, bookname "
					+"FROM wiki ORDER BY num ASC)) "
					+"WHERE no BETWEEN ? AND ?";
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps=conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				WikiVO vo=new WikiVO();
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
	public WikiVO bookDetailData(int num) {
		WikiVO vo=new WikiVO();
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
			sql="SELECT num, isbn, bookname, writer, translator, page, price, pubdate, series, image "
					+"FROM wiki "
					+"WHERE num=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, num);
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			//값을 VO에 저장
			vo.setNum(rs.getInt(1));
			vo.setIsbn(rs.getLong(2));
			vo.setBookname(rs.getString(3));
			vo.setWriter(rs.getString(4));
			vo.setTranslator(rs.getString(5));
			vo.setPage(rs.getInt(6));
			vo.setPrice(rs.getInt(7));
			vo.setPubdate(rs.getDate(8));
			vo.setSeries(rs.getString(9));
			vo.setImage(rs.getString(10));

			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally { 
			disConnection();
		}
		return vo;
	}
	
	public ArrayList<WikiVO> bookFindData(String name){
		ArrayList<WikiVO> list=new ArrayList<WikiVO>();
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
				WikiVO vo=new WikiVO();
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
}
