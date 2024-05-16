package com.sist.main2;
//추상클래스의 단점
//=> 상속을 내리는 클래스 => 상속을 받을 수 없다
abstract class AAA{
	int a;
	public abstract void aaa();
	public void bbb() {
		
	}
}
class BBB extends AAA{
	// a,bbb(), aaa() => 상속받음
	// aaa()는 추상클래스 => 구현이 안된 상태
	int b;
	public void ccc() {
		
	}
	//aaa() 구현 후 사용
	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}
}
class CCC{
	int a, b;
	public void ddd() {}
}
class DDD extends CCC{
	//a,b,ddd()
	int c;
	public void eee() {}
}
/*
 *  상속을 내린 클래스는 자신의 변수, 메소드 접근
 *  상속을 받은 클래스는 자신의 변수, 메소드, 상위클래스에서 상속받은 변수, 메소드 접근
 *  CCC 선언 => a, b, ddd()
 *  DDD 선언 => a, b, ddd(), c, eee() 
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AAA aa=new BBB(); // AAA로 선언되었기 때문에 BBB에 있는 int b, ccc() 사용불가
		BBB aaa=new BBB(); // AAA에 있는 int a, aaa(), bbb(), int b, ccc() 사용가능
		//추가한 변수, 메소드가 있는 경우에 상속 받은 클래스로 선언해야 상하위클래스의 모든 변수,메소드 사용가능
			
		
	}

}
