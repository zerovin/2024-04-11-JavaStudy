package com.sist.io;
/*
 *  355page - 357page
 *  java.io => CheckedException => 예외처리 필수
 *   - io : 입출력
 *     inputStream - read() 읽기
 *     outputStream - write() 쓰기
 *   - Stream : 데이터가 이동하는 통로
 *     FIFO : 먼저 들어간게 먼저 나오는 방식 First In First Out => Queue
 *   - 클래스
 *     1.File
 *     2.FileInputStream
 *       FileOutputStream
 *     3.FileReader
 *       FileWriter
 *     4.BufferedReader
 *       BufferedWriter
 *     5.BufferedInputStream
 *       BufferedOutputStream
 *     7.ObjectInputStream
 *       ObjectOutputStream
 *     ------------------------
 *     InputStream / OutputStream - 읽기/쓰기 => 1byte씩 읽기/쓰기 => 한글 깨짐 => 한글이 아닐시 사용
 *                                  업로드 / 다운로드
 *                                  바이트 스트림
 *     Reader / Writer - 읽기/쓰기 => 2byte씩 읽기/쓰기 => 한글 정상 => 한글 포함시 사용
 *                       파일 읽기/쓰기
 *                       문자 스트림
 *                       ex) movie.txt 파일 읽을 때 FileReader
 *                       
 *  메모리에 저장 - 속도가 빠르다
 *            - 프로그램이 종료되면 모든 데이터가 사라진다
 *              => 영구적으로 저장필요 => 파일
 *  파일 - 데이터 노출
 *        잃어버릴 가능성
 *        관련된 데이터를 따로 저장해서 처리하기 어렵다
 *        구분자가 없다 => 배열에 저장, ArrayList에 저장해서 사용
 *        => 보완 => RDBMS(관계형 데이터베이스) == 오라클
 *  RDBMS(관계형 데이터베이스) - 파일의 모든 단점 보완
 *                         업로드/다운로드 불가
 *  ===> 추천 - ex) 카페/블로그 => 읽은 데이터를 파일로 저장 후 분석 => 분석된 데이터를 오라클로 전송 
 *  
 *  파일 클래스 정보 376page => 파일 입출력
 *  - File : 파일, 폴더 정보를 가지고 있다
 *  - File 생성자
 *      File file=new File("경로명/파일명") => 파일에 대한 정보를 가지고 온다
 *      File dir=new File("경로명") => 폴더에 대한 정보를 가지고 온다
 *  - File 정보와 관련된 메소드
 *   ***1) 파일명 읽기 getName() : String 리턴
 *      2) 경로명 읽기 getParent() : String 리턴
 *   ***3) 파일명+경로명 getPath() : String 리턴
 *   ***4) 파일크기 length() : long 리턴
 *      5) 숨김 파일 여부 isHidden() : boolean 리턴
 *      6) 읽기 가능 여부 canRead() : boolean 리턴
 *      7) 쓰기 가능 여부 canWrite() : boolean 리턴
 *      8) 수정일 lastModified() : long 리턴
 *   ***9) 파일 정보 한번에 읽기(폴더) listFiles() : File[] 리턴
 *      10) 파일 여부 isFile() : boolean 리턴
 *      11) 폴더 여부 isDirectory() : boolean 리턴
 *  - File 제어하는 메소드
 *   ***1) 폴더 생성 mkdir()
 *   ***2) 파일 생성 createNewFile()
 *   ***3) 파일 삭제 delete()
 *   ***4) 파일 존재 여부 exists()
 *   ----------------------------파일 입출력 / 파일 복사 / 속도의 최적화
 *  
 */
import java.io.*;
import java.text.*;
import java.util.*;
public class 라이브러리_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("c:\\javaDev\\melon.txt");
		System.out.println("***파일명:"+file.getName());
		System.out.println("경로명:"+file.getParent());
		System.out.println("***파일명+경로명:"+file.getPath());
		System.out.println("숨김 파일 여부:"+file.isHidden());
		System.out.println("읽기 전용 여부:"+file.canRead());
		System.out.println("쓰기 전용 여부:"+file.canWrite());
		System.out.println("***파일 여부:"+file.isFile());
		System.out.println("폴더 여부:"+file.isDirectory());
		System.out.println("수정일:"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
		//lastModified() 는 long형으로 리턴 => SimpleDateFormat으로 변환
		System.out.println("***파일 크기:"+file.length());
	}

}
