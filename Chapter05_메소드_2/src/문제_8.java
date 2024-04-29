// 8. 학점을 구하는 메소드를 구현하시오 => ChoiceFormat
import java.util.Scanner;
public class 문제_8 {
	static char score(int num) {
		char c=' ';
		switch(num/10) {
			case 10: case 9:
				c='A';
				break;
			case 8:
				c='B';
				break;
			case 7:
				c='C';
				break;
			case 6:
				c='D';
				break;
			default:
				c='F';
		}
		return c;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("점수 입력 >> ");
		int num=scan.nextInt();
		char c=score(num);
		System.out.println(c);
	}

}
