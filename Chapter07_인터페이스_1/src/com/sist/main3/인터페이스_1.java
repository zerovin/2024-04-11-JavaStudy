package com.sist.main3;
interface A{
	public void aaa();
}
interface B{
	public void bbb();
}
//다중상속 ,로 구분
/*
 *  자신클래스 = 자신생성자()
 *  상위클래스 = 하위생성자()
 *    class A
 *    class B extends A
 *    A a=new A();
 *    B b=new B();
 *    A c=new B();
 *    
 *    interface A
 *    class B implements A
 *    A a=new A(); => 불가 => 인터페이스, 추상클래스는 미완성 클래스 => 메모리할당불가
 *    B b=new B();
 *    A c=new B(); => 구현된 클래스를 이용해서 메모리 저장
 *    ------------ 구현한 클래스, 오버라이딩, 하위클래스 이용해서 객체생성
 *    
 */
class C implements A, B{
	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		System.out.println("C:bbb() Call");
	}
	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		System.out.println("C:aaa() Call");
	}
}
/*
 *  상속을 받은 경우
 *  1.변수 => 클래스 선언에 따라
 *  2.메소드 => 생성자에 따라 => 메소드를 덮어쓴다
 *  
 *  class A{
 *     int a,b;
 *     public void aaa(){}
 *  }
 *  A aa=new A(); => A변수, A메소드 => aa.a, aa.b, aa.aaa()
 *  
 *  class B{
 *     int c;
 *     public void bbb(){}
 *  }
 *  B bb=new B(); => B변수, B메소드 => bb.c, bb.bbb()
 *  
 *  class C extends A{
 *     //int a,b;
 *     //public void aaa(){}
 *     int d;
 *     public void ddd(){}
 *  }
 *  C cc=new C(); => C가 가지고 있는 모든 변수, 메소드 => cc.a, cc.b, cc.aaa(), cc.d, cc.ddd()
 *  A ac=new C(); => A가 가지고 있는 변수,메소드
 *                   C에 오버라이딩한 같은 메소드명이 있을 경우 C메소드 => ac.a, ac.b, ac.aaa()
 *                   A로 호출시 C에만 있는 d, ddd() 호출 불가
 *                   
 *  interface A{
 *     void aaa();
 *  }
 *  interface B{
 *     void bbb();
 *  }
 *  class C implements A, B{ ==> implements도 상속
 *     //aaa()
 *     //bbb()
 *  }
 *  A a=new C() => a.aaa()만 접근가능 bbb() 접근불가
 *  B b=new C() => b.bbb()만 접근사능 aaa() 접근불가
 *  C c=new C() => c.aaa(), c.bbb() 둘다 접근가능 => 다중상속일 경우
 *  
 *  A a; => A가 가지고 있는 변수, 메소드만 제어가능
 *  B b; => B가 가지고 있는 변수, 메소드만 제어가능
 *  
 */

//필요시에는 단일 상속 가능
interface AA{
	void aaa();
}
interface BB extends AA{
	//aaa()
	void bbb();
}
class CC implements BB{
	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}
}
public class 인터페이스_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new C(); //aaa()만 호출가능
		a.aaa();
		
		B b=new C(); //bbb()만 호출가능
		b.bbb();
		
		C c=new C(); //aaa(), bbb() 둘 다 호출 가능
		c.aaa(); c.bbb();
		// 다중 상속시 상속받은 클래스 이용 => 상속 내린 클래스의 모든 메소드를 갖고 있기 때문
		// 다중상속에서 하나의 상위클래스로 객체생성시 선언한 상위클래스의 변수, 메소드만 사용가능
		// 하위클래스 자신으로 객체 호출을 하면 다중상속받은 모든 상위클래스의 변수, 메소드 사용가능
		// => 하위클래스 자신으로 객체 호출이 효율적 C c=new C();
		
		BB bb=new CC();
		bb.aaa();
		bb.bbb();
		//인터페이스를 상속받은 인터페이스를 상속받으면 상위클래스로 선언하고 모든 클래스의 변수, 메소드 상속도 가능 => 단일상속
	}

}
