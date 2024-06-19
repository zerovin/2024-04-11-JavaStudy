package com.sist.client;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.*;
import com.sist.dao.*;
/*
 *  - JButton, JMenu, JTextField => ActionListener
 *  - JTable, JLabel => MouseLisetener
 *  - JComboBox => ItemListener 
 */
public class BoardListPanel extends JPanel implements ActionListener, MouseListener{
	JLabel titleLa, pageLa;
	JButton inBtn, prevBtn, nextBtn;
	JTable table;
	DefaultTableModel model;
	ControllPanel ctrP;
	BoardDAO dao;
	TableColumn column;
	
	int curpage=1;
	int totalpage=0;
	public BoardListPanel(ControllPanel ctrP) {
		this.ctrP=ctrP;
		dao=BoardDAO.newInstance();
		
		inBtn=new JButton("새글"); //<input type=button value="새글">
		prevBtn=new JButton("이전");
		nextBtn=new JButton("다음");
		pageLa=new JLabel("0 page / 0 pages"); //<label>0 page / 0 pages</label>
		titleLa=new JLabel("게시판",JLabel.CENTER); 
		titleLa.setFont(new Font("맑은 고딕", Font.BOLD, 30)); //<h3></h3>
		
		String[] col= {"번호","제목","이름","작성일","조회수"}; //<tr><th></th>...</tr>
		String[][] row=new String[0][5];
		//한 줄에 5개 데이터 첨부
		
		model=new DefaultTableModel(row, col) { //데이터 관리
			//익명의 클래스 => 포함클래스 => 상속없이 오버라이딩
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		table=new JTable(model); //테이블 모양 관리
		JScrollPane js=new JScrollPane(table);
		for(int i=0;i<col.length;i++) {
			column=table.getColumnModel().getColumn(i);
			if(i==0) {
				column.setPreferredWidth(50);
			}else if(i==1) {
				column.setPreferredWidth(350);
			}else if(i==2) {
				column.setPreferredWidth(100);
			}else if(i==3) {
				column.setPreferredWidth(150);
			}else if(i==4) {
				column.setPreferredWidth(50);
			}
		}
		table.getTableHeader().setReorderingAllowed(false);
		table.setShowVerticalLines(false);
		table.setRowHeight(30);
		table.getTableHeader().setBackground(Color.pink);
		
		//배치
		setLayout(null);
		titleLa.setBounds(120, 15, 620, 50);
		add(titleLa);
		
		inBtn.setBounds(120, 70, 100, 30);
		add(inBtn);
		
		js.setBounds(120, 110, 620, 330);
		add(js);
		
		JPanel p=new JPanel();
		p.add(prevBtn);
		p.add(pageLa);
		p.add(nextBtn);
		p.setBounds(120, 450, 620, 35);
		add(p);
		print();
		
		inBtn.addActionListener(this);
		prevBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		
		table.addMouseListener(this);
	}
	public void print() {
		//1. 테이블 지우기, 리셋
		for(int i=model.getRowCount()-1;i>=0;i--) {
			model.removeRow(i);
		}
		//데이터 읽기
		List<BoardVO> list=dao.boardListData(curpage);
		totalpage=dao.boardTotalPage();
		for(BoardVO vo:list) {
			String[] data= {
					String.valueOf(vo.getNo()),
					vo.getSubject(),
					vo.getName(),
					vo.getRegdate().toString(),
					String.valueOf(vo.getHit())
			};
			model.addRow(data);
			pageLa.setText(curpage+" page / "+totalpage+" pages");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==inBtn) {
			ctrP.boardIP.nameTf.setText("");
			ctrP.boardIP.subTf.setText("");
			ctrP.boardIP.ta.setText("");
			ctrP.boardIP.pwdPf.setText("");
			ctrP.card.show(ctrP, "BOARD_IN");
			ctrP.boardIP.nameTf.requestFocus();
		}else if(e.getSource()==prevBtn) {
			if(curpage>1) {
				curpage--;
				print();
			}
		}else if(e.getSource()==nextBtn) {
			if(curpage<totalpage) {
				curpage++;
				print();
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==table) {
			if(e.getClickCount()==2) {
				int row=table.getSelectedRow();
				String no=model.getValueAt(row, 0).toString();
				//데이터 출력
				ctrP.boardDTP.print(Integer.parseInt(no));
				//이동
				ctrP.card.show(ctrP, "BOARD_DT");
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
	
	/*
	JLabel titleLa;
    JButton inBtn,prevBtn,b1,b2,b3,b4,b5,nextBtn;
    JTable table;
    DefaultTableModel model; 
    
    public BoardListPanel() {
       setLayout(null);
    	
       titleLa=new JLabel("게시판",JLabel.CENTER);
       titleLa.setFont(new Font("맑은 고딕",Font.BOLD,25));
       titleLa.setBounds(10,20,940,40);
  	   add(titleLa);
  	   
  	   inBtn=new JButton("글쓰기");
  	   inBtn.setBounds(830, 590, 80, 30);
	   add(inBtn);
	   
	   prevBtn = new JButton("<");
       b1 = new JButton("1");
       b2 = new JButton("2");
       b3 = new JButton("3");
       b4 = new JButton("4");
       b5 = new JButton("5");
       nextBtn = new JButton(">");
       
       
         // 버튼을 투명하게 만들기 위한 메서드 호출
//       prevBtn.setOpaque(false);
//       b1.setOpaque(false);
//       b2.setOpaque(false);
//       b3.setOpaque(false);
//       b4.setOpaque(false);
//       b5.setOpaque(false);
//       nextBtn.setOpaque(false);
//
         // 내용 영역을 채우지 않도록 설정
//       prevBtn.setContentAreaFilled(false);
//       b1.setContentAreaFilled(false);
//       b2.setContentAreaFilled(false);
//       b3.setContentAreaFilled(false);
//       b4.setContentAreaFilled(false);
//       b5.setContentAreaFilled(false);
//       nextBtn.setContentAreaFilled(false);
       
       JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 1, 1)); // FlowLayout 설정
    
       p.add(prevBtn);
       p.add(b1);  
       p.add(b2);
       p.add(b3);
       p.add(b4);
       p.add(b5);
       p.add(nextBtn);
       p.setBounds(10, 590, 940, 40);
       add(p);
       
       Dimension buttonSize = new Dimension(30, 20);
       prevBtn.setPreferredSize(buttonSize);
       b1.setPreferredSize(buttonSize);
       b2.setPreferredSize(buttonSize);
       b3.setPreferredSize(buttonSize);
       b4.setPreferredSize(buttonSize);
       b5.setPreferredSize(buttonSize);
       nextBtn.setPreferredSize(buttonSize); 
 	   
 	   String[] col={"No","분류","제목","작성자","작성일","조회수"};
  	   String[][] row=new String[0][6];
  	   model=new DefaultTableModel(row,col);
 	   table=new JTable(model);
  	   JScrollPane js=new JScrollPane(table);
  	   js.setBounds(30, 80, 880, 500);
 	   add(js);
 	   
 	  
 	   DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
       headerRenderer.setHorizontalAlignment(JLabel.CENTER);
 	   
 	   DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
 	   DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
       leftRenderer.setHorizontalAlignment(JLabel.LEFT);
 	   table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); 
       table.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);  
       table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer); 
       table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer); 
       table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer); 
      
       TableColumn column;
 	   int[] colWidths = {40, 130, 450, 100, 100, 60};
 	   for (int i = 0; i < col.length; i++) {
 	      column = table.getColumnModel().getColumn(i);
 	      column.setPreferredWidth(colWidths[i]);
       }
    }
    */
}