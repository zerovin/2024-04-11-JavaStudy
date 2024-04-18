/*
 *  i,j = 루프변수
 *	1~100 사이의 
 *	=> 짝수의 합 = 누적변수
 *  => 홀수의 합 
 *  => 전체의 합 
 * 
 */
public class 제어문_반복문_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//초기값
		int sum=0,even=0,odd=0; //합
		int ecnt=0,ocnt=0; //갯수
		
		for(int i=1;i<=100;i++) {
			if(i%2==0) {
				even+=i; //짝수값 누적 ==> 복합대입연산자
				ecnt++; //짝수 갯수 ==> 단항연산자
			}
			else {
				odd+=i; //홀수값 누적
				ocnt++; //홀수 갯수
			}
			sum+=i; //전체합 누적
		}
		System.out.println("1~100 사이의 짝수 합:"+even);
		System.out.println("1~100 사이의 짝수 갯수:"+ecnt);
		System.out.println("1~100 사이의 홀수 합:"+odd);
		System.out.println("1~100 사이의 홀수 갯수:"+ocnt);
		System.out.println("1~100 사이의 전체 합:"+sum);
	}

}
