package com.sist.io;
/*
 *  java.io
 *    특징 - 데이터 이동 통로(스트림)를 만들어서 데이터 입출력
 *           => 스트림 - 단점 단방향 => 빨대프로그램
 *                     읽기/쓰기를 따로 만들어서 처리 => 네트워크는 읽기/쓰기를 동시처리(쓰레드) ex)채팅-서버에서 보내는 값/서버로 보내는 값
 *    IO - InputStream / OutputStream
 *         송신/수신 => 1byte 전송 => 자바에서는 각국 언어 사용할 수 있게 2byte용 제작
 *         1byte => 바이트 스트림
 *                  ~InputStream, ~OutputStream
 *         2byte => 문자 스트림
 *                  ~Reader, ~Writer
 *    상속도 -    InputStream           OutputStream
 *                  |                      |
 *            FileInputStream       FileOutputStream
 *          BufferedInputStream   BufferedOutputStream
 *          
 *                Reader                 Writer
 *                  |                      |
 *              FileReader             FileWriter
 *            BufferedReader         BufferedWriter
 *          
 *        => ObjectInputStream(직렬화) / ObjectOutputStream(역직렬화) => 객체단위저장
 *        -----------------------------------------------------
 *    메모리 입출력 : Scanner
 *    파일 입출력 : IO
 *    네트워크 입출력 : IO
 *  **io사용시 반드시 예외처리를 한다 => CheckedException
 *  
 *    입출력
 *      바이트 스트림
 *       - 읽기메소드 : read() => 한글자 읽기
 *                   read(byte[]) => 여러글자 읽기
 *       - 쓰기메소드 : write(), write(int)=> 한글자 출력
 *                   write(byte[]) => 여러글자 출력
 *       - 파일 닫기 : close()
 *       - FileInputStream / FileOutputStream => 웹 - 파일 업로드 / 다운로드 / 파일 복사
 *      문자 스트림
 *       - 읽기메소드 : read()*, read(char[])
 *       - 쓰기메소드 : write(char), write(char[]), write(String)*
 *       - FileReader / FileWriter => 크롤링 후 파일 저장 / 카페, 블로그, 로그파일 읽고 분석
 *      필터 스트림 - 파일에 있는 데이터를 메모리에 한번에 이동 후 사용가능 => 속도가 빠르다
 *                 Buffered~
 *       - 읽기메소드 : readLine() => 한줄씩 읽어 온다
 *       - 쓰기메소드 : write(String)
 *       - BufferedReader / BufferedWriter => 한번에 데이터를 한줄씩 읽는 경우 주로 사용
 *       
 *      * 파일 내의 명사/조사 => 형태소 분석 라이브러리 - 꼬꼬마(서울대) R/Korean-text ex)챗봇
 *    
 *    FileReader => r 읽기모드
 *    FileWriter => w 쓰기모드 - create 기존데이터는 삭제되고 덮어쓰기
 *                             생성자 - new FileWriter("파일명")
 *                  a 쓰기모드 - append 기존데이터에 결합해서 쓰기
 *                             생성자 - new FileWriter("파일명", true)
 *    ==> 파일을 읽어서 ArrayList(배열)에 저장 후 데이터 활용
 *    
 *    Properties - 파일의 확장자 .properties
 *                 구분자가 있기 때문에 사용하기 편리 => 사용자 정의
 *                 외부 라이브러리에서 주로 사용 => 보안이 뛰어남
 *                   ex)데이터베이스 관련 MyBatis, JPA, Spring - XML, Annotation
 *                      스프링부트 - properties를 필수적으로 사용, yml 주로 사용 (환경설정)
 *                 작성법 - 변수=값
 *                        변수 => key역할을 수행 => 중복 허용하지 않는다
 *                        값 => 중복 허용
 *                        ex) id=admin / name=홍길동 ==> Map 방식
 *                 한글을 유니코드 형식으로 저장 => 보안에 뛰어남
 *                   => 데이터베이스 정보 - 오라클 위치, 사용자명, 비밀번호 => 누구나 데이터베이스에 접근가능
 *                      Validation - 유효성 검사
 *                 라이브러리로 제작 - Spring, MyBatis에서 등록만하면 읽어옴
 *  
 *   컬렉션 + IO => 배열X
 *     1.데이터 수집 - 파일에 저장 => List로 저장 => 사용
 *                  파일을 저장하지 않으면 프로그램 구동시마다 데이터 수집 해야함 => 파일에 저장해야 데이터 수집없이 파일만 읽기
 *     2.데이터 수집시 중복된 데이터 제거 => Set
 *     3.관리하는 클래스가 많은 경우 - new 메모리 누수현상 => 한개의 메모리 주소로 사용가능하게 => 싱글턴 => Map
 *     
 *   컬렉션
 *                         Collection
 *                              |
 *         -------------------------------------------
 *         |                    |                    |
 *        List                 Set                  Map
 *         |                    |                    |
 *      ArrayList            HashSet              HashMap
 *      데이터 저장              중복제거              클래스 관리
 *       add()                add()                push()
 *       size()               size()               isEmpty()
 *       get()                isEmpty()            size()
 *       isEmpty()            clear()              get()
 *       clear()                                   keySet()
 *                                                 values()
 * 
 *   이후 수업
 *   라이브러리
 *    1.network
 *    2.sql 12장
 *    3.J2EE => 웹 관련
 *    4.외부라이브러리 ex) Jsoup ... mvnrepository.com
 *    5.Spring
 *    6.python 연동
 *   IO/Collection 응용
 *   Network
 *   전체자바정리
 *         
 *          
 */
public class 라이브러리_정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
