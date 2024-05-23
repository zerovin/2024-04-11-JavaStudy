package com.sist.util;
/*
 *  Collection - 배열 대처 => 가변형 : 저장개수를 지정하지 않는다(신축성)
 *  
 *  1.컬렉션 프레임워크
 *    - 다수의 데이터를 쉽고 효율적으로 처리할 수 있게 만든 표준화된 클래스 집합
 *      => 관리가 쉽고 모든 개발자가 동일하게 사용
 *    - 자료구조 - 데이터 수정, 삭제, 추가, 읽기가 가능 => 배열은 고정이라 불가능
 *    - 동적 메모리 할당 - 가변형, 필요시마다 데이터 추가 삭제가 편리
 *                     ex) 웹, 모바일 => 컬렉션을 이용해서 데이터 전송
 *    - 단점 - 모든 데이터를 저장 가능 => Object => 객체 형변환 필요
 *            매소드 리턴형/매개변수 => Object
 *              => 제네릭스 - 프로그램에 맞게 데이터형 변경해서 사용
 *  2.컬렉션의 종류 336page
 *                          Collection : interface
 *                               |
 *             ---------------------------------------
 *             |                 |                   |
 *            List              Set                 Map : interface
 *             |                 |                   |    
 *      ***ArrayList       ***HashSet             Hashtable => interface 구현한 클래스
 *         LinkedList         TreeSet          ***HashMap
 *         Vector                                 
 *         Stack / Queue      
 *         
 *     List - 데이터 중복 허용
 *            순서를 가지고 있다(인덱스)
 *     Set - 데이터 중복을 허용하지 않는다
 *           순서가 존재하지 않는다
 *     Map - (key, value) 동시에 저장
 *           key는 중복 불가능, value는 중복가능
 *     ----------------------------------- 추가, 수정, 삭제, 읽기 => CRUD => 자료구조
 *     ArrayList : 비동기, 데이터베이스 연결
 *     LinkedList : C언어와 호환
 *     Vector : 동기, 네트워크 접속자 정보 저장 => 보완 => ArrayList
 *     -------------- 같은 메소드 사용 add(), get(), size(), set(), remove(), clear()
 *     
 *     ArrayList 337page
 *      - 가장 많이 사용되는 컬렉션
 *      - 인덱스를 이용해서 데이터를 저장하고 관리 => 배열과 유사
 *      - 기본형, 클래스를 첨부해서 사용가능
 *      - 접근속도가 빠르다
 *      - 단점 : 추가, 삭제시 속도가 늦다 => 자동으로 순차적으로 조절 => 가급적 마지막에 데이터 추가
 *      - 저장은 어떤 데이터든 상관없이 저장가능 => Object
 *         
 */
import java.util.*;
public class 컬렉션_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList(); //가변형  - 데이터 저장 개수를 지정하지 않는다
		//LinkedList list=new LinkedList();
		/*
		 *  LinkedList - 접근 속도가 늦다
		 *               추가 삭제가 빠르다 
		 */
		//Vector list=new Vector();
		
		//저장 => add() - 마지막에 추가
		list.add("홍길동"); //인덱스0
		list.add("심청이"); //인덱스1
		list.add("이순신"); //인덱스2
		list.add("강감찬"); //인덱스3
		list.add("김두한"); //인덱스4
		
		//add(원하는 위치 인덱스, 값)
		list.add(1, "박문수"); //인덱스1 기존 인덱스1234=>2345로 변경
		
		//출력 - 저장된 위치에서 값 읽기 => get(index)
		//저장된 개수 => size()
		for(int i=0;i<list.size();i++) {
			String name=(String)list.get(i); //list.get(i) 리턴형 = Object 형변환 필요
			System.out.println(name);
		}
		
		System.out.println("==== 배열/컬렉션 출력 (for-each) ====");
		for(Object name:list) { //여기서는 형변환이 안되니 Object로 받아
			System.out.println(name);
		}
		
		//수정 => set(변경하려는 인덱스, 변경값)
		list.set(1, "을지문덕"); 
		System.out.println("===== 수정 후 =====");
		for(Object name:list) {
			System.out.println(name);
		}
		
		//삭제 => remove(삭제할 인덱스)
		list.remove(1);
		System.out.println("===== 삭제 후 =====");
		for(Object name:list) {
			System.out.println(name);
		}
		
		//전체삭제 => clear()
		list.clear();
		System.out.println("===== 전체삭제 후 =====");
		System.out.println("현재 인원 : "+list.size());
		 
	}

}
