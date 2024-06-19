package com.sist.test;
import java.util.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.DataBufferDouble;

import com.sist.dao.*;
import com.sist.commons.*;
public class ClientMain extends JFrame implements ActionListener, Runnable, MouseListener{
	CardLayout card=new CardLayout();
	Login login=new Login();
	WaitRoom wr=new WaitRoom();
	MemberDAO dao;
	
	//네트워크 관련
	Socket s; //통신기기
	OutputStream out;//서버로 전송, 이벤트 발생시 처리
	BufferedReader in;//서버에서 값읽기, 자동화처리 => 쓰레드
	
	String myId;
	int selRow=-1;
	
	public ClientMain() {
		dao=MemberDAO.newInstance();
		
		setLayout(card);
		add("LOGIN", login);
		add("WR", wr);
		
		setSize(800, 600);
		setVisible(true);
		
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		
		wr.tf.addActionListener(this); //입력 enter
		wr.b6.addActionListener(this); //나가기
		
		wr.table2.addMouseListener(this);
		wr.b4.addActionListener(this); //정보보기
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClientMain();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login.b1) { //로그인버튼
			String id=login.tf.getText();
			if(id.length()<1) {
				login.tf.requestFocus();
				return;
			}
			String pwd=String.valueOf(login.pf.getPassword());
			if(pwd.length()<1) {
				login.pf.requestFocus();
				return;
			}
			
			String result=dao.memberLogin(id, pwd);
			if(result.equals("NOID")) {
				JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다");
				login.tf.setText("");
				login.pf.setText("");
				login.tf.requestFocus();
			}else if(result.equals("NOPWD")) {
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
				login.pf.setText("");
				login.pf.requestFocus();
			}else {
				//로그인 성공 => 서버 연결
				try {
					s=new Socket("localhost", 7777);
					in=new BufferedReader(new InputStreamReader(s.getInputStream()));
					out=s.getOutputStream();
					//-----------------------서버 연결 완료
					
					//서버로 로그인 요청
					out.write((Function.LOGIN+"|"+id+"\n").getBytes());
				}catch(Exception ex) {}
				
				//서버로부터 응답값을 받아 처리
				new Thread(this).start();
			}
			
		}else if(e.getSource()==login.b2){ //취소버튼
			dispose(); //윈도우 메모리 해제
			System.exit(0); //프로그램 종료
		}else if(e.getSource()==wr.tf) { //대기실채팅
			//1.입력값 가지고 오기
			String msg=wr.tf.getText();
			if(msg.length()<1) {
				return;
			}
			
			//2.서버로 입력값 전송
			try {
				out.write((Function.CHAT+"|"+msg+"\n").getBytes()); //out이 서버와 연결, 서버로 값 보내기
			}catch(Exception ex) {}
			wr.tf.setText("");
			wr.tf.requestFocus();
		}else if(e.getSource()==wr.b6) { //나가기
			try {
				out.write((Function.EXIT+"|\n").getBytes());
			}catch(Exception ex) {}
		}else if(e.getSource()==wr.b4) { //정보보기
			if(selRow==-1) {
				JOptionPane.showMessageDialog(this, "정보 볼 대상을 선택하세요");
				return;
			}
			String yid=wr.model2.getValueAt(selRow, 0).toString(); //id
			try {
				out.write((Function.INFO+"|"+yid+"\n").getBytes());
			}catch(Exception ex) {}
			selRow=-1; //선택해제
		}
	}
	//client(요청) => server(응답) => client(응답 출력)
	//이벤트 발생(클릭, 엔터) => 전송 => 응답 => 출력
	//서버에서는 Function.LOGIN / CHAT / EXIT를 받음
	//서버 응답값 처리
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				//서버 응답값 받음
				String msg=in.readLine();
				StringTokenizer st=new StringTokenizer(msg, "|");
				int protocol=Integer.parseInt(st.nextToken()); //구분자
				switch(protocol) {
					case Function.LOGIN:{
						String[] data= {
							st.nextToken(),
							st.nextToken(),
							st.nextToken(),
							st.nextToken(),
							st.nextToken()
						};
						wr.model2.addRow(data);
					}
					break;
					case Function.MYLOG:{
						myId=st.nextToken();
						String name=st.nextToken();
						setTitle(name+"님의 채팅창");
						card.show(getContentPane(), "WR"); //대기실창으로 이동
					}
					break;
					case Function.CHAT:{
						wr.ta.append(st.nextToken()+"\n");
						wr.bar.setValue(wr.bar.getMaximum());
					}
					break;
					case Function.EXIT:{
						String mid=st.nextToken();
						for(int i=0;i<wr.model2.getRowCount();i++) {
							String ids=wr.model2.getValueAt(i, 0).toString();
							if(mid.equals(ids)) {
								wr.model2.removeRow(i);
								break;
							}
						}
					}
					break;
					case Function.MYEXIT:{
						dispose();
						System.exit(0);
					}
					break;
					case Function.INFO:{
						/*
						 *  +vo.getName()+"|"
							+vo.getSex()+"|"
							+vo.getAddr1()+"|"
							+vo.getEmail()+"|"
							+vo.getPhone()+"|"
							+vo.getContent() 
						 */
						String info="이름:"+st.nextToken()+"\n"
								+"성별:"+st.nextToken()+"\n"
								+"주소:"+st.nextToken()+"\n"
								+"이메일:"+st.nextToken()+"\n"
								+"전화:"+st.nextToken()+"\n"
								+"소개:"+st.nextToken()+"\n";
						JOptionPane.showMessageDialog(this, info);
					}
					break;
				}
			}catch(Exception ex) {}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==wr.table2) {
			if(e.getClickCount()==2) {
				int row=wr.table2.getSelectedRow();
				selRow=row;
				String id=wr.model2.getValueAt(row, 0).toString(); //id
				if(id.equals(myId)) {
					wr.b3.setEnabled(false);
					wr.b4.setEnabled(false);
					wr.b5.setEnabled(false);
				}else {
					wr.b3.setEnabled(true);
					wr.b4.setEnabled(true);
					wr.b5.setEnabled(true);
				}
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
