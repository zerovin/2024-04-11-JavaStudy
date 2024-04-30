// 멜론 크롤링
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class 메소드_5 {
	// Jsoup 미리보기에 데이터가 출력된 경우 => 페이지 소스에 html내용 그대로 노출되는지
	static void find(int type, String fd) throws Exception{
		Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
		Elements title=doc.select("div.wrap_song_info div.rank01");
		Elements singer=doc.select("div.wrap_song_info div.rank02 span.checkEllipsis");
		
		for(int i=0;i<title.size();i++) {
			boolean bCheck=false;
			if(type==1) {
				bCheck=title.get(i).text().contains(fd); // true or false
			}else {
				bCheck=singer.get(i).text().contains(fd); // true or false
			}
			if(bCheck) {
				System.out.println((i+1)+"."+title.get(i).text()+" - "+singer.get(i).text());
			}
		}
	}
	public static void main(String[] args) throws Exception{ // throws Exception 파일입출력, 웹에서 크롤링
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 뮤직 목록"); 
			System.out.println("2. 노래명 검색");
			System.out.println("3. 가수명 검색");
			System.out.println("4. 프로그램 종료");
			System.out.println("===============");
			System.out.print("메뉴 선택 >> ");
			int menu=scan.nextInt();
			if(menu==1) {
			
				Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
				Elements title=doc.select("div.wrap_song_info div.rank01");
				Elements singer=doc.select("div.wrap_song_info div.rank02 span.checkEllipsis");
				
				for(int i=0;i<title.size();i++) {
					System.out.println((i+1)+"."+title.get(i).text());
				}
			}else if(menu==2) {
				System.out.print("검색어 입력 >> ");
				String fd=scan.next();
				/*
				Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
				Elements title=doc.select("div.wrap_song_info div.rank01");
				Elements singer=doc.select("div.wrap_song_info div.rank02 span.checkEllipsis");
				for(int i=0;i<title.size();i++) {
					if(title.get(i).text().contains(fd)) { // 제목에 검색어가 포함되었는지
						System.out.println((i+1)+"."+title.get(i).text());
					}
				}
				*/
				find(1,fd);
			}else if(menu==3) {
				System.out.print("가수 입력 >> ");
				String fd=scan.next();
				/*
				Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
				Elements title=doc.select("div.wrap_song_info div.rank01");
				Elements singer=doc.select("div.wrap_song_info div.rank02 span.checkEllipsis");
				for(int i=0;i<title.size();i++) {
					if(singer.get(i).text().contains(fd)) { // 제목에 검색어가 포함되었는지
						System.out.println((i+1)+"."+title.get(i).text()+" - "+singer.get(i).text());
					}
				}
				*/
				find(2,fd);
				
			}else if(menu==4) {
				System.out.println("프로그램 종료");
				break; // for,while 바로 종료
			}else {
				System.out.println("메뉴가 존재하지 않습니다");
				continue;
				/*
				 *	for(초기값;조건식;증감식)
				 *	    continue; ==> 증감식으로 이동 => 특정부분 제외
				 *
				 * 	while(조건식){
				 * 	    continue; ==> 조건식으로 이동 => 처음부터 다시 시작
				 * 	}
				 */
			}
			
		}
	}

}
