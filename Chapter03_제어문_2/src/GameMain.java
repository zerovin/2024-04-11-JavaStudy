import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameMain extends JFrame implements KeyListener{
	GameView gv=new GameView();
	public GameMain() {
		add("Center",gv);
		setSize(900, 650);
		setVisible(true);
		addKeyListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameMain();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this) {
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				gv.x-=5;
				if(gv.x<0)
					gv.x=500;
				gv.repaint();
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				gv.x+=5;
				if(gv.x<0)
					gv.x=-500;
				gv.repaint();
			}if(e.getKeyCode()==KeyEvent.VK_UP) {
				gv.y-=5;
				if(gv.y<0)
					gv.y=500;
				gv.repaint();
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				gv.y+=5;
				if(gv.y<0)
					gv.y=-500;
				gv.repaint();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
