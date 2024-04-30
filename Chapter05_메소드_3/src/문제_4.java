//년도를 입력 받아 윤년여부를 확인하는 프로그램 작성

import java.util.*;
public class 문제_4 {
	//년도 입력 메소드
	static int input(){
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력 >> ");
		int a=scan.nextInt();
		return a; //입력값 반환
	}
	//윤년처리
	static void isYear(int year) {
		if((year%4==0&&year%100!=0)||year%400==0) {
			System.out.println(year+"는 윤년입니다");
		}else {
			System.out.println(year+"는 윤년이 아닙니다");
		}
	}
	//출력
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 년도 입력
		//Scanner scan=new Scanner(System.in);
		/* 
		 *	클래스 => 키보드 입력받아 메모리저장
		 *	System.in 이용해서 키보드 입력값 가저옴 => 모든 문자는 정수형으로 받음
		 *	System.in-키보드 입력값(inputStream), System.out-화면출력(outputStream) 
		 * 
		 */
		/*
		System.out.print("년도 입력 >> ");
		int year=scan.nextInt();
		
		if((year%4==0&&year%100!=0)||year%400==0) {
			System.out.println(year+"는 윤년입니다");
		}else {
			System.out.println(year+"는 윤년이 아닙니다");
		}
		*/
		int year=input();
		isYear(year);
	}

}
