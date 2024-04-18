/*
 *	자바에서 제공하는 제어문 - 필요한 내용만 출력(조건문, 선택문-다중조건문과 동일)
 *					  - 반복수행(for, while, do~while)
 *					  - 반복제어(종료-break, 제외-continue)
 *					  - 연산자+제어문=메소드 
 *	1)조건문 - 사용빈도가 가장 많음
 *		단일조건문 - 검색=>검색어 입력여부 확인
 *				- 상세보기
 *				- 형식)***조건문 => true/false => 부정연산자(!)/비교연산자(==,!=,<,>,<=,>=)/논리연산자(&&,||) 
 *						if(조건문){
 *							조건이 true일 때만 수행 => false면 스킵
 *						}
 *		선택조건문 - true/false를 나눠서 처리
 *				- 로그인=>로그인 된 경우/로그인이 안된 경우
 *				- 아이디중복=>중복이 없는 경우/중복인 경우
 *				- 형식)
 *					  if(조건문){ =>로그인이 된 상태
 *							조건이 true일 때 처리 => main화면으로 이동
 *						}else{ =>로그인이 안된 상태
 *							조건이 false일 때 처리 => 아이디/비밀번호가 틀리다는 메세지 전송
 *						}
 *
 *		다중조건문 - 조건 여러개 => 한개만 수행
 *				- 메뉴 클릭(웹-화면변경,종료,새로고침), 키보드 키값(게임)
 *				- 형식)
 *					  if(조건문){
 *							조건문 true일 때 처리문장 수행	==> 종료
 *						}esle if(조건문){ => 위 조건문이 false일 때
 *							조건문 true일 때 처리문장 수행	==> 종료
 *						}else{ => 모든 조건문이 false일 때
 *							해당 조건이 없는 경우에 수행 ==> 생략가능
 *						}
 *		=> 선택문 : 다중조건문을 단순화 => 웹에서는 거의 사용빈도 X, 화면이동(JSP) => Spring => Front(Router)
 *									간결해서 게임(키보드값) 받을 때 사용
 *			- 한개의 값이 있는 경우 => 선택문
 *			- 범위가 있는 경우 => 다중조건문
 *			  ex) score>=90 && score<=100 ==>10 다중조건문
 *				  score=90 91 92... 선택문
 *			- 형식)
 *				  switch(정수,문자,문자열){ =>문자(+,-,*,/)
 *						case '+' => 문자중에 +가 들어온 경우
 *							처리문장
 *							break; => 처리후에 종료
 *						case '-' => 문자중에 -가 들어온 경우
 *							처리문장
 *							break; => 처리후에 종료
 *						...
 *						default => case에 없는 데이터가 있는 경우 => 다중조건문 else
 *							처리문장
 *							break;
 *					}
 *			- 같은 처리 100/10 ==>10 9 8 7...
 *				  switch(정수){
 *						case 10:
 *							A
 *							break;
 *						case 9:
 *							A
 *							break;
 *					}
 *			  =>
 *				  switch(정수){
 *						case 10:
 *						case 9:
 *							A
 *							break; ==> break가 없는 경우도 있다
 *					}
 *					break가 없는 경우 = 밑에 있는 break까지 수행
 *
 *	*** 웹 => if / if~else / for / while
 *		기본 - 데이터베이스(SQL)80%
 *		HTML/CSS/JavaScript(화면UI) - Java(데이터처리,요쳥처리) - Oracle(데이터를 저장하는 공간-데이터베이스(영구적))
 *		└ AWS(PaaS)클라우드 => Linux
 */
import java.util.Scanner;
public class 제어문_선택문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//사용자 입력요청
		Scanner scan=new Scanner(System.in);
		System.out.print("첫번째 정수 입력:");
		int num1=scan.nextInt();
		
		System.out.print("연산자 입력(+,-,*,/):");
		char op=scan.next().charAt(0);
		
		System.out.print("두번째 정수 입력:");
		int num2=scan.nextInt();
	
		/*
		 *	문자 - ''
		 *	문자열 - " 
		 */
		//결과값 출력
		switch(op) { //문자, 정수, 문자열(실수, 논리형은 사용 불가)
			case '+':
				//처리문장
				System.out.println(num1+"+"+num2+"="+(num1+num2));
				break; //문장을 수행하고 종료
			case '-':
				System.out.println(num1+"-"+num2+"="+(num1-num2));
				break;
			case '*':
				System.out.println(num1+"*"+num2+"="+(num1*num2));
				break;
			case '/':
				if(num2==0)
					System.out.println("0으로 나눌 수 없습니다");
				else
					System.out.println(num1+"/"+num2+"="+(num1/num2));
				break;
			//연산자가 잘못된 경우
			default: //default는 생략가능
				System.out.println("잘못된 연산자 입니다");
				//마지막은 break를 사용할 수 있고 사용하지 않을 수도 있다
				//***case에 등록된 값이 중복되면 오류
				//***데이터가 일치해야한다 => case에 등록되는 데이터형 통일
		}
	}

}
