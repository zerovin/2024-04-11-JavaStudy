//5. 정수를 10개 저장하는 배열을 만들고
//	1에서 10까지 범위의 정수를 랜덤하게 생성하여 배열에 저장하라.
//	그리고 배열에 든 숫자들과 평균을 출력하라
public class 문제_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 배열 선언, 변수 선언
		int[] num=new int[10];
		int total=0;
		double avg;
		
		// 2. 초기화 => 인덱스 필요 => 일반 for문
		for(int i=0;i<num.length;i++) {
			num[i]=(int)(Math.random()*10)+1;
			// 3. 요청처리
			System.out.print(num[i]+" ");
			total+=num[i];
		}
		avg=total/(double)(num.length); // num.length 는 int니까 (double)로 형변환
		
		// 결과값 출력
		System.out.printf("\n평균:%.2f\n",avg);
	}

}
