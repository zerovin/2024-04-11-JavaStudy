/*
 *	부정연산자
 *	!(NOT) ==> boolean변수에서만 사용가능
 *	- 턴 
 * 
 */
public class 연산자_단항연산자_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean bCheck=false;
		System.out.println(bCheck); //false
		System.out.println(!bCheck); //true
		
		/*
		while(true) {
			bCheck=!bCheck;
			if(bCheck==true)
				System.out.println("컴퓨터");
			else
				System.out.println("본인");
		}
		*/
	}

}
