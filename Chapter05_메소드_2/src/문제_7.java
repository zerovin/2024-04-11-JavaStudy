// 7. 문자열을 거꾸로 출력하는 메소드를 구현하시오
import java.util.Scanner;
public class 문제_7 {
	static void reverse(String s) {
		System.out.println("입력값:"+s);
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
		System.out.println("\n라이브러리:"+new StringBuffer(s).reverse()); // 라이브러리
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("문자 입력 >> ");
		String s=scan.next();
		reverse(s);
	}

}
