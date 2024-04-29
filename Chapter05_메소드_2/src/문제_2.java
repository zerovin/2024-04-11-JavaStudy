// 2. 1~10까지 합을 구하는 메소드를 구현하시오
// 리턴형O 매개변수X 
// 매개변수보다 리턴형이 같거나 커야함
public class 문제_2 {
	static int sumNum() {
		int sum=0;
		for(int i=1;i<=10;i++) {
			sum+=i;
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=sumNum(); //리턴형이 있는 경우 결과값을 받는다
		System.out.println("1~10까지의 합="+sum);
	}

}
