package com.sist.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ClientMain extends JFrame implements ActionListener{
	public MenuPanel mp=new MenuPanel();
	public ControllerPanel cp=new ControllerPanel();
	public ClientMain() {
		//배치
		// North, South, West, East, Center => BorderLayout
		//add("North",mp); 
		//add("Center",cp);
		setLayout(null);
		mp.setBounds(170, 15, 600, 30);
		add(mp);
		cp.setBounds(0, 60, 800, 535);
		add(cp);
		
		//윈도우크기
		setSize(800, 600);
		setVisible(true);
		setResizable(false); // false = 리사이즈 금지, 최대화버튼 삭제 => 윈도우크기 고정
		setDefaultCloseOperation(EXIT_ON_CLOSE); //윈도우창 닫으면 메모리 회수, 프로그램 종료
		
		mp.b1.addActionListener(this); //b1버튼을 클릭하면 actionPerformed 호출
		mp.b2.addActionListener(this);
		mp.b6.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex) {}
		new ClientMain();
	}
	@Override
	public void actionPerformed(ActionEvent e) { //버튼처리 인터페이스 - 선언만하고 구현은 안된 상태
		// TODO Auto-generated method stub
		if(mp.b1==e.getSource()) { //b1버튼 클릭시
			cp.card.show(cp, "HOME");
		}else if(mp.b2==e.getSource()) { //b2버튼 클릭시
			cp.card.show(cp, "FIND");
		}else if(mp.b6==e.getSource()) {
			JOptionPane.showMessageDialog(this, "프로그램을 종료합니다"); //종료 모달창
			System.exit(0);			
		}
	}

}
