/*
 *	클래스
 *	- 사용자 정의 데이터형 : 데이터만 모아서 관리
 *	                   다른 데이터형 모아서 관리 가능
 *	- 액션 클래스 : 메소드를 여러개 모아서 관리 
 *
 *	** 클래스는 한개에 대한 정보
 *	   ex) class 사원{
 *	          이름
 *	          부서
 *	          근무지
 *	          입사일
 *	          직위
 *	          연봉
 *	          성과급
 *	          ...
 *	       }
 *	       class 학생{
 *	          이름 String
 *	          학년 int
 *	          학점 char
 *	          주소 String
 *	          전화
 *	          나이
 *	          ...
 *	       }
 */
//데이터형 => 형변환
//개발자 마자 다르게 데이터를 모음(프로그램에 맞게)
class Student{
	String name;
	int age; // static 안붙은 경우 각자 값 저장 == 인스턴스 변수(객체변수), 메모리 공간 따로 생성
	//static String school_name; // static==공유변수, 하나의 메모리 공간 공유, 변경시 모든 사람의 school_name을 같은 값으로 동시제어
	//공유변수 사용하면 제일 마지막에 입력한 값 출력
	String school_name;
}

//저장
public class 클래스_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//저장
		Student hong=new Student();
		//      └ 객체 - 사용자 정의 데이터형에 대한 변수명
		//name,age,school_name 3개 데이터 공간 생성 == 주소 세개 생성
		//주소접근 . 으로 접근 .=주소접근연산자 ex)hong.name
		
		hong.name="홍길동";
		hong.age=25;
		hong.school_name="쌍용";
		Student shim=new Student();
		shim.name="심청이";
		shim.age=20;
		shim.school_name="SIST";
		Student park=new Student();
		park.name="박문수";
		park.age=30;
		park.school_name="SIST강북";
		
		System.out.println("===== hong영역 =====");
		System.out.println("이름 "+hong.name);
		System.out.println("나이 "+hong.age);
		System.out.println("학교 "+hong.school_name); 
		System.out.println("===== shim영역 =====");
		System.out.println("이름 "+shim.name);
		System.out.println("나이 "+shim.age);
		System.out.println("학교 "+shim.school_name);
		System.out.println("===== park영역 =====");
		System.out.println("이름 "+park.name);
		System.out.println("나이 "+park.age);
		System.out.println("학교 "+park.school_name);
	}

}
