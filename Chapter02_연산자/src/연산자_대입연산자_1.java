/*
 *	대입연산자 - 메모리에 저장 = 변수에 값 대입 
 *			- "="
 *			  ex) int a=10; => 10을 a라는 메모리에 저장(대입)
 *				  int a='A'; => 형변환 65 int값으로 형변환 후 저장
 *							    작은 값은 대입가능
 *				  long l=20; => 8byte long에 4byte int 저장 => 20L로 변환 후 저장
 *				  double d=20; => 20 int가 20.0 double로 변환 후 저장
 *	복합대입연산자  - 누적, 문자열 결합 
 *				- "+="
 *				 ex) int a=10;
 *							  <--처리방향 뒤 연산처리 후 대입	
 *					 a+=1; => a=a+1; => a=11
 *					 a+=10; => a=a+10; => a=20
 *					 a+=20; => a=a+20;
 *			   - "-="
 *				 ex) a-=1; => a=a-1;
 *					 a-=10; => a=a-10;
 *			   - "*="
 *				 ex) a*=2; => a=a*2;
 *			   - "/="
 *				 ex) a/=2; => a=a/2;
 *
 *				 ex) int a=10;
 *		 			 a++;
 *		 			 a++;
 *		 			 a++;
 *		 			 a++;
 *		 			 a++;
 *		 			 => a+=5
 * 		
 * 
 * 
 */
public class 연산자_대입연산자_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double d=20;
		System.out.println("d:"+d);
		
		int a=10;
		a++;
		a++;
		a++;
		a++;
		a++;
		System.out.println("a="+a); //하나씩 증감 ++, --
		
		int b=10;
		b+=5;
		System.out.println("b="+b); //여러개씩 증감 +=, -=
		
		/*
		 *	한개 증가 | 한개 감소
		 *	  ++		--
		 *	여러개 증가 | 여러개 감소
		 *	  +=		-=
		 *
		 * 	int a=10;
		 * 	a++ / ++a / a+=1 / a=a+1 ==> 한개 증가
		 * 
		 *	int a=10;
		 *	a-- / --a / a-=1 / a=a-1 ==> 한개 감소
		 *
		 *	여러개 증가 / 여러개 감소
		 *	int a=10;
		 *	a-=5 => a=a-5
		 *	a+=5 => a=a+5
		 * 
		 */
		
		int score1=10;
		int score2=5;
		score1+=score2; // score1 = score1+score2 = 10+5 = 15
		System.out.println("score1="+score1);
		score1-=score2; // score1 = score1-score2 = 15-5 = 10
		System.out.println("score1="+score1);
		
		// 변수값 변경 => ++, --, +=, -=
		// 나머지 연산자는 변수값 변경X
		int m=10;
		m++; //변수값 변경 11
		m+=10; //변수값 변경 21
		int n=20;
		System.out.println(m+n); //변수값 변경X
		System.out.println("n="+n);
		System.out.println(n=m+n); //변수값 변경
		System.out.println("n="+n);
		
	}

}
