import java.util.*;
class Sawon1{
	
}
public class 라이브러리_활용_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		//list=new ArrayList<String>(); //=> 제네릭스<>
		//ArrayList<String> list=new ArrayList<String>(); //리턴형 Object -> String
		//ArrayList<Sawon1> list=new ArrayList<Sawon1>(); //리턴형 Object -> Sawon1
		//변수=데이터 => 변수가 데이터와 같거나 커야한다, 작은 경우 형변환
		
		//배열의 단점을 보완 => 가변형, 개수지정X
		list.add("홍길동"); // 인덱스0
		list.add("심청이"); // 인덱스1
		list.add(100); // 인덱스2
		list.add(10.5); // 인덱스3
		list.add(true); // 인덱스4
		
		//String name=list.get(0); //list.get(0) ==> Object리턴 String에 Object를 담으려니 오류 => 형변환
		//String name=list.get(0).toString();
		String name=(String)list.get(0);
		double d=(Double)list.get(3); //언박싱
		boolean b=(Boolean)list.get(4); 
		
	}

}
