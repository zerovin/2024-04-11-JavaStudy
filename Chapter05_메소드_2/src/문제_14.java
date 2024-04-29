// 14. 메소드를 정의하여 입력받은 숫자를 거꾸로 뒤집은 수를 출력하는 프로그램을 작성하시오
import java.util.Scanner;
public class 문제_14 {
	static void reverse(int num) {
		System.out.println(num);
		String s=String.valueOf(num); //모든 데이터형을 문자형으로 변환
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력 >> ");
		int num=scan.nextInt();
		reverse(num);
	}

}
