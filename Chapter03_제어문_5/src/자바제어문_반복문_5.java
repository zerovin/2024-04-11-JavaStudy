/*
 *	A~Z 사이에서 사용자가 입력한 알파벳이 몇번째 있는지 확인 
 * 
 */
import java.util.Scanner;
public class 자바제어문_반복문_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("알파벳 입력:");
		char input=scan.next().charAt(0);
		int count=1;
		
		for(char c='A';c<='Z';c++) {
			if(input==c) {
				break; //조건 만족시 종료 
			}
			count++; //종료시까지 카운트, index확인
		}
		System.out.println(input+"는(은)"+count+"번째 있습니다");
	}

}
