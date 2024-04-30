/*
 *	메소드 - 기능
 *	     - 클래스 안에 존재 => 독립적으로 사용불가 => 메소드
 *	       C/C++/Python => 단독 사용가능 => 함수
 * 	     - 사용자로부터 입력값(요청)을 받아서 처리한 결과를 반환
 * 	                ---------매개변수  --------리턴형
 * 	     - 기능 처리 => 웹(메뉴, 동작)-키보드입력,버튼클릭 => 메소드
 * 	     - 변수 / 연산자+제어문=메소드
 *   1. 형식
 *      리턴형 메소드명(매개변수...){ =>선언부
 *          //구현부
 *          ...
 *          ...
 *          return 값(변수,배열명,클래스 객체)
 *          // return 생략가능 => 결과값없이 메소드 자체에서 처리 => void
 *      }
 *      => 리턴형 == 사용자 요청에 대한 처리결과값 - 기본형(byte,int,char,long,double)
 *                                         결과값이 많은 경우 (배열,클래스,컬렉션-웹) ex)목록
 *                                         => 1개만 설정가능-배열,클래스도 하나의 메모리 주소만 보냄
 *                                            파이썬은 여러개 가능 def func: ... return a,b,c / a,b,c=func()
 *      => 매개변수 == 사용자 요청값 - 기본형, 배열, 클래스
 *                               여러개 받는 경우도 있음. 3개이상일시 배열, 클래스로 받음
 *                               ex) 로그인-id,pw / 검색-검색어 / 회원가입-id,pw,name,sex,birth,email
 *                                   => 배열, 클래스
 *      => 메소드명 == 변수 식별자와 동일
 *      => 구현 == {변수/연산자/제어문=>결과값얻기}
 *   2. 유형
 *      ---------------
 *        리턴형  매개변수
 *      ---------------
 *          O     O      => ex) String
 *                              String substring(int, int)
 *      ---------------
 *          O     X      => ex) Math
 *                              double randoㅡ()
 *      ---------------
 *          X     O      => 자체처리 - 출력 = void
 *                          ex) System
 *                              void print(String s)
 *      ---------------
 *          X     X      => 자체처리 - 출력 = void
 *                          ex) System
 *                              System.out.println() => 줄바꿈
 *      ---------------
 *   3. 활용 = 메소드 호출
 *      1) 리턴형이 있는 경우
 *         데이터형 변수=메소드명()
 *         => 변수처리
 *      2) 리턴형이 없는 경우
 *         메소드명()
 *      3) 매개변수가 있는 경우
 *         메소드명(값, 값)
 *      4) 매개변수가 없는 경우
 *         메소드명()
 *   4. 주의점
 *      메소드가 호출될 때 메소드의 처음부터 명령문을 수행
 *      매개변수는 설정된 순서대로 대입 ex) (int,char,double)=>(10,'A',10.0)
 *      메소드에 선언된 변수/매개변수 => stack공간에 저장 => 메모리 자체에서 처리
 *                            => 메소드 종료시 자동삭제 == 지역변수(메소드 안에서 사용되는 변수)
 *                            => 지역변수는 반드시 초기화해서 사용    
 *  
 */
import java.util.Scanner;
public class 메소드_1 {
	static int input() {
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력 >> ");
		return scan.nextInt();
	}
	static int rand() {
		return (int)(Math.random()*100)+1;
	}
	static char alpha() {
		return (char)((Math.random()*26)+65);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int num=scan.nextInt()..
		int num=input();
		System.out.println("num="+num);
		
		//int num2=(int)(Math.random()*100)+1;
		int num2=rand();
		System.out.println("num2="+num2);
		
		//char c=(char)((Math.random()*26)+65);
		char c=alpha();
		System.out.println("c="+c);
		
		for(int i=0;i<10;i++) { // alpha() 재사용
			char cc=alpha(); // char cc=(char)((Math.random()*26)+65);
			System.out.print(cc+" ");
		}
	}

}
