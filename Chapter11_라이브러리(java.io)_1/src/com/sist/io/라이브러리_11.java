package com.sist.io;
//FileReader
import java.io.*;
public class 라이브러리_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr=null;
		try {
			fr=new FileReader("c:\\java_data\\seoul_location.txt"); //자동생성불가, FileWrtier/FileOutputStream만 자동생성가능
			int i=0;
			long start=System.currentTimeMillis();
			String data="";
			while((i=fr.read())!=-1) {
				data+=(char)i;
			}
			long end=System.currentTimeMillis();
 			System.out.println(data);
			System.out.println("걸린 시간:"+(end-start));
			//BufferedReader=18 FileReader=168 BufferedReader가 한줄씩 읽어와서 속도가 빠름
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				fr.close();
			}catch(Exception e){}
		}
	}

}
