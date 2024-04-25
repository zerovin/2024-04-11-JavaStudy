/*
 *	문자 10개 저장
 *	=> 출력 HELLO
 *	=> 반대 출력 OLLEH
 *	=> Sort => 이차 for문 
 */
public class 배열_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] alpha=new char[10];
		for(int i=0;i<alpha.length;i++) {
			alpha[i]=(char)((Math.random()*26)+65);
		}
		// 출력
		/*
		 *	for-each : 출력중심 => 웹 => 배열/컬렉션
		 * 
		 *	for(데이터형 변수:배열명) => 데이터형==변수명 일치 or 데이터형변수가 데이텨형보다 클 수도 있음
		 *		
		 *	ex)
		 *     char[]
		 *     for(char c:배열) => 기본
		 *	   for(int c:배열) => 가능
		 *	   for(double c:배열) => 가능
		 *
		 *	byte < char < int < long < double
		 *	* 가급적이면 같은 데이터형으로 받는다
		 *	* 인덱스를 이용하는 것이 아니라 실제 배열된 저장된 값을 읽어온다
		 *	* 단점 - 관련된 다른 배열의 값을 출력할 수 없다, 하나의 배열만 출력
		 *	  ex)
		 *       String[] names={"","","","",""}
		 *       String[] sexs={"","","","",""}
		 *       
		 *       이름(성별)
		 *       for(String name:names) => 배열 두개 동시제어 불가 => 일반 for문-인덱스 사용으로 해결
		 *                                 항상 0번부터 가져오는 애라 뒤에서부터 출력도 불가
		 *
		 */
		for(char c:alpha) { 
			System.out.print(c+" ");
		}
		System.out.println("\n========= 반대로 출력 ===========");
		for(int i=alpha.length-1;i>=0;i--) {
			System.out.print(alpha[i]+" ");
		}
	}

}
