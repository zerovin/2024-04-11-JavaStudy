package com.sist.main2;
/*
 *	객체 생성
 *  클래스명 객체명=new 클래스명()
 *  ------다른 클래스에 접근 불가능
 *  
 *  class A{
 *    int a,b;
 *    public void aaa(){}
 *  }
 *  
 *  class B{
 *     int c;
 *     public void bbb(){}
 *  }
 *  
 *  class C extends A{
 *     int c;
 *     public void bbb(){}
 *  }
 *  
 *  A aa=new A(); //A클래스의 a, b, aaa() 접근가능
 *  B bb=new B(); //B클래스의 c, bbb() 접근가능
 *  C cc=new C(); //A클래스의 a, b, aaa() C클래스의 c, bbb() 접근가능
 *  상속을 내린 클래스는 본인이 가지고 있는 메소드만 접근 가능 => 상속받은 클래스에 접근불가
 *  A ccc=new C();//A클래스의 a, b 접근가능 C클래스의 aaa()메소드로 덮어써서 접근가능 A변수 C메소드
 *  
 *  
 *  
 */
public class GenieMusic extends MusicSystem{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detail(int mno) {
		// TODO Auto-generated method stub
		
	}
	
}
