package com.sist.util;
/*
 *  java.util - 가장 많이 사용되는 라이브러리
 *   - 난수 Random - 정수, 지정된 범위
 *                  1. 객체 생성
 *                     Random r=new Random()
 *                  2. 난수 발생
 *                     r.nextInt(100) => 100제외 0~99
 *                  ex) 웹 - 예약일 / 예약시간 => 난수 => 실전배포 가상으로 연습
 *   - 날짜 Date - 기능이 없음
 *                ex) 오라클 / MySQL에서 전송하는 날짜를 받는 경우(데이터베이스 호환)
 *         Calendar - Date에 기능 부여
 *                    ex) 요일, 월별 마지막날짜 => 달력제작
 *                    
 *  java.text 
 *   - 변환 SimpleDateFormat => format() - 날짜변환
 *                          ex) new SimpleDateFormat("yyyy-MM-dd")
 *                              년 : yy/yyyy
 *                              월 : MM/M
 *                              일 : dd/d
 *                              시 : hh/h
 *                              분 : mm/m
 *                              초 : ss/s
 *         DecimalFormat => format() - 숫자변환, 패턴 사용
 *                          ex) new Decimalformat("###,###,###") => 오라클(9,999,999)
 *                          
 *  데이터관리 : 컬렉션 => 자료구조
 *   - 데이터를 쉽고 효율적으로 관리할 수 있게 표준화된 라이브러리 : 컬렉션 크레임워크
 *   - 단점 : 모든 데이터를 저장해서 관리할 수 있게 만들어져 있다
 *           기본형, 클래스 => Object
 *                         단점 : 형변환 후 사용, 어떤 데이터가 첨부되어 있는지 모름 => 가독성저하
 *   - 단점보완 : 형변환없이 사용, 가독성이 좋게 만든다 => 소스가 간결 => 제네릭
 *   - 제네릭 - 데이터형을 통일화 시킴
 *            제네릭을 사용하지 않으면 모든 메소드의 리턴형, 매개변수가 Object
 *              => Object를 프로그램에서 필요한 데이터형으로 한번에 변경
 *                 사용자 정의 클래스도 가능 
 *                 ex) class Movie => <Movie>
 *            <데이터형> => 기본형 사용불가
 *                        ex)<int>(X), <double>(X) => Wrapper 제공
 *                       기본형을 클래스화
 *                       - int = Integer
 *                         double = Double
 *                         boolean = Boolean
 *                         1. 제네릭 사용가능
 *                         2. 기본형에 기능 부여
 *                         3. parseInt(), parseDouble(), parseBoolean()
 *                            => 웹, 윈도우에서는 String만 사용하기 때문에 기본형으로의 변경을 위해 많이 사용
 *   - 컬렉션 : 데이터 관리(메모리)
 *            1. 읽기(데이터를 가지고 온다)
 *            2. 추가
 *            3. 수정
 *            4. 삭제
 *            5. 검색 => 데이터 구분 
 *                      List - 인덱스
 *                             ex)set(int index, 추가할 데이터)
 *                                 remove(int index)
 *                      Set - 인덱스가 없다 
 *                            실제 저장된 데이터가 구분자 => 데이터 중복이 없음
 *                      Map - 키
 *                            키, 값을 쌍으로 저장
 *                            키 - 중복불가, 값 - 중복허용
 *                      오라클 - primary key
 *                             중복이 없는 데이터
 *                             ex) id, 자동증가번호
 *   - 컬렉션 클래스 종류
 *                                           Collection : interface
 *                                               |
 *              -----------------------------------------------------------------
 *              |                                |                              |
 *            List                              Set                            Map
 *              |                                |                              |
 *    ---------------------------           -----------                   --------------
 *    |              |          |           |         |                   |            |
 *  **ArrayList   Vector   LinkedList   **HashSet   TreeSet           **HashMap      Hashtable
 *                              |
 *                            Queue
 *     1)List
 *       1.순서를 가지고 있다 (인덱스 = 자동처리) => 순자척으로 저장
 *       2.중복 데이터 저장허용
 *       3.사용처 - 데이터베이스(오라클) *****웹은 데이터베이스가 핵심
 *       4.구현된 클래스
 *         ArrayList : 비동기화 처리(순서없이 읽어오는대로 저장) => 속도가 빠르다
 *                     데이터베이스(오라클)에 저장된 데이터를 읽어 브라우저 전공
 *         Vector : 동기화(저장이 완료되면 다음 데이터 저장) => 속도가 늦다 => 보완 => ArrayList
 *                  네트워크 접속자정보(IP, PORT)
 *         LinkedList / Queue / Stact => 사용빈도 거의 없다
 *       5.ArrayList/Vector/LinkedList는 List라는 인터페이스를 구현
 *         => 메소드가 동일(표준화)
 *         => 주요기능 
 *         ***add() : 추가
 *            remove() : 삭제
 *            set() : 수정
 *         ***get() : 읽기
 *         ***size() : 저장개수
 *         ***isEmpty() : 데이터 존재 여부
 *         ***clear() : 전체삭제
 *         => ArrayList가 여러개 있는 경우
 *            removeAll() : 차집합 => 오라클 MINUS
 *            retainAll() : 교집합 => 오라클 INTERSECT
 *            addAll() : 합집합 => 오라클 UNION
 *            ===> 오라클 JOIN 로직(제어문)은 없고 명령문 => SQL / PL~SQL
 *         
 *              
 *     2)Set
 *       1.순서가 없다
 *       2.데이터 중복을 허용하지 않는다
 *       3.구현된 클래스
 *      ***HashSet : 중복없는 데이터 저장
 *                   ex) 웹 채팅시 접속자 관리
 *                   add(), remove(), clear(), isEmpty()
 *         TreeSet : 검색 속도가 빠르다
 *                   ex) 앱
 *     3)Map 349page
 *       1.key, value 동시 저장
 *         ex) 우편번호(우편번호, 실제주소)
 *         key - 중복불가
 *         value - 중복가능
 *         Map<K,V> - K : key
 *                    V : value
 *                    T : type
 *                    E : element
 *                    ArrayList<E>
 *                    Vector<E>
 *                    Set<E>
 *       2.사용처 - Spring - 클래스 저장(사용자)
 *                         클래스 관리(생성~소멸)
 *                웹 - 전송 / 응답 / 저장(클라이언트-Cookie, 서버-Session)
 *                     ex) ?page=10 page=key 10=value / ?id=admin id=key admin=value
 *                Mybatis - key:id, value:sql
 *       3.주요기능
 *         put() : 저장 => put(key, value)
 *         get() : 읽기 => get(key)
 *         clear() : 전체삭제
 *       4.순서가 없다
 *         key - 구분자로 사용
 *         value - 모든 값 설정가능
 *         
 *     4)Properties
 *       1.파일 .properties => 파일 읽기
 *       2.데이터베이스 정보
 *       3.map형식
 *         변수(key)=값 => 보안유지 => MyBatis
 *
 */
