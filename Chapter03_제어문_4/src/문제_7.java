//1부터 30까지의 정수에서 짝수만 한 줄에 3개씩 출력하라
public class 문제_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=30;i++) {
			if(i%2==0) {
				System.out.printf("%02d ",i); // %2d 두자리 차지 오른쪽 정렬, %02d 두자리차지 오른쪽정렬 빈자리 0
				if(i%3==0)
					System.out.println();
			}
		}
	}

}
