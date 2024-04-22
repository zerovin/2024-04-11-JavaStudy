/*
 *	1~100 정수 => 3의 배수 갯수, 5의 배수 갯수, 7의 배수 갯수 추출
 * 
 */
public class 자바제어문_반복문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count3=0, count5=0, count7=0;
		for(int i=1;i<=100;i++) {
			if(i%3==0) {
				count3++;
			}
			if(i%5==0) {
				count5++;
			}
			if(i%7==0) {
				count7++;
			}
		}
		System.out.println("1~100까지 3의 배수 갯수 : "+count3);
		System.out.println("1~100까지 5의 배수 갯수 : "+count5);
		System.out.println("1~100까지 7의 배수 갯수 : "+count7);
		// 갯수누적(++),누적합(+=)
	}

}
