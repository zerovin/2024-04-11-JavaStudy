/*
 *	6. 0~9사이의 난수를 100개 발생해서 
       빈도를 구해서 출력하시오 
       예)
         0의 개수: 1
         1의 개수: 1
         ..
         9의 개수: 0
 * 
 */
public class 문제_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num=new int[100];
		for(int i=0;i<num.length;i++) {
			num[i]=(int)(Math.random()*10);
		}
		
		int[] result=new int[10];
		for(int i=0;i<num.length;i++) {
			result[num[i]]++;
		}
		for(int i=0;i<result.length;i++) {
			System.out.println(i+"의 개수:"+result[i]);
		}
	}

}
