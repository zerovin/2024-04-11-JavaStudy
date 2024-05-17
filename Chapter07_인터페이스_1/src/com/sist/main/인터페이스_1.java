package com.sist.main;
/*
 *  1.인터페이스란? 246page
 *    추상클래스의 일종 => 특수한 클래스, 상속시 상위클래스 역할
 *                    미완성된 클래스 => 상속내려서 구현해서 사용, 자신이 메모리 할당 불가
 *    추상클래스 단점 보완 - 단일 상속 => 다중 상속으로 변경
 *                     추상클래스 = 구현된 메소드 + 구현이 안된 메소드
 *                     인터페이스 = 구현이 안된 메소드만
 *    역할 - 서로 다른 클래스를 연결해서 사용
 *          관련된 클래스를 묶어서 하나의 객체명으로 제어
 *          기능 설계와 관련 => 재사용
 *          모든 개발자가 동일한 메소드를 재정의 => 표준화 => 소스의 통일화 => 분석이 쉽다 => 유지보수가 쉽다
 *            ex) 라이브러리 System.out.println(), Math.random(), nextInt()
 *    요구사항 분석에 많이 사용
 *      아이템선정 => 참조할 사이트(벤치마킹) => 기능 추출(인터페이스) / 데이터추출(크롤링-사용자 정의 데이터형)
 *      사이트에 사용할 데이터 크롤링 => 오라클에 저장 => 데이터베이스 설계 => 데이터 수집
 *        => 구현 JSP / Spring => 테스트 - 오류발생여부 확인 => 배포 => 발표
 *         
 *  2.인터페이스 구성요소
 *    [접근지정어] interface 인터페이스명{
 *       접근지정어 - default / public => 다른 클래서를 묶어서 관리하는 역할 => 보통 public
 *       변수 - 상수, 초기값 반드시 부여 247page
 *               ex) int a; => 오류 int a=10;
 *             변수 작성시 public static final 생략, 자동추가 => 변수 작성시 자동 상수로 설정
 *               ex) (public static final) int a=10;
 *       구현이 안된 메소드 - public abstract 생략, 자동추가 248page
 *                        ex) (public abstract) void aaa(); => 접근지정어 공백이라도 default가 아니라 public
 *       JDK 1.8부터 구현된 메소드 - 접근지정어 default 생략없이 작성해야 구현가능 
 *                                ex) default void ccc(){}
 *                              public은 컴파일러가 자동 추가
 *                                ex) (public) default void ccc(){}
 *                                오버라이딩시 접근지정어는 확장만 가능하기 때문에 public 붙어야 오류방지
 *       ***인터페이스는 변수 - 상수 / 메소드 - public 
 *       
 *    }
 *  3.인터페이스 장점 면접 98%
 *      기능 설계 => 메소드 설계 => 개발기간 단축
 *      모든 개발자가 동일한 메소드 구현 => 표준화 => 분석하기 쉽다
 *      인터페이스 하나로 관련된 여러개 클래스를 모아서 관리
 *      유지보수가 쉽다
 *      독립적으로 사용가능
 *      결합성이 낮은 프로그램 - 클래스와 클래스를 연결시 리모컨 역할(원격) 
 *    단점 - 고정, 수정시 상속받은 클래스 오류 => default 구현 메소드로 추가
 *     
 *  4.인터페이스 상속 249page
 *    인터페이스 - 인터페이스 상속 extends**
 *      interface A
 *      interface B extends A
 *      
 *      interface A
 *      interface B extends A
 *      interface C extends B
 *      -------------------------단일 상속
 *      
 *      interface A
 *      interface B
 *      interface C extends A, B
 *      -------------------------다중 상속 253page
 *    인터페이스 - 클래스 상속 implements**
 *      interface A
 *      class B implements A => A가 가지고 있는 메소드 구현해서 사용
 *    다중 상속 250page
 *      interface A
 *      interface B
 *      class C implements A, B
 *      
 *      interface A
 *      interface B
 *      class C
 *      class D extends C implements A, B => 클래스상속 + 인터페이스상속
 *    
 *    ex)윈도우
 *       class A extends JFrame implements ActionListener, KeyListener, MouseListener
 *       ActionListener, KeyListener, MouseListener => 이벤트(사용자 행위) => 인터페이스로 제작되어있음
 *    
 *    컬렉션 => 인터페이스로 되어 있음
 *    
 *    *** 클래스 상속 extends(확장)
 *        인터페이스 상속 implements(구현)
 *        
 *    *** 클래스 == extends(확장) ==> 클래스
 *        인터페이스 == implements(구현) ==> 클래스
 *        인터페이스 == extends(확장) ==> 인터페이스
 *        클래스 == 불가 ==> 인터페이스 (클래스에서 인터페이스로의 상속은 존재하지 않는다)
 *        
 *                                              
 *      
 *  5.인터페이스 활용
 *  ------------------------------객체지향 마지막
 *  예외처리 - 형식
 *  라이브러리 - 메소드 => 기능, 원형(리턴형/매개변수)
 *  컬렉션 - 배열대체, 개수고정X => 제네릭스(자동형변환)
 *  웹 데이터베이스 연동 - 브라우저, 데이터형 클래스
 *  프레임워크(기본 틀) - 스프링, 스프링부트 => 실무
 *  AWS 호스팅 - 리눅스 명령어
 *  
 *  *웹 프로그램
 *   자바 - 변수(데이터형), 연산자, 제어문
 *          묶어서 사용
 *            1) 명령문 묶기 => 메소드
 *            2) 변수 묶기 => 배열(1차원), 클래스
 *          객체지향프로그램 - 권장
 *            1) 데이터 보호 - 캡슐화, getter/setter => 웹 사이트 데이터 추출(크롤링)
 *            2) 인터페이스 - 클래스 여러개를 묶어서 관리 => 결합성이 낮은 프로그램
 *            3) 오버라이딩 - 인터페이스에서 오버라이딩 주로 사용
 *          프로그램의 비정상종료 방지 - 예외처리
 *          사용자 정의 + 라이브러리 => 조립
 *         ----------------------------
 *         2차 자바 - 오라클 연동 JDBC
 *         3차 자바 - 웹 연동 J2EE(JSP) => 타임리프, VueJS로 대체되는 분위기 (1차프로젝트)
 *         4차 자바 - 스프링,스프링부트 => 어노테이션/XML (2차프로젝트)
 *  서버 - 개인프로젝트 - 스프링부트 => React-Query
 *                   장고 => Redux (파이썬 - 예측, 통계)
 *            
 *         
 *   
 */
