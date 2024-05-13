package com.sist.main;
/*
 *	206page - 오버로딩,오버라이딩
 *	207page - 상속에서 접근지정어
 *
 * 	오버로딩 / 오버라이딩 => 면접 97%, 추상클래스/인터페이스 => 85%
 * 
 * 오버로딩 - 중복 메소드 정의 => 같은 기능
 * 	        매개변수 개수, 데이터는 다름
 * 	        ex) 버스 - 버스(좌석), 버스(마을), 버스(고속)
 *              print - print(int), print(char), print(char[])
 *              plus - plus(byte,byte) (byte,int) (byte,short) (byte,long) (byte,float) (byte,char) (byte,double)
 * 오버라이딩 - 기존의 클래스를 상속 받아 재정의 => 메소드 기능을 변경
 *                        오버로딩                             오버라이딩          
 *        상태         같은 클래스내에서만 가능                   상속이 된 상태 가능 => 익명의 클래스 => 상속없이 오버라이딩 가능
 *               class A{
 *                  public void aaa(){} => aaa()
 *                  public void aaa(int a){} => aaa(int)
 *                  public void aaa(char a){} => aaa(char)
 *                  public void aaa(int a,int b){} => aaa(int,int)
 *                  public int aaa(double d){} => aaa(double)
 *                  void aaa(float f){} => aaa(float)
 *               }
 *        메소드명            동일                                 동일
 *        매개변수       개수/데이터형 다름***                   개수/데이터형 동일
 *        리턴형            관계없음                               동일
 *        접근지정어         관계없음                       축소불가, 같거나 확대만가능
 *                                    **접근지정어의 크기 private < default < protected < public
 *                                                   기본 public
 *  오버라이딩 - 상속
 *            예외조건 - static - 상속불가, 사용이 가능하게 만든다(공유)
 *                     private - 상속가능, 접근 불가 => protected
 *                     생성자 - 상속불가
 *                     초기화블록 - 상속불가
 *                     ---------------
 *                     멤버변수(인스턴스) - 상속가능, 변수값변경(변수 오버라이딩)
 *                     메소드 - 상속가능, 기능변경(메소드 오버라이딩)
 *  메소드의 종류 - 인스턴스 메소드 : new에 의해 따로 저장
 *              공통 메소드 : static 상속의 예외 조건 => 변경시 전체 변경, 오버라이딩 안됨
 *              종단 메소드 : final 확장 불가능, 변경 불가
 *              ===> 권장사항** 메소드의 접근지정어는 가급적이면 public
 *  접근지정어 - public : 생성자, 클래스, 메소드, 인터페이스 => 다른 클래스와 연결
 *            private : 멤버변수 데이터 노출 방지(데이터 보호)
 *                      => 다른 클래스에서 사용시 변수기능의 메소드 제작 => 읽기-get변수명() 저장-set변수명()
 *                         class A{
 *                            private String name;
 *                            private boolean login;
 *                            public void getName(){} //get~
 *                            public void isLogin(){} //boolean은 is~ 로 시작
 *                         } 
 *                         class B{
 *                            A a=new A();
 *                         }
 * class 영역 - static 메소드 : 기본적으로 static 메소드, static 변수만 사용가능
 *                           인스턴스 메소드, 인스턴스 변수 사용불가 => 객체 생성 후는 '굳이' 사용가능
 *                           this 사용X
 *             인스턴스 메소드 : 인스턴스 메소드, 인스턴스 변수, static 메소드, static 변수 사용가능
 *                           this 사용
 * 
 */
class ABC{
	public void display1() {} //멤버메소드 => 셋 중에 얘만 오버라이딩 가능
	public static void display2() {} //공통메소드
	public final void display3() {} //종단메소드 => 변경불가
}
class BCD extends ABC{
	public void display1(BCD this /*예전에는 있었는데 지금은 자동인식*/) {} //멤버메소드
	//public static void display2() {} //공통메소드
	//public final void display3() {} //종단메소드
}
//인스턴스 메소드, 인스턴스 변수 => 주로 사용 / static => 데이터베이스, MyBatis
//실무 SpringFramework + MyBatis => MySQL
class DGB{
	// this. ==> DGB가 가지고 있는 변수
	// 생성자, 멤버 메소드에만 존재 => static 메소드에는 인스턴스 멤버변수 사용불가, 메모리 위치가 다름 => this 없음
	private String name;
	private boolean login;
	private static int age;
	
	public void display() {
		String name="";
		this.name="홍길동";
		name=""; 
	}
	public static void aaa() {
		//name=""; 멤버변수 사용불가
		//클래스의 멤버변수가 아님 => 공통 사용부분 구사
		System.out.println(age); //static 메소드에서 static 변수만 사용가능
		//display(); 인스턴스 메소드 사용 불가
		DGB d=new DGB(); //인스턴스 메소드 굳이 쓰려면 객체 생성 후
		d.display(); //호출 가능
		
	}
	public String getName() {
		return name;
	}
	public void setName(String /*name*/n) {
		//this.name = name; //this == 멤버변수 구분자, this 안쓰고 싶으면 변수명 변경
		name=n;
		//지역변수 우선순위
		//지역변수, 매개변수에서 먼저 찾고 없을때 멤버변수에서 찾아옴
	}
	public boolean isLogin() { //boolean is~
		return login; //지역변수, 멤버변수 충돌이 안되면 this 생략가능
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	
}

public class MainClass_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
