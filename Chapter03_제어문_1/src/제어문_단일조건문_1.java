// 정수입력을 받는다 => 양수/음수인지 확인해서 출력
import java.util.Scanner;
public class 제어문_단일조건문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 		// 스캔-변수생성-값입력-변수초기값-조건문
		Scanner scan=new Scanner(System.in);
		int num;
		System.out.print("정수 입력=");
		num=scan.nextInt();
		
		if(num>=0) {
			System.out.println(num+"은(는) 양수입니다");
		}
		
		if(num<0) {
			System.out.println(num+"은(는) 음수입니다");
		}
	}

}
