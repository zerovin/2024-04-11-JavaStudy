// 100점 만점으로 성적을 입력 받아
// 90~100이면 A,80~89이면 B,70~79이면 C, 60~69이면 D, 60점 이하면 F를 출력하라 (switch~case 사용)

/*
 *	switch~case : 선택문
 *	if문의 조건문과 다르게 case 사용 - 정수,문자,문자열
 *	=> 값 한개 지정
 *	=> 값 입력
 *	=> switch에서 값 받
 *	=> case 처음부터 검색
 *	=> 해당 문자,정수를 찾아서 문장 수행
 *	=> case 찾아서 처리
 *	=> break가 없는 경우 break가 존재하는 곳까지 문장 수행
 *		ex) int a=2;
 *  		switch(a){
 *  			case 1:
 *  				문장1
 *  			case 2:   ===> 시작
 *  				문장2  ===> 수행 종료X
 *  			case 3:	  ===> 시작
 *  				문장3  ===> 수행
 *  				break; ===> 종료 
 *  			case 4:
 *  				문장4
 *  		}
 *  		=>case2,3 수행
 *  		** 찾은 case부터 break가 있는 case까지 수행
 *  		** 해당 case에 없는 경우에는 default(생략가능) => case마다 break;
 *  		** break는 switch~case를 종료
 *  
 *  		** 보통 프로그램에서는 if를 많이 사용한다
 *  		   경우의 수가 많은 경우에는 switch를 주로 이용 (게임, 메뉴)
 *  			=>switch가 if보다 간결
 *  			=>네트워크
 *  		** if => 범위가 있는 경우
 *  			if(score>=90 && score<=100)
 *  		** switch => 값이 1개씩 여러개인 경우
 *  			switch(score){
 *  				case 100: case 99: case:98 ... case 90:
 *  			}
 *  switch(정수,문자,문자열){}
 */				

import java.util.Scanner;
public class 문제_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int num=0;
		while(true) {
			System.out.print("점수 입력(0~100):");
			num=scan.nextInt();
			if(num<0 || num>100) {
				System.out.println("다시 입력하세요");
				continue;
			}
			break;
		} // 유효성 검사
		
		switch(num/10) {
			case 10:
			case 9:
				System.out.println("A학점");
				break;
			case 8:
				System.out.println("B학점");
				break;
			case 7:
				System.out.println("C학점");
				break;
			case 6:
				System.out.println("D학점");
				break;
			default:
				System.out.println("F학점");
		}
	}

}
