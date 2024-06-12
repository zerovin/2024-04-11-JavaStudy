package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class BoardDetailPanel extends JPanel{
	JLabel la1,la2,la3,la4,la5,la6;
	JLabel name,no,sub,day,hit;
	JTextArea ta;
    JButton b1,b2,b3;
    
    public BoardDetailPanel() {
       setLayout(null);
    	
       la1=new JLabel("게시글",JLabel.CENTER);
       la1.setFont(new Font("맑은 고딕",Font.BOLD,25));
       la1.setBounds(110,20,500,40);
  	   add(la1);
  	   
  	   la2=new JLabel("번호",JLabel.CENTER);
  	   la2.setBounds(80, 75, 80, 30);
  	   no=new JLabel("",JLabel.CENTER);
	   no.setBounds(95, 75, 120, 30);
	   add(la2);add(no);
  	 
  	   la3=new JLabel("조회수",JLabel.CENTER);
  	   la3.setBounds(350, 75 , 80, 30);
  	   day=new JLabel("",JLabel.CENTER);
  	   day.setBounds(305, 75, 200, 30);
  	   add(la3);add(day);
  	 
  	   la4=new JLabel("작성자",JLabel.CENTER);
  	   la4.setBounds(85, 110 , 80, 30);
  	   name=new JLabel("",JLabel.CENTER);
  	   name.setBounds(95, 110, 120, 30);
  	   add(la4);add(name);
  	 
  	   la5=new JLabel("작성일",JLabel.CENTER);
  	   la5.setBounds(350, 110 , 80, 30);
  	   hit=new JLabel("",JLabel.CENTER);
  	   hit.setBounds(305, 110, 200, 30);
  	   add(la5);add(hit);
  	 
  	   la6=new JLabel("제목",JLabel.CENTER);
  	   la6.setBounds(80, 145 , 80, 30);
  	   sub=new JLabel("");
  	   sub.setBounds(95, 145, 400, 30);
  	   add(la6);add(sub);
  	   
  	   ta=new JTextArea();
  	   ta.setEditable(false); // 비활성화 
  	   ta.setBounds(100, 190, 550, 250);
  	   add(ta); 
  	   
  	   JPanel p=new JPanel();
  	   b1=new JButton("수정");
  	   b2=new JButton("목록");
  	   b3=new JButton("삭제");
  	   p.add(b1);p.add(b2);p.add(b3);
  	   p.setBounds(130, 460, 485, 35);
  	   add(p);
    }
}