/*
 *	11.	정수 입력을 받아서 60이상 합격 =>불합격  if~else 
 */
import java.util.Scanner;
public class 문제_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int num=0;
		
		//유효성 검사
		while(true) {
			System.out.println("점수입력 >> ");
			num=scan.nextInt();
			if(num<0 || num>100) {
				System.out.println("잘못된 입력입니다");
				continue;
			}
			break;
		}
		
		//결과값 출력
		if(num>=60) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
	}
}
