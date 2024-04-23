
public class 문자열_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="Hello Java";
		System.out.println(msg.replace("a", "b")); // Hello jbvb
		
		msg="홍길동 hong gil dong";
		System.out.println(msg.replaceAll("[가-힣]", "")); // hong gil dong
		System.out.println(msg.replaceAll("[a-z]", "")); //홍길동
		// 한글 전체 [가-힣]
		// 알파벳 [A-Z] [a-z]
		// 숫자 [0-9]
		// 얘네를 알아야 크롤링 가능
		
	}

}
