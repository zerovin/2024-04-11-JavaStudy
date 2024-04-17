/*
 *	month
 *	1~12 ==> 이외는 else 처리(잘못된 입력) 
 * 
 */
import java.util.Scanner;
public class 제어문_조건문_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("월 입력(1~12):");
		int month=scan.nextInt();
		
		if(month>=1 && month<=12) { //정상적으로 입력이 된 경우
			
			//중첩조건문
			if(month==1||month==2||month==12) {
				System.out.println("겨울입니다");
			}
			if(month>=3 && month<=5) {
				System.out.println("봄입니다");
			}
			if(month>=6 && month<=8) {
				System.out.println("여름입니다");
			}
			if(month>=9 && month<=11) {
				System.out.println("가을입니다");
			}
		}else { //입력 실수, 잘못된 입력이 된 경우
			System.out.println("없는 달입니다.(잘못 입력되었습니다)");
		}
	}

}
