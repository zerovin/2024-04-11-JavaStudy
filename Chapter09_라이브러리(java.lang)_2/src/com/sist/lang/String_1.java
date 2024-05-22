package com.sist.lang;
/*
 *  String - 문자열 관리 char[]제어
 *           오버라이딩 불가 => 제공한 그대로 사용 => 종단클래스 final => 상속불가
 *           Math, System, StringBuffer, Wrapper
 *           암기용
 *           웹, 윈도우는 모든 데이터가 String으로 들어온다
 *           자바스크립트와 동일
 *  - String에 문자열을 저장하는 방법
 *    - 일반 기본형처럼 사용 => 기본사용법
 *      String s=""; 
 *    - 객체 생성
 *      String s=new String("");
 *      *** 문자열은 자체가 메모리 주소
 *          ex) "Hello" => 이 자체가 메모리 주소 {'H','e','l','l','o'}
 *              String s1="Hello";
 *              String s2="Hello";
 *              ==> s1,s2 메모리주소값은 같다
 *                  s1==s2 => true
 *                  s1.equals(s2) => true
 *              String s3=new String("Hello") => 새로운 메모리를 생성해서 값 할당
 *              ==> s1, s3는 메모리주소는 다르고 값은 같음
 *                  s1==s3 => false
 *                  s1.equals(s3) => true
 *     *** == : 객체 주소값 비교 Stack
 *     *** equals() : 실제 저장된 문자열을 비교 Heap
 *  - 기능(메소드)
 *    1.charAt(int index) : 원하는 위치의 문자 한개를 가지고 올 때 사용
 *                          원형 - public char charAt(int index)
 *                          문자열은 char[] => index번호 0번 부터 시작
 *                          ex) "Hello Java"
 *                               0123456789
 *                               chatAt(6) ==> 'J'
 *  **2.length() : 문자의 갯수를 가지고 온다
 *                 원형 - public int length()
 *                 ex) "Hello Java"
 *                      0123456789
 *                      length() => 10 => 영문/한글/공백(space문자) 포함 글자수
 *                 ex) 말줄임표 사용 ..., 비밀번호 확인, MMS
 *  **3.toUpperCase() / toLowerCase() : 대문자변환 / 소문자변환
 *                                      원형 - public String toUpperCase()
 *                                            public String toLowerCase() 
 *    검색관련=========
 *    4.startsWith() : 시작 문자열이 같은 경우
 *                     원형 - public boolean startsWith(String start)
 *                     ex) 서제스트(자동완성기) 만드는 경우
 *                          cookie 저장/읽기 - 문자열만 저장 가능, 찾고자하는 접두사 검색
 *                     정규식 - ^A
 *                     오라클 - A%
 *                     CSS - img[src^='http']
 *    5.endsWith() : 끝나는 문자열이 같은 경우
 *                   원형 - public boolean endsWith(String end)
 *                   ex) 확장자 찾기 gif/jpg/png/bmp...
 *                   정규식 - A$
 *                   오라클 - %A
 *                   CSS - img[src$='jpg|gif|png']
 *  **6.contains() : 포함된 단어
 *                   원형 - public boolean contains(String s)
 *                   ex) 사이트의 모든 검색은 contains 사용
 *                   정규식 - [A]
 *                   오라클 - %A%
 *                   CSS - img[src*='A']
 *  **7.equals() : 문자열이 같을 때
 *                 원형 - public boolean equals(String S)
 *                 ex) 로그인, 아이디찾기
 *               **equalsIgnoreCase() - 대소문자 구분X
 *                                      ex)검색
 *                 equals() - 대소문자 구분O
 *                            ex)로그인, 아이디, 비번
 *  **8.indexOf() : 찾는 문자 인덱스번호 반환, 앞에서부터 검색
 *                  원형 - public int indexOf(찾는 문자 or 문자열)
 *                  ex)일반문자열
 *  **9.lastIndexOf() : 찾는 문자 인덱스번호 반환, 뒤에서부터 검색
 *                      원형 - public int lastIndexOf(찾는 문자 or 문자열)
 *                      ex)경로명, 확장자
 *  변경관련=========
 *  **10.replace() : 문자나 문자열 변경
 *                   오버로딩 - 매개변수에 따라 여러개
 *                   원형 - public String replace(char c1, char c2)
 *                         public String replace(String s1, String s2)
 *                         c1, s1 => 변경할 대상 / c2, s2 => 변경할 문자,내용
 *                   ex) 크롤링-오라클 저장시 자주 사용
 *                             ||, & => 이미지가 있는 경우 저런 문자 오류
 *  **11.replaceAll() : 정규식(문자형태) 이용해서 문자, 문자열 변경
 *                      원형 - public String replaceAll(String regex, String 변경문자열)
 *                      ex) 맛있다 맛있고 맛있는 ...
 *                          => 맛있+
 *                      ex) ABCDEFG한글입니다
 *                          replaceAll([A-Z],"") => 영어전체 공백
 *                          replaceAll([가-힣],"") => 한글전체 공백
 *                          replaceAll([0-9],"") => 숫자전체 공백
 *                    **데이터
 *                      - 정형화된 데이터 - 프로그램에 필요한 데이터만 수집 (데이터베이스 안에 저장)
 *                      - 반정형화 데이터 - 구분만 되어있는 데이터 ex) HTML/XML/JSON
 *                      - 비정형화 데이터 - 구분이 없는 데이터 ex)트위터, 페이스북
 *                      ===> 정형화(빅데이터) => 통계, 분석
 *  **12.substring() : 문자열을 자르는 경우에 사용
 *                     원형 - public String substring(int start)
 *                           public String substring(int start, int end)
 *                           **index[end-1] 까지 잘라온다 => end포함X
 *                     ex) "Hello Java"
 *                          0123456789
 *                          substring(6) => Java
 *                          substring(2,5) => llo
 *  **13.valueOf() : 모든 데이터형을 문자열로 변환
 *                   원형 - public static String valueOf(Object o)
 *                         public static String valueOf(int i)
 *                         public static String valueOf(double d)
 *                         public static String valueOf(float f)
 *                         public static String valueOf(boolean b)
 *                       **static 메소드
 *                         ex) String s="Hello Java";
 *                             s.length()
 *                             s.substring()
 *                             String.valueOf(10) => "10"
 *                             ==> valueOf()는 static이라서 String.valueOf()로 사용
 *                 **모든 웹, 윈도우는 String으로 데이터를 받는다
 *                   String을 다른 데이터형으로 변경 => Wrapper
 *  **14.split() : 구분자별로 문자열을 잘라서 배열에 저장
 *                 원형 - public String[] split(String regex)
 *                 정규식 이용
 *  **15.trim() : 좌우 공백 제거
 *                원형 - public String trim()
 *  
 */
public class String_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//문자열 저장 공간 만들기
		String s1="Hello";
		String s2="Hello";
		//같은 문장열 다른 메모리 저장
		String s3=new String("Hello");
		if(s1==s2) { // == 객체일 때 => 메모리 주소값 비교, 실제 문자열 비교는 equals()
			System.out.println("s1과 s2는 같다");
		}else {
			System.out.println("s1과 s2는 다르다");
		}
		if(s1==s3) { 
			System.out.println("s1과 s3는 같다");
		}else {
			System.out.println("s1과 s3는 다르다");
		}
	}

}
