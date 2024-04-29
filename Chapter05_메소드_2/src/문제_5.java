// 5. 문자열의 소문자를 대문자로 바꾸는 메소드를 구현하시오
import java.util.Scanner;
public class 문제_5 {
	static String upper(String str) {
		//return str.toUpperCase(); 라이브러리
		String result="";
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if(c>='A' && c<='Z') {
				result+=c;
			}else if(c>='a' && c<='z'){
				result+=(char)(c-32);
			}else {
				result+=c;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("소문자 입력 >> ");
		String str=scan.next();
		String res=upper(str);
		System.out.println(str+" => "+res);
	}

}
