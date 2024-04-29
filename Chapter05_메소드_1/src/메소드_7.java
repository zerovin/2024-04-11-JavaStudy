// char return - 알파벳 전송 => 대문자는 소문자로, 소문자는 대문자로
public class 메소드_7 {
	static char upper(char c) {
		return (char)(c-32); // 'a' => 97 => 65 => (char)65 == A
	}
	static char lower(char c) {
		return (char)(c+32);
	}
	static char upperLower(char c) {
		char res=' '; //결과값이 여러개 있을 경우 => 결과를 변수선언 => return 변수;
		if(c>='A' && c<='Z') {
			res=(char)(c+32);
		}else {
			res=(char)(c-32);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c=upper('m');
		System.out.println("upper('m') >> "+c);
		c=lower('M');
		System.out.println("lower('M') >> "+c);
		
		c=upperLower('A');
		System.out.println("upperLower('A') >> "+c);
		c=upperLower('a');
		System.out.println("upperLower('a') >> "+c);
	}

}
