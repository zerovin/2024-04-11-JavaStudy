package com.sist.main;
//에러메세지 출력
/*
 *  에러확인
 *  getMessage() - 에러내용만 출력
 *  printStackTrace() - 에러위치확인 => 권장
 *  
 *  Exception
 *  - IOException / SQLException / ClassNotFoundException / RuntimeException...
 *  
 *  RuntimeException - 실행시 예외처리의 모든 기능을 가지고 있다
 *  - ClassCastException / ArithmeticException / NullPointerException / NumberException
 *  
 *  ==> 상속 내리는 클래스가 받는 클래스보다 크다
 *      class A
 *      class B extends A   ==>   A>B
 *      => 클래스에서 클래스 상속은 확장
 *      
 *      interface A
 *      class B implements A   ==> A>B => 인터페이스도 클래스
 *      => 인터페이스에서 클래스 상속은 구현
 *         인터페이스는 구현이 안된 메소드를 가지고 있다 => 구현해서 완성된 클래스를 만들어 사용
 *      
 *      ClassCastException < RuntimeException < Exception < Throwable
 * 
 *  예외처리 클래스
 *  Exception - 예외처리의 최상위 클래스 => 모든 예외처리가 첨부
 *  
 *  에러 확인
 *  getMessage(), printStackTrace()**권장
 *  
 *  에러 발생시 처리 - output창(console)
 *  
 */
class AAA{
	
}
class BBB extends AAA{
	
}
public class 예외처리_7 {
	String msg; //null초기화 => null인 경우 연결하는 주소가 없어 메소드 사용불가 => NullPointerException
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//int a=Integer.parseInt(" 10"); //정수변환
			
			/*
			int[] arr=new int[2];
			arr[0]=10;
			arr[2]=20; //index 초과 0,1,2
			System.out.println(10/0);
			*/
			
			/*
			예외처리_7 b=new 예외처리_7();
			String s=b.msg.concat("Java"); // 오류발생 msg=null
			System.out.println(s);
			*/
			
			AAA a=new BBB();
			BBB b=(BBB)a; //ClassCastException
			//형변환시 반드시 생성자 일치
			
		}catch(Exception ex) {
			//Exception => 자바에서 지원하는 모든 오류 처리가능
			//Throwable => Error 도 출력 => 웹
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			//error가 자주나는 경우 try~catch
		}
	}

}
