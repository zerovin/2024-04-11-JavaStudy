package com.sist.client;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ControllPanel extends JPanel{
	CardLayout card=new CardLayout();
	BookListPanel bookListP=new BookListPanel();
	FindPanel findP=new FindPanel();
	public ControllPanel() {
		setLayout(card);
		add("BOOKLIST",bookListP);
		add("FIND", findP);
	}
}
