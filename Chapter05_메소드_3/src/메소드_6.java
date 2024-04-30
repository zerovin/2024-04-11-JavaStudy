/*
 *	5개 정수 넘겨주면 => 정렬 ASC(오름차순)/DESC(내림차순)
 *
 *	선택정렬 : 1개를 선택해서 변경
 *	버블정렬 : 인접한 데이터끼리 변경
 *	-------------sort, reserve
 *	             오라클 : ORDER BY
 *	로직 - 프로그램돌리는 방식, 2차 for사용
 *
 *	1. 2차for문
 *	         1    2    7
 *	   for(초기값;조건식;증감식){
 *             3    4    6
 *	   	 for(초기값;조건식;증감식){
 *	        반복 출력 문장 5
 *	     }
 *	   }
 *	   ex)
 *	      for(int i=1;i<=5;i++){
 *	        for(int j=1;j<=5;j++){
 *	           반복 출력 문장 => 25번
 *	        }
 *	      }
 *	      i=1 i<=5 ----------- j=1 j<=5 문장수행 j++
 *	                           j=2 j<=5 문장수행 j++
 *	                           j=3 j<=5 문장수행 j++
 *	                           j=4 j<=5 문장수행 j++
 *	                           j=5 j<=5 문장수행 j++
 *	                           j=6 j<=5 false 종료
 *	                           -------------------i++
 *	      i=2 i<=5 ----------- j=1 j<=5 문장수행 j++
 *	                           j=2 j<=5 문장수행 j++
 *	                           j=3 j<=5 문장수행 j++
 *	                           j=4 j<=5 문장수행 j++
 *	                           j=5 j<=5 문장수행 j++
 *	                           j=6 j<=5 false 종료
 *	                           -------------------i++
 *	      i=3 i<=5 ----------- j=1 j<=5 문장수행 j++
 *	                           j=2 j<=5 문장수행 j++
 *	                           j=3 j<=5 문장수행 j++
 *	                           j=4 j<=5 문장수행 j++
 *	                           j=5 j<=5 문장수행 j++
 *	                           j=6 j<=5 false 종료
 *	                           -------------------i++
 *	      i=4 i<=5 ----------- j=1 j<=5 문장수행 j++
 *	                           j=2 j<=5 문장수행 j++
 *	                           j=3 j<=5 문장수행 j++
 *	                           j=4 j<=5 문장수행 j++
 *	                           j=5 j<=5 문장수행 j++
 *	                           j=6 j<=5 false 종료
 *	                           -------------------i++
 *	      i=5 i<=5 ----------- j=1 j<=5 문장수행 j++
 *	                           j=2 j<=5 문장수행 j++
 *	                           j=3 j<=5 문장수행 j++
 *	                           j=4 j<=5 문장수행 j++
 *	                           j=5 j<=5 문장수행 j++
 *	                           j=6 j<=5 false 종료
 *	                           -------------------i++
 *	      i=6 i<=5 - false 종료 => for 전체 종료
 *
 *	2. 선택정렬 - 앞에서부터 고정
 *	   ex)
 *	      30 20 40 10 50
 *	      -- --
 *	      20 30
 *	      --    --
 *	      20    40
 *	      --       --
 *	      10       20
 *	      --          --
 *	      10          50
 *	      ---------------- for 1
 *	      10 30 40 20 50
 *	      -- -- --
 *	     고정 30 40
 *	         --    --
 *	         20    30
 *	         --       --
 *	         20       50
 *	      ---------------- for 2
 *	      10 20 40 30 50
 *	      ----- -- --
 *	       고정  30 40
 *	            --    --
 *	            30    50
 *	      ---------------- for 3
 *	      10 20 30 40 50
 *	      -------- -- --
 *	         고정   40 50
 *	      ---------------- for 4 = length-1
 *	      10 20 30 40 50
 *
 *
 */
public class 메소드_6 {
	static int[] sort(String type, int[] arr) {
		boolean bCheck=false;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(type.equals("DESC")) {
					bCheck=arr[i]<arr[j]; // 내림차순 = desc true
				}else {
					bCheck=arr[i]>arr[j]; // 오름차순 = desc false
				}
				if(bCheck) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[5];
		for(int i=0;i<arr.length;i++) {
			//초기화
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println("===== 변경 전 =====");
		for(int i:arr) { // for-each 출력 전용
			System.out.print(i+" ");
		}
		System.out.println("\n===== 변경 후 =====");
		/*
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		*/
		arr=sort("DESC",arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		arr=sort("ASC",arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}

}
