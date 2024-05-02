// 3명의 학생 국어,영어,수학 => 총점,평균,학점,등수
// 절차적 => 메소드화
import java.util.*;
public class 메소드정리_5 {
	//입력, 총점, 평균, 학점
	static void input(int[] kor, int[] eng, int[] math, int[] total, double[] avg, char[] score) {
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<kor.length;i++) {
			//1.입력			
			System.out.print((i+1)+"번째 국어 >> ");
			kor[i]=scan.nextInt();
			System.out.print((i+1)+"번째 영어 >> ");
			eng[i]=scan.nextInt();
			System.out.print((i+1)+"번째 수학 >> ");
			math[i]=scan.nextInt();
			
			//2. 총점
			total[i]=kor[i]+eng[i]+math[i];
			//3. 평균
			avg[i]=total[i]/3.0;
			//4. 학점
			switch(total[i]/30) {
				case 10: case 9:
					score[i]='A';
					break;
				case 8:
					score[i]='B';
					break;
				case 7:
					score[i]='C';
					break;
				case 6:
					score[i]='D';
					break;
				default:
					score[i]='F';
			}
		}
	}
	//등수
	static void rankChange(int[] total, int[] rank) {
		for(int i=0;i<total.length;i++) { 
			rank[i]=1;
			for(int j=0;j<total.length;j++) {
				if(total[i]<total[j]) {
					rank[i]++;
				}
			}
		}
	}
	//출력
	static void print(int[] kor, int[] eng, int[] math, int[] total, double[] avg, char[] score, int[] rank) {
		for(int i=0;i<3;i++) {
			System.out.println(kor[i]+" "+eng[i]+" "+math[i]+" "+total[i]+" "+avg[i]+" "+score[i]+" "+rank[i]);
		}
	}
	//조립
	static void process() {
		int[] kor=new int[3];
		int[] eng=new int[3];
		int[] math=new int[3];
		int[] total=new int[3];
		double[] avg=new double[3];
		int[] rank=new int[3];
		char[] score=new char[3];
		
		input(kor,eng,math,total,avg,score);
		rankChange(total,rank);
		print(kor,eng,math,total,avg,score,rank);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		int[] kor=new int[3];
		int[] eng=new int[3];
		int[] math=new int[3];
		int[] total=new int[3];
		double[] avg=new double[3];
		int[] rank=new int[3];
		char[] score=new char[3];
		
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<kor.length;i++) {
			//1.입력			
			System.out.print((i+1)+"번째 국어 >> ");
			kor[i]=scan.nextInt();
			System.out.print((i+1)+"번째 영어 >> ");
			eng[i]=scan.nextInt();
			System.out.print((i+1)+"번째 수학 >> ");
			math[i]=scan.nextInt();
			
			//2. 총점
			total[i]=kor[i]+eng[i]+math[i];
			//3. 평균
			avg[i]=total[i]/3.0;
			//4. 학점
			switch(total[i]/30) {
				case 10: case 9:
					score[i]='A';
					break;
				case 8:
					score[i]='B';
					break;
				case 7:
					score[i]='C';
					break;
				case 6:
					score[i]='D';
					break;
				default:
					score[i]='F';
			}
		}
		//5. 등수
		for(int i=0;i<total.length;i++) { 
			rank[i]=1;
			for(int j=0;j<total.length;j++) {
				if(total[i]<total[j]) {
					rank[i]++;
				}
			}
		}
		//6.출력
		for(int i=0;i<3;i++) {
			System.out.println(kor[i]+" "+eng[i]+" "+math[i]+" "+total[i]+" "+avg[i]+" "+score[i]+" "+rank[i]);
		}
		*/
		
		process();
	}

}
