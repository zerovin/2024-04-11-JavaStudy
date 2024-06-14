package com.sist.client;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class ChatPanel extends JPanel{
	public ChatPanel() {
		JLabel chatTitle;
		JTextArea chatTextArea;
		JTextField chatWrite;
		JComboBox chatColor;
		String[] color= {"Black","Red","Green","Blue","Cyan","Dark gray","Light gray", "Magenta", "Orange", "Pink"};
		JButton chatLetter, chatInfo;
		JTable chatPeople;
		DefaultTableModel chatPeopleData;

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
}
