package com.sist.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class BoardListPanel extends JPanel{
	JLabel la1,la2,la3,la4,la5,la6;
	//JLabel b2, b3, b4, b5, b6;
	//JLabel pageLa=new JLabel("0 page / 0 pages");
    JButton insertBtn,b2,b3,b4,b5,b6,b7,b8;
	//JButton b1;
    JTable table;
    DefaultTableModel model; 
    
    public BoardListPanel() {
       setLayout(null);
    	
       la1=new JLabel("게시판",JLabel.CENTER);
       la1.setFont(new Font("맑은 고딕",Font.BOLD,25));
       la1.setBounds(110,30,500,40);
  	   add(la1);
  	   
  	   insertBtn=new JButton("글쓰기");
  	   insertBtn.setBounds(630, 441, 80, 30);
	   add(insertBtn);
	   
	   b2 = new JButton("<");
       b3 = new JButton("1");
       b4 = new JButton("2");
       b5 = new JButton("3");
       b6 = new JButton("4");
       b7 = new JButton("5");
       b8 = new JButton(">");
       
       
         // 버튼을 투명하게 만들기 위한 메서드 호출
//       b2.setOpaque(false);
//       b3.setOpaque(false);
//       b4.setOpaque(false);
//       b5.setOpaque(false);
//       b6.setOpaque(false);
//       b7.setOpaque(false);
//       b8.setOpaque(false);
//
//       // 내용 영역을 채우지 않도록 설정
//       b2.setContentAreaFilled(false);
//       b3.setContentAreaFilled(false);
//       b4.setContentAreaFilled(false);
//       b5.setContentAreaFilled(false);
//       b6.setContentAreaFilled(false);
//       b7.setContentAreaFilled(false);
//       b8.setContentAreaFilled(false);
       
       JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 1, 1)); // FlowLayout 설정
       
       p.add(b2);
       p.add(b3);  
       p.add(b4);
       p.add(b5);
       p.add(b6);
       p.add(b7);
       p.add(b8);
       p.setBounds(250, 470, 700, 35);
       add(p);
       
       Dimension buttonSize = new Dimension(35, 20);
       
       b2.setPreferredSize(buttonSize);
       b3.setPreferredSize(buttonSize);
       b4.setPreferredSize(buttonSize);
       b5.setPreferredSize(buttonSize);
       b6.setPreferredSize(buttonSize);
       b7.setPreferredSize(buttonSize);
       b8.setPreferredSize(buttonSize);
      // pageLa.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
       
       Font buttonFont = new Font("맑은 고딕", Font.PLAIN, 11);
       b2.setFont(buttonFont);
       b3.setFont(buttonFont);
       b4.setFont(buttonFont);
       b5.setFont(buttonFont);
       b6.setFont(buttonFont);
       b7.setFont(buttonFont);
       b8.setFont(buttonFont);
 	   
 	   String[] col={"No","제목","작성자","작성일","조회수"};
  	   String[][] row=new String[0][5];
  	   model=new DefaultTableModel(row,col);
 	   table=new JTable(model);
  	   JScrollPane js=new JScrollPane(table);
  	   js.setBounds(40, 95, 670, 340);
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
 	   int[] colWidths = {40, 200, 100, 100, 60};
 	   for (int i = 0; i < col.length; i++) {
 	      column = table.getColumnModel().getColumn(i);
 	      column.setPreferredWidth(colWidths[i]);
       }
    }
}