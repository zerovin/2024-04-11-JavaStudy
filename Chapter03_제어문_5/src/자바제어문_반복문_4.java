/*
 *	1~100 사이의 정수 10개 추출
 *	최대값/최소값 출력 
 */
public class 자바제어문_반복문_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max=0;
		int min=100;
		for(int i=0;i<10;i++) {
			int num=(int)(Math.random()*100)+1;
			System.out.print(num+" ");
			if(num>max) {
				max=num; //최대값
			}
			if(num<min) {
				min=num; //최소값
			}
		}
		System.out.println();
		System.out.println("최대값="+max);
		System.out.println("최소값="+min);
		
		/*
		 *	int max=1;
		 *	int a=10;
		 *	int b=20;
		 *	int c=30;
		 *	
		 *	if(max<a)
		 *		max=a => max -> 0 -> 10
		 *	if(max<b)
		 *		max=b => max -> 10 -> 20
		 *	if(max<c)
		 *		max=c => max -> 20 -> 30 
		 */
	}

}
