//3이상 4462 이하에서 짝수인 정수의 합을 구하여라.

public class 문제_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int evensum=0;
		int oddsum=0;
		for(int i=3;i<=4462;i++) {
			if(i%2==0) {
				evensum+=i;
			}else {
				oddsum+=i;
			}
		}
		System.out.println("3이상 4462 이하에서 짝수인 정수의 합="+evensum);
		System.out.println("3이상 4462 이하에서 홀수인 정수의 합="+oddsum);
	}

}
