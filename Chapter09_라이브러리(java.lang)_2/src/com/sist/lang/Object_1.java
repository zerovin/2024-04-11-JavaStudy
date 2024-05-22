package com.sist.lang;

import java.util.Objects;

import javax.swing.event.ListDataEvent;

/*
 *  java.lang** / java.util** / java.sql** - 웹 관련 핵심 라이브러리
 *  java.io - 파일업로드, 다운로드 (자료실)
 *  java.net - 브라우저에서 한글인식 => 인코딩 / 디코딩 => 한글깨짐방지
 *  
 *  라이브러리 - 자바에서 지원하는 클래스의 집합(API)
 *            사용법, 사용용도 공부
 *            변수는 존재하지 않고 메소드(기능)만 존재
 *            주로 오버라이딩해서 사용
 *  프로그램 = 라이브러리 + 사용자 정의 (조립)
 *  
 *  java.lang - 자바에서 기본적으로 사용이 많은 클래스를 모아서 관리 => import 생략가능 292page
 *   - Object : 자바의 모든 클래스(사용자정의 포함)의 상위클래스 => 최상위 클래스 
 *               => 모든 클래스는 Object로부터 상속을 받는다
 *               => extends Object 생략가능
 *              데이터형 중에 가장 큰 데이터형 => 모든 데이터를 받아서 저장 가능
 *              라이브러리 메소드의 리턴형은 대부분 Object => 객체 형변환***
 *              ex)
 *                 class A (extends Object){
 *                    int a;
 *                    int b;
 *                    public void display(){}
 *                 }
 *                 => Object obj=new A();
 *                    => obj는 a,b,display()를 가지고 있지 않음
 *                    => A a=(A)obj 형변환 후 사용
 *                    => 상위클래스는 하위클래스의 변수, 메소드에 접근불가
 *                 ** 형변환 => 데이터형의 크기변경 (상속 / 포함)
 *                    상속 - 상속을 내리는 클래스 > 상속을 받는 클래스
 *                          상위클래스 - 하위클래스의 추가된 기능에 접근 불가능
 *                          하위클래스 - 상속받은 기능 + 추가된 기능
 *                    포함 - 포함하고 있는 클래스가 큼
 *                          ex) class A{}
 *                              class B{
 *                                 public void display(){
 *                                    A a=new A(); => 포함클래스X, 지역변수
 *                                 }
 *                              }
 *                              class C{
 *                                 A a=new A(); => 포함클래스 => 멤버일 경우만 포함클래스
 *                              }
 *              제공하는 기능(메소드)
 *             ***1.toString() - 객체를 문자열화 => 객체의 주소
 *                               묵시적, 명시적
 *                                 ex) class A
 *                                     A a=new A();
 *                                     System.out.println(a) => 묵시적 => toString() 생략가능
 *                                     System.out.println(a.toString()) => 명시적
 *                               가장 많이 오버라이딩 => 변수 값을 출력
 *                2.hashCode() - 객체의 메모리 주소값 리턴
 *                               데이터값이 같은 경우, 같은 객체(같은 주소)인지 다른 객체(다른 주소)인지 판별
 *                                 => 데이터 중복 여부 판별, 중복제거
 *                                    ex) 웹에서 데이터 수집시
 *             ***3.clone() - 객체를 복제 => 새로운 메모리를 만들 때 필요한 객체의 내용을 그대로 복사
 *                            ProtoType 패턴 - 이모티콘 / 아바타
 *                4.finalize() - 소멸자 => 객체 메모리 해제시 자동호출, 호출안되면 객체이 메모리가 남아있게됨
 *                               System.gc() - 사용하지 않는 메모리 회수 요청
 *                               웹/앱에서는 사용하지 않음, 멀티미디어(동영상, 화상채팅, CCTV)에서 주로 사용
 *                  **객체의 생명주기
 *                    객체 생성 ===========> 객체 활용 ===========> 객체 소멸
 *                   new 생성자()          .변수/메소드            객체=null => 더이상 사용X => GC대상(메모리회수 대상)
 *                                                            GC대상이어도 바로 회수하지 않고 프로그램 종료시 회수
 *                                                            new 많이 사용 => 메모리 누적 => 부하
 *             ***5.equals() - 객체 멤버변수값 비교
 *                             메모리 주소값(default)X, 멤버변수 값을 비교
 *                             오버라이딩해서 사용
 *   - String
 *   - System
 *   - Math
 *   - Wrapper
 *   - StringBuffer
 */
