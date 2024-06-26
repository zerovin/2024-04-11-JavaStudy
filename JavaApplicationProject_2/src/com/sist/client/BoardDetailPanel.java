package com.sist.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sist.dao.*;
public class BoardDetailPanel extends JPanel implements ActionListener{
	JLabel titleLa, nameLa, noLa, subLa, dayLa, hitLa;
	JLabel name, no, sub, day, hit;
	JTextArea ta;
	JButton b1, b2, b3; //수정, 삭제, 목록
	ControllPanel ctrP;
	BoardDAO dao;
	
	public BoardDetailPanel(ControllPanel ctrP) {
		this.ctrP=ctrP;
		dao=BoardDAO.newInstance();
		titleLa=new JLabel("게시판",JLabel.CENTER); 
		titleLa.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		setLayout(null);
		titleLa.setBounds(120, 15, 620, 50);
		add(titleLa);
		
		noLa=new JLabel("번호",JLabel.CENTER);
		noLa.setOpaque(true);
		noLa.setBackground(new Color(75, 255, 247));
		noLa.setBounds(120, 75, 80, 30);
		no=new JLabel("",JLabel.CENTER);
		no.setBounds(205, 75, 120, 30);
		add(noLa);
		add(no);
		
		dayLa=new JLabel("작성일",JLabel.CENTER);
		dayLa.setOpaque(true);
		dayLa.setBackground(new Color(75, 255, 247));
		dayLa.setBounds(330, 75, 80, 30);
		day=new JLabel("",JLabel.CENTER);
		day.setBounds(415, 75, 200, 30);
		add(dayLa);
		add(day);
		
		nameLa=new JLabel("이름",JLabel.CENTER);
		nameLa.setOpaque(true);
		nameLa.setBackground(new Color(75, 255, 247));
		nameLa.setBounds(120, 110, 80, 30);
		name=new JLabel("",JLabel.CENTER);
		name.setBounds(205, 110, 120, 30);
		add(nameLa);
		add(name);
		
		hitLa=new JLabel("조회수",JLabel.CENTER);
		hitLa.setOpaque(true);
		hitLa.setBackground(new Color(75, 255, 247));
		hitLa.setBounds(330, 110, 80, 30);
		hit=new JLabel("",JLabel.CENTER);
		hit.setBounds(415, 110, 200, 30);
		add(hitLa);
		add(hit);
		
		subLa=new JLabel("제목",JLabel.CENTER);
		subLa.setOpaque(true);
		subLa.setBackground(new Color(75, 255, 247));
		subLa.setBounds(120, 145, 80, 30);
		sub=new JLabel("");
		sub.setBounds(205, 145, 400, 30);
		add(subLa);
		add(sub);
		
		ta=new JTextArea();
		ta.setEditable(false); //비활성화
		ta.setBounds(120, 180, 485, 250);
		add(ta);
		
		JPanel p=new JPanel();
		b1=new JButton("수정");
		b2=new JButton("삭제");
		b3=new JButton("목록");
		p.add(b1); p.add(b2); p.add(b3);
		p.setBounds(120, 440, 485, 35);
		add(p);
		
		b1.addActionListener(this); //수정
		b2.addActionListener(this); //삭제
		b3.addActionListener(this); //목록
	}
	public void print(int no) {
		BoardVO vo=dao.boardDetailData(no);
		this.no.setText(String.valueOf(vo.getNo()));
		name.setText(vo.getName());
		sub.setText(vo.getSubject());
		hit.setText(String.valueOf(vo.getHit()));
		day.setText(vo.getRegdate().toString());
		ta.setText(vo.getContent());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			BoardVO vo=dao.boardUpdateData(Integer.parseInt(no.getText()));
			ctrP.boardUP.no=vo.getNo();
			ctrP.boardUP.nameTf.setText(vo.getName());
			ctrP.boardUP.subTf.setText(vo.getSubject());
			ctrP.boardUP.ta.setText(vo.getContent());
			ctrP.card.show(ctrP, "BOARD_UP");
		}else if(e.getSource()==b2) {
			ctrP.boardDLP.pf.setText("");
			ctrP.boardDLP.no=Integer.parseInt(no.getText());
			ctrP.card.show(ctrP, "BOARD_DL");
		}else if(e.getSource()==b3) {
			ctrP.boardLP.print();
			ctrP.card.show(ctrP, "BOARD");
		}
	}
	/*
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
    */
	
}