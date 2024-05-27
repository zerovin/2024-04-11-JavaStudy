package com.sist.io;
/*
 *   파일 읽기
 *   FileInputStream => 1byte 한글깨짐
 *                      BufferedReader로 1byte->2byte 변환해서 한글깨짐 방지 가능
 *   FileReader => 2byte 한글 정상제어
 */
import java.io.*;
public class 라이브러리_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis=null;
		try {
			//읽을 파일 설정
			fis=new FileInputStream("c:\\java_data\\seoul_location.txt");
			// 영문, 숫자, 특수문자 - 정상  / 영어 외 다른 언어 - 깨짐
			/*
			int i=0;
			String data="";
			while((i=fis.read())!=-1) { //파일이 끝날 때 까지
				data+=(char)i;
			}
			System.out.println(data); //한글깨짐
			*/
			
			//속도는 Buffered가 빠름
			BufferedReader br=new BufferedReader(new InputStreamReader(fis)); //InputStream(1byte)을 Reader(2byte)로 읽어옴
			String data="";
			long start=System.currentTimeMillis();
			while(true) {
				String s=br.readLine(); //한줄씩 읽기
				if(s==null) break; //문장이 끝나면 반복문 종료
				data+=s+"\n";
			}
			long end=System.currentTimeMillis();
			System.out.println(data);
			System.out.println("걸린 시간:"+(end-start));
			//BufferedReader=18 FileReader=168 BufferedReader가 한줄씩 읽어와서 속도가 빠름
		}catch(Exception ex) {
			ex.printStackTrace(); //에러확인
		}finally {
			//파일, 서버, 데이터베이스 연결 => 에러, 정상 관계없이 반드시 종료
			try {
				fis.close();
			}catch(Exception e) {}
		}
	}

}
