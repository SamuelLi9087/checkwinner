import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
public class BingoCardGraphics extends JFrame {
	
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 480;
	
	public BingoCardGraphics(String title) {
		
		
		
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		pack();
		int seed = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter the seed","seed",JOptionPane.QUESTION_MESSAGE));
		//add(new BingoPanel(seed));
		BingoPanel tetris = new BingoPanel (seed);
		Insets frameInsets = getInsets();
		int frameWidth = tetris.getWidth()+ (frameInsets.left + frameInsets.right);
		int frameHeight = tetris.getHeight()+ (frameInsets.top + frameInsets.bottom);
		setPreferredSize(new Dimension(frameWidth, frameHeight));
		setLayout(null);
		
		add(tetris);
		
		pack();
		setLocationRelativeTo(null);
		
		//add(new fillCard());
		setVisible(true);
			
		
		
		
	}
}



/*private static final int WIDTH = 1600;
private static final int HEIGHT = 960;
public FirstImage(String title) {
	
	super(title);
	setSize(WIDTH,HEIGHT);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	add(new FirstImagePanel());
	setVisible(true);*/