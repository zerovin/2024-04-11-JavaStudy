// 4.두 정수의 나눗셈 결과를 구하는 메소드를 구현하시오(실수)
import java.util.Scanner;
public class 문제_4 {
	static double div(int a, int b) {
		double result=0.0;
		try {
			result=a/(double)b;
		}catch(Exception e) {
			System.out.println("0으로 나눌 수 없습니다!!");
		}
		return result; // 0일때 Infinity출력 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("첫번째 정수 입력 >> ");
		int num1=scan.nextInt();
		System.out.print("두번째 정수 입력 >> ");
		int num2=scan.nextInt();
		
		double result=div(num1,num2);
		System.out.println(result);
	}

}
