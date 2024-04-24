/*
 *	1.배열 생성
 *	  같은 데이터형만 모아서 관리
 *	  데이터형[] 배열명;
 *	  데이터형 배열명[]; => 사용은 가능 권장사항X (C/C++)
 *	2.초기화
 *	  데이터형[] 배열명={값, 값...} => 변경하지 않는 데이터형
 *	  데이터형[] 배열명=new 데이터형[개수]
 *	  => 기본 디폴트 값
 *	     int => 0
 *	     char => '\0'
 *	     double => 0.0
 *	     long => 0L
 *	     boolean => false
 *	3.저장 갯수 확인
 *	  length => 배열명.length
 *	4.데이터 변경
 *	  연속적인 메모리 공간
 *	  인덱스번호를 이용해서 데이터를 변경, 읽기
 *	  인덱스 번호는 0번부터 시작
 *	  변수, 배열 => 읽기/쓰기
 *	  int[] arr=new int[3]
 *	                   arr[0] arr[1] arr[2]
 *	  arr -----------> -----------------
 *	                      0     0     0
 *	                   -----------------저장된 크기가 동일(데이터형이 같음)
 *	  => 값을 변경
 *	     arr[0]=100
 *	     arr[1]=200
 *	     arr[2]=300
 *	     -------------일반 변수 취급
 *	     **인덱스는 0부터 순자척
 *	       => 반복문을 사용하기 편리
 *	       => 개수만큼만 출력 => 변경X 고정적(가변형=>클래스 제작)
 *	       => 소스량을 줄일 수 있다
 *	          소프트웨어 라인 = 하루 개발 코딩량 과거 1500줄 => 현재 250줄 
 *	5.for-each 출력 
 *	  for(데이터형 변수명:배열명){
 *	      ---------- 인덱스 번호가 아니라 실제 배열의 저장값
 *	  	배열 데이터형과 변수명의 데이터형 일치
 *	  	형변환을 할 수 없다
 *	  }
 *	  배열의 값을 변경하거나, 초기화X
 *	  Only 출력만
 *	  웹에서 주로 사용
 * 
 */
public class 배열_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 정수 10개 저장 => 용도에 따라 배열/일반변수 => 용도가 같을 경우 배열
		int[] arr=new int[10]; // 변수 10개와 동일
		// arr이름으로 10개의 데이터 제어
		
		// char 5개 => 'A'~'E' 초기값 설정
		char[] alpha= {'A','B','C','D','E'};
		
		// 데이터형 변환
		double[] data= {10.5,20.5,30.5,40.5,50}; //실수에 정수넣으면 자동으로 50.0 실수로 변환
		// 작은 데이터형은 추가 가능
		for(double d:data) {
			System.out.println(d); //10.5 20.5 30.5 40.5 50.0
		}
		// int배열 안에 int, byte, char 가능
		int[] arr2={'A','B','C','D','E'}; // 65 66 67 68 69
		for(int i:arr2) {
			System.out.print(i+" ");
		}
		
		// int <=> char 형변환없이 저장 가능
		System.out.println();
		char[] ch={65,66,67,68,69}; // A B C D E
		for(char c:ch) {
			System.out.print(c+" ");
		}
		System.out.println();
		
		// 큰 데이터형으로 값 설정
		boolean[] boo=new boolean[5];
		//false(0), true(1)
		for(boolean b:boo) {
			System.out.println(b); //false 다섯개			
		}
		
		String[] str=new String[5];
		for(String s:str) {
			System.out.println(s); //null 다섯개
		}
		
		double[] dd=new double[5]; // 0.0
		for(double d:dd) {
			System.out.println(d); // 0.0 다섯개
		}
	}

}
