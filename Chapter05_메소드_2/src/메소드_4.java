/*
 *	매개변수 - 지역변수와 동일, 메소드 종료되면 자동으로 메모리 삭제
 *	        사용자가 보내주는 값 = 요청 => {가공 후 처리 결과값 전송}
 *	        Call By Value(기본형)*** / Call By Refernce(배열/클래스)
 *
 *	        static void display(int a, int b){
 *	        	                -------------a,b변수 초기화
 *	        	매개변수는 호출시에 초기화
 *	        	display(10,20) ==> a=10, b=20
 *	        	a, b 매개변수 순서에 맞춰서 보내야 함
 *	        	ex) isLogin(String id, String pwd)
 *	        	    => isLogin("1234","admin") => X
 *	                회원가입시 15~20개 정보 묶어서 전송 => 같은데이터형-배열/다른데이터형-클래스
 *	        	**매개변수는 3개이상 초과하지 않는다 
 *	        }
 * 
 */

// 입력 / 처리 / 출력 => 3개의 정수 입력 => 총점, 평균, 학점, 출력
import java.util.*;
public class 메소드_4 {
	// 입력기능
	static int scoreInput(String subject) {
		Scanner scan=new Scanner(System.in);
		System.out.print(subject+" 점수 입력 >> ");
		return scan.nextInt();
	}
	static int scoreTotal(int k, int e, int m) {
		return k+e+m;
	}
	static double scoreAvg(int total) {
		return total/3.0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kor=scoreInput("국어");
		int eng=scoreInput("영어");
		int math=scoreInput("수학");
		System.out.println("국어 점수 : "+kor);
		System.out.println("영어 점수 : "+eng);
		System.out.println("수학 점수 : "+math);
		int total=scoreTotal(kor,eng,math);
		double avg=scoreAvg(total);
		System.out.println("총점 : "+total);
		System.out.printf("평균 :%.2f\n",avg);
	}

}
