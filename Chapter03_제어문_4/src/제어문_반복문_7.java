// 무한루프
/*
 *	간단한 게임 : UpDown Game 
 *  => 1~100사이 난수를 맞추는 게임
 *  => 힌트 up or down
 *  => 1~100까지 사이의 수가 입력이 안된 경우 -> 제외하고 다시 처음으로 이동 => continue
 *  => 정답일 경우 => break(for문 종료)
 *  => 반복제어문 - break, continue;
 */
import java.util.Scanner;
public class 제어문_반복문_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		//난수발생
		int com=(int)(Math.random()*100)+1; //1~100사이 정수 하나 추출
		int count=0;
		
		//사용자가 난수를 맞추는 코딩, 무한루프 => 맞추면 동료
		//while(true) - 데이터베이스에서 주로 사용
		//오라클, mySQL, MariaDB
		for(;;) {
			//사용자 입력
			System.out.print("1~100사이의 정수 입력:");
			int user=scan.nextInt();
			
			if(user<1 || user>100) { //범위를 벗어난 경우 ||
				System.out.println("입력값에 오류가 있습니다");
				continue; //for문의 처음으로 돌아감
			}
			
			count++;
			//정상적으로 입력 된 경우
			if(com>user) {
				System.out.println("입력값보다 큰 수를 입력하세요");
			}else if(com<user) {
				System.out.println("입력값보다 작은 수를 입력하세요");
			}else {
				System.out.println("정답입니다!!");
				break; //for종료 => 게임 종료 => System.exit(0)
			}
			
		}
		System.out.println(100-(count*5)+"점");
		
	}

}
