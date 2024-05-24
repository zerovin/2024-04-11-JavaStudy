package com.sist.util;
import java.util.*;
//사용자 정의
class Student{
	private int hakbun;
	private String name;
	private int kor,eng,math;
	
	//읽기 / 쓰기 기능 추가
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	//데이터 추가 우클릭 => Source => Generate Constructor Using Field에서 자동생성
	public Student(int hakbun, String name, int kor, int eng, int math) {
		//super(); 보통 삭제
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	//매개변수 있는 생성자 생성시 자동으로 디폴트생성자가 만들어지지 않기 때문에 디폴트 생성자를 만들어 준다 => 제어편리
	public Student() {
		//디폴트 생성자 초기화 => 모든 학생 정보가 같은 값을 가지고 저장 됨 => 매개변수 있는 생성자로 각자의 값을 받아 생성
	}
}
class A{
	int a,b;
	public A() {
		a=10;
		b=20;
	}
	public A(int a, int b) {
		this.a=a;
		this.b=b;
	}
}
/*
 *  A aa=new A();
 *  ---aa---
 *  --------   --------
 *              ------
 *                10  ===> a
 *              ------
 *                20  ===> b
 *              ------
 *            ---------
 * 
 *  A cc=new A(100,200);  ==> 각 데이터의 초기값을 따로 가지고자 할 때는 매개변수 있는 생성자 사용
 *  ---cc---
 *  --------  --------
 *             ------
 *               100  ===> a
 *             ------
 *               200  ===> b
 *             ------
 *            ---------
 */

public class 컬렉션_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> list=new ArrayList<Student>();
		// Object => Student 변경
		list.add(new Student(1, "홍길동", 90, 80, 70));
		list.add(new Student(2, "박문수", 78, 83, 75));
		list.add(new Student(3, "이순신", 95, 80, 70));
		list.add(new Student(4, "이산", 89, 80, 70));
		list.add(new Student(5, "심청이", 67, 80, 70));	
		System.out.println(list); //객체 주소값 출력
		
		System.out.println("===== 데이터 출력 =====");
		// 배열, 컬렉션 => for-each 이용해서 출력
		for(Student std:list) {
			//서식이 있는 출력 => 출력 형식 만들어서 처리
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
					std.getHakbun(),std.getName(),std.getKor(),std.getEng(),std.getMath());
			//웹 => String.format("%-3d%-5s%-5d%-5d%-5d\n")
		}
		/*
		 *  %d => 정수
		 *  %s => 문자열
		 *  %c => 문자
		 *  %f => 실수
		 *  
		 *  %-3d => --- 세자리 출력
		 *          - 음수 왼쪽 정렬 ex) 1--
		 *          + 양수 오른쪽 정렬 ex) --1
		 *  %-5s => ----- 다섯자리 출력
		 *          - 음수 왼쪽 정렬 ex) 홍길동--
		 *          + 양수 오른쪽 정렬 ex) --홍길동
		 */
		System.out.println("===== 데이터 추가 1 =====");
		Student s=new Student();
		s.setHakbun(6);
		s.setName("강감찬");
		s.setKor(78);
		s.setEng(90);
		s.setMath(60);
		list.add(s);
		for(Student std:list) {
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
					std.getHakbun(),std.getName(),std.getKor(),std.getEng(),std.getMath());
		}
		
		System.out.println("===== 데이터 추가 2 =====");
		list.add(new Student(7, "춘향이", 89, 80, 90));
		for(Student std:list) {
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
					std.getHakbun(),std.getName(),std.getKor(),std.getEng(),std.getMath());
		}
		System.out.println("===== 데이터 출력 =====");
		//인덱스 출력 안필요하면 for-each
		for(Student std:list) {
			/*
			System.out.println(std.toString()); //각 객체 주소값 출력
			System.out.println(std);//각 객체 주소값 출력
			*/
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
					std.getHakbun(),std.getName(),std.getKor(),std.getEng(),std.getMath());
		}
		
		//인덱스가 필요할 땐 i사용하는 for문
		for(int i=0;i<list.size();i++) {
			Student std=list.get(i); //형변환없이 사용가능
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
					std.getHakbun(),std.getName(),std.getKor(),std.getEng(),std.getMath());
		}
		
		System.out.println("===== 데이터 삭제 =====");
		list.remove(3);
		for(Student std:list) {
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
					std.getHakbun(),std.getName(),std.getKor(),std.getEng(),std.getMath());
		}
		
		System.out.println("===== 데이터 수정 =====");
		list.set(1, new Student(2, "수정", 90, 90, 90));
		for(Student std:list) {
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
					std.getHakbun(),std.getName(),std.getKor(),std.getEng(),std.getMath());
		}
		
		System.out.println("===== 데이터 전체 삭제 =====");
		list.clear();
		System.out.println("현재인원 : "+list.size());
	}

}
