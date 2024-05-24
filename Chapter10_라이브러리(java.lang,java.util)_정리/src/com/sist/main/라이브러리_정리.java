package com.sist.main;

import java.util.Arrays;
import java.io.UnsupportedEncodingException;
/*
 *  라이브러리 - 자바에서 지원하는 클래스의 집합
 *            완제품 => 특별한 경우가 아니면 그대로 사용
 *            운영체제와 연결 API (Application Program Interface)
 *            분류 - 패키지 => 관련된 클래스끼리 모아서 제공
 *            ***java.lang : 자바의 기본 클래스 => import 생략가능
 *                 Object : 최상위 클래스 => 모든 클래스의 상속을 내려주는 클래스
 *                          extends Object
 *                          객체와 관련된 기능(메소드)을 제공
 *                           ***toString() : 메모리 할당시 주소값 확인
 *                            - clone() : 객체 사용시 복제해서 사용, 새로운 메모리 만들어서 복제
 *                            - finalize() : 객체 소멸자, 메모리 해제시 호출
 *                           ***hashCode() : 객체 메모리 주소를 리턴, 필요시 변경가능(오버라이딩)
 *                           ***equals() : 객체 비교
 *                           ***Object가 가지고 있는 기능 => 모든 클래스에서 사용가능
 *                                                      필요시 오버라이딩해서 사용 => 메소드 내용 변경 => 재정의
 *                                                      동일객체여부 확인을 위해 toString(), hashCode() 자주 변경
 *                 String : 문자열을 저장하는 클래스
 *                          String s=""
 *                          String s=new String("") => 새로운 메모리에 저장해서 사용, 한글 변환코드
 *                            C언어 - ASC => 한글 깨짐 (알파벳, 숫자 / 한글-포인터) 1byte
 *                            자바언어 - Unicode => 각국의 언어 사용가능 2byte UTF-8 Unicode Transfer Format
 *                                 Encoding(Byte배열) "자바" => %EC%9E%90%EB%B0%94
 *                            자바 ==================> 브라우저(C언어)
 *                               <==================
 *                                     Decoding
 *                            https://www.google.com/search?q=%EC%9E%90%EB%B0%94&oq=%EC%9E%90%EB%B0%94&gs...
 *                          기능(메소드)
 *                            - length() : 문자의 개수
 *                            - toString() : 문자를 있는 그대로 가지고 오기
 *                            - replace(), replaceAll() : 문자변환
 *                            - indexOf(), lastIndexOf() : 문자 위치 찾기
 *                            - substring(), split() : 문제 제어 자르기
 *                            - trim() : 좌우 공백문자 제어
 *                            - valueOf() : 모든 데이터형을 문자열로 변경
 *                            - equals() : 비교
 *                            - startsWith(), endsWith(), contains() : 검색
 *                            ===> 웹의 핵심
 *                                 - 문자열 제어
 *                                 - 데이터베이스 연동
 *                 StringBuffer : 문자열 결합
 *                                기능(메소드)
 *                                  - append()
 *                 Math : 수학
 *                        기능(메소드)
 *                          - ceil() : 올림
 *                          - random() : 난수발생 => Random 클래스로 대체이용
 *                 System : 운영체제 관련
 *                          기능(메소드)
 *                            - exit() : 프로그램 종료
 *                            - gc() : 메모리 회수
 *                 Wrapper : 제네릭에서 주로 사용
 *                           기능(메소드) 
 *                             - Integer : parseInt() 문자열을 정수형으로 변환
 *                             - Double : parseDouble() 문자열을 실수형으로 변환
 *                             - Boolean : parseBoolean() 문자열을 논리형으로 변환
 *            ***java.util : 프로그램 사용에 유용하게 사용할 수 있게 만든 클래스 집합
 *                 Random : 난수발생
 *                          기능(메소드)
 *                            - nextInt() : 범위를 지정해줘야 함, 안해주면 int 전범위
 *                                          ex) nextInt(100) => 0~99
 *                 Date : 기능이 없다
 *                        생성 Date date=new Date()
 *                        오라클 날짜 데이터와 호환 => 데이터베이스 호환
 *                 Calendar : Date에 없는 기능 첨부
 *                            추상클래스 => new로 생성 불가
 *                            Calendar cal=Calendar.getInstance()
 *                            ex) 요일, 마지막날 구하기, 달력제작(예약,예매)
 *                 StringTokenizer : 단어별 분리
 *                                   기능(메소드)
 *                                     - nextToken() : 분리된 단어를 하나씩 읽어옴
 *                                     - countTokens() : 분리된 단어 개수
 *                                     - hasMoreTokens() : 반복문 수행시 더 읽을 토큰이 있는지 true,false반환 
 *                 ↓↓↓↓↓↓↓↓↓ 제네릭 - 데이터형 변경 => Object 형변환 <클래스명>
 *                           <> 안에 기본형 데이터는 사용 불가능 => 각 데이터형마다 클래스 지원(Wrapper)
 *                 ArrayList : 중복된 데이터가 있는 경우
 *                             순서 - 인덱스 자동 조절 => 구분자 - 인덱스
 *                             기능(메소드)
 *                              ***add() : 추가
 *                               - set() : 수정
 *                               - remove() : 삭제
 *                              ***clear() : 전체삭제
 *                              ***size() : 저장개수
 *                              ***get() : 읽기
 *                               - ArrayList가 여러개 있는 경우
 *                                   - retainAll() : 교집합, 공통된 값을 읽어옴
 *                                   - removeAll() : 차집합, 한쪽에만 있는 데이터
 *                                   - addAll() : 전체 데이터 복사
 *                                   - subList() : 부분 데이터 복사
 *                 HashSet : 중복이 없는 데이터
 *                           순서가 없다, 출력시에 원하는 순서대로 출력이 되지 않는다
 *                           중복제거 list로 변경
 *                           구분자 - 자체값 (중복이 없기 떄문에 값 자체가 고유)
 *                           기능(메소드)
 *                            ***add()
 *                            ***clear()
 *                             - iterater()
 *                 HashMap
 *             - java.text : 변환 - 숫자, 날짜 변환
 *                 DecimalFormat : format()
 *                              ***DecimalFormat df=new DecimalFormat("###,###,###")
 *                                 => 자리수 #으로 표현 / 오라클은 999,999,999
 *                 SimpleDateFormat : format()
 *                                 ***SimpleDateFormat sdf=new SimpleDateFormat("")
 *                                    년도 => yyyy
 *                                    월 => MM / M
 *                                    일 => dd
 *                                    시간 => hh / h
 *                                    분 => mm / m
 *                                    초 => ss / s
 *             - java.io : 입출력 - 메모리, 파일, 네트워크
 *             - java.net : 네트워크 프로그램 개발
 *             - java.sql : 데이터베이스 프로그램 개발
 */
import java.net.*;
public class 라이브러리_정리 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		System.out.println("자바".getBytes()); //[B@6504e3b2
		System.out.println(Arrays.toString("자바".getBytes())); //[-20, -98, -112, -21, -80, -108]
		
		String s=URLEncoder.encode("자바", "UTF-8"); //%EC%9E%90%EB%B0%94
		System.out.println(s);
		s=URLDecoder.decode(s, "UTF-8");
		System.out.println(s); //자바
	}

}
