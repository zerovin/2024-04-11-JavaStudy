/*
 *	배열 => 5
 *	---------------------
 *	|   |   |   |   |   |
 *	---------------------
 *	간격이 동일 => 인덱스 => 단위가 byte 4byte-int[] / 8byte-double[]
 *
 *	1.초기값
 *	  0번부터 추가
 *	  마지막부터 추가
 * 
 * 	ex) 정수입력받아 2진법 출력
 * 	    8bit ---------
 * 	    10 => 00001010 => 뒤에서 출력
 * 
 */
import java.util.Scanner;
public class 배열활용_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("0~32767 사이의 정수 입력:");
		// bit => 16bit
		int input=scan.nextInt();
		// 0,1저장
		int[] binary=new int[16];
		int index=binary.length-1; // 0~15 뒤에서 부터 넣을꺼라 제일 큰 인덱스로
		
		System.out.println("===== API 이용 =====");
		System.out.println(Integer.toBinaryString(input)); // 100 -> 1100100 => 2진법
		System.out.println(Integer.toOctalString(input)); // 100 -> 144 => 8진법 1 100 100 => 1 4 4
		System.out.println(Integer.toHexString(input)); // 100 -> 64 => 16진법 110 0100 => 6 4
		
		System.out.println("==== API 이용 X ====");
		while(true) {
			binary[index]=input%2;
			input=input/2;
			if(input==0) break;
			index--;
		}
	
		//출력
		for(int i=0;i<binary.length;i++) {
			if(i%4==0 && i!=0) {
				System.out.print(" "); // 4개 출력후에 공백 ---- ---- ---- ----
			}
			System.out.print(binary[i]); // 100 -> 0000 0000 0110 0100
		}
		
		
			
	}

}
