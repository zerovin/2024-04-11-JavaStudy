/*
 *	돈 5600원
 *		지출 - 점심 3000원
 *			  커피 1500원
 *			  심심풀이 250원 
 * 
 */
public class 변수_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 5600;
		int lunch = 3000;
		int coffee = 1500;
		int etc = 250;
		System.out.println(total-lunch-coffee-etc+"원");
		
		int out = lunch+coffee+etc;
		System.out.println(total-out+"원");
	}

}
