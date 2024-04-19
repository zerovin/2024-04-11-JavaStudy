//5~16까지의 합을 구하시오

//1~100 좌우대칭 숫자를 추출해서 출력
public class 문제_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//5~16까지의 합을 구하시오
		int sum=0;
		for(int i=5;i<=16;i++) {
			sum+=i;
		}
		System.out.println("5~16까지의 합="+sum);
		
		//1~100 좌우대칭 숫자를 추출해서 출력
		for(int i=1;i<=100;i++) {
			if(i%11==0) {
				System.out.print(i+" ");
			}
		}
	}

}