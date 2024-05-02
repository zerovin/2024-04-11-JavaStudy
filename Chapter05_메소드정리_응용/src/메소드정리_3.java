
public class 메소드정리_3 {
	static void swap(int[] arr) { // 배열 => 메모리 주소 자체를 넘겨준다 => 같은 메모리 제어 => 원본변경
		System.out.println("변경 전 - arr[0]="+arr[0]+", arr[1]="+arr[1]);
		int temp=arr[0];
		arr[0]=arr[1];
		arr[1]=temp; //값 교환
		System.out.println("변경 후 - arr[0]="+arr[0]+", arr[1]="+arr[1]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Call By Reference => 메모리 주소전송(배열,클래스) => 해당 주소에 있는 원본 제어
		int[] temp= {100,200};
		swap(temp);
		System.out.println("main=>temp값 - temp[0]="+temp[0]+", temp[1]="+temp[1]); //원본변경
	}

}
