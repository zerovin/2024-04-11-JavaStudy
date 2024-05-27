package com.sist.util;
/*
 *  데이터를 묶어서 한번에 처리 => Iterator()
 *  
 *  Iterator
 *   - hasNext() 위->아래
 *   - next()
 *   - remove()
 *   - hasPrevious() 아래->위
 */
// Set / Map => 크롤링시 사용
import java.util.*;
public class 라이브러리_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();
		list.add("홍길동");
		list.add("심청이");
		list.add("박문수");
		list.add("이순신");
		list.add("강감찬");
		
		System.out.println("====== 일반 형식 ======");
		for(String name:list) {
			System.out.println(name);
		}
		
		System.out.println("======= 재출력 =======");
		for(String name:list) {
			System.out.println(name);
		}
		
		System.out.println("===== Iterator =====");
		Iterator<String> it=list.iterator();
		while(it.hasNext()) { //it에 존재하는 개수만큼 반복
			//next() => 데이터를 가지고 온다, 다음데이터가 있을시 true 없을시 false
			System.out.println(it.next());
		}
		System.out.println("======= 재출력 =======");
		while(it.hasNext()) { 
			System.out.println(it.next()); //단방향, next로 모두 출력하면 재출력 불가
		}
		
		System.out.println("====== next() 소진 후 재출력 ======");
		Iterator<String> it2=list.iterator(); //next로 데이터출력 다 소진후 재출력시 다시 선언
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		System.out.println("===== ListIterator =====");
		ListIterator<String> it3=list.listIterator();
		while(it3.hasNext()) {
			System.out.println(it3.next());
		}
		
		System.out.println("===== ListIterator2 =====");
		ListIterator<String> it4=list.listIterator();
		while(it4.hasPrevious()) {
			System.out.println(it4.previous());
		}
		
	}

}
