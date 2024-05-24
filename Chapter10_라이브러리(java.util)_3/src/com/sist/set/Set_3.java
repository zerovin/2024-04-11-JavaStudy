package com.sist.set;
import java.util.*;
class Student{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(String name, int age) {
		this.name=name;
		this.age=age;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (name+age).hashCode();
		//값이 같다면 메모리를 같게 함
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Student) {
			//instanceof => 객체 비교
			//오른쪽이 크거나 같으면 true 반환
			//객체명 instanceof 클래스명 => 클래스가 객체명보다 같거나 커야 true
			Student s=(Student)obj;
			return name.equals(s.name) && age==s.age;
		}
		return false;
	}
	
}
public class Set_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Student> set=new HashSet<Student>();
		Student s1=new Student("홍길동", 20);
		Student s2=new Student("홍길동", 20);
		
		//System.out.println("s1:"+s1);
		//System.out.println("s2:"+s2); //s1, s2 다른 메모리 => 중복제거 불가
		System.out.println("s1:"+s1.hashCode());
		System.out.println("s2:"+s2.hashCode()); //hashCode 오버라이딩해서 메모리같게 만드는 기능 설정
		
		set.add(s1);
		set.add(s2);
		for(Student ss:set) {
			System.out.println(ss.getName()+", "+ss.getAge());
		}
		
		String ss="";
		Object obj=new Object();
		StringBuffer sb=new StringBuffer();
		if(ss instanceof Object) { //true
			System.out.println("String 클래스는 Object보다 작다"); 
		}
		if(obj instanceof String) { //false
			System.out.println("Object객체는 String보다 작다");
		}
		if(sb instanceof Object) { //true
			System.out.println("StringBuffer클래스는 Object보다 작다");
		}
		//if(ss instanceof StringBuffer) { //상속, 포함이 아닌 관계에서 비교 불가 => 오류
		//	System.out.println("String클래스는 StringBuffer보다 작다");
		//}
		
		/*
		 *           Object
		 *             |
		 *     -----------------
		 *     |               |
		 *  String        StringBuffer   ==> String/StringBuffer 비교불가
		 *  
		 *  클래스 비교는 상속, 포함 관계에서만 가능
		 *  - 상속 : 상속을 내리는 클래스 > 상속을 받는 클래스
		 *  - 포함 : 포함하고 있는 클래스 > 포함 되어있는 클래스
		 *  
		 *   
		 */
	}

}
