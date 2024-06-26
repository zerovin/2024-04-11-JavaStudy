package com.sist.main;
import java.sql.*;
/*
 *  INSERT / UPDATE / DELETE 가 여러개 동시 수행 될 때
 *  => 일괄처리 - 하나라도 오류나면 전체 취소 (트랜잭션) 
 */
public class MainClass_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url, "hr", "happy");
			conn.setAutoCommit(false); //트랜잭션 이용시 자동커밋해제
			// SQL
			String sql="INSERT INTO card VALUES(3, 'park', 20000)";
			ps=conn.prepareStatement(sql);
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			
			sql="INSERT INTO point VALUES(3, 4, 200)";
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			conn.commit();
		}catch(Exception ex) {
			try {
				conn.rollback();
			}catch(Exception e) {}
		}finally {
			try {
				conn.setAutoCommit(true); //트랜잭션처리 후 오토커밋 활성화
				if(ps!=null) {
					ps.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception ex) {}
		}
	}

}
