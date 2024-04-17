//정수 2개와 연산자(+,-,*,/)를 입력 받아 사칙 연산하는 프로그램을 만들어라 
//(다중조건문 사용) 
//import java.util.Scanner;
public class 제어문_문제_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1=(int)(Math.random()*100)+1;
		int num2=(int)(Math.random()*100)+1; //1~100, 0제외
		int ops=(int)(Math.random()*4);
		char op=' ';
		
		if(ops==0) op='+';
		else if(ops==1) op='-';
		else if(ops==2) op='*';
		else if(ops==3) op='/';
		
		int num3=0;
		if(op=='+') num3=num1+num2;
		else if(op=='-') num3=num1-num2;
		else if(op=='*') num3=num1*num2;
		else if(op=='/') num3=num1/num2;
		
		System.out.printf("%d%c%d=%d",num1,op,num2,num3);
		
		/*
		Scanner scan=new Scanner(System.in);
		int num1,num2;
		char op=' ';
		System.out.print("첫번째 정수입력:");
		num1=scan.nextInt();
		
		System.out.print("연산자입력(+,-,*,/):");
		op=scan.next().charAt(0);
		
		System.out.print("두번째 정수입력:");
		num2=scan.nextInt();
		
		
		if(op=='+') {
			System.out.printf("%d+%d=%d",num1,num2,(num1+num2));
		}else if(op=='-') {
			System.out.printf("%d-%d=%d",num1,num2,(num1-num2));
		}else if(op=='*') {
			System.out.printf("%d*%d=%d",num1,num2,(num1*num2));
		}else if(op=='/') {
			if(num2==0) {
				System.out.println("0으로 나눌 수 없습니다");
			}else {
				System.out.printf("%d+%d=%d",num1,num2,(num1+num2));
			}
		}
		*/
	}

}
