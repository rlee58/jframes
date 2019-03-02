
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JFrame;

public class test2{
	
	private JFrame gameScreen;
	
	public test2(){
		gameScreen = new JFrame();
		gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameScreen.setTitle("Blackjack - New Game");
		gameScreen.setSize(800,800);
		gameScreen.setVisible(true);
		gameScreen.setResizable(false);
		test table = new test();		
		gameScreen.add(table);
		
		
	}
	
	
}
