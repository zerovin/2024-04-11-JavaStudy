package com.sist.main2;
class AA{
	int a=10;
	int b=20;
	public void aaa() {
		System.out.println("A:aaa() Call");
	}
}
// AA a=new AA() ===> a, b, aaa()
class BB extends AA{
	//int a=10, b=20; aaa()
	int c=30;
	//AA클래스의 aaa() 수정 오버라이딩
	public void aaa() {
		System.out.println("B:aaa() Call");
	}
	public void bbb() {
		System.out.println("B:bbb() Call");
	}
}
// 상속X BB b=new BB() ===> c, aaa(), bbb()
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("======= AA ========");
		AA aa=new AA(); //AA에 설정된 변수, 메소드에만 접근
		System.out.println(aa.a);
		System.out.println(aa.b);
		aa.aaa();
		
		System.out.println("======= BB ========");
		BB bb=new BB();
		System.out.println(bb.a); //상속
		System.out.println(bb.b); //상속
		System.out.println(bb.c);
		bb.aaa(); //상속->수정
		bb.bbb();
		
		System.out.println("======= AA:new BB() ========");
		AA cc=new BB(); //변수는 AA 메소드는 BB
		System.out.println(cc.a);
		System.out.println(cc.b);
		//System.out.println(cc.c);  c는 BB변수라서 접근불가
		cc.aaa(); //AA에 있는 메소드 중 BB에서 오버라이딩한 메소드 접근
		//cc.bbb() AA에 없는 메소드라 접근 불가
		
		/*
		 *  클래스명 객체명=new 생성자()
		 *    기본적으로 클래스명 생성자 같게 객체 생성
		 *    상속을 받았을 경우 중 일부 다르게 선언가능
		 *      상속 내리는 클래스와 상속 받는 클래스의 변수, 메소드가 동일한 경우 사용
		 *      => 상속받는 클래스에 추가된 변수, 메소드가 있는 경우는 하위클래스에 접근을 못하기 때문에 사용하지 않는다
		 *      상속 받은 클래스가 여러개인 경우 사용
		 *      => 한개의 객체로 모든 클래스를 제어
		 *         ex) class A
		 *             class B extends A
		 *             class C extends A
		 *             class d extends A
		 *             
		 *             B b=new B(); (X)
		 *             C c=new C(); (X)
		 *             D d=new D(); (X)
		 *             ------------각각의 객체생성X
		 *             
		 *             A a=new B();
		 *             a=new C();
		 *             a=new D();
		 *             a=new E();
		 *             ------------한개의 객체 이용 => 추상클래스, 인터페이스
		 *         여러개의 관련된 클래스를 한개로 묶어서 관리할 목적
		 *         설계용 => 재사용
		 *         단점 - 단일상속
		 *               일반 클래스와 동일 (멤버변수, 생성자, 구현된 메소드) + 구현이 안된 메소드 포함될 수 있음
		 *    public abstract class ClassName{
		 *       변수 - static / 인스턴스
		 *       생성자 - default만 사용권장
		 *       구현된 메소드 => 일반메소드
		 *                    사이트에서 같은 기능 같은 출력일 시
		 *                    ex)로그인, 회원가입, 아이디비번찾기, 우편번호...
		 *       구현 안된 메소드 => 추상메소드 
		 *                       기능은 같으나 출력내용이 다를 시 => 선언만
		 *                       ex)목록출력, 상세페이지, 예약...
		 *    }
		 *              
		 *        
		 *    
		 *   
		 */
	}

}
