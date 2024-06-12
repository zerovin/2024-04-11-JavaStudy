package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class BoardUpdatePanel extends JPanel{
   JLabel la1,la2,la3,la4,la5,la6;
   JButton b1,b2,b3;
   JTextField tf1,tf2;
   JTextArea ta;
   JPasswordField pf;
   String[] List= {"예시 1", "예시 2", "예시 3"};
   JComboBox ListCombo;
   
   public BoardUpdatePanel() {
	  setLayout(null);
	  
      la1=new JLabel("수정하기",JLabel.CENTER);
      la1.setFont(new Font("맑은 고딕",Font.BOLD,25));
      la1.setBounds(125,25,500,40);
	  add(la1);
      
      la2=new JLabel("이름");
      tf2=new JTextField();
      la2.setBounds(100, 80, 50, 30);
      tf2.setBounds(140, 80, 110, 30);
      add(la2);
      add(tf2);
      
      la3=new JLabel("비밀번호");
      pf=new JPasswordField();
      la3.setBounds(275, 80, 90, 30);
      pf.setBounds(335, 80, 140, 30);
      add(la3);
      add(pf);
      
      la4=new JLabel("분류");
      ListCombo=new JComboBox(List);
      la4.setBounds(500, 80, 80, 30);
      ListCombo.setBounds(535, 82, 90, 30);
      add(la4);
      add(ListCombo);
      
      la5=new JLabel("제목");
      tf1=new JTextField();
      la5.setBounds(100, 120, 50, 30);
      tf1.setBounds(140, 120, 489, 30);
      add(la5);
      add(tf1);
      
      la6=new JLabel("내용"); 
      ta=new JTextArea();
      ta.setBounds(145, 168, 470, 265);
      la6.setBounds(100, 168, 80, 30);
      add(la6);
      add(ta);
      JScrollPane scrollPane = new JScrollPane(ta);
      scrollPane.setBounds(145, 170, 480, 265); 
      add(scrollPane);
      
      b1=new JButton("수정");
      b2=new JButton("목록");
      //b3=new JButton("삭제");
      
     
      JPanel p=new JPanel();
      p.setBounds(220,455,300,35);
      add(p);
      p.add(b1);
      p.add(b2);
      //p.add(b3);
      
      Dimension buttonSize = new Dimension(70, 30);
      b1.setPreferredSize(buttonSize);
      b2.setPreferredSize(buttonSize);
      //b3.setPreferredSize(buttonSize);

   }
   
}