package com.sist.util;
/*
 *  제네릭
 *  ClassName<클래스명> - Object를 지정한 클래스명으로 변경
 *                      ex) A<Integer>
 *   - 데이터형을 통일화 : 리턴형 / 매개변수를 한번에 프로그램에 맞게 한번에 변경
 *   - ArrayList는 이미 만들어져 있는 상태 => 프로그래머가 어떤 데이터형을 저장할지 모름 => 뭐든 넣을 수 있게 Object
 *                                  => 리턴형 / 매개변수 전부 Object => 데이터 사용시 형변환 후 사용 => 보완 => 제네릭
 *   - 소스가 간결해진다 => 형변환을 하지 않기 때문
 *   - 가독성이 좋다 => 어떤 데이터를 저장했는지 확인가능
 *      ex) ArrayList<String>, ArrayList<Music>, ArrayList<Movie>
 *   - 컬렉션에서 주로 사용
 *   
 *  데이터형을 변경할 수 있는 제네릭
 *   - <T> type => class
 *   - <E> element => class
 *   - <K> key
 *   - <V> value
 *   ex)
 *       class Box<T>{
 *          T t;
 *          public void setT(T t){
 *             this.t=t;
 *          }
 *          public T getT(){
 *             return t;
 *          }
 *       }
 *       ==> Box box=new Box() => T(Object)
 *       ==> Box<String> box=new Box<String>()
 *           =>  T=>String
 *     
 */
class Box<E>{
	E e;
	public void setE(E e) {
		this.e=e;
	}
	public E getE() {
		return e;
	}
}
public class 컬렉션_제네릭_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box box=new Box();
		
		//E=>String
		Box<String> boxs=new Box<String>();
		
	}

}
