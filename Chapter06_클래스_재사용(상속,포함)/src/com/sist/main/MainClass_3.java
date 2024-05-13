package com.sist.main;
/*
 *	상속
 *	1.단일 상속만 가능
 *	2.extends - 확장된 클래스 => 사용
 *	3.이미 제작된 클래스 이용 => 신뢰성이 좋음
 *	4.소스를 줄일 수 있다 => 가독성은 떨어짐 
 *
 *	class A{
 *	   int a;
 *	   int b;
 *	   int c;
 *	   public void display(){}
 *	}
 *	-----------
 *	class B extends A{
 *	    //아무것도 없는 것처럼 보이지만 ==> 가독성 떨어짐
 *	    //class A의 a,b,c,display() 있음
 *	    public void bbb(){}
 *	}
 *
 *	B bb=new B();
 *	---bb---
 *	  0x100
 *	--------   0x100-------------------
 *	              --------super--------
 *	                    ---a---
 *	                    ---b---
 *	                    ---c---
 *	                 ---display()---
 *	              --------this--------
 *	                  ---bbb()---
 *	           ------------------------
 *	bb라는 객체를 통해서 접근가능
 *	상속불가 - 생성자
 *	         초기화블록
 *	         private - 상속은 가능, 접근은 불가 => protected
 *	         static - 상속 불가 => 공통으로 사용가능하게 만듦
 *	         ex) class Super
 *	             class Sub extends Super
 *	             Super
 *	               ↑
 *	              Sub => 클래스의 크기비교는 반드시 상속 / 포함
 *	             class A{int a,b,c,d,e;}
 *	             class B{int k;}
 *	             ------------------A>B(X) 크기를 잴 수 없다
 *	                                      클래스의 크기는 상속/포함 관계로 확인
 *	             class A{int a; int b;}
 *	             class B entends A{//int a; //int b; int c;}
 *	             ------------------A>B(O) 상속은 내리는 클래스가 더 크다 => is-a
 *	         ex) 동물 - 포유류 - 인간 - 남자  ==> 동물/포유류/인간 => 범위기준 => 상속을 내리는 클래스가 크다 == 데이터형이 커짐
 *	                              - 여자  ==> 여자/남자 => 크기를 잴 수 없다
 *	                        - 말
 *	                        - 돼지
 *	                        - 소
 *	                 - 양서류
 *	                 - 조류
 *	             ←-------------이다 is-a
 *                인간=남자 / 인간=여자
 *                남자=(남자)인간 / 여자=(여자)인간
 *                -----------------------------클래스에도 크기가 있다 => 형변환
 *         **자바는 모든 클래스(사용자 정의, 라이브러리)의 상속을 내리는 클래스가 있다 == 최상위클래스 - Object
 *           Object가 가지고 있는 모든 기능 사용가능
 *           Object는 모든 데이터형의 상위 클래스 - 기본형, 모든 클래스를 받을 수 있다, 배역
 *           ex) Object o=10;
 *               o=10.5l;
 *               o="aaa";
 *               o='A'
 *               o=new A();
 *               -------------배열 => 데이터형 여러개 첨부
 *               Objec[] obj={"",10.7,10,'A',new A()}; => 다른 데이터형을 모아서 관리
 *
 */
import javax.swing.*;
public class MainClass_3 extends Object/*생략 됨*/ /*extends JFrame*/{ //JFrame이 가진 모든 메소드 사용가능
	/*
	 *	생략 가능 코드
	 *	1.import java.lang.*; => String, Math, StringBuffer => 자주 사용하기 때문에 생략가능
	 *	2.extends Object => 모든 클래스는 Object로부터 상속받는다 => 생략
	 *	3.생성자 => 없을 경우 컴파일러가 자동 생성 => 필요없는 경우 생략가능
	 *	4.void 메소드에서 return => 컴파일러가 return; 자동추가 => 생략가능
	 *	5.모든 클래스 예외처리 - 컴파일시 => 반드시 예외처리
	 *	                   실행시 => 예외처리 생략가능 - 사용자 입력값을 받은 후 처리(조건문)
	 */
	
	/*
	public MainClass_3() {
		//this. => JFrame이 가진 메소드 우르르르
	}
	*/
	
	public MainClass_3(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
