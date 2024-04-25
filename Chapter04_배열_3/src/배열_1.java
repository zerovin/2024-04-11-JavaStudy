/*
 *	배열 - 같은 데이터형(용도가 같은 데이터) 여러개 데이터를 모아서 저장
 *	      고정적 단점
 *	      여러개의 데이터를 한 개의 이름으로 제어 - 인덱스(0번부터 시작)
 *        1)선언
 *          -데이터형[] 배열명;
 *          -데이터형 배열명[];
 *          -ex)
 *              정수 int[] arr
 *              실수 double[] arr
 *              문자 char[] arr
 *              문자열 String[] arr
 *              논리 boolean[] arr
 *        2)초기화
 *          -실제 값을 초기화
 *          -ex)
 *              int[] arr;
 *              arr=new int[]{1,2,3,4,5}
 *          -기본 값을 초기화
 *          -ex)
 *              int[] arr=new int[5]; => 자동으로 0으로 초기화
 *          -int[] => 0
 *          -double[] => 0.0
 *          -boolean[] => false
 *          -String[] => null(주소가 없는 상태)
 *          -long[] => 0L
 *          -char[] => '\0' => 공백
 *          *null - 모든 클래스에 저장(참조할 수 있는 주소가 없는 상태)
 *          **new 연산자 => malloc() 자주 사용 => 연산자로 승격
 *                        넘겨주는 값(주소 값 => int)
 *                        동적 메모리 할당(생성)
 *                        실행시마다 메모리 확보(메모리 따라 생성) => 메모리 주소가 다름 => 클래스에서 저장
 *            ex)
 *               int[] arr=new int[5];
 *               arr=[I@6f2b958e => 메모리 주소
 *                                  연속적인 메모리를 가지고 있다
 *                                  같은 크기의 메모리가 5개 생성
 *                                 arr[0]  arr[1]  arr[2]  arr[3]  arr[4]
 *                               => 인덱스 이용 => 실제 값 저장된 위치
 *               arr ===========> ----------------------------------------
 *                                   0   |   0   |   0   |   0   |   0
 *                               |----------------------------------------
 *                          [I@6f2b958e
 *                          => 주소를 이용해서 원하는 데이터에 접근하는 변수 => 참조변수(배열/클래스)
 *          변수/배열/클래스 - 한개만 저장(변수)/같은 데이터형 여러개 저장(배열)/다른 데이터형 여러개 저장(클래스)
 *          ex)
 *             학생 1명에 대한 정보
 *             1.이름 2.성별 3.학번 4.학년 5.주소 6.전화 7.나이...
 *             변수 = String name, sex;
 *                   int harbun;
 *                   int year;
 *                   String address;
 *                   String phone;
 *                   int age;
 *             학생 3명에 대한 정보
 *             변수 = String name1, name2, name3;
 *                   String sex1, sex2, sex3;
 *                   int hakbun1, hakbun2, hkbun3;
 *                   ...
 *             배열 => 하나하나 변수잡으면 제어가 어려우니 배열로
 *                   String[] name=new String[3];
 *                   String[] sex=new String[3];
 *                   int[] hakbun=new int[3];
 *             클래스 => 배열로 잡아도 많으니 클래스로
 *                   class Student{
 *                   	String name,sex,address,phone;
 *                      int hakbun,year,age;
 *                   }
 *                   클래스는 메모리를 원하는만큼 확보, 생성 가능
 *                   Student hong1=new Student();
 *                   Student hong2=new Student();
 *                   Student hong3=new Student();
 *                   ...
 *                   => 얘도 많아지면
 *                      Student[] std=new Student[1000];
 *        3)값 변경
 *          int[] arr={10,20,30,40,50}
 *          
 *          Stack(주소)                Heap(실제 데이터가 저장되는 영역)
 *                             [0]      [1]      [2]      [3]      [4]  
 *          arr ===========> --------------------------------------------
 *                              10   |   20   |   30   |   40   |   50
 *                          |--------------------------------------------
 *                       0x100     0x104    0x108    0x112    0x116
 *                          배열 변수는 시작 주소값만 가지고 있다
 *                          arr=0x100
 *                          arr[0] = 0x100주소의 첫번째 값
 *                          arr[1] = 0x100주소의 두번째 값
 *                          ...
 *          배열명[인덱스]=변경할 값;
 *          ex)
 *             세번째 값 변경 => arr[2]=100 => 30->100으로 변경
 *             마지막 값 변경 => arr[4]=500 => 50->500으로 변경
 *          *length - 개수
 *          배열 복사 - 얕은 복사 => 공유, 같은 영역 제어, 원본에 영향을 줌
 *                  - 깊은 복사 => 새로운 배열(주소) 생성 => clone();
 *        4)출력 for-each 
 * 
 */
public class 배열_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//new 사용시 각각의 새로운 메모리 주소 생성
		int[] a=new int[5];
		System.out.println(a); //[I@6f2b958e
		
		int[] a1=new int[5];
		System.out.println(a1); //[I@1eb44e46
		
		// 메소드 => Call By Reference
		// 얕은 복사
		System.out.println("===== 얕은 복사 =====");
		int[] arr= {10,20,30,40,50};
		int[] temp=arr; //데이터복사가 아니라 주소값 공유, 원본제어 가능
		// 배열은 메모리 주소를 이용 => 주소를 대입하면 => 별칭 => 같은 메모리 제어
		temp[0]=100;
		temp[1]=200;
		// arr[0]=100, arr[1]=200
		System.out.println("temp[0]="+temp[0]); //100
		System.out.println("temp[1]="+temp[1]); //200
		System.out.println("arr[0]="+arr[0]); //100
		System.out.println("arr[1]="+arr[1]); //200
		
		// 깊은 복사
		System.out.println("===== 깊은 복사 =====");
		int[] arr2= {10,20,30,40,50};
		int[] temp2=arr.clone(); // 새로운 배열 생성
		// 설정된 그대로 복사 => 새로운 배열을 생성 => clone => 깊은 복사
		temp2[0]=100;
		temp2[1]=200;
		System.out.println("temp2[0]="+temp2[0]); //100
		System.out.println("temp2[1]="+temp2[1]); //200
		System.out.println("arr2[0]="+arr2[0]); //10
		System.out.println("arr2[1]="+arr2[1]); //20
		
		System.out.println("arr="+arr);
		System.out.println("temp="+temp); // 얕은 복사 - 같은 주소
		System.out.println("temp2="+temp2); // 깊은 복사 - 새로운 주소
		
		// 배열 = 메모리 주소 => 원본이 변경될 수 있다 => 깊은 복사가 안전
		// 주소값은 대입 가능
	}

}
