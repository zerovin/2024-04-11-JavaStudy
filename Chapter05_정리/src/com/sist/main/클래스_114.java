package com.sist.main;
/*
 *	114page
 *
 *	클래스 구성요소 - 윈도우, 웹, 모바일 동일
 *    설계(클래스) =====> 메모리 저장(인스턴스/객체)
 *    1.클래스 설계
 *       클래스 - 데이터만 관리(변수 여러개를 모아서 관리) => 데이터를 모아서 한번에 전송 ex)웹, 윈도우
 *              데이터활용(메소드를 여러개 묶어서 관리) => 사용자 요청시 처리 ex)Manager
 *              └ 액션클래스(동작을 정의)
 *              데이터+메소드 혼합
 *       클래스 설계내용 - 1) 데이터 => 멤버변수
 *                     2) 기능 => 메소드
 *                     3) 필요시 멤버변수의 초기화 => 생성자, static => static{}
 *       멤버변수의 종류
 *         인스턴스 변수 - Heap 메모리 공간을 만들어 동시에 저장 후 관리 => new 연산자 (프로그래머 관리)
 *                     메모리를 따로 저장 (메모리가 여러개가 필요한 경우)
 *                     ex)영화,회원정보, 게시물 저장
 *         정적 변수 - Method Area 모든 객체가 1개의 메모리를 공통으로 사용하는 변수 => static
 *                  변경시 데이터 값이 동시에 변경
 *                  모든 객체의 변수값을 한꺼번에 변경 => static
 *                  데이터 전체를 모아서 관리 => 오라클 (공유된 데이터), 마이페이지만 다름
 *                  ex)게임 캐릭터 width, height  
 *       변수 초기화 - 사용을 위해 변수 값을 저장
 *       - 인스턴스 초기화 블록
 *         class A{
 *            int a; => 클래스 블록은 선언만 가능, 값 대입불가
 *            {
 *               a=100; => 구현 제어문/연산자/파일읽기...
 *            }
 *         }
 *       - 정적변수 초기화 블록 => static 변수는 초기화 블록에서 주로 사용
 *         class A{
 *            static int a;
 *            
 *            static{
 *               a=100; => 명시적 초기화가 안되는 경우 사용 => 난수, 제어문...
 *            }
 *         }
 *         ex) 자동로그인 => 쿠키에서 id 읽어와서 초기화
 *       - 생성자 => 가장 많이 사용 => 인스턴스
 *         1)특징
 *           모든 클래스는 생성자가 1개 이상 존재, 없는 경우 컴파일러가 자동으로 1개 추가(디폴트생성자-매개변수X)
 *           클래스명 동일
 *           리턴형이 없다, void 없음
 *           객체 생성시 호출 => new 생성자() 
 *           같은 이름으로 여러개의 생성자를 만들 수 있다 == 오버로딩(중복 메소드 정의)
 *           - 매개변수의 개수, 데이터형이 다른 경우
 *           - 리턴형, 접근지정어는 관계없음
 *           단독 호출 불가 => 호출시 new 생성자()
 *         2)역할
 *           멤버변수의 초기화
 *           시작과 동시에 처리하는 소스가 있는 경우 ex)모바일, 화면UI, 카톡-서버연결, 데이터베이스 연결, 파일읽기
 *         **static 메소드 안에서는 static 변수, static 메소드만 사용가능
 *                              인스턴트를 사용하고 싶은 경우 => new 이용해서 메모리 할당 후 사용
 *           인스턴트 메소드 안에서는 모든 것을 사용가능
 *         class A{
 *           int a=10; ===> 인스턴스
 *           static int b=20; ===> 정적
 *           
 *           A(){ ===> 인스턴스
 *              a,b,aaa(),bbb() => 인스턴스,static 모든 변수,메소드 사용가능
 *           }
 *           
 *           void aaa(){ ===> 인스턴스
 *              a,b,bbb() => 생성자는 호출 불가능
 *           } 
 *           
 *           static void bbb(){ ===> 정적
 *              b => static은 static 메소드, static 변수만 호출 가능
 *              A aa=new A(); => static에서 인스턴트 사용시 메모리 할당 후
 *              aa.aaa(), aa.a => 사용
 *           } 
 *         }
 *        
 */
class Student{
	private String name;
	private String sex;
	private int age;
	
	public Student() {
		name="홍길동";
		sex="남자";
		age=20;
	}
	
	//사용자가 입력한 값으로 초기화
	public Student(String n, String s, int a) { //생성자 여러개 생성가능
		name=n;
		sex=s;
		age=a;
	}
	public Student(String n) {
		//생성자 호출 => this()
		//클래스 안에서 생성자 호출시에 this();
		//반드시 생성자 안에서만 호출가능, 첫줄에만 사용가능
		this(); //첫줄에 사용 public Student(){}
		name=n;
	}
	public Student(String s, int a) {
		this("박문수",s,a); //public Student(String n, String s, int a) {}
	}
	public void print() {
		System.out.println("이름:"+name);
		System.out.println("성별:"+sex);
		System.out.println("나이:"+age);
	}
}
class Member{
	//생성자 => default 생성자는 존재하지 않는다 ==> 매개변수가 있는 생성자만 있기에 Member() 호출하면 오류
	//생성자가 없을 때만 컴파일러에서 디폴트 생성자 추가
	public Member(String name) { 
		System.out.println("이름:"+name);
	}
}
class Sawon{
	//public Sawon(){} => 컴파일러가 자동으로 추가
}
class Emp{
	private String name;
	private String dept;
	public Emp(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}
}
public class 클래스_114 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		//생성자는 여러개 생성 가능
		Student s1=new Student();
		s1.print();
		
		System.out.println("========== 사용자 입력을 받아 초기화 ==========");
		Student s2=new Student("심청이","여자",20);
		s2.print();
		
		
		Student s3=new Student("박문수");
		s3.print();
		
		Student s4=new Student("여자",30);
		s4.print();
		*/
		Member m=new Member("a");
		
		//생성자가 없는 경우 컴파일러가 디폴트 생성자 자동추가
		Sawon s=new Sawon();
		
		
	}

}
