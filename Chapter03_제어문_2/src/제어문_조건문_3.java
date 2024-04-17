/*
 *	단일조건문
 *	-단점 - 독립문장이기 때문에 모든 단일조건문 실행 => 속도 저하
 *	-동시에 여러 조건문을 실행하고자 할 때 이용
 *	
 *	다중조건문
 *	-하나의 문장에 있는 여러 조건문 중 true 실행 => 속도 빠름
 *
 * 	선택조건문
 * 	-true/false를 나눠서 처리
 * 	-형식 if(조건문){
 * 			조건이 true일 때 처리
 * 		}else{
 * 			조건이 false일 때 처리
 * 		}
 * 
 */
// 1. 짝수 num%2==0 / 홀수 num%2!=0
/*
 *	if => 정상수행
 *	else => 오류 => 입력문제
 *	
 *	오류발생
 *	1)프로그래머의 실수 => 어려워ㅓㅓ => 예외처리
 *	2)사용자 입력값 문제 => if~else 
 * 
 */
public class 제어문_조건문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=(int)(Math.random()*100)+1;
		System.out.println("num="+num);
		
		if(num%2==0) {
			//true일  때 처리
			System.out.println(num+"는(은) 짝수입니다");
		}
		//if(num%2!=0)
		else {   
			//false일 때 처리
			System.out.println(num+"는(은) 홀수입니다");
		}
	}

}
