package com.sist.util;
//Arrays 326page
/*
 *  toString() - 배열의 데이터 출력
 *  sort() - 데이터정렬(ASC-오름차순)
 *  copyOf() - 기존 배열을 복사해서 새로운 크고 작은 배열 생성
 *  
 */
import java.util.*;
public class 라이브러리_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		int[] arr=new int[7];
		//초기화
		for(int i=0;i<arr.length;i++) {
			arr[i]=r.nextInt(100)+1; //1~100
		}
		System.out.println("정렬 전 : ");
		System.out.println(Arrays.toString(arr));
		System.out.println("정렬 후 : ");
		//ASC
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		//DESC
		for(int i=arr.length-1;i>=0;i--) {
			System.out.print(arr[i]+" ");
		}
	}

}
