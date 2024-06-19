package com.sist.server;
import java.util.*;
import java.io.*;
import java.net.*;
import com.sist.dao.*;
/*
 *  Server
 *   1. 접속을 받는 클래스 - 접속을 받아서 클라이언트 정보(IP, PORT) 저장
 *                      IP:전화번호 + PORT:전화선 = 소켓:전화기
 *   2. 접속된 클라이언트마다 통신담당 클래스 따로 제작 
 *      한번에 제작, 여러개가 동시 수행 => 쓰레드
 *    **쓰레드 => 시분할
 *              ex) 게임 비행기, 총알 동시동작
 *      => 자바는 기본적으로 두개의 쓰레드 가짐 main / gc
 */
public class Server implements Runnable{
	//접속 담당 => 교환소켓
	/*
	 *  1. ServerSokcet 생성
	 *     bind - 연결 => 전화 개통 - 전화/전화선 매칭
	 *            └ bind(ip, port)           
	 *     listen - 대기상태
	 *  2. 대기중에 클라이언트가 접속시 
	 *     accept - 사용자 정보 수집(쓰레드 매칭 후 통신) => 메모리 저장
	 *              └ 전화 - 발신자 전화번호
	 *  3. 종료 요청시
	 *     Thread 종료
	 */
	/*
	 *  서버 컴퓨터는 하나
	 *  연결선 (숫자) 0~65535 중 0~1023 사용중
	 *    => 21 - FTP
	 *       23 - TELNET
	 *       25 - SMTP
	 *       80 - 웹
	 *       8080 - 프록시
	 *       1521 - 오라클
	 *       1433 - MSSQL
	 *       4000 - 머드서버
	 *       3306 - MySQL/MariaDB
	 */
	private ServerSocket ss; //접속 받는 클래스
	private final int PORT=7777;
	//클라이언트의 정보 저장 => IP, PORT, id, name, gender
	//id 가지고 오라클에서 정보를 가지고 온다
	private Vector<Client> waitVc=new Vector<Client>();
	public Server() {
		try {
			ss=new ServerSocket(PORT); //개통 
			System.out.println("Server Start");
			//클라이언트 접속 대기
			//50명까지만 접속 가능
			//(PORT, 연결숫자) 연결숫자 지정안할시 default는 50명
			//TomCat => Web Server 50명
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//접속시 클라이언트 정보 확인 => 정보 저장
	//Thread가 동작하는 메소드
	public void run() {
		try {
			while(true) { //접속을 언제할지 모르니까 계속 루프
				//접속이 된 경우
				Socket s=ss.accept(); //접속자 IP를 받아서 저장
				//Socket에 클라이언트 정보가 들어가 있음 ip, port
				/*
				 *  서버 : ServerSocket에 지정하는 PORT - 고정
				 *  클라이언트 : Socket에 사용되는 PORT - 자동설정, port를 지정하지 않음 
				 */
				
				/*
				//에코 서버 - 한번만 통신
				System.out.println("접속 IP : "+s.getInetAddress().getHostAddress()); //접속자 IP주소
				System.out.println("포트번호 : "+s.getPort()); //PORT
				OutputStream out=s.getOutputStream(); //클라이언트에 값을 보냄
				//s => 클라이언트
				out.write("서버에 접속되었습니다!!^0^\n".getBytes()); //getByte 1byte로 전송해야하는데 한글 2byte => getByte로 변환
				*/
				Client client=new Client(s);
				waitVc.add(client); //정보저장
				client.start(); //클라이언트와 통신 시작
			}
		}catch(Exception ex) {}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server=new Server();
		new Thread(server).start();
	}
	
	//통신 담당
	/*
	 * 	프로그램안에서 여러개의 프로그램 동시 수행 => 프로세스 => 여러개 쓰레드가 동시 수행
	    100명 연결 => 100개 수행
	    내부 클래스 - 클래스안에 클래스 : Server Class가 가지고 있는 모든 변수/메소드 사용가능
	    한개의 컴퓨터에서 Server는 한개 동작 가능
	    Server - 고정 IP를 가지고 있어야 한다
	 */
	class Client extends Thread{
		String id;
		Socket s; // Server클래스 안 run 메소드 s랑 매칭
		OutputStream out; //클라이언트 전송
		BufferedReader in; //클라이언트 요청 받기
		public Client(Socket s) {
			try {
				this.s=s;
				out=s.getOutputStream();
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			}catch(Exception ex) {}
		}
		//통신
		public void run() {
			try {
				//out.write(("★★★★★ 짝짝짝 접속 완료 ^0^ ★★★★★\n").getBytes());
				while(true) {
					//1.클라이언트 요청을 받는다
					String msg=in.readLine(); //채팅 문자열을 보내면
					System.out.println("Client=>"+msg);
					//2.서버에서 응답
	
					for(Client client:waitVc) { //모든 접속자가 받음
						client.out.write((msg+"\n").getBytes());
					}
				}
			}catch(Exception ex){}
		}
	}
}
