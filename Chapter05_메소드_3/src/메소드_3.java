// 사용자가 년 월 일 전송 => 출력
// 받아서 출력 String or 메소드에서 출력 void

import java.util.*;
public class 메소드_3 {
	// 리턴형 없이 void
	//재사용
	static void print(int year, int month, int day) {
		System.out.println(year+"년도 "+month+"월 "+day+"일");
	}
	
	//반복제거
	static int input(String msg) {
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력 >> ");
		return scan.nextInt();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("====== 1.재사용 ======");
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력 >> ");
		int year=scan.nextInt();
		System.out.print("월 입력 >> ");
		int month=scan.nextInt();
		System.out.print("년도 입력 >> ");
		int day=scan.nextInt();
		
		print(year,month,day);
		
		System.out.println("====== 2.반복제거 ======");
		year=input("년도");
		month=input("월");
		day=input("일");
		print(year,month,day);
		
	}

}
