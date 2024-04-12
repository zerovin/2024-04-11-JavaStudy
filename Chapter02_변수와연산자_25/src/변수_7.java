/*
 *	값 교환
 *	 
 * 
 * 
 */
public class 변수_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=100;
		int b=200;
		a=b;
		b=a;
		System.out.println("a="+a);
		System.out.println("b="+b); // 값교환 X
		
		int c=100;
		int d=200;
		int temp=c;
		c=d;
		d=temp;
		System.out.println("c="+c);
		System.out.println("d="+d); //값교환 O => 값 교환시 임시변수 필요
		
		char c1='A';
		char c2='B';
		char _temp=c1;
		c1=c2;
		c2=_temp;
		System.out.println("c1="+c1);
		System.out.println("c2="+c2); //값교환 방식은 int, char 동일
	}

}
