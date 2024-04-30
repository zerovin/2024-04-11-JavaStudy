// 연도를 입력 받아서 윤년 여부 확인 프로그램 작성
/*
 * 	ex)
 *	연도입력:
 *	윤년입니다 
 */
public class 메소드_재사용_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year=메소드_7.input("년도"); //클래스 이름변경시 클래스->우클릭->Refactor->Rename 으로바꿔야 재사용으로 불러온 클래스명도 바뀜
		boolean bCheck=메소드_7.isYear(year);
		if(bCheck) {
			System.out.println("윤년입니다");
		}else {
			System.out.println("윤년이 아닙니다");
		}
	}

}
