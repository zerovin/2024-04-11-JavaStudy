//임의의 정수를 배열로 생성해서 입력하고 정렬하는 프로그램 작성 
/*
 *	형식)
 *	   static 리턴형 메소드형(매개변수) {
 *	   ------ 메소드는 반드시 메모리에 저장
 *	          JVM에 의해 자동 저장
 *
 *        return 값;
 *	   }
 *	   
 *	   static int aaa(int a){
 *	      int b=10; => 10전송
 *	      return b;
 *	   }
 *
 *	   static int[] bbb(int[] arr){
 *	      return arr; => 배열로 넘길 때 보통 매개변수 return
 *	   }
 *
 *	   static int input(){
 *	      Scanner scan=new Scanner(System.in);
 *	      System.out.print("입력:");
 *	      int a=scan.nextInt();
 *	      return a; == 변수 a없이 return scan.nextInt();
 *	   }
 *
 *	**고려사항
 *	  1.리턴형
 *	  2.매개변수
 *	  3.변수명, 메소드명이 동일할 수 있다 => 가급적이면 다르게
 *
 *	버블정렬 - 뒤에서부터 고정
 *	30 10 40 20 50
 *  -- --
 *  10 30
 *     -- --
 *     30 40
 *        -- --
 *        20 40
 *           -- --
 *           40 50
 *	------------------- for 1
 *	10 30 20 40 50
 *  -- --       --
 *  10 30       고정
 *     -- --
 *     20 30
 *        -- --
 *        30 40
 *	------------------- for 2
 *	10 20 30 40 50
 *  -- --    -----
 *  10 20     고정
 *     -- --
 *     20 30
 *	------------------- for 3
 *	10 20 30 40 50
 *  -- -- --------
 *  10 20    고정
 *  ------------------- for 4 = length-1
 *  10 20 30 40 50
 *
 */
public class 문제_3 {
	//배열 생성
	
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
		
		System.out.println("\n===== 변경 후 =====");
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) { // j, j+1비교 => 버블정렬
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}

}
