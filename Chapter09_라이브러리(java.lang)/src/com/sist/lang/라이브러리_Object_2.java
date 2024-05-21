package com.sist.lang;
import java.util.*;
class Sawon{
	private String name;
	private String sex;
	//메소드를 통해서 변수에 접근 읽기/쓰기 => getter/setter => 변수 은닉화 => 캡슐화
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		//this는 Sawon의 객체 => 지역변수 우선순위
		//지역변수명=멤버변수가 같은 경우 구분자로 멤버변수는 this 이용
		//변수가 같을 수 있다 => 멤버변수(Heap), 지역변수(Stack) 변수저장위치가 달라서 같은 변수명가능
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	//toString() 오버라이딩
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "이름:"+name+", 성별:"+sex;
	}
	// toString() => default(메모리주소)
	// Object에서 오버라이딩은 toString 가장 많이 사용 => 멤버변수값 확인
	// 문자열 변환 => 자바에서 지원하는 메소드의 대부분의 리턴형이 Object
	// 클래스 저장 => 입출력이 Object
	
}
public class 라이브러리_Object_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Sawon s=new Sawon(); //메모리에 저장
		s.setName("홍길동");
		s.setSex("남자");
		System.out.println(s); //주소값 자동으로 Object=>String 변환 toString()자동호출
		System.out.println(s.toString()); //toString() 생략가능
		*/
		
		/*
		ArrayList list=new ArrayList();
		list.add(1);
		list.add(10.5);
		list.add("aaa");
		//Object라서 모든 데이터형 저장 가능 
		
		int a=(int)list.get(0); 
		double d=(double)list.get(1);
		String s=(String)list.get(2);
		//Object 리턴하기 때문에 값 받을때는 적절한 데이터형으로 형변환
		 */
		
		ArrayList<Sawon> list=new ArrayList<Sawon>(); // 데이터형이 Object가 아닌 사용자정의로 변경 <> 제네릭스
		list.add(new Sawon());
		list.add(new Sawon());
		list.add(new Sawon());
	}

}
