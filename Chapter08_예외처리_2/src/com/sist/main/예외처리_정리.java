package com.sist.main;
/*
 *  예외처리가 필요한 곳
 *  - 컴파일시에 예외처리 여부 확인하는 프로그램 => 반드시 예외처리 후 사용 (메소드) => CheckedException
 *    java.io 입출력 / java.sql 데이터베이스 / java.net 네트워크 / javax.http.servlet 웹
 *  - 예외처리 여부를 확인하지 않는 프로그램 => UnCheckedException
 *    java.lang
 *     => 예외처리 필수는 아님, 생략가능 => 사용자의 에러가 많이 발생하는 위치는 예외처리 하는게 좋음
 *        ex) 사용자 입력창 TextField =>int 문자열=>int
 *        
 *  try~catch~finally 사용
 *  throws가 있는 경우 처리
 *  ---------------------Exception / Throwable => 모든 예외처리 클래스 포함
 *                       Exception < Throwable
 *  ex) throws Exception
 *      try{
 *      
 *      }catch(Exception e){}
 *      
 *  Throwable > Exception > 기타
 *    ex)
 *       throws Throwable
 *       => throws Exception => 예외처리 상속도상 작은 클래스로 받아서 오류
 *  Throwable - Spring AOP에서 사용
 *  ***상속이 있는 경우 상위클래스가 하위클래스보다 크다 (상속도 위로 올라갈수록 크다)
 *               Object
 *                  |
 *              Throwable
 *                  |
 *          ------------------
 *          |                |
 *        Error          Exception
 *                           |
 *                 ----------------------
 *                 |                    |
 *             예외처리 필수          예외처리 미필수
 *               컴파일시         실행시 - 입력값을 받아봐야 오류여부 알 수 있음
 *
 *  예외 발생이 많은 경우 - ex) 웹 NumberFormatException
 *                         브라우저 => 자바
 *                         무조건 문자열로 데이터 받음 => 다른 데이터형으로 변환과정에서 예외가능성
 *                    부분적 예외처리 가능
 *                      ex) 문장12345678 중 예외 예상 부분만 try~catch절로 감싸서 처리
 *                          for문 안에 try~catch도 사용가능 => 크롤링시 적합하지 않으면 skip하게
 *                          ==> try~catch절은 원하는 위치에서 원하는 만큼 사용가능 
 *                     
 *                    
 *  
 *      
 */
public class 예외처리_정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
