package com.sist.io;
//파일 쓰기 => 문자스트림 2byte 한글사용편리
//FileWriter
import java.io.*;
public class 라이브러리_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw=null;
		try {
			fw=new FileWriter("c:\\java_data\\board.txt", true); //파일이 없을 경우 자동생성, 폴더생성은 불가, true 없으면 덮어쓰기
			String msg="ABCDEFGHIOJLMNOPQRSTUVWXYZ123456789\r\n";
			fw.write(msg); //byte변환을 하지 않아도 입력가능
			System.out.println("저장완료");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch(Exception e) {}
		}
	}

}
