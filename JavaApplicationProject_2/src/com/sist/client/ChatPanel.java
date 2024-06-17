package com.sist.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

import java.util.*;
public class ChatPanel extends JPanel{
		JTextPane pane;
		JTextField tf;
		JComboBox<String> box1, box2;
		JTable table;
		DefaultTableModel model;
		JButton b1, b2;
		JScrollBar bar;
		
		public ChatPanel() {
			setLayout(null);
			pane=new JTextPane();
			JScrollPane js1=new JScrollPane(pane);
			js1.setBounds(10, 15, 480, 570);
			add(js1);
			bar=js1.getVerticalScrollBar();
			pane.setEditable(false);
			
			tf=new JTextField();
			tf.setBounds(10, 590, 380, 30);
			add(tf);
			
			
			box1=new JComboBox<String>();
			box1.addItem("black");
			box1.addItem("cyan");
			box1.addItem("yellow");
			box1.addItem("blue");
			box1.addItem("magenta");
			box1.addItem("green");
			box1.addItem("pink");
			box1.addItem("orange");
			
			box1.setBounds(395, 590, 100, 30);
			add(box1);
			
			String[] col={"ID", "이름", "성별"};
			String[][] row=new String[0][3];
			model=new DefaultTableModel(row, col) {
				@Override
				public boolean isCellEditable(int row, int column) {
					// TODO Auto-generated method stub
					return false;
				}
			};
			table=new JTable(model);
			JScrollPane tableJs=new JScrollPane(table);
			tableJs.setBounds(510, 15, 400, 400);
			add(tableJs);
			
			box2=new JComboBox<String>();
			box2.setBounds(510, 425, 100, 30);
			add(box2);
			
			b1=new JButton("1:1상담");
			b1.setBounds(620, 425, 120, 30);
			add(b1);
			b2=new JButton("정보보기");
			b2.setBounds(745, 425, 100, 30);
			add(b2);
		}
		
		public void initStyle(){
		   Style green=pane.addStyle("green", null);
		   StyleConstants.setForeground(green, Color.green);
		   
		   Style yellow=pane.addStyle("yellow", null);
		   StyleConstants.setForeground(yellow, Color.yellow);
		   
		   Style blue=pane.addStyle("blue", null);
		   StyleConstants.setForeground(blue, Color.blue);
		   
		   Style pink=pane.addStyle("pink", null);
		   StyleConstants.setForeground(pink, Color.pink);
		   
		   Style cyan=pane.addStyle("cyan", null);
		   StyleConstants.setForeground(cyan, Color.cyan);
		   
		   Style orange=pane.addStyle("orange", null);
		   StyleConstants.setForeground(orange, Color.orange);
		   
		   Style magenta=pane.addStyle("magenta", null);
		   StyleConstants.setForeground(magenta, Color.magenta);
	       
		   Style red=pane.addStyle("red", null);
		   StyleConstants.setForeground(red, Color.red); //알림
		   
		   Style gray=pane.addStyle("gray", null);
		   StyleConstants.setForeground(red, Color.gray); //귓속말
		}
		
		//TextPane의 단점 - 문자열 결합 불가 => setText() => append로 문자열 결합
		public void append(String msg, String color) {
			try {
				Document doc=pane.getDocument();
				doc.insertString(doc.getLength(), msg+"\n", pane.getStyle(color));				
			}catch(Exception ex) {}
		}

	/*
		JLabel chatTitle;
		JTextArea chatTextArea;
		JTextField chatWrite;
		JComboBox chatColor;
		String[] color= {"Black", "Green","Blue","Cyan","Dark gray","Light gray", "Magenta", "Orange", "Pink"};
		JButton chatLetter, chatInfo;
		JTable chatPeople;
		DefaultTableModel chatPeopleData;
		public ChatPanel() {
		
		//title
		chatTitle=new JLabel("실시간 채팅", JLabel.CENTER);
		chatTitle.setFont(new Font("맑은 고딕",Font.BOLD,25));
		chatTitle.setBounds(10,40,940,40);
		add(chatTitle);
		
		//textarea
		chatTextArea=new JTextArea();
		chatWrite=new JTextField();
		chatColor=new JComboBox(color);
		
		setLayout(null);
		
		chatTextArea.setBounds(30, 110, 600, 500);
		add(chatTextArea);
		
		chatWrite.setBounds(30, 620, 480, 30);
		add(chatWrite);
		
		chatColor.setBounds(520, 620, 110, 30);
		add(chatColor);
		
		//table
		String[] col={"아이디","이름"};
		String[][] row=new String[0][2];
		chatPeopleData=new DefaultTableModel(row, col);
		chatPeople=new JTable(chatPeopleData);
		JScrollPane chatTable=new JScrollPane(chatPeople);
		chatTable.setBounds(650, 110, 230, 500);
		add(chatTable);
		
		//table button
		chatLetter=new JButton("1:1 채팅");
		chatInfo=new JButton("정보보기");
		JPanel chatTableBtn=new JPanel();
		chatTableBtn.add(chatLetter);
		chatTableBtn.add(chatInfo);
		chatTableBtn.setBounds(650, 620, 230, 30);
		add(chatTableBtn);	
	}
	*/
	 
}
