//년도를 입력 받아 윤년인지 아닌지를 판별하는 방법을 if~else문으로 사용하라

/*
 *	윤년조건
 *	4년마다
 *	100년마다제외
 *	400년마다 
 */
import java.util.Scanner;
public class 제어문_문제_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("연도입력:");
		int year=scan.nextInt();
		
		if((year%4==0 && year%100!=0)||year%400==0) {
			System.out.println(year+"년은 윤년입니다");
		}else {
			System.out.println(year+"년은 윤년이 아닙니다");
		}
	}

}
