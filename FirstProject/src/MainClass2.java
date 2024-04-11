//출력 형식
/*
 	= System.out.println()
 						===== ln() => new Line
 	  System.out.println("Hello ")
 	  System.out.println("Java")
 	  Hello
 	  Java
 	= System.out.print() ==> 옆으로 출력
 	  System.out.print("Hello ")
 	  System.out.print("Java")
 	  Hello Java
 	= System.out.printf() ==> 서식이 있는 출력
 	  %d => 정수
 	  %f => 실수
 	  %c => 문자
 	  %s => 문자열
 	= 자바에서 표현법
 	  정수표현법 => 10진법(0-9) 10, 20 .....
 	  			 8진법(0-7) 010 10진법과의 구분을 위해 앞에 0, 10진법8=8진법010 
 	  			 16진법 0x10 앞에 0x, 색상코드에서 사용
 	  			 2진법 0b10 앞에 0b
 	  			 ----------------------
 	  			 10 = 32bit => int
 	  			 10L = 64bit => long
 	  실수표현법 => 10.5 - 저장하는 메모리 크기 => 64bit
 	  			 10.5F - 32bit (4byte) 1byte=8bit	 
 	  문자표현법 => 'A' => 한글자만 사용가능
 	  문자열표현법 => "Hello" => 여러 문자 사용가능
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(010); //8
		System.out.println(0x10); //16
		System.out.println(0b10); //2
		System.out.println("홍길동"); //홍길동
		System.out.println("\"홍길동\""); //"홍길동"
		System.out.println("c:\\javaDev\\movie.txt"); //c:\javaDev\movie.txt 경로지정시 역슬래시 두개씩
		//명령문 종료시는 반드시 ;
		System.out.println("홍길동\t남자"); // \t - tab 일정간격 띄어쓰기
		System.out.println("홍길동\n남자"); // \n - enter 줄바꿈
		
		System.out.print("홍길동\t"); //print 옆으로 출력 + \t tab
		System.out.print("남자\t");
		System.out.println("26");
		
		System.out.print("★\n★★\n★★★\n★★★★\n★★★★★\n");
		//=
		System.out.println("★");
		System.out.println("★★");
		System.out.println("★★★");
		System.out.println("★★★★");
		System.out.println("★★★★★");
		
		
		  for(int i=0;i<=4;i++) { 
			  for(int j=0;j<=4-i;j++) { 
				  System.out.print("*"); 
				  }
			  System.out.println(); 
		  }
		 System.out.println("10 20 30 40 50");
		 System.out.printf("%-3d%-3d%-3d%-3d%-3d",10,20,30,40,50); //000세칸 중 %-3 = 좌측정렬, %3d = 우측정렬
		 System.out.printf("%3d%3d%3d%3d%3d",10,20,30,40,50);
	}

}
