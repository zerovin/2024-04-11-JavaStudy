package com.sist.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class BoardListPanel extends JPanel{
	JLabel titleLa;
    JButton inBtn,prevBtn,b1,b2,b3,b4,b5,nextBtn;
    JTable table;
    DefaultTableModel model; 
    
    public BoardListPanel() {
       setLayout(null);
    	
       titleLa=new JLabel("게시판",JLabel.CENTER);
       titleLa.setFont(new Font("맑은 고딕",Font.BOLD,25));
       titleLa.setBounds(10,40,940,40);
  	   add(titleLa);
  	   
  	   inBtn=new JButton("글쓰기");
  	   inBtn.setBounds(830, 620, 80, 30);
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
       p.setBounds(10, 620, 940, 40);
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
  	   js.setBounds(30, 110, 880, 500);
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
}