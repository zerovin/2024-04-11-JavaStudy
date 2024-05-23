package com.sist.util;
import java.util.*;
import java.text.*;
public class 라이브러리_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//오늘 날짜 읽기
		/*
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-d");
		String today=sdf.format(date); //2024-05-23
		StringTokenizer st=new StringTokenizer(today, "-");
		int year=Integer.parseInt(st.nextToken());
		int month=Integer.parseInt(st.nextToken());
		int day=Integer.parseInt(st.nextToken());
		*/
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력 >> ");
		int year=scan.nextInt();
		System.out.print("월 입력 >> ");
		int month=scan.nextInt();
		System.out.print("일 입력 >> ");
		int day=scan.nextInt();
		
		System.out.printf("%d년 %d월 %d일\n\n",year,month,day);
		
		String[] strWeek= {"일","월","화","수","목","금","토"};
		for(String s:strWeek) {
			System.out.print(s+"\t");
		}
		System.out.println();
		
		//달력출력 => 1일의 요일, 마지막날 필요
		Calendar cal=Calendar.getInstance();
		
		//날짜 설정
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);
		
		int week=cal.get(Calendar.DAY_OF_WEEK);
		week=week-1;
		
		int lastday=cal.getActualMaximum(Calendar.DATE);
		
		//출력
		for(int i=1;i<=lastday;i++) {
			if(i==1) {
				//공백설정
				for(int j=0;j<week;j++) {
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t",i);
			//요일 확인
			week++;
			if(week>6) { //일요일이면
				week=0;
				System.out.println();
			}
		}
		
	}

}
