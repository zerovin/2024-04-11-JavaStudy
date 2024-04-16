/*
 * 	증감 연산자 ++, --
 * 	무조건 증가, 감소 (1씩)
 * 
	int num1=10;   
    System.out.printf("%d \n", num1);  10
    num1++;
    System.out.printf("%d \n", num1);  11
    ++num1;
    System.out.printf("%d \n", num1);  12
    --num1;
    System.out.printf("%d \n", num1);  11
    num1--;
    System.out.printf("%d \n", num1);  10

  
 */
public class 연산자문제_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=10;   
	    System.out.printf("%d \n", num1); //10
	    num1++;
	    System.out.printf("%d \n", num1); //11
	    ++num1;
	    System.out.printf("%d \n", num1); //12
	    --num1;
	    System.out.printf("%d \n", num1); //11
	    num1--;
	    System.out.printf("%d \n", num1); //10

	    char c='A';
	    char d='A';
	    System.out.println(c++); //A 출력 후 증가
	    System.out.println(++d); //B 증가 후 출력
	    
	    // 증감연산자 : 제어문 => 반복문, 횟수 구하기, 크롤링
	}

}
