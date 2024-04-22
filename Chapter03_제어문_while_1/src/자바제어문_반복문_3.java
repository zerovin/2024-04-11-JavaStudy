/*
 *	A~Z 출력 => for
 *	Z~A 출력 => while
 */
public class 자바제어문_반복문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//A~Z for
		for(char c='A';c<='Z';c++) {
			System.out.print(c+" ");
		}
		
		System.out.println();
		//Z~A while
		char c='Z';
		while(c>='A') {
			System.out.print(c+" ");
			c--;
		}
	}

}
