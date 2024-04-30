
public class 문제_2_재사용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=문제_2.input();
		
		// num=>이진법 제작 메소드로 전송
		int[] binary=문제_2.binaryCheck(num);
		
		// binary[]를 넘겨준다 => 출력요청
		문제_2.print(binary);
	}

}
