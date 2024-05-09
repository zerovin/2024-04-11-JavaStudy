package com.sist.main;
/*
 * 메소드 - 문장, 단락
 *  - 기능별 분리 - 오류처리
 *               재사용
 *               수정편리
 *               추가가능
 *               유지보수
 *               분업
 *  - 역할 - 다른 클래스와 연결해서 사용
 *          ex) 사람클래스 ======== 자판기클래스
 *                       동전투입   음료선택
 *                                음료뽑기
 *                                거스름돈
 *         객체지향프로그램 - 여러개의 클래스를 생성 후 상호연결해서 사용
 *	       사이트분석 - 기능 확인 => 메소드
 *                   데이터 추출
 *                   ex) 중복없는 난수 3개 발생 int[] com
 *                       사용자 입력 int[] user
 *                       입력값 난수 비교 com/user
 *                       힌트 com/user/s/b
 *                       종료여부확인 s==3
 *                       ==> com/user/s==전역변수 b==지역변수 => 반복유무기준
 *                           기능 확인 후 변수설정(데이터확인)
 *                   ex) 년도/월 입력 year/month
 *                       요일 구하기-윤년처리 year/month/week
 *                       달력출력 year/month/week
 *                       ==> year/month/week==전역변수
 */
//클래스는 public이 기본 => 하나의 파일에서 public은 한개만 사용 가능
import java.util.*;
//Diary.class, 클래스구성요소_메소드.class => 저장과 동시에 컴파일
class Diary{ // 아래 public class가 이어서 여기는 public 사용불가
	public int input(String msg) {
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력 >> ");
		return scan.nextInt();
	}
	
	//요일구하기
	public int getWeek(int year, int month) {
		Calendar cal=Calendar.getInstance(); //객체생성방법 => 추상클래스 new로 객체생성불가
		//추상클래스 - 미완성된 클래스 new없이 객체생성가능
		//Spring => new 사용하지 않고 객체 생성 => 리플렉션
		cal.set(Calendar.YEAR, year); //static final int YEAR => static 상수여서 객체생성없이 접근가능
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);
		//상수 => static final 클래스이름으로 접근 => 클래스명.상수명
		//상수형 변수 => final 클래스 내에서 사용, 객체 생성 후 접근 => 객체명.상수명
		
		int week=cal.get(Calendar.DAY_OF_WEEK);
		
		//month=0시작 week=1시작
		return week-1;
		/*
		 *	{"일","월", ...,"토"} 0번부터 일요일 시작
		 *	Calendar의 week는 1부터 시작
		 *	==> week-1 
		 */
		
	}
	public int getLastDay(int year, int month) {
		Calendar cal=Calendar.getInstance(); //객체생성방법 => 추상클래스 new로 객체생성불가
		//추상클래스 - 미완성된 클래스 new없이 객체생성가능
		//Spring => new 사용하지 않고 객체 생성 => 리플렉션
		cal.set(Calendar.YEAR, year); //static final int YEAR => static 상수여서 객체생성없이 접근가능
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);
		
		int lastday=cal.getActualMaximum(Calendar.DATE); //해당 월의 마지막 날짜
		
		return lastday;
	}
	
	//달력출력 => 전역변수없이 / 전역변수(멤버변수)사용
	public void print(int year, int month, int week, int lastday) {
		System.out.println(year+"년 "+month+"월");
		String[] strWeek= {"일","월","화","수","목","금","토"};
		for(String s:strWeek) {
			System.err.print(s+"\t"); //err 빨간 글자로 출력
		}
		System.out.println("\n");
		for(int i=1;i<=lastday;i++) {
			if(i==1) {
				//공백
				for(int j=0;j<week;j++) {
					System.out.print("\t");
				}
			}
			
			System.out.printf("%2d\t",i); //평일 검은색
			
			week++;
			if(week>6) {
				week=0;
				System.out.println();
			}
			
		}
	}
	public void process() {
		int year=input("년도");
		int month=input("월");
		int week=getWeek(year, month);
		int lastday=getLastDay(year, month);
		print(year, month, week, lastday);
	}
}
public class 클래스구성요소_메소드 { //public 사용한 class==저장명

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Diary d=new Diary(); //input메소드 저장 static이 아니라 new로 객체 생성
		Scanner scan=new Scanner(System.in);
		while(true) {
			d.process();
			System.out.print("\n종료할까요?(y/n)");
			char end=scan.next().charAt(0);
			if(end=='y' || end=='Y') {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
		}
		//d.process();
		
	}

}
