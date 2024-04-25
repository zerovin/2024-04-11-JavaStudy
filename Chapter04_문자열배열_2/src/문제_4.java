// 4. 배열 arr에 담긴 모든 값을 더하는 프로그램을 완성하시오.
public class 문제_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub   
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		/*
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		*/
		
		for(int a:arr) { // 배열에 저장된 실제값을 가지고 옴, 받는 변수는 배열의 데이텨형
			sum+=a;
		}
		
		System.out.println("sum="+sum); // 결과 : sum=150
	
	}

}
