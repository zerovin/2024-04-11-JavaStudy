/*
 *	논리연산자 결과갑 = true/false
 *	- && 직렬연산자 - 범위, 기간 포함 
 *	  ex) a>=0 && a<=100 ===> 0~100사이에 있는지
 *	- || 병렬연산자 - 범위, 기간을 벗어난 경우
 *	  ex) a<0 || a>100 ===> 0미만 100초과
 *
 *	  (조건) && (조건) = 두 조건이 모두 true => true
 *				       둘 중 하나라도 false => false
 *					  **앞조건이 false면 뒷조건을 수행하지 않음 => false => 최적화 연산
 *	  (조건) || (조건) = 둘 중 하나라도 true => true
 *				       두 조건 모두 false => false
 *					  **앞조건이 true면 뒷조건을 수행하지 않음 => true => 최적화 연산
 *
 *	  ----------------------------------------------
 *							&&			||		
 *	  ----------------------------------------------
 *		true true		   true		   true
 *	  ----------------------------------------------
 *		true false		  false		   true
 *	  ----------------------------------------------
 *		false true		  false		   true
 *	  ----------------------------------------------
 *		false false		  false		   false
 *	  ----------------------------------------------	
 * 
 */
public class 연산자_논리연산자_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=10;
		int y=9;
		boolean bCheck = x==y && ++y==x; //false
		System.out.println("bCheck="+bCheck);
		System.out.println("x="+x); // 10
		System.out.println("y="+y); // 9 뒷부분 연산을 수행하지 않았기 때문에 9 => 효율적인 연산 => 최적화 연산
		
		boolean bCheck2 = x!=y && ++y==x; //true
		System.out.println("bCheck2="+bCheck2);
		System.out.println("x="+x); // 10
		System.out.println("y="+y); // 10 뒷부분 연산을 수행했기 때문에 10
	}

}
