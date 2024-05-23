package com.sist.util;
/*
 *  java.text - 변환 Format
 *   -*SimpleDateFormat - 날짜 변경 ex)yyyy-MM-dd hh:mm:ss
 *   -*DecimalFormat - 정수 변경 ex)1,000 
 *   - ChoiceFormat - switch~case
 *   - MessageFormat - SQL, 출력형태 
 *                     MessageFormat.format(형식, 출력할 배열)
 */
import java.util.*;
import java.text.*;
public class 라이브러리_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 시스템 날짜
		//기본출력
		Date date=new Date();
		System.out.println(date);
		
		//원하는 스타일로 출력 yyyy-MM-dd
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //SYSDATE
		/*
		 *  연도 yyyy / yy
		 *      ex) 2024 / 24
		 *  월 MM / M 
		 *    ex) 05 / 5 
		 *  일 dd / d
		 *    ex) 01 / 1
		 *  시간 hh / h
		 *  분 mm / m
		 *  초 ss / s
		 */
		System.out.println(sdf.format(date));
		
		// yyyy년 MM월 dd일
		StringTokenizer st=new StringTokenizer(sdf.format(date),"-");
		System.out.println(st.nextToken()+"년 "+st.nextToken()+"월 "+st.nextToken()+"일");
		
		// 시간
		sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(date));
	}

}
