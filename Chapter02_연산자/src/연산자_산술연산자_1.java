/*
 *	+
 *	1) 산술연산자 (더하기 연산자)
 *		ex)10+10=20
 *	2) 문자열 결합 
 *		ex)"7"+7 = "77"
 *		   7+"7" = "77"
 *		   7+7+"7" = 14+"7" = "147"
 *		   7+"7"+7+7 = "77"+7+7 = "777"+7 = "7777"
 * 		   7+"7"+7*7 = 7+"7"+49 = "77"+49 = "7749"
 * 	() - 우선순위 변경
 * 	/ - 정수/정수=정수
 * 	% - 나머지는 왼쪽 부호를 따라간다
 *  **같은 데이터형끼리만 연산가능
 *    ex) int + long = long + long = long
 *    	  double + int = double + double = double
 *    	  => 최종 결과값은 가장 큰 데이터형을 결과값으로 처리
 * 
 */
public class 연산자_산술연산자_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// char + int = int
		char c='A';
		int i=10;
		System.out.println(c+i); //75 int
		
		// double + int = double
		double d=10.5;
		System.out.println(d+i); //20.5 double
		
		// byte + byte = int
		byte b1=10;
		byte b2=20;
		//byte b3=b1+b2; // byte+byte는 int인데 byte로 받아서 오류
		int b3=b1+b2;
		System.out.println(b3);
		
		// char + char = int
		char c1='A';
		char c2='B';
		int c3=c1+c2;
		System.out.println(c3);
		
		// char + byte + double + float = double
		char d1='A'; //65
		byte d2=100;
		double d3=10.5;
		float d4=10.5F;
		System.out.println(d1+d2+d3+d4);
		
		// int + long + float = float
		int e1=100;
		long e2=100L;
		float e3=10.5F;
		System.out.println(e1+e2+e3);
		
		// byte < char < int < long < float < double
		// 자동변경 => 데이터형이 다른 경우
		
	}

}
