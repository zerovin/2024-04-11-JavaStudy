package com.sist.model;
/*
 *  1.목록 출력 => 검색 => 데이터 추출 => 오라클-SELECT ==> READ
 *  2.게시물 추가 => 추가 => 오라클-INSERT ==> CREATE
 *  3.상세보기 => 조건 => 오라클-SELECT ==> READ
 *  4.수정 => 수정 => 오라클-UPDATE ==> UPDATE
 *  5.삭제 => 삭제 => 오라클-DELETE ==> DELETE
 *  --------CRUD : 메모리-컬렉션 / 파일-ObjectInput/Output / 데이터베이스-오라클
 */
import java.util.*;
import java.io.*;
public class BoardSystem {
	//데이터 저장 => 모든 사용자 공통으로 사용
	private static ArrayList<Board> list=new ArrayList<Board>();
	
	//초기화
	public BoardSystem(){
		/*
		// 이 코드 있으면 프로그램 껐다가 켰을 때 목록이 하나뿐
		Board b=new Board();
		b.setNo(1);
		b.setName("홍길동");
		b.setSubject("파일을 이용한 CRUD 배우기");
		//프로그램 => 데이터관리 JSP Spring VueJS ReactJS
		//데이터 분석 => 머신러닝/딥러닝 => 응용 => AI
		b.setContent("파일을 이용한 CRUD=>데이터베이스(오라클):읽기, 검색, 추가, 수정, 삭제:메모리(컬렉션), 파일, 데이터베이스");
		b.setRegdate(new Date());
		b.setHit(0);
		b.setPwd("1234");
		list.add(b);
		boardSave();
		*/
		boardGetData(); 
	}
	public void boardGetData() {
		ObjectInputStream ois=null;
		try {
			FileInputStream fis=new FileInputStream("c:\\java_data\\board.txt");
			ois=new ObjectInputStream(fis);
			list=(ArrayList<Board>)ois.readObject();
		}catch(Exception ex) {
			ex.printStackTrace(); //에러확인
		}finally {
			try {
				ois.close();
			}catch(Exception e) {}
		}
	}
	//저장
	public void boardSave() {
		ObjectOutputStream oos=null;
		try {
			FileOutputStream fos=new FileOutputStream("c:\\java_data\\board.txt");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(list); //파일에 객체단위로 저장
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				oos.close();
			}catch(Exception ex) {}
		}
	}
	
	//추가 => 게시물 / 장바구니 / 예약 boardInsert
	public void boardInsert(Board board) {
		board.setNo(boardSequence()+1);
		list.add(board);
		boardSave();
	}
	
	//목록 => 페이지 나누기 / ***면접 => 인라인뷰
	public int boardTotalPage() {
		//SELECT CEIL(COUNT(*)/10.0) FROM board
		return (int)(Math.ceil(list.size()/10.0));
	}
	public ArrayList<Board> boardList(int page){
		ArrayList<Board> bList=new ArrayList<Board>();
		int j=0; //10개씩 => j<10 => j++
		int pagecnt=(page*10)-10; //시작위치
		/*
		 * 1page => 0~9   ==> 0
		 * 2page => 10~19 ==> 10
		 * 3page => 20~29 ==> 20
		 * 
		 * WHERE rownum BETWEEN 1 AND 10 ORDER BY no DESC
		 */
		ArrayList<Board> temp=new ArrayList<Board>();
		for(int i=list.size()-1;i>=0;i--) {
			temp.add(list.get(i)); //역순 출력
		}
		
		//sort
		for(int i=0;i<temp.size();i++) {
			if(j<10 && i>=pagecnt) {
				Board b=temp.get(i);
				bList.add(b);
				j++;
			}
		}
		return bList;
	}
	
	//상세보기
	public Board boardDetail(int no) {
		Board board=new Board();
		/*
		 * SELECT * FROM board
		 * WHERE no=1 
		 */
		for(Board b:list) {
			if(b.getNo()==no) {
				b.setHit(b.getHit()+1); //조회수 증가
				board=b;
				boardSave();
				break;
			}
		}
		return board;
	}
	
	//수정 => 장바구니 / 예약 boardInsert
	public void boardUpdate(int no, Board board) {
		int index=0;
		for(int i=0;i<list.size();i++) {
			Board b=list.get(i);
			if(b.getNo()==no) {
				index=i;
				break;
			}
		}
		list.set(index, board);
		boardSave(); //파일에 저장
	}
	public Board boardUpdateData(int no) {
		Board board=new Board();
		for(Board b:list) {
			if(b.getNo()==no) {
				board=b;
				break;
			}
		}
		return board;
	}
	
	//삭제 => 취소
	public void boardDelete(int no) {
		int index=0;
		for(int i=0;i<list.size();i++) {
			Board b=list.get(i);
			if(b.getNo()==no) {
				index=i;
				break;
			}
		}
		list.remove(index);
		
		//파일에 다시 저장
		boardSave(); //반복제거
		/*
		 *  메소드 - 기능설정 => 기능에 관련된 명령문을 모아서 관리 => 재사용가능
		 *       - 반복 제거
		 *       - 에러처리, 수정이 편리하게 만든다
		 *   
		 */
	}
	
	//검색
	public ArrayList<Board> boardFind(String subject){
		ArrayList<Board> bList=new ArrayList<Board>();
		for(Board b:list) {
			if(b.getSubject().contains(subject)) {
				bList.add(b);
			}
		}
		return bList;
	}
	
	//sequence 자동증가번호
	public int boardSequence() {
		int max=0;
		// 종료하지 않는 프로그램 제작 => 예외처리 => 에러방지
		try {
			// list => 처음 null값 => 가지고 올 최대값이 없 => 오류
			for(Board b:list) { 
				if(b.getNo()>max) {
					max=b.getNo();
				}
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return max;
	}
}
