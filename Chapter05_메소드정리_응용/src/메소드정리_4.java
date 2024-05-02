/*
 *	매개변수 전송
 *  - 메소드 안의 변수는 메소드 종료시 삭제
 *  
 *  다른 메소드로 값 전송 
 */
/*
 *	메소드 연결
 *	숫자야구게임 => 메소드로 분리
 *	1. 3개의 중복없는 난수 발생
 *	2. 사용자로부터 3개의 정수 입력
 *	3. 난수/사용자입력값 비교
 *	4. 힌트제공
 *	5. 종료 여부 확인 => 종료 or 재시작
 *
 */
import java.util.*;
public class 메소드정리_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 절차적 언어 => 5. 종료 여부 확인 => 종료 or 재시작 불가 => 재사용X
		int[] com=new int[3];
		for(int i=0;i<com.length;i++) {
			com[i]=(int)(Math.random()*9)+1; //1~9사이 정수
			//중복체크
			for(int j=0;j<i;j++) {
				if(com[i]==com[j]) {
					i--; // 중복수 발생시 다시 발생
					break;
				}
			}
		}
		//System.out.println(Arrays.toString(com));
		
		//사용자 입력 => 정답일 때까지 => while
		//사용자 입력값 저장
		int[] user=new int[3];
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.print("세자리 정수 입력:");
			int input=scan.nextInt();
			//오류처리-세자리정수
			if(input<100 || input>999) { // || => 범위를 벗어난 경우
				System.out.println("세자리 정수만 사용이 가능합니다");
				// 처음 상태로 돌아감
				continue;
			}
			user[0]=input/100;
			user[1]=input%100/10;
			user[2]=input%10;
			
			//오류처리-중복
			if(user[0]==user[1] || user[1]==user[2] || user[0]==user[2]) {
				System.out.println("같은 수는 사용할 수 없습니다");
				continue;
			}
			//오류처리-0사용
			if(user[0]==0 || user[1]==0 || user[2]==0) {
				System.out.println("0은 사용할 수 없습니다");
				continue;
			}
			//비교
			int s=0,b=0;
			for(int i=0;i<com.length;i++) {
				for(int j=0;j<user.length;j++) {
					// i=0 => j=0,1,2
					// i=1 => j=0,1,2
					// i=2 => j=0,1,2
					if(com[i]==user[j]) { //같은 수가 있는지
						if(i==j) { //같은 자리인지
							s++; //같은 자리
						}else {
							b++; //다른 자리
						}
					}
				}
			}
			//힌트
			System.out.printf("Input Number:%d, Result:%dS-%dB\n",input,s,b);
			//종료여부확인
			if(s==3) {
				System.out.println("Game Over!!");
				break;
			}
		}
		
		
	}

}
