package com.sist.main3;
abstract class A{
	public abstract void aaa();
	public abstract void bbb(); //모든 클래스가 구현
	
	// B, D클래스만 구현, C, E는 구현X
	// 구현을 해두고 필요한 클래스에서 오버라이딩
	public void ccc() {
		//구현 
	}
	
	//public abstract void ddd();
	//얘 나중에 추가하면 상속받은 클래스 전부 오류
	
	public void ddd() {}
	//프로젝트 구현이 끝난 다음 추가기능 => 구현된 메소드로 만들어 처리
	//필요한 클래스에서만 오버라이딩
	/*
	 *  추상클래스 보완 => 인터페이스
	 *  1.다중상속 가능
	 *  2.모든 메소드가 추상메소드 => 안써도 다 가져다 놔야해 => 1.8부터 구현된 메소드 존재
	 *  3.모든 변수는 상수
	 *   
	 */
}
class B extends A{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}
	
}
class C extends A{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}
	
}
class D extends A{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}
	
}
class E extends A{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}
	
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
