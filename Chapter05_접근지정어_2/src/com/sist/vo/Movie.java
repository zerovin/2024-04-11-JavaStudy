package com.sist.vo;

import lombok.Data;

@Data
public class Movie {
	private int rank;
	private String title;
	private String actor;
	private String director;
	private String grade;
	private String genre;
	private String regdate;
	public Movie() {
		
	}
	//private => Movie 클래스 블록에서만 사용가능
	/*
	 *	실제 더이터값은 은닉화
	 *	읽기/변경 => 메소드를 이용해서 접근이 가능하게 만든다 : 캡슐화
	 *	변수에 대한 기능 부여 - 읽기 getXxx() / 쓰기 setXxx()
	 *
	 *  ==> 변수는 감추고 메소드 getter, setter로 접근 == 캡슐화
	 */
}
