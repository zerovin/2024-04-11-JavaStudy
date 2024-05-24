package com.sist.util;
import java.util.*;
public class 컬렉션_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names=new ArrayList<String>(); //가변형
		//추가 => 문자열만 추가 => String이니까
		names.add("홍길동"); //인덱스0
		names.add("박문수"); //인덱스1
		names.add("심청이"); //인덱스2
		names.add("이순신"); //인덱스3
		names.add("강감찬"); //인덱스4
		
		System.out.println("===== 저장된 데이터 출력 =====");
		for(int i=0;i<names.size();i++) {
			String name=names.get(i);
			System.out.println(i+":"+name);
		}
		System.out.println("===== 데이터 추가 후 인덱스 확인 =====");
		//add(값) 맨 마지막에 추가 => 속도가 빠름
		names.add("춘향이"); //인덱스5
		for(int i=0;i<names.size();i++) {
			String name=names.get(i);
			System.out.println(i+":"+name);
		}
		System.out.println("===== 지정된 위치에 추가 =====");
		//add(추가할 위치 인덱스, 값) 해당 인덱스위치에 추가, 지정 인덱스 뒤에 있는 데이터는 인덱스 1씩 증가(자동)
		//add() 오버로딩 => add(String s), add(int index, String s)
		names.add(3,"이산");
		for(int i=0;i<names.size();i++) {
			String name=names.get(i);
			System.out.println(i+":"+name);
		}
		System.out.println("===== 데이터 수정 =====");
		//set(int index, String s) 해당 위치 인덱스의 값을 변경
		names.set(1, "박문수 수정");
		for(int i=0;i<names.size();i++) {
			String name=names.get(i);
			System.out.println(i+":"+name);
		}
		System.out.println("== 인덱스 3 데이터 수정 ==");
		names.set(3, "이산 수정");
		for(int i=0;i<names.size();i++) {
			String name=names.get(i);
			System.out.println(i+":"+name);
		}
		System.out.println("===== 데이터 삭제 =====");
		//remove(int index) 해당 인덱스 삭제, 지정 인덱스 뒤에 있는 데이터는 인덱스 1씩 감소(자동)
		names.remove(2);
		for(int i=0;i<names.size();i++) {
			String name=names.get(i);
			System.out.println(i+":"+name);
		}
		System.out.println("===== 저장 개수 확인 =====");
		System.out.println("현재 인원:"+names.size());
		
		System.out.println("===== 전체 삭제 =====");
		names.clear();
		System.out.println("현재 인원:"+names.size());
	}

}
