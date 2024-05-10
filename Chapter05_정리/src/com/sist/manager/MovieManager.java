package com.sist.manager;
//사용자 요청시 처리
//모든 데이터 관리
/*
 *	1.데이터읽기 => 시작과 동시에 => 초기화 (자동초기화/생성자)
 *	2.요청에 대한 처리 => 메소드
 *	  - 전체목록(페이징)
 *	  - 검색 결과 출력
 *	  - 상세보기 
 *	  ------------윈도우
 *	3.패키지 => 관련된 클래스를 모아서 관리
 *            접근지정어 = public
 */
import java.io.*;
import java.util.*;
import com.sist.vo.*; //Movie
public class MovieManager {
	//Movie에 있는 모든 데이터 읽어서 저장
	//변수 = private, 모든 User가 공유 = static
	private static Movie[] movies=new Movie[1938]; //목록 저장 => 모든 데이터가 동일
	/*
	 *	변수 - 기본형 / 배열 / 클래스
	 *	Movie : 사용자 정의 데이터형 => 배열, 형변환 가능 
	 *
	 *	초기화
	 *	static{}
	 *	생성자
	 */
	//초기화 => 생성자 => UserMain에서 사용
	public MovieManager() {
		//파일에서 데이터 읽어서 저장 => 예외처리 => 컬렉션		
		try {
			//정상수행
			//예외처리는 모든 문장에 있음, 생략가능
			//파일 입출력, 네트워크연결, 데이터베이스에서는 필수 
			FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
			int i=0; //fr.read() => 리턴형 int
			StringBuffer sb=new StringBuffer(); //읽어서 데이터 누적
			while((i=fr.read())!=-1) { //-1=파일의 끝 EOF End Of File
				sb.append((char)i);
			}
			//반드시 파일 닫기
			fr.close();
			
			String data=sb.toString(); //전체 데이터를 모은다
			String[] temp=data.split("\n"); //한줄씩 저장
			i=0;
			for(String s:temp) {
				String[] movie=s.split("\\|");
				// split, replaceAll => ? . + * | => 기호자체사용시 \\사용
				// \\사용하지 않으면 연산자로 처리
				movies[i]=new Movie();
				movies[i].setRank(movie[0]); //변수에 값 설정 setter
				movies[i].setTitle(movie[1]);
				movies[i].setGenre(movie[2]);
				movies[i].setPoster(movie[3]);
				movies[i].setActor(movie[4]);
				movies[i].setRegdate(movie[5]);
				movies[i].setGrade(movie[6]);
				movies[i].setDirector(movie[7]);
				i++;
			}
		}catch(Exception ex) {} //에러처리
	}
	/*
	public static void main(String[] args) {
		MovieManager m=new MovieManager();
		for(Movie movie:m.movies) {
			System.out.println(movie.getRank()+"."+movie.getTitle());
		}
	}
	*/
	
	//목록출력
	public Movie[] movieListData(int page) {
		int total=movieTotalPage();
		int leng=20;
		if(page==total) { //마지막 페이지면
			leng=18;
		}
		//배열의 단점 = 고정 ==> 보완 - 컬렉션
		Movie[] movie=new Movie[leng];
		int j=0;
		int pagecnt=(20*page)-20; //페이지별 시작인덱스 구하는 식
		/*
		 *	1page 0~19
		 *	2page 20~39
		 *	3page 40~59 
		 */
		for(int i=0;i<movies.length;i++) {
			if(j<20 && i>=pagecnt) {
				movie[j]=new Movie();
				movie[j]=movies[i];
				j++;
			}
		}
		return movie;
	}
	public int movieTotalPage() {
		return (int)(Math.ceil(movies.length/20.0));
	}
	
	//상세보기
	public Movie movieDetailData(int mno) {
		return movies[mno-1];
	}
	
	//검색
	public Movie[] movieFindData(String title) {
		int count=0;
		for(Movie m:movies) {
			if(m.getTitle().contains(title)) {
				count++; //배열의 개수를 구하기 위해
			}
		}
		Movie[] movie=new Movie[count]; //구한 개수만큼의 크기를 가진 배열 생성 => 동적(가변형)
		int i=0;
		for(Movie m:movies) {
			if(m.getTitle().contains(title)) {
				movie[i]=m;
				i++;
			}
		}
		
		return movie;
	}
	
	//웹 목록(페이징)
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		MovieManager m=new MovieManager(); // static 메소드에서 인스턴스 메소드를 부를때 객체생성
		/*
		int total=m.movieTotalPage();
		//인스턴스변수 / 인스턴스메소드의 비율이 static보다 많은 이유 ↑
		System.out.print("1~"+total+" 사이의 페이지 입력 >> ");
		int page=scan.nextInt();
		
		//데이터 읽기
		Movie[] movie=m.movieListData(page);
		for(Movie mm:movie) {
			System.out.println(mm.getRank()+"."+mm.getTitle());
		}
		*/
		
		System.out.print("검색어 입력 >> ");
		String title=scan.next();
		Movie[] movie=m.movieFindData(title);
		for(Movie mm:movie) {
			System.out.println(mm.getRank()+"."+mm.getTitle());
		}
		
		System.out.println("============================");
		System.out.print("상세 볼 영화번호 >> ");
		int mno=scan.nextInt();
		Movie mmm=m.movieDetailData(mno);
		//메소드 - 요청에 처리 => 기능
		//클래스 - 처리 / 데이터만 있는 클래스
		//파일 / 오라클 => 데이터만 있는 클래스에 값을 채워서 전송
		System.out.println("순위:"+mmm.getRank());
		System.out.println("영화명:"+mmm.getTitle());
		System.out.println("감독:"+mmm.getDirector());
		System.out.println("출연:"+mmm.getActor());
		System.out.println("장르:"+mmm.getGenre());
		System.out.println("등급:"+mmm.getGrade());
		System.out.println("개봉일:"+mmm.getRegdate());
		
		//목록, 상세보기, 검색 => 기본
	}
	/*
	 *	데이터 모으기 Movie => 멤버변수
	 *	기능 설정 => 목록, 상세, 검색, 예약, 댓글 => 메소드 => 액션클래스
	 *	           데이터 읽기 => 초기화(전체목록) => 생성자
	 *	다른 클래스에 활용 => 접근지정어 private/protected/default 접근금지
	 *                           public 접근가능
	 *                           데이터 = 접근금지 + 데이터 기능설정메소드 getXxx(), setXxx()
	 * 
	 */
}
