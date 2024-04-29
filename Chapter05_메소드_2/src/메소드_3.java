// 매개변수 - 메소드 안에서만 사용가능 == 지역변수
// 메소드 호출시에 메모리 저장 => 메소드 종료시 자동으로 메모리 해제
public class 메소드_3 {
	static int j=1; //전역변수 - 얘는 프로그램 종료시까지 유지, 종료시 삭제
	static int k=1;
	static int l=1;
	static void increment() { // 호출시마다 변수 다시 생성, 이전변수 자동삭제
		int i=1; //지역변수
		int k=1; 
		System.out.println("i="+i); // 여러번출력해도 새롭게 i=1메모리를 생성해서 1만출력 증가X
		++i;
		
		System.out.println("j="+j);
		++j;
		
		System.out.println("k="+k); // 지역변수 우선, 전역변수 지역변수 둘다 선언되었을때 지역변수로 인식
		++k;
		
		System.out.println("l="+메소드_3.l); // 전역변수 지역변수 둘다 선언되었을때 전역변수로 쓰고 싶으면 메소드명.변수
		++메소드_3.l;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		increment(); //i=1 j=1 k=1 l=1 메소드 종료시{} 안에 선언된 모든 변수는 메모리에서 사라진다(지역변수)
		increment(); //i=1 j=2 k=1 l=2
		increment(); //i=1 j=3 k=1 l=3
	}

}
