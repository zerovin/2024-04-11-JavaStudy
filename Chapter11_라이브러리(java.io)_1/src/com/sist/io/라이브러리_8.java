package com.sist.io;
/*
 *  파일쓰기 FileWriter
 *         크롤링한 데이터를 저장
 *  파일읽기 FileReader
 *         프로그램 제어
 *         한줄씩 읽기 => 파일에 있는 데이터를 메모리에 한번에 저장 => 필터스트림 
 *         한글자씩 읽기 => 파일에 있는 데이터를 한글자씩 읽어오기	
 *  필터 스트림 - BufferedReader******* ex)네트워크, 웹 369page
 *  
 *  FileWriter (FileOutputStream) => write(), close()
 *  FileReader (FileInputStream) => read(), close()
 *  ==> 한글자씩 읽기 / 쓰기(여러글자 입력가능)
 *      FileWriter => write(String s)
 *      FileOutputStream => write(byte[])
 *      String에서 byte[]변환
 *      String s="aaa";
 *             s.getBytes();
 */

//파일에 저장
import java.io.*;
public class 라이브러리_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.FileOutputStream 이용한 저장
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("c:\\java_data\\member.txt");
			//파일이 있는 경우 해당 파일에 내용 저장
			//파일이 없는 경우 자동생성
			//FileOutputStream / FileWriter => 지정한 경로, 파일명에 파일이 없는 경우 자동생성
			
			//한글자 입력 => byte(int, char)
			//fos.write('A');
			//fos.write('B');
			//fos.write('C');
			
			// 여러글자 한번에 입력 => byte[]
			String msg="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			fos.write(msg.getBytes()); //msg만 넣으면 오류 byte단위이기 때문에 byte로 변환
			//getBytes() => byte, byte[] 바이트 단위로 저장
			
			System.out.println("저장 완료");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				fos.close();
			}catch(Exception e) {
				
			}
		}
	}

}
