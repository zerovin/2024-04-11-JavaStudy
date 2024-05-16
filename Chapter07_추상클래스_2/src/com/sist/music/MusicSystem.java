package com.sist.music;

public abstract class MusicSystem {
	//전체 데이터를 가지고 있다
	public static Music[] musics=new Music[50];
	
	//데이터 초기화 => 각각의 다른 데이터(다른 파일명)로 초기화 => 추상메소드
	public abstract void init(); //각각 상속받아 다르게 구현
	
	//목록출력 => 구현
	public void list() {
		System.out.println("========== 목록 출력 ==========");
		int i=1;
		for(Music m:musics) {
			System.out.println(i+"."+m.getTitle());
			i++;
		}
	}
	
	//상세보기 => 구현
	public void detail(int mno) {
		System.out.println("========== 상세보기 ==========");
		Music m=musics[mno-1]; //mno 1부터 시작, 인덱스는 0부터
		System.out.println("제목:"+m.getTitle());
		System.out.println("가수명:"+m.getSinger());
		System.out.println("앨범:"+m.getAlbum());
	}
	
	//검색 => 구현
	public void find(String title) {
		System.out.println("=========== 검색 ===========");
		for(Music m:musics) {
			if(m.getTitle().contains(title)) {
				System.out.println(m.getTitle());
			}
		}
	}
}
