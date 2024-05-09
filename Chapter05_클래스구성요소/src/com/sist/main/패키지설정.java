package com.sist.main;
//util 폴더 안의 여러개의 클래스 불러오기 *, 클래스 하나만 사용시 .클래스명
//Scanner, Calendar 둘다 사용할꺼
import java.util.*; 

//static 클래스 불어올 때는 import static
import static java.lang.Math.random; //Math.random() => 클래스명 없이 random() 으로 사용가능
import static java.lang.Math.max; //max(a,b)
import static java.lang.Math.min; //min(a,b)

public class 패키지설정 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=(int)(random()*100)+1;
		int b=(int)(random()*100)+1;
		System.out.println("최대값:"+max(a,b));
		System.out.println("최소값:"+min(a,b));
	}

}
