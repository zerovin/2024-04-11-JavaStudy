package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class ClientMain extends JFrame{
	CardLayout card=new CardLayout();
	LoginPanel loginP=new LoginPanel();
	MainPanel mainP=new MainPanel();
	JoinPanel joinP=new JoinPanel();
	public ClientMain() {
		setLayout(card);
		add("JOIN", joinP);
		add("MAIN", mainP);
		add("LOGIN",loginP);
		
		setSize(960, 750);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex) {}
		new ClientMain();
	}

}
