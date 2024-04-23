//자몽:grapefruit

public class 문자열_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String f="자몽:grapefruit";
		System.out.println("자몽의 영어는?");
		System.out.println("영어는 "+f.substring(f.indexOf(":")+1));
		/* 
		 * substring 문자열을 자르는 경우에 사용
		 * 
		 * substring(int startIndex) startIndex~끝
		 * substring(int startIndex, int endIndex) startIndex~endIndex-1
		 * 
		 * ex)
		 * 	Hello Java
		 * 	0123456789
		 * 	substring(6) => Java
		 * 	substring(3, 8) => lo Ja
		 * 
		 */
		String msg="Hello Java";
		System.out.println(msg.substring(3, 8)); // lo Ja
		System.out.println(msg.substring(0, 7)+"...");
	}

}
