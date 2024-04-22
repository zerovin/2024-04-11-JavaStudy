/*
 *	스프링 / 마이바티스 / JPA / 스프링 부트 => 라이브러리
 *	라이브러리 + 변수 + 연산자 + 제어문
 *			  ------------------ 메소드 
 *
 *	while 데이터베이스, 페이지나누기
 *	 - 반복하는 횟수를 모르는 경우에 주로 사용
 *	 - for/while/do~while 차이*** => 기술면접
 *	 - 형식)
 *		초기값;
 *		while(조건식){
 *			반복수행문장
 *			증감식
 *		}
 *		
 *	형식 -> 문법 -> 순서 -> 응용
 *
 *	smdmEhkIRVc\u0026pp=ygUJ67Ck7JaR6rCx
 */
import java.util.Scanner;
public class 자바제어문_반복문_9 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		/*
		Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe "
		+"http://youtube.com/embed/smdmEhkIRVc\\u0026pp=ygUJ67Ck7JaR6rCx");
		*/
		
		// 1부터 입력한 정수까지 합을 구해서 출력
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력(1~100):");
		int num=scan.nextInt();
		int sum=0;
		
		System.out.println("===== while문 =====");
		int i=1;
		while(i<=num) {
			sum+=i;
			i++;
		}
		System.out.println("while:결과값 sum="+sum);
		
		System.out.println("===== for문 =====");
		sum=0; //sum 초기화, 안하면 위 while문 결과값 그대로가져와서 55+55=110
		for(i=1;i<=num;i++) {
			sum+=i;
		}
		System.out.println("for:결과값 sum="+sum);
	}

}
