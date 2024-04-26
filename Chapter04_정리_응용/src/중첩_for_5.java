/*
 *	중복이 없는 난수
 *
 * 	1~10 10개 난수 발생 - 중복없이
 */
public class 중첩_for_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 용도가 같은 정수 10개 저장
		int[] arr=new int[10]; //변수이름을 1개로 통일, 구분은 인덱스
		//인덱스 0 ~ length-1
		//제어하기가 편리 (읽기/쓰기), 반복문을 사용하기 때문에 소스코딩을 줄일 수 있다
		//int a=random() => 500개
		//클래스 - 한개의 이름으로 여러개 동시제어 => 인터페이스
		
		//초기화
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10)+1;
			for(int j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					i--; //다시 난수 발생
					break; //2차 for문만 제어
				}
			}
		}
		
		
		
		
		
		//출력
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
		
	}

}
