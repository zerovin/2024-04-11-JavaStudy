package com.sist.lang;
/*
 *  Wrapper - 모든 기본형 데이터형을 클래스화 => 사용이 쉽게 기능부여
 *  ***Integer : int
 *               문자열 => 정수로 변환
 *               Integer.parseInt(String)
 *  ***Double : double
 *              문자열 => 실수로 변환
 *              Double.parseDouble(String)
 *  ***Boolean : boolean
 *               문자열 => 논리형으로 변환
 *               Boolean.parseBoolean(String)
 *   - Float : float
 *             문자열 => 실수로 변환
 *             Float.parseFloat(String)
 *   - Byte : byte 
 *            문자열 => byte로 변혼
 *            Byte.parseByte(String)
 *   
 *  오토박싱
 *    Integer i=10;
 *  언박싱
 *    int ii=i;
 *  ===> Integer / int => 클래스 / 데이터형이지만 교환 가능, 동일하게 사용
 *  
 *  제네릭스 : 데이텨형을 변경 => 이미 만들어져있는 라이브러리의 데이터형 변경 =>
 *           메소드의 리턴형 / 매개변수
 *           등록 => 클래스만 가능
 *           <데이터형>
 *           <int> X => <Integer>
 *           라이브러리 매개변수/리턴형을 변경할 수 있다 => 형변환없이 사용
 *           
 */
class A<T>{
	T t;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t=t;
	}
}
public class Wrapper_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i=100; //클래스에 값 바로 대입
		System.out.println(i); 
		int ii=i;
		System.out.println(ii); //객체 주소가 아니라 값이 출력됨
		//Integer, int 형변환없이 동일하게 사용
		
		String s="1000"; //웹에서 자바로 보내는 모든 정수는 문자열
		System.out.println(s+1); //10001 문자열결합
		System.out.println(Integer.parseInt(s)+1); //문자열"1000"을 정수1000로 변환 => 1000+1 1001 출력
		
		A a=new A();
		a.getT(); //리턴형 Object
		
		A<String> b=new A<String>();
		b.getT(); //리턴형 String
		
	}

}
