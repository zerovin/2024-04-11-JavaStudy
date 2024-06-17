package com.sist.dao;
import java.util.*;
import java.sql.*;
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
	public ArrayList<BookVO> bookListData(){
		ArrayList<BookVO> list=new ArrayList<BookVO>();
		try {
			getConnection();
			String sql="SELECT num, bookname, writer, translator, price, pubdate, series FROM wiki";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				BookVO vo=new BookVO();
				vo.setNum(rs.getInt(1));
				vo.setBookname(rs.getString(2));
				vo.setWriter(rs.getString(3));
				vo.setTranslator(rs.getString(4));
				vo.setPrice(rs.getInt(5));
				vo.setPubldate(rs.getDate(6));
				vo.setSeries(rs.getNString(7));
				
				list.add(vo);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
}
