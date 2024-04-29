// 사용자로부터 2개의 정수를 받아 결과값 전송
import java.util.*;
public class 메소드_계산기 {
	static int add(int a, int b) {
		return a+b;
	}
	static int minus(int a, int b) {
		return a-b;
	}
	static int gop(int a, int b) {
		return a*b;
	}
	static String div(int a, int b) { 
		//리턴형 정답, 고정X  프로그램에 맞게 설정
		
		String result="";
		if(b==0) {
			System.out.println("0으로 나눌 수 없습니다");
		}else {
			result=String.valueOf(a/b);
		}
		return result;
	}
	//사용자 요청 => 매개변수 => 처리 => 결과값=리턴형 
	//리턴형은 1개만 사용 가능
	/*
	 *      데이터첨부 => 매개변수
	 *      --|   |----------
	 *      |                |
	 *      |      처리       | => {구현부}
	 *      |                |  
	 *      |---------|   |---
	 *             결과값도출 => 리턴형
	 *             
	 *     ex)
	 *     	  과일(매개변수) ==> 믹서기(구현) ==> 즙(결과값)
	 *        GPT 사용자입력(매개변수) ==> 구글링/데이터만들기(메소드/구현) ==> 화면(결과값)
	 *
	 *	1.사용자가 보내주는 값? 어떤 값을 받을지? ==> 매개변수
	 *	2.처리방법 ==> {구현부}
	 *	  변수/연산자/제어문 ==> 명령문 ==> 명령문의 집합(메소드)  
	 *	3.어떤 결과값 도출 ==> 리턴형
	 *
	 *	**소스를 구분 => 기능별 분리 => 가독성이 좋다(알아보기 쉽다), 오류시에 메소드만 찾음, 필요시 변경가능
	 *	  재사용 가능
	 *	  게임을 다시 시작가능 ∵메소드는 호출시마다 처음부터 다시 구동
	 *    결과값이 많은 경우 => 정렬 => 배열, 클래스
	 *    리턴형 => 배열, 정수, 실수, 문자, 문자열, 논리, 클래스
	 *            int[] method()
	 *            int method()
	 *            double method()
	 *            String method()
	 *            char method() 
	 *            boolean method()
	 *            Sawon method()
	 *    매개변수 => 배열, 정수, 실수, 문자, 문자열, 논리, 클래스 (기본형, 클래스)
	 *    **리턴형, 매개변수의 차이는 개수 => 리턴형은 하나만, 매개변수는 여러개 가능
	 *      매개변수의 개수를 모르는 경우도 있을 수 있음 ex(회원가입 - 필수외의 입력은 안해도 됨)
	 *      => 가변 매개변수(...)
	 *     
	 */
	// 계산값 출력
	static void process() {
		Scanner scan=new Scanner(System.in);
		System.out.print("첫번째 정수 입력 >> ");
		int num1=scan.nextInt();
		
		System.out.print("연산자 입력(+,-,*,/) >> ");
		char op=scan.next().charAt(0);
		
		System.out.print("두번째 정수 입력 >> ");
		int num2=scan.nextInt();
		
		
		switch(op) {
			case '+':
				System.out.printf("%d + %d = %d\n",num1,num2,add(num1,num2));
				break;
			case '-':
				System.out.printf("%d - %d = %d\n",num1,num2,minus(num1,num2));
				break;
			case '*':
				System.out.printf("%d * %d = %d\n",num1,num2,gop(num1,num2));
				break;
			case '/':
				System.out.println(div(num1,num2)); //String으로 나와야하는 값이 있어 printf로 출력 불가
				break;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// main에서는 메소드들 조합, 연결만
		process();
		
		//PrintStream java.io.PrintStream.printf(String format, Object... args)
		//                                                      Object는 모든 데이터형을 받을 수 있다(최상위클래스)
		//                                                            ...개수를 모름, 매개변수 개수제한X
		System.out.printf("");
		Object i=10;
		i="";
		i='A';
		i=10.5;
		i=true;
		i=new Scanner(System.in);
		// Object는 다 담을 수 있음
	}

}
