package com.sist.main;
/*
 *  throw - 임의로 에러 발생
 *          형식)
 *              throw new 예외클래스() => catch로 이동
 *              throw 아래 코딩 불가능, throw에서 catch로 이동하기 때문
 *  catch는 예외처리 크기에 따라 순서가 존재 => 상속도 기반
 *  throws 문장은 예외처리 순서가 없다 => ,로 구분
 *  
 *  try{
 *     1234=>error=>catch로 이동
 *     567
 *  }catch(Exception e){
 *     8
 *  }
 *  9 10
 *  ==> 4에서 에러발생시 4567 수행X
 *      자바는 코드를 읽어내려간 후 다시 올라가지 않는다 => 반복문, 메소드이용
 *      
 *  catch를 사용하지 않는 프로그램을 제작하는게 제일 좋음
 *  단, 에러가 있을 수도 있으니 대비 => 예외처리
 *  
 */

import java.io.*;
import java.util.*;
public class 예외처리_2 {
	public void disp() throws Exception,IOException,ArrayIndexOutOfBoundsException{
		// Exception 쓸거면 뒤에 하위클래스 애들 굳이 쓸 필요X
		// Exception - 어떤 에러날지 예측불가
		// IOException, ArrayIndexOutOfBoundsException - 어떤 에러날지 예상가능
	}
	public static void main(String[] args) /*throws Exception*/{
		// TODO Auto-generated method stub
		try {
			FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
			//파일관련라이브러리 IOException => CheckedException 예외처리 필수			
		}catch(/*IOException*/ Exception e) { //가급적 catch절은 여러개보다 큰 클래스로 통합
			
		}
		
		Scanner scan=new Scanner(System.in);
		System.out.print("양수만 입력 >> ");
		int no=scan.nextInt();
		try {
			if(no<0) { //음수입력이 예외처리는 아님, 임의로 발생시킴
				// 견고한 프로그램 => 에러발생시 처리가 되고 있는지 테스트
				// 애플리케이션 테스트
				// 개발자 => 단위테스트 - 메소드마다 정상작동하는지 테스트 => JUnit
				throw new IllegalArgumentException("음수는 사용할 수 없습니다!!"); //catch 이동
				// "" 얘가 getMessage로 출력됨
				// throw 예외를 던진다 => 직접 예외의 catch 호출가능
				// catch절을 실행시키기 위해 일부러 예외발생
				// 이 위치는 다른 수행문장 작성시 오류
			}
			System.out.println("no="+no); // 위에서 예외임의발생해야 catch로 이동하고 이 문장이 수행되지 않음
		}/*catch(IllegalArgumentException e) { //입력값이 잘못된 경우
			System.out.println(e.getMessage()); 
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}*/catch(Exception e) { //상위클래스는 catch절 중 먼저 작성시 오류, 코드 위에서부터 읽어 내려오기 떄문
			// 기타, 예상하지 못한 예외를 위해 상위클래스 아래에 두기 / Exception catch절만 둬도 같은 결과
			System.out.println(e.getMessage());
		}
		//반드시 실행되어야하는 문장이 있는 경우
		System.out.println("프로그램 종료");
	}

}
