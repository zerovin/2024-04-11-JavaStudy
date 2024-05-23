package com.sist.util;
//날짜관련 332page
/*
 *  Date / Calendar - 웹에서 날짜 출력
 *                    ex) 댓글, 게시판, 예약일
 *                    오라클 - 데이터형 => 정수/실수 => 숫자형 Number
 *                           문자 => VARCHAR2, CHAR, CLOB => String
 *                           날짜 => DATE
 *                    오라클에서 날짜받을 때 주로 사용
 *  Date - 간단한 날짜 정보
 *         가진 메소드는 없음
 *         오라클 호환
 *         일반 클래스 - Date dat=new Date(); => 시스템 날짜시간 반환
 *  Calendar - Date에 없는 기능 보완
 *             기능 - 요일, 마지막날 읽기...
 *             ex) 달력, 일정표 제작
 *             추상클래스 - new 사용불가
 *                       Calendar cal=Calendar.getInstance()
 *                         => 디자인패턴 => 싱글턴 패턴 : 한개의 객체주소만 이용
 *                                                  스프링이 싱글턴 
 *             
 *  
 */
import java.util.*;
import java.text.*;
public class 라이브러리_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=new Date();
		
		//날짜 출력
		System.out.println(date); //Thu May 23 12:09:19 GMT+09:00 2024
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-d");
		String today=sdf.format(date);
		StringTokenizer st=new StringTokenizer(today,"-");
		int year=Integer.parseInt(st.nextToken());
		int month=Integer.parseInt(st.nextToken());
		int day=Integer.parseInt(st.nextToken());
		
		System.out.println(year+"년 "+month+"월 "+day+"일");
		// MM => 01~09 11 12...
		//       앞에 0붙으면 8진법이라 오류가능성 있음
		// StringTokenizer 잘라서 int처리할 때 MM대신 M사용
		
		//요일 확인 / 월 마지막날
		Calendar cal=Calendar.getInstance();
		//설정
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, day);
		
		int week=cal.get(Calendar.DAY_OF_WEEK); //요일 읽기
		System.out.println(week); //01234567 로 출력
		String[] strWeek= {"","일","월","화","수","목","금","토"};
		System.out.println(today+"의 요일은 "+strWeek[week]+"요일");
		int lastday=cal.getActualMaximum(Calendar.DATE);
		System.out.println("마지막 날:"+lastday+"일");
	}

}
