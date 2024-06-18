package com.sist.client;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ControllPanel extends JPanel{
	CardLayout card=new CardLayout();
	HomePanel homeP;
	BookDetailPanel bookDP;
	BookListPanel bookListP=new BookListPanel();
	FindPanel findP;
	BoardListPanel boardLP=new BoardListPanel();
	BoardInsertPanel boardIP=new BoardInsertPanel();
	ChatPanel chatP=new ChatPanel();
	MypagePanel myP=new MypagePanel();
	
	public ControllPanel() {
		setLayout(card);
		homeP=new HomePanel(this);
		bookDP=new BookDetailPanel(this);
		findP=new FindPanel(this);
		//add("BOOKLIST",bookListP);
		add("HOME", homeP);
		add("DETAIL", bookDP);
		add("FIND", findP);
		add("BOARD", boardLP);
		add("BOARD_IN", boardIP);
		add("CHAT", chatP);
		add("MYPAGE", myP);
	}
}
