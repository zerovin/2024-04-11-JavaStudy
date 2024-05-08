package com.sist.controller;
/*
 *	패키지 - 관련된 클래스를 모아서 검색이 쉽게
 *	       import 사용해서 불러오기
 *	       패키지가 있어야 분업가능 => 다른 패키지영향X => 패키지별로 동시작업가능
 *	패키지명 - com(org).회사명.클래스기능     
 *	         키워드 사용금지
 *	         소문자로 사용
 *	         숫자 맨 앞 사용금지
 *	         공백 사용금지
 *	         특수문자 _, $사용가능 (보통 특수문자 사용안함)
 *	         다른 이름의 패키지 안에 같은 이름의 클래스 가능 => 폴더단위이기 때문
 *	         기능별 분리 controller-제어(연결) / dao-데이터관리 / manager-외부데이터읽기(파일,크롤링) / vo-사용자정의데이터형
 *	                  ex) 네트워크 - server/client/commons
 *	                      웹 - user/admin
 *	패키지==폴더 - 관련된 클래스를 모아서 관리하기 쉽게 만듦
 *	            ex)자바자료, 오라클자료, 웹자료
 *	            private - 멤버변수에 사용, 손실변경을 방지 => 다른 클래스에서 사용불가 => 메소드로 기능설정
 *	                                                 읽기 get변수명() / 저장 set변수명()
 *	                      개인정보 등 중요한 변수는 private으로 설정
 *	            public - 클래스, 메소드, 생성자에 사용
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
