package com.sist.lang;
/*
 *  라이브러리 - 자바에서 지원하는 클래스
 *            => J2SE Standard Edition 기본
 *               J2EE 웹에서 사용하는 라이브러리 ex)servlet-api => JSP
 *            외부에서 지원하는 클래스 => Jsoup / SimpleJSON / CSV / Spring
 *            
 *  java.lang - import 생략가능, 자바 기본 클래스, 가장 많이 사용되는 라이브러리
 *  - Object***
 *  - String***
 *  - Math
 *  - System
 *  - StringBuffer
 *  - Wrapper : 데이터형을 클래스화해서 사용이 쉽도록 만듦
 *     - Integer***
 *     - Double***
 *     - Boolean***
 *     - Float
 *     - Byte
 *  
 *  java.util - import 사용 필수
 *  - Scanner
 *  - Calendar / Date***
 *  - StringTokenizer***
 *  - Collection
 *     - List : ArrayList***(배열대신), LinkedList, Vector
 *     - Set : HashSet***, TableSet
 *     - Map : HashTable, HashMap***
 *
 *  java.io - 입출력
 *  - FileInputStream*** / FileOutputStream***
 *  - FileReader*** / FileWriter***
 *  - InputStream / OutputStream
 *  - BufferedReader*** / BufferedWriter
 *  - BufferedInputStream / BufferedOutputStream
 *  
 *  java.net - 네트워크
 *  - URLEncoder*** / URLDecoder
 *  - Socket / ServerSocket
 *  - URL
 *  
 *  java.sql - 오라클 연결
 *  - Connection************** 오라클연결
 *  - Statement************** SQL문장
 *  - ResultSet************** 결과값
 *  
 *  ------------------------------------------------------
 *  
 *  2차 자바(웹) => HttpServletRequest - 브라우저에서 전송한 값을 자바에서 받을 때 사용 
 *                HttpSevletResponse - 자바에서 브라우저로 결과값 전송
 *                HttpSession - 서버에 정보저장
 *                Cookie - 클라이언트 브라우저에 저장
 *  
 *  자바 기본문법 그대로 적용
 *  라이브러리 + 사용자 클래스 = 프로그램 제작
 *  
 *  라이브러리 - 자바를 사용해서 프로그램을 만들 수 있게 미리 제작한 클래스의 집합 API(Application Programming Interface)
 *            java.lang, java.util, java.io, java.sql 290page
 *            import를 사용해서 클래스 읽기, java.lang제외
 *            
 *  java.lang
 *    1.Object - 모든 클래스에 상속을 내린 클래스 (최상위 클래스), 모든 클래스는 extends Object 생략
 *               Object가 가지고 있는 기능(제공된 메소드)
 *                ***toString() : 객체를 문자열로 변환 => String
 *                   원형) public String toString()
 *                        문자열 변환 (String), toString(), valueOf()
 *                ***clone() : 메모리 복제 (새로운 메모리 생성)
 *                             참조 => 공동으로 사용, 같은 주소공유
 *                             복제 => 새로운 메모리 생성, 다른 주소사용
 *                             메모리 주소 이용(배열, 클래스)
 *                             ex)게임 아바타
 *                                 class A{
 *                                    int a; 
 *                                    int b;
 *                                 }
 *                                 
 *                                 A aa=new A();  //a=0, b=0
 *                                 A cc=aa.clone(); ==> cc.a=0;, cc.b=0;
 *                                 aa.a=100;
 *                                 aa.b=200;
 *                                 
 *                                 A bb=aa.clone(); ==> bb.a=100; bb.b=200;
 *                 - finalize() : 소멸자 => 메모리에서 해제 => 자동으로 호출
 *                 - 객체비교 equals()
 *                       ***hashCode()    
 *               
 *  
 */
import java.util.*;
public class 라이브러리_1 {
	public 라이브러리_1() {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {10, 20, 30};
		int[] temp=arr; //참조 => 같은 주소 제어 => 동시변경 => 별칭
		System.out.println("====== arr =====");
		System.out.println(Arrays.toString(arr));
		System.out.println(arr);
		System.out.println("===== temp =====");
		System.out.println(Arrays.toString(temp));
		System.out.println(temp); //arr과 서로 같은 주소 공유
		System.out.println("===== temp 변경 =====");
		temp[0]=100;
		temp[1]=200;
		temp[2]=300;
		System.out.println("===== temp =====");
		System.out.println(Arrays.toString(temp));
		System.out.println("====== arr =====");
		System.out.println(Arrays.toString(arr));
		//temp 변경하면 arr도 동시변경, 같은 메모리 제어 => 참조
		//메소드를 통해서 데이터 변경 => Call By Reference 메모리주소에 의한 참조
		 
		
		/*
		int[] arr= {10,20,30};
		int[] temp=arr.clone(); //새로운 메모리 생성
		
		System.out.println("====== arr =====");
		System.out.println(Arrays.toString(arr));
		System.out.println(arr);
		System.out.println("===== temp =====");
		System.out.println(Arrays.toString(temp));
		System.out.println(temp); //다른 주소
		System.out.println("==== 변경 ====");
		temp[0]=100;
		temp[1]=200;
		temp[2]=300;
		System.out.println("===== temp =====");
		System.out.println(Arrays.toString(temp));
		System.out.println("====== arr =====");
		System.out.println(Arrays.toString(arr));
		//clone으로 복제해서 사용시 다른 메모리를 사용하기 때문에 값 공유X
		 */
	}

}
