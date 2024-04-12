/*
 *	30 20 40 50 10 => 10 20 30 40 50
 *	Select Sort	
 *
 * 
 * 
 */
public class 변수_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={30, 20, 40, 50, 10};
		System.out.println("변경 전:");
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
				
			}
		}
		System.out.println("변경 후:");
		System.out.println(Arrays.toString(arr));
	}

}
