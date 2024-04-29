// 3. 1~n까지 합을 구하는 메소드를 구현하시오
// 리턴형O 매개변수O
import java.util.Scanner;
public class 문제_3 {
	static int numTotal(int n) { 
		int total=0;
		for(int i=1;i<=n;i++) {
			total+=i;
		}
		return total;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력 >> ");
		int n=scan.nextInt();
		int total=numTotal(n);
		System.out.println("1~"+n+"까지의 합 = "+total);
	}

}
