// 10. 두수를 입력받아 큰 수를 출력하는 메소드를 구현하시오
import java.util.Scanner;
public class 문제_10 {
	static int more(int a, int b) {
		int result=0;
		if(a>b) {
			result=a;
		}else {
			result=b;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("첫번째 정수 입력 >> ");
		int num1=scan.nextInt();
		System.out.print("두번째 정수 입력 >> ");
		int num2=scan.nextInt();
		int res=more(num1,num2);
		System.out.println("더 큰 수는 "+res);
	}

}
