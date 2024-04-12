/*
 *	변수 : 한개의 데이터를 저장하는 메모리 공간의 이름
 *		  └필요시에 변경 가능
 *	메모리 공간 - 4byte씩 나눠진다
 *		0--------------
 *			사용중
 *		4--------------
 *			사용중
 *		8--------------
 *			 10  --------------> 별칭 a = 변수
 *		12-------------
 *
 *		16-------------
 *		.
 *		.
 *		.
 *
 *		1) 변수 명칭법
 *			1. 알파벳이나 한글로 시작 - 알파벳 사용시 대소문자 구분 ex)a/A
 *			2. 숫자 사용 가능 단,앞에 사용 불가 ex)a1,a2...
 *			3. 특수문자 _,$ 두개만 사용가능 - 보통 두단어연결시 언더바 사용 ex)file_name
 *			   └_name : 임시변수 - 언더바가 앞에 붙으면 임시변수
 *			4. 키워드, 예약어 사용 불가 - 자바에서 이미 사용중인 단어(이클립스 내에 보라색글자, 검은색은 가능)
 *			5. 공백 불가
 *			6. 변수명에 대한 제한X, 3-10글자정도 권장 ex)국어점수 = kor
 *
 *		*변수 - 다음에 다시 사용
 *		 리터럴 - 변수에 실제 저장된 값(메모리)
 *
 *		2) 변수의 형식
 *		   1.데이터형 변수명 = 값 ex)byte b1 = -128;
 *			 *기본 메모리는 4byte, int제외 다른 타입은 메모리는 쪼개거나 붙여 저장
 *			 - 정수
 *				1byte => byte - 파일읽기/업로드/다운로드/네트워크전송
 *								-128~127까지 사용가능-이상은 overflow 오류
 *								작은 수 사용으로 메모리 공간 절약 but 메모리 쪼개는 속도 생각해서 대부분 int 사용
 *				2byte => short - 사용빈도는 거의 없다 (C언어와의 호환성)
 *				4byte => int - default (컴퓨터는 무조건 숫자 = int)
 *				8byte => long - 금융권 '숫자L'로 표기
 *				------------------------------------------------
 *				컴퓨터에 저장은 0 or 1
 *				1byte = 8bit (0 or 1 8개로 저장)
 *				부호비트 1 1 1 1 1 1 1 1
 *				0 = 양수 / 1 = 음수
 *				1byte에서 제일 큰 수 = 127 = 01111111 !더 큰숫자는 오류
 *				
 *			 - 실수
 *				4byte
 *				8byte
 *			 - 문자
 *				2byte
 *			 - 논리
 *				1byte
 *			데이터를 저장해서 재사용 - 변수(한개만 저장 가능)
 *			정수 byte = 1byte (-128~127)
 *				short = 2byte (-32768~32767)
 *				int = 4byte (-21억4천~21억4천)
 *				----------------------------
 *				long = 8byte = 64bit
 *		변수 초기값 부여
 *			1.명시적 초기화 int a=100;
 *			2.난수발생 => 임의로 숫자 추출 ex)게임
 *			3.사용자로부터 값을 받아 초기화
 *			*초기값없이 사용시 오류
 *		변수 종류
 *			1.지역변수 한 스코프 내 - 반드시 초기화해서 사용 
 *				초기화(28page)
 *					1)선언과 동시에 초기값 부여 int a=10;
 *					2)선언 후, 값 대입 int a; a=10;
 *					3)여러개 동시 선언
 *						int a,b,c; a=b=c=10;
 *						int a=10, b=20, c=30; 단, 같은 데이터형끼리만 가능
 *			2.멤버변수 클래스 내 
 *			3.공유변수
 *			4.참조변수
 *
 *	30page
 *	논리형 = boolean = true/false
 *	1byte => true=1 / false=0
 *	조건을 사용할 때
 *	형식 => boolean bCheck=false;
 *
 *
 *
 *
 */		
public class 변수_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//byte b=127; //사용범위, 메모리크기 => 데이터형
		System.out.println(Short.MAX_VALUE);
		//상수 final byte b1=-128;
		byte b1=-128;
		System.out.println(b1);
		b1=100;
		System.out.println(b1);
		long a=2100000000000L;
		long b=21000L;
		//국어 영어 수학 점수 총점 계산
		int kor=90;
		int eng=80;
		int math=70;
		
		int total=0;
		//System.out.println(kor+eng+math);
		
		/*
		 *	30page
		 *	논리형 = boolean = true/false
		 *	1byte => true=1 / false=0
		 *	조건을 사용할 때 형식 => boolean bCheck=false;
		 */
		boolean bCheck=false;
		System.out.println(bCheck);
		
		/*
		 * 	문자형
		 *  char - 멀티바이트 = 2byte => UniCode
		 *  		C언어 - 싱글바이트 = 1byte => ASC
		 *  각 문자마다 변호를 부여 (ASC), ((int)'문자')뽑으면 번호로 출력
		 * 	  0~65535
		 *    0~255
		 *    A = 65, B = 66 ...
		 *    a = 97, b = 98 ...
		 *    '0' = 48
		 *  표현방식 - 문자1개
		 */
		char hakjum='B';
		System.out.println(hakjum);
		
		char fname='홍';
		System.out.println(fname);
		
		char num='0';
		System.out.println((int)num); //48
	}

}
