// 9. 년도를 입력받아서 윤년인지 여부를 확인하는 메소드를 구현하시오
import java.util.Scanner;
public class 문제_9 {
	static boolean isYear(int a) {
		boolean result=false;
		if((a%4==0 && a%100!=0) || a%400==0) {
			result=true;
		}else {
			result=false;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력 >> ");
		int year=scan.nextInt();
		boolean yyy=isYear(year);
		if(yyy) {
			System.out.println(year+"는 윤년입니다");
		}else {
			System.out.println(year+"는 윤년이 아닙니다");
		}
		
	}

}
