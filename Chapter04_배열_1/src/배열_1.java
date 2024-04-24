/*
 *	자바 => Application / Web / Mobile
 *
 *	개발 방법 
 *	- 데이터 저장 => 데이터 가공(사용자 요청) => 화면출력
 *		데이터 저장 - 한개 저장 : 변수
 *		           여러개 저장 : 배열, 클래스
 *			**배열(4장)
 *				- 일차원 배열
 *				- 같은 데이터 여러개 모아서 관리(한개 이름으로 처리)
 *				- 장점 : 변수 여러개를 한개의 이름으로 제어 => 반복문 사용이 편리
 *				        연속적 메모리 공간을 만든다 => 인덱스번호를 사용해서 처리
 *				- 단점 : 고정적 => 추가, 삭제가 어렵다(더 큰 배열, 작은 배열)
 *				        같은 데이터형만 모아서 관리 => 보완(가변형, 다른 데이터형을 모아서 관리 = **컬렉션(12장))
 *			**클래스(5장) 
 *				- 다른 데이터를 여러개 모아서 관리(한개 이름으로 처리)
 *			**변수/연산자/제어문 - 기본문법
 *			  => 모아서 관리 = 클래스, 메소드
 *			**변수/배열/클래스 => 메모리에 저장 = RAM 프로그램 종료시 삭제
 *			  => 영구적인 저장 장치 필요
 *			     파일 - 여러개 연결해서 사용하기 어렵, 보안취약
 *			     RDBMS - 관계형 데이터베이스(15장)
 *			     파일 => table = 오라클/MySQL(무료)/MS-SQL/MariaDB(무료)
 *		데이터 가공(사용자 요청)
 *			명령문을 모아서 관리 - 사용자 입력부분
 *			               - 사용자 요청처리부분
 *			               - 결과값 도출
 *			=> 재사용 가능, 유지보수 편리
 *			===> 메소드******
 *			변수 + 메소드 = 클래스
 *			ex) 게시판
 *			    - 목록 출력기능
 *			    - 글쓰기
 *			    - 상세보기
 *			    - 삭제
 *			    - 수정
 *			    - 검색
 *			    => 오더 요청 - 댓글형 게시판
 *				==> 게시판 상속받아 처리 => 댓글 추가 ===> 재사용(유지보수)
 *		화면출력
 *			브라우저 - 자바 - Web => HTML/CSS/JavaScript 호환
 *			모바일 - 코틀린(안드로이드) / 스위프트(ios) = 통합언어 Dart - Flutter, React Native
 * 
 *	개발 = 누가 잘 모아서 관리하느냐(재사용, 유지보수) - 수정,삭제,추가가 쉽게 만드는 작업
 *	      => 변수+연산자+제어문 => 기능별로 모아서 처리 => 패키지 ex) java.io java.util java.swing... 
 * 	1.변수 여러개 모아서 관리
 * 		데이터형[] 배열명=new 데이터형[저장갯수]
 * 
 * 		int a,b,c,d,e,f,g;
 * 		=> int[] arr=new int[7]
 * 
 * 		double d1,d2,d3,...
 * 		=> double[] arr=new double[갯수]
 */

// 84page 배열 필요성
import java.util.Scanner;
public class 배열_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 3명의 학생 => 국어, 영어, 수학 => 총점, 평균, 학점
		Scanner scan=new Scanner(System.in);
		int kor1,kor2,kor3;
		int eng1,eng2,eng3;
		int math1,math2,math3;
		int total1,total2,total3;
		double avg1,avg2,avg3;
		char score1,score2,score3;
		
		// 점수입력
		System.out.print("첫번째 학생 국어점수:");
		kor1=scan.nextInt();
		System.out.print("첫번째 학생 영어점수:");
		eng1=scan.nextInt();
		System.out.print("첫번째 학생 수학점수:");
		math1=scan.nextInt();
		
		System.out.print("두번째 학생 국어점수:");
		kor2=scan.nextInt();
		System.out.print("두번째 학생 영어점수:");
		eng2=scan.nextInt();
		System.out.print("두번째 학생 수학점수:");
		math2=scan.nextInt();
		
		System.out.print("세번째 학생 국어점수:");
		kor3=scan.nextInt();
		System.out.print("세번째 학생 영어점수:");
		eng3=scan.nextInt();
		System.out.print("세번째 학생 수학점수:");
		math3=scan.nextInt();
		
		// 총점
		total1=kor1+eng1+math1;
		total2=kor2+eng2+math2;
		total3=kor3+eng3+math3;
		
		// 평균
		avg1=total1/3.0;
		avg2=total2/3.0;
		avg3=total3/3.0;
		
		// 학점
		switch(total1/30) {
			case 10: case 9:
				score1='A';
				break;
			case 8:
				score1='B';
				break;
			case 7:
				score1='C';
				break;
			case 6:
				score1='D';
				break;
			default:
				score1='F';
		}
		
		switch(total2/30) {
			case 10: case 9:
				score2='A';
				break;
			case 8:
				score2='B';
				break;
			case 7:
				score2='C';
				break;
			case 6:
				score2='D';
				break;
			default:
				score2='F';
		}
		
		switch(total3/30) {
			case 10: case 9:
				score3='A';
				break;
			case 8:
				score3='B';
				break;
			case 7:
				score3='C';
				break;
			case 6:
				score3='D';
				break;
			default:
				score3='F';
		}
		
		// 결과값 출력
		/*
		 *	%-5d => 5칸을 차지하는 d를 왼쪽정렬(-)로 출력, 양수(+)는 오른쪽정렬%5d => 간격조절
		 *	%-5d => 00---
		 *	%5d => ---00
		 *
		 */
		System.out.printf("%-5d%-5d%-5d%-7d%-7.2f%-3c\n",kor1,eng1,math1,total1,avg1,score1);
		System.out.printf("%-5d%-5d%-5d%-7d%-7.2f%-3c\n",kor2,eng2,math2,total2,avg2,score2);
		System.out.printf("%-5d%-5d%-5d%-7d%-7.2f%-3c\n",kor3,eng3,math3,total3,avg3,score3);
	}

}
