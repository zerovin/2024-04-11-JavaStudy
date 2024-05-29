package com.sist.main;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;

/*
 *  프로그램
 *  1. 데이터 저장 - 메모리 / 파일 / 데이터베이스(오라클)
 *                  => 파일/데이터베이스는 자바에서 제어 불가능
 *                  => 파일/데이터베이스에서 읽은 데이터를 메모리제 저장 후 관리
 *     데이터 저장시 사용하는 자바용어
 *     1) 변수 / 상수 - 한개 데이터 저장공간
 *        변수 - 변경 가능
 *        상수 - 변경 불가능, 구분자 final
 *              ex) final int a;     
 *          저장 공간 크기 = 데이터형
 *            - 정수 - byte(1byte) : -128~127 => overflow
 *                     ex) 웹(파일 업로드/다운로드-WebSocket), application(네트워크 전송,채팅/쪽지-Socket)
 *                    int(4byte) : 프로그램에서 사용하는 모든 정수는 int를 인식 => -21억 4천~21억4천
 *                    long(8byte) : 금융권, 공기업, 빅데이터, AI
 *                  - 오라클에서 보내준 데이터를 받은 경우
 *                    NUMBER, NUMBER(4) => int
 *           - 실수 - double(8byte) : 일반적인 실수 저장시 사용하는 공간
 *                 - 오라클 NUMBER(7,2) => double
 *           - 논리 - boolean(1byte) : true/false
 *                 - 오라클에는 존재하지 않는다 (CHAR, NUMBER)
 *           - 문자/문자열 - String : 웹, 윈도우에서 가장 많이 사용되는 데이터형
 *                      - 오라클 VARCHAR2
 *       *1.오라클 컬럼과 매칭
 *            이름       널?       유형           
            -------- -------- ------------ 
            EMPNO    NOT NULL NUMBER(4)      ===> int empno (사번)
            ENAME             VARCHAR2(10)   ===> String ename (이름)
            JOB               VARCHAR2(9)    ===> String job (직위)
            MGR               NUMBER(4)      ===> int mgr (사수번호)
            HIREDATE          DATE           ===> Date hiredate (입사일)
            SAL               NUMBER(7,2)    ===> double sal (급여)
            COMM              NUMBER(7,2)    ===> dobule comm (성과급)
            DEPTNO            NUMBER(2)      ===> int deptno (부서번호)
           ===============================
            숫자형 NUMBER => int, double
            문자형 CHAR(1~2000byte) / VARCHAR2(1~4000byte) / CLOB(4GB) => String
                 ** 한글 한글자당 3byte
            날짜형 DATE => java.util.Date
 *        2.웹에 출력된 데이터 : 데이터 추출(데이터형)
 *       *변수/클래스/배열 남발하면 프로그램 짜기 어렵
 *        => 한개의 이름으로 제어, 모음
 *     2) 데이터가 많은 경우 데이터 모아서 관리 => 묶어서 사용
 *        반복문 사용 - 소스 간결  
 *                   ex) int a~z 26개 변수 설정 => 최대최소값 출력
 *                       if문 최대값 25개 최소값 25개 => 50개 if문 사용
 *                       for문 최대값 1개 최소값 1개 => 2개 for문 사용
 *        배열 - 같은 데이터형을 묶어서 한개의 이름으로 제어
 *              구분자 - 인덱스
 *              데이터형[] 배열명=new 데이터형[개수]
 *        클래스 - 다른 데이터형이 여러개 존재할 떄 한개의 이름으로 제어
 *               구분자 - 메모리 주소값 == 객체
 *               new 생성자() => 따로 메모리 생성, 저장
 *        인터페이스 / 컬렉션 - 여러 클래스를 한개의 이름으로 모아서 관리
 *        ==> 정수 10개 => 배열
 *            클래스 10개 => 컬렉션 : 배열의 단점 보완
 *     3) 변수의 종류
 *        ----- 메소드에서만 사용 가능
 *        1.지역변수 : 메소드 안에 선언되는 변수 ex)루프변수, 결과값 전송하는 변수
 *        2.매개변수 : 사용자가 보내준 요청
 *                  3개 이상 초과시 배열, 클래스 이용
 *        ----- 프로그램 종료시까지 사용, 다른 클래스에서 사용가능
 *        3.인스턴스 : 메모리 공간 따로 생성, new 사용시마다 생성
 *        4.공유변수(정적변수) : 모든 객체가 공통으로 사용가능, 한개의 메모리만 생성
 *        
 *     4) 자바에서 지원하는 메모리 공간
 *        -------- Method Area ---------
 *        Method - Method는 메소드명이 주소
 *        공유변수 - static
 *        ----------- Stack ------------
 *        메모리 자체관리 - {}끝나면 메모리 자동회수
 *        지역변수 / 매개변수
 *        ------------ Heap ------------
 *        인스턴스 변수 => new
 *        클래스 / 배열
 *        프로그래머가 관리 => 메모리해제
 *        객체null, 사용하지않는 변수 => GC
 *        new => delete
 *        malloc() => free()
 *        => 자동메모리 회수기 이용==가비지컬렉션
 *        ------------------------------
 *        
 *     5) 사용자 요청에 따라서 제어
 *        1.연산자
 *          단항연산자
 *            - 증감연산자 ++, --
 *                전치 ++a --a
 *                후치 a++ a-- => 전치보다 후치 자주 사용
 *                ex) 반복문
 *            - 부정연산자 ! : 반대 => true / false
 *                ex) String finddata="";
 *                    => if(data.contains(finddata))
 *                       if(!data.contains(finddata))
 *                    예약가능일/예약불가일, 체크인/체크아웃
 *                오라클 <>
 *                     contains => LIKE, REGEXP_LIKE()
 *                웹 대부분은 오라클 명령어를 이용해서 데이터 추출
 *                  => 모든 데이터는 오라클에 저장 후 사용, 오라클==영구적인 저장장치, 모든 사용자가 공유
 *            - 형변환 연산자 (데이터형) : 클래스도 데이터형 => 라이브러리/사용자 정의 가능
 *                왼쪽에서 받는 변수(클래스)가 크거나 같아야 함
 *                값을 받는 데이터 = 대입할 값
 *                               -----------UpCastign - 자동 형변환 ------->
 *                기본 데이터형 크기 byte < char < int < long < float < double
 *                              <----------DownCasting - 강제 형변환 -------
 *                클래스 크기 - 상속 / 포함
 *                  상속 : 상속을 받은 클래스 < 상속을 내리는 클래스
 *                  포함 : 포함하고 있는 클래스 > 포함된 클래스
 *                클래스는 상속도 상 위로 올라갈수록 크다
 *                  상속도 : 확장해서 기능 추가,변경해서 사용 extends
 *                  ↑ 올라갈수록 공통점, 추상화
 *                  ↓ 내려갈수록 구체적, 구현
 *                  모든 클래스는 Object로부터 상속을 받는다
 *                  Object : 클래스 중 가장 큰 클래스, 리턴형 Object => 형변환 필요
 *                           프로그램에 맞는 데이터형으로 변경 <제네릭>
 *          이항연산자 - 형변환 자동
 *                    프로그램 언어는 연산시에 같은 데이터형만 연산 가능
 *                      => 큰 데이터형으로 변경 후 수행, bit수가 같아야 처리
 *                         작은 데이터 형으로 통합 가능 => 형변환
 *                    ex) 'A'+1 => char + int => int + int 변경 후 연산 => 65+1=66
 *                        10+10.5 => int + double => double + double 변경 후 연산 =? 10.0+10.5=20.5
 *            - 산술연산자 +, -, *, /, %
 *               + : 산술연산, 문자열 결합
 *               / : 0으로 나눌 수 없다, 정수/정수=정수
 *                   ex) 자바 5/2=2
 *                       오라클 5/2=2.5
 *                       자바스크립트 5/2=2.5
 *               % : 남는 값이 왼쪽 부호를 따라간다
 *              ***산술 규칙
 *                 int + int = int
 *                 int + long = long
 *                 int + char = int
 *                 int + double = double
 *                 byte + byte = int
 *                 char + char = int
 *                 ------------------- 큰 데이터 형으로 반환
 *                                     int이하 데이터형은 int로 반환
 *            - 비교연산자 ==, !=, <, >, <=, >= 조건문 / 반복문 => boolean
 *               == 같다 => 오라클 =, 자바스크립트 ===
 *               != 같지 않다 => 오라클 <>, 자바스크립트 !==
 *            - 논리연산자 &&, || 두개의 조건이 있는 경우 처리 => boolean
 *               && : 두개의 조건이 true일 경우에만 true
 *               || : 둘 중에 한개의 조건이 true면 true
 *               ==> 효율적 연산
 *                   (조건) && (조건) 앞 조건이 false면 뒤 조건은 연산하지 않는다
 *                   (조건) || (조건) 앞 조건이 true면 뒤 조건은 연산하지 않는다
 *            - 대입연산자 =, +=, -=
 *              += 누적시에 주로 사용 문자열 누적, 정수 누적
 *                 ex) a+=10 ==> a=a+10
 *                 
 *          삼항연산자 - if~else
 *                    조건?값1:값2
 *                    조건 true => 값1 / false => 값2
 *                    => 자바에서는 if~else 사용 빈도가 많다
 *                       웹에서 주로 사용 자바+HTML 구분 <% 자바소스 %>
 *                       자바 + HTML => JSP => 작은 사이트 => 중소기업 사이트
 *                       자바 / HTML 분리 => MVC => 큰 사이트 => 공기업, 금융권
 *                    ex) <%
 *                            int curpage=1;
 *                            int totalpage=10;
 *                            if(curpage>1){  //prev
 *                               curpage--;
 *                        %>
 *                            <a href="list.jsp?page=<%=curpage%>">
 *                        <%    
 *                            }
 *                            if(curpage<totalpage){ //next
 *                               curpage++;
 *                        %>
 *                            <a href="list.jsp?page=<%=curpage%>">
 *                        <%
 *                            }
 *                        %>
 *                        =====>
 *                        <a href="list.jsp?page=<%=curpage>1?curpage--:curpage%>"> //prev
 *                        <a href="list.jsp?page=<%=curpage<totalpage?curpage++:curpage%>"> //next
 *                        
 *        2.제어문
 *           - 조건문 if
 *               단일 조건문
 *                 if(조건){ //조건 결과값 true/false => 부정/비교/논리연산자
 *                    조건 true일 때 수행하는 문장
 *                 }
 *                 => 독립적, 여러개 사용시 속도가 늦다 => 1번 수행 - 다중 if / 여러번 수행 - 단일 if
 *                 ex) 사용자가 요청값을 전송했는지, 입력했는지 여부
 *                     => 오라클 NOT NULL => 모든 값이 있어야 함, 필수입력
 *                 유효성겁사 : 입력여부 확인 / 제한된 값
 *                     
 *               선택 조건문
 *                 if(조건){
 *                    조건 true일 때 수행하는 문장
 *                 }else {
 *                    조건 false일 때 수행하는 문장
 *                 }
 *                 => 웹에서 많이 사용
 *                    웹에서는 무조건 브라우저로 결과값 전송 정상 or 비정상 => if or else
 *                    ex)로그인 성공 main.jsp이동 , 실패 id pw가 다르다
 *               다중 조건문 : 해당되는 1개의 조건만 수행
 *                 if(조건){
 *                    조건 true => 문장 수행 => 종료
 *                        false => 아래 else if 조건 검색
 *                 }else if(조건){
 *                    조건 true => 문장 수행 => 종료
 *                        false => 아래 else if 조건 검색
 *                 }else{
 *                    해당 조건이 없는 경우 수행하는 문장 => default 생략가능
 *                 }
 *             ===> 조건에 맞는 모든 문장 수행 - 단일 조건문 여러개
 *                  조건에 맞는 문장 한개 수행 - 다중 조건문 => 다중조건이 있을 경우 오라클에서 어렵
 *                  ex) 맛집명 name ==> name LIKE
 *                      테마 theme ==> theme LIKE
 *                      주소 address => address LIKE
 *                      맛집명+테마 ==> name LIKE AND theme LIKE
 *                    **동적 쿼리
 *             ===> 웹, 데이터베이스에서 자주 사용
 *                  
 *           - 반복문 for, while : 화면출력 => HTML(JSP)
 *               for, for-each : 반복 횟수가 지정된 경우
 *               - for
 *                      1     2    4
 *                 for(초기값;조건식;증감식){
 *                    실행문장 3
 *                 }
 *                 => 초기값 증가해서 조건이 true면 수행
 *                    초기값 -> 조건식 -> 실행문장 -> 증가식
 *                         -> 조건식 -> 실행문장 -> 증가식
 *                         -> 조건식 -> 실행문장 -> 증가식
 *                         -> 조건식 false일 때 종료
 *                 => 자바에서 반복문 필요시 일반 for문이 많다
 *                    패턴이 있는 경우에만 수행
 *               - for-each
 *                 for(데이터형 변수:배열,컬렉션){
 *                    실행문장 => 변수는 실제 저장된 데이터 값을 가지고 온다
 *                    *** 데이터형은 배열, 컬렉셔네 저장된 데이터형과 동일하거 커야한다
 *                 }
 *                 => 웹에서 출력시 대부분 for-each
 *               - 이차 for
 *                 자바개발에서는 빈도수가 적다
 *                 주로 코딩테스트에서 사용 
 *                       1    2    7
 *                 for(초기값;조건식;증감식){ //줄수
 *                          3    4    6
 *                    for(초기값;조건식;증감식){ //한줄에 출력되는 양
 *                       실행문장 5
 *                    }
 *                 }
 *                 ex) 별표출력, Stack-LIFO, Queue-FIFO
 *               while : 반복 횟수가 없는 경우, 무한스크롤
 *                       데이터베이스 - 반복 횟수를 알 수 없다
 *                                  데이터가 없을때까지 반복 rs.next()
 *               - 초기값있는 while
 *                 초기값 ----------- 1
 *                 while(조건문){ --- 2 false면 종료
 *                    실행문장 ------- 3
 *                    증감식 -------- 4 2조건문으로 이동
 *                 }
 *               - 초기값없는 while
 *                 while(조건문){
 *                    실행문장
 *                 }
 *                 => 데이터베이스에서 주로 사용
 *           ** 무한루프 => 반드시 종료 조건 설정
 *                for(;;){}
 *                while(true){}
 *           - 반복제어문 break : 반복문 중단하는 경우 사용 
 *   
 *        묶어서 한개의 이름으로 제어 => 소스간결, 유지보수 편리
 *          - 배열 - 일차원 배열
 *                  1.선언
 *                    데이터형[] 배열명; => 권장
 *                    데이터형 배열명[]; => C언어 호환
 *                  2.초기값
 *                    데이터형[] 배열명={값, 값,...};
 *                    데이터형[] 배열명=new 데이터형[개수]; => 기본값으로 초기화
 *                  3.값변경
 *                    인덱스 => 0번부터 시작
 *                    배역명[0]=값
 *                  4.출력
 *                    for-each : 출력전용
 *                    값 변경 => 일반 for문 인덱스번호 이용해서 처리
 *                **단점
 *                    - 고정적 => 한번 지정하면 변경이 어렵다 (저장개수)
 *                              각각의 저장 개수가 다를 경우 처리가 어렵다 ex)검색, 데이터베이스 프로그램
 *                  ==> 단점보완 => 가변형 - 컬렉션 ArrayList
 *                              
 *          - 메소드 - 관련된 명령문을 모아서 관리 => 재사용, 반복제거, 에러관리/기능추가 편리
 *                   1.리턴형 : 요청에 대한 처리값
 *                            기본형 => int, String
 *                                    ex)총페이지, 로그인여부
 *                            데이터가 여러개 => ArrayList => SELECT
 *                                           ex) 목록출력, 검색
 *                            관련된 데이터 => 사용자 정의 데이터형 => SELECT에서 조건이 있는 경우
 *                                          ex) 상세보기
 *                  2.매개변수 : 사용자가 요청한 값 => 브라우저 내 입력/클릭
 *                  3.메소드명 : 약속사항 - 소문자로 시작
 *                                     운영체제 호환문제로 알파벳 사용 권장
 *                                       cp949-윈도우, euc-kr한글, utf-8유니코드*
 *                **형식
 *                  [접근지정어][제어어] 리턴형 메소드명(매개변수목록){ => 선언부
 *                     구현부
 *                     return 값; => void일때만 생략가능
 *                  }
 *                    - 접근지정어 : 특별한 경우가 아니면 public
 *                                다른 클래스와 통신을 할 수 있게 한다
 *                    - 제어어 : static - 공통기반 => 데이터베이스 MyBatis
 *                             abstract - 선언하는 메소드 => 프로그램에 맞게 구현해서 사용
 *                **종류
 *                  리턴형  매개변수
 *                   O      O    ===> 가장 많이 사용
 *                   O      X    ===> 자체에서 처리
 *                   ---------------------------- 리턴형이 있다면 SELECT
 *                   X      O    ===> 데이터베이스
 *                   X      X    ===> 빈도수 거의 없음
 *                   ---------------------------- 리턴형이 없다면 INSERT/UPDATE/DELETE
 *                   ex) 사용자 요청 => 검색결과 브라우저 출력
 *                         리턴형 ArrayList
 *                         매개변수 String - 검색어
 *                       맛집 상세보기
 *                         리턴형 Food
 *                         매개변수 int - 맛집번호
 *                       로그인 요청
 *                         리턴형 String
 *                         매개변수 String - id,pw
 *                       게시글 등록
 *                         리턴형 void
 *                         매개변수 클래스 - 이름,제목,내용,비밀번호 묶어서 전송       
 *          - 클래스 - 메소드 + 변수 묶어서 사용
 *                   구성요소 역할
 *                    class ClassName{
 *                       선언만 가능 => 예외처리, 메소드 호출, 연산자, 제어문 => 구현 {}
 *                                   ex) class ClassName{
 *                                          try{}catch(Exception e){}  ==> 불가
 *                                       }
 *                                       class ClassName{
 *                                          { //블록 안에서만 구현가능
 *                                             try{}catch(Exception e){} ==> 가능
 *                                          }
 *                                       }
 *                       => 접근 범위 반드시 설정 == 접근지정어
 *                       변수 - 인스턴스 변수 - new 사용시마다 새로운 메모리 생성
 *                                         [접근지정어] 데이터형 변수명;
 *                                           기본형 (int, long...)
 *                                           배열
 *                                           클래스 (String...)
 *                                         라이브러리를 제외하고 사용자 정의일 때 은닉화 => private
 *                                         대부분의 변수는 인스턴스 변수가 기본
 *                             공유변수(정적변수 static) - 메모리 한개만 생성
 *                                                    데이터 묶음
 *                                                    모든 클라이언트가 동일
 *                       생성자, 초기화블록 - 없는 경우도 존재
 *                                       멤버변수의 초기화 담당
 *                                       생성자는 없는 경우에 자동으로 매개변수없는 디폴트 생성자 추가
 *                                        변수가 명시적인 초기화 가능할 때 생성자X
 *                                          ex)private int a=10;
 *                                        명시적인 초기화가 아니라 구현 후 초기화시에는 생성자, 초기화 블록 사용
 *                                          ex)파일읽어서 데이터 초기화, 데이터베이스에서 가져온 값으로 초기화 => 구현
 *                                        클래스 영역에서는 선언만 가능, 구현은 {} 안에서 해야함
 *                                         class ClassName{
 *                                           { //블록 안에서만 구현가능 => 초기화 블록
 *                                              try{}catch(Exception e){} ==> 가능
 *                                           }
 *                                         }
 *                                        ==> 가급적 인스턴스 초기화 => 생성자
 *                                            static 초기화 => static{}
 *                                         => 데이터베이스 드라이버 등록
 *                                            화면UI
 *                                            시작과 동시에 처리하는 명령문이 있는 경우
 *                                            ==> public 생성자 => 다른 클래스에서 연결                                      
 *                       메소드
 *                    }
 *                   클래스 종류
 *                    - 추상 클래스
 *                    - 인터페이스
 *                   객체지향 3대 특성 - 권장사항
 *                    - 데이터 보호 : 캡슐화***** 시큐어 코딩 기본
 *                                 데이터 은닉화 변수 private => getter, setter 메소드로 접근 ==> lombok - Spring에서 자동첨부
 *                    - 재사용 : 상속 / 포함
 *                    - 추가, 변경 : 오버로딩 / 오버라이딩
 *          - 라이브러리 - 만들지 못하는 기능을 자바에서 클래스 지원
 *        다른 프로그램과 연동
 *          - 오라클 연동
 *            - 오라클 명령어 사용 => JDBC
 *          - 브라우저 연동
 *            - HTML/CSS
 *          ============> 웹 사이트 제작
 *                                 
 *          브라우저 -----요청-----> 자바 --요청된 데이터 보내줘--> 오라클
 *                <-- 화면 출력 ---    <--응답 데이터 보내줌 ---
 *          ==================================================== 통합 => 스프링
 */

