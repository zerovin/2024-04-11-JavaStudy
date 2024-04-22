/*
 *	70page
 *
 *	while
 *	- for문과 동일한 반복문
 *	- 반복 횟수가 명확하지 않는 경우 - while
 *	- 몇회 반복해서 원하는 값을 얻는 경우 - for
 *	- 파일 읽기, 데이터베이스 읽기**, 네트워크 서버 => Back-End => while
 *	- 화면출력, 페이지 나누기 => Front-End => for
 *	- 형식)
 *		초기값;
 *		while(조건식){
 *			반복 수행문장
 *			증감식
 *		}
 *	- 순서)
 *		초기값; --------------1
 *		while(조건식){ -------2
 *			반복 수행문장 ------3
 *			증감식 -----------4 => 2번으로 이동
 *		}
 *		=> 1-2-3-4-2-3-4-2-3-4-2 ===> 2가 false일 때 종료
 *
 *	**while문은 무한루프시에 주로 사용 while(true) == for(;;), while 더 많이 사용
 *
 *	ex) 1~10 출력
 *		
 *		//for
 *		for(int i=1;i<=10;i++){
 *			System.out.print(i+" ");
 *		}
 *		
 *		//while
 *		int i=1;
 *		while(i<=10){
 *			System.out.print(i+" ");
 *			i++;
 *		}
 *
 */
/*
 *	자바가 어렵다면
 *	=> 얘네중에 하나는 마스터 해야
 *	오라클 SQ
 *	HTML/CSS/JavaScript
 *	JSP => 1차 ERD, FlowChart => 설계, 아이템 기획
 *	Spring => 2차
 *	Spring-Boot => 3차
 *	Python => 3차
 *	React => 3차
 */
public class 자바제어문_반복문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1~10 출력
		
		//for
		System.out.println("===== for문 =====");
		for(int i=1;i<=10;i++) {
			System.out.print(i+" "); // 1 2 3 4 5 6 7 8 9 10
		}
		
		//while
		System.out.println("\n===== while문 =====");
		int i=1;
		while(i<=10) {
			System.out.print(i+" "); // 1 2 3 4 5 6 7 8 9 10
			i++;
		}
	}

}
