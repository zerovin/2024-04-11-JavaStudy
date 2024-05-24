package com.sist.main;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set_5 music=new Set_5();
		System.out.println("=============== 지니뮤직 ================");
		Set<String> genie=music.genieData();
		for(String title:genie) {
			System.out.println(title);
		}
		
		System.out.println("=============== 멜론뮤직 ================");
		Set<String> melon=music.melonData(); // Set은 인덱스가 없어서 subList 사용불가
		
		for(String title:melon) {
			System.out.println(title);
		}
		
		System.out.println("=========== 지니뮤직에만 있는 곡 ==========");
		Set<String> genieCopy=new HashSet<String>();
		genieCopy.addAll(genie);
		genieCopy.removeAll(melon);
		for(String title:genieCopy) {
			System.out.println(title);
		}
		
		System.out.println("=========== 멜론뮤직에만 있는 곡 ==========");
		Set<String> melonCopy=new HashSet<String>();
		melonCopy.addAll(melon);
		melonCopy.removeAll(genie);
		for(String title:melonCopy) {
			System.out.println(title);
		}
		
		System.out.println("=========== 지니뮤직 + 멜론뮤직 ArrayList ==========");
		//UNION => 중복없이 합
		//UNIONALL => 중복있는 합
		ArrayList<String> list=new ArrayList<String>();
		list.addAll(genie);
		list.addAll(melon);
		for(String title:list) {
			System.out.println(title);
		}
		System.out.println("-------- 전체 "+list.size()+"곡 ---------");
		
		System.out.println("======== 중복없이 지니뮤직 + 멜론뮤직 HashSet =======");
		Set<String> list2=new HashSet<String>();
		list2.addAll(genie);
		list2.addAll(melon);
		for(String title:list2) {
			System.out.println(title);
		}
		System.out.println("------- 전체 "+list2.size()+"곡 ---------");
	}

}
