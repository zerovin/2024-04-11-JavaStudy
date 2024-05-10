package com.sist.manager;
import java.io.*;
import java.util.*;
import com.sist.vo.*;

public class GenieManager {
	private static Genie[] musics=new Genie[200];
	public GenieManager() {
		try {
			FileReader fr=new FileReader("c:\\javaDev\\genie.txt");
			int i=0; 
			StringBuffer sb=new StringBuffer(); 
			while((i=fr.read())!=-1) { 
				sb.append((char)i);
			}
			fr.close();
			
			String data=sb.toString();
			String[] temp=data.split("\n"); 
			i=0;
			for(String s:temp) {
				String[] music=s.split("\\|");
				
				musics[i]=new Genie();
				musics[i].setRank(i+1);
				musics[i].setTitle(music[1]);
				musics[i].setSinger(music[2]);
				musics[i].setAlbum(music[3]);
				musics[i].setPoster(music[4]);
				i++;
			}
		}catch(Exception ex) {}
	}
	//목록출력
	public Genie[] musicListData(int page) {
		int total=musicTotalPage();
		int leng=20;
		Genie[] music=new Genie[leng];
		
		int j=0;
		int pagecnt=(20*page)-20;
				
		for(int i=0;i<musics.length;i++) {
			if(j<20 && i>=pagecnt) {
				music[j]=new Genie();
				music[j]=musics[i];
				j++;
			}
		}
		return music;
	}
	public int musicTotalPage() {
		return (int)(Math.ceil(musics.length/20.0));
	}
	
	//상세보기
	public Genie musicDetailData(int mno) {
		return musics[mno-1];
	}
	
	//검색
	public Genie[] musicFindData(String title) {
		int count=0;
		for(Genie m:musics) {
			if(m.getTitle().contains(title)) {
				count++; //배열의 개수를 구하기 위해
			}
		}
		Genie[] music=new Genie[count]; //구한 개수만큼의 크기를 가진 배열 생성 => 동적(가변형)
		int i=0;
		for(Genie m:musics) {
			if(m.getTitle().contains(title)) {
				music[i]=m;
				i++;
			}
		}
		
		return music;
	}
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		GenieManager m=new GenieManager(); // static 메소드에서 인스턴스 메소드를 부를때 객체생성
		
		System.out.print("검색어 입력 >> ");
		String title=scan.next();
		Genie[] music=m.musicFindData(title);
		for(Genie mm:music) {
			System.out.println(mm.getRank()+"."+mm.getTitle());
		}
		
		System.out.println("============================");
		System.out.print("상세 볼 음악번호 >> ");
		int mno=scan.nextInt();
		Genie mmm=m.musicDetailData(mno);

		System.out.println("순위:"+mmm.getRank());
		System.out.println("노래명:"+mmm.getTitle());
		System.out.println("가수:"+mmm.getSinger());
		System.out.println("앨범명:"+mmm.getAlbum());
	}
}

