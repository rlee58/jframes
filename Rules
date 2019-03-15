import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;


public class Rules extends JComponent {
	
	public void paint(Graphics g){
		g.setFont(new Font("Arial",Font.PLAIN,16));
		g.drawString(">The main objective of the game is to have cards with values larger than the CPU's cards without going over 21.",12,15);
		g.drawString("-In BlackJack, aces can be either 1 or 11.",12,45);
		g.drawString("-Jacks, Queens and Kings are counted as 10.",12,75);
		g.drawString("-The rest of the numbered cards have values the same as their number.",12,105);
		g.drawString("-You start with two cards. You can \"hit\" to get another card or \"stand\" to stop drawing cards.", 12, 135);
		g.drawString("-If your total is larger than 21, you lose.",12,165);
		g.drawString("-CPU starts with one card face up, one card face down. When you stand, the CPU will reveal it then hit/stand.",12,195);
		g.drawString("-If your total is less than or equal to 21, and the CPU's total is larger than 21, you win.",12,225);
		g.drawString("-If both your cards and the CPU's cards are less than or equal to 21, the totals will be compared.",12,255);
		g.drawString("-The player with the larger total wins.", 12, 285);
		g.drawString("Special rule (only in this version): If you get seven cards and the total is less than 21, you win.",12,330);
		
		
	}
}
