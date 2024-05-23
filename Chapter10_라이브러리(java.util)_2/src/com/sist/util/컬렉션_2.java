package com.sist.util;
import java.util.*;
public class 컬렉션_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		//add(Object)
		list.add(100);
		list.add("홍길동");
		list.add('A');
		list.add(true);
		list.add(10.5);
		//데이터형 여러가지 첨부 => 관리, 반복문 사용 어렵
		//반복문은 패턴이 있는 경우만 사용가능 => 데이터형이 여러가지면 패턴X, 반복문 사용 어렵
		//데이터형이 여러가지인 경우 모두 Object로 들어와서 다 형변환 해줘야해
		int a=(int)list.get(0);
		String name=(String)list.get(1);
		char c=(char)list.get(2);
		boolean b=(boolean)list.get(3);
		double d=(double)list.get(4);
		//가급적 동일한 데이터형 저장
		//형변환 부담 => 보완 => 제네릭
	}

}
