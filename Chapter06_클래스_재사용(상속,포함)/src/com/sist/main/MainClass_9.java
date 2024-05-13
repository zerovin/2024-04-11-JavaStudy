package com.sist.main;
class Movie{
	void display() {
		
	}
}
class MegaBox extends Movie{
	//int display(){}; 오버라이딩시에 리턴형이 동일해야함
	//void display(){} 다르면 오류
	int display(int a) { //같은 메소드를 다른 형태로 => 매개변수 생성 => 오버로딩 
		return 10;       //상속받은 메소드가 아닌 같은 이름의 다른 메소드
	}
	public void display() {} //오버라이딩 => 리턴형 메소드명 매개변수 동일, 접근지정어는 크면 가능
	/*
	 *	오버라이딩
	 *	1.상속 => 재정의 (메소드 내용을 변경해서 사용)
	 *	2.메소드명 동일
	 *	3.매개변수 동일 (매개변수가 다를 경우 다른 메소드 => 오버로딩)
	 *	4.리턴형 동일
	 *	5.접근지정어가 동일하거나 확대
	 *    private < default < protected < public
	 *  
	 *  라이브러리 => 오버라이딩
	 *  상속이 여러개 있는 경우 - 가장 큰 클래스를 상속을 받는다
	 *    ex) JButton, JTextField, JFrame => JFrame 상속
	 * 
	 */
	
}

public class MainClass_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
