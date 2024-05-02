/*
 *	메소드 - 기능처리(사용자 요청처리) => 한개의 기능만 수행이 가능하게 만든 명령문 집합
 *	       명령문
 *	         1)변수선언
 *	         2)연산처리
 *	         3)제어문처리 
 * 	1.메소드 구조
 * 	  [접근지정어][옵션] 리턴형 메소드명(매개변수목록){ => 선언부(원형)
 * 	     구현부
 * 	     ...
 * 	     ...
 * 	     return 값; => 메소드 종료 - return에서 종료
 *	                             return이 메소드 중간에 올 수도 있음
 *	                             return 생략 불가
 *	                             └ void의 경우는 생략가능 => 컴파일러에서 return 자동첨부
 * 	  }
 *	  접근지정어 - 다른 클래스에서 접근하는 범위
 *	            public / protected / private / default(같은 폴더안에서만 접근가능)
 *	  옵션 - default : 없는 경우
 *	      **static : 자동 메모리 할당 => 공유
 *	        abstract : 추상 메소드 => 선언 => 프로그램에 맞게 구현해서 사용 ex)버튼,마우스클릭,키보드입력
 *	        final : 종단 메소드 => 수정이 안되는 메소드
 *	  리턴형 - 사용자 요청에 대한 결과값
 *	         반드시 1개만 전송 기본형(정수,실수,문자,논리), 여러개일 경우 배열/클래스
 *	  메소드명 - 변수 식별자와 동일
 *	  매개변수 - 여러개 사용 가능 => 사용자가 보내주는 값
 *	  메소드 호출 - 메소드 호출시 메소드는 처음부터 끝까지 사용
 *	             사용 후 호출했던 위치로 복귀
 *	             void display(){
 *	                1..
 *	                2..
 *	                3..
 *	             }
 *	             main(){
 *	                1.. => 1
 *	                2.. => 2
 *	                display(); => 3 메소드 블록으로 이동 => 메소드 내의 123 수행 후 
 *	                3.. => 4
 *	                4.. => 5
 *	             }
 *	             --------------------------
 *	             int display(){
 *	                1..
 *	                2..
 *	                3..
 *	                return 5;
 *	             }
 *	             main(){
 *	                1..
 *	                2..
 *	                int a=display(); => 123수행 => return 값 전송 => a=5
 *	                3..
 *	                4..
 *	             }
 *	2.메소드 특징
 *	  -반복적인 문장이 있는 경우(반복 제거)
 *	  -구조적인 프로그램 => 단락(수정, 오류처리)
 *	  -재사용 => 복붙이아니라 호출, main은 다른 클래스에서 호출 불가능
 *	  -객체지향프로그램은 클래스와 클래스의 상호연결
 *	   클래스 역할 - 기능(CPU,메모리,하드디스크,사운드...)
 *	            - 조립(메인보드 = main이 있는 클래스)
 *	  ex) 사용자가 로그인 요청
 *	      => id,pwd : 매개변수
 *	      => 결과값 : boolean
 *
 *	      사용자가 아이디 중복체크
 *	      => id : 매개변수
 *	      => 결과값 : boolean
 *
 *	      웹 => 매개변수(이미지 클릭, 페이지번호 클릭, 입력(검색어))
 *	        => 화면 이동 => return
 *	        => 출력할 내용이 많은 경우 => 배열/컬렉션
 *	3.매개변수 전송법
 *	  -값 전송 - 메모리를 따로 만들어서 값 전송 작업처리
 *	   Call By Value
 *	   기본형 => 원본 유지
 *	  -주소 전송 - 메모리 주소 공유 전송, 같은 메모리 공간에서 작업처리
 *	   Call By Reference
 *	   배열/클래스 => 원본 변경
 *	   **String은 예외 - 일반 기본형과 동일하게 Call By Value
 *
 *
 */
public class 메소드정리_1 {
	// call by value => 실제 값만 전송 => 다른 메모리 생성(기본형, String)
	// 기본형은 주소를 가지고 있지 않다 => 값만 전송
	// call by reference => 메모리 주소 전송 => 같은 메모리 제어(배열, 클래스)
	static void rand(int[] arr) {
		System.out.println("arr="+arr); //nums와 주소 동일, arr=[I@6f2b958e
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
	}
	/*
	 *	얕은 복사
	 *	int[] arr=new int[5];
	 *	int[] temp=arr;  ===> 주소공유, 원본공유 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[5]; 
		System.out.println("nums="+nums); //arr과 주소 동일, nums=[I@6f2b958e
		rand(nums);
		for(int i:nums) {
			System.out.print(i+" ");
		}
		
		int[] arr={10,20,30,40,50};
		int[] temp=arr; //temp는 arr의 별칭 => temp=arr, 메모리를 넘겨주기 떄문에 넘겨준 배열자체가 변경
		temp[1]=200;
		System.out.println("\ntemp[1]="+temp[1]); //temp[1]=200
		System.out.println("arr[1]="+arr[1]); //arr[1]=200
		
	}

}
