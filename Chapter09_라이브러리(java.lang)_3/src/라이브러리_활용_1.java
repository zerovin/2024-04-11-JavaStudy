//Object - 객체와 관련된 메소드를 가지고 있다
//생성, 소멸, 객체 비교, 객체 복제 => 새롭게 생성
//Object는 모든 객체의 기능을 가지고 있다 => 모든 클래스에 상속을 내려서 사용
/*
 *  소멸자 - finalize()
 *  복제 - clone() 
 *  toString() 거의 모든 프로그램에 오버라이딩 => 상속받아 기능변경
 *  ===> 라이브러리는 오버라이딩
 *  모든 클래스는 extends Object
 *  모든 데이터형, 클래스는 Object로 묶어 사용가능 => 형변환
 *  상속을 내리면 상속 내린 클래스는 상속 받은 클래스의 추가적인 변수/메소드 접근 불가능
 */
class Sawon /*extends Object*/{ 
	int sabun;
	String name;
	public Sawon(int sabun, String name) {
		this.sabun=sabun;
		this.name=name;
	}
	public void print() {
		System.out.println("사번:"+sabun+", 이름:"+name);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "사번:"+sabun+", 이름:"+name;
	}
	
	/*
	 *  clone()
	 *  toString()
	 *  finalize()
	 *  equals()
	 *  hashCode() 
	 */
}
class Member{
	int mno;
	String name;
	public Member(int mno, String name) {
		this.mno=mno;
		this.name=name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "회원번호:"+mno+", 이름:"+name;
	}
}
// 상위클래스로 객체 생성시에 접근 => 상위클래스에서 받은 메소드 재정의, 오버라이딩으로 접근
// 여러개의 클래스를 묶어서 제어할 때 상위클래스로 객체 생성
// 라이브러리 리턴형 == Object
// Object => 클래스는 어떤 것이든 만들어서 사용

public class 라이브러리_활용_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Object obj=new Sawon(); // 데이터형이 Object이기 때문에 Sawon class에서 추가된 변수, 메소드 접근불가
		Sawon s=(Sawon)obj; //Object -> Sawon으로 형변환해서 사용
		
		s.sabun=1;
		s.name="홍길동";
		s.print();
		*/
		
		//Object는 여러개의 클래스를 한개의 메모리 공간에서 제어시 주로사용
		Object obj=new Sawon(1, "홍길동");
		//Object 클래스가 가지고 있는 변수, 메소드 사용가능
		//상위클래스로 객체 생성시 접근 못하는 부분이 생길 수 있다
		//접근 못하는 부분에 접근할 수 있게 Object 클래스 안의 메소드를 오버라이딩해서 사용
		System.out.println(obj.toString());
		
		obj=new Member(2, "심청이");
		System.out.println(obj); //toString() 자동호출
	}

}
