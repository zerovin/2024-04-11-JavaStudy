//Scanner 클래스를 이용하여 2자리의 정수(10~99사이)를 입력받고,
//십의 자리와 1의 자리가 같은 지 판별하여 출력하는 프로그램을 작성하라.
import java.util.Scanner;
public class 제어문_문제_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.print("두자리 정수 입력(10~99):");
			int num=scan.nextInt();
			
			if(num>=10 && num<=99) {
				if(num%11==0) {
					System.out.println(num+"의 십의 자리와 일의 자리는 같습니다");
					//break;
				}else {
					System.out.println(num+"의 십의 자리와 일의 자리는 다릅니다");
				}
			}else {
				System.out.println("두자리의 정수가 아닙니다");
				continue;
			}
		}
		
	}

}
