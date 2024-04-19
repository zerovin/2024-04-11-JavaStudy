//0~12까지 2의 배수, 3의 배수의 합을 구하여라.

public class 문제_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//0~12까지 2의 배수, 3의 배수의 합을 구하여라.
		int sum2=0;
		int sum3=0;
		for(int i=0;i<=12;i++) {
			if(i%2==0) {
				sum2+=i;
			}
			if(i%3==0){
				sum3+=i;
			}
		}
		System.out.println("0~12까지 2의 배수의 합="+sum2);
		System.out.println("0~12까지 3의 배수의 합="+sum3);
		
		//1~100까지 7의 배수, 9의 배수의 합
		int num7=0;
		int num9=0;
		for(int i=1;i<=100;i++) {
			if(i%7==0) {
				num7+=i;
			}
			if(i%9==0) {
				num9+=i;
			}
		}
		System.out.println("1~100까지 7의 배수="+num7);
		System.out.println("1~100까지 9의 배수="+num9);
	}

}
