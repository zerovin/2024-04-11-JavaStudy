/*
 *	단항연산자
 *	1.증감연산자 : ++, -- => 1개 증가, 1개 감소
 *	  ex) int a=10;
 *		  a++;
 *		  => a+1 = 11
 *		  int a=10;
 *		  a--;
 *		  => a-1 = 9
 *
 *	  1)전치연산 : 먼저 증가 후에 대입
 *		++a, --a
 *		ex)int a=10;
 *		   int b=++a;   
 *		   => a=11, b=11
 *			1-a값을 증가
 *			2-증가값을 b에 대입
 *	  2)후치연산 : 대입 후에 나중에 증가
 *		a++, a--
 *		ex)int a=10;
 *		   int b=a++;
 *		   => a=11, b=10
 *			1-a값을 b에 대입
 *			2-a값 1개 증가
 *		**a는 전치/후치 상관없이 무조건 1개 증가
 *	  예제) 1. int a=10;
 *			  int b=++a + ++a + a++;
 *		      a = 11 -> 12 -> 13 = 13
 *		      b = 11 + 12 + 12 = 35
 *		   2. int a=10;
 *			  int b=a++ + a++ + a++;
 *			  a = 11 -> 12 -> 13 =13 
 *			  b = 10 + 11 + 12 = 33
 * 		   3. int a=10;
 * 			  int b=++a + ++a + ++a;
 * 			  a = 11 -> 12 -> 13 = 13
 * 			  b = 11 + 12 + 13 = 36
 * 		   4. int a=10;
 * 			  int b=a++ + ++a + a++;
 * 			  a = 11 -> 12 -> 13 = 13
 * 			  b = 10 + 12 + 12 = 34
 *         => 누적, 제어문(반복문), 총알
 *        
 *	2.부정연산자 
 *	3.형변환연산자(boolean제외) 
 * 
 */
public class 연산자_단항연산자_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
		int b=++a + ++a + a++;
		System.out.println("a="+a+",b="+b);
		//a = 11 -> 12 -> 13 = 13
		//b = 11 + 12 + 12 = 35 
		
		int c=10;
		int d=c++ + c++ + c++;
		System.out.println("c="+c+",d="+d);
		//c = 11 -> 12 -> 13 =13 
		//d = 10 + 11 + 12 = 33
		
		int e=10;
		int f=++e + ++e + ++e;
		System.out.println("e="+e+",f="+f);
		//a = 11 -> 12 -> 13 = 13
		//b = 11 + 12 + 13 = 36
		
		int g=10;
		int h=g++ + ++g + g++;
		System.out.println("g="+g+",h="+h);
		//a = 11 -> 12 -> 13 = 13
		//b = 10 + 12 + 12 = 34
		
		int i=10;
		i++;
		i++;
		i++;
		System.out.println("i="+i); //1씩 3번 증가 13
		
		int j=10;
		j--; //j-1=9
		j--; //j-1=8
		j--; //j-1=7
		System.out.println("j="+j); //7
		
		int k=10;
		++k;
		++k;
		++k;
		System.out.println("k="+k); //13
		
		int l=10;
		--l;
		--l;
		--l;
		System.out.println("l="+l); //7
		// 전치후치 단독사용시는 값 동일
	}

}
