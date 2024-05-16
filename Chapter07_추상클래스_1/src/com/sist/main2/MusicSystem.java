package com.sist.main2;
/*
 *  공통수행기능 => abstract
 *  한번 만들어두고 필요시마다 상속받아 사용
 *    ex)목록, 상세, 검색, 예약 
 */
public abstract class MusicSystem {
	public static Music[] musics=new Music[50];
	public abstract void init(); //데이터 초기화
	// 필요한 기능 설계
	public abstract void find(String title);
	public abstract void list();
	public abstract void detail(int mno);
}
