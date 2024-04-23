
public class 문자열_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="hello";
		String s2="HELLO";
		
		if(s1.equals(s2)) { //같은 경우 = true / 다른 경우 = false
			System.out.println("s1과 s2가 같다");
		}else {
			System.out.println("s1과 s2가 다르다"); //출력 대소문자구분O
		}
		
		if(s1.equalsIgnoreCase(s2)) {
			System.out.println("s1과 s2가 같다"); //출력 대소문자구분X => 검색시 사용 
		}else {
			System.out.println("s1과 s2가 다르다"); 
		}
		
		/*
		 *	equalsIgnoreCase : 대소문자 구분없이 비교 ex)아이디
		 *	equals : 대소문자 구분  ex)비밀번호
		 *	=> 결과값 true/false => 조건문에서 주로 사용
		 * 
		 */
		
		String msg="Hello Java";
		for(int i=msg.length()-1;i>=0;i--) {
			System.out.print(msg.charAt(i)); // 문자열 거꾸로 출력
		}
		// length() 문자갯수
		// index는 0부터 시작
		// 최대index=length-1 => 1안빼면 오류
		
	}
}
