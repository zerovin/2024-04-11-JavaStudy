package com.sist.vo;

import lombok.Data;

//데이터형 선언 => 1개에 대한 정보 저장
/*
 *	1|
 *	쇼생크 탈출|
 *	드라마|
 *	https://movie-phinf.pstatic.net/20160119_278/14531650465287bcuk_JPEG/movie_image.jpg?type=m77_110_2|
 *	팀 로빈스(앤디 듀프레인), 모건 프리먼(엘리스 보이드 레드 레딩)|
 *	2016 .02.24 재개봉, 1995 .01.28 개봉|
 *	15세 관람가|
 *	프랭크 다라본트 
 */
@Data
//lombok => getter/setter 생성
public class Movie {
	private String rank;
	private String title;
	private String genre;
	private String poster;
	private String actor;
	private String regdate;
	private String grade;
	private String director;
	//private은 해당 클래스 영역(Movie)에서만 사용가능, 다른 클래스에서 연결불가 => 데이터 손실방지
	//각 변수에 기능부여 => 다른 클래스에서 사용가능하게 만듦 => 캡슐화
	//읽기-getter 쓰기-setter => lombok @Data
	
	//public Movie(){} 매개변수없는 디폴트생성자 자동생성
	
}
