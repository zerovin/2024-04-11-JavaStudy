package com.sist.client;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
public class MypagePanel extends JPanel{
	public MypagePanel() {
		JLabel title, memberInfo, id, name, email, addr, phone;
		JLabel myId, myName, myEmail, myAddr, myPhone;
		JLabel cart, totalCount, totalPrice;
		JTable cartTable;
		DefaultTableModel cartModel;
		JComboBox count;
		JButton orderBtn, listBtn;
		
		setLayout(null);
		
		title=new JLabel("마이페이지", JLabel.CENTER);
		title.setFont(new Font("맑은 고딕",Font.BOLD,25));
	    title.setBounds(10,20,940,40);
	  	add(title);
	  	
	  	memberInfo=new JLabel("회원정보");
	  	memberInfo.setFont(new Font("맑은 고딕",Font.BOLD,20));
	  	memberInfo.setBounds(30, 80, 80, 30);
	  	add(memberInfo);
	  	
	  	id=new JLabel("ID");
	  	id.setFont(new Font("맑은 고딕",Font.BOLD,15));
	  	id.setBounds(30, 130, 80, 30);
	  	add(id);
	  	
	  	name=new JLabel("이름");
	  	name.setFont(new Font("맑은 고딕",Font.BOLD,15));
	  	name.setBounds(30, 190, 80, 30);
	  	add(name);
	  	
	  	email=new JLabel("E-mail");
	  	email.setFont(new Font("맑은 고딕",Font.BOLD,15));
	  	email.setBounds(30, 230, 80, 30);
	  	add(email);
	  	
	  	addr=new JLabel("주소");
	  	addr.setFont(new Font("맑은 고딕",Font.BOLD,15));
	  	addr.setBounds(30, 270, 80, 30);
	  	add(addr);
	  	
	  	phone=new JLabel("전화번호");
	  	phone.setFont(new Font("맑은 고딕",Font.BOLD,15));
	  	phone.setBounds(30, 310, 80, 30);
	  	add(phone);
	  	
	  	cart=new JLabel("장바구니");
	  	cart.setFont(new Font("맑은 고딕",Font.BOLD,20));
	  	cart.setBounds(470, 80, 80, 40);
	  	add(cart);
	  	
	  	String[] col={"상품명", "가격", "수량", "삭제"};
	  	String[][] row=new String[0][4];
	  	cartModel=new DefaultTableModel(row, col);
	  	cartTable=new JTable(cartModel);
	  	JScrollPane cartPane=new JScrollPane(cartTable);
	  	cartPane.setBounds(470, 130, 440, 370);
	  	add(cartPane);
	  	
	  	cartTable.getColumn("상품명").setPreferredWidth(230);
	  	cartTable.getColumn("가격").setPreferredWidth(80);
	  	cartTable.getColumn("수량").setPreferredWidth(50);
	  	cartTable.getColumn("삭제").setPreferredWidth(80);
	  	
	  	count=new JComboBox();
	  	for(int i=1;i<=10;i++) {
	  		count.addItem(i); 	  		
	  	}
	  	TableColumn column = cartTable.getColumnModel().getColumn(3);
	  	column.setCellEditor(new DefaultCellEditor(count)); 
	  	
	  	totalCount=new JLabel("총 수량");
	  	totalCount.setFont(new Font("맑은 고딕",Font.BOLD,15));
	  	totalCount.setBounds(470, 530, 50, 30);
	  	add(totalCount);
	  	
	  	totalPrice=new JLabel("총 가격");
	  	totalPrice.setFont(new Font("맑은 고딕",Font.BOLD,15));
	  	totalPrice.setBounds(470, 570, 50, 30);
	  	add(totalPrice);
	  	
	  	orderBtn=new JButton("주문하기");
	  	orderBtn.setBounds(810, 530, 100, 30);
	  	add(orderBtn);
	  	
	  	listBtn=new JButton("목록으로");
	  	listBtn.setBounds(810, 570, 100, 30);
	  	add(listBtn);
	}
}
