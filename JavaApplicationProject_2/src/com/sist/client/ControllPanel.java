package com.sist.client;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ControllPanel extends JPanel{
	CardLayout card=new CardLayout();
	HomePanel homeP=new HomePanel();
	BookListPanel bookListP=new BookListPanel();
	FindPanel findP=new FindPanel();
	BoardListPanel boardLP=new BoardListPanel();
	BoardInsertPanel boardIP=new BoardInsertPanel();
	ChatPanel chatP=new ChatPanel();
	MypagePanel myP=new MypagePanel();
	
	public ControllPanel() {
		setLayout(card);
		add("HOME", homeP);
		add("BOOKLIST",bookListP);
		add("FIND", findP);
		add("BOARD", boardLP);
		add("BOARD_IN", boardIP);
		add("CHAT", chatP);
		add("MYPAGE", myP);
	}
}
