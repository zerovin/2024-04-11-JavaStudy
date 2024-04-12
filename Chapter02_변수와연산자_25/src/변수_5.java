/*
 *	byte, char, int, long, float, double
 *	기타 - boolean
 *
 * 	1.데이터형의 크기
 *	  byte < char < int < long < float < double***
 *	  └ 크기의 기준 = 수 표현의 갯수, 실수형<정수형
 *
 * 	  int a=10L; (X) int=4byte, 10L=long=8byte 작은데에 큰거 들어가는거 불가
 * 	  long a-10; (O) 큰거에 작은거 들어가는 건 가능
 * 	  int a='A'; (O) //65 => 자동 형변환
 * 	   
 * 	  업캐스팅 - 크기 기준으로 작은 데이터형을 큰 데이터형으로
 * 	  다운캐스팅 - 크기 기준으로 큰 데이터형을 작은 데이터형으로
 * 
 * 	  ****
 * 	  byte + byte = int
 * 	  char + char = int
 */
public class 변수_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//강제 형변환 (int)'A'
		//자동 형변환
		int a='A';
		System.out.println(a); //65 char->int 
		
		char c=65;
		System.out.println(c); //A int->char
		
		double d='A';
		System.out.println(d); //65.0 char->double
		
		byte b1=10;
		byte b2=110;
		//byte b3=b1+b2; //byte + byte = int 라서 에러
		byte b3=(byte)(b1+b2);
	}

}
