/*
 *	형변환 연산자
 *	(데이터형) - boolean은 제외 
 *	- UpCasting => 데이터형을 크게 만든다
 *	- DownCasting => 데이터형을 낮게 만든다
 *	
 *		------------ UpCasting -------------->
 *	  byte < char < int < long < float < double
 *		<----------- DownCasting--------------
 *
 *	  ex) 'A' => char
 *		  (int)'A' => int => 65
 *		  =>UpCasting
 *	
 *		  10.5 => double
 *		  (int)10.5 => int => 10
 *		  => DownCasting
 */
public class 연산자_단항연산자_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 형변환 (데이터형) (int), (double), (char)...
		
		//UpCasting
		System.out.println('A'); //A
		System.out.println((int)'A'); //65
		
		//DownCasting
		System.out.println(98); //98
		System.out.println((char)98); //b
		
		System.out.println(10.5); //10.5
		System.out.println((int)10.5); //10
		
		/*
		 *	10.5 + 10.5 = 21.0
		 *	(int)(10.5+10.5) = (int)21.0 = 21
		 *	(int)10.5 + (int)10.5 = 10 + 10 = 20
		 *
		 *	double d=123456.78;
		 *	int i=123456;
		 *	(int)((d-i)*100) = 77
		 *  
		 *  Math.random() = 0.0 and less than 1.0 => 0.0 ~ 0.99 난수 발생
		 *  게임, 예약일
		 *  
		 */
		
		double d=123456.78;
		float f=123456.78F;
		int i=123456;
		System.out.println((int)((d-i)*100)); // 77 byte 차이가 나서 0.78이 아니라 0.777777777로 인식
		System.out.println((int)((f-i)*100)); // 78 byte가 같으면 딱 떨어짐
		
		int rand=(int)(Math.random()*100)+1;
		// Math.random() => 0.0 ~ 0.99사이의 난수 발생
		// (int)((0.0~0.99)*100)+1 = (int)(0.0~99.0)+1 = (0~99)+1 = 1~100
		System.out.println("rand="+rand);
		
	}

}
