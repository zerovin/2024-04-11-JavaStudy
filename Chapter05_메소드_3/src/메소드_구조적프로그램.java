/*
 * 	구조적이 프로그램
 *	 소스가 많은 경우 => 나열X 기능별분리O
 *	 문장으로 치면 단락 나누기
 *	 ==> 오류 발생시 해당 메소드만 찾으면 됨 
 *       수정하기 편리
 *	메소드
 *	- 재사용 - 다른 클래스와 연결
 *	         신뢰성이 뛰어나다(검증이 된 상태)
 *	         소스량을 줄일 수 있다
 *	         개발 속도가 빠르다(조립=>약간의 수정)
 *	         관련사이트 제작 편리
 *	         ex) 영화-메가박스,CGV,롯데시네마
 *	             음악-지니뮤직,멜론
 *	             예약-영화예매,항공예약,맛집예약
 *	- 반복제거 - 같은 내용 소스코딩 => 한개로 통합
 *	          수정이 편리
 *	          개발(SI) => 유지보수(SM) ex)개발1년=>유지보수10~15년
 */

// 국어,영어,수학,물리,국사,화학 점수 입력 => 출력
import java.util.*;
public class 메소드_구조적프로그램 {
	static int input(String msg) {
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력 >> ");
		return scan.nextInt();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		Scanner scan=new Scanner(System.in);
		System.out.print("국어 입력 >> ");
		int kor=scan.nextInt();
		System.out.print("영어 입력 >> ");
		int eng=scan.nextInt();
		System.out.print("수학 입력 >> ");
		int math=scan.nextInt();
		System.out.print("물리 입력 >> ");
		int phy=scan.nextInt();
		System.out.print("국사 입력 >> ");
		int his=scan.nextInt();
		System.out.print("화학 입력 >> ");
		int che=scan.nextInt();
		*/
		
		int k=input("국어");
		int e=input("영어");
		int m=input("수학");
		int p=input("물리");
		int h=input("국사");
		int c=input("화학");
	}

}
