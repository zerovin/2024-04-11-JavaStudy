/*
 *	달력만들기
 *	1.년도/월 year/month
 *	2.요일구하기 year/month/week
 *	3.출력 year/month/week
 *	 
 */
// 멤버변수없이 메소드만 => 리턴형, 매개변수
// 메소드 공통으로 사용되는 변수가 있는지 확인 => 멤버변수
import java.util.*;
public class 멤버변수_활용2 {
	static int year,month,day,week; //멤버변수
	static int input(String msg) {
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력 >> ");
		return scan.nextInt();
	}
	static int getWeek() {
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, day);
		
		week=cal.get(Calendar.DAY_OF_WEEK);
		return week; //1부터 출력 이라 strWeek인덱스 0번 공백
	}
	static void print() {
		String[] strWeek= {"","일","월","화","수","목","금","토"}; // 지역변수
		//DAY_OF_WEEK 1부터 출력 이라 strWeek인덱스 0번 공백
		System.out.printf("%d년도 %d월 %d일 %s요일입니다\n",year,month,day,strWeek[week]);
	}
	/*
	//입력
	static int input(String msg) {
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력 >> ");
		return scan.nextInt();
	}
	
	//요일구하기
	static int getWeek(int year, int month, int day) {
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, day);
		
		int week=cal.get(Calendar.DAY_OF_WEEK);
		return week; //1부터 출력 이라 strWeek인덱스 0번 공백
	}
	
	//출력
	static void print(int year, int month, int day, int week) {
		String[] strWeek= {"","일","월","화","수","목","금","토"}; //DAY_OF_WEEK 1부터 출력 이라 strWeek인덱스 0번 공백
		System.out.printf("%d년도 %d월 %d일 %s요일입니다\n",year,month,day,strWeek[week]);
	}
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int year=input("년도");
		int month=input("월");
		int day=input("일");
		int week=getWeek(year, month, day);
		print(year, month, day, week);
		*/
		year=input("년도"); //멤버변수 사용시 재선언X
		month=input("월");
		day=input("일");
		week=getWeek(); //멤버변수 사용시 매개변수 전달X
		print();
		
	}

}
