package com.sist.main;
class AA{
	void aaa() {}
	private void bbb() {}
	protected void ccc() {}
	public void ddd() {}
}
class BB extends AA{
	//A의 메소드 변경해서 사용 => 오버라이딩
	//private 메소드인 bbb는 오버라이딩 불가
	@Override
	void aaa() {
		// TODO Auto-generated method stub
		super.aaa();
	}

	@Override
	protected void ccc() {
		// TODO Auto-generated method stub
		super.ccc();
	}

	@Override
	public void ddd() {
		// TODO Auto-generated method stub
		super.ddd();
	}
	
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BB b=(BB)new AA(); //오류 ClassCastException
		AA a=new BB();
		BB b=(BB)a; //오류X
	}

}
