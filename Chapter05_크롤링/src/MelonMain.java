import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *	파일 한개에 클래스가 여러개 있는경우
 * 	=> public class 한번만 사용
 *  => public class명 == 저장명 동일해야 작동
 *  
 *	ex)
 *	   class A
 *	   class B
 *	   public class C   
 *	   => C.java
 *
 *	   class A
 *	   class B
 *	   => A.java or B.java
 *	   => 가급적 main이 있는 클래스명 == 저장명
 *  
 *	   class A
 *	   class B
 *	   => A.class B.class 따로 컴파일
 *	   => 같은 폴더에서는 같은 이름의 클래스명 사용불가
 *	    
 */
class musicData{
	String rank;
	String title, singer, album, poster;
}
class MelonMusic{
	static musicData[] musics=new musicData[100];
	{ 
		try {
			/*
			int k=1;
			for(int i=50;i<=100;i+=50) {
				Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
				Elements title=doc.select(".lst"+i+" .wrap_song_info .rank01 a");
				Elements singer=doc.select(".lst"+i+" .wrap_song_info .rank02 a");
				Elements album=doc.select(".lst"+i+" .wrap_song_info .rank03 a");
				Elements poster=doc.select(".lst"+i+" .image_typeAll img");
				
				for(int j=0;j<title.size();j++) {
					System.out.println("순위:"+k);
					System.out.println("노래명:"+title.get(j).text());
					System.out.println("가수명:"+singer.get(j).text());
					System.out.println("앨범명:"+album.get(j).text());
					System.out.println("앨범아트:"+poster.get(j).attr("src"));
					System.out.println("======================================");
					
					FileWriter fw=new FileWriter("c:\\javaDev\\melon.txt",true); //append
					String data=k+"|"
					            +title.get(j).text()+"|"
					            +singer.get(j).text()+"|"
							    +album.get(j).text()+"|"
					            +poster.get(j).attr("src")+"\r\n";
					fw.write(data);
					fw.close();
					k++;
				}
			}
			*/
			
			// 파일에서 데이터 읽기
			FileReader fr=new FileReader("c:\\javaDev\\melon.txt");
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
				String[] ss=s.split("\\|");
				musics[i]=new musicData();
				musics[i].rank=ss[0];
				musics[i].title=ss[1];
				musics[i].singer=ss[2];
				musics[i].album=ss[3];
				musics[i].poster=ss[4];
				i++;
			}
			
		}catch(Exception ex) {}
	}
	
	static void musicList() {
		System.out.println("============ Music List =============");
		int i=1;
		for(musicData s:musics) {
			System.out.println(i+"."+s.title);
			i++;
		}
	}
	static void musicTitleFind(String title) {
		int count=0;
		for(musicData m:musics) {
			if(m.title.contains(title)) {
				System.out.println(m.title);
				count++;
			}
		}
		System.out.println("검색결과 총 "+count+"건");
	}
	static void musicSingerFind(String singer) {
		int count=0;
		for(musicData m:musics) {
			if(m.singer.contains(singer)) {
				System.out.println(m.title+" - "+m.singer);
				count++;
			}
		}
		System.out.println("검색결과 총 "+count+"건");
	}
	static void musicAlbumFind(String album) {
		int count=0;
		for(musicData m:musics) {
			if(m.album.contains(album)) {
				System.out.println(m.title+" - "+m.album);
				count++;
			}
		}
		System.out.println("검색결과 총 "+count+"건");
	}
	
}

public class MelonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MelonMusic mm=new MelonMusic();
		
		// 목록출력
		mm.musicList();
		
		System.out.println("======================");
		Scanner scan=new Scanner(System.in);	
		System.out.print("검색어 입력 >> ");
		
		/*
		// 제목검색
		String title=scan.next();
		mm.musicTitleFind(title);
		*/
		
		/*
		// 가수검색
		String singer=scan.next();
		mm.musicSingerFind(singer);
		*/
		
		
		// 앨범검색
		String album=scan.next();
		mm.musicAlbumFind(album);
		
	}

}
