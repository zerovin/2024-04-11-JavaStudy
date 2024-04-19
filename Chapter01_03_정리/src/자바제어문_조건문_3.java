/*
 *	선택문
 *	if(조건문){
 *		조건문이 true일 때 수행하는 문장
 *	}else{
 *		조건문이 false일 때 수행하는 문장
 *	}
 *	
 *			조건
 *	  true	 |	false
 *	 ----------------
 *	 |				|
 * 실행문장		  실행문장
 * 
 * -대문자/소문자
 * -양수/음수
 * -짝수/홀수
 * -로그인O/X
 * -아이디중복O/X
 * -검색어O/X
 * 
 */
public class 자바제어문_조건문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c='k';
		// 대문자 소문자의 차이가 32
		// A=>65, a=>97
		if(c>='A' && c<='Z') {
			System.out.println(c+"은(는) 대문자");
			System.out.println(c+"의 소문자는 "+((char)(c+32)));
		}else {
			System.out.println(c+"은(는) 소문자");
			System.out.println(c+"의 대문자는 "+((char)(c-32)));
		}
	}

}
