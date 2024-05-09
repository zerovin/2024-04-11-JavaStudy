package com.sist.main;
import java.util.*;

class Diary2{ //같은 패키지에 같은 클래스명을 쓰면 저장시 에러 => 저장과 동시에 컴파일
	private int year;
	private int month;
	private int week;
	private int lastday;
	//private => Diary2 클래스 안에서는 사용가능
	//           다른 클래스에서 사용 - getter/setter, 안쓰면 만들 필요X
	
	public int input(String msg) {
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력 >> ");
		return scan.nextInt();
	}
	
	//요일구하기
	public void getWeek() {
		Calendar cal=Calendar.getInstance(); //객체생성방법 => 추상클래스 new로 객체생성불가
		//추상클래스 - 미완성된 클래스 new없이 객체생성가능
		//Spring => new 사용하지 않고 객체 생성 => 리플렉션
		cal.set(Calendar.YEAR, year); //static final int YEAR => static 상수여서 객체생성없이 접근가능
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);
		//상수 => static final 클래스이름으로 접근 => 클래스명.상수명
		//상수형 변수 => final 클래스 내에서 사용, 객체 생성 후 접근 => 객체명.상수명
		
		week=cal.get(Calendar.DAY_OF_WEEK)-1;
		lastday=cal.getActualMaximum(Calendar.DATE);
		
		//month=0시작 week=1시작
		/*
		 *	{"일","월", ...,"토"} 0번부터 일요일 시작
		 *	Calendar의 week는 1부터 시작
		 *	==> week-1 
		 */	
	}
	
	//달력출력 => 전역변수없이 / 전역변수(멤버변수)사용
	public void print() {
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
		year=input("년도");
		month=input("월");
		getWeek();
		print();
	}
}
public class 클래스구성요소_메소드2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Diary2 d=new Diary2();
		d.process();
		
	}

}
