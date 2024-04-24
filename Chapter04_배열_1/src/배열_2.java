// 5개의 난수 발생 => 출력, 평균출력
public class 배열_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int a1=(int)(Math.random()*100)+1;
		int a2=(int)(Math.random()*100)+1;
		int a3=(int)(Math.random()*100)+1;
		int a4=(int)(Math.random()*100)+1;
		int a5=(int)(Math.random()*100)+1;
		
		System.out.println(a1+" "+a2+" "+a3+" "+a4+" "+a5);
		System.out.printf("평균:%.2f\n",(a1+a2+a3+a4+a5)/5.0);
		*/
		
		//배열
		int[] arr=new int[5]; //new를 이용하면 자동으로 값 초기화 => 5개의 정수가 0으로 들어감
		for(int i=0;i<5;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
		//출력 ==> 향상된 for문 => for-each => 데이터 출력용 => 배열, 컬렉션에서만 사용가능
		//값 추가, 수정 불가 => only 출력만 담당 => 데이터가 모아져 있어야 사용 가능
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
		/*
		 *	new를 이용해 메모리 할당 => 자동 초기화
		 *	int => 0
		 *	double => 0.0
		 *	long => 0L
		 *	float => 0.0F
		 *	boolean => false
		 *	char => '\0'
		 *	String = null
		 *
		 *	배열, 클래스가 저장되는 위치
		 *	메모리구조
		 *	---------------------
		 *	 Method Area/static
		 *	 main
		 *	---------------------
		 *	 Stack => 지역변수 => 메모리 자체 관리
		 *	 └ {}이 종료되면 자동으로 사라짐
		 *	---------------------
		 *	 Heap => 배열, 클래스의 실제값 => 프로그래머가 관리
		 *	      프로그래머 관리소홀(삭제X) => 자동메모리회수(가비지컬렉션-자동삭제) 바로회수X 프로그램종료시 회수
		 *	      => 메모리 누수현상
		 *	---------------------
		 *
		 *	int[] arr=new int[5] 5개가 들어갈 공간을 연속적으로 모아줌, 변수는 따로따로
		 *	new(스택) => 요청한 메모리를 생성 => 생성된 위치의 주소값을 배열변수에 넘겨준다
		 *
		 *	     스택                 힙
		 *	 arr = 0x100=>|   100     104     108     112     116
		 *	              | ---------------------------------------
		 *	   ==========>|    0   |   0   |   0   |   0   |   0    
		 *	              | ---------------------------------------
		 *	              |    0       1       2       3       4    ======> index
		 *	              |  arr[0]  arr[1]  arr[2]  arr[3]  arr[4] ======> 실제 사용되는 값
		 *	              | arr+0*4  arr+1*4 arr+2*4 arr+3*4 arr+4*4
		 *	              |   100     100+4  100+8   100+12  100+16
		 *	              | => 연속적인 메모리 구조
		 *	              | arr의 첫번째 값 요청 => arr[0] => 일반 변수와 동일
		 *	              | arr의 두번째 값 요청 => arr[1]
		 *	              | arr의 세번째 값 요청 => arr[2]
		 *	              | ...
		 *	              | ...
		 *	                => 해당위치의 값을 인덱스로 표현(0번부터 시작)
		 *	                => 생성되면 삭제, 추가 불가능 => 고정
		 *	                => 인덱스번호가 0부터 순차적으로 만들어진다
		 *	                   └ 반복문 처리가 편하다
		 *	 
		 *	int[] arr=new int[3];
		 *	=> arr[0] arr[1] arr[2]
		 *	int a,b,c;
		 *	a=100;
		 *	b=200;
		 *	c=200;
		 *
		 *	arr[0]=100
		 *	arr[1]=100
		 *	arr[2]=100
		 *
		 */
		
		/*
		 *	for-each
		 *	for(데이터형 변수:배열명)
		 *	     └ 반드시 배열에 저장된 실제 데이터 값을 입력해야 읽어옴 int, double, char
		 *	       데이터형이 배열의 데이터형보다 크면 가능
		 *	       배열의 모든 값을 읽으면 자동 종료
		 *	ex)
		 *		int[] arr={10,20,30,40,50}
		 *		for(int i:arr)
		 *			i=10
		 *			i=20
		 *			i=30
		 *			i=40
		 *			i=50  ==> 종료
		 *
		 *		char[] arr={'A','B','C'}
		 *		for(char c:arr)
		 *			c='A'
		 *			c='B'
		 *			c='C' ==> 종료
		 *	 	==> 출력과 관련(브라우저에서 목록출력)에 사용
		 *		
		 *		char[] arr={'A','B','C'}
		 *		for(int i:arr) ======> char배열을 int for-each 가능
		 *		
		 *byte < char < int < long < float < double
		 *		=> 형변환은 사용 불가
		 *
		 *		(double)int a; ==> X
		 *		int a=(int)10.5 ==> O
		 * 
		 */
	}

}
