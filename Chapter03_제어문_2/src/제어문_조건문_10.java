//문자를 받아서 => 대문자/소문자/숫자/기타
import java.util.Scanner;
public class 제어문_조건문_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("문자입력:");
		char c=scan.next().charAt(0); //문자 1개를 받는 경우
		
		//범위 => &&
		if(c>='A' && c<='Z') { //대문자
			System.out.println(c+"는(은) 대문자입니다");
		}else if(c>='a' && c<='z') { //소문자
			System.out.println(c+"는(은) 소문자입니다");
		}else if(c>='0' && c<'9') { //숫자, 문자를 하나만 받았기 때문에 범위는 0~9
			System.out.println(c+"는(은) 숫자입니다");
		}else {
			System.out.println(c+"는(은) 알파벳, 숫자가 아닙니다");
		}
		
		// 난수 => 0,1,2만 입력될 시
		/*
		 *	if(num==0)
		 *	else if(num==1)
		 *	else if(num==2)
		 *	입력값이 고정이면 예외가 없기에 else문장 생략가능
		 */
	}

}
