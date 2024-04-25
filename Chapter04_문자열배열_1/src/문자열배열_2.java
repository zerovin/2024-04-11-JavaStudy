// startsWith() / endsWith()
// 자동완성기능(서제스트)
import java.util.Scanner;
public class 문자열배열_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] books= {
				"자바와 오라클",
				"자바로 시작하는 웹프로그램",
				"자바와 JSP",
				"JSP와 오라클",
				"JSP와 Ajax",
				"Ajax와 JQuery",
				"혼자 배우는 자바",
				"자바 프로그래밍",
				"오라클 AND 자바",
				"최신 자바"
		};
		// 데이터 모음
		Scanner scan=new Scanner(System.in);
		System.out.print("검색어 입력 >> ");
		String fd=scan.next();
		for(String book:books) {
			//if(book.startsWith(fd)) { // 시작문자열이 같은 경우
			//if(book.endsWith(fd)) { // 끝문자열이 같은 경우
			//if(book.startsWith(fd) || book.endsWith(fd)) { //시작이나 끝 문자열이 같은 경우 => 이럴땐 contains가 편리
			if(book.contains(fd)) {
				System.out.println(book);
				try {
					Thread.sleep(1000); // 잠깐 멈춤
				}catch(Exception ex) {}
			}
		}
	
	}

}
