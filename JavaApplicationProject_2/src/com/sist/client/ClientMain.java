package com.sist.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import com.sist.dao.*;
public class ClientMain extends JFrame implements ActionListener{
	CardLayout card=new CardLayout();
	LoginPanel loginP=new LoginPanel();
	MainPanel mainP=new MainPanel();
	JoinPanel joinP=new JoinPanel();
	PostFindFrame post=new PostFindFrame(); //우편번호 검색창
	public ClientMain() {
		setLayout(card);
		add("LOGIN",loginP);
		add("MAIN", mainP);
		add("JOIN", joinP);

		
		setSize(960, 750);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //윈도우 창 우측상단 X버튼으로 종료금지
	
		
		loginP.loginBtn.addActionListener(this); //로그인
		loginP.joinBtn.addActionListener(this); //회원가입
		loginP.cancelBtn.addActionListener(this); //종료
		joinP.cancel.addActionListener(this);
		joinP.postFind.addActionListener(this); //우편번호검색
		post.find.addActionListener(this); //우편번호 검색
		post.cancel.addActionListener(this); //우편번호 취소
		post.postTf.addActionListener(this); //우편번호 입력
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex) {}
		new ClientMain();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==loginP.cancelBtn) {
			dispose(); //window 메모리 해제
			System.exit(0); //프로그램종료
		}else if(e.getSource()==loginP.loginBtn) {
			//1.입력한 사번, 이름 가지고 오기
			try {
				//유효성 검사
				String id=loginP.idField.getText();
				if(id.length()<1) {
					JOptionPane.showMessageDialog(this, "아이디을 입력하세요");
					loginP.idField.requestFocus();
					return;
				}
				String pwd=String.valueOf(loginP.pwField.getPassword()); //비밀번호 값 가지고 오기 char배열이라 String으로 변환
				if(pwd.length()<1) {
					JOptionPane.showMessageDialog(this, "비밀번호을 입력하세요");
					loginP.pwField.requestFocus();
					return;
				}
				
				//오라클 연결
				MemberDAO dao=MemberDAO.newInstance();
				String result=dao.memberLogin(id, pwd);
				//웹에서는 자바스크립트 처리
				if(result.equals("NOID")) {
					//없는 아이디
					JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다");
					loginP.idField.setText("");
					loginP.pwField.setText("");
					loginP.idField.requestFocus();
				}else if(result.equals("NOPWD")) {
					//비밀번호 불일치
					JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
					loginP.pwField.setText("");
					loginP.pwField.requestFocus();
				}else {
					//로그인
					card.show(getContentPane(),"MAIN");
				}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "잘못된 입력입니다");
				return; //메소드 종료
			}
		}else if(e.getSource()==loginP.joinBtn) {
			card.show(getContentPane(),"JOIN");
		}else if(e.getSource()==joinP.cancel) {
			card.show(getContentPane(),"LOGIN");
		}else if(e.getSource()==joinP.postFind) {
			for(int i=post.model.getRowCount()-1;i>=0;i--) {
				post.model.removeRow(i); //열릴때마다 리스트 리셋, 지우기
			}
			post.postTf.setText("");
			post.setVisible(true);
		}else if(e.getSource()==post.cancel) {
			post.setVisible(false);
		}else if(e.getSource()==post.find || e.getSource()==post.postTf) {
			String dong=post.postTf.getText();
			if(dong.length()<1) {
				JOptionPane.showMessageDialog(this, "동/읍/면을 입력하세요");
				post.postTf.requestFocus();
				return;
			}
			MemberDAO dao=MemberDAO.newInstance();
			ArrayList<ZipcodeVO> list=dao.postFindData(dong);
			if(list.size()==0) {
				JOptionPane.showMessageDialog(this, "검색된 결과가 없습니다");
				post.postTf.setText("");
				post.postTf.requestFocus();
			}else {
				for(int i=post.model.getRowCount()-1;i>=0;i--) {
					post.model.removeRow(i); //열릴때마다 리스트 리셋, 지우기
				}
				for(ZipcodeVO vo:list) {
					String[] data= {vo.getZipcode(), vo.getAddress()};
					post.model.addRow(data);
				}
			}
		}
	}

}
