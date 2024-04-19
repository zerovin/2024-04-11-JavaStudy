/*
 *	연산자
 *	1.단항연산자
 *	  - 증감연산자 - 반복문에서 주로 사용
 *		++, -- - 1증가, 1감소
 *		전치연산자
 *		  ++a ===> 먼저 증가 나중에 다른 연산 처리
 *		  ex) int a=10;
 *			  int b=++a;
 *			  -------------
 *			  a=a+1 => b=a
 *		후치연산자
 *		  a++ ===> 다른 연산 처리 후에 증가
 *		  ex) int a=10;
 *			  int b=a++;
 *			  -------------
 *			  b=a => a=a+1
 *		** ++a, a++ => a는 무조건 1 증가
 *			ex) int a=10;
 *				System.out.println(a++) => 출력 후 증가 => 10
 *				System.out.println(++a) => 증가 후 출력 => 11
 *	  - 부정연산자 - 조건문에서 주로 사용
 *		무조건 결과값 - true/false ==> !
 *		ex) 6==8 => !(6==8) 반대값
 *			!(6==8 && 6>5) => 예약일이 아닌 날, 비활성
 *	  - 형변환연산자 - 데이터형을 바꿀 시에 사용 실수->정수, 문자->정수, 정수->문자
 *		데이터형에 대한 형변환 ==> 클래스 형변환은 어렵(is-a, has-a)
 *		**데이터형의 크기
 *			------ 데이터형을 크게 UpCasting ----->
 *			byte < char < int < long < double
 *			<---- 데이터형을 작게 DownCasting-----
 *		  => 기본 UpCasting => 자동변경
 *		     DownCasting => 강제변경 => 형변환연산자
 *			 ex) int a='A'; char => int 자동변경
 *				 double d=10; int => double 자동변경
 *				 int a=10.5; double => int 자동변경X => 강제로 형변환(int)10.5
 *		  => 연산처리시에 주로 형변환이 많다
 *			 데이터형이 같은 것끼리만 연산
 *			 ex) 10 + 10.5 => 연산처리X => 10.0 + 10.5
 *				 'A' + 1 => int로 자동변경 => 65 + 1
 *			 => 자동으로 큰 데이터형으로 변경 후 연산처리 
 *		형변환 방법 : (데이터형)
 *		- byte로 변경 => (byte)10 ==> 10
 *		- char로 변경 => (char)65 ==> 'A'
 *		- double로 변경 => (double)10 ==> 10.5
 *		**boolean은 형변환이 없다 (숫자관련 데이터형만 가능)
 *		**필요시에만 형변환
 *	  ※단항연산자 - 연산대항(피연산자) = 1개
 *		ex) int a=10; ++a, --a
 *			boolean bCheck=ture; ==> !bCheck
 *			int a=65; ==> (char)a
 *	
 *	2.이항연산자 - 연산 대상이 2개인 경우
 *	  - 산술연산자
 *		└ 비트연산자(&, |, ^), 쉬프트연산자(<<, >>), 반전연산자(~ 음수->양수/양수->음수)
 *		+, -, *, /, % 5개의 연산
 *		+ - 덧셈 10+10+20
 *			문자열 결합 "Hello "+"Java" == "Hello Java"
 *		/ - 0으로 나눌 수 없다
 *		  - 정수/정수=정수
 *		% - 값이 왼쪽편의 부호(+, -)를 따른다
 *		***연산처리가 될때
 *			다른 데이터형일 경우 큰 데이터형으로 결과값이 나온다
 *			ex) int+double=double
 *				int+char=int
 *				long+int+double=double
 *			=> int이하(byte, char)의 연산결과는 int
 *				byte+byte=int
 *				byte+char=int
 *				char+char=int
 *
 *	  - 비교연산자 => 왼쪽 기준
 * 		결과값 - boolean => 조건문, 반복문에서 주로 사용
 * 		  == 같다
 * 		  != 같지 않다
 * 		  < 작다
 * 		  > 크다
 * 		  <= 작거나 같다 < || ==
 * 		  >= 크거나 같다 > || ==
 * 		=>숫자(int,char,byte,long,double) 비교가능
 *		  boolean일 경우에는 ==, != 만 가능 
 * 		
 *	  - 논리연산자
 *		결과값 - boolean
 *		*** &&가 ||보다 우선순위 ()는 최우선순위 연산자
 *		조건 || 조건 && 조건			  (조건 || 조건) && 조건
 *			  ----------- 1순위   ==>  ------------1순위
 *		----------2순위						 ------------2순위
 *
 *		------------------------------
 *		(조건) (조건)		&&		||
 *		------------------------------
 *		true  true	   true	   true
 *		------------------------------
 *		true false	  false	   true
 *		------------------------------
 *		false true	  false	   true
 *		------------------------------
 *		false false	  false	  false
 *		------------------------------
 *		&& = 두개의 조건이 true일 때만 true 나머지는 false
 *			 범위포함, 로그인(id,pw)
 *		|| = 둘중에 1개가 true면 true
 *			 범위를 벗어나는 경우
 *
 *	  - 대입연산자
 *		= 대입
 *		+= 여러개 증가
 *			ex) int a=10;
 *				a+=10 ===> a=a+10 ===> 10씩증가
 *		-= 여러개 감소
 *			ex) int a=10;
 *				a-=5 ===> a=a-5 ===> 5씩감소
 *		=> 1개 증가 - a++, ++a, a+=1, a=a+1
 *		   1개 감소 - a--, --a, a-=1, a=a-1
 *		*=, /=, %= ==> 존재는 하지만 사용빈도는 없음
 *
 *	3.삼항연산자 - 소스를 줄이기 위해 주로 사용
 *	  - (조건) ? 값1 : 값2
 *		----- true => 값1
 *			  false => 값2
 *		=> if ~ else
 *
 *	**HTML => 자바연결 <% %>
 *	  <%
 *		if(curpage>1){
 *	  %>
 *			<a href="list.jsp?page=<%=curpage-1%>">
 *	  <%
 *		}else{
 *	  %>		
 *			<a href="list.jsp?page=<%=curpage%>">
 *	  <%
 *		}
 *	  %>
 *	  =====>
 *	  <a href="list.jsp?page=<%=curpage-1?curpage-1:curpage%>">
 *
 *	※산술연산자-형변환연산자 결합 => 통계, 평균 => 단독프로 사용
 *	  비교연산자, 논리연산자 => 제어문(if/for)에서 주로 사용
 *
 *	자바 => 기본을 다 안다면 누가누가 빨리 찾냐의 싸움
 *	80% 이미 제작 20% 조립
 */
public class 자바연산자_1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stu
		
		int a=10;
		System.out.println(a++); //10
		a=10;
		System.out.println(++a); //11
		
		new Thread().stop(); // 실행은 되지만 버전이 바꼈단 경고가 뜸
		new Thread().interrupt(); //변경된 애로 적용
		
	}

}
