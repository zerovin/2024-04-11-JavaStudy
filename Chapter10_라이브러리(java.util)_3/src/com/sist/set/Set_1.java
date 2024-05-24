package com.sist.set;
// 345page
/*
 *  Set - 인터페이스
 *   - HashSet - 접근 속도가 빠르다
 *   - TreeSet - 검색 속도가 빠르다
 *   
 *   특징 1.순서가 없다 => 인덱스가 존재하지 않는다
 *       2.데이터 중복을 허용하지 않는다 => 오라클 - DISTINCT
 *       3.주요 메소드
 *         add() => 데이터 추가
 *         remove() => 데이터 삭제
 *         clear() => 데이터 전체 삭제
 *         *** 데이터를 한번에 모아서 관리 - iterator()
 *   사용처 - ArrayList에 존재하는 데이터의 중복을 제거할 때 주로 사용
 *            => 객체는 중복제거가 어렵다 => 같은 메모리 주소 => equals() 재정의
 */
import java.util.*;
public class Set_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 장르별 / 부서명 / 상품명 => 중복 발생 상황
		
		//저장 장소 선언
		Set<String> set=new HashSet<String>();
		set.add("사과");
		set.add("배");
		set.add("체리");
		set.add("수박");
		set.add("메론");
		set.add("참외");
		set.add("사과"); //중복된 데이터 저장불가 => 이미 존재하는 데이터 저장불가
		set.add("배");
		set.add("오렌지");
		set.add("딸기");
		
		System.out.println("===== 저장된 과일 출력 =====");
		//index번호가 없음 => for-each로 출력
		for(String f:set) {
			System.out.println(f); //10개 중 중복값 2개 빼고 8개출력
			//중복된 데이터는 저장되지 않는다
			//순서가 없기때문에 작성순서대로 출력되지 않는다
		}
		
	}

}
