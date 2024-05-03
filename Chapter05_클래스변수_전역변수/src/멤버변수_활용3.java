/*
 *	static 메소드
 *	 - static 변수만 사용가능
 *	 - static이 아닌 멤버변수를 사용하려면 => 객체생성(new)
 *	 - 멤버 메소드 => static 변수, 멤버변수 사용
 */
public class 멤버변수_활용3 {
	int a=10;
	static int b=10; // 동시에 변경해야 하는 사항 => static 변수
	static void display() {
		// System.out.println("a="+a); static 메소드에서 a가 static 변수가 아니라 사용 불가
		System.out.println("b="+b); //b는 static 변수라서 사용가능
		멤버변수_활용3 ss=new 멤버변수_활용3(); // new로 객체생성 후
		System.out.println("a="+ss.a); // 변수 a 사용가능
	}
	void print() {
		System.out.println("a="+a); //void에서는 static 아닌 멤버변수 사용가능
		System.out.println("b="+b); //void에서 static 변수 사용 가능
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
