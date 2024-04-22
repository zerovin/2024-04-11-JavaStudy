/*
	2.숫자를 입력받아 3~5는 봄, 6~8은 여름, 9~11은 가을, 12,1,2는 겨울,
	그 외의 숫자를 입력한 경우 잘못입력을 출력하는 프로그램을 작성하라.
	if-else 문과 switch 둘 다 이용해 볼 것.

	결과)
	달을 입력하세요(1~12) >> 9
	가을
	
	=> 다중 조건 / 선택문
		if~else if~else if~else - 다중조건문
		switch~case - 선택문
 		한 문장만 수행
 */
import java.util.Scanner;
public class 문제_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("달을 입력하세요(1~12) >> ");
		int num=scan.nextInt();
		
		//if-else
		System.out.println("======== if-else ========");
		if(num>=3 && num<=5) {
			System.out.println("봄");
		}else if(num>=6 && num<=8) {
			System.out.println("여름");
		}else if(num>=9 && num<=11) {
			System.out.println("가을");
		}else if(num==1||num==2||num==12){
			System.out.println("겨울");
		}else {
			System.out.println("잘못된 입력입니다");
		}
		
		
		//switch
		System.out.println("======== switch =========");
		switch(num) {
			case 3: case 4: case 5:
				System.out.println("봄");
				break;
			case 6: case 7: case 8:
				System.out.println("여름");
				break;
			case 9: case 10: case 11:
				System.out.println("가을");
				break;
			case 12: case 1: case 2:
				System.out.println("겨울");
				break;
			default:
				System.out.println("잘못된 입력입니다");
		}
	}

}
