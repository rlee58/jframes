import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Card {

	
	private int value1;
	private int value2;
	private ImageIcon imageIcon;
	
	public Card(int value1, String str){
		this.value1 = value1;
		imageIcon = new ImageIcon("bin/"+str+".png");
	}
	public Card(int value1, int value2, String str){
		this.value1 = value1;
		this.value2 = value2;
		imageIcon = new ImageIcon("bin/"+str+".png");
	}
	
	public int getValue1(){
		return value1;
	}
	public int getValue2(){
		return value2;
	}
	public ImageIcon getImage(){
		return imageIcon;
	}
}
