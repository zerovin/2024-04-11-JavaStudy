package com.sist.main;
/*
 *	객체지향프로그램 => 규칙(문법X, 권장사항)
 *  - 기존의 프로그램을 쉽게 제작, 활용
 *  - 코드의 재사용(개발이 빠름) => 상속, 포함
 *     - 상속 : 기존의 기능을 변경 == has-a == 오버라이딩
 *     - 포함 : 기존의 기능을 있는 그대로 사용 == is-a
 *  - 코드관리가 용이 => 구조화 프로그램 - 프로그램을 관련된 사항으로 나눠서 작업 == 메소드
 *  - 이미 사용중인 프로그램을 변경가능 => 신뢰성이 뛰어남
 *  - 보안 => 데이터 보호 == 캡슐화
 *  객체지향의 3대 특성 : 캡슐화 - private 변수 / 메소드로 접근
 *                   상속 - 재사용 기법
 *                   다형성 - 오버로딩 / 오버라이딩 => 유지보수(기능변경, 메소드관련)
 *  
 *  상속
    - 상속 사용시 결합성이 높고, 제약조건이 많이 존재, 메모리가 커짐, 속도가 늦음 => 가급적 사용X
      - 단일 상속
      - 상속 기호 extends => 그존의 클래스를 확장해서 사용
        class A
        class B extends A 
        => B-상속받는 클래스 A-상속 내리는 클래스(private,static,생성자,초기화블록 제외하고 나머지 상속가능)
    - 상속을 내린 클래스(상위, 부모, 베이스클래스) - 상속받은 클래스의 변수, 메소드에 접근 불가
    - 상속을 받은 클래스는 상속 내린 클래스에 접근 가능
      상속을 받은 클래스 - 자신의 객체(this), 상위클래스의 객체(super)
      상속을 내른 클래스 - 자신의 객체만 가지고 있다(this)
    - 모든 클래스는 자신의 객체를 가지고 있다(인스턴스, 생성자) == this
    - static 메소드나 static 초기화 블록은 this를 가지고 있지 않다  
    - new 이용해서 객체 생성시 thi s생성  
 *                     
 */
public class MainClass_1 {
	private int num; //Heap
	public MainClass_1() {
		System.out.println("this라는 자신의 객체가 생성");
		System.out.println("this="+this);
	}
	public void numData(int num) { //Stack
		//적용하는 우선순위 => 지역변수,매개변수 우선 > 멤버변수
		System.out.println("num="+num); //지역변수, 매개변수
		//멤버변수 사용시 this.변수명 => this가 구분자
		System.out.println("this.num="+this.num); //멤버변수
		this.num=num;
		System.out.println("this.num="+this.num);
		//매개변수, 멤버변수 충돌 => 구분자 this 사용
	}
	public void display() {
		System.out.println("this="+this);
	}
	public static void aaa() {
		//System.out.println("this="+this); //static은 모든 객체가 공통으로 사용 => this 사용불가
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//객체생성
		MainClass_1 m=new MainClass_1();
		//this=m JVM이 자동으로 객체주소값 대입
		System.out.println("m="+m);
		m.numData(100);
		
		MainClass_1 m1=new MainClass_1();
		//this=m1
		System.out.println("m1="+m1);
		
		//객체 생성시마다 this 생성 => 자신의 클래스 객체를 나타냄
		//this, super구분 this-자신의 객체 super-상위클래스의 객체
	}

}
