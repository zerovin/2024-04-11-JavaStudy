package com.sist.main;
//UpDown Game
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //interface
public class 예외처리_응용 extends JFrame implements ActionListener{
	//예외처리_응용 => 윈도우 확장 => 단일상속이 기본
	JTextField tf;
	JButton b1,b2; //선언
	JLabel la=new JLabel("", JLabel.CENTER); //명시적 초기화
	
	//전체변수(멤버변수) => 메소드 2개이상에서 사용, 하나에서만 사용할거면 지역변수
	//1.입력값 받을 때, 2. 비교할 때
	//처리는 입력 후 엔터시 => 입력값 받고 비교 => 결과값 출력
	int com; //난수
	int user; //사용자 입력값
	
	//클래스도 변수(객체) => 변수(기본형, 배열, 클래스) 멤버변수로 사용가능
	//초기화, 화면UI, 서버연결 => 생성자에서 주로 처리
	public 예외처리_응용() {
		tf=new JTextField();
		b1=new JButton("시작");
		b2=new JButton("종료");
		
		//배치
		setLayout(null);
		tf.setBounds(10, 15, 150, 30);
		tf.setEnabled(false); //비활성화
		//윈도우에 추가
		add(tf);
		
		b1.setBounds(165, 15, 100, 30);
		add(b1);
		b2.setBounds(270, 15, 100, 30);
		add(b2);
		
		la.setBounds(10, 55, 360, 30);
		add(la);
		
		//윈도우 크기
		setSize(400, 135);
		setVisible(true);
		
		//버튼 클릭 => 등록 => 메소드 자동 호출
		b1.addActionListener(this); //actionPerformed 위치 => class 예외처리_응용 =>this 
		b2.addActionListener(this);
		tf.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 생성자 호출
		new 예외처리_응용();
	}
	public void getRand() {
		com=(int)(Math.random()*100)+1;
	}
	public void compare() {
		if(com>user) {
			la.setText("입력값보다 큰 값을 입력하세요");
			tf.setText("");
			tf.requestFocus();
		}else if(com<user){
			la.setText("입력값보다 작은 값을 입력하세요");
			tf.setText("");
			tf.requestFocus();
		}else {
			int no=JOptionPane.showConfirmDialog(this, "종료할까요?", "종료", JOptionPane.YES_NO_OPTION);
			//showConfirmDialog(위치, 멘트, title, 버튼형식);
			if(no==JOptionPane.YES_OPTION) {
				System.exit(0); //종료
			}else { //다시시작 => 초기상태
				tf.setText("");
				tf.setEnabled(false);
				b1.setEnabled(true);
				la.setText("");
			}
		}
	}
	//버튼, JTextField(Enter)처리 => 고정 => 구현없이 선언만해서 넘겨주면 프로그램에 맞게 구현해서 사용  
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2) { //종료버튼 클릭했다면
			System.exit(0);
		}else if(e.getSource()==b1) { //시작버튼 클릭시
			getRand(); //com에 난수 발생
			JOptionPane.showMessageDialog(this, "게임을 시작합니다!!"); //this 현 윈도우창 위에 띄우기
			tf.setEnabled(true);
			tf.requestFocus(); //focus
			b1.setEnabled(false); //시작버튼 비활성화
		}else if(e.getSource()==tf) { //입력 후 enter를 쳤다면
			String no=tf.getText();
			//예외처리 => 에러 출력은 하지 않고 프로그램 정상 유지, 종료목적X
			//예외처리는 클래스 블록에서는 사용불가 => 초기화블록, 메소드, 생성자에서만 사용가능
			try {
				user=Integer.parseInt(no);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "정수만 입력이 가능합니다!!");
				tf.setText("");
				tf.requestFocus();
				
				//다시 처음부터 동작
				return; //메소드에서 return 사용시 => 메소드 종료
				//메소드는 return이 있는 곳에서 종료
				//return은 항상 마지막 줄에 있는 것은 아니다
				//마지막이 아닌 곳에서 종료 원할시는 return 생략 불가 
			}
			
			//비교
			compare();
		}
		//void 일 때 자동추가되는 return 자리는 제일 마지막 위치
	}

}
