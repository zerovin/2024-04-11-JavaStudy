package com.sist.test;
import java.util.*;
import java.awt.image.DataBufferDouble;
import java.io.*;
import java.lang.reflect.Member;
import java.net.*;

import com.sist.commons.Function;
import com.sist.dao.*;
public class Server implements Runnable{
	// 접속 담당
	private ServerSocket ss;
	//PORT 0~65535 => 0~1023
	private final int PORT=7777;
	private MemberDAO dao;
	
	//저장 공간(접속자)
	private Vector<Client> waitVc=new Vector<Client>();
	
	public Server() {
		//시작과 동시에 서버구동
		try {
			ss=new ServerSocket(PORT);
			dao=MemberDAO.newInstance(); //데이터베이스
			System.out.println("Server Start");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//접속시에 접속자 정보 저장 => 접속자마다 통신이 따로 수행 => Thread
	public void run() {
		//접속시에 처리
		while(true) {
			try {
				Socket s=ss.accept();
				// 접속이 된 경우에만 호출
				// s => 클라이언트 정보, 발신자정보 => IP, PORT
				
				Client client=new Client(s);
				//통신시작
				client.start();
				
				// Client 클래스에 있는 run 메소드 호출
			}catch(Exception ex) {}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server=new Server();
		new Thread(server).start(); //start()를 쓰면 메소드 run 호출, run()으로 호출하면 안됨
		//Server 클래스가 가진 run 메소드 호출
	}

	/*
	 *  클래스의 종류
	 *   - 추상클래스 보완 => 인터페이스
	 *   - 내부클래스 => 클래스 메모리 할당없이 모든 변수/메소드에 접근가능
	 *      1) 멤버클래스 : 네트워크, 쓰레드
	 *         class A{
	 *         	  데이터;
	 *            class B{
	 *               A가 가지고 이는 모든 데이터 공유
	 *            }
	 *         }
	 *      2) 익명의 클래스 : 스프링, 데이터분석
	 *                      상속없이 오버라이딩 가능 => 생성자에서 메소드 변경/추가
	 */
	//통신 객체, 접속할때마다 Client 클래스 생성
	class Client extends Thread{
		Socket s; //클라이언트와 통신하는 통신 기기
		OutputStream out; //클라이언트에게 전송
		BufferedReader in; //클라이언트로부터 요청값 받기
		//개인정보
		String id, name, sex, pos, admin;
		
		public Client(Socket s) {
			//변수 초기화
			try {
				this.s=s;
				out=s.getOutputStream();
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				//네트워크 전송 => 1byte로 전송
				//값을 받는 경우 => 2byte로 받는다
				// 1byte를 2byte로 변경해서 받는 클래스  => 필터스트림 => InputStreamReader
				// InputStream 1byte / Reader 2byte
			}catch(Exception ex) {}
		}
		
		//통신 시작
		public void run() { //클라이언트마다 따로 동장 => 쓰레드 이용
			while(true) {
				try {
					//클라이언트의 요청값을 받는다
					String msg=in.readLine();
					StringTokenizer st=new StringTokenizer(msg, "|");
					//100|id
					int protocol=Integer.parseInt(st.nextToken());
					switch(protocol) {
						case Function.LOGIN:{ //로그인을 요청했다면
							/*
							 *  로그인 - 로그인 하는 사람 MYLOG 
							 *         로그인 하고 있던 사람 LOGIN 
							 */
							//ID 받기
							id=st.nextToken();
							//정보얻기
							MemberVO vo=dao.memberInfo(id);
							name=vo.getName();
							sex=vo.getSex();
							pos="대기실";
							admin=vo.getAdmin();
							
							//이미 접속된 회원에게 현재 접속회원 정보 전송
							messageAll(Function.LOGIN+"|"+id+"|"+name+"|"+sex+"|"+pos+"|"+admin);
							messageAll(Function.CHAT+"|[☞ 알림]"+name+"님이 입장하셨습니다");
							//서버에 저장
							waitVc.add(this);
							
							//1.창 갱신
							messageTo(Function.MYLOG+"|"+id+"|"+name); //Login => WaitRoom
							//2.이미 접속된 회원의 모든 정보를 받는다
							for(Client client:waitVc) {
								messageTo(Function.LOGIN+"|"
										+client.id+"|"
										+client.name+"|"
										+client.sex+"|"
										+client.pos+"|"
										+client.admin);
							}
							//3.개설된 방정보
							
						}
						break;
						case Function.EXIT:{ //나가기 요청
							/*
							 *  나가기 - 나가는 사람 MYEXIT 
							 *         남아있는 사람 EXIT
							 *         
							 *  Client - Slave
							 *  Server - Master
							 *  Server => Client에게 지시를 내린다
							 *  Client => Server에서  지시를 받아서 동작
							 */
							//남아있는 사람 시점
							messageAll(Function.EXIT+"|"+id); //테이블에서 제거
							messageAll(Function.CHAT+"|[☞ 알림]"+name+"님이 퇴장하셨습니다");
							
							//나가는 사람 시점
							for(Client client:waitVc) {
								if(client.id.equals(id)) {
									messageTo(Function.MYEXIT+"|"); //윈도우창 종료
									waitVc.remove(client);
									in.close();
									out.close();
								}
							}
						}
						break;
						case Function.CHAT:{ //채팅 요청
							String message=st.nextToken();
							messageAll(Function.CHAT+"|["
									+name+"]"+message);
						}
						break;
						
						/*
						 *  클라이언트 - 요청하기 => a, input, form
						 *            응답출력 => html, css
						 *  서버 - 요청받기 => 자바 라이브러리 HttpSevletRequest
						 *        응답 => HttpServletResponse
						 *        저장 / 수정 / 삭제 / 찾기 => JDBC(오라클연동)
						 */
						case Function.INFO:{
							String yid=st.nextToken();
							MemberVO vo=dao.memberInfo2(yid);
							messageTo(Function.INFO+"|"
									+vo.getName()+"|"
									+vo.getSex()+"|"
									+vo.getAddr1()+"|"
									+vo.getEmail()+"|"
									+vo.getPhone()+"|"
									+vo.getContent());
						}
						break;
					}
				}catch(Exception ex) {}
			}
		}
		//접속자 전체로 전송
		public synchronized void messageAll(String msg) {
			// synchronized - 동기화
			try {
				for(Client client:waitVc) {
					client.messageTo(msg);
				}
			}catch(Exception ex) {}
		}
		//접속자 한명에게만 전송
		public synchronized void messageTo(String msg) {
			try {
				out.write((msg+"\n").getBytes());
			}catch(Exception ex) {}
		}
	}
}
