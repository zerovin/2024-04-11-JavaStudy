/*
 *	단일 조건문
 *	형식) if(조건문){  ==> 반드시 true/false => 부정연산자, 비교연산자, 논리연산자만 사용
 *			실행문장 ==> 조건이 true일때만 수행
 *		 }
 *
 *	1. 정수 입력을 받아서 짝수/홀수 처리
 */
import java.util.Scanner;
public class 제어문_단일조건문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int num;
		System.out.print("정수 입력:"); //입력요청
		num=scan.nextInt(); //변수에 저장
		
		if(num%2==0) { //짝수조건
			System.out.println(num+"는(은) 짝수입니다");
		}
		
		if(num%2!=0) { //홀수조건
			System.out.println(num+"는(은) 홀수입니다");
		}
	}

}
