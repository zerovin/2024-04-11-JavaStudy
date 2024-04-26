/*
 *	정렬
 *	버블정렬 - 인접한 수끼리 비교 => 뒤에서부터 고정 
 *	27 22 17 23 9 2 => 2 9 17 22 23 27 ASC(오름차순정렬)
 *	 
 *	27 22 17 23 9 2
 *  -- --
 *  22 27
 *	   -- --
 *	   17 27
 *	      -- --
 *	      23 27
 *	         -- -
 *	          9 27
 *	            -- -
 *	            2  27    ========> 5번 비교
 *	---------------------1round => for 1
 *	22 17 23 9 2 27
 *	-- --        --
 *	17 22        고정
 *	   -- --
 *	   22 23
 *	      -- -
 *	      9 23
 *	        -- -
 *	         2 23        ========> 4번 비교
 *	---------------------2round => for 2
 *	17 22 9 2 23 27
 *	-- --     -----
 *	17 22	   고정
 *	   -- -
 *	   9 22
 *	     -- -
 *	      2 22           ========> 3번 비교
 *	---------------------3round => for 3
 *	17 9 2 22 23 27
 *	-- -   --------
 *	9 17    고정
 *	  -- -
 *	   2 17              ========> 2번 비교 
 *	---------------------4round => for 4
 *	9 2 17 22 23 27
 *	- - -----------
 *	2 9  고정	             ========> 1번 비교
 *	---------------------5round => for 5
 *	2 9 17 22 23 27 =====> length-1round
 *	---------------------버블 정렬
 *	i+j=length
 *	i=length-j
 */
import java.util.*;
public class 중첩_for_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {27, 22, 17, 23, 9, 2};
		System.out.println("정렬 전:");
		System.out.println(Arrays.toString(arr));
		System.out.println("정렬 후:");
		System.out.println("========= ASC ==========");
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
			System.out.println((i+1)+"Round:"+Arrays.toString(arr));
		}
		System.out.println(Arrays.toString(arr));
		
		//DESC
		System.out.println("========= DESC ==========");
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]<arr[j+1]) {
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
			System.out.println((i+1)+"Round:"+Arrays.toString(arr));
		}
		System.out.println(Arrays.toString(arr));
	}

}
