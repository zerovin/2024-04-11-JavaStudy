package com.sist.client;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.net.*;
import java.text.*;
import com.sist.dao.*;
import com.sist.commons.*;
public class FindPanel extends JPanel implements ActionListener, MouseListener{
	JTable table;
	DefaultTableModel model;
	JTextField tf;
	JButton b;
	BookDAO dao;
	ControllPanel ctrP;
	TableColumn column;
	public FindPanel(ControllPanel ctrP) {
		dao=BookDAO.newInstance();
		this.ctrP=ctrP;
		
		setLayout(new BorderLayout());
		tf=new JTextField(20);
		b=new JButton("검색");
		
		JPanel p=new JPanel();
		p.add(tf);
		p.add(b);
		add("North",p);
		
		String[] col={"번호","","도서명","지은이","가격","시리즈"};
		Object[][] row=new Object[0][6];
		model=new DefaultTableModel(row, col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			@Override //이미지출력
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return getValueAt(0, columnIndex).getClass();
			}
		};
		table=new JTable(model);
		table.setRowHeight(35);
		table.getTableHeader().setReorderingAllowed(false);
		table.setShowVerticalLines(false);
		JScrollPane js=new JScrollPane(table);
		add("Center",js);
		
		for(int i=0;i<col.length;i++) {
			column=table.getColumnModel().getColumn(i);
			if(i==0) {
				column.setPreferredWidth(30);
			}else if(i==1) {
				column.setPreferredWidth(50);
			}else if(i==2) {
				column.setPreferredWidth(400);
			}else if(i==3) {
				column.setPreferredWidth(150);
			}else if(i==4) {
				column.setPreferredWidth(50);
			}else if(i==5) {
				column.setPreferredWidth(100);
			}
		}
		tf.addActionListener(this);
		b.addActionListener(this);
		table.addMouseListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==tf || e.getSource()==b) {
			String name=tf.getText();
			if(name.length()<1) {
				JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
				tf.requestFocus();
				return;
			}
			
			//데이터베이스 연동
			ArrayList<BookVO> list=dao.bookFindData(name);
			if(list.size()<1) {
				JOptionPane.showMessageDialog(this, "검색된 결과가 없습니다");;
			}else {
				//테이블 전체 삭제, 리셋
				for(int i=model.getRowCount()-1;i>=0;i--) {
					model.removeRow(i);
				}
				for(BookVO vo:list) {
					try {
						URL url=new URL(vo.getImage());
						Image img=ImageChange.getImage(new ImageIcon(url), 35, 35);
						Object[] obj= { //이미지, 정수, 문자열 다양한 데이터형이 들어가서 Object
							vo.getNum(),
							new ImageIcon(img),
							vo.getBookname(),
							vo.getWriter(),
							new DecimalFormat("##,###,###").format(vo.getPrice()),
							vo.getSeries()
						};
						model.addRow(obj);
					}catch(Exception ex) {
						
					}
				}
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
				ctrP.goodsDP.print(Integer.parseInt(no));
				ctrP.card.show(ctrP, "DETAIL");
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
    JTable table;
    DefaultTableModel find;
	JButton search, entire; // add, edit, del;
	JTextField searchT;
	JTextArea list;
	
   public FindPanel()
   {
	   searchT=new JTextField(40);
	   search=new JButton("검색");
	   
	   setLayout(null); 
	   
	   JPanel p=new JPanel();
	   searchT.setBounds(30, 20, 400, 30);
   	   add(searchT);
   	   search.setBounds(450, 20, 100, 30);
   	   add(search);

	   String[] col= {"책 제목","저자","출판사","발행일"};
   	   String[][] row=new String[0][4];
	   find=new DefaultTableModel(row,col);
   	   table=new JTable(find);
   	   JScrollPane js=new JScrollPane(table);
   	   
	   js.setBounds(30, 80, 880, 500);
	   add(js);
	   
	   entire=new JButton("전체보기");
	   entire.setBounds(30, 590, 100, 30);
	   add(entire);

//	   add=new JButton("추가");
//	   del=new JButton("수정");
//	   edit=new JButton("삭제");
//	
//	   JPanel p1=new JPanel();
//	   p1.add(entire);
//	   p1.add(add);
//	   p1.add(del);
//	   p1.add(edit);
//	   p1.setBounds(20, 600, 250, 60);
//	   add(p1);
   }
   */

	
}