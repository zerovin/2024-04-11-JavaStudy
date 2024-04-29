// 1~100사이 2의 배수의 합, 3의 배수의 합 4,5,...8,9의 배수의 합
public class 메소드_5 {
	static int display2() {
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i%2==0) {
				sum+=i;
			}
		}
		return sum;
	}
	static int display3() {
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i%3==0) {
				sum+=i;
			}
		}
		return sum;
	}
	static int display4() {
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i%4==0) {
				sum+=i;
			}
		}
		return sum;
	}
	static int display5() {
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i%5==0) {
				sum+=i;
			}
		}
		return sum;
	}
	static int display6() {
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i%6==0) {
				sum+=i;
			}
		}
		return sum;
	}
	static int display7() {
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i%7==0) {
				sum+=i;
			}
		}
		return sum;
	}
	static int display8() {
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i%8==0) {
				sum+=i;
			}
		}
		return sum;
	}
	static int display9() {
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i%9==0) {
				sum+=i;
			}
		}
		return sum;
	}
	
	static int display(int num) {
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i%num==0) {
				sum+=i;
			}
		}
		return sum;
	}
	
	//메소드 => 반복제어 => 소스를 간결하게 만들 수 있다
	//main 안의 코드 == 절차적언어 => 순차적 => 재사용X => 일회용
	//main 밖 메소드 == 다른 클래스에서 사용가능 => 재사용 => 조립식
	//게시판(CRUD - Create, Read, Update, Delete)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("========= display2~9() ===========");
		System.out.println("1~100 사이의 2의 배수의 합:"+display2());
		System.out.println("1~100 사이의 3의 배수의 합:"+display3());
		System.out.println("1~100 사이의 4의 배수의 합:"+display4());
		System.out.println("1~100 사이의 5의 배수의 합:"+display5());
		System.out.println("1~100 사이의 6의 배수의 합:"+display6());
		System.out.println("1~100 사이의 7의 배수의 합:"+display7());
		System.out.println("1~100 사이의 8의 배수의 합:"+display8());
		System.out.println("1~100 사이의 9의 배수의 합:"+display9());
		
		System.out.println("========== display() ============");
		for(int i=2;i<=9;i++) {
			System.out.println("1~100 사이의 "+i+"의 배수의 합:"+display(i));
		}
		
	}

}
