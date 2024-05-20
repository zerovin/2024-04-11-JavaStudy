package com.sist.main;
/*
 *  266page 예외처리 상속도
 *  상위 예외처리 클래스일수록 예외처리 기능을 많이 가지고 있다
 *  catch 1개로 여러개 처리 => Exception - 모든 예외처리 기능을 가지고 있다
 *                         RuntimeException - 실행시 예외
 *   
 *  CheckedException - 컴파일시 예외처리가 있는지 확인 => 반드시 예외처리해서 사용
 *                     ex)파일입출력, 오라클연결, 크롤링, 네트워크, 웹 => 예외처리필수
 *  UnCheckedExcpetion - 실행시 예외처리 => 생략가능
 *  
 *  예외처리 종류 - CheckedException => 반드시 예외처리 
 *                - ClassNotFoundException : 클래스를 찾을 수 없는 경우 
 *                   => class.forName("패키지명.클래스명"); => JSP/Spring
 *                - IOException : 입출력 (메모리, 파일, 네트워크)
 *            *** - SQLException : 오라클 실행 => SQL, 데이터베이스 연동
 *                - InterruptedException : 쓰레드 관련
 *                - MalformedURLException : 네트워크 관련
 *                  
 *              RuntimeException => 아래에 있는 모든 예외처리 가능
 *                - NumberFormatException : 정수변환 Integer.parseInt() => 웹, 네트워크, 윈도우 => 정수개념X
 *                - ClassCastException : 클래스 형변환 문제
 *                - ArrayIndexOutOfBoundsException : 배열 인덱스 초과
 *                - NullPointerException : 클래스에 주소값이 배정이 안된 상태
 *                - ArithmeticException : 0으로 나눈 경우
 *                - IllegalArgumentException : 매개변수 밧이 다른 값이 전송 된 경우 => 웹에서 전송받은 경우 
 *              -------------------------------------------------------------------------------------
 *              => 위의 모든 예외 catch 하나로 처리하는 기능 : Exception / Throwable
 *              
 *  예외처리 방식 - 모든 프로그램 언어에 존재 ex)자바스크립트, 오라클
 *    - try~catch => 가장 많이 사용되는 예외처리 268page
 *                   try{
 *                      정상수행 => 에러가 의심되는 소스
 *                   }catch(예외처리 클래스){
 *                      에러 발생시 처리 => 가벼운 예외처리(소스에서 수정이 가능한 에러)
 *                                      에러(예외처리에서 처리 불가)
 *                   }
 *                   try => 전체사용, 부분적 사용 가능
 *                          try{.....}catch(){.....} => 전체처리
 *                          
 *                          .....
 *                          .....
 *                          try{}catch(){} => 의심되는 부분만 처리
 *                          .....
 *                          ..... 
 *                        
 *                   
 *    - throws => 라이브러리에 주로 사용
 * 
 *  **에러 : 소스상에서 수정이 불가능한 에러
 *          ex)브라우저문제, 메모리부족, 이클립스오류
 *    예외처리 : 소스상에서 수정 가능(잡을 수 있는 가벼운 에러)
 *             ex)파일명 오류, IP 오류, 매개변수 값 전송 오류 ...
 *  
 *   
 */
public class 예외처리_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		//전체 예외처리 => 오류발생시 for문 종료
		try {
			for(int i=1;i<=10;i++) {
				int n=(int)(Math.random()*3); //0,1,2
				System.out.println(i/n); //n이 0일 경우 오류
				//오류발생시 => for문 종료 => catch로 
			}
		}catch(Exception e) {
			System.out.println("오류발생:"+e.getMessage()); //getMessage() 어떤 오류발생했는지 확인
		}
		*/
		
		//부분 예외처리 => 오류가 발생해도 for문은 10번 다 돌아감
		for(int i=1;i<=10;i++) {
			try {
				int n=(int)(Math.random()*3);
				System.out.println(i/n); //0으로 나눠 오류발생시 => catch수행 => for증가식으로 이동
			}catch(Exception ex) {
				System.out.println("오류발생:"+ex.getMessage());
			}
		}
		
		/*
		 *  for 안에서 예외처리
		 *  ex) 크롤링 => 모든 HTML이 동일하지 않을 경우(같은 형식, 공백데이터) / 모든 부분이 필요하지 않을 경우 => skip 
		 */
	}

}
