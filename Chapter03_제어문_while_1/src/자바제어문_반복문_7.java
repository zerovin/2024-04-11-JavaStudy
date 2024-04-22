/*
 *	파일출력, 데이터베이스 출력-웹, 네트워크 서버 제작-앱C
 */
import java.util.*;
import java.io.*;
public class 자바제어문_반복문_7 {

	public static void main(String[] args) throws Exception{ // throws Exception = 예외처리 
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
		int i=0; //한글 읽기 => 정수값을 읽는다
		while((i=fr.read())!=-1) { //-1 EOF(End Of File)
			System.out.print((char)i);
		}
		fr.close();
	}

}
