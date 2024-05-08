package com.sist.main;
import java.util.Scanner;

import com.sist.manager.*;
import com.sist.vo.*;
/*
 *	◆변수
 *                                     메모리저장시점         사용범위       메모리해제       저장위치
 * ----------------------------------------------------------------------------------------------              
 * 인스턴스변수                            new 클래스명()      클래스 전체     프로그램종료       Heap
 * class A{                          => 메모리 따로 저장    =>다른 클래스
 *   [접근지정어] 데이터형 변수명;
 *   클래스 블록 안에 선언가능
 *   다른 클래스에서 사용가능
 * }
 * class A{
 *   int a;
 *   int b;
 *   double c;
 *   static int d;
 * } 
 * => A = 사용자 정의 데이터형
 * 	  A의 Heap영역 크기 16byte = a-4byte b-4byte c-8byte
 *    d는 static이라 A의 메모리가 아니라 다른 공통공간(Method Area)에 저장
 *    **모든 클래스는 4byte(주소)
 * -------------------------------------------------------------------------------------------
 * 정적변수Static                     컴파일시에 메모리에 저장   자신 클래스전체   프로그램종료    Method Area
 * class A{                        접근방식 : 클래스명.변수명  =>다른클래스
 *   [접근지정어] static 데이터형 변수명;    new없이 사용가능
 *   클래스 블록안에서만 선언가능
 *   다른 클래스에서 사용가능
 * }
 * **모든 클래스가 공유할 수 있다(공개) => 메모리공간 1개만 생성
 * -------------------------------------------------------------------------------------------
 * 지역변수                              메소드 호출시마다   메소드 안에서만 사용   메소드종료       Stack
 * void display(){                      메모리 생성                       return
 *   데이터형 변수명;
 *   메소드 안에서 선언
 *   접근지정어 사용불가, 
 *   static 사용불가
 *   final 사용가능
 *   다른 클래스에서 사용불가 - 접근지정어 불필요
 *   메소드 블록 안에서만 사용가능
 *   자동초기화 불가 - 초기화 해줘야해
 * }
 * 
 * Stack - LIFO (Last In First Out)
 * void display(){ // a->b->c->c->b->a
 *   int a=10;
 *   {
 *     int b=20;
 *     {
 *       int c=30;
 *     }
 *   }
 * }
 * ------------------------------------------------------------------------------------------
 * *** 멤버변수(static, 인스턴스변수(객체변수))
 *     - 자동 초기화
 *     	 int 0
 *       double 0.0
 *       String null => 주소없는 상태
 *                      주소는 new 사용시 생성
 *	자바에서 사용하는 메모리
 *	- Method Area -메소드, static 변수
 *	- Stack - 지역변수, 매개변수(메소드 안에서 사용가능) => 메모리 자체관리 => 메소드가 종료되면 자동으로 사라짐
 *	- Heap - 배열, 클래스 멤버변수 => 프로그래머가 관리(과거)
 *	         메모리할당 - int malloc(sizeof(A)) => new 
 *	         메모리해제 - free(A) => delete
 *	         ==> 프로그래머가 삭제에 소홀 - 프로그램 종료시 자동으로 운영체제에서 삭제
 *	             변수가 많아지면서 문제발생 => 가비지컬렉션(자동메모리회수) 
 *	                                    - 프로그램 종료쯤 느리게 회수
 *                                      - 멀티미디어 사용시 직접회수 System.gc() 가비지컬렉션 호출
 *     
 *	*변수
 *	 - 저장하는 데이터가 여러개 => 따로 메모리 만들어서 저장 ==> 인스턴스
 *	 - 저장하는 데이터가 1개 => static
 *	 - 사용 후 필요없음 => 지역변수
 * 
 * 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("페이지 입력 >> ");
		int page=scan.nextInt();
		Movie[] m=MovieManager.getMovieData(page);
		
		//1.목록
		System.out.println("============ 영화 목록 =============");
		//컴파일시 메모리 저장 => Method Area 메모리에 저장이 된 상태
		//static 이용시 메모리 공간 1개 생성 => 모든 클래스에 공유 가능
		//변경시 모든 클래스에서 변경된 데이터 사용
		for(Movie movie:m) { //movies(public, static) 접근가능, 클래스명.변수명으로 불러오기가능
			System.out.println(movie.getMno()+"."+movie.getTitle());
			//값 출력, 읽어올 경우 getXxx()
			//갑 저장, 값 변경 setXxx()
		}
	}

}
