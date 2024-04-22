/*
 *	while문
 * 		반복문 - 반복 횟수가 지정이 안된 경우 주로 사용
 * 		형식)
 * 			초기값 ---------------1
 * 			while(조건문){ => false면 종료
 * 				반복 수행문장 ------2
 * 				증감식 -----------3 --> 조건문에 대입
 * 			}
 * 		
 * 		무한루프
 * 
 */
import java.util.Scanner;
public class 자바제어문_반복문_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		while(true) { // 72page, 반드시 종료하는 프로그램 제작 = break;
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 뮤직 목록");
			System.out.println("2. 뮤직 검색(곡명)");
			System.out.println("3. 뮤직 검색(가수명)");
			System.out.println("4. 뮤직 보기");
			System.out.println("9. 프로그램 종료");
			System.out.println("===============");
			System.out.print("메뉴 선택 >> ");
			int menu=scan.nextInt();
			
			/*
			if(menu==1) {
				System.out.println("뮤직 전체 목록을 요청하셨습니다");
			}else if(menu==2) {
				System.out.println("곡명으로 검색을 요청하셨습니다");
			}else if(menu==3) {
				System.out.println("가수명으로 검색을 요청하셨습니다");
			}else if(menu==4) {
				System.out.println("동영상을 요청하셨습니다");
			}else if(menu==9) {
				System.out.println("프로그램 종료");
				break; //while문 종료
			}else {
				System.out.println("메뉴가 존재하지 않습니다");
			}
			*/
			
			//switch
			switch(menu) {
				case 1:
					System.out.println("뮤직 전체 목록을 요청하셨습니다");
					break;
				case 2:
					System.out.println("곡명으로 검색을 요청하셨습니다");
					break;
				case 3:
					System.out.println("가수명으로 검색을 요청하셨습니다");
					break;
				case 4:
					System.out.println("동영상을 요청하셨습니다");
					break;
				case 9:
					System.out.println("프로그램 종료");
					System.exit(0); //얘로 시스템 종료 0-정상종료, 1-비정상종료
					//break; break는 switch만 벗어나서 종료를 할 수가 없음
				default:
					System.out.println("메뉴가 존재하지 않습니다");
			}
			//종료를 할 수가 없...
			
			
			
		}
		/*
		 *	break = 반복문 종료(중단)
		 *	continue = 조건식으로 이동, 처음부터 다시 실행할 떄 사용 
		 */
	}

}
