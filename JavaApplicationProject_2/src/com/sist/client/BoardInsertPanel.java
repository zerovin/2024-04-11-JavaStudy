package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class BoardInsertPanel extends JPanel{
   JLabel titleLa,nameLa,pwdLa,typeLa,subLa,contLa;
   JButton sbmBtn,listBtn;
   JTextField subTf,nameTf;
   JTextArea ta;
   JPasswordField pf;
   String[] List= {"예시 1", "예시 2", "예시 3"};
   JComboBox ListCombo;
   
   public BoardInsertPanel() {
	  setLayout(null);
	  
      titleLa=new JLabel("글쓰기",JLabel.CENTER);
      titleLa.setFont(new Font("맑은 고딕",Font.BOLD,25));
      titleLa.setBounds(110,25,500,40);
	  add(titleLa);
      
      nameLa=new JLabel("이름");
      nameTf=new JTextField();
      nameLa.setBounds(100, 80, 50, 30);
      nameTf.setBounds(140, 80, 110, 30);
      add(nameLa);
      add(nameTf);
      
      pwdLa=new JLabel("비밀번호");
      pf=new JPasswordField();
      pwdLa.setBounds(275, 80, 90, 30);
      pf.setBounds(335, 80, 140, 30);
      add(pwdLa);
      add(pf);
      
      typeLa=new JLabel("분류");
      ListCombo=new JComboBox(List);
      typeLa.setBounds(500, 80, 80, 30);
      ListCombo.setBounds(535, 82, 90, 30);
      add(typeLa);
      add(ListCombo);
      
      subLa=new JLabel("제목");
      subTf=new JTextField();
      subLa.setBounds(100, 120, 50, 30);
      subTf.setBounds(140, 120, 489, 30);
      add(subLa);
      add(subTf);
      
      contLa=new JLabel("내용"); 
      ta=new JTextArea();
      ta.setBounds(145, 168, 470, 265);
      contLa.setBounds(100, 168, 80, 30);
      add(contLa);
      add(ta);
      JScrollPane scrollPane = new JScrollPane(ta);
      scrollPane.setBounds(145, 170, 480, 265); 
      add(scrollPane);
      
      sbmBtn=new JButton("등록");
      listBtn=new JButton("목록");
      
      JPanel p=new JPanel();
      p.setBounds(220,455,300,35);
      add(p);
      p.add(sbmBtn);
      p.add(listBtn);
     
      Dimension buttonSize = new Dimension(70, 30);
      sbmBtn.setPreferredSize(buttonSize);
      listBtn.setPreferredSize(buttonSize);
   }

}