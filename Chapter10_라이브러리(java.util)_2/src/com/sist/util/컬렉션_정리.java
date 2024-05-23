package com.sist.util;
/*
 *  컬렉션 - 데이터관리 배열 대체
 *          => 배열 - 먼저 메모리 크기를 만들어서 관리
 *                   추가 삭제가 어렵다 => 추가, 삭제시 새로운 배열 생성 copyOf
 *  - 종류
 *    1) 데이터 중복 가능여부
 *       데이터 중복 허용 : List => ArrayList
 *                      Map => HashMap
 *       데이트 중복 불가 : Set
 *    2) 인덱스 이용여부 
 *       인덱스 이용 : ArrayList 
 *       실제 값 사용 : HashSet
 *       key 사용 : HashMap => key는 중복불가
 *    ** 데이터 관리 - 구분자 반드시 필요
 *    
 *  - List - 단방향 포인트
 *           수정, 삭제가 없는 프로그램 제작시 사용 ex) 데이터베이스
 *           데이터를 모아서 브라우저에 전송 목적
 *           조회가 간편, 검색이 빠르다, 맨 뒤에 데이터 추가시 속도 빠름
 *           웹의 50% ArrayList
 *  - Map - 관리 ex) 쿠키, 세션, 클래스 관리(스프링)
 *  - Set - 중복제거 => DISTINCT 오라클 중복제거기능이 있어 자주 사용하지는 않음
 *           ex) 코딩테스트, 웹소켓에서 자주 사용
 */
public class 컬렉션_정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
