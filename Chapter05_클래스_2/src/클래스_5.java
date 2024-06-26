/*
 *	클래스의 구조 => 프로그램에 맞게 데이터/메소드 관리를 위한 설계
 *	       활용 => 메모리에 저장 후 사용
 *	       저장 => new 생성자()
 *	       객체 => 저장시(new 생성자()에서) 받은 주소 이용
 * 	class ClassName{
 * 	   변수(멤버변수) - 클래스가 가지고 있는 변수
 * 	   초기화 - 초기화블록, 생성자
 * 	   메소드
 * 	   --------기본순서
 * 	}
 *  **순서는 상관없음
 *  **변수(어떤 데이터 활용할지)
 *    기능설정(메소드) 데이터 활용
 *    초기화결정
 *    기타변수 = 지역변수로 활용
 *    
 *  ※클래스의 구성요소
 *  멤버변수 - new를 사용하여 저장가능
 * 	         클래스 전체 / 다른 클래스에서 사용가능
 * 	         일반 변수와 동일
 * 	         => 클래스는 한개에 대한 정의 ex)영화1개, 레시피1개 => form 하나에 데이터여러개 저장
 * 	         **공통으로 사용되는 변수는 static 이용
 *	생성자 - 클래스명과 동일 / 리턴형이 없다
 *         메모리 할당시 호출되는 메소드
 *         멤버변수의 초기화 - 서버구동/화면UI/데이터베이스 연동
 *         반드시 필요, 경우에 따라서 생략가능 => 컴파일러가 자동으로 생성자 추가
 *	메소드 - 멤버변수가 가지고 있는 데이터를 활용할 수 있게 기능을 추가
 *	***다른 클래스에서 사용가능
 *	   메소드 => 다른 클래스와 통신(연결)
 *	           기능 변경 - 오버라이딩
 *             기능 추가 - 오버로딩
 *	***객체 지향 프로그램 OOP
 *	   객체 지향의 3대 특성 == OOP 특징 6,7장
 *	   1) 캡슐화 - 데이터 보호 목적 => 파밍 => 크롤링(해킹) => Vue/React/Ajax 사용해서 만든 사이트는 크롤링불가
 *	   2) 재사용 - 상속(변경해서 사용), 포함(있는 그대로 사용)
 *	   3) 다형성 - 오버라이딩 / 오버로딩(생성자)-같은 이름의 메소드를 여러개 만들어서 사용
 * 
 * 	   자바 => 데이터 영구적 저장(오라클) => 화면 UI(HTML/CSS) => 연결(JDBC/JSP)
 * 	   ----------------------------------------------------------------통합(Spring)
 *	***프로그램의 비정상 종료 방지 - 예외처리 8장 => 자바 기본문법
 */
class Movie{
	int rank;
	String title;
	String reserve;
	String regdate;
}
public class 클래스_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movie m1=new Movie();
		System.out.println("m1 = "+m1); //m1 = Movie@1eb44e46
		m1.rank=1;
		m1.title="범죄도시4";
		m1.reserve="27.4%";
		m1.regdate="2024.04.24";
		/*
		 * 	      m1         Movie@1eb44e46
		 *  --------------	---------------
		 *  Movie@1eb44e46    -----------
		 *  --------------         1      ===> rank => m1.rank
		 *  	              -----------
		 *                      범죄도시4   ===> title => m1.title
		 *                    -----------
		 *                       27.4%    ===> reserve => m1.reserve
		 *                    -----------
		 *                    2024.04.24  ===> regdate => m1.regdate
		 *                    -----------
		 *                  ---------------
		 *  	             
		 *  
		 */
		
		Movie m2=new Movie();
		System.out.println("m2 = "+m2); //m2 = Movie@e73f9ac
		m2.rank=2;
		m2.title="혹성탈출-새로운 시대";
		m2.reserve="24.2%";
		m2.regdate="2024.05.08";
		
		Movie m3=new Movie();
		System.out.println("m3 = "+m3); //m3 = Movie@61064425 new사용시마다 각각의 메모리 생성=주소반환
		m3.rank=3;
		m3.title="악마와의 토크쇼";
		m3.reserve="15.2%";
		m3.regdate="2024.05.08";
	}

}
