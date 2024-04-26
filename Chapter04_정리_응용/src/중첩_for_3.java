/*
 *	★★★★★
 *	★★★★★
 *	★★★★★
 *	★★★★★
 *	1차 => 줄수 5 => 1~4
 *	2차 => 출력 5 => 1~5
 *
 *	ABCD
 *	EFGH
 *	IJKL
 *	MNOP
 *
 *	ABCD
 *	ABCD
 *	ABCD
 *	ABCD
 *
 *	★★☆★★
 *	★★☆★★
 *	★★☆★★
 *	★★☆★★
 *
 *	☆★★★★
 *	★☆★★★
 *	★★☆★★
 *	★★★☆★
 *	★★★★☆
 *
 *	★★★★☆
 *	★★★☆★
 *	★★☆★★
 *	★☆★★★
 *	☆★★★★
 *
 *	☆★★★☆
 *	★☆★☆★
 *	★★☆★★
 *	★☆★☆★
 *	☆★★★☆
 *
 *	♠♥♣◈
 *	♠♥♣◈
 *	♠♥♣◈
 *	♠♥♣◈
 *
 */
public class 중첩_for_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("==========");
		char c='A'; //for문 밖에 있으면 for문에서 나온 결과값 유지
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=4;j++) {
				System.out.print(c++);
			}
			System.out.println();
		}
		
		System.out.println("==========");
		for(int i=1;i<=4;i++) {
			c='A'; //for안에 있으면 반복문 돌릴때마다 'A'로 초기화
			for(int j=1;j<=4;j++) {
				System.out.print(c++);
			}
			System.out.println();
		}
		
		System.out.println("==========");
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=5;j++) {
				if(j==3) {
					System.out.print("☆");
				}else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
		
		System.out.println("==========");
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(i==j) {
					System.out.print("☆");
				}else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
		
		System.out.println("==========");
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(i==6-j) {
					System.out.print("☆");
				}else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
		
		System.out.println("==========");
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(i==j || i==6-j) {
					System.out.print("☆");
				}else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
		
		//♠♥♣◈
		System.out.println("==========");
		String[] img= {"♠","♥","♣","◈"};
		for(int i=1;i<=4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(img[j]);
			}
			System.out.println();
		}
		
	}

}
