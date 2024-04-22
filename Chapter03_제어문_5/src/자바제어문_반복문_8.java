/*
 *	 
 */
public class 자바제어문_반복문_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<=5;i++) { //for문 설정하는 i변수도 for문{} 안에서만 사용가능
			char c='A'; //for문 돌 때마다 새로 생성
			System.out.print(c+" "); //A A A A A
			c++;
			//c변수는 for문 안에서만 사용가능	
		}//c변수는 사라짐
		
		System.out.println();
		char c='A'; //for밖에 있어서 삭제되지 않아서 누적 가능
		for(int i=0;i<=5;i++) {
			System.out.print(c+" "); //A B C D E F 
			c++;
			//c변수는 for문 안에서만 사용가능	
		}//c변수는 사라짐
	}

}
