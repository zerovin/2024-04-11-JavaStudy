import java.util.Arrays;

public class 실무_중복없는난수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lotto=new int[6];
		int su=0; //난수를 받는 변수
		boolean bCheck=false; //중복여부 확인 => 중복이면 true / 아니면 false
		for(int i=0;i<lotto.length;i++) {
			bCheck=true;
			while(bCheck) { //중복-다시수행 / 중복아닐시-종료 => lotto저장
				//난수
				su=(int)(Math.random()*45)+1;
				bCheck=false;
				
				//중복되는 숫자가 저장되었는지 비교
				for(int j=0;j<i;j++) {
					if(lotto[j]==su) {
						bCheck=true;
						break;
					}
				}
			}
			lotto[i]=su;
		}
		System.out.println(Arrays.toString(lotto));
		
	}

}
