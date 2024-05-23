package com.sist.util;
/*
 *  라이브러리 - 자바에서 지원하는 클래스 집합, 관련된 클래스 모음 => 패키지
 *  
 *  라이브러리 공부법
 *  1.어떤 클래스의 메소드인지
 *  2.원형 => 리턴형 / 매개변수, static / instance
 *  3.어떤 기능을 가지고 있는지
 *  4.사용처
 *  
 *  1.java.lang - import 생략 => 자동인식
 *    - Object - 최상위 클래스 => 모든 클래스(사용자정의)의 상속을 내리는 클래스
 *               가장 큰 데이터형
 *             - 기능(메소드)
 *               toString() : 객체를 문자열화
 *               clone() : 복제(새로운 메모리 생성) => prototype
 *               equals() : 객체 비교
 *               finalize() : 소멸자
 *               hashCode() : 객체 주소값 반환
 *    -String - 문자열을 저장하는 데이터형
 *              웹에서 가장 많이 사용되는 데이터형
 *            - 기능(메소드)
 *              length() : 문자개수 확인 => int
 *              equals() : 실제 저장된 문자열 비교 => 대소문자 구분
 *              substring() : 문자열을 자르는 경우 ex)화면UI, CSS
 *              trim() : 앞뒤 공백제거 ex)사용자 입력시 시작,끝 space문자 제거
 *              valueOf() : 모든 데이터형을 문자열로 변환
 *              replace(), replaceAll() : 문자 변환
 *              indexOf(), lastIndexOf() : 문자, 문자열의 위치 찾기
 *    - StringBuffer - 임시 저장장소를 만들어서 문자열 결합시 최적화 => 빠른 속도
 *                   - 기능(메소드)
 *                     append() : 문자열 결합
 *    - Math - 수학 연산
 *           - 기능(메소드)
 *             random() : 임의 추출
 *             ceil() : 올림
 *    - System - 운영체제 관련
 *             - 기능(메소드)
 *               print(), printf(), println() : 출력
 *               gc() : 메모리 회수
 *               exit() : 프로그램 종료
 *    - Wrapper - 기본 데이터형(int,long,double,char...)을 쉽게 사용 가능하게 기능부여
 *                문자열 => 기본형 변환에 사용
 *              - 기능(메소드)
 *                int => Integer ===> Integer.parseInt()
 *                double => Double ===> Double.parseDouble()
 *                boolean => Boolean ===> Boolean.parseBoolean()
 *                byte => Byte ===> Byte.parseByte()
 *                
 *  ↓↓↓↓↓↓↓↓↓↓↓↓↓↓ 클래스 사용을 위해서 반드시 import 사용 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓
 *  2.java.util - 프로그램을 유용하게 사용할 수 잇는 클래스 집합
 *    - Date - 오라클에 저장된 날짜를 읽어서 저장, 출력
 *    - Calendar - Date에 기능 추가
 *                 년, 월, 주, 일 이용가능
 *                 달력 제작시 사용
 *    - StringTokenizer - 문자열분해 ≒ split()-배열(제어가 어렵)
 *                        단어별 추출
 *    - Collection - 자료구조(데이터 저장 후 쉽게 관리 => 배열X) => 표준화
 *                   interface
 *                   CRUD 가능(추가,수정,삭제,읽기)
 *                                       Collection : interface
 *                                            |
 *                          ---------------------------------------
 *                          |                 |                   |
 *                         List              Set                 Map : interface
 *                          |                 |                   |    Spring, MyBatis 구현한 클래스
 *                   ***ArrayList       ***HashSet             Hashtable
 *                      LinkedList         TreeSet          ***HashMap
 *                      Vector                                 
 *                      Stack / Queue
 *                   
 *                 - List
 *                    1.중복 허용
 *                    2.순서 존재 => 인덱스번호
 *                      ex) 01234 중 [2]삭제시 [3],[4]가 땡겨와서 0123으로 채움
 *                    3.데이터베이스에 데이터를 저장해서 브라우저에 전송
 *                    4.저장방식 - 인덱스번호 데이터
 *                      -------------
 *                         1 데이터
 *                      -------------
 *                         2 데이터
 *                      -------------
 *                         3 데이터
 *                      -------------
 *                 - Set
 *                    1.중복 불가
 *                    2.순서X
 *                    3.중복 제거
 *                      ex) 장르, 카테고리, 부서명, 근무자...
 *                    4.저장방식 - 데이터 => 중복불가
 *                      ------------
 *                         데이터1
 *                      ------------
 *                         데이터2
 *                      ------------
 *                         데이터3
 *                      ------------
 *                 - Map
 *                   1.키, 값으로 구성
 *                   2.키 중복불가, 값 중복가능
 *                   3.사용처 - 세션 ex) "id","hong"
 *                            브라우저에서 자바로 요청값 전송
 *                            쿠키
 *                            클래스 등록
 *                            웹에서 70%는 Map 사용
 *                   4.저장방식
 *                     ------------
 *                       키    값
 *                     ------------
 *                      id   hong
 *                     ------------
 *                      pw   1234
 *                     ------------
 *   
 *   *** String / ArrayList / Integer => 웹의 3대 클래스
 *                        
 *    - Random - 임의의 정수 추출
 *             - 기능(메소드)
 *               nextInt() : 정수형 전체 0~21억 4천
 *               nextInt(10) : 0~9 사이 정수 임의 추출
 *               nextInt(난수발생범위)                
 *                   
 *  3.java.text
 *  4.java.io
 *  5.java.net - 데이터 수집 => 크롤링
 *  5.java.sql - 오라클 연동 => 저장, 읽기, 수정, 삭제 => CRUD
 * 
 *                
 *  
 */
import java.util.*;
public class 라이브러리_1 {

	public static void main(String[] args) {
		Random r=new Random();
		int num=r.nextInt(10); //0-9 사이 정수 임의 추출
		System.out.println(num);
		
		//A-Z 알파벳 열개 임의 추출
		for(int i=1;i<=10;i++) {
			char c=(char)(r.nextInt(26)+65);
			System.out.print(c+" ");
		}
		System.out.println();
		
		//로또번호
		for(int i=1;i<=6;i++) {
			int lotto=r.nextInt(45)+1; //1~45
			System.out.print(lotto+" ");
		}
	}
}
