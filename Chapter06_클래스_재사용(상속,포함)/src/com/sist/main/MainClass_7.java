package com.sist.main;
/*
 * 	5장 객체지향 프로그램** - 변수설정
 *                      저장할 내용 여러개 => new 인스턴스 변수
 *                      한개 저장 => static
 *                      메소드(연산자/제어문) 형식 => 처리과정
 *                      초기화 - 생성자, static{}
 *	194page
 *
 * 	상속 - 재사용
 *        변경 = 오버라이딩
 *        상속시 호출되는 과정
 *        메모리 할당(상위, 하위)
 *        형변환
 *        
 *	7장 - 추상클래스 / 인터페이스**(다중상속)
 *	8장 - 예외처리**
 *	9장 - 라이브러리 => 조립(암기)
 *
 *	오라클 JSP Spring Spring-Boot MyBatis JPA => 자바기반
 *
 * 	상속 - 멤버변수, 메소드
 * 	      메소드 변경, 추가 가능
 * 	      확장된 클래스 extends
 * 	      형식) class A extends B => 단일 상속(하나만 상속받을 수 있음), 재사용목적
 * 	      ex)    ---> 구체화
 * 	          동물 - 인간 - 남/여
 * 	            <--- ~이다 (남/여는 인간이다, 인간은 동물이다) 
 * 	                 is-a => 추상화 => 공통점을 모아준다
 *        상속을 내리는 클래스는 클래스마다 공통점을 가지고 있다 => 확장
 *        단일 상속 - 201page 
 *                 하나의 클래스만 상속 받음(클래스) - 변경(오버라이딩) - 변수 오버라이딩
 *                                                           메소드 오버라이딩 
 *                                             추가(오버로딩)
 *        다중 상속 - 두개 이상의 클래스를 상속 받음(인터페이스)
 *        
 *                  추가(오버로딩)     변경(오버라이딩)-덮어쓰기
 *        상태    같은 클래스내에서만 가능   상속이 된 상태 가능 => 익명의 클래스 => 상속없이 오버라이딩 가능
 *        메소드명        동일             동일
 *        매개변수   개수/데이터형 다름   개수/데이터형 동일
 *        리턴형        관계없음           동일
 *        접근지정어     관계없음        축소불가, 확대가능
 *        
 *                    <-----------축소------------
 *        접근지정어 private < default < protected < public
 *                    ------------확대------------>
 *        ex) class A{
 *               void display(){}
 *            }
 *            => void display(){}
 *               protected void display(){}
 *               public void display(){}
 *               잘 모르는 경우 => public
 * 
 */
import java.util.*;
//변수 오버라이딩
//Parent => 메모리할당 ===> Child가 메모리 할당
class Parent{
	String name;
	int age;
	//메모리에 저장 => 상속받은 클래스에서 사용가능
	
	public Parent() {
		name="홍길동";
		age=25;
		System.out.println("Parent 클래스 메모리 할당");
	}
}
class Child extends Parent{
	String name; //변수를 따로 설정해야 상위클래스와 다르게 변수지정 가능 => 변수 오버라이딩
	int age;
	public Child() {
		this.name="박문수"; //자신 => this => 지역변수와 구분
		this.age=30;
		super.name="심청이"; //상위클래스 => super
		super.age=15;
		System.out.println("Child 클래스 메모리 할당");
	}
}
/*
 *	Child c=new Child(); //확장된 클래스 => 기본
 *	Parent p=new Child(); => 클래스 여러개를 한개의 이르으로 제어 
 *
 *	----c-----
 *	   0x100 
 *	----------  ---------------------
 *	                ----super--- => 상속받은 데이터, 메소드
 *                      name     => c.name
 *                  ------------ 
 *                       age     => c.age
 *                  ------------
 *                  ----this---- => 추가된 내용 (데이터, 메소드)
 *                    name, age
 *                  ------------
 */
class KKK{
	public void display() {
		System.out.println("KKK:display() Call...");
	}
}

class AAA extends KKK{
	public void display() {
		System.out.println("AAA:display() Call...");
	}
}
class BBB extends KKK{
	public void display() {
		System.out.println("BBB:display() Call...");
	}
}
class CCC extends KKK{
	public void display() {
		System.out.println("CCC:display() Call...");
	}
}
class DDD extends KKK{
	public void display() {
		System.out.println("DDD:display() Call...");
	}
}
class EEE extends KKK{
	public void display() {
		System.out.println("EEE:display() Call...");
	}
}
/*
 *	프로그램은 여러개를 가지고 제어 => 어렵
 *	int a,b,c,d,e,f,k,j,s,q,n,m,p;
 *	int[] arr=new int[12]; 
 */
public class MainClass_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("AAA(1), BBB(2), CCC(3), DDD(4), EEE(5)");
		int no=scan.nextInt();
		/*
		if(no==1) {
			AAA a=new AAA();
			a.display();
		}else if(no==2) {
			BBB b=new BBB();
			b.display();
		}else if(no==3) {
			CCC c=new CCC();
			c.display();
		}else if(no==4) {
			DDD d=new DDD();
			d.display();
		}else {
			EEE e=new EEE();
			e.display();
		}
		*/
		KKK k=null; //상속 받은 모든 클래스를 상위클래스를 이용하여 한번에 제어
		//데이터가 여러개 [] 배열
		//클래스가 여러개인 경우 => 상속 => 상위클래스 이용해서 제어
		switch(no) {
			case 1:
				k=new AAA();
				break;
			case 2:
				k=new BBB();
				break;
			case 3:
				k=new CCC();
				break;
			case 4:
				k=new DDD();
				break;
			case 5:
				k=new EEE();
				break;
		}
		k.display();
		
		Child c= new Child();
		System.out.println("이름: >> "+c.name);
		System.out.println("나이: >> "+c.age);
	}

}
