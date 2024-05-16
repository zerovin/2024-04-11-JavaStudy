package com.sist.music;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//추상클래스, 인터페이스 => 관련된 클래스를 묶어서 1개의 객체로 제어하는 목적
		//데이터 - 한개의 이름으로 여러개의 변수 제어 => 배열
		/*
		 *  추상클래스
		 *  - 공통으로 사용되고 구현이 동일한 경우
		 *    list(), find(), detail() ===> 추상클래스에서 구현
		 *  - 공통으로 사용되나 구현 내용이 다른 경우
		 *    init() => 추상클래스에서 선언만 => 각 클래스에서 구현
		 *    
		 *  메소드
		 *  - 구현된 메소드 - 상속받은 모든 클래스의 구현 내용이 동일
		 *                [접근지정어] 리턴형 메소드명(매개변수){
		 *                   구현 내용
		 *                }
		 *  - 구현 안 된 메소드 - 상속받은 클래스에서의 각각 구현이 다른 경우, 선언만 => abstract
		 *                    [접근지정어] abstract 리턴형 메소드명(매개변수); ==> {}블록없이 선언만
		 *  *** 메소드가 선언만 되어있는 경우에는 new를 이용해서 메모리에 저장 불가
		 *      new 이용해서 메모리 할당 불가 => 상속받은 클래스 이용해서(선언된 메모리 반드시 구현) 메모리 저장 후 사용
		 *  *** 메소드가 구현이 안된 경우 - 추상클래스, 인터페이스 => 미완성된 클래스
		 *      abstract class A{
		 *         public void aaa(){} => {}블록이 이으면 메소드는 구현으로 인정
		 *         public void bbb(){}
		 *         public void ccc(){}
		 *         => 구현이 안된 메소드가 반드시 포함되어야 하는 건 아님
		 *            but 다 구현되어있으면 굳이 abstract 쓸 이유가 없
		 *                => 일반클래스 사용이 편리(자체메모리할당), 추상은 무조건 상속해야 사용가능
		 *                => 하나의 객체로 여러 클래스 동시 제어할 시 추상클래스 
		 *            
		 *            구성요소는 선택사항
		 *            
		 *      }
		 *      추상클래스에서 모든 메소드가 구현이 된 경우에도 메모리 할당은 불가
		 *      => abstract 선언되어있으면 메모리할당 불가
		 */
		Scanner scan=new Scanner(System.in);
		//MusicSystem ms=new GenieMusic();
		//MusicSystem ms=new MelonMusic();
		MusicSystem ms=null; //Music과 관련된 클래스를 한개로 묶어서 처리 => 추상클래스, 인터페이스 사용
		/*
		 *	무조건 한개로 통합
		 *  변수 여러개 => 한개의 이름 => 배열
		 *  클래스 여러개 => 한개의 객체 생성 => 추상클래스
		 *  데이터 여러개 => 파일 / 오라클 
		 */
		System.out.print("1.지니뮤직 2.멜론 >> ");
		int n=scan.nextInt();
		if(n==1) {
			ms=new GenieMusic();
		}else {
			ms=new MelonMusic();
		}
		ms.init();
		
		while(true) {
			System.out.println("====== 메뉴 ======");
			System.out.println("1. 목록");
			System.out.println("2. 상세보기");
			System.out.println("3. 검색");
			System.out.println("4. 종료");
			System.out.println("================");
			System.out.print("메뉴 선택 >> ");
			int menu=scan.nextInt();
			switch(menu) {
				case 1:
					ms.list();
					break;
				case 2:
					System.out.print("번호 선택(1~50) >> ");
					int no=scan.nextInt();
					ms.detail(no);
					break;
				case 3:
					System.out.print("검색어 입력 >> ");
					String title=scan.next();
					ms.find(title);
					break;
				case 4:
					System.out.println("프로그램 종료");
					System.exit(0); //break 주면 switch-case에서만 빠져나감
			}
		}
	}

}
