/*
 *	자바 - 오라클 - HTML/CSS/JavaScript 
 * 
 *	JSP - MVC(1차-Ajax,JQuery) - Spring(2차-Vue3) - Python(데이터분석-Numpy,Pandas,MatplotLib) - Django(파이썬,웹)
 *	
 *	Spring-Boot(개인-React,Redux,React-Query,NextJS) - AWS(리눅스명령어->Hosting)
 *	=> MSA(Spring-Cloud)**
 *
 *	자바 - 변수/연산자/제어문/메소드
 *	      메소드 여러개 == 클래스 => 재사용
 *	    - 메소드 - 매개변수 : 사용자로부터 받는 값
 *	           - 결과값 : 어떤 데이터를 넘겨 줄건지
 *	           - 메소드명
 *	           - 구현 : 결과값을 도출
 *	           - 어느 위치에서 호출
 *        ex)
 *        	 1) 사용자 로그인 요청
 *              매개변수 - id, password
 *              리턴형 - boolean
 *           2) 아이디 중복 체크
 *              매개변수 - id
 *              리턴형 - boolean
 *           3) 우편번호 검색
 *              매개변수 - dong
 *              리턴형 - String[]
 *           4) 맛집 검색
 *              매개변수 - 검색어(String)
 *              리턴형 - String[]
 *           5) 노래 검색
 *              매개변수 - 검색어(String)
 *              리턴형 - String[]
 *           ==> 결과값을 브라우저에 출력(웹)
 *        형식)
 *           어떤 값을 받아서 어떤 값을 보내줄지
 *           리턴형 메소드명(매개변수...){
 *           	구현...(요청 처리)
 *           	return 결과값
 *           }
 *           **리턴형의 데이터형 == 결과값 데이터형 동일
 *           데이터형 변수=메소드명()  => 호출
 *           **리턴형에 설정한 데이터형 == 호출시 데이터형 동일
 *        기능분리)
 *           입력 부분
 *           처리 부분
 *           출력 부분
 *           ==> 모든 자바는 3가지 형태로 나눠서 처리
 *        리턴형)
 *           한가지 데이터형(기본형) - 정수형/실수형/논리형/문자형
 *                               ex) int 메소드명()/double 메소드명()/boolean 메소드명()/char 메소드명()
 *           여러개 데이터(배열)) - ex) int[] 메소드명()/double 메소드명()
 *        매개변수)
 *           메소드 종료시 사라짐 - 지역변수와 동일
 *           여러개 사용가능
 *           ex) 5개의 정수를 보내서 정렬하는 프로그램
 *               메소드명(int a, int b, int c, int d, int e) => 3개이상 초과시 => 배열
 *               메소드명(int[] arr)
 *        메소드가 호출되면 항상 메소드 처음부터 실행
 *        지역변수 == 메소드 안에 선언되는 변수 - 메소드가 종료되면 사라짐(매개변수와 동일) => 반드시 초기화
 */

// 배열, 5개의 정수를 임의로 추출 => 최대값/최소값
public class 메소드_4 {
	// 1. 정수 추출 => 입력
	static int[] input() { // 정수여러개 int[]
		// 1. 배열 선언
		int[] arr=new int[5];
		
		// 2. 배열에 임의 추출된 값 저장
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
		return arr; // 배열은 배열명만 전송 => 배열명(메모리 주소)
	}
	
	// 2. 최대값 => 처리    ========== 값이 하나만 넘어가야해서 최대/최소 따로 메소드 생성
	static int max(int[] arr) {
		int max=arr[0];
		for(int i:arr) {
			if(max<i) {
				max=i;
			}
		}
		return max;
	}
	// 3. 최소값 => 처리
	static int min(int[] arr) {
		int min=arr[0];
		for(int i:arr) {
			if(min>i) {
				min=i;
			}
		}
		return min;
	}
	
	// 4. 출력
	static void process() {
		// 1. 정수 5개 받기
		int[] arr=input();
		int max=max(arr);
		int min=min(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println("\n최대값:"+max);
		System.out.println("최소값:"+min);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		// 1. 배열 선언
		int[] arr=new int[5];
		
		// 2. 배열에 임의 추출된 값 저장
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
		
		// 3. 최대값 / 최소값
		int max=arr[0];
		int min=arr[0];
		
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i]) {
				max=arr[i];
			}
			if(min>arr[i]) {
				min=arr[i];
			}
		}
		
		// 전체 정수 출력
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println(); // 줄바꿈
		
		// 최대값 / 최소값 출력
		System.out.println("최대값:"+max);
		System.out.println("최소값:"+min);
		*/
		process();
	}

}
