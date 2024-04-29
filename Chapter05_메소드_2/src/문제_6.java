// 6. 문자열을 입력받아서 좌우 대칭인지 확인하는 메소드를 구현하시오
// 구글 코딩테스트
import java.util.Scanner;
public class 문제_6 {
	static void alpha(String msg) {
		if(msg.length()%2!=0) { //짝수여야만 좌우대칭 가능
			System.out.println("잘못된 입력입니다.");
			return; //메소드 종료, return은 원하는 위치에서 사용 가능
		}
		
		boolean bCheck=true;
		for(int i=0;i<msg.length()/2;i++) { //절반잘라서
			char c1=msg.charAt(i); //앞에서 i번째
			char c2=msg.charAt(msg.length()-1-i); //뒤에서 i번째
			if(c1!=c2) {
				bCheck=false;
				break;
			}
		}
		if(bCheck==true) {
			System.out.println("좌우 대칭입니다");
		}else {
			System.out.println("좌우 대칭이 아닙니다");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("문자열 입력 >> ");
		String text=scan.next();
		alpha(text);
		
	}

}
