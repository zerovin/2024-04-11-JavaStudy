package com.sist.main;
/*
 *  1.반복문장 => 제거 ==> 메소드
 *    재사용, 다른 클래스 연결 => 한가지 기능만 수행(구조적인 프로그램) ==> 메소드
 *    => 수정, 에러잡기가 쉬움
 *  2.관련된 클래스 여러개 => 한개의 객체명으로 처리 ==> 인터페이스
 *  3.비정상 종료없이 프로그램 유지 ==> 예외처리
 *  
 *  변수잡는 연습 => 사이트
 *  프로그램 == 누가누가 더 잘 묶어서 사용하는가 => 재사용 
 *    변수 => 배열 / 클래스 
 *    명령문(연산자,제어문) => 메소드
 *    필요시 변수 초기화 => 생성자
 *    클래스 여러개 => 인터페이스
 *    에러 처리 => 예외처리
 *  상속 => 윈도우에서 주로 사용
 *         오버라이딩(인터페이스)
 *  ----------------------------- ~8장 자바 기본문법
 *  + 라이브러리, 사용자클래스
 *  ----------------------------- 조립, 응용
 *  
 *  모바일, 웹, 앱 모두 동일한 출력 => JSON JavaScript Object Nontation 자바스크립트 객체 표현법
 *  
 *  반드시 예외처리 해야하는 부분
 *    1.파일 입출력 
 *    2.네트워크
 *    3.오라클 연동 - 데이터를 모아두는 장소 (영구적 저장장치)
 *                 파일 - 여러개 연결 불가
 *                 오라클 - 여러개 연결 가능 => RDBMS
 *   
 *  생략가능 부분
 *    - import java.lang.*;
 *    - void => return 자동추가
 *    - 생성자 생략 => 없을시 디폴트생성자 자동추가
 *    - extends Object
 *    - 실행시 파일 RuntimeException => 예외처리 생략가능
 *    - interface 상수 => (public static final) 상수명 = 값;
 *                추상메소드 => (public abstract) void 메소드명();
 *                구현메소드 => (public) default void 메소드명(){}
 *        interface A{
 *           (public static final) int a=10;
 *           (public abstract) void disp();
 *           (public) default void aaa(){}
 *        }
 *        => interface는 접근지정어 public만 사용가능
 *         
 */
interface ABC{
	int AA=100; //only public static final
	//(public static final) int AA=100;
}
public class 예외처리_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
