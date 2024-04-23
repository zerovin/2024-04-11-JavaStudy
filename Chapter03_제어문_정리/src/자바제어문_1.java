/*
 *	1.변수 => 여러개 = 배열,클래스
 *		-데이터 한개만 저장하는 메모리 공간
 *		-식별자 - 변수명 설정 (대소문자구분...)
 *		-약속사항 - 리팩토링 
 *			1. 클래스,인터페이스명 - 대문자로 시작  ex)class Main => Main main=new Main();
 *				웹에서는 한글이 깨짐 => 알파벳 사용
 *				두개의 단어를 이용할 경우(대문자, _) ex)MainClass, File_name
 *			2. 변수, 메소드명 - 소문자로 시작
 *			3. 상수 - 모든 알파벳이 대문자
 *			4. 들여쓰기
 *		-데이터형(정수,실수,문자,논리)
 *			정수 - int(4byte), long(8byte), byte(1byte) => 저장크기
 *			실수 - double(8byte) => 소수점 15자리
 *			문자 - char(2byte) => 양수 0~65535
 *					=> String(문자열저장)-웹에서 가장 많이 사용
 *						브라우저->자바 값 전송시 무조건 문자열 = 1
 *			논리 - true/false
 *	2.연산자
 *		-요청처리 => 변수 가공
 *		-단항연산자
 *			증감연산자(++,--)
 *			형변환연산자(type)
 *			부정연산자(!)
 *		-이항연산자
 *			산술연산자(=,+,-,*,/)
 *			비교연산자(==,!=,<,>,<=,>=)
 *			논리연산자(&&,||)
 *			대입연산자(=,+=,-=,*=,/=)
 *		-삼항연산자
 *			(조건)?값1:값2 => if~else (웹, 게임 - 소스 줄일 경우)
 *	3.제어문
 *		-프로그램 자체 제어
 *			필요한 내용만 출력(건너뜀) => 조건문
 *			소스가 반복적일 경우 => 반복문
 *			반복문제어 => 반복문 종료, 제외 => 반복제어문
 *		-조건문
 *			단일조건문 - 조건이 맞는 경우에만 출력
 *				if(조건문){ => true/false => 부정연산자,비교연산자,논리연산자
 *					true => 문장수행
 *				} false => 건너뜀
 *				**여러개 사용시 독립적으로 사용 => 모든 조건을 검색
 *			선택조건문 - true일 경우/false경우 나눠서 처리 => 웹,윈도우에서 가장 많이 사용
 *						예)로그인O -> main / 로그인X -> 로그인요청 or 회원가입
 *				if(isLogin()){
 *					main.jsp 이동 => true일 때 처리
 *				}else{
 *					login.jsp 이동 => false일 때 처리
 *				}
 *			다중조건문 - 해당 조건에 맞는 문장만 1개 수행
 *				if(조건){
 *					true => 수행 => 종료
 *				}else if(조건){ false => 새 조건 검색
 *					true => 수행 => 종료
 *				}else if(조건){ false => 새 조건 검색
 *					true => 수행 => 종료
 *				}else{
 *					true인 조건이 없는 경우 처리 => 필요없는 경우 생략가능
 *				}
 *			선택문 - 다중조건문을 간결하게 만든 제어문
 *				switch~case ex)게임-key입력값, 웹-범위지정(예약,체크,금액...)
 *				switch(정수,문자,문자열){ => int,long,char,StringO/실수X
 *					case Enter:
 *						처리문장
 *						break;
 *					case Space:
 *						처리문장
 *						break;
 *					default:
 *						case에 없는 경우
 * 				}
 *				ex)메뉴=>1개선택=>윈도우창=>네트워크
 *		-반복문 - for / while / do~while
 *			for 반복 횟수가 존재, 화면 UI, 목록 15~20 => 페이징(인라인뷰)
 *				가장 많이 사용 되는 반복문
 *					시작   종료   증감
 *				for(초기값;조건식;증감식){
 *					실행문장
 *				}
 *						 1	  2   4
 *				for(int i=1;i<=3;i++){
 *					실행문장 3
 *				}
 *				1=>2-3-4=>2-3-4=>2-3-4=>2 false 종료
 *		
 *				i=1 if(i<=3) 문장수행 => i++
 *				i=2 if(i<=3) 문장수행 => i++
 *				i=3 if(i<=3) 문장수행 => i++
 *				i=4 if(i<=3) false => 문장수행X => 종료
 *			while 무한반복(반복횟수를 모르는 경우)
 *				서버프로그램(Back-end)
 *				파일읽기, 데이터베이스, 빅데이터(챗봇)
 *				초기값 -------------1
 *				while(조건식){ -----2 => true->문장실행 false->종료
 *					반복 실행문장 ----3
 *					증가식 ---------4
 *				}
 *				=> 한번도 수행을 못할 수도 있다 => 보완 do~while
 *			do~while 조건이 나중에 검색 => 반드시 한번이상 수행, 사용빈도는 거의 없다
 *				초기값 -------------1
 *				do{
 *					반복 수행문장 ----2 => 조건 검색없이 일단 먼저 수행
 *					증가식 ---------3
 *				}while(조건식) -----4
 *		-반복제어문 - break, continue 
 *			break - 제어문을 종료 => 반복문/선택문
 *				for(int i=1;i<=5;i++){
 *					if(i==3) break; ==> 1,2 => 3일때 종료
 *				}
 *				*** for, while => break를 사용하면 종료
 *			continue - 제외 => 반복문에서만 사용
 *				for(int i=1;i<=5;i++){
 *					if(i==3) continue; => 3일때 증가식으로 올라간다=3제외하고 증가식으로 1,2,4,5
 *				}
 *				*** for => continue => 증가식으로 이동
 *				*** while => continue => 조건식으로 이동 => !!잘못쓰면 무한루프
 *					int i=1;
 *					while(i<=5){
 *						if(i==3) continue;
 *						System.out.println(i);
 *						i++;
 *					}
 *					i=1 => i<=5 => 1출력 => i++
 *					i=2 => i<=5 => 2출력 => i++
 *					i=3 => continue; => i<=5 => i=3 => continue; => i<=5 ==> 무한루프, 증가식을 내려가질 못함 
 *					
 *	=> 연산자+제어문 => 한개의 기능 설정 = 메소드
 *	=> 1,2,3 통합 = 클래스
 *	클래스 : 데이터형 / 통합 => 웹 출력(브라우저-HTML만 출력)
 */
public class 자바제어문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("===== for-break 반복문 중단 =====");
		for(int i=1;i<=5;i++) {
			if(i==3) break; // i=3일때 종료
			System.out.println("i="+i); //i=1, i=2
		}
		
		System.out.println("==== while-break 반복문 중단 ====");
		int i=1;
		while(i<=5) {
			if(i==3) break;
			System.out.println("i="+i); //i=1, i=2
			i++;
		}
		
		System.out.println("=== do~while-break 반복문 중단 ===");
		i=1;
		do {
			if(i==3) break;
			System.out.println("i="+i); //i=1, i=2
			i++;
		}while(i<=5);
	}

}
