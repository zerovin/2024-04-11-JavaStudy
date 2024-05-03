/*
 *	class Sawon{ //한명의 사원에 대한 정보 모음
 *		String name;
 *		String dept;
 *	}
 *	---------------------------- 변수X, 사용자 정의 데이터형 - Sawon이라는 데이터형 선언
 *
 *	public class MainClass{
 *		Sawon s=new Sawon(); ===> 모든 메소드에서 사용가능 == 멤버변수, 전역변수
 *		static void aaa(){
 *			Sawon s=new Sawon(); ---------
 *		}                                |
 *		static void bbb(){               |        
 *			Sawon s=new Sawon(); ---------======> 메소드 안에 이는 변수는 호출 후 사라짐
 *		}                                |        이름은 같지만 각각 다른 변수
 *		static void ccc(){               |        공유해서 같이 쓰려면 리턴형, 매개변수로 연결
 *			Sawon s=new Sawon(); ---------
 *		}
 *		public static void main(String[] args) {
 *			// TODO Auto-generated method stub
 *
 *		}
 *	}
 *
 *	메소드 안에서만 사용 => 지역변수
 *	   ex) for(int i=1;i<=10;i++){} => i==지역변수
 *	전체 메소드에서 사용 => 멤버변수
 * 
 */
public class 멤버변수_활용 {
	static int b=200; //전역변수 쓰면 리턴형,매개변수없이 모든 메소드에서 사용가능
	static int aaa() {
		int a=100; //aaa() => 호출 후 사라짐
		System.out.println("aaa():a="+a);
		System.out.println("aaa():a는 사라진다");
		System.out.println("aaa():b="+b);
		// {} 블록 안에서만 사용하는 변수 => 지역변수
		return a; //다른 메소드에서 쓰려면 리턴
	}
	static int bbb(int a) { //aaa()의 변수 a를 매개변수로 가져옴
		//int a=200;
		System.out.println("bbb():a="+a);
		System.out.println("bbb():a는 사라진다");
		System.out.println("bbb():b="+b);
		return a;
	}
	static void ccc() {
		int a=300; //지역변수
		System.out.println("ccc():a="+a);
		System.out.println("ccc():a는 사라진다");
		System.out.println("ccc():b="+b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=aaa();
		int b=bbb(a);
		ccc();
	}

}
