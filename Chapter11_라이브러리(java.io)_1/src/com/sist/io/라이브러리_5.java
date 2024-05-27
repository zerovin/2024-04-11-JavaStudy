package com.sist.io;

/*
 *  File
 *  
 *  바이트 스트림
 *    InputStream        OutputStream
 *         |                  |
 *  FileInputStream    FileOutputStream
 *      파일 읽기             파일 쓰기        => 1byte씩 읽어서 출력/입력
 *      read()             write()        => close()
 *  ---------------------------------------- 다운로드 / 업로드
 *   
 *   문자 스트림
 *      Reader            Writer
 *        |                 |
 *    FileReader        FileWriter
 *      파일 읽기           파일 쓰기    => 2byte씩 읽어서 출력/입력
 *      read()            write()   => close()
 *  ---------------------------------- 한글이 포함된 데이터 입출력
 *  ** 한글은 한 글자당 2byte
 *  
 *  바이트 스트림 : 1byte 전송 (파일) ex)파일업로드, 네트워크 송수신(인코딩,디코딩)
 *  문자 스트림 : 2byte 전송 (파일제어) 
 *  필터 스트림 : 실제 하드디스크에 있는 모든 내용을 메모리에 올려 놓고 시작 => 속도가 빠름
 *             BufferedInputStream / BufferedOutputStream
 *             BufferedReader / BufferedWriter
 *    
 *  IO - 메모리 입출력 - 표준입출력 358page
 *                   System.out : 출력 => print(), println(), printf()
 *                   System.in : 입력 => read() 문자번호(int) => 예외처리필요
 *       파일 입출력
 *       네트워크 입출력
 *       단점 : 단방향 통신 => 읽기/쓰기가 따로 만들어진다 ex)빨대
 *             양방향 통신을 원할 경우 => 프로그램 두개 동작 (읽기/쓰기) => 쓰레드(네트워크)
 */

//파일 입출력
import java.io.*;
public class 라이브러리_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FileInputStream fis=null; //FileInputStream=1byte 한글=2byte 한글깨짐
		FileReader fis=null; //FileReader=2byte 한글=2byte 한글포함 텍스트 제어
		try {
			File file=new File("C:\\javaDev\\javaStudy\\Chapter11_라이브러리(java.io)_1\\src\\com\\sist\\io\\라이브러리_1.java");
			fis=new FileReader(file); 
			int i=0; //문자 번호를 읽어온다
			while((i=fis.read())!=-1) { //-1 EOF End Of File
				System.out.print((char)i); //360page
			}
		}catch(Exception ex) {
			ex.printStackTrace(); //에러확인
		}finally {
			//정상수행(try) , 오류발생(catch) 상관없이 무조건 수행하는 문장
			try {
				fis.close();
			}catch(Exception e) {}
		}
	}

}
