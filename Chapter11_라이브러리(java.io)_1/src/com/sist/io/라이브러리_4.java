package com.sist.io;
import java.io.*;
import java.util.*;
import java.text.*;
/*
 *  File 관련
 *  1.생성자 => 경로명 : 폴더 정보 읽기
 *                   ex) File dir=new File("c:\\javaDev\\");
 *            경로명/파일명 : 파일 정보 읽기
 *                        ex) File file=new File("c:\\javaDev\\파일명");
 *  2.폴더 생성 : mkdir()
 *    파일 생성 : createNewFile()
 *  3.폴더 삭제 : delete()
 *              => 폴더 안에 파일/폴더가 있는 경우 삭제 불가 => 안에 있는 파일/폴더 삭제 후 해당 폴더 삭제가능
 *    파일 삭제 : delete()
 *  4.폴더 안에 있는 파일/폴더 정보 : listFiles() File[]리턴
 *  5.파일명 : getName()
 *    경로명 : getParent()
 *    파일명+경로명 : getPath()
 *  6.파일크기 : length()
 */
public class 라이브러리_4 {
	//코딩이 되어있는 상태라면 throws
	//코딩 시작 상태라면 try~catch
	//io, sql, net => 대부분 클래스 CheckedException을 가지고 있음
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File dir=new File("c:\\javaDev");
			//파일 정보 읽기
			File[] list=dir.listFiles(); //c:\\javaDev에 있는 모든 파일 읽기
			for(File file:list) {
				//System.out.println(file.getName());
				/*
				if(file.isFile()) { //파일
					System.out.print(file.getName()+"   ");
					//System.out.print(file.length()+"bytes   ");
					String s=file.length()/1024!=0?file.length()/1024+"KB":file.length()+"Bytes";
					System.out.print(s+"   ");
					System.out.print(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
					System.out.println();
				}else { //디렉토리(폴더)
					System.out.print(file.getName()+"   ");
					System.out.print("<DIR>파일폴더   "); //폴더는 파일 크기 출력을 해주지는 않음
					System.out.print(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
					System.out.println();
				}*/
				
				if(file.isFile()) {
					System.out.print(file.getName()+"   ");
					String s=file.getName();
					s=s.substring(s.lastIndexOf(".")+1); //확장자 잘라오기
					System.out.println(s+"파일");
				}
				
			}
		}catch(Exception ex) {}
	}

}
