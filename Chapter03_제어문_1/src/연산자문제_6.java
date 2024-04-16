/*
	int num1=10, num2=10;   
	int a, b;   
	a = ++num1; => 전치연산자 => 먼저 증가 => 증가된 값을 대입
	b = num2++; => 후치연산자 => 먼저 대입 => 대입 후 증가

	System.out.printf("%d, %d \n", b, num2);  10, 11
 */
public class 연산자문제_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=10, num2=10;   
	    int a, b;   
	    a = ++num1; // a=11 num1=11
	    b = num2++; // b=10 num2=11

	    System.out.printf("%d, %d \n", b, num2); //10, 11
	}
}