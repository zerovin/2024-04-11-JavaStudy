//사용자로부터 두개의 정수(시작,끝)를 입력받아 시작(포함)해서 
// 끝(포함)까지의 곱을 출력하는 프로그램을 작성하시오. 

import java.util.Scanner;
public class 문제_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("시작 숫자 >> ");
		int start=scan.nextInt();
		System.out.print("끝 숫자 >> ");
		int end=scan.nextInt();
		int x=1;
		
		for(int i=start;i<=end;i++) {
			x*=i; //처리
		}
		System.out.println(start+"부터 "+end+"까지의 곱은 "+x);
	}	
	//오류처리 ex)시작숫자<끝숫자
}
