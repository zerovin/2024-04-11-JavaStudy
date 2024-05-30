package com.sist.main;
/*
 *  변수 / 배열 / 연산자 / 제어문 / 메소드
 *  클래스 구성요소 
 *     class ClassName{
 *        변수 : 필요 데이터 => 출력화면
 *              목록에서 데이터 읽기X-요약, 상세에서 데이터 읽기
 *        메소드 : 어떤 기능 => 메뉴
 *        생성자 : 오버로딩
 *               초기값, 시작과 동시에 처리
 *               ex)자동로그인, 보안처리, 데이터베이스 드라이브 등록
 *     }
 *   - 접근지정어
 *       private 자신의 클래스 안에서 접근가능
 *               멤버변수에서 주로 사용
 *       default 같은 패키지 다른 클래스에서 사용가능
 *               윈도우 => 컴포넌트(JButton, JTextField..)
 *       protected 같은 패키지 다른 클래스에서 사용가능
 *                 상속이 있는 경우 다른 패키지에서 접근가능
 *       public 모든 클래스에서 사용가능
 *     - 접근지정어 사용 
 *       [접근지정어] class ClassName     => public 다른 클래스와 연동
 *       [접근지정어] 데이터형 변수명         => private 데이터 보호
 *       [접근지정어] 생성자()              => public 다른 클래스와 연동
 *       [접근지정어] 리턴형 메소드명()       => public 다른 클래스와 통신
 *       [접근지정어] interface 인터페이스명 => public 다른 클래스에서 구현 후 사용
 *       ==> private / public 주로 사용
 *     - 접근 범위
 *       <---------------- 축소 ----------------
 *       private < default < protected < public
 *       ----------------- 확장 --------------->
 *       => 오버라이딩 - 접근지정어의 확장 가능, 축소 불가능
 *   - 제어어
 *     static 공통적인 => 모든 객체가 공통으로 사용
 *            static 메소드, static 블록에서는 인스턴스 사용불가
 *            => 인스턴스를 사용하기 위해서는 반드시 메모리 할당 후 사용 => 매개변수
 *               ex) class A{
 *                      int a;
 *                      public static void display(){
 *                         a=200; //오류
 *                         A aa=new A(); //메모리 할당
 *                         aa.a=200;
 *                      }
 *                   }
 *                   A aa=new A();
 *                   aa.a=100;
 *            => 인스턴스메소드, 인스턴스 블록에서는 인스턴스변수, static변수 사용가능
 *     abstract 미완성된 => 상속을 내려서 구현한 클래스를 이용
 *     final 마지막 => 종단클래스 - 상속을 내릴 수 없는 클래스
 *                   종단메소드 - 오버라이딩 불가
 *                   상수 - 값 변경 불가
 *     [접근지정어] [제어어] ~
 *     [제어어] [접근지정어] ~
 *     접근지정어, 제어어 순서 변경해도 이상X
 *     
 *  오버로딩 오버라이딩 차이 99%***
 *                  오버로딩                오버라이딩
 *             => 새로운 기능 추가        => 기존 기능 변경
 *     메소드명         동일                   동일
 *     리턴형         관계없음                  동일
 *     매개변수     개수/데이터형 다름             동일
 *     접근 지정어     관계없음                확장만 가능
 *     상태        같은 클래스 내               상속
 *                                         포함 => 익명의 클래스
 *
 *  추상클래스/인터페이스 75%***
 *    - 미완성된 클래스 => 반드시 상속내려서 구현 후 사용
 *      공통적인 기능 설계 => 표준화
 *      서로 다른 클래스 연결 => 리모콘 역할
 *      관련된 클래스 여러개를 묶어서 사용
 *      결합성이 낮은 프로그램
 *      요구사항 분석 => 설계도
 *      
 *                      추상클래스              인터페이스
 *      상속              단일상속               다중상속 => 추상클래스의 단점 보완
 *      사용방법       extends 추상클래스명   implements 인터페이스명
 *      변수               멤버변수                상수
 *      메소드       구현 메소드, 미구현 메소드       미구현 메소드 => jdk 1.8부터 구현된 메소드 사용가능
 *                                                         default static 만 가능
 *      접근지정어     접근지정어 전체 사용가능     public만 사용가능
 *      
 *   - 인터페이스 중심 => 컬렉션 / 데이터베이스
 *                           Collection
 *                               |
 *            ----------------------------------------
 *            |                  |                   |
 *          List                Set                 Map
 *            |                  |                   |
 *       ArrayList            HashSet             HashMap
 *       LinkedList           TreeSet             Hashtable
 *       Vector
 *       
 *       ArrayList list=new ArrayList()
 *       LinkedList list= new LinkedList()
 *       Vector list=new Vector()
 *       ==>
 *       List list=new ArrayList()
 *            list=new Vector()
 *            list=new LinkedList();
 *       - 이벤트 처리(윈도우) => 키보드 입력, 클릭 등의 행위를 했을 때 처리
 *         ActionListener : JButton, JMenu, JRadio
 *         MouseListener : JTable
 *         KeyListener : JTextField
 *         ----------Mouse~, Key~ 모든 컴포넌트가능
 *      ***구현하지않고 내려주는 이유
 *         프로그램마다 구형하는 기능이 다르기 때문
 *         프로그램에 맞게 구현해서 사용
 *         설계된 메소드만 전송 == 구현이 안된 메소드
 *         ex) 버튼 - 로그인, 취소, 회원가입, 계산기, 검색 ...
 *
 *  ***기술면접
 *  객체지향의 객체란?
 *  캡술화, 은닉화 차이
 *  상속, 포함 차이
 *  예외처리 종류/목적
 *  컬렉션
 *  
 *  예외처리
 *    - 목적 : 사전에 에러를 방지하는 프로그램
 *      정의 : 비정상 종료 방지
 *    - 직접처리 : 프로그래머 직접 에러를 처리 => 에러복구
 *               try~catch~finally
 *               웹 => DB연동 java.sql => CheckedException => 거의 대부분 사용
 *      간접처리 : 에러 발생에 대한 선언 => 사용시 반드시 예외처리 후 사용 => 에러 떠넘기기
 *               throws
 *    - try ~ catch는 여러개 사용가능
 *      catch 순서 존재 - 상속도 상 위로 올라갈수록 예외처리하는 범위가 크다
 *                      Exception / Throwable 중 사용
 *    - throws 순서가 없다
 *    
 *                      Object
 *                        |
 *                    Throwable
 *                        |
 *              ----------------------
 *              |                    |
 *            Error              Exception
 *      소스상에서 처리 불가능      소스상에서 변경,처리 가능
 *     ex) 메모리 부족         ex)IP, 파일명, 배열범위초과, 0나누기
 *                                   |
 *                 --------------------------------------
 *                 |                                    |
 *          CheckedException                    UnCheckedException
 *                 |                                    |
 *              java.io                         RuntimeException
 *                IOException                     NumberFormatException
 *                FilenotFoundException            - Integer.parseInt()
 *              java.sql                          NullPointerException
 *                SQLException                    ArrayIndexOutOfBoundsException
 *              java.lang                          - StringTokenizer
 *                ClassNotFoundException
 *                 - Class.forName()
 *                InterruptedException
 *    
 *     
 *    - 오라클 연동 : CheckedException => 예외처리 필요
 *      JDBC : 자바에서 제공하는 라이브러리
 *      DBCP : 웹에서 주로 사용하는 기술
 *      ORM : 실무에서 사용하는 기술 ex) MyBatis 85%, JPA 15%
 *    - JavaScript - Jquery(Ajax) - Vue - React - React-Query - NextJS
 *     
 *  라이브러리
 *    - java.lang
 *       - Object : 최상위 클래스
 *          - toString() 객체를 문자열로 변경
 *          - finalize() 소멸자
 *          - clone() 복제
 *       - String : 문자열 저장
 *          - equals() 문자열이 같은 경우 '=='은 주소값 비교
 *          - contains() 포함된 단어, 검색
 *          - startsWith() 서제스트 자동완성기
 *          - indexOf()/lastIndexOf() 지정된 문자 위치를 찾는 경우, 인덱스번호 반환
 *          - valueOf() 모든 데이터형을 문자열로 변경
 *          - substring() 문자열 자르는 경우
 *          - length() 문자 개수 확인
 *          - trim() 좌우 공백 제거
 *          => 웹은 모두 문자열
 *       - StringBuffer : 문자열 결합
 *          - append() 한메모리에 추가, 최적화
 *          - toString() 저장된 모든 데이터를 문자열로 변경
 *       - Math : 수학
 *          - random() 임의의 값 추출
 *          - ceil() 올림
 *       - Wrapper : 기본형을 클래스화, 제네릭(클래스만 지정가능)에서 사용
 *          - Integer 문자열을 정수로 변환, int 클래스화 parseInt() 
 *          - Double 문자열을 실수로 변환, double 클래스화 parseDouble()
 *          - Boolean 문자열을 논리형으로 변환, boolean 클래스화 parseBoolean()
 *          - Byte 문자열을 바이트로 변환, byte 클래스화 parseByte()
 *          - 오토박싱 Integer i=10;
 *          - 언박싱 int ii=i;
 *            => 오토박싱, 언박싱 호환가능
 *         => 웹, 윈도우는 모든 데이터를 문자열로 인식(기본형X)
 *    - java.util - 프로그램에서 많이 사용하는 클래스 집합
 *       - Random : 임의의 수 추출, Math.random() 보완
 *          - nextInt(int bounds) int bounds = 범위, 마지막은 제외
 *            ex) nextInt(100) 0~99
 *       - StringTokenizer : 문자열을 구분자 기준으로 자르는 경우, split() 보완   
 *          - nextToken() 자른 단어를 읽어옴
 *          - hasMoreTokens() 자른 개수만큼 루프돌릴 때 사용, 다음 출력값이 있을 경우 true 반환
 *          - countTokens() 자른 개수
 *       - Date : 오라클 데이터형과 호환, 기능은 없다
 *       - Calendar : Date에 없는 기능 보완 ex)요일, 마지막날 => 달력제작
 *       - Collection : 배열 단점 보완, 가변형
 *          - List 데이터 중복허용
 *                 순서가 있다, 인덱스 - 삭제, 추가시 자동변경 => 순차적으로 유지 0번부터 시작 
 *             - ArrayList 데이터베이스에서 추출한 데이터를 브라우저, 윈도우로 전송
 *                - add(값) 추가
 *                - size() 개수
 *                - get() 데이터 읽기
 *                - clear() 전체삭제
 *                - isEmpty() 데이터 존재여부
 *          - Set 데이터 중복 허용하지 않는다
 *                순서가 없다
 *             - HashSet 중복제거, 웹소켓, 브라우저에서 채팅,쪽지 전송 => 접속자가 중복되면 안된다
 *                - add(값) 추가
 *                - size() 개수
 *                - get() 데이터읽기
 *                - clear() 전체삭제
 *                - isEmpty() 데이터 존재 여부
 *          - Map 키,값을 동시에 저장
 *                키 - 중복불가
 *                값 - 중복가능
 *             - HashMap 클래스를 모아서 관리, 웹에 전송,응답, 쿠키에 저장, 세션에 저장
 *               ex) ?page=1 page-키, 1-값
 *                - put(키,값) 추가
 *                - size() 개수
 *                - get() 데이터 읽기
 *                - clear() 전체삭제
 *                - isEmpty() 데이터 존재여부
 *         ***저장된 데이터형 => 프로그래머가 어떤 데이터를 저장할지 모름
 *                        => 어떤 데이터든 상관없이 받을 수 있게 제작
 *                        => 리턴형 / 매개변수 Object 가장 큰 데이터형
 *                        => 형변환 필요
 *         ***Object를 데이터형 전체 변경이 가능하게 만든다 => 프로그램에 맞는 데이터형으로 변경
 *            - 데이터형 통일화
 *            - 가독성 => 저장된 데이터형 확인가능
 *            - 형변환이 없기 때문에 간결
 *            ===> 제네릭 <클래스명> 
 *                 ex)int => <Integer>
 *            - 컬렉션은 제네릭을 이용해서 제어
 *    - java.text
 *       - DecimalFormat : 숫자변환
 *          - new DecimalFormat("#,###,###,###")
 *       - SimpleDateFormat : 날짜변환
 *          - new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
 *       ------------------- .format() 으로 변경
 *       - String.format() : printf()와 동일
 *                            ex) String.format("%d%d",1,2) 
 *    - java.io - 입출력
 *       - FileInputStream / FileOutputStream : 다운로드 / 업로드
 *       - FileReader / FileWriter : 파일에 한글이 있는 경우 제어
 *       - BufferedReader / BufferedWriter : 메모리에 파일의 내용을 읽어 놓고 제어
 *                                           => 제어 속도가 빠르다
 *         - Input, Reader
 *             - read() 읽기
 *             - close() 닫기
 *         - Output, Writer
 *             - writer() 쓰기
 *         - -1 : EOF End Of File 파일의 끝   
 *    - java.sql*****
 *       - 드라이버 등록
 *         - Class.forName(드라이버명)
 *       - 오라클 연결
 *         - Connection
 *       - 오라클로 명령어(SQL) 전송
 *         - PreparedStatement
 *       - 결과값 얻기
 *         - ResultSet
 *       * SQL - 구조화된 질의 언어, 자바에서 오라클을 제어하는 언어를 배움
 *         - DML 데이터 조작언어 => 프로그래머가 주로 사용, 데이터 담당자 == DBA
 *         - DDL 정의언어
 *         - DCL 제어언어
 *         - TCL 트랜잭션 언어(일괄처리)
 *    - javax.servlet.http~ JSP 웹
 *    - org.springframework Spring 
 *    
 *  
 *  
 */
class Sawon{
	//static보다 인스턴스 사용이 편리
	//static - 공통메소드 
	//인스턴스 - 멤버메소드 => 멤버만 사용가능
	//윈도우 => this
	int sabun;
	String name;
	public static void setData() {
		Sawon s=new Sawon();
		s.sabun=10;
		s.name="홍길동";
	}
	public static void setData1(Sawon s) { //static에서는 동일한 객체를 사용하기 위해서 매개변수를 이용
		s.sabun=10;
		s.name="홍길동";
	}
	public Sawon() {
		setData1(this);
	}
}
public class 정리_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon ss=new Sawon();
		ss.setData();
		System.out.println("ss.sabun="+ss.sabun); //0
		System.out.println("ss.name="+ss.name); //null
		//s와 ss는 다른 메모리
		
		Sawon ss1=new Sawon();
		ss1.setData1(ss1);
		System.out.println("ss1.sabun="+ss1.sabun); //0
		System.out.println("ss1.name="+ss1.name); //null
	}

}
