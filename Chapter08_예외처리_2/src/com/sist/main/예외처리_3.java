package com.sist.main;
import java.util.*;
// 사용자 정의 예외처리
// Exception / RuntimeException 둘 중 하나 상속받아 사용
// Exception - CheckedException
// RuntimeException - UnCheckedException
class MinusException extends Exception{ // 예외처리 전체를 상속받아 처리
	//MinusException 쓸려면 예외처리 필수 => Exception 상속받았기 때문
	//RuntimeException 상속 받았으면 해당 메소드 사용시 예외처리 생략가능
	public MinusException(String msg) {
		super(msg); 
	}
}
public class 예외처리_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("양수만 입력 >> ");
		int no=scan.nextInt();
		try {
			//catch는 자바에서 제공하는 예외클래스는 인식, 사용자 정의 예외처리는 인식 못함
			//사용자 정의 예외처리는 throw로 예외 임의 발생
			if(no<0) { //음수입력이 에러사항은 아니지만 에러시 확인을 위해 throw 이용해 예외 임의 발생
				throw new MinusException("음수는 사용불가!!");
				// throw => 사용자 정의 예외처리를 만든 경우 catch가 인식하지 못하니 throw로 catch절 호출
			}
		}catch(MinusException e) {
			System.out.println("에러메세지:"+e.getMessage());
			System.out.println("======= 에러 발생 위치 =======");
			e.printStackTrace();
		}
	}

}
