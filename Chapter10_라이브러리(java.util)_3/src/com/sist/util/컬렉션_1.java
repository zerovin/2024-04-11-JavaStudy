package com.sist.util;
/*
 *  컬렉션(Collection)
 *  - 데이터가 많은 경우 처리를 쉽고 효율적으로 관리 가능하게 만드는 자료구조
 *  - 라이브러리 => 표준화 - 모든 개발자가 같은 코드를 사용
 *  - 자료구조 - 데이터 수정, 추가, 삭제, 읽기 => CRUD
 *  - 배열은 고정적 - 선언과 동시에 저장 개수 지정(추가, 삭제 불가)
 *                추가, 삭제시 크고 작은 새로운 배열 생성
 *    배열의 단점을 보완 - 가변형 => 배열의 크기 자동 확대, 축소
 *  - 컬렉션의 구조 => 검색가능
 *                                      Collection : interface
 *                                          |
 *           ------------------------------------------------------------------
 *           |                              |                                 |
 *         List                            Set : 인터페이스                     Map
 *        일자배열                            묶음                            - 사용빈도가 적다
 *     -----------                      - 구현된 클래스                       - 라이브러리에서는 Map 사용빈도 상당
 *      1 2 3 ...                         HashSet                         - 구분자, 데이터 동시저장
 *     -----------                         - 중복 제거                         => 구분자-key, 데이터-value
 *    -데이터 중복 허용                       Treeset :                             key - 중복불가
 *    -데이터 구분을 인덱스로(순서존재)             - 검색 => 속도가 빠름                    value - 중복가능
 *    **추가, 삭제시                             binary search                  ex)name="홍길동"
 *      인덱스 자동 추가,                       - 자바자체 프로그램 개발                   key - name
 *      인덱스 삭제 조정                          오라클 기능 - 검색, 중복제어              value - "홍길동"
 *      ex) 01234 2삭제=> 0123                  명령어 이용해서 데이터 수집        - 웹에서 주로 사용
 *    -구현된 클래스                        - 데이터 중복이 없다                      ex) ?page=1
 *     ArrayList                          => ArrayList에서 중복된 데이터 제거           page - key
 *       - 데이터베이스의 저장된 값을 저장 후         ex)크롤링 => 중복 안된 데이터만 출력         value - 1
 *         브라우저에 전송                  - 데이터가 중복이 없기 때문에 데이터로만 검색가능      getParameter("page") => 1
 *       - 웹 프로그램, Vector 단점 보완        => 순서가 없다                        request - 사용자가 보내준 값을 받을 때 사용
 *       - 비동기방식                                                           response
 *         => 접속 속도 빠르게 개선                                                session 
 *            데이터 순차적 저장 불가                                              cookie
 *         => 정렬 후 저장, 사용                                               - 스프링에서 클래스 관리할 때 사용
 *         => 오라클에서 정렬                                                  - MyBatis에서 SQL 관리할 때 사용
 *            ORDER BY no                                                  - 구현된 클래스
 *            데이터 검색(일기) SELECT                                            HashMap
 *            데이터 추가 INSERT                                                  - 동기
 *            데이터 수정 UPDATE                                                  - 주로 사용
 *            데이터 삭제 DELETE                                                  - Hashtable을 보완
 *       - 사용처**                                                            Hashtable   
 *         =>웹 프로그램에서 주로 사용                                                - 동기
 *     Vector                                                                => 저장 put(key, value)
 *       - 네트워크 접속자 정보 저장                                                   읽기 get(key)
 *       - 동기적 방식 => 접속 속도 늦다
 *       - 네트워크 -> 서버
 *     Stack
 *       - LIFO 구조 Last In First Out
 *       - 사용 권장X
 *       - ex)변수저장
 *     LinkedList
 *       - 추가, 삭제가 빠르다
 *       - 접근 속도가 늦다
 *       - C언어 호환
 *     Queue
 *       - FIFO 구조 First In First Out
 *       - ex) 네트워크 전송, 운영체제 스케줄러    
 *       
 *  ===> ArrayList, HashSet, HashMap => 일반 기본값 저장, 클래스 저장가능
 *       모든 데이터 저장이 가능하게 만든다 => 매개변수 / 리턴형 Object
 *       Object = 모든 데이터의 가장 큰 데이터형 => 형변환 후 사용
 *       필요시 매개변수 / 리턴형을 프로그램에 맞게 변경 => 제네릭
 *       제네릭 - 데이터형을 한번에 통일화 => 라이브러리 자체 매개변수/리턴형을 한번에 변경
 *                => 형변환이 필요없다
 *              간결, 가독성 => 어떤 데이터가 저장되어 관리되는지 확인 가능
 *              ex) ArrayList list=new ArrayList()
 *                    => 저장된 데이터 확인 불가
 *                  ArrayList<String> list=new ArrayList<String>()
 *                    => 저장된 데이터 String
 *                  ArrayList<Movie> list=new ArrayList<Movie>()
 *                    => 저장된 데이터 Movie
 *              ***한가지에 관련된 데이터를 모아서 하나의 데이터형으로 관리, 저장 권장
 *              
 *  자료구조 - 메모리에서 데이터 관리
 *        ***추가 add() - 데이터베이스(오라클) => 데이터 담기
 *           삭제 remove()
 *        ***읽기 get() - 화면 => 데이터읽기 => HTML이용 브라우저 출력
 *           수정 set()
 *           전체삭제 clear()
 *        ***저장개수 size() - for문을 이용해서 출력 횟수 확인
 *        ======> 대부분 데이터는 오라클에 저장 => 오라클 안에서 제어
 *       
 *   
 *  *** 프로그램
 *      자바        오라클      HTML/CSS
 *       |          |            |
 *       ------------            |
 *             |                 |
 *           연동(JDBC)           |
 *             |                 |
 *             -------------------
 *                      |
 *                     JSP
 *      -----------------------------------
 *      통합 => 프레임워크(스프링) => 라이브러리(MyBatis, JPA)
 *      기본 조립 => 라이브러리 + 메소드 사용법 = 저장할 변수 설정 
 *   
 */
import java.util.*;
public class 컬렉션_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<String> list=new ArrayList<String>();
		ArrayList list=new ArrayList();
		//문자열만 저장해서 관리
		//add(Object) => add(String) 사용자 정의 데이터형으로 변경
		//가급적이며 1개의 데이터형을 저장 => 데이터형 통일 => 반복문 수행 가능
		//같은 데이터형을 모아서 처리 해야 효율적이기 떄문에 제네릭 사용
		
		//다른 데이터형 모을 시 반복문 사용, 유지보수가 어려움
		list.add("홍길동"); //인덱스0
		list.add(10); //인덱스1
		list.add(10.5); //인덱스2
		list.add(true); //인덱스3
		list.add('A'); //인덱스4
		
		for(int i=0;i<list.size();i++) {
			//String name=(String)list.get(i); //오류발생
			
			if(i==0) {
				String name=(String)list.get(i);
				System.out.println(name);
			}else if(i==1) {
				int no=(int)list.get(i);
				System.out.println(no);
			}else if(i==2) {
				Double d=(double)list.get(i);
				System.out.println(d);
			}else if(i==3) {
				boolean b=(boolean)list.get(i);
				System.out.println(b);
			}else if(i==4) {
				char c=(char)list.get(i);
				System.out.println(c);
			}
		}
	}

}
