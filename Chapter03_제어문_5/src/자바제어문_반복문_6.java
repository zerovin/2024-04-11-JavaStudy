/*
 *	사용자로부터 2~9사이의 정수를 입력받아서 구구단 출력
 *	단, 입력이 2~9가 아닐 시 다시 입력 요청	 
 */
import java.util.Scanner;
public class 자바제어문_반복문_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int num; //블록변수 {}를 벗어나면 자동삭제
		
		//사용자로부터 데이터를 받을시 오류체크
		for(;;) { //무한루프 정확히 입력할 때 까지
			System.out.print("정수입력(2~9) >> ");
			num=scan.nextInt();
			if(num<2 || num>9) {
				System.out.println("잘못된 입력입니다"); //for 처음으로 이동
				continue;
			}
			break; //for문 종료
		}
		System.out.println("===== "+num+"단 =====");
		for(int i=1;i<=9;i++) {
			//System.out.println(num+"*"+i+"="+num*i);
			System.out.printf("%d*%d=%d\n",num,i,num*i);
		}
		/*
		 *	for(int i=0;i<10;i++){
		 *		int j=10;
		 *	} // i, j는 for문{} 안에서만 사용 가능
		 */
	}

}
