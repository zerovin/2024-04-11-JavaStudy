/*
 *	사용자로부터 두 개의 정수를 입력 받아서
 *	뺄셈과 곱셈 연산의 결과를 출력하는 프로그램을 작성 
 */
import	java.util.Scanner;
public class 연산자문제_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("두개의 정수 입력(10 20):");
		int num1=scan.nextInt();
		int num2=scan.nextInt();
		System.out.println("===== 결과값 =====");
		System.out.println(num1+"-"+num2+"="+(num1-num2)); // -는 +랑 연산순위가 같아서 ()안하면 오류
		System.out.printf("%d-%d=%d\n",num1,num2,num1-num2); //위 식과 동일결과물 산출
		System.out.println(num1+"*"+num2+"="+num1*num2); // *는 +보다 연산순위가 우선이라 ()안해도 됨
		System.out.printf("%d*%d=%d\n",num1,num2,num1*num2); //위 식과 동일결과물 산출
		// +, - 연산 순위 동일
		// * => +보다 연산 순위가 우선
	}

}
