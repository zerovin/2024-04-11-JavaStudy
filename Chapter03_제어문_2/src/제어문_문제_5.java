//100점 만점으로 성적을 입력 받아 90~100이면 A,80~89이면 B,70~79이면 C, 60~69이면 D,
// 60점 이하면 F를 출력하라 (if 사용)
//import java.util.Scanner;
public class 제어문_문제_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner scan=new Scanner(System.in);
		//System.out.print("성적입력:");
		//int score=scan.nextInt();
		int score=(int)(Math.random()*100)+1;
		System.out.println("점수:"+score);
		System.out.println("===== 결과값 =====");
		
		/*
		if(score>100) {
			System.out.println("잘못된 입력입니다");
		}
		*/
		if(score>=90 && score<=100) {
			System.out.println("A학점");
		}
		if(score>=80 && score<90) {
			System.out.println("B학점");
		}
		if(score>=70 && score<80) {
			System.out.println("C학점");
		}
		if(score>=60 && score<70) {
			System.out.println("D학점");
		}
		if(score<60){
			System.out.println("F학점");
		}
		
		
	}

}
