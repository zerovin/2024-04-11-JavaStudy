
public class 문자열_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String alpha="ABCDEFGHIJ";
		//            0123456789
		// 1. CDEFGHIJ
		System.out.println(alpha.substring(2));
		
		// 2. EFG
		System.out.println(alpha.substring(4, 7));
		
		String id=" admin ";
		System.out.println(id+"의 문자 갯수:"+id.length()); // 공백도 문자 길이에 포함 7
		// 공백=문자=space문자
		id=id.trim(); // 앞뒤 공백 제거, 중간 띄어쓰기는 제거X ex)로그인, 검색, 입력
		System.out.println(id+"의 문자 갯수:"+id.length()); // 앞뒤 공백 없어져서 5
		
		String msg="Hello Java";
		//          0123456789
		System.out.println(msg.indexOf("a")); // 앞에서 먼저 나오는 애 출력 7
		System.out.println(msg.lastIndexOf("a")); // 뒤에서 먼저 나오는 애 출력 9, ex)경로명
		
		String ext="Hello.java";
		System.out.println(ext.substring(ext.lastIndexOf(".")+1));
		//java 업로드, 다운로드시 확장자별로 아이콘 출력위해 사용 => 확장자 출력
		//확장자 출력시에는 파일명에 .이 있을수 있기 때문에 lastIndexOf(".") 사용
		
		/*
		 *	데이터형
		 *		정수 - 정수만 저장 = int/long/byte
		 *		                 Integer/Long/Byte
		 *		실수 - 실수만 저장 = double
		 *		문자 - 문자 1개 저장 = char
		 *		논리 - true/false = boolean
		 *		                   Boolean
		 *		문자열 - 문자 여러개를 동시에 저장 = String => 문자열 제어기능이 있다
		 * 
		 */	
		// int a=(int)"100"; 오류코드
		int a=Integer.parseInt("100");
	}

}
