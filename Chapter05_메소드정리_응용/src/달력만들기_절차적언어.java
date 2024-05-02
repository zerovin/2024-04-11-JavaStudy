/*
 *	절차적 언어
 *	- 순차적으로 명령문 작성, 한줄식 번역, 출력
 *	  => 재사용이 어렵, 수정 불편, 기능 추가 불편
 *	  => 실무에서 사용X
 *
 *	메소드
 *	- 기능별로 나눠서 처리
 *	  => 변수가 메소드 안에서만 사용 => 리턴형/매개변수 고려 => 실무에서 사용X
 *	  => 전역변수 - 전체 메소드에서 사용하는 변수 선언 => 리턴형/매개변수 고려X => 실무에서 사용
 *	  
 *	  지역변수 - 메소드 블록 => 메소드 종료시 사라짐 ex)매개변수
 *	  전역변수 - 클래스 블록 => 프로그램 종료시 사라짐
 * 
 *	--------------------------------------------
 * 	aaa()
 *    => 변수 a
 *    => 변수 b
 *    => 변수 c
 *  bbb()
 *    => 변수 a
 *    => 변수 b
 *    => 변수 d
 *  ccc()
 *    => 변수 a
 *    => 변수 b
 *    => 변수 e
 *	===> a,b만 공통으로 쓰는 변수
 *       전역변수 : a,b
 *       지역변수 : c,d,e
 *       모든 변수를 전역변수,멤버변수로 쓰는건 아님
 */



// 문법 => C방식 => 자바실무X
// 메소드 => C++방식 => 자바실무X
// 전역변수 메소드 => 자바방식 => 자바실무O

// 학습순서 문법 => 메소드(재사용) => 프로그램제작(객체지향) => 전역변수(멤버변수,공유변수)

/*
 *	1.년도/월 => year/month
 *	2.요일 => year/month/week/i
 *	3.출력 => year/month/week/i
 *	====> year month week 전역변수 선언
 *	      for문안에 들어가는 루프변수 i는 지역변수
 */
import java.util.*;
public class 달력만들기_절차적언어 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 사용자입력 or default(Date)
		Scanner scan=new Scanner(System.in); // Scanner=F final클래스
		System.out.print("년도 입력 >> ");
		int year=scan.nextInt();
		System.out.print("월 입력 >> ");
		int month=scan.nextInt();
		
		// 2. 요일 구하기 => 사용자 정의 or 라이브러리
		Calendar cal=Calendar.getInstance(); // Calendar=A abstract 추상클래스 상속,확장가능
		// Calendar클래스 메모리 할당
		// new를 안쓰면 추상클래스
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1); // 라이브러리 month 0번부터 시작
		cal.set(Calendar.DATE, 1);
		// 요일
		int week=cal.get(Calendar.DAY_OF_WEEK); // 라이브러리 week는 0번부터가 아니라 1번부터 시작
		week=week-1;
		// 마지막날
		int lastday=cal.getActualMaximum(Calendar.DATE); // 입력한 달의 (윤년계산된)마지막 날짜를 가져옴
		
		// 3. 달력 출력
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

}
