// 11. 입력 받은 값이 짝수인지 홀수인지 판별하는 메소드를 구현하시오
import java.util.Scanner;
public class 문제_11 {
	static boolean evenOdd(int a) {
		boolean result=false;
		if(a%2==0) {
			result=true;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력 >> ");
		int num=scan.nextInt();
		boolean even=evenOdd(num);
		if(even) {
			System.out.println(num+"은 짝수입니다");
		}else {
			System.out.println(num+"은 홀수입니다");
		}
	}

}
