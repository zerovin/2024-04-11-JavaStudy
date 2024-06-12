package com.sist.client;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ControllPanel extends JPanel{
	CardLayout card=new CardLayout();
	BookListPanel bookListP=new BookListPanel();
	FindPanel findP=new FindPanel();
	BoardListPanel boardLP=new BoardListPanel();
	BoardInsertPanel boardIP=new BoardInsertPanel();
	public ControllPanel() {
		setLayout(card);
		add("BOOKLIST",bookListP);
		add("FIND", findP);
		add("BOARD", boardLP);
		add("BOARD_IN", boardIP);
	}
}
