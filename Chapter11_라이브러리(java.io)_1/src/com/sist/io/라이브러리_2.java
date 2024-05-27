package com.sist.io;
import java.util.*;
import java.io.*;
public class 라이브러리_2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		// 파일 생성 => 같은 폴더에서 동일 파일명 생성 불가
		File file=new File("c:\\java_data\\student.txt");
		
		//존재여부
		if(!file.exists()) { //파일이 없다면
			//파일 생성
			file.createNewFile(); //CheckedException => 예외처리필수
			System.out.println("파일이 생성되었습니다");
		}else {
			System.out.println("이미 존재하는 파일입니다");
		}
		
		
	}

}
