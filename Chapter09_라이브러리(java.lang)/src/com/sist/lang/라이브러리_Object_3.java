package com.sist.lang;
/*
 *  복제 clone()
 *  Object는 모든 데이터형을 받을 수 있다
 *  자바에서는 대부분 라이브러리의 리턴형, 매개변수 == Object 
 *  클래스 여러개를 묶어서 관리 => Object
 *  
 *  class A
 *  class B
 *  class C
 *  
 *  A a=new A()
 *  B b=new B()
 *  C c=new C()  => 따로따로 생성시 제어에 어려움
 *  
 *  Object[] arr={new A(), new B(), new C()}
 *  
 *  여러개 => 한개 이름으로 제어
 *    ex) 변수 220000개
 *        int[] arr=new int[220000]
 *        Object[] arr=new Object[]
 *  객체지향은 누가누가 잘 묶어서 사용하는가 싸움
 *  
 *  변수 - 데이터관리
 *  메소드 - 데이터활용
 *         기능처리 : 연산처리, 제어문 => 묶어서 사용
 *         
 *  class ClassName{
 *     변수 - 화면출력데이터, 관리대상데이터 저장
 *          데이터 벤치마킹
 *          하나만 사용하는 변수 - 로그 => static
 *          여러개 따로 저장하는 변수 - 메모리 따로 생성 저장 => 인스턴스 명령어new
 *     초기화 - 데이터 저장 => 생성자
 *            기본 데이터 저장 => 디폴트 생성자
 *            값을 받아서 저장 => 매개변수가 이는 생성자
 *            생성자가 여러개 필요할 때도 있다 => 오버로딩
 *            **오버로딩
 *              - 중복 함수 정의 => 같은 이름으로 제작
 *              - 메소드명이 동일
 *              - 매개변수를 다르게 만든다 (개수, 데이터형)
 *              - 리턴형 관계없음
 *              - 접근지정어 관계없음
 *             생성자
 *              - 클래스명과 동일
 *              - 리턴형 없음
 *              - 필요시에만 생성 => 없는 경우 컴파일러가 자동으로 매개변수없는 디폴트 생성자 추가
 *             ***시작과 동시에 처리 ex)화면UI, 자동로그인, 서버연결, 데이터베이스 연결
 *             ***데이터베이스에서 읽어서 주로 처리
 *     메소드 - 기능처리
 *              ex)목록출력, 페이징, 상세보기, 예약, 결제...
 *            다른 클래스와 연결
 *            접근지정어는 주로 public
 *            리턴형/매개변수
 *            프로그램마다 기능은 동일 처리가 다른 메소드 => 추상클래스 / 인터페이스 이용 하나로 통합
 *              ex)카페-게시판 인터페이스로 제어, 영화업체-CGV/메가/롯데
 *  }
 *  
 *  클래스 제작 - 개발(공기업/금융권 75%) - 공기업(정처기필수)
 *             에러에 대한 사전대비
 *             비정상 종료가 없는 프로그램
 *             => 예외처리(견고성)
 *             속도(최적화)
 *             가독성(유지보수) => 표준화 틀은 통일 => 인터페이스(Spring, MyBatis, JPA, Vue, React)
 * 
 *  예외처리 - 예외복구 try~catch(복구) => 대부분 사용
 *           예외회피 throws 알림 => 복구불가
 *  
 *  라이브러리 - 프로그램에 살을 붙이는 개념
 *            사용자가 만들지 못하는 기능 제공
 *            자바에서는 거의 모든 내용이 만들어져 있다 => 찾아서 조립 CBD(조립식 프로그램)
 *              자바개발자 단점은 라이브러리가 없는 경우 조립이 안됨
 *              C/C++ : 개발자 - 라이브러리없이 제작
 *              Java : 프로그래머 - 라이브러리로 조립
 *            java.lang / java.util / java.io / java.net / java.sql     
 *  
 */
class Card{
	
}
public class 라이브러리_Object_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("%d%s%c%f",10,"aaa",'a',10.7);
		//java.io.PrintStream.printf(String format, Object... args) => 매개변수 Object
	}

}
