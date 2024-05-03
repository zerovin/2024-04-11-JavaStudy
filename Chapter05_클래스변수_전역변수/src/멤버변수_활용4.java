class Human{
	/*static*/ String name;
	/*static*/ String sex;
	// static O - 공통으로 사용하는 메모리 생성
	// static X - new 사용시 다른 메모리 생성
}
public class 멤버변수_활용4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human hong=new Human();
		hong.name="홍길동";
		hong.sex="남자";
		Human shim=new Human();
		shim.name="심청이";
		shim.sex="여자";
		
		System.out.println(hong.name);
		/*
		 * static String name; 일때
		 * 심청이 => static 변수는 모든 데이터값이 통일
		 *          각각의 데이터를 저장해야 할때는 static 쓰면 안됨
		 *          가장 마지막에 넣은 데이터값으로 모든 데이터의 값이 같아짐
		 *           
		 * String name; 일때
		 * 홍길동 => new 사용시마다 개별 메모리 생성
		 *         각각의 데이터값 저장
		 */
	
	}

}
