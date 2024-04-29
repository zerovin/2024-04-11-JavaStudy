// 12. 3의 배수를 판별하는 메소드를 구현하시오
import java.util.Scanner;
public class 문제_12 {
	static boolean three(int a) {
		boolean result=false;
		if(a%3==0) {
			result=true;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력 >> ");
		int num=scan.nextInt();
		boolean bCheck=three(num);
		if(bCheck) {
			System.out.println(num+"은 3의 배수입니다");
		}else {
			System.out.println(num+"은 3의 배수가 아닙니다");
		}
		
	}

}
