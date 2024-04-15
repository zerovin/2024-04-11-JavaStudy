/*
 *	비교연산자 - 숫자에서만 사용가능 (문자열은 비교불가)
 *			  ex) "aaa" == "aaa" (X) => equals()
 *			  ** 비교연산자 결과값 = true/false => 조건문에서 주로 사용
 *			- == 같다 
 *				 자바스크립트 (===)
 *				 오라클 (=)
 *			- != 같지않다
 *			- < 작다 => 왼쪽에 있는 데이터 기준
 *			- > 크다
 *			- <= 작거나 같다 => <, ==
 *			- >= 크거나 같다 => >, ==
 *			  ex) 6==7 => false
 *				  6!=7 => true
 *				  6>7 => false
 *				  6<7 => true
 *				  6<=7 => true = 6<7 or 6==7
 *				  6>=7 => false = 6>7 or 6==7
 *				  char - 문자는 가능, 문자열은 불가
 *				  'A'=='B', 'A'!='B' ...
 *	**단항연산자/산술연산자/비교연산자/대입연산자/논리연산자/형변환
 *	  변수/연산자/제어문 => 묶음
 *			
 * 
 */
public class 연산자_비교연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 정수 비교
		int a=(int)(Math.random()*100)+1; //1~100사이의 임의의 수를 추출
		int b=(int)(Math.random()*100)+1;
		System.out.println("a="+a+",b="+b);
		
		System.out.println("======== 비교 ========");
		System.out.println("a==b:"+(a==b));
		System.out.println("a!=b:"+(a!=b));
		System.out.println("a<b:"+(a<b));
		System.out.println("a>b:"+(a>b));
		System.out.println("a<=b:"+(a<=b)); // a<b || a==b
		System.out.println("a>=b:"+(a>=b)); // a>b || a==b  ==> 44page
		
		System.out.println("======== 알파벳 비교 대문자 =========");
		char c=(char)((int)(Math.random()*26)+65); // (char)((int)((0.0~0.99)*26)+65) = (char)((0~25)+65) = (char)65~90
		
		char d=(char)((int)(Math.random()*26)+65);
		System.out.println("c="+c+",d="+d);
		System.out.println("c==d:"+(c==d));
		System.out.println("c!=d:"+(c!=d));
		System.out.println("c<d:"+(c<d));
		System.out.println("c>d:"+(c>d));
		System.out.println("c<=d:"+(c<=d));
		System.out.println("c>=d:"+(c>=d)); // char도 정수형으로 비교

		System.out.println("======== 알파벳 비교 소문자 =========");
		char e=(char)((int)(Math.random()*26)+97);
		char f=(char)((int)(Math.random()*26)+97);
		System.out.println("e="+e+",f="+f);
		System.out.println("e==f:"+(e==f));
		System.out.println("e!=f:"+(e!=f));
		System.out.println("e<f:"+(e<f));
		
		System.out.println("e>f:"+(e>f));
		System.out.println("e<=f:"+(e<=f));
		System.out.println("e>=f:"+(e>=f));
	}

}
