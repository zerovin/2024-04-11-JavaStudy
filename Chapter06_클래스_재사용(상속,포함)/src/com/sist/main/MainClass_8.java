package com.sist.main;
//메소드 오버라이딩 204page => 가장 많이 사용
class Music{
	int count=10;
	public void list() {
		System.out.println("목록 출력");
	}
	public void detail() {
		System.out.println("상세보기");
	}
	public void find() {
		System.out.println("뮤직 검색");
	}
}
class Genie extends Music{
	int musiccount=200;
	@Override //기존의 메소드를 오버라이딩해서 수정해서 사용 "@Override" 텍스트 안써도됨 우측에 ▲이 표시있으면 오버라이딩
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("Genie뮤직에서 목록 출력");
	}

	@Override
	public void detail() {
		// TODO Auto-generated method stub
		System.out.println("Genie뮤직에서 상세보기");
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("Genie뮤직에서 검색수행");
	}
	
}
class Melon extends Music{
	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("Melon뮤직에서 목록 출력");
	}

	@Override
	public void detail() {
		// TODO Auto-generated method stub
		System.out.println("Melon뮤직에서 상세보기");
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("Melon뮤직에서 검색수행");
	}
}
class Mnet extends Music{
	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("Mnet뮤직에서 목록 출력");
	}

	@Override
	public void detail() {
		// TODO Auto-generated method stub
		System.out.println("Mnet뮤직에서 상세보기");
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("Mnet뮤직에서 검색수행");
	}
}
public class MainClass_8 {
	// 상속 - 유사한 클래스 여러개를 모아서 1개의 객체로 제어
	/*
	 * 상속을 받는 경우
	 *
	 * 변수 - 선언하는 클래스명
	 * 메소드 - 생성자에 따라 
	 * 생성자 => 상속의 제외 조건
	 * 
	 * class A
	 * class B extends A
	 * 
	 * 형변환 필요없는 객체생성
	 * A a=new B(); 변수A 메소드B ==> 클래스가 여러개이고 하나의 객체로 제어를 원할 경우
	 * A a=new A(); 변수A 메소드A
	 * B b=new B(); 변수B 메소드B** ==> 가장 많이 사용
	 * 
	 * B b=new A(); => 오류 라이브러리에서 값을 받는 경우 형변환 후 사용
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=== 지니뮤직 ===");
		Music m=new Genie(); //하나의 객체로 여러개의 클래스 관리 데이터여러개=배열, 클래스여러개=상속
		                     //상위클래스 Music클래스로 객체 생성을 해서 하위클래스의 변수,데이터는 가져오지 못함
		                     //=> 하위클래스 = 하위클래스 => 본인 클래스로 객체생성이 가장 많이 사용됨
		m.detail();
		m.list();
		m.find();
		
		System.out.println("===== 멜론 =====");
		m=new Melon(); //메소드 호출시 생성자 주의, 생성자에 따른 데이터를 가져옴
		m.detail();
		m.list();
		m.find();
		
		System.out.println("==== Mnet ====");
		m=new Mnet();
		m.detail();
		m.list();
		m.find();
		
	}

}
