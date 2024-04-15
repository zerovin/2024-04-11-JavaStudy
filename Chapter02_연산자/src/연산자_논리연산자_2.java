/*
 *	점수 >=60 <=100 => true 
 * 	
 * 
 */
public class 연산자_논리연산자_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score=(int)(Math.random()*100)+1; //1~100 난수 발생
		System.out.println("난수값:"+score);
		boolean bCheck=(score>=60) && (score%2==0); // score%2==0 짝수조건
		System.out.println("60이상 짝수:"+bCheck);
		
		//score가 40이상이고 score가 홀수
		bCheck=(score>=40) && (score%2!=0); //변수재사용 조건변경, 데이터형사용X 변수명만 작성 
		System.out.println("40이상 홀수:"+bCheck);
		
		//변수 재사용 - 한번 선언 후 main{}안에서 필요시마다 사용가능, main 종료시까지 메모리 유지
		int a=10;
		a++;
		a=100;
		a++;
		a=200;
		a++;
		a=300;
		a--;
		System.out.println(a);
	}

}
