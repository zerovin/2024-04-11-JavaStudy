/*
 	int num1=10, num2=10;   
    int a, b;   
    num1 = num1 + 1;
    a = num1;
    System.out.printf("%d, %d \n", a, num1); //a=11, num1=11
    b = num2;
    num2 = num2 + 1;
    System.out.printf("%d, %d \n", b, num2); //b=10, num2=11

 */
public class 연산자문제_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=10, num2=10;   
        int a, b;   
        num1 = num1 + 1; //num1+=1 == ++num1 증가 후
        a = num1; //11 대입
        System.out.printf("%d, %d \n", a, num1); //11, 11
        b = num2; //b=10 대입 후
        num2 = num2 + 1; //num2=11 == num2++ 증가
        System.out.printf("%d, %d \n", b, num2); //10, 11

	}

}