/*
 *  int[] arr=new int[10];
 *  int o=arr.length-1;  ==> 출력
 *  int i=0; ==> 입력
 *  
 *  int o=0;
 *  int i=0;
 */
//메모리 할당 => 메모리에 저장
import java.util.*;
class Human{
	public void display() {
		System.out.println("Human:display() Call");
	}
}
class Sawon{
	public void aaa() {
		System.out.println("Sawon:aaa() Call");
	}
	public void bbb() {
		System.out.println("Sawon:bbb() Call");
	}
	public void ccc() {
		System.out.println("Sawon:ccc() Call");
	}
}
public class 최종정리 {
	public static void main(String[] args) throws Exception{
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=i+1;
		}
		System.out.println(Arrays.toString(arr));
		
		//Stack
		for(int i=arr.length-1;i>=0;i--) {
			System.out.print(arr[i]+" ");
		}
		
		//Queue
		System.out.println();
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		//꼭 new를 써야 메모리 할당되는 건 아님
		//자바에서 가장 많이 사용
		Human h1=new Human(); //결합성이 높다 => 다른 클래스에 영향이 많다
		h1.display();
		
		Human h2=new Human().getClass().getDeclaredConstructor().newInstance();
		//getDeclaredConstructor() => 매개변수 없는 디폴트생성자호출
		h2.display();
		Human h3=Human.class.getDeclaredConstructor().newInstance();
		h3.display();
		
