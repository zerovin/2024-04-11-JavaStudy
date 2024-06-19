package com.sist.server;
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 *  1. 전송
 *  2. 서버값을 처리
 *  => 동시에 두 개의 프로그램 실행 - 쓰레드
 *  
 *  Thread
 *  1.상속 => 확장
 *    class A extends Thread
 *  2.인터페이스 구현
 *    class A implements Runnable => 윈도우에서는 이미 상속, 인터페이스 이용
 *    
 *  Thread
 *  생성 ============> 대기상태 ============> 동작 =============> 휴직
 *  new Thread()     start()              run()             sleep()
 *                                      interrupt()-종료
 *  ** run() 메소드 호출 => start()
 *  
 *  Thread t1=new Thread()
 *  Thread t2=new Thread()
 *  Thread t3=new Thread()
 *  => t1.start()
 *     t2.start()
 *     t3.start()
 *  => t1 t2 t3
 *     t1 t2 t3
 *     t3 t1 t2 => 우선순위에 따라, 빨리 끝나는게 우선, JVM 가상머신이 정함
 */
public class Client extends JFrame implements ActionListener, Runnable{
	JTextField tf, tf1;
	JButton b1, b2;
	JTextArea ta;
	String name;
	JScrollBar bar;
	
	//네트워크 관련
	Socket s; //서버연결
	OutputStream out; //전송
	BufferedReader in; //서버로부터 전송값 받기
	
	
	public Client() {
		tf=new JTextField(15); //(글자수) 이름입력
		
		b1=new JButton("접속");
		b2=new JButton("종료");
		ta=new JTextArea(); //서버에서 들어오는 값 출력
		JScrollPane js=new JScrollPane(ta);
		bar=js.getVerticalScrollBar();
		
		
		tf1=new JTextField(30); //채팅 입력창
		tf1.setEnabled(false); //접속 전 비활성화, 접속 후 활성화
		
		JPanel p=new JPanel();
		p.add(tf); p.add(b1); p.add(b2);
		add("North",p);
		
		ta.setEditable(false); //비활성화
		add("Center",js);
		add("South", tf1);
		
		setSize(350, 400);
		setVisible(true);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		tf1.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		try {
			Socket s=new Socket("localhost",7777); //(서버주소 ip, 포트번호)
			// s => Server
			BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			//InputStreamReader byte로 보낸거 리더로 변환
			System.out.println(in.readLine());
		}catch(Exception ex) {}
		*/
		
		new Client();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) { //접속
			try {
				name=tf.getText();
				if(name.length()<1) { //필수입력
					tf.requestFocus();
					return; //actionPerformed메소드 종료
				}
				//1.소켓 생성
				s=new Socket("localhost", 7777);
				
				//2.서버 송수신 위치 확인
				//수신
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				//송신
				out=s.getOutputStream();
		
				//연결이 된 경우
				b1.setEnabled(false); //접속이 됐으니 접속버튼 비활성화
				tf1.setEnabled(true); //채팅 입력창 활성화
				tf1.requestFocus();
			}catch(Exception ex) {}
			new Thread(this).start(); //쓰레드 동작 Client 클래스가 가지고 있는 run 메소드 호출
			
		}else if(e.getSource()==b2) { //종료
			System.exit(0);
		}else if(e.getSource()==tf1) { //채팅 문자열 입력창
			try {
				String msg=tf1.getText();
				if(msg.length()<1) {
					return;
				}
				
				//입력이 된 상태 => 서버로 문자열 전송
				out.write(("["+name+"] "+msg+"\n").getBytes());
				tf1.setText("");
				tf1.requestFocus();
			}catch(Exception ex) {}
		}
	}
	
	//서버에서 응답한 값을 처리하는 역할
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				String msg=in.readLine();
				ta.append(msg+"\n");
				bar.setValue(bar.getMaximum()); //스크롤바 항상 제일 아래로
			}
		}catch(Exception ex) {}
	}

}