interface I{
	void disp();
	void bbb(); //인터페이스 단점 - 추가시마다 상속받은 클래스에 오류
	default void ccc() {} //얘는 추가해도 오류X => 개발자요구
}
class A{
	public void aaa() {
		I b=new B();
		b.disp();
	}
}
class B implements I{
	public void disp() { //클래스명 변경해도 자신 클래스에서만 오류
		
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}
}

class AA{
	int a;
	static int B; // static은 이탤릭체
}
interface 도형{
	String COLOR="black"; //COLOR => static => 이탤릭체
	//public static final String COLOR="black";
	//public static final 자동추가
	
	//그리다
	void draw();
	//public abstract void draw();
	//public abstract 자동추가
	
	//private void aaa();
	//private 사용 오류 => private은 오버라이딩이 안되기 때문에 사용불가
	
	//protected void aaa(); protected도 오류
	//선언시에 접근지정어는 public만 선언가능
	
	//private int a=100; only public, static, final
	//인터페이스에서 접근지정어는 public만 사용가능
	
	//public int a=100;
	//public void aaa();
	//public 자동으로 추가되지만 작성해도 상관은 없음
	
	//형식 고정
	//변수 상수 public static final
	//메소드 public abstract
	
	//접근지정어는 only public
}
class 선 implements 도형{
	//선언된 메소드 구현안하면 오류
	//접근지정어 축소되면 오류 public 작성해줘야 오류X
	public void draw() {
		System.out.println("선을 그린다 ---------");
	}
}
class 사각 implements 도형{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("사각형을 그린다 □■□■□■□■□■□■");
	}
}
class 삼각 implements 도형{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("삼각형을 그린다 △▲▽▼△▲▽▼△▲▽▼");
	}
	
}
public class 인터페이스_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		도형 a=new 선();
		a.draw();
		
		a=new 사각();
		a.draw();
		
		a=new 삼각();
		a.draw();
		//관련된 클래스 여러개를 모아서 한개의 객체명으로 제어
	}

}
