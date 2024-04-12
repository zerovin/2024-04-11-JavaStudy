/*
 *	 
 * 
 * 
 */
public class 변수_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//두단어 결합시 _언더바 사용하거나 camelcase
		byte byte_value=10; //-128~127 사이 정수만 출력
		int intValue=20; //컴퓨터에서 모든 숫자는 int로 인식 21억4천, 4byte, 정수디폴트
		long longValue=30L; //숫자뒤 L,l로 구분, 8byte
		float floatValue=10.5F; //소수점 6자리까지, 4byte
		double doubleValue=10.5; //10.5D 10.5d D,d생략가능 실수디폴트
		//실제 프로그램에서 int, double 가장 많이 사용
		// 변수 = 계속 상태가 변경 / 고정 => 상수
		boolean booleanValue=true; //조건식 1byte
		char charValue='A'; //문자 한개 저장 2byte (0~65535)
		
		// ***byte, char, int, long, double, boolean
		
		char c1='된';
		char c2='장';
		char c3='국';
		char c4=' ';
		char c5='끓';
		char c6='이';
		char c7='는';
		char c8=' ';
		char c9='법';
		
		System.out.println(c1+c2+c3+c4+c5+c6+c7+c8+c9); //331870
		System.out.println(c1+""+c2+c3+c4+c5+c6+c7+c8+c9); //된장국 끓이는 법
		
		String s="된장국 끓이는 법";
		System.out.println(s); //된장국 끓이는 법
	}

}
