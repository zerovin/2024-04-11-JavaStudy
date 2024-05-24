package com.sist.set;
import java.util.*;
public class Set_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(("심청이"+20).hashCode());
		System.out.println(("홍길동"+20).hashCode()); //주소값 다름
		//변수값이 같을 때 같은 객체로 만들고자하면 hashCode()이용
		
		Set<Integer> set=new HashSet<Integer>();
		Random r=new Random();
		for(int i=0;i<10;i++){
			int k=r.nextInt(100)+1;
			set.add(k);
			System.out.print(k+" ");
		}
		System.out.println("\n저장된 개수:"+set.size()); //for문 10바퀴돌려도 중복제거하면 10개가 안될 수도 있음
		
		TreeSet<Integer> set2=new TreeSet<Integer>();
		set2.addAll(set);
		//50이상 출력
		System.out.println("===== 50이상 출력 =====");
		for(int i:set) {
			if(i>=50) {
				System.out.print(i+" ");
			}
		}
		System.out.println("\n-- TreeSet tailSet() --");
		System.out.println(set2.tailSet(50));
		
		System.out.println("\n===== 50이하 출력 =====");
		for(int i:set) {
			if(i<=50) {
				System.out.print(i+" ");
			}
		}
		System.out.println("\n-- TreeSet headSet() --");
		System.out.println(set2.headSet(50));
	}

}
