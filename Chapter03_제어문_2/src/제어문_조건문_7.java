/*
 *	1.형식
 *	2.흐름파악 => 동작순서
 *	3.응용 
 *
 *	1)제어문 : 프로그램 제어 - 요청한 내용만 출력 - 필요시에는 수행을 건너뜀(if))
 *						 반복수행 - 반복문, 중단(break), 다시시작(continue)
 *						 선택된 내용만 출력(선택문) 
 *	  - 조건문 : 오류처리, 건너뛰기 - 사용자 요청에 맞는 내용만 출력
 *		=단일조건문 - 독립정인 문장 (조건에 맞는 모든 문장을 수행)
 *			if(조건문){
 *				true에 수행이 되는 영역 => false면 건너뜀
 *			}
 *		=선택조건문 - true/false 나눠서 작업 => 56page
 *			if(조건문){
 *				true일 때 처리되는 문장
 *			}else{
 *				false일 때 처리되는 문장
 *			}
 *		=다중조건문 - 여러개의 조건중 1개만 출력
 *			if(조건문){
 *				true => 문장수행 => 종료
 *				false ↓
 *			}else if(조건문){
 *				true => 문장수행 => 종료
 *				false ↓
 *			}else if(조건문){
 *				true => 문장수행 => 종료
 *				false ↓
 *			}else{
 *				해당 조건이 없는 경우에 수행문장 => 필요시에만 처리(생략가능)
 *			}
 * 		-if~else > 단일조건문 > 다중조건문(게임-키선택,메뉴-switch~case) 순으로 많이 씀
 * 								
 */
//성적계산 ==> 다중조건문 
import java.util.Scanner;
public class 제어문_조건문_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		// 클래스 메모리 저장 => new
		// System.in => 키보드 입력값
		System.out.print("국어점수:");
		int kor=scan.nextInt();
		
		System.out.print("영어점수:");
		int eng=scan.nextInt();
		
		System.out.print("수학점수:");
		int math=scan.nextInt();
		
		System.out.println("국어점수:"+kor);
		System.out.println("영어점수:"+eng);
		System.out.println("수학점수:"+math);
		System.out.println("총점:"+(kor+eng+math));
		System.out.printf("평균:%.2f\n",(kor+eng+math)/3.0);
		
		//요청사항 => 학점 => 다중조건문
		char score='A';
		int avg=(kor+eng+math)/3; //학점에서는 소수점 안필요해서 정수로 나눔
		
		if(avg>=90) {
			score='A';
		}else if(avg>=80) {
			score='B';
		}else if(avg>=70) {
			score='C';
		}else if(avg>=60) {
			score='D';
		}else{
			score='F';
		}
		System.out.println("학점:"+score);
	}

}
