
public class 자바제어문_반복문_변수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		for(i=1;i<=10;i++) {
			System.out.print(i+" ");
		}
		// i변수는 메모리에서 삭제
		System.out.println("i="+i); // line6 int i; 없이는 오류 {}밖에서 변수지정해줘야 밖에서 사용가능
		
	}

}
