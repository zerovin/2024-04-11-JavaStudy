package com.sist.main;
/*
 *	클래스 구성요소
 *	***클래스 블록
 *       class ClasName{
 *          구현 불가능 - 제어문, 연산처리, 파일읽기, 크롤링, 메소드 호출... => 메소드, 생성자, 초기화블록 이용 
 *          선언만 가능 - 변수, 클래스(사용자 정의 데이터형), 배열
 *       }
 *	  변수 - 프로그램에 필요한 데이터 저장공간
 *	        멤버변수 == 프로그램 종료시까지 유지하는 변수 => 자동초기화 default
 *	  변수 초기화 - 변수는 초기값이 없는 상태에서 메모리 저장 불가
 *      생성자 - 일반 메소드와 다름
 *             클래스명과 동일
 *             리턴형 없음 (void도 리턴형이 생략일뿐 있음)
 *               ex) class A{
 *                      void A(){} => 일반메소드
 *                      A(){} => 생성자
 *                   }
 *             여러개의 생성자 생성 가능 - 같은 이름의 메로드 여러개 제작가능 == 오버로딩
 *          ***오버로딩 - 같은 이름의 메소드로 새로운 기능 추가
 *                      메소드명이 동일
 *                      매개변수의 갯수나 데이터형이 다름
 *                      리턴형 관계없음
 *                      접근지정어 관련없음
 *                      ex) System.out.print() 매개변수에 따라 다르게 여러개 인식
 *                          plus(int a, int b) => plus(int, int)
 *                          plus(double d, double d2) => plus(double, double)
 *                          plus(int a, double d)
 *                          plus(byte b, int i)
 *                          plus(char a, char b)
 *                          ===> 같은 이름의 함수지만 매개변수가 다르면 다른 메소드로 인식
 *            생성자의 역할 - 역할이 필요없는 경우 생략가능
 *                        반드시 생성자는 필요 => 생략된 경우 컴파일러가 생성자 하나 추가
 *                        멤버변수의 초기화 담당
 *                        클래스를 메모리에 저장할 때 호출되는 메소드
 *                        시작과 동시에 처리해야하는 기능이 있는 경우 사용
 *                          ex) 화면UI, 오라클연결, 서버연결, 자동로그인
 *            생성자 호출 - new 생성자()
 *                       └ new없이 호출시 오류 발생
 *             
 *      초기화블록 - 호출없이 자동으로 처리
 *                인스턴스 변수
 *                  {
 *                     구현 후 초기화
 *                  }
 *                정적 변수
 *                  static{
 *                     static 변수 초기화
 *                  }
 *    **초기화 방법 - 명시적 초기화 int a=100; => 일단 명시적 초기화가 가능하면 명시적으로
 *                 초기화 블록 int a;
 *                          {
 *                             a=100; => 파일읽기, 크롤링...=> 초기화에 구현이 필요할 때
 *                          }
 *                 생성자 int a;
 *                      생성자(){
 *                         a=100; => 초기화에 구현이 필요할 때
 *                      }
 *                 ===> 값이 지정되어 있으면 => 명시적 초기화
 *                      구현으로 초기화를 하는 경우 => 초기화블록, 생성자
 *                                              ex) random(), Scanner...
 *     저장되는 순서
 *     기본값 => 명시적 초기값 => 초기화블록 => 생성자
 *             ----------------------------- 동시사용X
 *       ex) class ClassName{
 *              int a=100;
 *              {
 *                 a=200;
 *              }
 *              ClassName(){
 *                a=300;
 *              }
 *           }
 *           ==
 *           class ClassName(){
 *              int a=300;
 *           }
 *           
 *           a=0 -> a=100 -> a=200 -> a=300 ===> a=300으로 프로그램시작
 *           int a=300; 명시적 초기화랑 같으면 명시적 초기화가 효율적
 *           
 *           믈래스에서는 선언 / 선언과 동시에 초기화만 가능
 *           int a;
 *           a=100; 
 *           ==> 선언 후 대입 == 구현 => 명시적 초기화 불가, 초기화 블록 사용
 *     
 *	  메소드 - 특정 기능을 수행하는 명령문의 집합 (검색, 목록출력, 페이징, 예약, 결제, 가입, 탈퇴...)
 *           재사용 가능 = 구조적인 프로그램
 *           기능별로 나눠져있다 => 수정 편리
 *           반복기능 제거
 *           메소드 역할 - 기능 수행
 *                      다른 클래스와 연결 (객체지향프로그램-여러개의 클래스를 모아 조립하는 프로그램)
 *                                     CBD Component=클래스(한개의 기능)을 여러개 만들어 조립
 *                                     묶어주는 역할=Container
 *           메소드 형식 - [접근지정어] [옵션] 리턴형 메소드명(매개변수목록){
 *                         //구현        ----데이터형
 *                         return 값 => 리턴형에 해당되는 값
 *                         //void 결과값이 없는 경우 => return 생략 가능 => 컴파일러에서 자동 추가
 *                      }
 *                    **접근지정어 - private : 자신의 클래스안에서만 사용 => 다른 클래스와 연결 불가 => 멤버변수(데이터보호)
 *                                default : 키워드가 없는 상태 => 같은 패키지안에서만 접근가능
 *                                protected : 같은 패키지안에서만 접근가능 + 상속을 받은 경우 다른 패키지 접근가능
 *                                public : Open Mode => 패키지와 관계없이 모든 클래스에서 접근가능
 *                              **private - 접근거부 => 다른 클래스에서 사용불가 ex)개인정보, 멤버변수
 *                                          메소드이용(변수 기능) - 메모리 저장 public set변수명()
 *                                                            메모리 읽기 public get변수명()
 *                                                            변수는 메모리 값에 저장 => 노출, 변경, 상실방지
 *                                                            메소드에는 주소값만 저장 => 노출X
 *                                                            ==> 캡슐화 - 변수는 숨기고 메소드로 접근
 *                                public - 접근가능 => 다른 클래스와 연결가능 ex)생성자, 믈래스, 메소드, 인터페이스
 *                                접근지정어 사용방법
 *                                  -클래스 - [접근지정어] [옵션] class ClassName{
 *                     	                      다른 클래스와의 연결을 위해 대부분 public
 *                                            옵션 - static(공통), abstract(추상), final(종단)  
 *                                          }
 *                                   생성자 - [접근지정어] 클래스명(){
 *                                             대부분 public
 *                                          }
 *                                   멤버변수 - [접근지정어] [옵션] 데이터형 변수명;
 *                                            클래스, 배열
 *                                            접근지정어는 주로 private - 개인정보, 회사정보, 노출X
 *                                                         public - 라이브러리클래스, 테이블연결, 윈도우관련
 *                                            옵션은 static - 공통으로 사용하는 변수 => 메모리공간 1개만 생성 
 *                                          **일반 => 인스턴스 : 메모리가 따로따로
 *                                             데이터 묶음 => static => 데이터관리
 *                                               ex)회원목록, 게시판목록 => 하나의 메모리로 사용 
 *                                   메소드 - [접근지정어] [옵션] 리턴형 메소드명(매개변수목록){
 *                                             다른 클래스와의 연결을 위해 대부분 public
 *                                             옵션 - static(공통 ex)한글변환,암호화), abstract, 사용X
 *                                             리턴형 - 기본형, 배열, 클래스 => 요청 결과값
 *                                             매개변수 - 0이상 => 없을수도 많을수도 (단, 3개이상은 배열,클래스로) => 사용자요청값          
 *                                          }
 *                      경우의 수
 *                        리턴형(요청처리값) 매개변수(사용자요청값)
 *                              O              O         => String
 *                                                          String substring(int s, int e)
 *                                                          s부터 e까지 자른 문자열  
 *                              O              X         => String trim() => 공백 제거한 문자열
 *                                                          Strind toUpperCase() => 대문자 변환 문자열
 *                              X              O         => void System.out.println(String s) s 출력
 *                                                          메소드 자체 처리 -> 결과값 없음 void
 *                                                          오라클에 추가, 수정, 삭제
 *                              X              X         => 사용빈도 거의 없
 *                                                          void System.out.println() 줄바꿈
 *           메소드 호출
 *             class A{
 *                private int a;
 *                           private int b;
 *                private static int c; ===> 저장
 *                public void aaa(){}
 *                public static void bbb(){} ===> 저장
 *                public int ccc(){}
 *                public static int ddd(){} ===> 저장
 *                
 *                           static => 메소드/변수는 컴파일시에 저장
 *                인스턴스 => 메모리를 따로 만들어야 저장 new
 *             }
 *             static 저장 - Method Area
 *                         -------
 *                            0   ===> c  호출 A.c
 *                         -------
 *                          bbb()         호출 A.bbb() bbb=클래스명,메소드명
 *                         -------
 *                          ddd()         호출 == 리턴형이 있는 경우 같거나(권장) 큰 결과값을 받아서 저장
 *                         -------               int result=A.ddd() 
 *                          
 *             A aa=new A();
 *                Stack          Heap(객체영역)
 *              ----aa----
 *                0x100 ===> 메모리주소에 있는 메소드나 변수를 가지고 온다 => .은 메모리주소 접근 연산자
 *              ----------  0x100---------
 *                                   0  ===> a 호출 객체명.변수명 aa.a
 *                               ---------
 *                                   0  ===> b 호출 객체명.변수명 aa.b
 *                               ---------
 *                                 aaa()       호출 객체명.메소드명 aa.aaa()
 *                               ---------
 *                                 ccc()       호출 리턴형이 있는 경우
 *                               ---------         int result=aa.ccc()
 *           메소드 수행
 *             public int aaa(){
 *                수행문장1
 *                수행문장2
 *                수행문장3
 *                return 10;
 *             }         
 *             int a=aaa(); => 호출 
 *             수행문장1
 *             수행문장2
 *             수행문장3
 *             ==> a에 10 대입 => 메소드 아래 문장 수행
 *             호출 => 메소드에 있는 모든 문장 수행 => 호출된 위치로 복귀
 *             *메소드는 호출시마다 메소드 처음부터 다시 수행
 *         **프로그램에서는 특별한 경우가 아니면 static메소드는 사용빈도가 거의 없다
 *           static 메소드 - 데이터베이스 / 네트워크 프로그램 제어
 *           인스턴스 메소드 - 웹
 *               
 *   패키지/import
 *   데이터 보호 - 캡슐화
 *   상속/포함
 *   오버라이딩/오버로딩
 *   ==================객체지향프로그램
 *   +예외처리/클래스 종류/라이브러리 사용법/화면구현
 *   
 *   ***개념 - 면접
 *      1.형식 2.사용방식(메소드호출,초기화) 3.조립 => 기능 ==> 요구사항분석
 *      
 *                  
 */
