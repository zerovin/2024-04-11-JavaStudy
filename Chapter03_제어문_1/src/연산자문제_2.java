/*
 * int a, b;  
    a = 6;  
    b = 2;   
    System.out.printf("덧셈 연산 결과: %d \n", a+b);    8
     + 실제 산술연산, 문자열 결합
    System.out.printf("뺄셈 연산 결과: %d \n", a-b);    4
    System.out.printf("곱셈 연산 결과: %d \n", a*b);    12
    System.out.printf("나누기 연산 결과: %d \n", a/b);   3
     / 0으로 나눌 수 없다 ==> 반드시 0이 입력된 경우의 처리 필요
       정수/정수=정수
    System.out.printf("나머지 연산 결과: %d \n", a%b);   0
     % 배수 ex) 코딩테스트-화폐매수 구하기, 숫자분리, 윤년
       나머지값은 왼쪽부호를 따라간다
 * 
 */
import java.util.Scanner;
public class 연산자문제_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b;  
	    a = 6;  
	    b = 2;   
	    System.out.printf("덧셈 연산 결과: %d \n", a+b);   //8 
	    System.out.printf("뺄셈 연산 결과: %d \n", a-b);   //4
	    System.out.printf("곱셈 연산 결과: %d \n", a*b);   //12
	    System.out.printf("나누기 연산 결과: %d \n", a/b);  //3
	    System.out.printf("나머지 연산 결과: %d \n", a%b);  //0 

	    int money=369;
	    
	    // 100 => 몇개
	    int won100=money/100;
	    
	    // 10 => 몇개
	    int won10=(money%100)/10;
	    
	    // 1 => 몇개
	    int won1=money%10;
	    
	    System.out.println("100원 동전:"+won100); //3
	    System.out.println("10원 동전:"+won10); //6
	    System.out.println("1원 동전:"+won1); //9
	    
	    //윤년 구하기
	    Scanner scan=new Scanner(System.in);
	    System.out.print("년도 입력:");
	    int year=scan.nextInt();
	    if((year%4==0 && year%100!=0)||(year%400==0)) { //4년마다 한번 단,100년에 한번은 제외
	    	System.out.println(year+"년도는 윤년입니다");
	    }
	    if(!(year%4==0 && year%100!=0)||(year%400==0)) {
	    	System.out.println(year+"년도는 윤년이 아닙니다");
	    }
	}

}
