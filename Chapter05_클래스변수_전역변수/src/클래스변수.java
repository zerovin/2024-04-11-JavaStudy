/*
 *	데이터를 묶어서 사용 => 1개 이름으로 여러개의 변수에 접근
 *	                  배열 - 같은 데이터형끼리만, 고정적
 *	                  클래스 - 다른 데이터형을 모아서 관리, 가변적
 * 	자바는 클래스로 시작해서 클래스로 종료
 *	네트워크 ===> C/C++
 *	데이터베이스 ==> Java => 웹
 *
 *	클래스 구성요소
 *	  - 사용은 데이터형 / 연산자 / 제어문 / 메소드
 *	    필요한 경우 라이브러리 사용
 *	  - 메모리 구조
 *	    ------------------------------------
 *	    메소드영역 - 메소드, static변수
 *	    ------------------------------------
 *	    스택 stack - 지역변수, 매개변수 
 *	                => {}이 종료되면 자동으로 메모리에서 회수
 *	    ------------------------------------
 *	    힙 heap - 배열, 멤버변수
 *	              =>프로그래머가 관리, GC(가비지컬렉션)실제 데이터가 저장되는 영역
 *	              => 프로그램이 종료될 때까지 유지
 *	    ------------------------------------
 *	  - 변수
 *	      지역변수 / 매개변수 => 메모리 저장 - 메소드 호출시
 *	                        사용범위 - 메소드 안에서만 사용가능
 *	                        저장위치 - 스택 stack
 *	                        지역변수 - 요청처리를 위한 변수
 *	                        매개변수 - 사용자 요청값이 있는 경우
 *	      멤버변수 => 메모리 저장 - new 작성시마다 따로 생성
 *	                사용범위 - 클래스전체, 다른 클래스에서도 사용가능
 *	      공유변수 => 메모리 저장 - 컴파일시에 총 한개 메모리 공간 생성
 *	                사용범위 - 클래스전체, 다른 클래스에서도 사용가능
 *	      ex) class A{
 *	             int a; ==> 저장X
 *	             int c; ==> 저장X
 *	             static int b; ==> 저장
 *	          }
 *	          a,c => A aa=new A(); ==> new 작성시 저장
 *	          stack => heap
 *	          aa.a or aa.c => stack의 메모리주소.heap에 있는 데이터변수로 접근
 *
 *	      **new - 동적 메모리 할당, 실행시마다 메모리 생성 => 변수를 묶어주는 역할 수행
 *	              stack에 있던 애들을 heap에 데려와서 기존 stack에는 메모리 주소 부여
 *	      ** . - 메모리 주소 접근 연산자
 *	      static - 여러 메소드가 한 메모리를 써서 여러 방법으로 접근 가능
 *	               ex) aa.b, bb.b, cc.b, A.b ==> 공유 가능
 *	      멤버변수 > 지역변수 > 매개변수 사용이 거의 대부분 
 *	      └ 프로그램 종료시까지 메모리 유지
 *	        따로 저장이 되기 때문에 관리가 편리
 *	        다른 데이터형 여러개를 묶어서 사용 가능
 *	      프로그램 - 데이터관리
 *	               ex) React, Vue, Next - 데이터관리프로그램(AI,머신러닝,딥러닝 data.go.kr)
 *	      변수 초기화
 *	        멤버변수 / 공유변수 => 기본 초기화
 *	                          int=0, boolean=false, double=0.0, String=null
 *	                          명시적인 초기화 - 직접 값 입력 int a=100;
 *	                          자동 초기화 - 호출없이 초기화
 *	                          메모리 저장 초기화 - 생성자
 *	                          멤버변수 초기화 - {}
 *	                          static 초기화 - 공유변수 초기화 static{d=1000;}
 *	                          
 *	                          class A{
 *	                              int a; => 클래스영역에서는 선언만 가능(변수선언, 메소드선언)
 *	                                         구현 불가능
 *	                                         제어문/연산처리/라이브러리(X)
 *	                                         └ 클래스 안이 아닌 {} 블록 안에서 가능
 *	                          }
 *
 *	        지역변수 => 반드시 초기화를 해야 사용가능
 *
 *
 *	          
 *
 *	  - 생성자 / 초기화
 *	  - 메소드 - 저장된 변수 활용, 기능
 *	      리턴형 - 요청처리에 대한 결과값
 *	      매개변수 - 사용자가 요청한 값 => 웹(검색어, 로그인, 회원가입, 글쓰기, 수정)
 *
 *	클래스 => 재사용 목적(부품) => 컴포넌트
 *	  1. 데이터 보호(노출X) - 캡슐화, 은닉화
 *	  2. 재사용 - 상속 is-a / 포함 has-a
 *	  3. 유지보수 - 수정(오버라이딩), 추가(오버로딩) => 다형성 6장-기술면접
 *
 *	***라이브러리 사용 - 미국기준(정보제공목적), 한국(시각적효과)
 *	                 프로그램에 맞게 변경해서 사용 - 오버라이딩
 *	                 ex) Math.random() => 형변환
 *	                     substring(int s,int e) => e = e-1
 *	                     Calendar => month 0부터시작 week 1부터시작
 *	                     Spring 로드존슨 => 전자정부 프레임워크
 *	   라이브러리 => 변수사용
 */ 
public class 클래스변수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
