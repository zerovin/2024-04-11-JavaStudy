package com.sist.main2;
class A{
	int c; //전역변수, 멤버변수
	public int add(int a, int b) { // 지역변수 사용시 리턴형 필요
		int c=a+b; //지역변수 - 메소드 호출과 동시에 사라짐
		return c;
	}
	public void plus(int a, int b) { //멤버변수 사용시 공유가 되기에 void사용
		c=a+b;
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		//a.add(10, 20); // c변수 == 지역변수 => 메모리 회수
		int c=a.add(10, 20); //리턴형으로 값을 받아서 메모리 생성 후 출력
		System.out.println(c);
		a.plus(10,20);
		System.out.println(a.c); //멤버변수 == 프로그램 종료시까지 사라지지 않는다
	}

}
