
public class 메소드_재사용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year=2024;
		int month=4;
		int day=30;
		메소드_3.print(year,month,day);
		// 메소드_3 main안에 있었으면 사용불가
		// main 밖에서 메소드 만들어야 다른 클래스에서 재사용 가능
	}

}
