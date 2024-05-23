package com.sist.util;
// java.lang 제외하고 나머지는 반드시 import
import java.util.*;
//import 한개 사용시 ex) import java.util.Scanner;
//두개이상 *사용 ex) import java.util.*;
public class 라이브러리_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		for(int i=1;i<=10;i++) {
			System.out.print(i+"번 학생 학점 : ");
			int score=r.nextInt(5)+1; //1~5
			switch(score) {
				case 1:
					System.out.println('A');
					break;
				case 2:
					System.out.println('B');
					break;
				case 3:
					System.out.println('C');
					break;
				case 4:
					System.out.println('D');
					break;
				case 5:
					System.out.println('F');
					break;
			}
			
		}
	}

}
