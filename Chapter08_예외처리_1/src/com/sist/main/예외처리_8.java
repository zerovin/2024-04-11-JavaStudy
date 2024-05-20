package com.sist.main;
// finally
/*
 *  예외처리
 *    try{
 *       정상수행 코드 => 에러발생가능
 *    }catch(예외처리클래스){
 *       에러에 대한 대비 => 사전 에러 방지 => 에러 복구 ex)다시입력, continue
 *    }catch(예외처리클래스){
 *       에러에 대한 대비 => 사전 에러 방지 => 에러 복구 ex)다시입력, continue
 *    }finally{  => 생략가능, 필요시에만 사용
 *       파일닫기 / 서버닫기 / 오라클닫기 => 주로 닫기에 사용 ===> 안닫으면 DDOS
 *       => try 수행, catch 수행 상관없이 무조건 수행
 *    }
 *    
 *  진행순서
 *    문장1
 *    문장2
 *    try{
 *       문장3
 *       문장4
 *       문장5
 *    }catch(예외처리 클래스){
 *       문장6 => 에러발생시에만 수행
 *    }
 *    finally{ => 필요시에만 사용
 *       문장7 => 에러여부와 상관없이 무조건 수행
 *    }
 *    => 에러가 없을 시 1-2-3-4-5-7-종료 => catch절 제외
 *       에러가 있을 시(문장2) 1-종료 => try~catch 전에 에러발생시 예외처리 안한 것과 같은 상황
 *       에러가 있을 시(문장4) 1-2-3-6-7-종료 => try절에서 에러발생시 에러발생지점에서 catch로 이동 후 finally 수행 
 */
public class 예외처리_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 에러가 없는 상태
		System.out.println("1");
		//System.out.println(10/2); //에러 발생시 1 -> 에러 -> 종료
		System.out.println("2");
		try {
			System.out.println("3");
			System.out.println(10/0); // catch로 이동 1-2-3-에러-6-7-종료
			System.out.println("5");
		}catch(Exception e) {
			System.out.println("에러처리 => 6"); //에러 확인 => printStackTrace(), getMessage()
		}finally {
			System.out.println("7"); //ex)파일닫기, 오라클닫기 => 서버 부하가 심하다 => 주로 닫기, 닫을 거 없으면 생략
		}
	}

}
