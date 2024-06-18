package com.sist.client;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.SimpleAttributeSet;
import com.sist.dao.*;
import java.text.*;
//사원 정보 출력 => JOIN
public class BookListPanel extends JPanel{
	JLabel titleLa;
	JTable table;
	DefaultTableModel model;
	
	public BookListPanel() {
		setLayout(null);
		titleLa=new JLabel("도서 목록",JLabel.CENTER);
		titleLa.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		titleLa.setBounds(10, 15, 930, 40);
		add(titleLa);
		
		String[] col= {"번호","도서명","지은이","옮긴이","가격","발행일","시리즈"};
		String[][] row=new String[0][7];
		model=new DefaultTableModel(row, col);
		table=new JTable(model);
		JScrollPane js=new JScrollPane(table);
		js.setBounds(10, 65, 930, 600);
		add(js);
		
		//데이터 첨부
		BookDAO dao=BookDAO.newInstance();
		ArrayList<BookVO> list=dao.bookListData(1);
		/*
		for(BookVO vo:list) {
			String[] data= {
					String.valueOf(vo.getNum()),
					vo.getBookname(),
					vo.getWriter(),
					vo.getTranslator(),
					String.valueOf(vo.getPrice()),
					new SimpleDateFormat("yyyy-MM-dd").format(vo.getPubdate()),
					vo.getSeries()
			};
			model.addRow(data);
		}
		*/
	}
}
