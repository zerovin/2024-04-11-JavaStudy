package com.sist.music;
import java.io.*;
public class GenieMusic extends MusicSystem{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
			FileReader fr=new FileReader("c:\\javaDev\\genie.txt");
			StringBuffer sb=new StringBuffer(); //Buffer 임시기억장소 StringBuffer 누적
			int i=0;
			while((i=fr.read())!=-1) {
				sb.append((char)i);
			}
			fr.close();
			
			String data=sb.toString(); //String 문자제한X
			String[] mdata=data.split("\n");
			i=0;
			for(String s:mdata) {
				//System.out.println(s);
				if(i>50) break;
				musics[i]=new Music();
				String[] temp=s.split("\\|"); //정규식 ^ $ . ? | + * 사용시 \\붙여서 사용
				musics[i].setMno(temp[0]);
				musics[i].setTitle(temp[1]);
				musics[i].setSinger(temp[2]);
				musics[i].setAlbum(temp[3]);
				musics[i].setPoster(temp[4]);
				i++;
			}
		}catch(Exception ex) {}
	}

}
