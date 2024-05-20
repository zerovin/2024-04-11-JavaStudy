package com.sist.main;

public class 예외처리_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// try ~ catch 수행 - 웹에서 필수 => 네트워크와 관련 / 오라클 연동
		// 웹, 파일, 오라클 => 예외처리는 문법사항, 반드시 추가
		/*
		 *  파일을 읽어서 데이터 출력 => 코딩테스트 => 예외처리 안해서 오류나면 0점처리
		 *  try{
		 *     FileReader fr=new FileReader("경로명")
		 *     int i=0;
		 *     while((i=fr.read())!=-1){
		 *        System.out.print((char)i);
		 *     }
		 *     fr.close();
		 *  }catch(IOException){
		 *  
		 *  }
		 *  
		 */
		
		try {
			System.out.println("문장 1");
			System.out.println("문장 2");
			System.out.println("문장 3");
			int[] arr=new int[2];
			System.out.println(arr[2]);
			System.out.println(10/0);
			System.out.println("문장 4");
			System.out.println("문장 5");
		}catch(/*Arithmetic*/RuntimeException e){
			System.out.println("에러발생 => 복구"); //에러 발생시에만 수행
		}
		System.out.println("문장 6");
		System.out.println("문장 7");
		System.out.println("프로그램 종료");
		//에러가 없으면 catch는 건너뜀 => 1234567종료
		//에러 발생시 catch 실행 후 다음 문장 => 123복구67종료 
		//예외처리 없을시 비정상 종료 => 123비정상종료(에러)
		//에러에 맞는 예외처리가 없을시 비정상종료 => 상속도 상위클래스로 예외처리 해주는게 많은 범위의 예외처리 가능
	}

}
