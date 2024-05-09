package com.sist.main;

import java.util.Scanner;

class Student2{
	private int kor, eng, math, total; //지역변수가 전역변수보다 우선
	private double avg;
	private char score;
	//Student2에 선언되는 모든 메소드에서 사용가능
	//멤버변수 - 프로그램 종료시에 사라짐 => 모든 메소드에서 사용 가능
	//지역변수 - 메소드 종료시 사라져서 return, 매개변수로 다른 메소드에 전달
	
	//입력
	public int input(String msg) {
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력 >> ");
		return scan.nextInt();
	}
	
	//total
	public void totalData() {
		total=kor+eng+math;
	}
	
	//avg
	public void avgData() {
		avg=total/3.0;
	}
	
	//score
	public void scoreData() {
		switch((int)avg/10) {
			case 10: case 9:
				score='A';
				break;
			case 8:
				score='B';
				break;
			case 7:
				score='C';
				break;
			case 6:
				score='D';
				break;
			default:
				score='F';
		}
	}
	
	//print
	public void print() {
		System.out.println("국어점수 : "+kor);
		System.out.println("영어점수 : "+eng);
		System.out.println("수학점수 : "+math);
		System.out.println("총점 : "+total);
		System.out.printf("평균 : %.2f\n",avg);
		System.out.println("학점 : "+score);
	}
	
	//실행
	public void process() {
		kor=input("국어");
		eng=input("영어");
		math=input("수학");
		totalData();
		avgData();
		scoreData();
		print();
	}
}
public class 성적계산_멤버변수형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student2 s=new Student2();
		s.process();
	}

}
