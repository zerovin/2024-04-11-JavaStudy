//알파벳 10개 난수 => 버블정렬 DESC

import java.util.Arrays;

public class 중첩_for_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] alpha=new char[10];
		
		//가독성 => 최적화 / 실무용보다 얘가 더 나은 코드
		for(int i=0;i<alpha.length;i++) {
			alpha[i]=(char)((Math.random()*26)+65);
			for(int j=0;j<i;j++) {
				if(alpha[i]==alpha[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println("원본  - "+Arrays.toString(alpha));
		for(int i=0;i<alpha.length-1;i++) {
			for(int j=0;j<alpha.length-1-i;j++) {
				if(alpha[j]>alpha[j+1]) {
					char temp=alpha[j+1];
					alpha[j+1]=alpha[j];
					alpha[j]=temp;
				}
			}
		}
		System.out.println("ASC  - "+Arrays.toString(alpha));
		
		for(int i=0;i<alpha.length-1;i++) {
			for(int j=0;j<alpha.length-1-i;j++) {
				if(alpha[j]<alpha[j+1]) {
					char temp=alpha[j+1];
					alpha[j+1]=alpha[j];
					alpha[j]=temp;		
				}
			}
		}
		System.out.println("DESC - "+Arrays.toString(alpha));
	}

}
