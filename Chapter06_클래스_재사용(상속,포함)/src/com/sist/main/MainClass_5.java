package com.sist.main;
/*
 *	상속 - 사용자 정의 클래스는 상속 사용빈도 낮음
 *        라이브러리 클래스 사용시 상속 자주 사용
 *        단일 상속
 *        상위클래스는 가급적 공통기반을 모아서 처리
 *          ex) class 사람 - class 회사원 extends 사람
 *                        - class 학생 extends 사람
 *                        - class 교직원 extends 사람
 *                        - class 교수 extends 사람...
 *                        ------------------------> 재사용
 *        메모리에 저장하는 방법
 *          상위클래스 = 하위클래스
 *          상위클래스 = 상위클래스
 *          하위클래스 = 하위클래스
 *          하위클레스 = (하위클래스)상위클래스 => 형변환 
 *          ------------> 클래스 크기는 상속이 있어야 가능
 *                        상속 내리는 클래스 > 상속 받는 클래스
 *        선언되는 클래스 - 변수
 *        생성자 - 메소드 지정
 *          ex) class Super{
 *                 int a=10;
 *                 int b=20;
 *                 public void display(){
 *                    System.out.println("Super:display() Call...");
 *                 }
 *              }
 *              class Sub extends Super{
 *                 int a=100;
 *                 int b=200;
 *                 public void display(){
 *                    System.out.println("Sub:display() Call...");
 *                 }
 *              }
 *              //extends Super 없을 때 상속X
 *              Super sup=new Super(); sup=> a=10, b=20 Super:display() Call...
 *              Sub sub=new Sub(); sub=> a=100, b=200 Sub:display() Call...
 *              
 *              //extends Super 있을 때 상속O
 *              Super sup2=new Sub(); sup2=> a=10, b=20 Sub:display() Call... => 오버라이딩
 *                                    상위클래스에 하위클래스 대입시
 *                                    생성자에 따라서 메소드를 덮어쓴다
 *                                    변수-상위클래스 메소드-생성자
 *              
 *              
 *              
 *         
 */

class A{
	int a=10;
	int c=20;
	public void display() {
		System.out.println("A:display() Call...");
	}
}
class B{
	int a=100;
	int c=200;
	public void display() {
		System.out.println("B:display() Call...");
	}
}
class C extends A implements Cloneable{
	int a=100;
	int c=200;
	public void display() {
		System.out.println("C:display() Call...");
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

public class MainClass_5 {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		// A aa=new B() ==> 상속 안받고는 클래스A와 클래스B는 관계없는 클래스라서 오류
		A aa=new A(); // 상위클래스 객체 생성 잘안씀
		System.out.println(aa.a);
		System.out.println(aa.c);
		aa.display();
		
		System.out.println("======================");
		C cc=new C(); //가장 많이 사용 => 하위클래스 본인 데이터형으로 생성
		System.out.println(cc.a);
		System.out.println(cc.c);
		cc.display();
		
		C kk=(C)cc.clone(); //clone은 리턴형 Object. C보다 큼 => 형변환
		//throws CloneNotSupportedException / try-catch 예외처리도 해야 에러X
		
		System.out.println("======================");
		A dd=new C(); //상위클래스에 하위클래스 대입시 변수=상위클래스 메소드-하위클래스 => 상위클래스로 생성
		System.out.println(dd.a); //A클래스변수 10
		System.out.println(dd.c); //A클래스변수 20
		dd.display();
		
		System.out.println("======================");
		C ee=(C)dd; //A인 데이터형을 C로 형변환 => 라이브러리 => 하위클래스로 생성
		System.out.println(ee.a); //C클래스변수 100
		System.out.println(ee.c); //C클래스변수 200
		ee.display(); //C클래스 메소드
	}

}
