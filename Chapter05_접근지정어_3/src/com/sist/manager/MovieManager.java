package com.sist.manager;
import com.sist.vo.*; //Movie 클래스 불러오기

import java.io.FileReader;
//패키지가 다르면 import로 클래스 불러오기
/*
 *	접근지정어
 *	           자신의 클래스  같은 패키지  모든 클래스
 *	private**      O   
 *	default        O         O
 *	protected      O         O + 다른패키지, 상속받은경우 접근가능
 *	public**       O         O         O
 * 
 *	멤버변수
 *	- 인스턴스
 *	- 정적(공유)
 *	메소드 - 다른 클래스와 통신을 담당(연결) => public
 *	클래스 - 다른 클래스에서 메소드를 이용하거나 멤버변수 사용 -> 메모리 할당 => public
 *	생성자 - 메모리 할당시 호출 => public
 * 
 */
import java.util.*;
public class MovieManager {
	//데이터 고정해서 공유 => static
	//크롤링해서 저장==데이터모음 => 보여만 주는 상태 => static
	public static Movie[] movies=new Movie[1938]; //static 사용 => new없이 자동으로 메모리 저장 => 생성자필요X
	//데이터가 여러개일 때 메모리 공간을 하나만 이용해서 접근 => static
	//static - 변경이 없는 경우, 고정-모든 사용자가 같은 내용을 보고 있는 경우 사용
	//ex) 오라클 - 모든 사람들이 공유 => static
	//인스턴스 변수 - 각각 따로 저장(new) => 보안필요 => private => 은닉화
	/*
	 *	생성자 - 주로 인스턴스변수 초기화
	 *	초기화블록 - 주로 static 블록 사용
	 *	          인스턴스 변수는 new 사용해서 각 공간 생성 후 사용가능
	 *	          static 변수는 컴파일시 저장 => new 사용하지않고 접근가능
	 */
	
	//static에 대한 초기화 블록
	static { //컴파일러에 의해 자동 처리 => 호출하지 않는다 (생성자는 호출필요)
		try {
			FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
			StringBuffer sb=new StringBuffer(); //읽어온 모든 문자 저장
			int i=0; //i=read에서 읽은 ASC 정수 담을 변수
			while((i=fr.read())!=-1) { //-1 EOF End Of File 파일끝
					                   //read() => char로 읽지 않고 ASC(문자번호)를 읽어온다 ex) A=65
				sb.append((char)i); // 정수 i => char로 변환
			}
			fr.close(); //파일 닫기
			
			//읽어 온 데이터 movies에 저장
			String[] strMovie=sb.toString().split("\n"); //한줄씩 배열에 저장
			i=0;
			for(String movie:strMovie) {
				String[] m=movie.split("\\|");
				movies[i]=new Movie();
				movies[i].setMno(m[0]);
				movies[i].setTitle(m[1]);
				movies[i].setGenre(m[2]);
				movies[i].setPoster(m[3]);
				movies[i].setActor(m[4]);
				movies[i].setRegdate(m[5]);
				movies[i].setGrade(m[6]);
				movies[i].setDirector(m[7]);
				i++;
			}
			
		}catch(Exception ex) {}
	}
	public static Movie[] getMovieData(int page) { //public 붙여야 다른 클래스에서 호출가능
		int total=movieTotalPage();
		int leng=20;
		if(page==total)
			leng=18;
		Movie[] movie=new Movie[leng];
		int j=0;
		int rowSize=20; // 20개씩
		int pagecnt=(page*rowSize)-rowSize; //데이터를 저장할 시작점
		for(int i=0;i<movies.length;i++) {
			if(j<20 && i>=pagecnt) {
				movie[j]=new Movie();
				movie[j]=movies[i]; //movie배열 => movies에 저장된 내용 채움
				j++;
			}
		}
		return movie;
	}
	public static int movieTotalPage() {
		return (int)(Math.ceil(movies.length/20.0)); //ceil올림 .0이상이면 올림 => 총페이지
	}
}
