package com.sist.main;
/*
 *  ArrayList - 중복이 있는 경우
 *  HashSet - 중복이 없는 경우
 *  HashMap - 두가지 동시 저장 key, value
 *  -----자료구조 - 데이터 저장, 수정, 추가, 삭제, 검색 => 컬렉션(여러개 수집, 관리)
 *                수정, 삭제, 검색시 => 데이터를 찾을 구분자 필요
 *                 - ArrayList 구분자 : 인덱스 번호 (중복가능)
 *                 - Set 구분자 : 데이터 자체 (중복불가)
 *                 - Map 구분자 : key(중복X), value(중복가능)
 *                 -------------------- 배열(고정) => 보완 => 가변-삭제추가가능
 *  
 *                 Collection
 *                      |
 *        -------------------------------
 *        |             |               |
 *       List          Set             Map
 *        |             |               |
 *    ArrayList      HashSet         HashMap
 *    LinkedList     TreeSet         Hashtable
 *      Vector
 *   => MyBatis,JPA
 *      
 *      
 *    => 사용은 개발자 선호에 따라
 *       ArrayList<String> list=new ArrayList<String>() ==> 하위클래스로 접근 권장X
 *       List<String> list=new ArrayList<String>() ==> 상위클래스로 접근 권장
 *       List<String> list=new LinkedList<String>()
 *       List<String> list=new Vector<String>()
 *       ===> List의 하위클래스중 개발자 각자의 선호방식으로 작업할 수 있게 상위클래스로 사용 권장
 *       
 *       Set<String> list=new HashSet<String>() ==> 상위클래스 Set으로 만들어야 HashSet, TreeSet 둘다 사용가능
 *       Set<String> list=new TreeSet<String>()     추후 Set 안의 다른 클래스로 바껴도 오류X
 */
import java.util.*;
public class Set_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> list=new Vector<String>();
		//ArrayList<String> list=new ArrayList<String>(); 작성시 오류
		list.addElement("홍길동");
		list.addElement("박문수");
		for(int i=0;i<list.size();i++) {
			String name=list.elementAt(i);
			System.out.println(name);
		}
		
		List<String> list1=new ArrayList<String>();      
		//List<String> list1=new LinkedList<String>();
		//Vector<String> list1=new Vector<String>();
		//ArrayList<String> list1=new ArrayList<String>();
		// ===> List로 만들면 ArrayList, LinkedList, Vector 전부사용가능
		list1.add("홍길동");
		list1.add("박문수");
		for(int i=0;i<list1.size();i++) {
			String name=list1.get(i);
			System.out.println(name);
		}
	}

}
