package com.sist.util;
//UpDown
import java.util.*;
public class 라이브러리_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.컴퓨터 난수발생 1~100
		// 2.사용자 입력을 받아서 난수 맞추기
		// Math.random() => 보완 => Random
		Random r=new Random();
		int com=r.nextInt(100)+1; //1~100
		
		//사용자 입력
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.print("1~100 사이 정수입력 >> ");
			int user=scan.nextInt();
			
			if(user<1 || user>100) {
				System.out.println("잘못된 입력입니다");
				continue; //처음부터 다시실행 => while문 조건식으로
			}
			
			//힌트
			if(com>user) {
				System.out.println("입력값보다 큰 값을 입력하세요");
			}else if(com<user) {
				System.out.println("입력값보다 작은 값을 입력하세요");
			}else {
				System.out.println("Game over!!");
				break;
			}
		}
	}

}
