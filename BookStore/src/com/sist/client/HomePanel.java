package com.sist.client;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.table.*;
import com.sist.commons.ImageChange;
import com.sist.dao.*;

// 사번의 정보를 출력 => 조인

public class HomePanel extends JPanel implements ActionListener,MouseListener{
	JPanel pan=new JPanel();
	JButton prevBtn,nextBtn;
	JLabel[] imgs=new JLabel[12]; 
	JLabel pageLa=new JLabel("0 page / 0 pages");
	JLabel titleLa;
	JTable bestTable;
	DefaultTableModel model;
	int curpage=1; // 현재 페이지
	int totalpage= 0; // 총페이지 
	// 데이터베이스 연결
	WikiDAO dao;
	// 초기화 
    ControllPanel ctrp;

		
		public HomePanel(ControllPanel ctrp)
		{
			this.ctrp=ctrp;
			dao=WikiDAO.newInstance();
			pan.setLayout(new GridLayout(3,4,5,5));
			pan.setBounds(20, 15, 650, 620);
		    setLayout(null);
		    add(pan);
		    prevBtn=new JButton("이전");
		    nextBtn=new JButton("다음");	    
			setLayout(null);
			JPanel p=new JPanel();
		    p.add(prevBtn); p.add(pageLa); p.add(nextBtn);
		    p.setBounds(100, 640, 600, 30);
		    add(p);
		    print();
		    
		    setLayout(null);
		    titleLa = new JLabel("베스트셀러");
			titleLa.setFont(new Font("맑은 고딕", Font.BOLD, 22));
			titleLa.setBounds(720,25,130,50);
			add(titleLa);
			setLayout(null);
			String[] col = {"순위", "도서명"};
			String[][] row = new String[0][2];
			model = new DefaultTableModel(row,col);
			bestTable = new JTable(model);
			JScrollPane js = new JScrollPane(bestTable);
			js.setBounds(670,75,230,400);
			add(js);
			
			prevBtn.addActionListener(this);
	    	nextBtn.addActionListener(this);
				// 데이터 첨부
//				WikiDAO dao1 = WikiDAO.newInstance();
//				ArrayList<CartVO> list1 = dao.CartListData();  // 구매순위가 있는 데이터가 필요함
//				for(CartVO vo: list1)
//				{
//					String[] data = {
//							vo.get구매횟수
//							vo.get도서명()
//						};
//					model.addRow(data);
//				}
				   
		}
	    // 데이터 첨부
		public void print()
		{
			totalpage=dao.bookTotalPage();  
			ArrayList<WikiVO> list=dao.bookListData(curpage);
			for(int i=0;i<list.size();i++)
			{
				WikiVO vo=list.get(i);
	    		try
	    		{
	    			URL url=new URL(vo.getImage());
	    			Image img=ImageChange.getImage(new ImageIcon(url), 110, 140);
	    			// 이미지 크기 축소 
	    			imgs[i]=new JLabel(new ImageIcon(img));
	    			imgs[i].setToolTipText(vo.getBookname()+"^"+vo.getNum());
	    			pan.add(imgs[i]);
	    			imgs[i].addMouseListener(this);
	    		}catch(Exception ex){}
	    		
	    		pageLa.setText(curpage+" page / "+totalpage+" pages");
	    	}
		}
		
		public void init()
		{
			for(int i=0;i<imgs.length;i++)
	    	{
	    		imgs[i]=new JLabel("");
	    	}
	    	pan.removeAll(); // 데이터 제거
	    	pan.validate();// panel 재배치
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == prevBtn)
			{
				if(curpage>1)
				{
					curpage--;
					init();
					print();
					
				}
			}
			else if(e.getSource() == nextBtn)
			{
				if(curpage<totalpage)
				{
					curpage++;
					init();
					print();
				}
			}
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			for(int i=0;i<imgs.length;i++)
			{
				if(e.getSource()==imgs[i])
				{
					if(e.getClickCount()==2)
					{
						String no=imgs[i].getToolTipText();
						no=no.substring(no.lastIndexOf("^")+1);
						ctrp.bookDP.print(Integer.parseInt(no));
						ctrp.card.show(ctrp, "DETAIL");
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
			for(int i=0;i<imgs.length;i++)
			{
				if(e.getSource()==imgs[i])
				{
					imgs[i].setBorder(new LineBorder(Color.blue,2));
					}
				}
			}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			for(int i=0;i<imgs.length;i++)
			{
				if(e.getSource()==imgs[i])
				{
					imgs[i].setBorder(null);
					}
				}
		}

				
}