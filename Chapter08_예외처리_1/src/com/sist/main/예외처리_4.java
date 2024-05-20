package com.sist.main;
/*
 *  try절 - 정상수행이 가능한 문장
 *  catch절 - try 안에 문장을 수행하는 과정에서 에러발생시 처리
 *           여러개 사용가능, 예외처리 클래스 크키 => 상속도 상위클래스일수록 에러처리기능이 많다
 *           ex)                          Exception
 *                                            |
 *                                    RuntimeException
 *                                            |
 *               NumberFormatException, NullPointerException, ClassCastException
 *               Exception > RuntimeException > NumberFormatException, NullPointerException, ClassCastException
 *          
 */
import java.util.*;

class A1{
	
}
class B1 extends A1{
	
}
public class 예외처리_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			A1 a=new A1();
			B1 b=(B1)a; //오류발생 => ClassCastException
			
		}/*catch(ArithmeticException e) { //0으로 나눌시 에러처리
			
		}catch(ArrayIndexOutOfBoundsException e) { //배열범위 초과시 처리
			
		}catch(NumberFormatException e) { //문자열을 정수로 변환시 생긴 에러처리
			
		}*/catch(RuntimeException e) {
			//에러처리범위가 넓은 애가 제일 위에 있으면 에러, 가장 나중에 처리하게 둬야 에러방지
			//전체를 잡아주는 예외처리 => RuntimeException
		}
		System.out.println("프로그램 종료");
	}

}
