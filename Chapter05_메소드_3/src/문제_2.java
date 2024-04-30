//정수를 입력 받아서 이진법을 출력하는 메소드 작성(3개의 메소드)
import java.util.Scanner;
public class 문제_2 {

	//정수 입력
	static int input() {
		Scanner scan=new Scanner(System.in);
		System.out.print("0~32767사이의 정수 입력 >> ");
		return scan.nextInt();
	}

	//이진법 처리
	static int[] binaryCheck(int num) {
		int[] binary=new int[16]; //16자리의 정수가 0으로 초기화
		int index=15; //뒤에서부터 값 저장
		while(true) { //입력된 값에 따라 반복횟수가 달라서 무한루프
			binary[index]=num%2;
			num/=2;
			if(num==0) break;
			index--;
		}
		return binary;
	}
	
	//출력
	static void print(int[] binary) { // void == return값이 없음, 바로 출력
		for(int i=0;i<binary.length;i++) {
			if(i%4==0 && i!=0) {
				System.out.print(" ");
			}
			System.out.print(binary[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//입력처리
		/*
		Scanner scan=new Scanner(System.in);
		System.out.print("0~32767사이의 정수 입력 >> ");
		*/
		int num=input();
		
		//이진법처리
		//int[] binary=new int[16]; //16자리의 정수가 0으로 초기화
		/*
		 *	new 이용 - 동적 메모리 할당(실행시에 메모리를 만들어서 배치)
		 *	  데이터형 초기화
		 *	  int => 0
		 *	  double => 0.0
		 *	  boolean => false
		 *	  char => '\0'
		 *	  String => null
		 * 
		 */
		/*
		int index=15; //뒤에서부터 값 저장
		while(true) { //입력된 값에 따라 반복횟수가 달라서 무한루프
			// 2로 나누고 나머지 값 저장
			// 2로 나누고 나머지 값 저장
			// ...
			// num = 0 이 될 때까지 반복
			binary[index]=num%2; // 뒷자리부터 나머지값 저장
			num/=2; //나눈 몫 새로 저장
			if(num==0) break;
			index--;
		}
		
		//출력
		for(int i=0;i<binary.length;i++) {
			if(i%4==0 && i!=0) {
				System.out.print(" ");
			}
			System.out.print(binary[i]);
		}
		*/
		
		int[] b=binaryCheck(num);
		print(b);
	}

}
