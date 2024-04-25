/*
 *	달력
 *	사용자 입력(년도/월)
 *	처리 = 해당 요일 구하기 소스코딩/라이브러리
 *	출력 
 *	ex) 예약, 일정표
 * 
 *	프로그램
 *	=> 변수 연산자 제어문 라이브러리 => 기능 => 저장해서 재사용 
 *  
 */
import java.util.*;
public class 문자열배열_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 사용자 입력 => 배열 응용
		Scanner scan=new Scanner(System.in);
		
		// 연도 입력
		System.out.print("년도 입력 >> ");
		int year=scan.nextInt();
		
		// 월 입력
		System.out.print("월 입력 >> ");
		int month=scan.nextInt();
		
		/*
		// ================= 처리 - 요일 구하기
		// 1년도 1월 1일 월요일 ~ 요청한 전년도까지 일수
		int total=(year-1)*365+(year-1)*4-(year-1)*100+(year-1)*400;
		
		//요청한 달의 전달까지 일수
		int[] lastday= {31,28,31,30,31,30,31,31,30,31,30,31};
		// 윤년 => 29, 윤년X => 28
		if((year%4==0 && year%100!=0) || year%400==0) {
			lastday[1]=29;
		}else {
			lastday[1]=28;
		}
		for(int i=0;i<month-1;i++) {
			total+=lastday[i];
		}
		
		//1일자의 요일
		total++;
		
		// 요일
		int week=total%7;
		*/
		
		// =================== 처리 - 라이브러리
		Calendar cal=Calendar.getInstance();
		// 날짜 변경
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);
		
		// 요일
		int week=cal.get(Calendar.DAY_OF_WEEK); // 1=일 2=월 3=화...
		week--;
		
		// 마지막 날
		int lastday=cal.getActualMaximum(Calendar.DATE);
		
		// ================== 달력출력
		System.out.println(year+"년 "+month+"월\n\n");
		String[] strWeek= {"일","월","화","수","목","금","토"};;
		for(String s:strWeek) {
			System.out.print(s+"\t");
		}
		System.out.println();
		for(int i=1;i<=lastday/*[month-1]*/;i++) {
			if(i==1) {
				for(int j=0;j<week;j++) {
					System.out.print("\t"); // 공백출력
				}
			}
			// 달력 출력
			System.out.printf("%2d\t",i);
			// 토요일 출력 => 한줄 내리기
			week++;
			if(week>6) {
				week=0;
				System.out.println();
			}
		}
		
	}

}
