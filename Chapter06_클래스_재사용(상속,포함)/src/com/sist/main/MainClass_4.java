package com.sist.main;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

/*
 * 상속 - 재사용, 단일상속
 * 예외조건 - 생성자, 초기화 블록, static(공동사용)
 * 
 * 메모리 저장
 *            ---super---
 *              변수/메소드
 *            -----------
 *            ---this----
 *              변수/메소드
 *            -----------
 * class A{
 *   int a,b,c,d,e,f;
 * }
 * class B extends A{
 * 	// int a,b,c,d,e,f; 
 *   int k; => 소스가 간결해진다
 *   => 기능 변경 => 메소드(오버라이딩)
 * }
 * ===> 실행 속도가 느려진다
 * ===> 소스를 볼 수 없기 때문에 가독성이 떨어진다
 * ===> 제약조건이 많다
 * ===> 결합성이 높아진다 
 * -----------------------가급적 상속 사용X (Spring)
 * ===> 상속보다 포함하는 클래스를 더 많이 사용         
 * 
 */

/*
 *	상속을 내리는 클래스 - super 클래스, base클래스, 부모클래스, 상위클래스
 *	상속 받는 클래스 - sub 클래스, 파생클래스, 자식클래스, 하위클래스
 *
 *	class 게시판{
 *	   글쓰기();
 *	   상세보기();
 *	   검색();
 *	   수정();
 *	   추가();
 *	   삭제();
 *	}
 *
 *	class 묻고답하기{          ===>       class 묻고답하기 extends 게시판{
 *	   묻기(); => 글쓰기 변경 => 오버라이딩       답하기();
 *	   상세보기();                        }
 *	   검색();
 *	   수정();
 *	   추가();
 *	   삭제();
 *	   답하기();
 *	}
 *
 *	class 댓글게시판{   ===>   class 댓글게시판 extends 게시판{
 *	   글쓰기();                 댓글();
 *	   상세보기();             }
 *	   검색();
 *	   수정();
 *	   추가();
 *	   삭제();
 *	   댓글();
 *	}
 *
 *	class 갤러리게시판{   ===>   class 갤러리게시판 extends 게시판{
 *	   글쓰기();                  파일업로드();
 *	   상세보기();              }
 *	   검색();
 *	   수정();
 *	   추가();
 *	   삭제();
 *	   파일업로드(); => 이미지
 *	}
 *
 */
import javax.swing.*;
class Super{
	int a;
	int b;
	//c는 사용불가 상속내린 클래스는 받은 클래스의 것을 사용할 수 없다
}
class Sub extends Super{
	// a,b
	int c;
}
public class MainClass_4 /*extends JFrame*/{ //상속클래스 is-a 자바는 단일상속만 가능
	JFrame f=new JFrame(); //포함클래스 has-a 여러개 사용가능
	public MainClass_4() {
		f.setSize(500, 500);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainClass_4();
		
		Super su=new Super();
		System.out.println(su.a);
		System.out.println(su.b);
		
		Sub sub=new Sub();
		System.out.println(sub.a); //상속받으면 super의 a,b도 사용가능
		System.out.println(sub.b);
		System.out.println(sub.c);
		
		Super su1=new Sub(); //상위->하위 가능 단, 사용할 수 있는 변수는 왼쪽 Super 클래스만큼만 ex) a,b
		System.out.println(su1.a);
		System.out.println(su1.b);
		//Sub sub1=new Super(); 는 하위클래스가 상위클래스보다 작아서 불가능, 왼쪽 데이터형이 커야해
		
		Super sub0=new Sub();
		Sub sub1=(Sub)sub0; //new로 받은 뒤에 형변환은 가능 
		System.out.println(sub1.a);
	}

}
