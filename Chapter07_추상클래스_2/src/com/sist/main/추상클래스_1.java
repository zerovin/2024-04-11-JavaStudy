package com.sist.main;
/*
 *  일반 클래스
 *    구성요소 class ClassName{
 *             변수 - 인스턴스 : 따로 저장하는 변수, 새로운 메모리 공간 생성 new
 *                   static : 한개를 공통으로 사용하는 변수
 *             생성자 - 변수에 대한 초기화
 *                    시작과 동시에 처리해야하는 일 - 윈도우, 웹, 데이터베이스
 *                      ex) 화면UI, 자동로그인, 쿠키, 드라이브등록
 *                    반드시 필요 - 메모리 저장시 호출, 필요없는 경우 생략가능 컴파일러에서 디폴트 생성자 자동추가
 *                    여러개 생성가능
 *                      -디폴트 생성자 - 매개변수가 없는 생성자
 *                      -매개변수가 있는 생성자 - 사용자로부터 초기값을 받아서 저장
 *                    클래스 내에서 생성자 호출시 this()이용 => 생성자 내에서만 호출가능, 첫줄에 한번만 호출가능
 *                      -super()는 상속 받은 경우 사용
 *                    자동처리 => 컴파일러에서 처리
 *                      -모든 클래스는 Object 상속을 받는다 => extends Object 생략
 *                         Object에서 제공하는 모든 기능 사용가능 - 객체 비교 equals()
 *                                                         소멸자 finalize()
 *                                                         복제 clone()
 *                                                         주소 출력 toString()
 *                      -import java.lang.*; 생략 - String, Math, System...
 *                      -메소드 void일 때 return 생략
 *                      -상속시 super() 생략
 *                         class A{
 *                      
 *                         }
 *                         class B extends A{
 *                            public B(){  
 *                              super(); ===> 생략, 상속을 내리는 클래스의 생성자가 매개변수를 가질 시 생략불가
 *                            }
 *                         } 
 *                         ==> super() 상위클래스의 메모리할당 => 자신의 메모리 할당
 *                             -----super-----
 *                             상속받은 변수/메소드
 *                             ---------------
 *                             ------this-----
 *                              추가된 변수/메소드
 *                             ---------------
 *                      -예외처리 생략 - 자바의 모든 클래스는 예외처리를 가지고 있다
 *                                   에러(소스상에서 수정할 수 없는 에러)방지 ex)메모리 공간 부족
 *                                   예외(소스상 수정가능한 에러)처리 ex)정수=>문자열
 *                         컴파일시 처리 javac - 예외처리 필수 ex)파일입출력, 네트워크, 쓰레드, 데이터베이스, 웹(스프링)...
 *                         실행시 처리 java - 생략가능 ex)사용자 입력처리
 *             기능처리 - 사용자 요청처리 => 메소드
 *                      요청은 한개만 요청 가능하게 제작
 *                      메소드는 반드시 한개 요청에 대한 처리만
 *                        ex)로그인과 동시에 댓글 처리 X
 *                      에러가 잘 발생하는 상황 - 사용자 입력(요청값 오류) => if로 예외처리
 *                                          프로그래머 실수 => if 사용불가
 *                        NullPointerException - 메모리할당X, 윈도우
 *                        ClassCastException - 객체 형변환
 *                        ArrayIndexOutOfBoudsException - 배열범위초과 length
 *                      메소드 - 반드시 구현
 *                             선언부{} => 메모리 저장
 *           }
 *  추상 클래스 - 사용자 정의는 거의 없음 => 확정된 개념(인터페이스)
 *             라이브러리에 추상클래스 많이 존재
 *             라이브러리 상속시 오버라이딩 해야하는 이유 => 미완성 클래스(구현이 안된 메소드)라 메모리할당 불가
 *             구현이 안된 메소드(설계만) 포함 => 미완성된 클래스 => 상속을 내려서 사용 / 익명의 클래스 이용
 *             [접근지정어] abstract class ClassName{
 *                변수 - 일반 클래스와 동일
 *                생성자 
 *                구현된 메소드 - 상속받은 클래스가 동일한 기능 수행
 *                구현이 안된 메소드 - 상속받은 클래스마다 기능 동일, 구현은 다름, 선언만 => 추상클래스
 *                  [접근지정어] abstract 리턴형 메소드명(매개변수...);
 *                  => 선언만해서 프로그램에 맞게 상속받은 클래스가 다르게 구현
 *             }                                   
 *             주로 사용되는 곳은 클래스마다 기능은 동일한데 구현내용이 다른 경우 선언만 => 유지보수 편리
 *               같은 기능이라도 사이트마다 처리방식이 다름 => 선언만하고 사이트에 맞게 구현
 *               ex)네이버 Ajax, 네이트 일반JSP, 아시아나 VueJS
 *               벤치마킹 => 기능설계 => 추상클래스
 *             상속이 안되는 소스 - 생성자, static, 초기화블록
 *             상속 - 변수, 메소드
 *             오버라이딩 프로그램 - 일반클래스, 추상클래스, 인터페이스
 *                              메소드명 동일, 매개변수 동일, 리턴형 동일, 접근지정어 확장가능
 *               abstract class A{
 *                  abstract void display(); ==> 상속을 내리면 반드시 구현해서 사용
 *                  => default
 *               }
 *               class B extends A{
 *                  void display(){} ==> 'abstract' 사용불가, 접근지정어 동일
 *                  protected void display(){} ==> 접근지정어 확장
 *                  public void display(){} ==> 접근지정어 확장, 잘 모르겠을 땐 public
 *               }
 *               
 *               interface A{
 *                  //int a; ==> 오류 => 상수이기 때문에 값을 지정해줘야 오류X
 *                  //public static final 생략
 *                  int a=10; ==> 오류X
 *                  
 *                  void display(); ==> 선언만 된 메소드만 가짐
 *                  //public absctract 생략
 *               }
 *               class B implements A{
 *                  void display(){} ==> 접근지정어 public에서 default로 축소됨 => 오류
 *                  public void display(){} ==> public 작성해야 오류X 
 *               }
 *               ==> 인터페이스 이해해야 Spring 가능
 */
class A{
	//public A(){}
}
class B extends A{
	public B() {
		//super();
	}
}
class C{
	public C(int a) {
		
	}
}
//하위클래스 D this-D super-C
//상위클래스 C this-C super-Object
//상속을 받아서 새로운 확쟁된 클래스 제작
class D extends C{
	public D() {
		super(10); //상위 클래스가 매개변수가 있는 경우 반드시 super를 이용해서 호출해야 사용가능
		//사용자 정의는 거의없음 => 라이브러리에서 호출시 반드시 super() 호출
		//super(), this() => 생성자 내에서 호출 가능, 반드시 첫줄에서 호출
		//=> super(), this() 둘 중에 하나만 호출 가능
		//상위 부모클래스 제어 => super, 생성자 super()
		//하위 자신클래스 제어 => this, 생성자 this()  
	}
}
abstract class AAA{
	public abstract void display();
}
public class 추상클래스_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//A a=new A();
		A a=new B();
		B b=(B)a; //형변환 A a=new A(); ==> java.lang.ClassCastException오류
		          //A a=new B(); ==> 오류X
		
		AAA aa=new AAA() {
			public void display() {
				
			}
		};
	}

}
