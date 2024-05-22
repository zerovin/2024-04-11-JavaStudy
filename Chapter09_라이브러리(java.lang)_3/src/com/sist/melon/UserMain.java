package com.sist.melon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class UserMain extends JFrame implements ActionListener,MouseListener{
	JTextField searchW;
	JButton searchBtn,listBtn;
	JTable listTable;
	DefaultTableModel model;
	
	public UserMain() {
		searchW=new JTextField(20);
		searchBtn=new JButton("검색");
		listBtn=new JButton("목록");
		JPanel p=new JPanel();
		p.add(searchW); p.add(searchBtn); p.add(listBtn);
		add("North",p);
		
		String[] col= {"번호","노래제목","가수명"};
		String[][] row=new String[0][3];
		model=new DefaultTableModel(row, col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}			
		};
		listTable=new JTable(model);
		JScrollPane js=new JScrollPane(listTable);
		add("Center", js);
		
		searchBtn.addActionListener(this);
		listBtn.addActionListener(this);
		listTable.addMouseListener(this);
		
		musicData();
		
		setSize(500,450);
		setVisible(true);
	}
	public void musicData() {
		for(int i=model.getRowCount()-1;i>=0;i--) {
			model.removeRow(i);
		}
		MelonSystem ms=new MelonSystem();
		Melon[] music=ms.musicList();
		for(Melon m:music) {
			String[] data= {String.valueOf(m.getMno()),m.getTitle(),m.getSinger()};
			model.addRow(data);
		}
	}
	public void musicFind(String fd) {
		for(int i=model.getRowCount()-1;i>=0;i--) {
			model.removeRow(i);
		}
		MelonSystem ms=new MelonSystem();
		Melon[] music=ms.musicFind(fd);
		
		for(Melon m:music) {
			String[] data= {String.valueOf(m.getMno()),m.getTitle(),m.getSinger()};
			model.addRow(data);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UserMain(); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==searchBtn) {
			String searchWord=searchW.getText();
			if(searchWord.trim().length()<1) {
				JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
				searchW.requestFocus();
				return;
			}
			musicFind(searchWord.trim());
		}else if(e.getSource()==listBtn) {
			musicData();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==listTable) {
			if(e.getClickCount()==2) { //더블클릭
				int row=listTable.getSelectedRow();
				String col=model.getValueAt(row, 0).toString();
				MelonSystem ms=new MelonSystem();
				Melon music=ms.musicDetail(Integer.parseInt(col));
				String msg="노래명:"+music.getTitle()+"\n"
				          +"가수명:"+music.getSinger()+"\n"
						  +"앨범명:"+music.getAlbum();
				JOptionPane.showMessageDialog(this, msg);
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
