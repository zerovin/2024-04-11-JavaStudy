/*
 *	메소드 안의 변수
 *	-지역변수, 매개변수 => 메소드가 종료되면 자동으로 사라짐
 *	 사라지지 않는 변수 제작 => 매개변수 필요X => 멤버변수 - 모든 메소드에서 사용가능 
 * 
 */

import java.util.Scanner;

public class 메소드정리_6 {
	//메소드 밖 클래스 영역에 변수 선언 == 멤버변수 - 프로그램 종료시까지 유지, 모든 메소드에서 공통사용
	//지역변수 - 메소드 안에서만 사용 => 다른 메소드로 넘기려면 리턴형 필요
	//매개변수 - 메소드 안에서만 사용
	//멤버변수 - 클래스 안에서 사용, 같은 클래스라면 다른 메소드끼리도 공유 가능
	
	static int[] kor=new int[3];
	static int[] eng=new int[3];
	static int[] math=new int[3];
	static int[] total=new int[3];
	static double[] avg=new double[3];
	static int[] rank=new int[3];
	static char[] score=new char[3];
	//클래스 블록에 선언되면 해당 클래스 안 모든 메소드는 해당 변수 사용가능 => 프로그램 종료시에 메모리에서 해제
	//매개변수를 따로 주지 않아도 공통으로 사용하는 멤버변수(공유변수) 적용해서 오류X
	static void userInput() {
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<kor.length;i++) {
			//1.입력			
			System.out.print((i+1)+"번째 국어 >> ");
			kor[i]=scan.nextInt();
			System.out.print((i+1)+"번째 영어 >> ");
			eng[i]=scan.nextInt();
			System.out.print((i+1)+"번째 수학 >> ");
			math[i]=scan.nextInt();
			
			//2. 총점
			total[i]=kor[i]+eng[i]+math[i];
			//3. 평균
			avg[i]=total[i]/3.0;
			//4. 학점
			switch(total[i]/30) {
				case 10: case 9:
					score[i]='A';
					break;
				case 8:
					score[i]='B';
					break;
				case 7:
					score[i]='C';
					break;
				case 6:
					score[i]='D';
					break;
				default:
					score[i]='F';
			}
		}
	}
	static void rankChange() {
		for(int i=0;i<total.length;i++) { 
			rank[i]=1;
			for(int j=0;j<total.length;j++) {
				if(total[i]<total[j]) {
					rank[i]++;
				}
			}
		}
	}
	static void print() {
		for(int i=0;i<3;i++) {
			System.out.println(kor[i]+" "+eng[i]+" "+math[i]+" "+total[i]+" "+avg[i]+" "+score[i]+" "+rank[i]);
		}
	}
	static void process() {
		userInput();
		rankChange();
		print();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
	}

}
