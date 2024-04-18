
public class 제어문_반복문_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.A~Z까지 출력
		for(char c='A';c<='Z';c++) {
			System.out.print(c+" ");
		}
		System.out.println(); //줄바꿈
		for(char c='a';c<='z';c++) {
			System.out.print(c+" ");
		}
		//정수/문자 가능
		System.out.println();
		for(char c='Z';c>='A';c--) {
			System.out.print(c+" ");
		}
		
	}

}
