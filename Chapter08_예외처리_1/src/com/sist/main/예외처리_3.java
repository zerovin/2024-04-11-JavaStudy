package com.sist.main;
/*
 *  263page
 *  예외 : 프로그램에 의도하지 않은 문제가 생기는 상황
 *        => 발생된 위치에서 비정상 종료
 *        => 비정상 종료 방지하고 정상종료가 가능하게 만드는 방법 => 예외처리
 *  문제 발생
 *  - 사용자 부주의 - 입력을 잘못하는 경우
 *  - 프로그램 결함 - 프로그래머 실수
 *  - 해결책
 *    1.조건문 사용 => if => 사전예방
 *    2.조건문으로 안되는 경우 => 예외처리 이용
 *  예외처리
 *  - 직접처리** : 프로그래머가 에러발생시 처리 => 복구
 *            try~catch try - 소스코딩 / catch - 에러발생시 처리 => 예상되는 에러처리(여러개 사용가능)
 *  - 간접처리 : 이미 소스 코드가 완료된 상태 => try~catch 사용이 어렵기 때문에 간접처리 이용
 *            시스템에 의해 처리가능 => 회피, 에러를 피해감
 *            throws - 예상되는 에러 등록 => 호출시 처리하고 사용
 *                     ex)라이브러리에 많이 존재 => 라이브러리 메소드 호출시 예외처리 후 사용
 *        
 *  문장 1 => error => 종료 => catch는 한번 수행
 *  문장 2 => error
 *  문장 3 => 정상수행
 */
import java.util.*;
public class 예외처리_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner scan=new Scanner(System.in);
			System.out.print("첫번째 정수 입력 >> ");
			//문자열로 받는다 (윈도우, 웹 => 정수개념X => 문자열로 받음)
			String num1=scan.next();
			
			System.out.print("두번째 정수 입력 >> ");
			String num2=scan.next();
			
			//첫번째 에러
			// 에러발생 의심부분 1
			int n1=Integer.parseInt(num1); // Integer.parseInt() 문자열을 정수로 변환
			
			// 에러발생 의심부분 2
			int n2=Integer.parseInt(num2); // 유효성 검사
			
			// 에러발생 의심부분 3
			int n3=n1/n2; //0으로 나누었을시의 예외처리를 catch절에서 잡지 않으면 0으로 나눌시 비정상종료
			// 예외처리보다는 if문 처리가 편리
			
			System.out.println("n1="+n1);
			System.out.println("n2="+n2);
			System.out.println("n3="+n3);
			
			// 변수 num1, num2, n1, n2, n3는 try{}에서만 사용할 수 있는 블록/지역변수
			
		}/*catch(NumberFormatException e) { //정수변환이 안된 경우 처리
			System.out.println("정수만 입력할 수 있습니다");
		}catch(ArithmeticException e) { //0으로 나누는 경우 처리
			System.out.println("0으로 나눌 수 없습니다");
		}*/
		catch(RuntimeException e) { // NumberFormatException, ArithmeticException 둘다 포함 => RuntimeException
			System.out.println("사용자 입력 오류 발생");
		}
		
		//정상수행 가능, 사용자가 입력을 잘못한 경우 => 에러처리X
		//=> 입력값에 따라 에러여부가 다름 => 강제로 예외처리X => 필요시 => 예외처리 생략가능
		//실행을 해봐야 아는 에러 RuntimeException
		System.out.println("프로그램 종료"); //정상종료
		//프로그램 정상종료가 가능하게 만든다 => 윈도우, 브라우저 실행상태 유지
	}

}
