package com.sist.main4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//1.윈도우 상속
//2.인터페이스 상속
/*
 *  인터페이스 - 이벤트와 관련
 *  1.JButton(Click), JRadioButton(Click), JMenu(Click), JTextField(Enter)
 *    => ActionListener - actionPerformed()
 *  2.MouseListener
 *    => mouseClicked / mousePressed / mouseReleased / mouseExited / mouseEntered
 *  3.KeyListener
 *    => keyTyped / keyPressed / keyReleased
 */
public class 퍼즐게임 extends JFrame implements ActionListener{
	/*
	 *  1.기본초기화
	 *    int 0, double 0.0, boolean false, 모든 클래스 null
	 *  2.명시적인 초기화 => 가능한지 우선 고려
	 *  3.초기화 블록 => 명시적 초기화가 안될 시
	 *  4.생성자 => 명시적 초기화가 안될 시
	 */
	JButton[] btns=new JButton[9];
	JLabel la=new JLabel("퍼즐 게임", JLabel.CENTER); //명시적 초기화
	JButton b1,b2;
	
	//초기화
	public 퍼즐게임() {
		//초기화 + 화면UI
		b1=new JButton("시작");
		b2=new JButton("종료");
		
		JPanel pan=new JPanel();
		pan.setLayout(new GridLayout(3, 3, 5, 5)); //rows, cols, 상하, 좌우 / 같은 크기의 버튼
		for(int i=0;i<btns.length;i++) {
			btns[i]=new JButton(String.valueOf(i+1));
			//윈도우, 네트워크, 웹의 데이터형은 다 String => 정수입력X => valueOf 정수를 문자열로 변환
			pan.add(btns[i]);
		}
		JPanel p=new JPanel();
		p.add(b1);
		p.add(b2); //일자배치 => JPanel(FlowLayOut) / html div처럼 한묶음으로 묶음
		
		setLayout(null);
		
		la.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		la.setBounds(10, 15, 450, 40); //사용자 정의 배치 => 직접 배치
		add(la); //윈도우에 첨부
		
		pan.setBounds(10, 65, 450, 330);
		add(pan);
		
		p.setBounds(10, 400, 450, 35);
		add(p);
		
		setSize(500, 500);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 퍼즐게임();
	}

	//버튼 처리 / 메뉴 처리 / enter 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
