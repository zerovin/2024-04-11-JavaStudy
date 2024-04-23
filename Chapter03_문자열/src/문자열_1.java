/*
 *	!!!!!!!!!!!!!!!!!!!!!!! 원본은 변경되지 않는다 !!!!!!!!!!!!!!!!!!!!!!
 *
 *	문자열 char[] 
 *	String - 문자열을 저장하는 데이터형 / 클래스 (기능=>메소드)
 *			프로그램에서 가장 많이 사용되는 데이터형
 *			저장되는 갯수 제한X
 *			형식)
 *				1.String name="홍길동";
 *				  ------ ----  -----
 *				  데이터형 변수명  리터럴=실제저장된값
 *
 *				2.String name=new String("홍길동");
 *			연산자)
 *				+ : 문자열 결합
 *					String name="홍길동";
 *					String etc="입니다";
 *					System.out.println(name+etc) => 홍길동입니다
 *			기능)
 *				*equals() : 같은 문자열이 있는 경우
 *				*contains() : 문자열 중에 포함 여부
 *				*startsWith() : 시작하는 문자열이 같은 경우 => 서제스트(자동완성기) => 검색
 *				endsWith() : 끝나는 문자열이 같은 경우 => 서제스트(자동완성기) => 확장자
 *				charAt() : 문자열 중에 해당 인덱스 문자 하나 추출 => char
 *				*indexOf() : 해당 문자열의 인덱스 번호 추출 (앞에서부터)
 *				*lastIndexOf() : 해당 문자열의 인덱스 번호 추출 (뒤에서부터)
 *				*length() : 문자 갯수
 *				replace() : 문자 변환
 *				*substring() : 문자를 자르는 경우
 *				toUpperCase() : 대문자 변환
 *				toLowerCase() : 소문자 변환
 *				*trim() : 공백문자 제거(좌우 공백 제거)
 *				split(), replaceAll(), *valueOf()
 *				-------------------------------------
 *				JavaScript 문자열 기능과 동일
 * 
 */
import java.util.Scanner;
public class 문자열_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String alpha="abcdefg";
		System.out.println("문자 갯수:"+alpha.length());
		System.out.println("대문자 변환:"+alpha.toUpperCase());
		alpha="ABCDEFG";
		System.out.println("소문자 변환:"+alpha.toLowerCase());
		/*
		 *	ABCDEFG 문자열은 index번호를 가지고 있다
		 *	0123456
		 *
		 */
		System.out.println("문자 추출:3번째:"+alpha.charAt(3));
		
		String myId="admin";
		String myPwd="1234";
		
		Scanner scan=new Scanner(System.in);
		System.out.print("아이디 입력 >> ");
		String id=scan.next();
		System.out.print("비밀번호 입력 >> ");
		String pwd=scan.next();
		
		if(id.equals(myId) && pwd.equals(myPwd)) { //문자열은 ==불가, equals사용
			System.out.println(id+"님 로그인되었습니다");
		}else {
			System.out.println("아이디나 비밀번호가 틀립니다");
		}
	}

}
