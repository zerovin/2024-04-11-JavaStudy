package com.sist.io;
//데이터 읽기
import java.util.*;
import java.io.*;
/*
 *  파일입출력 => 프로젝트
 *  ObjectInputStream / ObjectOutputStream 사용빈도가 많이 없어짐
 *  SQL  - 오라클 연동을 이용해서 파일입출력을 많이 쓰지는 않음
 *  개인정보 저장에 가끔 쓰임 => 네트워크 연결이 안되면 파일이용 => 네트워크 에러에 대비 ex)오라클정지
 *  JSON / CSV / XML => 파싱(필요한 데이터 읽기) => 오픈API(라이브러리가 따로 있다)
 *  **jackson CSVReader/CSVWriter-파이썬(공공데이터), **DOM/SAX
 */
public class 라이브러리_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectInputStream ois=null;
		try {
			//객체 생성
			FileInputStream fis=new FileInputStream("c:\\java_data\\std.txt");
			ois=new ObjectInputStream(fis);
			ArrayList<Student> list=(ArrayList<Student>)ois.readObject();
			//readObject() 리턴형 Object => 형변환 필요
			//제네릭까지 데이터형 ArrayList<Student>
			
			for(Student s:list) {
				System.out.println(s.getHakbun()+" "
						+s.getName()+" "
						+s.getKor()+" "
						+s.getMath()+" "
						+s.getEng());
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				ois.close();
			}catch(Exception e) {}
		}
	}

}
