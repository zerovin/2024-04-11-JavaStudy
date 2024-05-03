/*
 *	class ClassName{
 *	   
 *	   int display(){
 *	      변수 선언 == 지역변수
 *	      => 메소드 종료시 삭제
 *	      => 종료시에도 사용하려면 리턴형 return
 *	      int a=100;
 *	      return a;
 *	   }
 *	   void print(int a){ //다른 메소드 값 받으려면 매개변수
 *	      
 *	   }
 *	   ==> 변수, 메소드가 많아지면 리턴형, 매개변수 지옥
 *	       => 멤버변수 사용, 리턴형->void, 매개변수X
 *	} 
 */
import java.util.*;
class Sawon{
	String name;
	String dept;
	String loc;
	String job;
	int pay;
}
public class 멤버변수_초기화_활용 {
	// 사원등록
	static Sawon s=new Sawon();
	static void sawonInsert() { // 목록 출력을 위해서 Sawon return
		//Sawon s=new Sawon(); //지역변수
		s.name="홍길동";
		s.dept="개발부";
		s.loc="서울";
		s.job="대리";
		s.pay=3600;
	}
	// 사원목록
	static void sawonList() {
		System.out.println("이름:"+s.name);
	}
	// 사원상세보기
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sawonInsert();
		sawonList();
	}

}
