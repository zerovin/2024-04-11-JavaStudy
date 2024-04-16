import java.util.Scanner; // 자바에서 지원하는 클래스를 읽어올 때 사용
public class 연산자_삼항연산자_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c='A';
		System.out.println(c>='A' && c<='Z'?"대문자":"소문자");
		
		Scanner scan=new Scanner(System.in);
		// 클래스는 저장할 때 반드시 new(동적메모리할당)
		// System.in => 키보드로부터 값을 받는다
		System.out.print("알파벳 입력:");
		char c1=scan.next().charAt(0); //문자 1개 받을 경우
		System.out.println("c1="+c1);
		// 문자 입력 scan.next().charAt(0);
		// 정수 입력 scan.nextInt();
		// 논리 입력 scan.nextBoolean();
		// 실수 입력 scan.nextDouble();
		/*
		 *	변수
		 *	- 초기화(저장방법)
		 *	  1)명시적 초기화
		 *		int a=10;
		 *	  2)난수 Math.random() => 알파벳 만들기 어렵
		 *	  3)입력값 받기 Scanner(간단하게 입력값 받기 가능) / BufferedReader(실무에선 얘 더 많이 씀, 예외처리) 
		 * 
		 */
		System.out.println(c1>='A' && c1<='Z'?"대문자":"소문자");
	}

}
