package com.sist.main;
/*
 *	데이터 저장  ==========> 데이터 요청 처리 ========> 화면 출력
 *	1.변수                    1.연산자            1.명령프롬프트 - System.out.println()
 *	2.배열                    2.제어문            2.윈도우 - JFrame
 *	3.클래스                   3.메소드            3.브라우저 - HTML
 * --------                ----------
 *	파일/오라클                  클래스
 * 
 * 	1.묶는 방법
 *    - 데이터 묶기
 *      - 배열
 *      - 클래스 : 변수만 설정 getter/setter
 *    - 명령문 묶기 : 메소드 ~Manager
 *    - 데이터+명령문 동시에 묶기 : 클래스
 *	2.사용범위지정 - 접근지정어
 *    - private : 자신의 클래스 내에서 접근가능 => 데이터를 감추는 경우 == 은닉화
 *    - default : 같은 패키지 안에서만 접근가능
 *    - protected : 같은 패키지 안에서 접근가능 + 상속 받은 경우 다른 패키지 접근도 가능
 *    - public : 패키지 상관없이 모든 클래스에서 접근가능
 *    **공개 - public
 *    	      class Main{
 *               public JButton b=new JButton("로그인");
 *            }
 *      비공개 - private
 *             class Member{
 *                private String id;
 *                private String pwd;
 *             }
 *    **윈도우 관련 = 공개 public ex) Button/TextField
 *      정보 = 비공개 private ex) 개인정보, 영화정보...
 * 
 *	패키지 - 관련 클래스를 묶어서 관리 => 검색(찾기) 편리
 *         분업 가능
 *         형식) 회사 com.회사명.구분자(기능명)
 *              그룹 org.그룹명.구분자(기능명)
 *              학교 ac.학교명.구분자(기능명)
 *         클래스 구분 폴더
 *         식별자 사용 - 알파벳 소문자 사용
 *                    숫자 맨 앞 사용불가
 *                    키워드 사용불가
 *                    특수문자 _ $ 가능하나 거의 사용하지않음
 *                    공백 불가
 *         ex) com.회사명.dao => 오라클(데이터베이스) 연결
 *             com.회사명.manager => 파일, 이메일, 뉴스(외부API)...
 *             com.회사명.vo => 데이터형 모음(사용자 정의 데이터형)
 *             com.회사명.service => BI(통합) => 조립
 *             com.회사명.controller => 브라우저 연결
 *         패키지는 반드시 첫번째줄에 사용, 한번만 사용
 *         패키지 불러오는 방법 - import com.회사명.dao.*; => dao폴더 안에 있는 모든 클래스 불러오기
 *                          import com.회사명.dao.BoardDAO => BoardDAO 클래스 하나만 불러오기
 *         패키지가 다를 경우 같은 이름의 클래스 생성 가능
 *           ex) com.sist.dao - Board.java
 *               com.sist.vo - Board.java 
 *               ==> 패키지가 다르기에 둘다 생성가능
 *               ==> 한 곳에서 같은 이름의 클래스를 불러올 경우 충돌
 *                   import java.util.*; => Date
 *                   import java.sql.*; => Date
 *                   Date date=new Date(); => 오류발생
 *                   ===> 어디서 가져다 쓸건지 지정해주면 오류 해결
 *                        import java.util.Date; => Date //util의 Date를 가져옴
 *                        import java.sql.*; => Date
 *	
 *	변수 연산자 제어문
 *	    ---------
 *	       메소드
 *	-------------
 *	    클래스
 *	------------- 관련된 클래스 여러개 => 패키지
 *
 *	**멤버변수(지역변수 제외) => private
 *	**클래스, 메소드, 생성자 => 다른 클래스와 연결 => public
 *
 *	클래스 - 설계
 *	메소드 - 기능설정
 *	생성자 - 시작점, 초기화
 *	변수 - 화면출력 데이터모음
 *	---------------------자바
 *	+ 인터페이스, 예외처리, 추상클래스
 *
 *	객체지향프로그램 - 유지보수 초첨 => 수정, 추가 => 다형성
 *	                ex) 게시판 답변 느려요 => 실시간 채팅 => 직원 상주 불가 => 챗봇
 *	              재사용
 *	                ex) 게시판 묻고답하기 => 기존 게시판 활용 => 재사용 / 상속, 포함
 *	              데이터 손실 방지 => 캡슐화
 *	              **캡슐화, 상속, 다형성 == 객체지향 프로그램 권장사항, 필수X
 *	                캡슐화는 계속 사용 - 변수 private, 사용가능하게 getter/setter 
 *	                             
 *
 */
public class 접근지정어_정리 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	
	}

}
