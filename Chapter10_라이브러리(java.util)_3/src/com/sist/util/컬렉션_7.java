package com.sist.util;
/*
 *  ArrayList
 *  1.데이터 중복 허용 (오라클은 데이터 중복 허용)
 *    구분자 = 인덱스 => 자동 추가, 자동 관리 => 항상 0 ~ 순차적
 *    ex) 오라클에서 id, 게시물번호, 영화번호, 장바구니 번호 고유해야하는 데이터
 *        => 중복 없는 데이터 첨부 => PRIMARY KEY
 *        => 자동으로 인덱스번호 추가 안됨
 *  2.기능(메소드) - 라이브러리는 메소드
 *   *1)추가 => add(Data)
 *    2)수정 => set(int index, Data)
 *    3)삭제 => remove(int index)
 *   *4)저장개수 => size() ex)댓글,장바구니
 *   *5)읽기 => get(int index)
 *   *6)전체삭제 => clear()
 *   *7)데이터존재여부 => isEmpty()
 *  3.ArrayList가 여러개인 경우
 *    ex) 영화목록 / 예매목록 => 관련은 있지만 따로 저장해야하는 경우
 *        쇼핑목록 - 상품명, 가격, 상품번호 / 결제 - 상품번호, 가격, ID
 *    - retainAll() - 교집합
 *    - removeAll() - 차집합
 *    - addAll() - 전체 복사
 *    - subList() - 부분 복사
 *    ---------------------- 오라클에서는 JOIN, SUBQUERY => 여러개의 테이블 연동
 *    
 *        
 *     
 */
import java.util.*;
public class 컬렉션_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();
		list.add("홍길동");
		list.add("홍길동");
		list.add("박문수");
		list.add("이순신");
		list.add("홍길동");
		System.out.println("현재 저장된 개수:"+list.size()); //5
		
		list.remove("홍길동"); //데이터값이 같을 때 인덱스번호 앞번호부터 처리
		System.out.println("현재 저장된 개수:"+list.size()); //4
	}

}
