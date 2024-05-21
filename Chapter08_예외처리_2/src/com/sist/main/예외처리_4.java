package com.sist.main;
/*
 *  멀티 예외처리
 *    catch를 여러개 사용 => catch 하나로 통합
 *     
 */
public class 예외처리_4 {
	// throws 예외1,2,3 => 예외1,2,3이 예상되니 사용시 처리하고 쓰세요 알려는 드릴게~ => 에러발생시 대처
	// 처리는 사용하는 개발자에게 맡기는 프로그램 => 떠맡기기 ex)라이브러리
	public void display() throws NumberFormatException,NullPointerException,ArithmeticException{
		
	}
	public void print() throws NumberFormatException,NullPointerException,ArithmeticException{
		display();
	}
	public void print2() throws Exception{ //라이브러리의 경우 예외를 알기 힘드니 주로 Exception 샤용
		display();
	}
	public void print3() {
		//직접처리
		try {
			display();
		}catch(NumberFormatException e) {
			
		}catch(NullPointerException e) {
			
		}catch(ArithmeticException e) {
			
		}
	}
	public void print4(){
		try {
			display();
		}catch(Exception e) { // 상위클래스로 통합
			
		}
	}
	public void print5() {
		try {
			display();
		}catch(NumberFormatException | NullPointerException | ArithmeticException e) { // |로 통합
			
		}
	}
	// throws => 알림 "~에러가 발생할겁니다" => throws 있는 메소드사용시 throws로 다시알림, 직접처리
	// try~catch => 직접처리 => 알림 줄 필요X
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 예외처리 필요한 라이브러리 사용시 예외처리 안하면 오류 => 마우스오버 => throws / try~catch 자동완성기능 이용
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
