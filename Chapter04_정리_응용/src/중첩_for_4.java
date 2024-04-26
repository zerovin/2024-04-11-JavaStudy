/*
 *	★ 
 *	★★
 *	★★★
 *	★★★★
 * 
 *	★★★★
 *	★★★
 *	★★
 *	★
 *
 *	   *
 *	  **
 *	 ***
 *	****
 *
 *	****
 *	 ***
 *	  **
 *	   *
 * 
 */
public class 중첩_for_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=4;i++) {
			// 한 줄에 ★을 몇개 출력
			for(int j=1;j<=i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println("=========");
		for(int i=1;i<=4;i++) {
			//for(int j=4;j>=i;j--) {
			for(int j=1;j<=5-i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println("=========");
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=4-i;j++) {
				System.out.print(" "); //공백
			}
			for(int k=1;k<=i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("=========");
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=i-1;j++) {
				System.out.print(" "); //공백
			}
			for(int k=1;k<=5-i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
