package com.sist.main;
/*
 *  9장 메소드
 *      java.lang
 *      java.util
 *  10장 자료구조
 *      웹 => 크롤링
 *      배열대체 => 컬렉션 / 제네릭스
 *  11장 파일입출력
 *  12장 java.sql*** => 오라클 연동
 *  ----------------------------사용자 정의 메소드X
 *  
 *   1.데이터형 / 변수 / 연산자 / 제어문
 *   2.클래스 구성요소 - 멤버변수 static / 메소드 / 생성자
 *   3.재사용 - 상속 / 포함
 *   4.클래스 종류 - 추상클래스 / 인터페이스
 *   5.예외처리 - try~catch / throws
 *   ---------------------------자바 기본 문법
 *   6.라이브러리
 *   7.조립 - 라이브러리 이용해서 프로그램 제작
 *   -------------------------------------------웹 1~7 사용
 *   자바는 출력의 형태만 다름 - 윈도우, 도스, 브라우저
 *   브라우저 - 출력 Java+HTML => 분리 => MVC => Spring
 *            기술 JavaScript
 *            배포 AWS(리눅스)
 *   데이터베이스 라이브러리 - MyBatis / JPA
 *   Full Stack - Ajax, VueJS, React(React-Query), Redux(React-MVC구조)
 *   서버분리 - 역할별로 서버 따로 제작 => MSA구조
 *   데이터분석 - 파이썬 / 넘파이 / 판다스 / MatPlotLib / 브라우저-장고
 *   ----------------------------
 *   자바 70% / 데이터베이스 20% => 자바/오라클
 *   취업자격조건 Spring(Spring-Boot), Vue/React(React-Query), MyBatis, JPA
 *      우대사항 리눅스, MSA, 정보처리기사(산업기사)
 *  
 */

