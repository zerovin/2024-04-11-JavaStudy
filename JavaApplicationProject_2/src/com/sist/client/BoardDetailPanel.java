package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class BoardDetailPanel extends JPanel{
	JLabel titleLa,noLa,hitLa,nameLa,dayLa,subLa;
	JLabel name,no,sub,day,hit;
	JTextArea ta;
    JButton editBtn,listBtn,delBtn;
    
    public BoardDetailPanel() {
       setLayout(null);
    	
       titleLa=new JLabel("게시글",JLabel.CENTER);
       titleLa.setFont(new Font("맑은 고딕",Font.BOLD,25));
       titleLa.setBounds(110,20,500,40);
  	   add(titleLa);
  	   
  	   noLa=new JLabel("번호",JLabel.CENTER);
  	   noLa.setBounds(80, 75, 80, 30);
  	   no=new JLabel("",JLabel.CENTER);
	   no.setBounds(95, 75, 120, 30);
	   add(noLa);add(no);
  	 
  	   hitLa=new JLabel("조회수",JLabel.CENTER);
  	   hitLa.setBounds(350, 75 , 80, 30);
  	   day=new JLabel("",JLabel.CENTER);
  	   day.setBounds(305, 75, 200, 30);
  	   add(hitLa);add(day);
  	 
  	   nameLa=new JLabel("작성자",JLabel.CENTER);
  	   nameLa.setBounds(85, 110 , 80, 30);
  	   name=new JLabel("",JLabel.CENTER);
  	   name.setBounds(95, 110, 120, 30);
  	   add(nameLa);add(name);
  	 
  	   dayLa=new JLabel("작성일",JLabel.CENTER);
  	   dayLa.setBounds(350, 110 , 80, 30);
  	   hit=new JLabel("",JLabel.CENTER);
  	   hit.setBounds(305, 110, 200, 30);
  	   add(dayLa);add(hit);
  	 
  	   subLa=new JLabel("제목",JLabel.CENTER);
  	   subLa.setBounds(80, 145 , 80, 30);
  	   sub=new JLabel("");
  	   sub.setBounds(95, 145, 400, 30);
  	   add(subLa);add(sub);
  	   
  	   ta=new JTextArea();
  	   ta.setEditable(false); // 비활성화 
  	   ta.setBounds(100, 190, 550, 250);
  	   add(ta); 
  	   
  	   JPanel p=new JPanel();
  	   editBtn=new JButton("수정");
  	   listBtn=new JButton("목록");
  	   delBtn=new JButton("삭제");
  	   p.add(editBtn);p.add(listBtn);p.add(delBtn);
  	   p.setBounds(130, 460, 485, 35);
  	   add(p);
    }
}