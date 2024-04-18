
public class 제어문_선택문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int com=(int)(Math.random()*3); //0 1 2
		//상수도 가능
		//순서 상관X => 분석, 추가기능 => 순차적 서술
		//case값 중복 불가
		switch(com) { //정수
			case 0:
				System.out.println("가위");
				break; //break가 없으면 다음 문장도 수행
			case 1:
				System.out.println("바위");
				break;
			case 2:
				System.out.println("보");
			//default 생략 가능
		}
	}

}
