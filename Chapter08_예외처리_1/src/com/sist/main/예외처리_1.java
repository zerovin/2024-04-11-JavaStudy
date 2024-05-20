package com.sist.main;
/*
 *  8장 263page
 *  예외처리
 *   최적화 - 실행속도
 *   가독성 - 보기 편하고 쉽게
 *   견고성 - 프로그램 비정상 종료 방지 => 예외처리 => 에러 사전 방지
 *   
 *  에러 - 수정이 불가능한 에러 ex)메모리 부족, 쓰레드 충돌
 *  예외처리 - 소스상에서 수정 가능 ex)파일명, URL 오류
 *  
 *  에러가 발생하는 요소
 *  - 사용자 입력 부주의 : 잘못된 입력이 있는 경우 ex)정수입력=>문자열입력
 *                    if 조건문 처리 => 유효성 검사
 *  - 프로그래머 실수 ex)배열범위초과, 반복수행, 클래스 메모리할당없이 사용, 변수 초기화 전 사용
 *  
 *  예외처리 - 사전에 에러 방지
 *           비정상 종료 방지 => 정상 상태 유지
 *           예외처리 => 에러발생시 에러부분 건너뜀 => 에러를 수정해주는 건 아님
 *  
 *  예외처리 방법
 *  - 예외 복구** - try ~ catch
 *                try{} : 정상수행문장
 *                catch{} : 에러발생시 처리 => 복구 
 *  - 예외 회피** - 처리하지 않고 예외 발생시 시스템에 의해 처리
 *                메소드 뒤에 첨부
 *                메소드() throws 예외처리
 *  - 임의 발생 - 테스트용으로 주로 사용 => 프로그램이 정상적인지 확인
 *              throw => 에러를 발생시켜서 견고한지 확인
 *  - 사용자 정의 예외 - 자바에서 지원하지 않는 예외처리 존재 => 필요시 직접 예외처리 제작, 사용
 *  
 *  예외처리 상속도 => 처리하는 순서 존재
 *                 Object
 *                 - Throwable 예외처리 최상위 클래스
 *                   - Error 처리 불가능
 *                           종료 후 다시 시작
 *                   - Exception 처리 가능(소스상)
 *                               ex) 0으로 나누는 경우, URL/IP/파일명 오류
 *                     - CheckedException 컴파일시에 예외처리 확인
 *                                        반드시 예외처리를 한 후에 사용
 *                                      **java.io : 파일
 *                                      **java.sql : 오라클 연결
 *                                        java.lang : 쓰레드 관련
 *                                      **java.net : 네트워크
 *                                        Open API : Jsoup
 *                                      **웹(네트워크) => 반드시 예외처리
 *                                        javac
 *                                        9장 라이브러리 => 자바에서 지원하는 클래스 집합
 *                                                      java.lang, java.util, java.io
 *                                                      java.net, java.sql
 *                                                      javax.http.servlet => 웹 관련 => JSP
 *                     - UnCheckedException 컴파일시 예외처리를 확인하지 않음
 *                                          필요시 예외처리
 *                                          사용자 입력을 받는 경우**
 *                                          실행시 에러
 *                                          java
 *       
 *  CheckedException - 반드시 예외처리를 해서 사용, 컴파일시 예외처리가 되어있는지 확인
 *                     FileNotException - 파일관련
 *                     IOException - 파일관련
 *                     SQLException - SQL(오라클연동)
 *                     malformedURLException - URL(network)
 *                     ClassNotFoundException - 클래스
 *                       => Class.forName() => 클래스명으로 메모리 할당 => 리플렉션
 *                     InterruptedException - 쓰레드관련
 *                       ex)Thread.sleep() => 충돌방지, 쓰레드는 프로그램안에서 여러개의 프로그램을 동시에 실행
 *  UnCheckedException - 필요시에만 예외처리, 예외처리 생략가능
 *                       ArrayIndexOutOfBoundsException - 배열범위 초과
 *                       ClassCastException - 클래스 형변환
 *                       ArithmeticException - 산술 오류
 *                         ex)0으로 나누는 경우
 *                       NullPointerException - 메모리 할당이 없는 상태에서 객체 사용시, 클래스에서 발생
 *                         ex)String* - 멤버변수 선언시 null 자동초기화, 윈도우관련, 크롤링데이터 없는 경우
 *                         
 *  예외처리 상속도
 *              Object : 최상위 클래스
 *                |
 *            Throwable
 *                |
 *        ------------------
 *        |                |
 *      Error           Exception
 *                         |
 *              -------------------------
 *              |                       |
 *      (CheckedException)     (UnCheckedException)
 *              |                       |
 *         IOException   RuntimeException:실행시 에러 => 필요시 예외처리
 *        SQLException                  |
 *      =>반드시 예외처리(필수)   ArryaIndexOutOfBoundsException
 *                                ClassCastException
 *                                
 *  프로그램 제작
 *  1.설계 => 벤치마킹 (웹, 게임) => 모방 => 새로운 내용
 *      ex)영화-영화관주변정보, 캠핑-레시피, 자격증-교재추천, 예약/결제폼단순화
 *  2.변수설정 => 초기화 필요 여부
 *    - 생성자 (인스턴스)
 *    - static => static 블록 이용
 *    - 사이트 화면에 출력된 데이터를 확인 => 필요시 데이터 설계
 *  3.기능설정 => 메소드
 *    - 예상되는 에러 추출 => 예외처리 => 프로그램 종료방지
 *    ex)메뉴, 버튼, 입력...
 *    
 *  ***예외처리 실무 => 상위클래스 한개 이용
 *                  상속도의 상속을 내리는 클래스는 하위클래스의 예외를 포함 => 한번에 처리가능
 *                  ex) 배열 선언 => ArrayIndexoutOfBoundsException
 *                      정수 입력 => 정수 입력이 안된 경우 NumberFormatException
 *                      나누기 => ArithmeticException
 *                      --------------예외처리를 1.나눠서 잡는다 2.통합해서 잡는다
 *                      1. 나눠서 잡는다
 *                          try{
 *                             배열 선언
 *                             정수 입력
 *                             나누기
 *                             ========> 실행 가능한 프로그램 서술
 *                          }catch(ArrayIndexoutOfBoundsException){ //다중조건문 else if느낌
 *                          
 *                          }catch(NumberFormatException){
 *                          
 *                          }catch(ArithmeticException){
 *                          
 *                          }
 *                      2. 통합해서 잡는다
 *                         try{
 *                             배열 선언
 *                             정수 입력
 *                             나누기
 *                             ========> 실행 가능한 프로그램 서술
 *                          }catch(RuntimeException){
 *                          
 *                          }
 *                          
 *                          try{
 *                             배열 선언
 *                             정수 입력
 *                             나누기
 *                             ========> 실행 가능한 프로그램 서술
 *                          }catch(Throwable){
 *                          
 *                          }
 *                          
 *                          ==> 상속도 상에서 위로 올라갈수록 예외처리 기능을 많이 가지고 있다
 *                              하위의 예외처리기능을 포함
 *                              
 *  예외처리 형식 - 에러 발생시 건너뛰는 역할 => 에러를 처리해주는 것은 아님
 *               try{
 *                  정상수행을 할 수 있는 소스** => 평상시 코딩 => 일부러 에러발생시키지 마세요
 *                  1.에러가 없는 경우 => try에서 종료
 *                  2.에러가 있는 경우 => 해당 에러를 등록한 catch를 찾는다 => 이후 아래문장 수행
 *               }catch(예외처리클래스){
 *                  에러 발생시 복구하는 위치
 *               }
 *               
 *               ex)
 *                   try{
 *                      문장 1
 *                      문장 2
 *                      문장 3
 *                      문장 4
 *                      문장 5
 *                   }catch(예외처리){
 *                      문장 6 => 에러 발생시 처리하는 부분 => 에러가 없는 경우 catch 수행X
 *                   }
 *                   문장 7
 *                   문장 8
 *                   프로그램 종료
 *                   ==> 오류가 없는 경우 1 -> 2 -> 3 -> 4 -> 5 -> 7 -> 8 -> 프로그램종료
 *                       오류가 있는 경우(문장3오류) 1 -> 2 -> 6 -> 7 -> 8 -> 프로그램종료
 *                       예외처리를 하지 않는 경우(문장2오류) 1 -> 2 -> 프로그램종료 
 *               
 *               try절 - 정상수행이 가능한 소스 코딩을 하는 부분 => 모든 프로그램 소스가 서술
 *                      1개만 설정
 *               catch절 - try 수행중 발생하는 에러 처리 => 복구
 *                        여러개 사용가능
 *                        에러 발생시 1개의 catch만 수행 => 다중조건문과 비슷
 *                        catch를 찾아서 처리하는 역할 => JVM
 *               소스 전체 예외처리
 *                 try{
 *                    모든 소스
 *                 }catch(){
 *                    예상되는 부분만 예외처리 가능
 *                 }
 *                 문장
 *                 문장...
 *               예상되는 부분만 예외처리
 *                 try{
 *                    문장 => 자주 에러가 발생하는 부분
 *                 }catch(Exception){
 *                 
 *                 }
 *  
 *                                          
 *                                         
 *  Front - 자바스크립트 중심 JavaScript => JQuery Ajax NodeJS VueJs ReactJS
 *                       TypeScript    ---------3=>4,5버전 -----------NextJS
 *  Back - 프로그램언어 Java => JSP MVC Spring Spring-Boot
 *                          데이터베이스(오라클 MySql MariaDB)
 *                   AI => 파이썬, 머신러닝, 딥러닝
 *                         -----데이터분석 => 넘파이/판다스/MatPlotLib(시각화)=>seabon
 *    
 */
class A{
	
}
class B extends A{
	
}
public class 예외처리_1 {
	String name; //null 
	public void display() {
		name=name.substring(0,1); //문자열이 없는데 잘라달라해서 오류
		System.out.println(name); //java.lang.NullPointerException 에러
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Thread.sleep(1000); 쓰레드 관련부분은 컴파일시 예외처리를 확인하기 때문에 예외처리 안하면 오류 
		int[] arr=new int[2];
		arr[0]=10;
		//arr[2]=20; //에러발생 => 배열 인덱스 범위초과 => 종료 => 비정상 종료
		// output창 java.lang.ArrayIndexOutOfBoundsException 에러발생
		System.out.println(arr[0]+","+arr[1]);
		
		A a=new A();
		// A가 가지고 있는 메소드 호출해서
		//B b=(B)a; //java.lang.ClassCastException 에러발생
		// 에러 A a=new B(); B b=new B();로 작성
		
		//System.out.println(10/0); // java.lang.ArithmeticException 에러발생
		
		예외처리_1 c=new 예외처리_1();
		c.display(); //java.lang.NullPointerException 에러발생
	}

}