		//웹에서 가장 많이 사용되는 메모리 할당 - 스크링에서 주로 사용
		Class clsName=Class.forName("com.sist.main.Human");
		Method[] methods=clsName.getDeclaredMethods();
		Human h4=(Human)clsName.getDeclaredConstructor().newInstance();
		System.out.println("메소드명 없이 호출");
		methods[0].invoke(h4, null); //h4-호출 null-매개변수없이
		System.out.println("메소드명 있게 호출");
		h4.display();
		
		Class cls=Class.forName("com.sist.main.Sawon");
		Object obj=cls.getDeclaredConstructor().newInstance();
		Method[] ms=cls.getDeclaredMethods(); //선언된 메소드 다 가져와, 순차적으로 들어가지는 않을 수 있음, 실행시마다 저장순서 랜덤
		Scanner scan=new Scanner(System.in);
		System.out.print("호출할 메소드명 입력 >> ");
		String mName=scan.next();
		//Annotation => 구분자 => 스프링 ex)@override
		for(int i=0;i<ms.length;i++) {
			String s=ms[i].getName();
			if(mName.equals(s)) {
				//System.out.println(i+":"+ms[i].getName());
				ms[i].invoke(obj, null); //invoke-메소드 호출 null-매개변수
			}
		}
	}
}
