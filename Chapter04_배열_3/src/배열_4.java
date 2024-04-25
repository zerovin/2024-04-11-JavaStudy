/*
 *	배열의 범위를 벗어나면 오류발생, 인덱스 = 0 ~ 개수-1 
 *	프로그래머의 실수가 가장 많은 곳 => 실행시 에러
 *	ArrayIndexOutOfBoundsException = 인덱스오류 93page
 *	=> 크롤링
 *
 *	에러 => 에러 처리
 *
 */

public class 배열_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2};
		System.out.println(arr[2]); //에러
	}

}
