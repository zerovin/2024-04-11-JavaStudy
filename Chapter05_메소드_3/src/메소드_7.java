/*
 *	달력 출력
 *	1. 절차적언어
 *	2. 메소드화 => 구조적 프로그램 => 클래스 => 객체지향 프로그램
 *
 *  구조적 프로그램을 위한 최소한의 3가지
 *  - 입력부분 => 메소드
 *  - 처리부분 => 메소드 : 세분화
 *  - 출력부분 => 메소드
 */
import java.util.*;
public class 메소드_7 {
	// 입력부분 => 반복제거
	static int input(String msg) {
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력 >> ");
		return scan.nextInt();
	}
	
	// 처리부분
	static int getWeek(int year, int month) {
		// 1. 전년도까지의 총 일수 구하기
		int total=((year-1)*365)+(year-1)/4-(year-1)/100+(year-1)/400; //윤년조건
		
		// 2. 전달까지의 총 일수 구하기
		int[] lastday= {31,28,31,30,31,30,31,31,30,31,30,31};
		// 윤년이면 2월 == 29일
		if(isYear(year)) { // isYear 메소드 호출
			lastday[1]=29;
		}else {
			lastday[1]=28;
		}
		for(int i=0;i<month-1;i++) {
			total+=lastday[i];
		}
		
		// 3. +1 == 1일자의 요일 확인
		total++;
		
		// 4. 1일 요일 구하기 => 총 일수%7
		int week=total%7;
		
		return week;
	}
	// 윤년계산
	static boolean isYear(int year) { // 다른 클래스에서 재사용이 가능하도록
		if((year%4==0)&&(year%100!=0)||year%400==0) { // 입력한 연도가 윤년이라면
			return true;
		}else {
			return false;
		}
	}
	
	// 출력부분
	static void print(int year, int month, int week) {
		int[] lastday= {31,28,31,30,31,30,31,31,30,31,30,31};
		// 요일 출력부분
		System.out.println(year+"년도"+month+"월");
		String[] strWeek= {"일","월","화","수","목","금","토"};
		for(String w:strWeek) {
			System.out.print(w+"\t");
		}
		System.out.println();
		
		// 실제 달력 숫자 출력
		for(int i=1;i<=lastday[month-1];i++) {
			// 1. 공백출력 => 처음 1번만 출력
			if(i==1) {
				for(int j=0;j<week;j++) {
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t",i);
			// 일요일이면 다음줄에 출력
			// 요일확인
			week++;
			if(week>6) { // week==7 이면 일요일 
				System.out.println();
				week=0;
			}
		}
	}
	static void process() {
		int year=input("년도");
		int month=input("월");
		
		int week=getWeek(year, month);
		print(year,month,week);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 재사용을 위해 가급적 main안에서 메소드 작성하지마세요 => 다른 클래스에서 호출불가하니까
		
		/*
		// 입력부분
		Scanner scan=new Scanner(System.in);
		// 1. 연도 입력
		System.out.print("년도 입력 >> ");
		int year=scan.nextInt();
		// 2. 월 입력
		System.out.print("월 입력 >> ");
		int month=scan.nextInt();

		// 처리부분 => 요일구하기
		// 1. 전년도까지의 총 일수 구하기
		int total=((year-1)*365)+(year-1)/4-(year-1)/100+(year-1)/400; //윤년조건
		
		// 2. 전달까지의 총 일수 구하기
		int[] lastday= {31,28,31,30,31,30,31,31,30,31,30,31};
		// 윤년이면 2월 == 29일
		if((year%4==0)&&(year%100!=0)||year%400==0) { // 입력한 연도가 윤년이라면
			lastday[1]=29;
		}else {
			lastday[1]=28;
		}
		for(int i=0;i<month-1;i++) {
			total+=lastday[i];
		}
		
		// 3. +1 == 1일자의 요일 확인
		total++;
		
		// 4. 1일 요일 구하기 => 총 일수%7
		int week=total%7;
		
		// 요일 출력부분
		System.out.println(year+"년도"+month+"월");
		String[] strWeek= {"일","월","화","수","목","금","토"};
		for(String w:strWeek) {
			System.out.print(w+"\t");
		}
		System.out.println();
		
		// 실제 달력 숫자 출력
		for(int i=1;i<=lastday[month-1];i++) {
			// 1. 공백출력 => 처음 1번만 출력
			if(i==1) {
				for(int j=0;j<week;j++) {
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t",i);
			// 일요일이면 다음줄에 출력
			// 요일확인
			week++;
			if(week>6) { // week==7 이면 일요일 
				System.out.println();
				week=0;
			}
		}
		*/
		process();
		
	}

}