class Sawon{
	private int sabun;
	private String name;
	
	//사용자로부터 값을 받아서 초기화
	public Sawon(int sabun, String name) {
		this.sabun=sabun;
		this.name=name;
	}
	//생성자가 있기에 디폴트생성자 자동추가X
	//=>매개변수가 있는 생성자가 있으니 호출시마다 매개변수있는 생성자 호출

	//출력
	@Override //반드시 상속 => 재정의 => 덮어씀
	public String toString() {
		// TODO Auto-generated method stub
		return "사번:"+sabun+", 이름:"+name; //기존 메모리주소출력 기능 변경 => 변수초기화 출력
	}
	
}
class Student{
	private int hakbun;
	private String name;
	
	//생성자
	public Student(int hakbun, String name) {
		this.hakbun=hakbun;
		this.name=name;
	}

	//hashCode편집 => 라이브러리는 필요한 경우 대부분 오버라이딩해서 사용
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(hakbun,name); //객체들의 값이 같다면 같은 주소로 변환
	}	
}

/*
 *  인터페이스도 클래스, 다중상속이 가능한 클래스
 *  - 미완성된 클래스 => 완성해서 사용 => 상속
 *  - 인터페이스 == extends(확장) ==> 인터페이스   
 *    인터페이스 == implements(구현) ==> 클래스
 *    클래스 == extends(확장) ==> 클래스
 *    클래스 == 불가/==> 인터페이스 (X)
 *  - 형식 => 모든 구성요소 변수/메소드 => only public
 *       interface 인터페이스명{
 *          상수(변수는 존재하지 않는다) => 반드시 선언과 동시에 초기값 설정 => 변경불가
 *            (public static final) int a=100;
 *          구현이 안된 메소드
 *            (public abstract) void 메소드명();
 *          구현이 된 메소드
 *            (public) default 리턴형 메소드명(매개변수){}
 *       }
 */
class Box implements Cloneable{
	private int width;
	private int height;
	
	//getter setter
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	//throws 문장 뒤에 붙는 예외클래스 => RuntimeException 관련은 없다 => CheckedException => 예외처리 필수
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}	 
}
class Member{
	private int mno;
	private String name;
	
	//생성시 호출 => 생성자
	public Member(int mno, String name) {
		this.mno=mno;
		this.name=name;
		System.out.println("객체 메모리 할당");
	}
	public void print() {
		System.out.println("회원번호:"+mno);
		System.out.println("이름:"+name);
	}
	
