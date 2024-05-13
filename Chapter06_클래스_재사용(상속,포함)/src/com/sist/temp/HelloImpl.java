package com.sist.temp;

public class HelloImpl implements Hello{
	
	@Override
	public void sayHello() { //인터페이스 - 결합성이 낮아서 다른 클래스에 영향을 적게 줌, 본인 파일만 에러
		// TODO Auto-generated method stub
		System.out.println("sayHello Call...");
	}
	
}
