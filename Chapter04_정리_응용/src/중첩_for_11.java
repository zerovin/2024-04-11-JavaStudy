//API
import java.util.*;
public class 중첩_for_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println("정렬 전:");
		System.out.println(Arrays.toString(arr));
		
		// 정렬 api
		Arrays.sort(arr);
		System.out.println("정렬 후:");
		System.out.println(Arrays.toString(arr)); //ASC만 가능
		
		//DESC는 반복문으로 
		for(int i=arr.length-1;i>=0;i--) {
			System.out.print(arr[i]+" ");
		}
		
		/*
		 *	라이브러리가 모든 기능 지원은 아님
		 *	-직접 만들거나 - 오버로딩
		 *	-기존 라이브러리를 수정해서 사용 - 오버라이딩 
		 */
		
	}

}
