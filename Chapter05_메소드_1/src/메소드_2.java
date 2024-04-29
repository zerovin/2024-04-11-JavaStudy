// 리턴형(O) 매개변수(O)
import java.util.*;
public class 메소드_2 {
	static boolean isLogin(String id, String pwd) {
		// 매개변수 개수 제한 X, 여러개 사용 가능
		// 리턴형은 하나만 사용가능
		// 매개변수가 많은 경우 => 클래스, 배열 이용 => 3개 이상
		final String ID = "admin";
		final String PWD = "1234";
		/*
		 *	메소드 안에 선언되는 변수, 상수, 매개변수 == 메소드 안에서만 사용 가능 
		 */
		boolean bCheck=false;
		if(id.equals(ID) && pwd.equals(PWD)) {
			bCheck=true;
		}else {
			bCheck=false;
		}
		return bCheck; //사용자 요청에 대한 결과값 반환
		// 리턴의 데이터형과 실제 전송하는 값(메소드 리턴형)이 같거나 메소드리턴형이 더 크게 선언
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("아이디 입력 >> ");
		String id=scan.next();
		System.out.print("비밀번호 입력 >> ");
		String pwd=scan.next();
		
		//기능요청
		//메소드에서 넘겨주는 결과값을 받는다 = 같은 데이터형 or 더 크게
		boolean bCheck = isLogin(id, pwd);
		// 숫자인 경우 큰데이터형으로 받을 수 있다 ex) int(리턴형)=>long, double
		
		//기능 처리 => 윈도우, 브라우저 화면 출력
		if(bCheck) {
			System.out.println(id+"님 로그인 되었습니다!!");
		}else {
			System.out.println("아이디나 비밀번호가 틀립니다!!");
		}
	}
}
