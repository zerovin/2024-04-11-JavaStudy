/*
 *	7.	1~30 짝수합,홀수합을 출력하는 프로그램을 작성 
 */
public class 문제_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int evensum=0;
		int oddsum=0;
		for(int i=1;i<=30;i++) {
			if(i%2==0) {
				evensum+=i;
			}else {
				oddsum+=i;
			}
		}
		System.out.println("짝수합:"+evensum);
		System.out.println("홀수합:"+oddsum);
	}

}
