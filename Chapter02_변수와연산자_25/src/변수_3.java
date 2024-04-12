/*
 *	국어 영어 수학 => 총점 평균 학점(ABCDF) 
 * 	 -국어 영어 수학 총점 => 정수 int
 * 	 -평균 => 실수 double
 * 	 -학점 => 문자 char
 * 
 * 
 */
public class 변수_3 {
	public static void main(String[] args) {
		int kor = 90;
		int eng = 80;
		int math = 75;
		int total = kor+eng+math;
		double avg = total/3.0;
		// 정수/정수=정수 => 정수/실수(정수.0)=실수 평균치 구할 때는 실수로 나누기
		System.out.println("국어점수:"+kor);
		System.out.println("영어점수:"+eng);
		System.out.println("수학점수:"+math);
		System.out.println("평균:"+avg); //소수점 15까지 다 나옴
		System.out.printf("평균:%.2f",avg); //%.2f => 소수점이하 2자리까지 반올림 출력, 수식이라 Printf
	}
}
