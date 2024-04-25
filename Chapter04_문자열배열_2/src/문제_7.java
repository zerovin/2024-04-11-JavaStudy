/*
 *	7. 임의의 문자 5개를 저장하고 정렬해서 출력하시오 
       A C D H J
     A C D H J
     J H D C A
 */

import java.util.Arrays;

public class 문제_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] alpha=new char[5];
		System.out.println("====== 변경전 ======");
		for(int i=0;i<alpha.length;i++) {
			alpha[i]=(char)((Math.random()*26)+65);
			System.out.print(alpha[i]+" ");
		}
		System.out.println("\n===== 오름차순 =====");
		Arrays.sort(alpha); // 오름차순 정렬
		for(char a:alpha) {
			System.out.print(a+" ");
		}

		//System.out.println("\n"+Arrays.toString(alpha));
		
		System.out.println("\n===== 내림차순 =====");
		for(int i=alpha.length-1;i>=0;i--) { 
			System.out.print(alpha[i]+" "); // 내림차순 출력
		}
		
		// 선택정렬 / 버블정렬 => 이차for문
	}

}
