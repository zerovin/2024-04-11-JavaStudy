package com.sist.main;
/*
 *  문자열 2개를 받아
 *  정수 배열에 저장 ==> 정수변환(사용자 입력오류), 배열인덱스(프로그래머 실수)
 *  배열값 나누기해서 출력 ==> 사용자가 나누기 값 0을 입력할 경우
 *    1.예상되는 에러 3개
 *    2.기타 발생(예상 외 에러)
 *    ==> 예외처리 4개
 *        1)조건문으로 가능한지
 *        2)예외처리 - 예상되는 에러 도출 - catch 1개로 처리할지
 *                                   catch 에러별로 처리할지
 *    
 *  사전에 에러 방지할 수 있는 프로그램 제작이 중요
 *    ex) 웹 => 사용자 사이트 오류 발생 => 탈퇴
 *        배포 => 의뢰자가 일부러 오류 => 유지되는지 확인 => 안될시 통과X => 위약금
 *        --------방지를 위해 신입사원 교육을 타이트하게 하는 편 보통 Spring부터 교육
 * 
 */
import java.util.*;
public class 예외처리_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String s1="3";
			String s2="0";
			int n1=Integer.parseInt(s1);
			int n2=Integer.parseInt(s2); //error
			int[] arr= {n1,n2};
			System.out.println(arr[0]/arr[2]); //error
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 초과");
		}catch(NumberFormatException e) {
			System.out.println("정수 변환 오류");
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없다");
		}catch(Exception e) { // 반드시 큰 예외처리는 마지막에 처리
			System.out.println("예상하지 못한 에러 발생");
		}
	}

}
