//숫자를 입력받아 3~5는 봄, 6~8은 여름, 9~11은 가을, 12,1,2는 겨울,
//그 외의 숫자를 입력한 경우 잘못입력을 출력하는 프로그램을 작성하라. if-else 문
import java.util.Scanner;
public class 제어문_문제_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("월 입력(1~12) >>");
		int month=scan.nextInt();
	
		if(month>=1 && month<=12) {
			if(month>=3 && month<=5) {
				System.out.println(month+"월은 봄입니다");
			}else if(month>=6 && month<=8) {
				System.out.println(month+"월은 여름입니다");
			}else if(month>=9 && month<=11) {
				System.out.println(month+"월은 가을입니다");
			}else{
				System.out.println(month+"월은 겨울입니다");
			}
		}else {
			System.out.println("잘못된 입력입니다");
		}
	}

}
