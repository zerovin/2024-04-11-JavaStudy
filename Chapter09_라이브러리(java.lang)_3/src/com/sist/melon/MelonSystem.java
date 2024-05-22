package com.sist.melon;

import java.io.*;

public class MelonSystem {
	private static Melon[] musics=new Melon[100];
	static {
		FileReader txt=null;
		try {
			txt=new FileReader("c:\\javaDev\\melon.txt");
			StringBuffer sb=new StringBuffer();
			int i=0;
			while((i=txt.read())!=-1) {
				sb.append((char)i);
			}
			String txtSt=sb.toString();
			String[] txtSp=txtSt.split("\n");
			i=0;
			for(String s:txtSp) {
				String[] music=s.split("\\|");
				musics[i]=new Melon();
				musics[i].setMno(Integer.parseInt(music[0]));
				musics[i].setTitle(music[1]);
				musics[i].setSinger(music[2]);
				musics[i].setAlbum(music[3]);
				musics[i].setAlbumart(music[4]);
				i++;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				txt.close();
			}catch(Exception ex) {}
		}
	}
	public Melon[] musicList() {
		return musics;
	}
	public Melon[] musicFind(String fd) {
		int count=0;
		for(Melon m:musics) {
			if(m.getTitle().contains(fd)) {
				count++;
			}
		}
		Melon[] searchMusic=new Melon[count];
		int i=0;
		for(Melon m:musics) {
			if(m.getTitle().contains(fd)) {
				searchMusic[i]=m;
				i++;
			}
		}
		return searchMusic;
	}
	public Melon musicDetail(int mno) {
		Melon m=new Melon();
		for(Melon mm:musics) {
			if(mm.getMno()==mno) {
				m=mm;
				break;
			}
		}
		return m;
	}
}
