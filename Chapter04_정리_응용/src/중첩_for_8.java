/*
 *	정렬
 *	- 선택정렬
 *		30 20 40 10 50 => ASC(오름차순)-10 20 30 40 50 / DESC(내림차순)-50 40 30 20 10
 *	    ASC
 *	       30 20 40 10 50
 *	       -----
 *         20 30
 *         --   ---
 *         20    40
 *         ---      ---
 *         10       20
 *         ---         ---
 *         10          50
 *         -------------------1round => for 1
 *         10 30 40 20 50
 *         -- -- --
 *         고정30 40
 *            --    --
 *            20    30
 *            --       --
 *            20       50
 *        --------------------2round => for 2
 *        10 20 40 30 50
 *        ----- -- --
 *        고정   30 40
 *              --    --
 *              30    50
 *        --------------------3round => for 3
 *        10 20 30 40 50
 *        -------- -- --
 *        고정      40 50
 *        --------------------4round => for 4 
 *        10 20 30 40 50 
 *        -----------
 *        고정
 *        =====================> length-1
 *	- 버블정렬
 * 
 */
import java.util.*;
public class 중첩_for_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr=new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println("정렬전:");
		System.out.println(Arrays.toString(arr));
		System.out.println("정렬후:");
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