import java.util.*;
public class 라이브러리_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		//key:String, value:String => 대부분 key는 String(구분)
		map.put("id", "admin");
		map.put("password", "1234");
		map.put("name", "홍길동");
		map.put("gender", "남자");
		map.put("age", String.valueOf(20)); //20을 그냥 쓰면 String자리에 int가 들어가서 오류
		map.put("password", "4567"); //키가 중복되면 나중 설정값으로 덮어쓰기 => 중복허용X ex)Cookie
		
		//값 읽기
		System.out.println("아이디:"+map.get("id"));
		System.out.println("비밀번호:"+map.get("password"));
		System.out.println("이름:"+map.get("name"));
		System.out.println("성별:"+map.get("gender"));
		System.out.println("나이:"+map.get("age"));
		Set<String> s=map.keySet(); //key값만 저장 => 중복허용을 하면 안되기때문에 Set이용
		//제네릭 설정을 안해주면 데이터형은 Object
		/*
		for(Object ss:s) {
			String key=(String)ss; //Object로 받을시 형변환 필요
			System.out.println(key+":"+map.get(key));
		}
		*/
		for(String ss:s) {
			System.out.println(ss+":"+map.get(ss));
		}
		//Set은 순서가 없어서 가급적 출력시 List이용 => 순차적
		//Map은 클래스 관리
	}

}
