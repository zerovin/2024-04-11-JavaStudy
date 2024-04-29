// 리턴형(X) 매개변수(O)
// └ return 반환없이 메소드 자체에서 출력 => void

// 단 입력 받아서 해당 구구단 출력
import java.util.*;
public class 메소드_4 {
	// 결과값이 없을 경우 void
	static void gugudan(int dan) {
		//반복제거
		for(int i=1;i<=9;i++) {
			System.out.printf("%d * %d = %d\n",dan,i,dan*i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		gugudan(2); //반복제어 => 구조적 프로그램(단락) => 조립이 쉽게
		System.out.println("=============");
		gugudan(3);
		System.out.println("=============");
		gugudan(4);
		System.out.println("=============");
		gugudan(5);
		*/
		
		for(int i=2;i<=9;i++) {
			gugudan(i); //항상 호출시에 처음부터 수행
			System.out.println("===========");
		}
	}

}
