/*
 *	while 선조건 => 한번도 수행을 못할 수도 있다
 *	do~while 후조건 75page => 무조건 한번은 수행
 *
 *	초기값
 *	while(조건식){
 *		반복수행문장
 *		증감식
 *	}
 *
 *	int i=10;
 *	while(i<=5){ => 시작과 동시에 false => 종료
 *
 *	}
 *	=====> 수행X
 *
 *	int i=10; --------1
 *	do{
 *		반복 실행문장 ----2
 *		증감식 ---------3
 *	}while(i<=5); ----4 후조건 나중에 조건검색 => 한번이상 반드시 수행
 *
 *	while을 보완하기 위해 do~while 등장 => C/C++에서 많이 사용
 *	자바에서는 사용빈도가 거의 없다
 *
 */
public class 자바제어문_반복문_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1;
		System.out.println("===== for =====");
		for(i=1;i<=10;i++) {
			System.out.print(i+" ");
		}
		//i=11
		System.out.println("\n===== while =====");
		//i=1;
		while(i<=10) { //초기값 리셋 안시키면 i=11이라 false => 실행X
			System.out.print(i+" ");
			i++;
		}
		//i=11
		System.out.println("\n===== do~while =====");
		//i=1;
		do {
			System.out.print(i+" "); //11
			i++;
		}while(i<=10); //i=11이라 조건충족 안되지면 후조건이라 한번은 실행 
	}

}
