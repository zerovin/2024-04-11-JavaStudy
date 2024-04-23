/*
 *	continue - for문에서 주로 사용 => 제외 
 */
public class 자바제어문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("===== for-continue =====");
		for(int i=1;i<=5;i++) {
			if(i==3) continue; //3제외 => 증감식(i++)으로, 3제외 나머지 출력
			System.out.println("i="+i); // i=1, i=2, i=4, i=5
		}
		System.out.println("==== while-continue ====");
		int i=1;
		while(i<=5) {
			System.out.println("i="+i); //무한루프 돌면 얘 계속 출력
			if(i==3) continue; //3제외 조건문으로 이동 => i++가 안되서 i는 계속 3 => 무한루프
			System.out.println("i="+i);
			i++;
		}
		// 횟수가 없을 경우 while(true)로 사용
		// while, do~while 에서는 continue 잘 안씀
		/*
		 *	continue, break 문장은 자신의 반복문에서만 제어
		 *
		 *	for(int i=1;i<=3;i++){
		 *		for(int j=1;j<=3;j++){
		 *			if(j==2) break; => j가 이는 for문만 종료
		 *		}
		 *	}
		 *
		 */
	}
	
}
