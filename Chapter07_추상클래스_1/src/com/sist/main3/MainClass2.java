package com.sist.main3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 *  abstract class A
 *  abstract class B
 *  abstract class C
 *  class D extends A, B, C => 오류
 *  
 *  abstract class A
 *  abstract class B extends A
 *  abstract class C extends B
 *  class D extends C
 *  ==> 보완 => 인터페이스 - 다중상속가능
 */
public class MainClass2 extends JFrame implements MouseListener, KeyListener, Runnable{ //인터페이스 - 다중상속가능

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) { 
		// TODO Auto-generated method stub
		//이거 하나만 구현하고 싶은데 나머지도 다 빈 괄호로 데리고 와야 오류가 안남
		//abstract으로 되어 있기 때문에
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
