// split
public class 문자열배열_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String color="red,blue,black,yellow,white,pink,magenta";
		String[] colors=color.split(",");
		for(String c:colors) {
			System.out.print(c+" ");
		}
		System.out.println();
		String name="홍길동|심청이|춘향이|박문수|이순신|강감찬";
		String[] names=name.split("\\|"); // regex 정규식에서 |가 구분자, |사용시 \\|로 사용
		for(String n:names) {
			System.out.print(n+" "); // 한 글자씩 가져옴
		}
		/*
		 *	regex 정규식에서 사용하는 기호
		 *	? => 둘 중에 한개 
		 *	| => 여러개 중에 한개 선택 A|B|C
		 *	. => 임의의 1글자
		 *	+ => 한개이상의 문자가 있는 경우
		 *	* => 0개이상의 문자
		 *	^ => 시작
		 *	$ => 끝
		 *	==========> 자체 문자를 사용할 때는 반드시 앞에 \\ 붙여 사용
		 * 
		 */
	}

}
