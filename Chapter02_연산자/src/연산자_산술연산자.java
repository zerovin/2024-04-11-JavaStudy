import java.util.*; //자바에서 지원하는 라이브러리를 읽어 온다
public class 연산자_산술연산자 {
	/*
	 *	() : 최우선 순위 연산자
	 *		 ex) 5+5*10 = 5+50 = 55
	 *			 =>*, /, % -> +,- 
	 *			 (5+5)*10 = 10*10 = 100
	 *			 =>() -> *, /, % -> +,- 
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//임의로 변수 지정 int a=100
		//변수 선언
		int num1, num2; //사용시 오류 => 변수는 초기화시키고 사용 (값 지정)
		//초기화
		Random r=new Random(); //임의의 수 추출
		num1=r.nextInt(101); //0~100 사이의 정수 추출 => 마지막 숫자(101)는 제외
		num2=r.nextInt(101);
		
		System.out.println("num1="+num1);
		System.out.println("num2="+num2);
		
		
		// +
		int plus=num1+num2;
		System.out.println("plus="+(num1+num2));
		System.out.println("plus="+plus);
		
		System.out.println(5+5*10); //55
		System.out.println((5+5)*10); //100
		
		//-
		int minus=num1-num2;
		System.out.println("minus="+(num1-num2));
		System.out.println("minus="+minus);
		
		//*
		int gop=num1*num2;
		System.out.println("gop="+gop);
		
		// /, %
		int a=10;
		int b=3;
		
		System.out.println(a/b); //3
		System.out.println(a%b); //1
		System.out.println(a/(double)b); //3.33333333
		//int=>double로 변경 변수일시 (double)변수명 => 데이터형 변경
		//값이 있는 경우 = 값.0
		
		System.out.println(a%b); //1
		System.out.println(a%-b); //1
		System.out.println(-a%b); //-1
		System.out.println(-a%-b); //-1  => 왼쪽 부호를 따라감
	}

}
