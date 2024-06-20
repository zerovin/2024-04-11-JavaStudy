package com.sist.client;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;

import java.net.*;
import com.sist.dao.*;
import com.sist.commons.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
public class GoodsDetailPanel extends JPanel implements ActionListener, ItemListener{
	JLabel la1, la2, la3, la4, la5;
	JButton b1, b2;
	JComboBox<Integer> box;
	JLabel pLa, tLa;
	ControllPanel ctrP; //화면이동용
	GoodsDAO dao;
	int gno=0;
	String myId;
	public GoodsDetailPanel(ControllPanel ctrP) {
		dao=GoodsDAO.newInstance();
		this.ctrP=ctrP;
		setLayout(null);
		la1=new JLabel();
		la1.setBounds(100, 15, 550, 550);
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
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		box.addItemListener(this);
	}
	public void print(int no) {
		//1.오라클에서 값을 받는다
		gno=no;
		GoodsVO vo=dao.goodsDetailData(no);
		try {
			URL url=new URL(vo.getGoods_poster());
			Image img=ImageChange.getImage(new ImageIcon(url), 300, 300);
			la1.setIcon(new ImageIcon(img));
		}catch(Exception ex) {}
		la2.setText("<html><font size=5><b>"+vo.getGoods_sub()+"</b></font></html>");
		la3.setText("<html><font size=4><b>첫구매할인가</b></font> | "+vo.getGoods_first_price()+"</html>");
		la4.setText("<html><font size=4><b>할인율</b></font> | "+vo.getGoods_discount()+"</html>");
		la5.setText("<html><font size=4><b>배송</b></font> | "+vo.getGoods_delivery()+"</html>");
		pLa.setText("<html><font size=4><b>가격</b></font> | "+vo.getGoods_price()+"</html>");
		tLa.setText("<html><font size=5><b>총 가격 | "+vo.getGoods_price()+"</b></font></html>");
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
		if(e.getSource()==b1) {
			CartVO vo=new CartVO();
			vo.setGno(gno);
			
			String id=ctrP.cliMain.myId;
			vo.setId(id);
			int account=box.getSelectedIndex()+1;
			vo.setAccount(account);
			String price=tLa.getText();
			price=price.replaceAll("[^0-9]", "");
			vo.setPrice(Integer.parseInt(price));
			
			dao.cartInsert(vo);
			JOptionPane.showMessageDialog(this, "장바구니에 추가되었습니다\n마이페이지에서 확인하세요");
			//이동
			//ctrP.card.show(ctrP, "MYPAGE");
		}else if(e.getSource()==b2) {
			ctrP.card.show(ctrP, "HOME");
		}
	}
}