public class 클래스구성요소_변수 {
	//저장이 안됨 => 인스턴스 new 이용해서 저장
	/*
	 *	인스턴스 == 객체
	 *	- 클래스의 내용(메소드, 변수)을 메모리에 저장한 상태 => 각자 따로 저장 => new 이용
	 *
	 * 	인스턴스 - 변수 / 메소드 (대부분 인스턴스)
	 * 	static - 변수 / 메소드
	 * 
	 * 	class A{
	 *	   private int a=10; ===> 객체 자신이 가지고 있는 변수
	 *	   private static int b=20; ===> 객체마다 공통으로 사용되는 변수
	 *
	 *	   public void aaa(){ ===> 객체 자신이 가지고 있는 메소드
	 *	      ccc() / a / b 사용가능
	 *	   }
	 *	   public statiac void bbb(){ ===> 객체마다 공통으로 사용되는 메소드
	 *	      b만 사용가능 => static은 static으로 선언된 것만 사용가능
	 *	      aaa()/ccc()/a 는 new로 객체 생성 후 사용가능
	 *         ex) A aa=new A(); 객체 생성
	 *             aa.aaa() 사용
	 *             aa.ccc()
	 *             aa.a
	 *	   }
	 *	   public void ccc(){ ===> 객체 자신이 가지고 있는 메소드
	 *	      aaa() / a / b 사용가능
	 *	   }
	 *	   인스턴스 메소드는 클래스에 있는 모든 데이터, 메소드 사용가능
	 *	}
	 *	메소드는 호출되면 return이 있는 곳까지 수행
	 */
	public void aaa() {
		System.out.println("aaa() 진입");  //1
		bbb();
		System.out.println("aaa() 종료");  //6
		//return 생략, 컴파일러가 자동추가 => void
	}
	public void bbb() {
		System.out.println("bbb() 진입");  //2
		ccc();
		System.out.println("bbb() 종료");  //5
		//return 생략, 컴파일러가 자동추가 => void
	}
	public void ccc() {
		System.out.println("ccc() 진입");  //3
		System.out.println("ccc() 종료");  //4
		//return 생략, 컴파일러가 자동추가 => void
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// main은 static이니까 static 아닌 인스턴스 클래스를 부르기 위해 객체 생성
		클래스구성요소_변수 aa=new 클래스구성요소_변수();
		
		//객체 생성 후 호출
		aa.aaa();
	}

}
