package com.sist.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sist.dao.*;
public class BoardInsertPanel extends JPanel implements ActionListener{
	JLabel titleLa, nameLa, subLa, contLa, pwdLa;
	JTextField nameTf, subTf;
	JPasswordField pwdPf;
	JTextArea ta;
	JButton b1, b2;
	ControllPanel ctrP;
	BoardDAO dao;
	
	public BoardInsertPanel(ControllPanel ctrP) {
		this.ctrP=ctrP;
		dao=BoardDAO.newInstance();
		
		titleLa=new JLabel("글쓰기",JLabel.CENTER); 
		titleLa.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		setLayout(null);
		titleLa.setBounds(120, 15, 620, 50);
		add(titleLa);
		
		nameLa=new JLabel("이름",JLabel.CENTER);
		nameTf=new JTextField();
		nameLa.setBounds(120, 70, 80, 30);
		nameTf.setBounds(205, 70, 150, 30);
		add(nameLa);
		add(nameTf);
		
		subLa=new JLabel("제목",JLabel.CENTER);
		subTf=new JTextField();
		subLa.setBounds(120, 105, 80, 30);
		subTf.setBounds(205, 105, 450, 30);
		add(subLa);
		add(subTf);
		
		contLa=new JLabel("내용",JLabel.CENTER);
		ta=new JTextArea();
		JScrollPane js=new JScrollPane(ta);
		contLa.setBounds(120, 140, 80, 30);
		js.setBounds(205, 140, 450, 250);
		add(contLa);
		add(js);
		
		pwdLa=new JLabel("비밀번호",JLabel.CENTER);
		pwdPf=new JPasswordField();
		pwdLa.setBounds(120, 395, 80, 30);
		pwdPf.setBounds(205, 395, 150, 30);
		add(pwdLa);
		add(pwdPf);
		
		b1=new JButton("글쓰기");
		b2=new JButton("취소");
		JPanel p=new JPanel();
		p.add(b1); 
		p.add(b2);
		p.setBounds(120, 435, 535, 35);
		add(p);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			String name=nameTf.getText();
			if(name.length()<1) {
				nameTf.requestFocus();
				return;
			}
			String subject=subTf.getText();
			if(subject.length()<1) {
				subTf.requestFocus();
				return;
			}
			String content=ta.getText();
			if(content.length()<1) {
				ta.requestFocus();
				return;
			}
			String pwd=String.valueOf(pwdPf.getPassword());
			if(pwd.length()<1) {
				pwdPf.requestFocus();
				return;
			}
			//데이터를 모아서 DAO로 전송
			BoardVO vo=new BoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);
			dao.boardInsert(vo);
			//이동
			ctrP.boardLP.print(); //새글 포함한 목록 재출력
			ctrP.card.show(ctrP, "BOARD");
		}else if(e.getSource()==b2) {
			ctrP.card.show(ctrP, "BOARD");
		}
	}
		
	/*
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
      titleLa.setBounds(10,20,940,40);
 	   add(titleLa);
      
      nameLa=new JLabel("이름");
      nameTf=new JTextField();
      nameLa.setBounds(30, 80, 50, 30);
      nameTf.setBounds(140, 80, 150, 30);
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
   } */

}