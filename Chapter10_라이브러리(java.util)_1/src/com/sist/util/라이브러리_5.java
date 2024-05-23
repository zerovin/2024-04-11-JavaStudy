package com.sist.util;
import java.util.*;
public class 라이브러리_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Arryas 배열 크기 조절 가능
		//배열 => 고정 - 한번 정하면 변경 불가
		//변경이 필요한 경우 새로운 배열을 만들어서 처리 copyOf
		//copyOf(복사할 배열명, 배열개수)
		Random r=new Random();
		int[] arr=new int[7];
		
		//초기화
		for(int i=0;i<arr.length;i++) {
			arr[i]=r.nextInt(100)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		//값은 arr에 있는 데이터 그대로 배열 작게 생성 => 3
		int[] sub=new int[3];
		for(int i=0;i<sub.length;i++) {
			sub[i]=arr[i];
		}
		System.out.println(Arrays.toString(sub));
		
		int[] sub2=Arrays.copyOf(arr, 3);
		System.out.println(Arrays.toString(sub2));
		
		//배열 크게 생성
		int[] sup=new int[10];
		for(int i=0;i<arr.length;i++) {
			sup[i]=arr[i];
		}
		System.out.println(Arrays.toString(sup));
		
		int[] sup2=Arrays.copyOf(arr, 10); 
		System.out.println(Arrays.toString(sup2));
	}

}
