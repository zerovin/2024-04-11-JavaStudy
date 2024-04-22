import java.util.Scanner;
/*
 *	updown
 *	1.난수 발생
 *	2.사용자 입력
 *	3.힌트 up/down 
 *	4.못 맞추면 = continue; 반복제어문
 *	5.맞추면 종료 = break;
 *	
 *	=> 몇번만에 맞출지 횟수 부정확 => while문 
 */
public class 자바제어문_반복문_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		//1.난수발생
		int com=(int)(Math.random()*100)+1; // 1~100 사이의 임의의 정수 추출
		while(true) { //무한루프
			System.out.print("1~100사이 정수 입력 >> ");
			int user=scan.nextInt();
			if(user<1 || user>100) {
				System.out.println("잘못된 입력입니다"); 
				continue; //조건식으로 이동 => while문 처음으로 이동
			}
			//힌트
			if(com>user) {
				System.out.println("입력값 보다 큰 숫자를 입력하세요");
			}else if(com<user) {
				System.out.println("입력값 보다 작은 숫자를 입력하세요");
			}else { // com==user
				System.out.println("정답입니다!!");
				break; // 정답이니까 종료
			}
		}
		System.out.println("프로그램 종료!!");
	}

}
