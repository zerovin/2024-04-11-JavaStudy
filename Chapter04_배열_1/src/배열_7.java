import java.util.Scanner;
public class 배열_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		// 년 월 일 => 결과값 무슨 요일인지
		System.out.print("년도 입력:");
		int year=scan.nextInt();
		
		System.out.print("월 입력:");
		int month=scan.nextInt();
		
		System.out.print("일 입력:");
		int day=scan.nextInt();
		
		// 요청 처리 => 요일 확인
		/*
		 *	※ 요일 구하기
		 *	   1. 1년 1월 1일부터 ~ 요청한 년도의 전년도까지의 총 일수
		 *	   2. 요청한 달의 전 달까지의 일수
		 *	   3. 요청한 일
		 *	   ===========> 1 + 2 + 3 = 총 일수
		 *	   4. 총 일수 % 7 => 요일
		 *	      0=일 1=월 2=화 ... 6=토
		 */
		char[] strWeek= {'일','월','화','수','목','금','토'};
		int[] lastday= {31,28,31,30,31,30,31,31,30,31,30,31};
		
		// 1. 1년 1월 1일부터 ~ 요청한 년도의 전년도까지의 총 일수
		int total=(year-1)*365+(year-1)/4-(year-1)/100+(year-1)/400;
		//                     --------------------------------------윤년계산
		
		// 2. 요청한 달의 전 달까지의 일수
		if((year%4==0 && year%100!=0)||(year%400==0)) { //윤년일때
			lastday[1]=29;	//2월은 29일
		}else {
			lastday[1]=28;
		}
		for(int i=0;i<month-1;i++) {
			total+=lastday[i];
		}
		
		//요청한 일
		total+=day;
		
		//요일 구하기
		int week=total%7;
		
		// 결과값 출력
		System.out.println(year+"년 "+month+"월 "+day+"일은 "+strWeek[week]+"요일입니다");
		
	}	

}
