import java.util.Scanner;
// c => include
// c# => using
// python => import
// javascript => import
// 기존에 만든 클래스 불러오기, 라이브러리 읽기
// 같은 폴더에 있는 경우에는 생략 => 다른 폴더에 있는 경우에만 사용

// 국어, 영어, 수학 점수를 입력받아 총점, 평균 출력
public class 연산자_입력값처리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 저장할 메모리 공간 = 변수
		int kor,eng,math,total;
		double avg;
		
		// 사용자로부터 입력값을 받아서 변수 초기화
		// 키보드 입력값 받기
		
		
		Scanner scan=new Scanner(System.in);
		
		/*
		System.out.print("국어점수:");
		kor=scan.nextInt();
		
		System.out.print("영어점수:");
		eng=scan.nextInt();
		
		System.out.print("수학점수:");
		math=scan.nextInt();
		// => 각자 하나하나 받기
		*/
		
		System.out.print("국어,영어,수학 입력:(60 70 80):"); // => 공백으로 구분
		kor=scan.nextInt();
		eng=scan.nextInt();
		math=scan.nextInt();
		
		// 처리
		// 사용자 요청 => 프로그램에서 요청 처리결과를 보여줌 => 연산자 이용
		total=kor+eng+math;
		avg=total/3.0;
		
		System.out.println("===== 결과 =====");
		System.out.println("총점:"+total);
		System.out.printf("평균:%.2f",avg);
	}

}
