package com.sist.main2;
import java.util.*;
/*
 *  관련된 클래스를 모아서 한번에 관리
 *  모든 클래스가 인터페이스 상속이 있어야 관련된 클래스
 *  
 *  웹 - 요청 => 처리 => 결과값 브라우저 전송
 *      인터페이스로 모아서 처리
 */
public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("1.게시판 2.맛집 3.레시피 4.여행 5.공지사항 >> ");
		int menu=scan.nextInt();
		/*
		if(menu==1) {
			BoardModel model=new BoardModel();
			model.execute();
		}else if(menu==2) {
			FoodModel model=new FoodModel();
			model.execute();
		}else if(menu==3) {
			RecipeModel model=new RecipeModel();
			model.execute();
		}else if(menu==4) {
			SeoulModel model=new SeoulModel();
			model.execute();
		}else if(menu==5) {
			NoticeModel model=new NoticeModel();
			model.execute();
		}
		*/
		Container c=new Container();
		Model model=c.getModel(menu);
		model.execute();
	}

}