	//소멸시 호출 => 소멸자
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("객체 메모리 회수");
	}
	// C언어 생성자:클래스명() / 소멸자:~클래스명()
	
	/*
	 *  멤버변수 값 설정
	 *  - 한번만 변경 => 생성자
	 *  - 여러번 변경 => 생성자 이용 불가 => setter 이용
	 *  
	 *  ex)
	 *  Member m=new Member(1,"aaa");
	 *  m=new Member(2,"bbb");
	 *  m=new Member(3,"ccc");  ===> 객체, 메모리 3개 생성
	 */ 
}
class Food{
	private int fno;
	private String name;
	public Food(int fno, String name) {
		this.fno=fno;
		this.name=name;
		//지역변수 우선순위 => 지역변수, 매개변수 먼저 / 없으면 멤버변수
		//변수명이 같은 경우 멤버변소는 this로 구분
		//this => 클래스 자신이 가지고 있는 객체
		//super => 상속 내린 클래스의 객체
		/*
		 *  메모리 ---------------------
		 *    ------- super --------
		 *    상속 내린 클래스의 변수/메소드
		 *       => clone()
		 *       => finalize()
		 *       => equals()
		 *       => toString()
		 *       => hashCode()
		 *    ----------------------
		 *    -------- this --------
		 *           추가된 내용
		 *    ----------------------
		 *  --------------------------
		 */
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Food f=(Food)obj; //매개변수를 Object로 받음 => Object는 상위클래스 => fno, name에 접근불가 => Food로 형변환
		return name.equals(f.name) && fno==f.fno; //실제 멤버변수 값을 가지고 변경
	}
	/*
	 *  class A{
	 *     int a,b;
	 *     void display(){}
	 *  } 
	 *  class B extends A{
	 *     //int a,b;
	 *     //void display(){} => 필요한 경우 내용변경 => 오버라이딩
	 *     int c;
	 *     void bbb(){}
	 *  }
	 *  A a=new A(); ==> a, b, A.display()
	 *  B b=new B(); ==> a, b, B.display(), c, bbb()
	 *  A c=new B(); ==> a, b, B.display() / c, bbb() 접근불가
	 */
}
public class Object_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon s1=new Sawon(1, "홍길동"); //데이터베이스 데이터읽기, 파일데이터읽기
		System.out.println(s1); // s1.toString() => toString() 생략
		
		//Sawon s2=new Sawon(); => 매개변수있는 생성자만 있기에 디폴트생성자로 호출시 오류
		Sawon s2=new Sawon(2, "박문수");
		System.out.println(s2.toString());
		
		Student st1=new Student(1, "홍길동");
		Student st2=new Student(1, "홍길동"); //데이터내용은 같지만 주소값은 다름
		//new를 사용하면 새로운 메모리를 만들어서 사용
		//중복 제거 할때 hashCode() 사용, 데이터 중복여부
		
		System.out.println("st1:"+st1.hashCode());
		System.out.println("st2:"+st2.hashCode()); //주소값확인
		if(st1.hashCode()==st2.hashCode()) {
			System.out.println("같은 학생입니다");
		}else {
			System.out.println("다른 학생입니다");
		}
		
		Box box1=new Box();
		box1.setWidth(300);
		box1.setHeight(350);
		
		try {
			Box box2=(Box)box1.clone(); //Box box2=box1 => 대입과 clone은 다름. 대입은 주소공유
			//오류1.clone하면 Object로 반환하니 형변환
			//오류2.CloneNotSupportedException 예외처리필요
			
			System.out.println("box2.width:"+box2.getWidth());
			System.out.println("box2.height:"+box2.getHeight()); //clone - 대상값 그대로 복제, 새로운 메모리 생성
			System.out.println("box2 주소:"+box2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Box box3=new Box();
		System.out.println("box3.widht:"+box3.getWidth());
		System.out.println("box3.height:"+box3.getHeight()); //새 객체 => 초기화 값, 새로운 메모리
		
		Box box4=box1;
		System.out.println("box1 주소:"+box1);
		System.out.println("box1 주소:"+box4); //대입은 주소값공유, 같은 메모리 제어
		
		//객체생성
		Member m=new Member(1,"심청이");
		//객체활용
		m.print();
		//객체소멸
		m=null; //finalize()호출X, 메모리 회수가 안됨
		//객체 메모리 회수 명령
		System.gc(); //필요한 경우에만 사용
		
		Food f1=new Food(1,"중국집");
		Food f2=new Food(1,"중국집");
		
		//equals() == 재정의, 오버라이딩 전까지는 주소값 반환
		if(f1.equals(f2)) {
			System.out.println("f1 주소:"+f1);
			System.out.println("f2 주소:"+f2);
			System.out.println("같은 업체입니다");
		}else {
			System.out.println("f1 주소:"+f1);
			System.out.println("f2 주소:"+f2);
			System.out.println("다른 업체입니다");
		}
	}

}
