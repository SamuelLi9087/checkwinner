import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.text.Position;
public class BingoCard {
	
	private Random random;
	public static int[][] card;
	public static int [][] displayCard;
	public static ArrayList<Integer> rolling = new ArrayList<>();
	public static ArrayList<Integer> oldasf = new ArrayList<>();
	ArrayList<position> markedPositions = new ArrayList<>();
	
	public BingoCard(int seed) {
		random = new Random(seed);
		card = new int[5][5];
		displayCard = new int[5][5];
		
		generateCard();
		
	}
	
	public void generateCard() {
		int min = 1;
		int max = 16;
		
		ArrayList<Integer> ttroud = new ArrayList<>();
		
		for(int col=0;col<card[0].length;col++) {
			for(int row=0;row<card.length;row++) {
				
				int rand = random.nextInt(max-min)+min;
				while(ttroud.contains(rand)) {
					rand=random.nextInt(max-min)+min;
					
				}
				displayCard[row][col] = rand;
				card[row][col] = rand;
				ttroud.add(rand);
			}
		min+=15;
		max+=15;
		}
		displayCard[2][2] = 0;
		
		card[2][2] = 0;
	}
	
	
	
	//Width - 182 HEIGHT - 164
	//40- width 132 - height
	public void fillCard(Graphics g) {
		//g.fillRect(40,132,182,164);
		int x = 40;
		int y = 132;
		int width = 182;
		int height = 164;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(i == 2 && j == 2) {
					
					Rectangle rect = new Rectangle(x, y, width, height);
					Font font = new Font("SANS_SERIF", Font.BOLD, 80);
					g.setFont(font);
					drawCenteredString(g, "Free", rect, font);
					y+=height;
				}
				
				else 
				{
					Rectangle rect = new Rectangle(x, y, width, height);
					Font font = new Font("SANS_SERIF", Font.BOLD, 150);
					g.setFont(font);
					drawCenteredString(g, Integer.toString(displayCard[j][i]), rect, font);
					y+=height;
				}
				
				
			}
			y=132;
			x+=width;
		}
		
		
		
		
	}
	
	public int callBingoBall() {
		int rand = 0;
		while(oldasf.size()<75) {
			rand =  random.nextInt(75)+1;
			if ( oldasf.contains(rand) ) {
				continue;
			} else {
				oldasf.add(rand);
				break;
			}
		}
		
		for(int i = 0; i<card.length;i++) {
			for(int j=0;j<card[0].length;j++) {
				if(card[i][j]==rand) {
					if(rolling.contains(card[i][j])) {
						continue;
					}
					
					else{
						rolling.add(card[i][j]);
						card[i][j]=0;
						position newPos = new position(i,j);
						markedPositions.add(newPos);
						System.out.println(Arrays.deepToString(card));
						Collections.sort(rolling);
						System.out.println(rolling);
						
						return rand;
					}
		
		}
			}
		}
		
		//System.out.println(markedPositions);
		return rand;
		
	}
	
	
	public boolean checkWinners() {
		boolean didIwin = false;
		//first row
		if(card[0][0]==0 && card[0][1]==0&card[0][2]==0&card[0][3]==0&card[0][4]==0) {
			didIwin = true;
		}
		//second
		else if(card[1][0]==0 && card[1][1]==0&card[1][2]==0&card[1][3]==0&card[1][4]==0) {
			didIwin = true;
		}
		//third
		else if(card[2][0]==0 && card[2][1]==0&card[2][2]==0&card[2][3]==0&card[2][4]==0) {
			didIwin = true;
		}
		//fourth
		else if(card[3][0]==0 && card[3][1]==0&card[3][2]==0&card[3][3]==0&card[3][4]==0) {
			didIwin = true;
		}
		//fifth
		else if(card[4][0]==0 && card[4][1]==0&card[4][2]==0&card[4][3]==0&card[4][4]==0) {
			didIwin = true;
		}
		//first column
		if(card[0][0]==0 && card[0][1]==0&card[0][2]==0&card[0][3]==0&card[0][4]==0) {
			didIwin = true;
		}
		//second
		else if(card[1][0]==0 && card[1][1]==0&card[1][2]==0&card[1][3]==0&card[1][4]==0) {
			didIwin = true;
		}
		//third
		else if(card[2][0]==0 && card[2][1]==0&card[2][2]==0&card[2][3]==0&card[2][4]==0) {
			didIwin = true;
		}
		else if(card[3][0]==0 && card[3][1]==0&card[3][2]==0&card[3][3]==0&card[3][4]==0) {
			didIwin = true;
		}
		else if(card[4][0]==0 && card[4][1]==0&card[4][2]==0&card[4][3]==0&card[4][4]==0) {
			didIwin = true;
		}
		
		
		return didIwin;
		
	}
	
	
	public ArrayList<position> getMarkedPositions() {
		return markedPositions;
	}
		
	
	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
	    // Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(font);
	    // Determine the X coordinate for the text
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    // Set the font
	    g.setFont(font);
	    // Draw the String
	    g.drawString(text, x, y);
	}
	
	public String toString() {
		return Arrays.deepToString(card);
			}
			
		
		//Arrays.deepToString(card);
	
	
	
	


}
