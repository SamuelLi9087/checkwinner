import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class BingoPanel extends JPanel implements java.awt.event.KeyListener{
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 1000;
	private int num;
	private BufferedImage cardPic;
	private BingoCard bcard;
	//private atposition;
	
	
	public BingoPanel(int seed) {
		bcard = new BingoCard(seed);
		num = -1;
		
		setSize(WIDTH,HEIGHT);
		try {
			cardPic = ImageIO.read(BingoPanel.class.getResource("/images/BigBingoCard.jpg"));
		}
		catch(Exception E) {
			System.out.println("Exception Error");
			return;
		}
		addKeyListener(this);
		
	}
	public void addNotify() {
		super.addNotify();
		requestFocus();
	}
	
	public void paint(Graphics g) {
		
		g.drawImage(cardPic,0,0,1000,1000,null);
		bcard.fillCard(g);
		Graphics2D gasdf = (Graphics2D)g;
		gasdf.setColor(new Color(255,0,0,100));
		gasdf.fillOval(413,457,182,164);
		gasdf.setColor(java.awt.Color.black);
		if(num>-2) {
			g.drawString("" + num,100,100);
		}
		
		ArrayList<position> markedPositions = bcard.getMarkedPositions();
		
		
		
		
		int x = 40;
		int y = 132;
		int width = 182;
		int height = 164;
		for(int i=0;i<markedPositions.size();i++) {
			int row = markedPositions.get(i).getRow();
			int col = markedPositions.get(i).getCol();
				if(row==0) {
					y=132;
				}
				else if(row==1) {
					y=132+height;
				}
				else if(row==2) {
					y=132 + (2*height);
				}
				else if(row == 3) {
					y=132 + (3*height);
				}
				else if(row==4) {
					y=132+(4*height);
				}
				
				if(col ==0) {
					x=40;
				}
				if(col ==1) {
					x=40+182;
				}
				if(col ==2) {
					x=40+(2*182);
				}
				if(col ==3) {
					x=40+(3*182);
				}
				if(col ==4) {
					x=40+(4*182);
				}
				
			 
				
				Graphics2D ga = (Graphics2D)g;
				ga.setColor(new Color(255,0,0,100));
				ga.fillOval(x,y,width,height);
				
				
				
				
		}
		
	
		
		
		
	
			
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		num = bcard.callBingoBall();
		
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
/*	public void mouseClicked(MouseEvent e) {
		//System.out.println(bcard.callBingoBall());
		num = bcard.callBingoBall();
		
		repaint();
    }
    public void mousePressed(MouseEvent e) {    }
    public void mouseReleased(MouseEvent e) {   }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) { }
*/
}