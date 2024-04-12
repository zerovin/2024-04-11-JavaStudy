/*
 *	2page
 *	  자바언어의 특징
 *		1) 프로그램 언어 실행하는 방식
 *			= 컴파일 방식 => 컴퓨터가 인식하는 언어로 변경 (2진파일 = 0,1)
 *			  class MainClass{
 *			  	public static void main(String[] args){
 *				}
 *  	 	  }	
 *  
 *  		  010010010
 *  		  001011001
 *  		  000110111
 *  
 *  		  'A' => 65 ===(컴파일)===> 1000001
 *  		  = 프로그램 언어 => 컴파일방식 이용 ex)C/C++,C#,Java
 *  			Java(one Write - 한번 작성한 코드로 모든 운영체제에 같은 실행결과 = 호환성이 좋다)
 *  
 *  		= 인터프리터 방식 : 한줄씩 번역해서 처리 ex)HTML, CSS
 *			
 *			= 컴파일+인터프리터 동시사용 => 보안(소스검증) = 동시사용하는 언어는 자바가 유일  
 *			  제임스 고슬링 "자바언어는 절대 보안에 노출되지 않는다" -> 바로 뚫림, 자바 보안이 뛰어나지는 않음
 *			  |
 *			자바소스 .java
 *			  |
 *			JVM .class 번역
 *		|	 |	   |	|	  |
 *	  리눅스 유닉스 솔라리스 Mac Windows => 동일한 실행 결과
 *
 *			java ==> class
 *
 *		2)실행 과정
 *		  A.java 파일 만들기
 *			| javac
 *		  A.class 생성
 *			| java
 *		  실행결과
 *
 *	6page 개발환경 구축
 *	  1) JDK => 17버전 => jdk17.0.2 => jdk.java.net/17
 *		* 높은 버전에서는 실행 가능, 낮은 버전에서는 실행 불가
 *		* 실무 : jdk1.8 (SUN의 마지막 버전) => 호환성이 좋다
 *		* Spring-Boot : 17이상
 *		  SpringFramework : 14이하 
 *		* 오픈소스 이용 => 호환성 문제 => 단점
 *	  2) 환경설정
 *		 => classpath : 라이브러리 읽기 => .;c:\jdk-17.0.2\lib
 *		 => path : 실행파일 등록 => c:\jdk-17.0.2\bin
 *	  3) 11page => 편집기
 *				   eclipse => eclipse.org 최신버전 다운로드
 *				   └ Back-End용
 *				   인텔리J
 *				   └ FullStack용 프론트-백 협업가능 => 최근에 무료에서 트라이얼버전으로 변경
 *		-1 프로젝트 폴더만들기
 *		-2 src에 자바 클래스 생성
 *		  *주의점 1.파일명과 클래스명이 동일
 *			    2.대소문자 구분
 *			    3.명령문(CPU) 끝나면 반드시 ;
 *			    4.클래스 영문외에 한글사용 가능 => 리눅스가 아닌 다른 운영체제에서 한글인식 불안정(영문권장)
 *		  *약속사항 1.클래스명 : 대문자로 시작 ex) MainClass
 *				  2.변수 : 소문자 시작 ex) id, password
 *				  3.상수 : 모든 단어를 대문자로 ex) ID, PASSWORD
 *				  4.메소드 : 소문자로 시작
 *		-3 모든 자바파일 실행시에는 반드시 main() - 실행 시작점/종료점
 *		-4 주석 : ctrl + shift + /
 *		   주석해제 : ctrl + shift + \
 *	자바의 구성요소
 *	  class className{   //클래스 시작
 *	  	public static void main(String[] args) {  //프로그램 시작점
 *
 *		}
 *	  }
 *	
 *				-------- class ---------
 *
 *				------------------------
 *					   => 변수
 *				------------------------
 *					  => 생성자
 *				------------------------
 *					  => 메소드
 *				------------------------
 *
 *				------------------------
 *
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println('A');
		System.out.println((int)'A');
		System.out.println(Integer.toBinaryString(65));
		System.out.println((int)'홍');
		System.out.println(Integer.toBinaryString(54861));
	}

}
