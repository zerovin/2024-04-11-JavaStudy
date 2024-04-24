//3. 배열 alpha를 모두 출력하고자 한다. 빈칸에 적절한 코드를 삽입하시오.
import java.util.Arrays;
public class 문제_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] alpha = {'a', 'b', 'c', 'd'};

		for(int i=0;i<alpha.length;i++) { //인덱스 이용시 일반 for문 사용
			System.out.print(alpha[i]); // abcd
		}
		
		System.out.println("\n====== for-each ======");
		for(char c:alpha) { // 인덱스없이 실제값 출력, 웹 출력용 => for-each
			//받는 변수 데이터형 == 배열의 데이터형
			//받는 변수 데이터형이 더 커야해
			System.out.print(c+" ");
		}
		
		System.out.println("\n======== API =========");
		System.out.println(Arrays.toString(alpha));
	}

}
