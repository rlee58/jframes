

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

public class GameTable extends JComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g){
		Color backColor = new Color(185,252,252);
		g.setColor(backColor);
		g.fillRect(0, 0, 800, 800);
		
		Color tableColor = new Color(208,111,130);
		g.setColor(tableColor);
		g.drawRect(0,150,800,375);
		g.fillRect(0,150,800,375);
		g.setColor(Color.black);
		
		g.drawRect(300, 75, 200, 75);
		g.drawRect(300, 525, 200, 75);
		
		g.setFont(new Font("TimesRoman",Font.PLAIN,30));
		g.drawString("Player",360, 560);
		g.drawString("CPU",365,135);
		

	}

}
