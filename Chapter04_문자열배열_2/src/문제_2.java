/*
 *	2. 1월달 사원(1번부터 5번사원)의 실적이 50 45 35 12 70 이다. (실적 0~100)
 *	  1) 사번별 실적을 출력하시오. 사원(1) 50..
 *	  2) 1월 실적의 총점과 평균을 출력하시오.
 *	  3) 실적이 제일 큰 사원의 사번과 실적, 작은 사원의 사번과 실적을 출력하시오. 
 */
public class 문제_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score= {50,45,35,12,70};
		int total=0;
		int max=score[0];
		int min=score[0];
		for(int i=0;i<score.length;i++) {
			System.out.println("사원("+(i+1)+") "+score[i]);
			total+=score[i];
			if(max<score[i]) {
				max=score[i];
				
			}
			if(min>score[i]) {
				min=score[i];
			}
		}
		
		System.out.println("1월 실적 총점:"+total);
		
		double avg=total/(double)score.length;
		System.out.printf("1월 실적 평균:%.2f\n",avg);
		// 정수 %d / 실수 %f / 문자 %c / 문자열 %s
		
		for(int i=0;i<score.length;i++) {
			if(score[i]==max) {
				System.out.println("최대실적:사원("+(i+1)+") "+score[i]);
			}
			if(score[i]==min) {
				System.out.println("최소실적:사원("+(i+1)+") "+score[i]);
			}
		}
	}

}
