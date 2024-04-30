import java.util.*;
public class 실무_정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100)+1; //arr초기화
		}
		System.out.println("===== 변경 전 =====");
		for(int i:arr) {
			System.out.print(i+" ");
		}
		Arrays.sort(arr); //실무에선 sort 라이브러리 사용
		System.out.println("\n===== 변경 후 =====");
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		int num=10;
		System.out.println(Integer.toBinaryString(num)); //2진법 라이브러리
	}

}
