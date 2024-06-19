package com.sist.client;
import javax.swing.*;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BoardUpdatePanel extends JPanel implements ActionListener{
	JLabel titleLa, nameLa, subLa, contLa, pwdLa;
	JTextField nameTf, subTf;
	JPasswordField pwdPf;
	JTextArea ta;
	JButton b1, b2;
	ControllPanel ctrP;
	BoardDAO dao;
	
	int no=0;
	public BoardUpdatePanel(ControllPanel ctrP) {
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
		
		b1=new JButton("수정");
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
			vo.setNo(no);
			
			//데이터베이스 연동
			boolean bCheck=dao.boardUpdate(vo);
			//이동 => response.sendRedirect("detail.jsp");
			if(bCheck) {
				JOptionPane.showMessageDialog(this, "수정이 완료되었습니다");
				ctrP.boardDTP.print(no);
				ctrP.card.show(ctrP, "BOARD_DT");
			}else{
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다\n다시 입력하세요");
				pwdPf.setText("");
				pwdPf.requestFocus();
			}
		}else if(e.getSource()==b2) {
			ctrP.card.show(ctrP, "BOARD_DT");
		}
	}
	/*
   JLabel titleLa,nameLa,pwdLa,typeLa,subLa,contLa;
   JButton editBtn,listBtn;
   JTextField subTf,nameTf;
   JTextArea ta;
   JPasswordField pf;
   String[] List= {"예시 1", "예시 2", "예시 3"};
   JComboBox ListCombo;
   
   public BoardUpdatePanel() {
	  setLayout(null);
	  
	  titleLa=new JLabel("수정하기",JLabel.CENTER);
	  titleLa.setFont(new Font("맑은 고딕",Font.BOLD,25));
	  titleLa.setBounds(125,25,500,40);
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
      
      editBtn=new JButton("수정");
      listBtn=new JButton("목록");
      
     
      JPanel p=new JPanel();
      p.setBounds(220,455,300,35);
      add(p);
      p.add(editBtn);
      p.add(listBtn);
      
      Dimension buttonSize = new Dimension(70, 30);
      editBtn.setPreferredSize(buttonSize);
      listBtn.setPreferredSize(buttonSize);
   }
   */
}