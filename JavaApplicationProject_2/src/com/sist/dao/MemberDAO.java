package com.sist.dao;
import java.util.*;
import java.sql.*;
public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static MemberDAO dao; //싱글턴
	
	//1.드라이버 등록
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	
	//2.오라클 연결
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy"); //conn hr/happy
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
	public static MemberDAO newInstance() {
		if(dao==null) {
			dao=new MemberDAO();
		}
		return dao; //null이 아니면 기존에 저장된 dao 전송
	}
	//----------------------------------- 모든 DAO에 공통사항
	
	//기능
	//1.로그인처리
	/*
	 *  리턴형 => 경우의 수
	 *  - 사번이 없는 경우 => NOSABUN / 0
	 *  - 사번은 있으나 이름이 틀린 경우 => NONAME / 1
	 *  - 사번은 존재, 이름도 동일 => OK 2
	 *  => String / int
	 */
	public String memberLogin(String id, String pwd) {
		String result="";
		try {
			//1.연결
			getConnection();
			
			//2.SQL 문장
			String sql="SELECT COUNT(*) FROM member " //사번이 존재하는지 확인 COUNT 0 or 1
					+"WHERE id=?";  //'"+id+"'";
			
			//3.오라클로 SQL문장 전송
			ps=conn.prepareStatement(sql);
			
			//?에 값 채우기
			ps.setString(1, id);
			
			//4.결과값을 받는다
			ResultSet rs=ps.executeQuery();
			rs.next(); //값이 0아니면 1이라 커서 한번만 옮기면됨 while문 돌릴 필요X
			int count=rs.getInt(1); // 0 or 1
			rs.close();
			if(count==0) { //ID가 없는 경우
				result="NOID";
			}else { //ID가 있는 경우
				sql="SELECT pwd FROM member "
						+"WHERE id=?";
				
				//오라클로 전송
				ps=conn.prepareStatement(sql);
				
				//? 값 채우기
				ps.setString(1, id);
				
				//결과값 받기
				rs=ps.executeQuery();
				rs.next();
				String db_pwd=rs.getString(1);
				rs.close();
				
				if(db_pwd.equals(pwd)) { //로그인
					result="OK";
				}else { //이름 불일치
					result="NOPWD";
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace(); //오류확인 => null / sql문장
		}finally {
			//오라클 해제
			disConnection();
		}
		return result;
	}
	//2.회원가입 - 아이디중복체크, 우편번호검색
	//3.회원수정
	//4.회원탈퇴
	//SQL문장 제작할 줄 알아야 웹도 가능 DAO는 변경X
}
