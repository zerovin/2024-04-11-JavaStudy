package com.sist.client;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;

import java.net.*;
import com.sist.dao.*;
import com.sist.commons.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
public class BookDetailPanel extends JPanel implements ActionListener, ItemListener{
	JLabel la1, la2, la3, la4, la5, la6, la7;
	JButton b1, b2;
	JComboBox<Integer> box;
	JLabel pLa, tLa;
	ControllPanel ctrP; //화면이동용
	BookDAO dao;
	public BookDetailPanel(ControllPanel ctrP) {
		dao=BookDAO.newInstance();
		this.ctrP=ctrP;
		setLayout(null);
		la1=new JLabel();
		la1.setBounds(100, 15, 450, 550);
		add(la1);
		
		la2=new JLabel();
		la2.setBounds(470, 50, 400, 70);
		add(la2);
		la3=new JLabel();
		la3.setBounds(470, 150, 400, 30);
		add(la3);
		la4=new JLabel();
		la4.setBounds(470, 190, 400, 30);
		add(la4);
		la5=new JLabel();
		la5.setBounds(470, 230, 400, 30);
		add(la5);
		la6=new JLabel();
		la6.setBounds(470, 270, 400, 30);
		add(la6);
		la7=new JLabel();
		la7.setBounds(470, 310, 400, 30);
		add(la7);;
		
		b1=new JButton("장바구니");
		b1.setBounds(470, 520, 100, 30);
		add(b1);
		b2=new JButton("목록");
		b2.setBounds(580, 520, 100, 30);
		add(b2);
		
		pLa=new JLabel("가격");
		pLa.setBounds(470, 350, 400, 30);
		add(pLa);
		tLa=new JLabel("구매 총 가격:");
		tLa.setBounds(470, 460, 400, 30);
		add(tLa);
		
		box=new JComboBox<Integer>();
		box.addItem(1);
		box.addItem(2);
		box.addItem(3);
		box.addItem(4);
		box.addItem(5);
		box.addItem(6);
		box.addItem(7);
		box.setBounds(470, 420, 200, 30);
		add(box);
		
		b2.addActionListener(this);
		box.addItemListener(this);
	}
	public void print(int num) {
		//1.오라클에서 값을 받는다
		BookVO vo=dao.bookDetailData(num);
		try {
			URL url=new URL(vo.getImage());
			Image img=ImageChange.getImage(new ImageIcon(url), 300, 400);
			la1.setIcon(new ImageIcon(img));
		}catch(Exception ex) {}
		la2.setText("<html><font size=5><b>"+vo.getBookname()+"</b></font></html>");
		la3.setText("<html><font size=4><b>지은이</b></font> | "+vo.getWriter()+"</html>");
		la4.setText("<html><font size=4><b>옮긴이</b></font> | "+vo.getTranslator()+"</html>");
		la5.setText("<html><font size=4><b>시리즈</b></font> | "+vo.getSeries()+"</html>");
		la6.setText("<html><font size=4><b>발행일</b></font> | "+new SimpleDateFormat("yyyy-MM-dd").format(vo.getPubdate())+"</html>");
		la7.setText("<html><font size=4><b>ISBN</b></font> | "+String.valueOf(vo.getIsbn())+"</html>");
		pLa.setText("<html><font size=4><b>가격</b></font> | "+new DecimalFormat("#,###,###").format(vo.getPrice())+"</html>");
		tLa.setText("<html><font size=5><b>총 가격 | "+new DecimalFormat("#,###,###").format(vo.getPrice())+"</b></font></html>");
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==box) {
			String price=pLa.getText();
			price=price.substring(price.indexOf("|")+2);
			price=price.replaceAll("[^0-9]", ""); //숫자제외 나머지 공백
			
			int account=box.getSelectedIndex()+1;
			int total=Integer.parseInt(price)*account;
			
			DecimalFormat df=new DecimalFormat("##,###,###");
			String s=df.format(total);
			tLa.setText("<html><font size=5><b>총 가격 | "+s+"</b></font></html>");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2) {
			ctrP.card.show(ctrP, "HOME");
		}
	}
}
