package com.sist.main;
//Movie 클래스 불러오기
import com.sist.vo.Movie;
import java.util.*;
import java.sql.*;
//클래스가 다른 폴더(패키지)에 저장된 경우 반드시 import 이용해서 불러오기
/*
 *	private / public
 *	변수 - private => 데이터공개X
 *	      접근 가능하게 get변수명(), set변수명()
 *	메소드/클래스/생성자 - public => 다른 클래스에서 연결 필요
 *
 * 	127page
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//메모리에 저장
		//com.sist.vo.Movie movie=new com.sist.vo.Movie(); import 안붙이면 이렇게 사용은 가능
		java.util.Date date=new java.util.Date(); // 패키지 여러개가 들어갈 경우 같은 파일이름이 있을 수 있음 클래스 충돌 => 오류
		// 어떤 폴더의 동명파일을 쓸건지 선택하면 오류해결 => 같은 파일명쓰고 해당 파일 import
		Movie movie=new Movie();
		//데이터 초기화
		movie.setRank(1);
		System.out.println("순위:"+movie.getRank());
	}

}
