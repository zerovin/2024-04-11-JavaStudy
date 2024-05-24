package com.sist.set;
import java.util.*;
public class Set_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names= {"홍길동","이순신","심청이","춘향이","박문수","강감찬","을지문덕","이순신","춘향이","이산","김두한"};
		//배열을 ArrayList로 변경 List<E> List명=Arrays.asList(배열명);
		//Arrays.asList()의 리턴형 = List
		//List => ArrayList의 상위클래스이기 때문에 List로 받아야 함. ArrayList로 받으면 오류, 형변환 필요
		List<String> list=Arrays.asList(names);
		System.out.println("===== ArrayList =====");
		for(String name:list) {
			System.out.println(name);
		}
		//중복 제거 후 출력
		//ArrayList
		//1.중복제거
		Set<String> set=new HashSet<String>();
		set.addAll(list);
		
		//2.list에 저장
		ArrayList<String> list2=new ArrayList<String>();
		list2.addAll(set);
		System.out.println("===== 중복 제거 후 ArrayList =====");
		for(String name:list2) {
			System.out.println(name);
		}
	}

}
