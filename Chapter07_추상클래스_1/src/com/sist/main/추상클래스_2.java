package com.sist.main;
// 이미 처리 메소드명은 알고 있음
// ex) 계산기 24개 버튼 => 하나의 메소드로 기능 구현
abstract class Button{
	public abstract void click(); //공통기반 선언만 => 구현내용은 다름
}
class Login extends Button{
	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("로그인 요청");
	}
}
class Join extends Button{
	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("회원가입 요청");
	}
}
//추상클래스 사용 => 결합성이 낮은 프로그램 
public class 추상클래스_2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Button btn=new Login();
		btn.click(); //로그인 요청
		btn=new Join();
		btn.click(); //회원가입 요청
	}

}
