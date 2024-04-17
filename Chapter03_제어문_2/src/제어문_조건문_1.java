/*
 *	프로그램 형식
 *	1)평문 - 순차적으로 처리 => 연산자
 *	2)조건문(선택문) => 필요에 따라서 건너뛴다. 프로그램에 맞게 수행
 *	  ex)로그인, 아이디찾기, 검색, 상세보기
 *	  - 종류
 *		1.단일조건문
 *		  -형식 if(조건문){ => 조건(true/false) => 부정연산자/논리연산자/비교연산자
 *					조건이 true일 경우에만 수행하는 문장
 *				}
 *		  -부정연산자(!) = 반대효과
 *		  -논리연산자 (&&, ||) = 조건이 2개인 경우
 *			ex) id가 같고 비밀번호가 같은 경우 => &&
 *		  -비교연산자(==,!=,<,>,<=,>=)
 *		  -프로그램 - 라이브러리 사용/데이터베이스(오라클) => 데이터처리
 *			└ 사용자가 요청한 데이터만 읽기 -> 출력
 *			  └ 조건 => 사용자 요청/처리 결과물 => 사용자중심의 프로그램
 *			  └ 요구사항 분석 => 필요한 데이터 저장(데이터베이스) => 화면UI => 구현(자바) => 테스트 => 배포
 *				---아키텍처--  -----------------DBA---   --퍼블리셔-- -웹프로그래머--테스터--
 *																	  |
 *														 프론트(클라이언트)/백(서버-Java,Spring)
 *			Spring/Spring-Boot/MyBatis/JPA/JSP/MVC = Java 기반
 *			ASP.net = C# 기반
 *		2.선택조건문 => true,false를 나눠서 처리
 *		3.다중조건문 => 여러개의 조건 중 1개만 처리
 *		4.선택문 => 값 1개 선택해서 처리 ex)메뉴, 키보드(게임)
 *	3)반복문 => 같은 코딩이 여러번 나오는 경우 사용
 *	  ex)목록 출력, 검색결과 출력
 */

/*
 *	단일 조건문
 *		=>자바에서 제어문은 바로 밑에 있는 문장만 제어
 *		  if(조건문)
 *			실행문장1 ==> if문 소속문장
 *			실행문장2 ==> if문과 관련없는 문장 => 무조건 수행
 *		=>여러개의 문장을 동시에 수행
 *		  if(조건문){
 *			실행문장1 ==> if문 소속문장
 *			실행문장2 ==> if문 소속문장
 *		  }
 *		=>조건문 : 오류처리/예외처리
 *
 *	중첩조건문
 *		if(조건문){
 *			if(조건문){
 *				실행문장 ==> 두 조건문이 다 true일 때만 수행
 *			}
 *		}
 *		====>
 *		if(조건문 && 조건문){ 
 *			실행문장 ==> 두 조건문이 다 true일 때만 수행
 *		}
 */
// 숫자입력 => 같은 숫자인지 확인 ex) 11 22 33
import java.util.Scanner;
public class 제어문_조건문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		// 모든 클래스는 메모리에 저장할 때 new 이용 => 동적메모리 할당 => 메모리에 저장
		System.out.println("1~100 사이의 두자리 정수 입력:");
		int num=scan.nextInt(); //키보드로 입력된 정수값을 받는다
		
		
		if(num>=10 && num<=99) {
			//정상적으로 입력이 된 경우
			int a=num/10; //10의 자리
			int b=num%10; //1의 자리
			/*
			if(a==b) {
				System.out.println("같은 숫자입니다");
			}
			if(a!=b) {
				System.out.println("다른 숫자입니다");
			}
			*/
			if(num%11==0) {
				System.out.println("같은 숫자입니다");
			}
			if(num%11!=0) {
				System.out.println("다른 숫자입니다");
			}
		}
		if(!(num>=10 && num<=99)) {
			//오류 처리 => 사용자가 잘못 입력한 경우
			System.out.println("잘못된 입력입니다");
		}
		// 처음부터 다시 수행 => 반복문/메소드
		
	
		
		/*
		for(int i=1;i<=10000;i++) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
		*/
		int a=100;
		int b=20;
		
		int max=0;
		int min=100;
		
		if(max<a)
			max=a;
		if(max<b)
			max=b;
		
		if(min>a)
			min=a;
		if(min>b)
			min=b;
		System.out.println("max="+max);
		System.out.println("min="+min);
		
		System.out.println("max="+Math.max(a, b));
		System.out.println("min="+Math.min(a, b));
	}

}
