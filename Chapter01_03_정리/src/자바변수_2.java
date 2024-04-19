/*
 *	x 변수 생성 초기값 200
 *	y 변수 생성 초기값 100
 *	sum 변수에 x와 y 더한 값
 *	-------------------- sum 출력 
 * 
 * 	닭 2마리
 * 	돼지 3마리
 * 	소 4마리
 * ---------총 다리 수 출력
 * 
 *	상품 가격 1200
 *	상품 갯수 3
 *	배송료 3000
 *	--------총 금액
 * 
 */
public class 자바변수_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=200;
		int y=100;
		int sum=x+y;
		System.out.println(sum);
		
		int 닭=2;
		int 돼지=3;
		int 소=4;
		System.out.println(닭*2+돼지*4+소*4);
		
		int 상품가격=1200;
		int 상품갯수=3;
		int 배송료=3000;
		System.out.println(상품가격*상품갯수+배송료);
		
	}

}
