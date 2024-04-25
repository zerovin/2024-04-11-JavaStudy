// 3. 크기가 10인 정수형 배열을 생성하고 여기에 0부터 9까지의 값으로 배열을 채우는 프로그램 만들기
import java.util.Arrays;
public class 문제_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num=new int[10];
		for(int i=0;i<num.length;i++) {
			num[i]=i;
			System.out.print(num[i]+" ");
		}
		System.out.println("\n"+Arrays.toString(num));
	}

}
