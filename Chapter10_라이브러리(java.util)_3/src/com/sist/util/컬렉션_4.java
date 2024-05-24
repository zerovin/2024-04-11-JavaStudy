package com.sist.util;
import java.util.*;
public class 컬렉션_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names1=new ArrayList<String>();
		names1.add("홍길동");
		names1.add("박문수");
		names1.add("이순신");
		names1.add("강감찬");
		names1.add("심청이");
		System.out.println("===== names1 출력 =====");
		for(String name:names1) {
			System.out.println(name);
		}
		
		ArrayList<String> names2=new ArrayList<String>();
		names2.add("홍길수");
		names2.add("박문수");
		names2.add("이순신");
		names2.add("강감수");
		names2.add("춘향이");
		System.out.println("===== names2 출력 =====");
		for(String name:names2) {
			System.out.println(name);
		}
		
		System.out.println("===== 데이터 복사 addAll(Collection) =====");
		ArrayList<String> temp=new ArrayList<String>();
		temp.addAll(names1); // addAll(복사하려는 컬렉션) 전체 데이터 추가
		for(String name:temp) {
			System.out.println(name);
		}
		
		System.out.println("===== 교집합 출력 retainAll(Collection) ====="); //오라클 명령어 => INTERSECT => JOIN(INNER JOIN)
		temp.retainAll(names2); //retainAll(비교대상 컬렉션) 비교대상 컬렉션과 같은 값만 저장 (원본 변경 => 복제 후 사용 추천)
		for(String name:temp) {
			System.out.println(name); 
		}
		
		System.out.println("===== 차집합 출력 removeAll(Collection)====="); //오라클 명령어 => MINUS => OUTER JOIN(LEFT, RIGHT)
		ArrayList<String> temp2=new ArrayList<String>();
		temp2.addAll(names1); //원본 변경 방지를 위해 temp로 원본 복제 후 사용
		temp2.removeAll(names2); //removeAll(비교대상 컬렉션) 비교대상 컬렉션과 다른 값만 저장 (원본 변경 => 복제 후 사용 추천)
		for(String name:temp2) {
			System.out.println(name);
		}
		/*
		 *  1 2 3 4 5 => A
		 *  3 5 7 8 9 => B
		 *  
		 *  A B 교집합 => 3 5 => retainAll() => 공통으로 있는 데이터
		 *  A-B 차집합 => 1 2 4 => A.removeAll(B) => A만 가지고 있는 데이터
		 *  B-A 차집합 => 7 8 9 => B.removeAll(A) => B만 가지고 있는 데이터
		 */
		
		System.out.println("===== 부분적 복사 subList(int start, int end) ====="); 
		ArrayList<String> names3=new ArrayList<String>(names1.subList(0, 3));
		//subList(int start, int end) 인덱스 start부터 인덱스 end-1까지의 리스트를 잘라옴
		for(String name:names3) {
			System.out.println(name);
		}
		
	}

}
