
public class 메소드_2 {
	static void aaa() {
		System.out.println("aaa() 진입 = 1"); //1
		System.out.println("aaa() 기능 처리 = 2"); //2
		bbb();
		System.out.println("aaa() 종료 = 12"); //12
	}
	static void bbb() {
		System.out.println("bbb() 진입 =3 "); //3
		ccc(); //5
		System.out.println("bbb() 기능 처리 = 10"); //10
		System.out.println("bbb() 종료 = 11"); //11
	}
	static void ccc() {
		System.out.println("ccc() 진입 = 4"); //4
		ddd();
		System.out.println("ccc() 기능 처리 = 8"); //8
		System.out.println("ccc() 종료 = 9"); //9
	}
	static void ddd() {
		System.out.println("ddd() 진입 = 5"); //5
		System.out.println("ddd() 기능 처리 = 6"); //6
		System.out.println("ddd() 종료 = 7"); //7
	}
	// LIFO => stack 먼저 생성된게 나중에 끝남
	// 호출영역 => call stack
	/*
	 *	  --------------
	 *                                                 ddd() ===> 메모리 해제 1
	 *	  --------------
	 *                                        ccc()    ccc() ===> 메모리 해제 2
	 *	  --------------
	 *	                             bbb()    bbb()    bbb() ===> 메모리 해제 3
	 *	  --------------
	 *	                    aaa()    aaa()    aaa()    aaa() ===> 메모리 해제 4
	 *	  --------------
	 *	       main         main     main     main     main  ===> 메모리 해제 5 => 프로그램 종료
	 *	  --------------
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		aaa();
	}

}
