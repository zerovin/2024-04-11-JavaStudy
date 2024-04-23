
public class 문자열_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="ABCDEFG";
		String m=msg.substring(2,6); //원본 변경할 경우 새로운 변수에 저장하는게 안전
		System.out.println(msg.substring(2,6)); //CDEF
		System.out.println(msg); //ABCDEFG => 원본 변경X
		System.out.println(msg=msg.substring(2,6)); //CDEF
		System.out.println(msg); //CDEF 재저장하면 원본 변경됨
		
		int a=10;
		int b=20;
		String s1=String.valueOf(a); // String.valueOf() 모든 데이터형을 문자열로 변경
		String s2=String.valueOf(b); //정수->문자열로 변경
		// 윈도우, 웹 => 데이터형(정수,실수,논리)이 없음 => only 문자열 
		// 자바 => 원래상태로 복구해서 처리
		/*
		 * 	입력창
		 * 	<input type="text"> <input type="number">
		 * 	JTextField
		 * 
		 */
	}

}
