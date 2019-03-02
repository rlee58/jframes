

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

public class test extends JComponent implements Runnable{
	//set up graphics of jframe
	private int x=0;
	private int y=0;
	private int z=0;
	
	public void main(){
		Thread t = new Thread(this);
		t.start();
	}
	
	
	public void paint(Graphics g){
		Color backColor = new Color(x,y,z);
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

	@Override
	public void run() {
		while(true){
			if(x==255){
				x=0;
			}else{
				x++;
			}
			System.out.println(x+" ");
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
