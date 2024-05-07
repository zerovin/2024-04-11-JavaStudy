/*
 *	변수 => 초기화 - 프로그램에 필요한 데이터 값을 저장
 *	- 필요한 값 지정
 *	- 파일 읽기        
 *	- 웹 읽기(크롤링)   
 *	- 메소드 이용      
 *	- 입력값 받아서 처리
 *	=== 파일 읽기 ~ 입력값 => 선언이 아니라 구현 => 클래스{} 안에서는 사용 불가 => 초기화블록/생성자
 *  클래스{} 안에 선언과 동시에 값 지정은 가능
 *     class ClassName{
 *        int a=100;
 *     }
 *	클래스{} 안에 선언 후 나중에 값 대입은 불가 => 구현
 *	   class ClassName{
 *	      int a;
 *	      a=100; ==> 얘는 구현이라 오류 {}초기화블럭 생성 후 안에서 구현
 *	   }
 *	모든 클래스에는 생성자가 반드시 1개 이상 존재한다
 *	생성자가 없는 경우에 컴파일시 자동으로 1개 추가
 *
 * 	*** 자바 프로그램에서 자동으로 추가되는 내용
 * 	    1. import java.lang.*; => String, Math, System 많이 사용해서 자동추가 됨
 * 	    2. extends Object => 모든 클래스는 Object 상속
 * 	    3. 메소드 void일 경우 return 자동 추가 => void 메소드 작성시 return 생략 가능
 * 	    4. 생성자가 없는 모든 클래스 => 생성자 자동 추가
 * 
 */
class Student{
	//변수
	String name="홍길동";
	int hakbun=1;
	String school_name="SIST";
	String subject="컴퓨터";
	int year=2;
	//명시적 초기화 => 객체 생성시에 모든 데이터 값이 동일
	/*
	 *	자동 초기화
	 *	int 0
	 *	double 0.0
	 *	String null
	 *	boolean false 
	 */
	//초기화
	//메소드
}
public class 클래스_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 학생 생성
		// hong 메모리 주소 => name,subject,school_name,year,hakbun => .이용해서 접근
		Student hong=new Student();
		//               ----------생성자 => 리턴형X, 클래스명과 동일
		/*
		 * 생성자 - 외부에서 데이터 읽어 변수에 대입시 사용
		 *	      사용자로 부터 입력값을 받아서 초기화
		 *        시작과 동시에 연결 => 서버구동, 화면UI, 데이터베이스 연동
		 *        생략가능 => 컴파일러가 자동으로 생성자 1개 추가 public Student(){}
		 */  
		System.out.println("이름:"+hong.name); //홍길동
		System.out.println("학년:"+hong.year); //2
		System.out.println("학과:"+hong.subject); //컴퓨터
		
		// 2. 학생 생성
		// shim 메모리 주소 => name,subject,school_name,year,hakbun => .이용해서 접근
		Student shim=new Student();
		System.out.println("이름:"+shim.name); //홍길동 명시적 초기화를 해서 데이터값이 다 같아짐
		System.out.println("학년:"+shim.year); //2
		System.out.println("학과:"+shim.subject); //컴퓨터
		//변경
		shim.name="심청이";
		shim.year=3;
		shim.subject="자바";
		System.out.println("이름:"+shim.name); //심청이 각각의 데이터값을 입력하면 변경
		System.out.println("학년:"+shim.year); //3
		System.out.println("학과:"+shim.subject); //자바
		
		// 3. 학생 생성 박문수 1학년 파이썬
		Student park=new Student();
		park.name="박문수";
		park.year=1;
		park.subject="파이썬";
		System.out.println("이름:"+park.name); //박문수 각각의 데이터값을 입력하면 변경
		System.out.println("학년:"+park.year); //1
		System.out.println("학과:"+park.subject); //파이썬
	}

}
