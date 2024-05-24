package com.sist.util;
// 정렬
// Collections.sort()
import java.util.*;
public class 컬렉션_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// <> => 제네릭 : 반드시 클래스만 지정 가능
		// <int> <double> => 오류 
		// <Integer> <Double> Wrapper 클래스로 사용
		// Wrapper => 제네릭에 첨부, 기능 부여
		
		//ArrayList<int> list=new ArrayList<int>(); //오류 코드
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		//정수 10개 임의 추출
		Random r=new Random();
		for(int i=0;i<10;i++) {
			//int를 <Integer>클래스로 받음 => 오토박싱
			list.add(r.nextInt(100)+1); //1~100
			//r.nextInt(추출범위) 추출범위 지정안하면 -21억4천~21억4천
		}
		System.out.println("===== list 데이터 출력 =====");
		for(int i:list) { //<Integer>를 int로 받음 => 언박싱
			System.out.print(i+" ");
		}
		
		System.out.println();
		System.out.println("===== 정렬 =====");
		Collections.sort(list);
		for(int i:list) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		System.out.println("===== 복사된 데이터 출력 =====");
		//list 데이터 5개 복사
		ArrayList<Integer> list2=new ArrayList<Integer>(list.subList(0, 5));
		for(int i:list2) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		//5개 추가
		System.out.println("===== 데이터 추가 =====");
		list2.add(r.nextInt(100)+1);
		list2.add(r.nextInt(100)+1);
		list2.add(r.nextInt(100)+1);
		list2.add(r.nextInt(100)+1);
		list2.add(r.nextInt(100)+1);
		for(int i:list2) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		System.out.println("===== 데이터 추가 정렬 =====");
		Collections.sort(list2);
		for(int i:list2) {
			System.out.print(i+" ");
		}
	}

}
