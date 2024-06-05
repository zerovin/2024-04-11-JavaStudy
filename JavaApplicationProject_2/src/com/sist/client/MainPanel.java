package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class MainPanel extends JPanel{
	MenuPanel menuP=new MenuPanel();
	ControllPanel ctrP=new ControllPanel();
	
	public MainPanel() {
		setLayout(new BorderLayout());
		add("North",menuP);
		add("Center", ctrP);
	}
}
