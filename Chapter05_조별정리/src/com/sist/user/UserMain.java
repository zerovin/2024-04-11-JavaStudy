package com.sist.user;

import java.util.Scanner;
import com.sist.manager.*;
import com.sist.vo.*;

public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		GenieManager gm=new GenieManager();
		
		while(true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 목록");
			System.out.println("2. 검색");
			System.out.println("3. 상세보기");
			System.out.println("4. 종료");
			System.out.println("============");
			System.out.println("메뉴 선택 >> ");
			int menu=scan.nextInt();
			
			if(menu==1) {
				int total=gm.musicTotalPage();
				System.out.print("1~"+total+" 사이의 페이지 입력 >> ");
				int page=scan.nextInt();
				
				Genie[] music=gm.musicListData(page);
				for(Genie mm:music) {
					System.out.println(mm.getRank()+"."+mm.getTitle());
				}
			}else if(menu==2){
				System.out.print("검색어 입력 >> ");
				String title=scan.next();
				Genie[] music=gm.musicFindData(title);
				for(Genie mm:music) {
					System.out.println(mm.getRank()+"."+mm.getTitle());
				}
			}else if(menu==3){
				System.out.print("상세 볼 음악번호 >> ");
				int mno=scan.nextInt();
				Genie mmm=gm.musicDetailData(mno);
				System.out.println("순위:"+mmm.getRank());
				System.out.println("노래명:"+mmm.getTitle());
				System.out.println("가수:"+mmm.getSinger());
				System.out.println("앨범명:"+mmm.getAlbum());
			}else if(menu==4) {
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("없는 메뉴입니다");
			}
		}
	}

}
