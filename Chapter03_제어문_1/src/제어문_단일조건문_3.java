/*
 *	if(조건문) => 웹-페이지를 나눈 경우(사람이 한눈에 볼 수 이는 이미지 15~20)
 *				  -상세보기
 *				  -검색
 *	54page
 *	조건문 형식) if(조건문){ => true/false => 부정연산자(!), 비교연산자, 논리연산자
 *				실행문장 => 조건이 true일때만 수행이 된다
 *			  }
 * 			 *연산자 사용법
 * 			  산술연산자 => 일반 계산
 * 			  -------
 * 			  비교연산자
 * 			  논리연산자
 * 			  부정연산자
 * 			  --------- 조건문, 반복문
 * 			  증감연산자 => 반복문
 * 			  대입연산자 => 결과값받기
 * 
 *	대입연산자
 */
public class 제어문_단일조건문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		int num=(int)(Math.random()*100)+1; //1~100 난수 추출
		System.out.println("1.num="+num);
		if(num>=50)
			sum+=num; // sum=sum+num
		
		num=(int)(Math.random()*100)+1; //1~100 난수 추출
		System.out.println("2.num="+num);
		if(num>=50)
			sum+=num; // sum=sum+num
		
		num=(int)(Math.random()*100)+1; //1~100 난수 추출
		System.out.println("3.num="+num);
		if(num>=50)
			sum+=num; // sum=sum+num => 장바구니 금액 / 결제 금액
		
		System.out.println("===== 결과값 =====");
		System.out.println("sum="+sum);
		
	}

}
