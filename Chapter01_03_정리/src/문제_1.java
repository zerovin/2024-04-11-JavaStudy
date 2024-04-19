//int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식 작성 (조건문)
public class 문제_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=(int)(Math.random()*100+1);
		System.out.println("x="+x);
		
		if(x>10 && x<20) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}

}
