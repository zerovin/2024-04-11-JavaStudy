import java.util.*;
public class 달력만들기_전역변수 {
	static int year,month,week,lastday; // 전역변수로 사용시 지역변수 재선언 주의!! 색깔로 구분
	static void userInput() {
		// 1. 사용자입력 or default(Date)
		Scanner scan=new Scanner(System.in); // Scanner=F final클래스
		System.out.print("년도 입력 >> ");
		/*int*/ year=scan.nextInt();
		// year 전역변수로 써야해서 지역변수 재선언X
		System.out.print("월 입력 >> ");
		/*int*/ month=scan.nextInt();
		// month 전역변수로 써야해서 지역변수 재선언X
	}
	static void getWeek() {
		// 2. 요일 구하기 => 사용자 정의 or 라이브러리
		Calendar cal=Calendar.getInstance(); // Calendar=A abstract 추상클래스 상속,확장가능
		// Calendar클래스 메모리 할당
		// new를 안쓰면 추상클래스
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1); // 라이브러리 month 0번부터 시작
		cal.set(Calendar.DATE, 1);
		// 요일
		/*int*/ week=cal.get(Calendar.DAY_OF_WEEK); // 라이브러리 week는 0번부터가 아니라 1번부터 시작
		// week 전역변수로 써야해서 지역변수 재선언X
		week=week-1;
		// 마지막날
		/*int*/ lastday=cal.getActualMaximum(Calendar.DATE); // 입력한 달의 (윤년계산된)마지막 날짜를 가져옴
		// lastday 전역변수로 써야해서 지역변수 재선언X
	}
	static void print() {
		String[] strWeek= {"일","월","화","수","목","금","토"};
		System.out.println(year+"년 "+month+"월");
		for(String s:strWeek) {
			System.out.print(s+"\t");
		}
		System.out.println("\n"); // 두줄 줄바꿈
		for(int i=1;i<=lastday;i++) {
			if(i==1) { // 시작일 앞 공백
				for(int j=0;j<week;j++) {
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t",i);
			week++;
			if(week>6) { // week = 0~6
				System.out.println();
				week=0;
			}
		}
	}
	static void process() {
		userInput();
		getWeek();
		print();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
	}

}
