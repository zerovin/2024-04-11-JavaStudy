/*
 *	|| (or) - 병렬연산자
 *		 	- 조건중에 한개이상이 true면 true
 *			- 볌위를 벗어난 경우에 주로 처리
 *	(조건) || (조건)  
 *	
 *		ex) score>=60 && score<=70 => 60~70
 *			score<60 || score>70 => 60미만 70초과 
 * 
 */
public class 연산자_논리연산자_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score=(int)(Math.random()*100)+1; // 1~100추출
		boolean bCheck=(score<30) || (score>70); //1~29 71~100 => true
		System.out.println("score : "+score);
		System.out.println("30미만 70초과 : "+bCheck);
	}

}
