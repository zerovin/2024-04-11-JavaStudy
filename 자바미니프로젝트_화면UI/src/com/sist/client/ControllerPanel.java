package com.sist.client;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.*;
public class ControllerPanel extends JPanel{
	public CardLayout card=new CardLayout();
	public HomePanel hp=new HomePanel();
	public FindPanel fp=new FindPanel();
	public ControllerPanel() {
		setLayout(card);
		add("HOME",hp);
		add("FIND",fp);
	}
}