/*
 *  예외처리 - 에러발생에 대한 사전 방지 프로그램
 *           비정상 종료 방지, 정상수행이 가능하도록
 *           에러발생시 자동수정X, 에러부분 건너뛰기 
 *           에러부분 문장 => 컴파일시에 무시(통과) => 예외처리
 *  에러발생처리 1.조건문 우선 고려
 *           2.예외처리 - 조건문으로 처리가 어려운 경우
 *  에러발생이유 - 프로그래머 실수
 *               ex)배열인덱스초과, 파일명오류... => 테스팅
 *             사용자 입력 오류
 *               ex)유효성검사 => 자바스크립트
 *  에러 종류 - Error : 수정이 불가능한 에러
 *                    ex)메모리 부족, 이클립스 오류...
 *           Exception : 소스에서 수정이 가능한 에러 => 가벼운 에러, 
 *                       ex)IP오류, 크롤링 URL오류, 파일명오류, 라이브러리 로드오류...
 *  정상처리(예외처리)방법
 *    **직접처리 - 프로그래머가 에러를 직접 잡아서 복구 => 예외 복구 => catch
 *               try~catch~finally
 *    **간접처리 - 떠맡기기, 메소드 호출시 처리 => 예측되는 에러만 선언 => 라이브러리, 복잡한 소스가 있는 경우
 *               메소드() throws 예외종류 => 메소드를 호출해서 사용하려면 선언된 예외를 처리하고 호출해야한다
 *               복구X, 예외를 피해간다 => 예외 회피
 *    - 임의발생 - 테스트, 에러발생시 견고하게 짜여졌는지 에러 임의 발생 => 많이 사용하지는 않는다
 *    - 사용자 정의 - 자바에서 전체적인 예외처리를 지원하지 않기 때문에 필요시 직접 제작해서 사용 => 사용빈도는 거의 없음
 *    
 *  catch에는 순서가 존재 - 상속도 클래스 크기에 따라 큰 클래스가 아래로
 *  throws는 순서X
 *  예외처리 상속도 - CheckedException - 반드시 예외처리
 *                                   컴파일시 예외처리 확인
 *                UnCheckedException - 필요시 처리
 *                                     실행시 처리 ex)사용자 입력값을 받아서
 *                                     
 *  상속도
 *                     Object => java.lang.* => 모든 클래스의 최상위 클래스, 모든 클래스는 Object 상속
 *                        |
 *                    Throwable => 예외처리 최상위 클래스 => Error / Exception 둘 다 처리가능
 *                        |
 *         ---------------------------------
 *         |                                |
 *       Error                          Exception => 예외처리 기본 클래스
 *                                          |
 *                        ------------------------------------------------
 *                        |                                              |
 *                 CheckedException                               UnCheckedException
 *                 컴파일시에 예외처리 확인                              컴파일시 예외처리 미확인
 *                 => 반드시 예외처리 사용                            => 필요시에만 예외처리(생략가능)
 *                                                                       |
 *                IOException - 입출력                    RuntimeException => UnChecked 최상위 클래스
 *                 ex)파일, 메모리                                          |
 *                                                    ArrayIndexOutOfBoundsException - 배열 인덱스 초과
 *             SQLException - 오라클연결/해체             
 *         ex)오라클연결시 서버주소, SQL문장, 입력값오류               NumberFormatException - 정수변환
 *            자바에서 입력값전송 => 오라클에서 결과값얻기        ex)웹, 윈도우 - 정수가 필요한데 문자열이 전송되었을 때
 *            오라클 : 전체 프로그램에서 사용되는 데이터저장          => Integer.parseInt() 문자열을 정수로 변환
 *                                                           Integer - 기본형int를 사용하기 쉽게 클래스화
 *            MalFormedURLException - IP,URL오류          기본 데이터형 클래스화 => Wrapper
 *             ex)크롤링(정적-Jsoup, 동적-셀레니움)             
 *                                                          ArithmeticException - 0으로 나누기
 *          InterruptedException - 쓰레드 관련
 *                                                    NullPointerException - 메모리 할당 없이 사용시
 *   ClassNotFoundException - 클래스이름으로 메모리 할당           
 *                  ex)new 대신                             ClassCastException - 클래스 형변환
 *  ------------------------------------자주 에러가 나는 경우 예외 처리 ---------------------------------------        
 *  
 *  사용법
 *    1) try ~ catch ~ finally
 *       try{
 *          정상적으로 실행되는 소스
 *          => 예상못한 에러가 발생할 수 있다 => 프로그래머의 실수 / 사용자 입력 문제
 *          => 에러예상 => 대비 
 *       }catch(예외처리클래스){ => 멀티 - 여러개 사용가능
 *          에러를 잡아서 복구
 *          에러확인** - getMessage() : 에러 메세지만 출력
 *                     printStackTrace() : 실행하는 과정, 에러위치 확인, 초반엔 얘 사용권장
 *          에러나는 경우 output창 확인
 *       }finally{ => 생략가능
 *          try/catch 상관없이 무조건 수행하는 문장
 *          ex) 파일닫기, 오라클닫기, 서버닫기
 *              => 가비지컬렉션이 바로바로 메모리 회수를 하지는 않기 때문에
 *                  에러가 나든말든 닫아야 서버 과부하 방지
 *       }
 *       
 *    2) throws 선언, 라이브러리
 *       메소드() throws 예외처리등록
 *         메소드를 호출하려면 등록된 예외처리를 하고 사용 => 떠맡기기
 *         이미 소스가 만들어진 경우
 *           ex) void disp() {
 *                  1; 2;
 *                  try{
 *                    3; 4; 5;
 *                  }catch(Exception e){}
 *                  6; 7; 8;
 *               }
 *               =====>
 *               vodi disp() throws Exception{
 *                  1; 2; 3; 4; 5; 6; 7; 8;
 *               }
 *         throws 문장
 *           ex) public void disp() throws ArrayIndexOutOfBoundsException,NumberFormatException,NullPointerException{}
 *               => 호출시에 등록된 예외처리를 한 후에 사용
 *               public void print(){
 *                  disp(); => 정상수행
 *                             UnCheckedException 등록시 예외처리 없이 사용가능
 *                             CheckedException 등록되면 예외처리 해야 사용가능
 *               }
 *               
 *               public void disp() throws Exception{} => Exception-CheckedException 포함 사용시 예외처리
 *               public void print(){
 *                  disp(); => 오류발생
 *               }
 *               ===>
 *               1.떠맡긴다
 *                 public void print() throws Exception{ => 시스템에 예외가능성을 알려만 준다
 *                    disp(); => 오류발생X
 *                 }
 *               ===>
 *               2.직접처리
 *                 public void print(){
 *                    try{
 *                       disp(); => 예외처리를 했기 때문에 오류발생X
 *                    }catch(Exception ex){}
 *                 }
 *               -----------------------------------------------
 *               public void disp() throws IOException,SQLException,InterruptedException,ClassNotFoundException{
 *                  disp();
 *               }
 *               1.떠맡긴다
 *                 public void print() throws IOException,SQLException,InterruptedException,ClassNotFoundException{
 *                    disp();
 *                 }
 *               ===>
 *               2.직접처리
 *                 public void print(){
 *                    try{
 *                       disp();
 *                    }catch(IOException e){
 *                    }catch(SQLException e){
 *                    }catch(InterruptedException e){
 *                    }catch(ClassNotFoundException e){
 *                    }
 *                 }
 *               ===> 예상되는 에러클래스가 많을 경우 => Exception으로 통합
 *                 public void print(){
 *                   try{
 *                      disp();
 *                   }catch(Exception e){
 *                   }
 *                 }
 *                 
 *               ====> 라이브러리 => 이미 소스 코딩이 되어있는 상태 => try~catch보다 throws가 더 편하다 => 유지보수
 *        
 *  라이브러리
 *    java.lang - 기본 사용 클래스
 *                Object, String, StringBuffer, Math, Wrapper
 *    java.util - 유용하게 사용하는 클래스
 *                StringTokenizer, Calendar, Date, Scanner
 *                *** List / Set / Map => 컬렉션
 *    java.io - 파일 관련 클래스
 *              FileReader, FileWriter
 *    java.sql - 데이터베이스 관련 클래스
 *               Connection, Statement, ResulteSet
 *          
 */ 
