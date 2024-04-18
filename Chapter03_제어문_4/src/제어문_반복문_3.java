//1~100까지의 합
public class 제어문_반복문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0; //합 누적 => 초기값 0
		for(int i=1;i<=100;i++) { //홀수 int i=1;i<=100;i+=2 / 짝수 int i=2;i<=100;i+=2
			sum+=i; //누적 연산자
			System.out.println("i="+i+",sum="+sum);
		}
		System.out.println("1~100 합:"+sum);
	}

}
