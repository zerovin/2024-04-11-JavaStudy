package com.sist.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//메소드정리_응용 > 메소드정리_4 야구게임 예외처리
public class 예외처리_응용2 extends JFrame implements ActionListener{
	JTextField tf;
	JButton b1,b2; 
	JTextArea ta=new JTextArea("");
	int s, b;
	
	int[] com=new int[3];
	int[] user=new int[3];
	
	public 예외처리_응용2() {
		tf=new JTextField();
		b1=new JButton("시작");
		b2=new JButton("종료");
		
		//배치
		setLayout(null);
		tf.setBounds(10, 15, 150, 30);
		tf.setEnabled(false); //비활성화
		add(tf);
		
		b1.setBounds(165, 15, 100, 30);
		add(b1);
		b2.setBounds(270, 15, 100, 30);
		add(b2);
		
		ta.setEditable(false);
		JScrollPane js=new JScrollPane(ta);
		js.setBounds(10, 55, 360, 300);
		add(js);
		
		//윈도우 크기
		setSize(400, 400);
		setVisible(true);
		
		//버튼 클릭
		b1.addActionListener(this); 
		b2.addActionListener(this);
		tf.addActionListener(this);
	}
	public void getRand() {
		for(int i=0;i<com.length;i++) {
			com[i]=(int)(Math.random()*9)+1; 
			//중복체크
			for(int j=0;j<i;j++) {
				if(com[i]==com[j]) {
					i--; 
					break;
				}
			}
		}
	}
	public void compare() {
		s=0; b=0;
		for(int i=0;i<com.length;i++) {
			for(int j=0;j<user.length;j++) {
				if(com[i]==user[j]) { //같은 수가 있는지
					if(i==j) { //같은 자리인지
						s++; //같은 자리
					}else {
						b++; //다른 자리
					}
				}
			}
		}
		String msg="Input Number:"+user[0]+""+user[1]+""+user[2]+", Result:"+s+"S-"+b+"B\n";
		ta.append(msg);
		
		if(s==3) {
			int no=JOptionPane.showConfirmDialog(this, "종료할까요?", "종료", JOptionPane.YES_NO_OPTION);
			//showConfirmDialog(위치, 멘트, title, 버튼형식);
			if(no==JOptionPane.YES_OPTION) {
				System.exit(0); //종료
			}else { //다시시작 => 초기상태
				tf.setText("");
				tf.setEnabled(false);
				b1.setEnabled(true);
				ta.setText("");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 예외처리_응용2();
	}
	

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
			ta.setText("");
		}else if(e.getSource()==tf) { //입력 후 enter를 쳤다면
			String no=tf.getText();
			try {
				int input=Integer.parseInt(no);
				if(input<100 || input>999) { // || => 범위를 벗어난 경우
					JOptionPane.showMessageDialog(this, "세자리 정수만 사용이 가능합니다");
					tf.setText("");
					tf.requestFocus();
					return;
				}
				user[0]=input/100;
				user[1]=input%100/10;
				user[2]=input%10;
				
				//오류처리-중복
				if(user[0]==user[1] || user[1]==user[2] || user[0]==user[2]) {
					JOptionPane.showMessageDialog(this, "같은 수는 사용할 수 없습니다");
					tf.setText("");
					tf.requestFocus();
					return;
				}
				//오류처리-0사용
				if(user[0]==0 || user[1]==0 || user[2]==0) {
					JOptionPane.showMessageDialog(this, "0은 사용할 수 없습니다");
					tf.setText("");
					tf.requestFocus();
					return;
				}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "정수만 입력이 가능합니다!!");
				tf.setText("");
				tf.requestFocus();
				return;
			}
		}
		compare();
		tf.setText("");
		tf.requestFocus();
	}

}