public class 예외처리_1 {
	//display() 호출시에 "이런 에러가 발생할 수 있다" 예상
	//사용시에는 반드시 예외처리를 하고 사용
	//throws 뒤에 예상되는 예외 등록 => 순서상관X
	//throws 뒤 예외등록은 보통 CheckedException 사용, UnCheckedException은 생략가능하니
	/*
	 *  try ~ catch - 초기화블록, 생성자, 메소드에서만 사용가능
	 *  throws - 생성자, 메소드에서만 사용가능, 초기화블록에서는 사용불가
	 *  
	 *  ***권장사항 - 가급적이면 try~catch 사용
	 *  ***라이브러리는 프로그래머에게 처리 요청 => throws 문장으로 메소드 정의
	 */
	public void display() throws ArrayIndexOutOfBoundsException,NumberFormatException,
	                             NullPointerException,IllegalAccessError{
		
	}
	public void print() throws ArrayIndexOutOfBoundsException,NumberFormatException,
                               NullPointerException,IllegalAccessError{
		display();
	}
	public void print2() throws Exception{
		display();
	}
	public void print3() {
		display(); //UnCheckedException 생략가능
	}
	public void print4() {
		try {
			display();
		}catch(ArrayIndexOutOfBoundsException e) {
			
		}catch(NumberFormatException e) {
			
		}catch(NullPointerException e) {
			
		}catch(IllegalAccessError e) {
			
		}
	}
	public void print5() {
		try {
			display();
		}catch(Exception ex) {
			
		}
	}
	public void disp() throws Exception{
		
	}
	public void print6() {
		//disp(); => Exception - CheckedException 포함 => 예외처리 필수
		try {
			disp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//예외처리는 축소할 수 없다 => 상속도
	public void print7() throws Throwable /*IOException*/ {
		// => 상속도 상의 하위클래스(축소)로 예외처리시 오류, 상위클래스(확대)가능
		//disp();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
