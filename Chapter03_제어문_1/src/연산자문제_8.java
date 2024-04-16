/*
	int num1=10, num2=10;
    System.out.printf("%d \n", ++num1); => 증가 후 출력 => 11
    System.out.printf("%d \n", num1);    11
    System.out.printf("%d \n", num2++); => 출력 후 증가 => 10
    System.out.printf("%d \n", num2);    11
 */
public class 연산자문제_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=10, num2=10;
	    System.out.printf("%d \n", ++num1); //증가 후 출력 11
	    System.out.printf("%d \n", num1); //11
	    System.out.printf("%d \n", num2++); //출력 후 증가 10 => 다음 출력시 증가 적용
	    System.out.printf("%d \n", num2); //11

	}

}
