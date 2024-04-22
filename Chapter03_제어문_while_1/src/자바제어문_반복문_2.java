/*
 *	while 형식
 *	
 *	초기값
 *	while(조건식){
 *		반복 실행문장
 *		증감식
 *	}
 *
 *	주로 사용은 무한루프, 횟수를 알 수 없는 경우 ex)파일읽기, 데이터베이스, 메뉴
 *	└ 종료할 수 있는 프로그램이 존재해야함 = break;
 * 
 */
// 단을 입력받아서 해당 구구단 출력
import java.util.Scanner;
public class 자바제어문_반복문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("2~9사이의 정수 입력 >> ");
		int dan=scan.nextInt();
		
		System.out.println("===== for문 =====");
		for(int i=1;i<=9;i++) {
			System.out.printf("%d * %d = %d\n",dan,i,dan*i);
		}
		System.out.println();
		System.out.println("===== while문 =====");
		int i=1;
		while(i<=9) {
			System.out.printf("%d * %d = %d\n",dan,i,dan*i);
			i++;
		}
	}

}
