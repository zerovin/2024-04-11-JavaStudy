/*
 *	구구단 출력  
 *	1)반복횟수
 *	2)어디부터(초기값) 어디까지(조건식) 출력
 *	  ex)int i=1;i<=9;i++
 */
import java.util.Scanner;
public class 제어문_반복문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("단 입력:");
		int num=scan.nextInt();
		
		for(int i=1;i<10;i++) { //한개씩 증가, 1부터 9까지 수행 => 종료
			// 시작점, 종료점 => 출력 횟수
			System.out.printf("%d*%d=%d\n",num,i,num*i);
		}
	}

}
