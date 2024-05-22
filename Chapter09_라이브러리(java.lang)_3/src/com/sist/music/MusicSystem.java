package com.sist.music;
import java.io.*;
public class MusicSystem {
	//Music 데이터 공유 => 모든 유저가 같은 데이터를 사용하게 만든다
	private static Music[] musics=new Music[200];
	
	//파일 읽기 => 데이터저장
	//클래스 영역에서는 사용 불가능
	//초기화
	/*
	 *  A B C D E F G H I J
	 *  String s="A"
	 *  ---s---
	 *    100
	 *  -------   100-----
	 *               "A"
	 *             -------
	 *  s=s+"B"
	 *  ---s---
	 *    100 => 200
	 *  -------   100-----
	 *               "A"
	 *             -------
	 *            200-----
	 *               "AB"
	 *             -------
	 *             
	 *  StringBuffer
	 *  ---sb---
	 *    100
	 *  --------  100-----
	 *                A+B+CDEFGHIJ...
	 *            --------
	 *            
	 */
	static {
		FileReader fr=null;
		try {
			//CheckedException => 컴파일시에 예외 감시
			//초기화 블록은 throws 사용불가
			//throws는 생성자포함 메소드에서만 사용가능
			fr=new FileReader("C:\\javaDev\\genie.txt");
			int i=0;
			StringBuffer sb=new StringBuffer();
			//데이터 문자열 결합이 많은 경우 StringBuffer => 비동기 ArrayList
			//동기 => StringBuilder => Vector
			//String data="";
			while((i=fr.read())!=-1) {
				sb.append((char)i);
				//data+=(char)i;
			}		
			//System.out.println(sb.toString());
			//System.out.println(data);
			
			//String으로 제어
			String data=sb.toString();
			//분리 \n
			String[] temp=data.split("\n");
			i=0;
			for(String s:temp) {
				String[] m=s.split("\\|"); //정규식 . + * | ? ^ $ 사용시 \\붙여사용
				musics[i]=new Music();
				musics[i].setMno((Integer.parseInt(m[0]))/2);
				musics[i].setTitle(m[1]);
				musics[i].setSinger(m[2]);
				musics[i].setAlbum(m[3]);
				musics[i].setPoster(m[4]);
				musics[i].setKey(m[5]);
				i++;
			}
		}catch(Exception ex) {
			//에러 발생시 복구 => 확인
			ex.printStackTrace(); //FileNotFoundException / IOException => Exception
		}finally {
			try {
				fr.close();
			}catch(Exception ex) {}
		}
	}
	public int musicTotalPage() {
		return (int)(Math.ceil(musics.length/20.0)); //총페이지 수 구할 때 ceil 올림함수 
	}
	public Music[] musicListData() {
		return musics;
	}
	public Music MusicDetailData(int mno) {
		Music m=new Music();
		for(Music mm:musics) {
			if(mm.getMno()==mno) {
				m=mm;
				break;
			}
		}
		return m;
	}
	//검색
	public Music[] musicFindData(String fd) {
		int count=0;
		for(Music m:musics) {
			if(m.getTitle().contains(fd)) { //contains => boolean => if문에서 사용
				count++;
			}
		}
		Music[] mm=new Music[count];
		int i=0;
		for(Music m:musics) {
			if(m.getTitle().contains(fd)) {
				mm[i]=m;
				i++;
			}
		}
		return mm;
	}
}
