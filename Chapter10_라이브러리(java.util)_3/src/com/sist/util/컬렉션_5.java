package com.sist.util;
/*
 *  ArrayList
 *   - add() / remove() / set() / size() / get() / isEmpty() / clear()
 *   - ArrayList에는 한개만 저장
 *     두개 이상의 ArrayList에서 사용되는 기능 / 두개 이상인 경우 => JOIN
 *       - retainAll(Collection) => 두개의 List에서 같은 값을 읽어 오는 경우
 *                        ex) 장바구니 => 중복구매
 *       - addAll(Collection) => 전체 데이터 복사
 *       - removeAllCollection() => 한쪽에 없는 데이터만 출력
 *       - subList(int start, int end) => 부분 복사
 *       - asList() => 배열을 ArrayList로 변경
 */
import java.util.*;
public class 컬렉션_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		
		//addAll() => Set 복사가 가능
		for(String s:list) {
			System.out.println(s);
		}
		ArrayList<String> list2=new ArrayList<String>(Arrays.asList("A","B","C","D","E"));
		//Arrays.asList(값) ArrayList를 주어진 값으로 생성
		//asList는 클래스 첨부 불가능 => 기본형, String만 가능
		for(String s:list2) {
			System.out.println(s);
		}
	}

}
