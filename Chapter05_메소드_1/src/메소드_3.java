
public class 메소드_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 새로운 사이트 제작 => 로그인 기능필요
		// 재사용 => 코드카피X, 기능 불러오기O
		boolean bCheck=메소드_2.isLogin("admin", "1234");
		if(bCheck) {
			System.out.println("로그인 되었습니다");
		}else {
			System.out.println("아이디나 비밀번호가 틀립니다");
		}
	}

}
