/*
 *	구구단
 *	2*1=2 ..... 9*1=9
 *	...         ...
 *	...         ...
 *	...         ...
 *	2*9=18      9*9=81
 *
 *	줄수 => 1차 for => 9번수행 (1-9)
 *	개수 => 2차 for => 8번수행 (2-9)
 * 
 */
public class 중첩_for_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=9;i++) { //줄수
			for(int j=2;j<=9;j++) { //출력 개수
				//구구단 출력
				System.out.printf("%d * %d = %2d\t",j,i,j*i);
			}
			//줄수 => 다음줄 출력
			System.out.println();
		}
	}

}
