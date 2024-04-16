/*
 *	국어 영어 수학 점수입력 => 총점 평균 
 *	학점 = 100~90 A => +, 0, -
 *		   89~80 B
 *		   79~70 C
 *		   69~60 D
 *				 F
 */
import java.util.Scanner;
public class 제어문_단일조건문_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		//필요한 변수 선언
		int kor,eng,math;
		char score='A'; //if문에 모든 조건 불충족시 실행이 안되서 초기값X => 오류, 초기값 설정해줘야 오류X
		
		// 입력값을 받아 초기화
		System.out.print("국어 점수 입력:");
		kor=scan.nextInt();
		
		System.out.print("영어 점수 입력:");
		eng=scan.nextInt();
		
		System.out.print("수학 점수 입력:");
		math=scan.nextInt();
		
		// 학점 계산
		int avg=(kor+eng+math)/3;
		if(avg>=90 && avg<=100) {
			score='A';
		}
		if(avg>=80 && avg<90) {
			score='B';
		}
		if(avg>=70 && avg<80) {
			score='C';
		}
		if(avg>=60 && avg<70) {
			score='D';
		}
		if(avg<60) {
			score='F';
		}
		
		// 출력
		System.out.println("====== 결과값 ======");
		System.out.println("국어 점수:"+kor);
		System.out.println("영어 점수:"+eng);
		System.out.println("수학 점수:"+math);
		System.out.println("총점:"+(kor+eng+math));
		System.out.printf("평균:%.2f\n",(kor+eng+math)/3.0);
		// \n => printf 에서 줄바꿈 = new line = ln
		// \t => 일정 간격 띄울때 사용 = tab 
		System.out.println("학점:"+score+"학점");

	}

}
