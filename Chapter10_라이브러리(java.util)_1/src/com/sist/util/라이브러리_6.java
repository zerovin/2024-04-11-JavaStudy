package com.sist.util;
// StringTokenizer - 문자열 분리
/*
 *  nextToken() : 분리된 데이터를 가지고 오는 경우
 *                처음 사용시 0번, 두번째 1번,...사용시마다 인덱스 순서대로 가지고 옴
 *                가지고 있는 토큰 개수보다 많이 호출하면 오류
 *                  => 3개이상은 while(변수명.hasMoreTokens()){변수명.nextToken()}로 호출
 *  hasMoreTokens() : 분리된 데이터만큼 루프시 사용
 *                    커서 위치에 분리된 데이터의 유무를 true/false로 반환
 *  countTokens() : 분리된 개수
 *                  문자열을 분리하고 생긴 Token 개수 출력
 *
 *  StringTokenizer 변수명=new StringTokenizer(분리할 변수명); ==> 공백기준으로 분리
 *  StringTokenizer 변수명=new StringTokenizer(분리할 변수명, "구분자"); ==> 구분자기준으로 분리
 *  
 */
import java.util.*;
public class 라이브러리_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String colors="red,green,blue,black,white,yellow,magenta,pink,gray";
		StringTokenizer st=new StringTokenizer(colors, ",");
		System.out.println("color의 갯수:"+st.countTokens());
		/*
		System.out.println(st.nextToken()); //red
		System.out.println(st.nextToken()); //green
		System.out.println(st.nextToken()); //blue
		System.out.println(st.nextToken()); //black
		System.out.println(st.nextToken()); //white
		System.out.println(st.nextToken()); //yellow
		System.out.println(st.nextToken()); //magenta
		System.out.println(st.nextToken()); //pink
		System.out.println(st.nextToken()); //gray
		*/
		System.out.println(st.hasMoreTokens()); //true
		System.out.println("======== 반복문 + hasMoreTokens =====");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println(st.hasMoreTokens()); //false
		/*
		 *  hasMoreTokens() 329page
		 * 
		 *   cursor---------------------
		 *      before / first           => 처음 커서가 존재하다가 hasMoreTokens 호출시 아래로 이동
		 *   ---------------------------
		 *      green => st.nextTokens() => true(데이터 유무) 
		 *   ---------------------------
		 *      blue => st.nextTokens() => true
		 *   ---------------------------
		 *      black => st.nextTokens() => true
		 *   ---------------------------
		 *      ...
		 *   ---------------------------
		 *      gray => st.nextTokens() => true 
		 *   ---------------------------
		 *     after / last             => 데이터 없음 => false => 종료
		 *   ---------------------------
		 */
		
	}

}
