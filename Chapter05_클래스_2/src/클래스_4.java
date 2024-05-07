//초기화 블록 => 자동 호출 클래스 블록 안에 {}\
import java.util.*;
class Sawon{
	int sabun;
	String name;
	String dept;
	String job;
	String loc;
	int pay;
	
	/*
	//이 자리에선 선언만 가능 제어문 사용 불가, 제어문은 {}안에서만 사용가능 
	for(int i=0;i<10;i++){
		sabun=i;
	}
	*/
	
	//초기화 ==> 파일읽기, 라이브러리 이용한 값 읿력, 데이터베이스 연결시 사용 => {}안에서 구현 =>자동으로 읽어서 출력
	{ //명시적 초기화가 아닐시 {}블록이 있어야 초기화 가능
		/*
		sabun=1;
		name="홍길동";
		dept="개발부";
		job="대리";
		loc="서울";
		pay=3600;
		*/
		for(int i=0;i<10;i++){
			sabun=i;
		}
	}
	
	//생성자
	/*
	 *  생성자
	 *	- 멤버변수의 초기화
	 *	- 메모리에 저장시에 호출되는 메소드
	 *	- 모든 클래스에 1개 이상 존재
	 *	- 없는 경우 컴파일시 자동으로 추가
	 *	- 특징 - 리턴형이 없다
	 *	        클래스명과 동일
	 *	        생성자는 하나가 아니라 여러개일 수 이다
	 * 
	 */
	
	void Sawon() {
		// 생성자가 아니라 일반 메소드
	}
	
	/*
	 *	기본 초기값 / 명시적 초기화 / 초기화 블록 / 생성자
	 *	=> 보통 생성자 주로 사용
	 *  => static 은 초기화 블록 사용
	 *  
	 *  class A{
	 *    int a=10;
	 *    {
	 *       a=100;
	 *    }
	 *    A(){
	 *       a=200;
	 *    }
	 *  }
	 *  A aa=new A();
	 *  
	 *  ---aa---
	 *   0x100
	 *  --------   0x100----------
	 *                   ---a---
	 *               0->10->100->200
	 *                   -------
	 *             ---------------
	 *	관련된 데이터가 여러개 저장시 => 메모리 주소를 이용해 접근 => 참조 변수(배열/클래스)
	 *	1개만 저장시 => 변수 이용
	 *	** 객체 지향 프로그램 = 여러개의 데이터 + 여러개의 메소드를 한 곳에 저장 후 동시 제어
	 *	                   -----------------------------------저장공간==객체
	 *	   객체 - 재사용**	
	 *	         수정 편리
	 *	         데이터 보호
	 *
	 *	1970년도 SW-고급언어 / HW-저급언어
	 *	SW - C언어 : 절차적언어 - 재사용X, 편집기 한번사용시 저장안됨
	 *	HW - 집적회로 : 필요시마다 재사용 가능
	 *	1980년도
	 *	SW - C++ : 객체 지향 프로그램 => 집적회로 이용 => 저장 후에 다시 사용가능 == 객체지향
	 *	     스투덤 => 몸값을 높이기 위해 일부러 어려운 언어를 만듦
	 *	     IBM C언어 개발자 양성
	 *	2001년도 ~ 2023년도 자바 개발자 양성 => 수요<공급 자바가치하락 => 최신기술(자바기반MSA,SpringCloud,SpringAI)이 경쟁력
	 *
	 */
	
	// 사용자 입력을 받아서 초기화, 파일읽기 등에 사용
	Sawon(){
		// 얘가 생성자 => 반드시 호출시에 new 생성자명()
		Scanner scan=new Scanner(System.in);
		System.out.print("사번 입력 >> ");
		sabun=scan.nextInt();
		System.out.print("이름 입력 >> ");
		name=scan.next();
		System.out.print("부서 입력 >> ");
		dept=scan.next();
	}
}
public class 클래스_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon hong=new Sawon(); //저장 => 메모리 공간 생성(sabun, name, dept, job, loc, pay)
		System.out.println("사번:"+hong.sabun); //1
		System.out.println("이름:"+hong.name); //홍길동
		System.out.println("부서:"+hong.dept); //개발부
		// Sawon(); new없이 호출하면 오류
		new Sawon(); // new 있어야 호출 가능
	}

}
