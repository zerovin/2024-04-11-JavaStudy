/*
 *	알파벳 입력을 받아
 *	=> 대문자 -> 소문자로 출력
 *	=> 소문자 -> 대문자로 출력 
 *
 *	결과값 출력 위치
 *	- for에서 출력 => for문 안에 변수 설정
 *	- for종료 후 출력 => for 밖에 변수 설정 
 *	
 *	변수 유지하는 범위 {}, 블록변수, 지역변수 => 반드시 사용전에 초기화
 *	멤버변수, 공유변수 => 초기화가 되어 있음
 *	ex)
 *		class A{
 *			int a; //멤버변수
 *			static int b; //공유변수
 *			
 *			public static void main(String[] args){
 *				int c=10; //지역변수
 *			}
 *		}
 *
 *	1-4장 - 자바의 기본문법
 *	5-7장 - 객체지향프로그램
 *	8장 - 예외처리 => 프로그램을 종료하지 않게 만든다
 *	=======> 자바 기초
 *	9장-마지막 - 라이브러리(조립식) => 암기
 *	제일 마지막 - 오라클연동 JDBC(Java Data Base Connected) (웹 85%)
 *				웹 개발자 : Java, 데이터베이스, Spring - BackEnd
 *						 JavaScript => VueJS, ReactJS - FrontEnd
 *
 */
import java.util.Scanner;
public class 자바제어문_반복문_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		char c=' ';
		for(int i=0;i<5;i++) {
			System.out.print("알파벳 입력 >> ");
			c=scan.next().charAt(0); //횟수만큼의 메모리 할당
			//for문 한바퀴때마다 사라지고 다시 생성
			System.out.println("입력된 알파벳:"+c);
			if(c>='A' && c<='Z') {
				System.out.println("소문자로 변경:"+(char)(c+32)); //대소문자 차이 32 A=65 a=97
			}else if(c>='a' && c<='z') {
				System.out.println("대문자로 변경:"+(char)(c-32)); //(char)형변환 안하면 숫자로 출력
			}else {
				System.out.println("알파벳이 아닙니다");
			}
		}
		//c변수 사용가능, for문 안에서 변수선언시 밖에서 사용불가
		
	}

}
