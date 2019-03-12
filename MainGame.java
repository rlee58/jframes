import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MainGame implements ActionListener{

	private JFrame frame;
	private JButton btnNewGame;
	private JButton btnHit;
	private JButton btnStand;
	private JLabel playerSlot1;
	private JLabel playerSlot2;
	private JLabel playerSlot3;
	private JLabel playerSlot4;
	private JLabel playerSlot5;
	private JLabel playerSlot6;
	private JLabel playerSlot7;
	private JLabel cpuSlot1;
	private JLabel cpuSlot2;
	private JLabel cpuSlot3;
	private JLabel cpuSlot4;
	private JLabel cpuSlot5;
	private JLabel cpuSlot6;
	private JLabel cpuSlot7;
	JLabel cpuTurn;
	private JLabel playerTotLbl;
	private String totLbl = "Total: ";

	/**
	 * Create the application.
	 */
	public MainGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame("Blackjack - New Game");
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JTextPane gamePanel = new JTextPane();
		gamePanel.setBounds(0, 0, 782, 22);
		frame.getContentPane().add(gamePanel);

		frame.setVisible(true);

		btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(340, 340, 97, 25);
		frame.getContentPane().add(btnNewGame);
		btnNewGame.addActionListener(this);

		btnHit = new JButton("Hit");
		btnHit.setBounds(900, 900, 97, 25);
		frame.getContentPane().add(btnHit);
		btnHit.addActionListener(this);

		btnStand = new JButton("Stand");
		btnStand.setBounds(900, 930, 97, 25);
		frame.getContentPane().add(btnStand);
		btnStand.addActionListener(this);

		playerSlot1 = new JLabel("");
		playerSlot1.setBounds(340,400,95,130);
		frame.getContentPane().add(playerSlot1);

		playerSlot2= new JLabel("");
		playerSlot2.setBounds(440, 400, 95, 130);
		frame.getContentPane().add(playerSlot2);

		playerSlot3 = new JLabel("");
		playerSlot3.setBounds(240, 400, 95, 130);
		frame.getContentPane().add(playerSlot3);

		playerSlot4 = new JLabel("");
		playerSlot4.setBounds(540, 400, 95, 130);
		frame.getContentPane().add(playerSlot4);

		playerSlot5 = new JLabel("");
		playerSlot5.setBounds(140, 400, 95, 130);
		frame.getContentPane().add(playerSlot5);

		playerSlot6 = new JLabel("");
		playerSlot6.setBounds(640, 400, 95, 130);
		frame.getContentPane().add(playerSlot6);

		playerSlot7 = new JLabel("");
		playerSlot7.setBounds(40, 400, 95, 130);
		frame.getContentPane().add(playerSlot7);

		cpuSlot1 = new JLabel("");
		cpuSlot1.setBounds(340, 175, 90, 130);
		frame.getContentPane().add(cpuSlot1);

		cpuSlot2 = new JLabel("");
		cpuSlot2.setBounds(440, 175, 90, 130);
		frame.getContentPane().add(cpuSlot2);

		cpuSlot3 = new JLabel("");
		cpuSlot3.setBounds(240, 175, 95, 130);
		frame.getContentPane().add(cpuSlot3);

		cpuSlot4 = new JLabel("");
		cpuSlot4.setBounds(540, 175, 95, 130);
		frame.getContentPane().add(cpuSlot4);

		cpuSlot5 = new JLabel("");
		cpuSlot5.setBounds(140, 175, 95, 130);
		frame.getContentPane().add(cpuSlot5);

		cpuSlot6 = new JLabel("");
		cpuSlot6.setBounds(640, 175, 95, 130);
		frame.getContentPane().add(cpuSlot6);

		cpuSlot7 = new JLabel("");
		cpuSlot7.setBounds(40, 175, 95, 130);
		frame.getContentPane().add(cpuSlot7);

		playerTotLbl = new JLabel();
		playerTotLbl.setBounds(12, 560, 112, 42);
		frame.getContentPane().add(playerTotLbl);

		cpuTurn = new JLabel("You chose to stand, CPU's turn");
		cpuTurn.setBounds(900, 960, 181, 42);
		frame.getContentPane().add(cpuTurn);

		back();

	}
	public void back(){

		GameTable one = new GameTable();
		one.setBounds(0, 13, 782, 731);
		frame.getContentPane().add(one);
	}


	private String playerCardOne;
	private String playerCardTwo;
	private String playerCardThree;
	private String playerCardFour;
	private String playerCardFive;
	private String playerCardSix;
	private String playerCardSeven;
	private String cpuCardOne;
	private String cpuCardTwo;
	private ArrayList<String> arr = new ArrayList<String>();
	private ArrayList<Integer> playerHand = new ArrayList<Integer>();
	private ArrayList<Integer> cpuHand = new ArrayList<Integer>();
	private int hitCounter = 0;
	private Evaluator eval;	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewGame){
			System.out.println("clicked");
			try {
				loadArrayList();
				playerCardOne = pickCard(arr);
				playerSlot1.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+playerCardOne+".png"))));
				convertCard(playerCardOne,0);
				removeCard();
				playerCardTwo = pickCard(arr);
				playerSlot2.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+playerCardTwo+".png"))));
				convertCard(playerCardTwo,0);
				removeCard();
				cpuCardOne = pickCard(arr);
				cpuSlot1.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/blank.png"))));
				convertCard(cpuCardOne,1);
				removeCard();
				cpuCardTwo = pickCard(arr);
				cpuSlot2.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+cpuCardTwo+".png"))));
				convertCard(cpuCardTwo,1);
				removeCard();

				//test
				System.out.println(cpuHand);
				System.out.println(playerHand);
				eval = new Evaluator(playerHand,cpuHand);
				eval.evaluate();
				updateTotLbl(0);

				playerSlot3.setIcon(null);
				playerSlot4.setIcon(null);
				playerSlot5.setIcon(null);
				playerSlot6.setIcon(null);
				playerSlot7.setIcon(null);
				cpuSlot3.setIcon(null);
				cpuSlot4.setIcon(null);
				cpuSlot5.setIcon(null);
				cpuSlot6.setIcon(null);
				cpuSlot7.setIcon(null);


				hitCounter = 0;
				btnHit.setBounds(295,700,97,25);
				btnStand.setBounds(400,700,97,25);

			} catch (Exception e1) {
				e1.printStackTrace();
			} 
		}else if(e.getSource()==btnHit){
			hitCounter++;
			try{
				if(hitCounter==1){
					playerCardThree = pickCard(arr);
					playerSlot3.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+playerCardThree+".png"))));
					convertCard(playerCardThree,0);
					eval.updateValue(playerHand, 0);
					removeCard();
					updateTotLbl(0);
				}else if(hitCounter==2){
					playerCardFour = pickCard(arr);
					playerSlot4.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+playerCardFour+".png"))));
					convertCard(playerCardFour,0);
					eval.updateValue(playerHand, 0);
					removeCard();
					updateTotLbl(0);
				}else if(hitCounter==3){
					playerCardFive = pickCard(arr);
					playerSlot5.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+playerCardFive+".png"))));
					convertCard(playerCardFive,0);
					eval.updateValue(playerHand, 0);
					removeCard();
					updateTotLbl(0);
				}else if(hitCounter==4){
					playerCardSix = pickCard(arr);
					playerSlot6.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+playerCardSix+".png"))));
					convertCard(playerCardSix,0);
					eval.updateValue(playerHand, 0);
					removeCard();
					updateTotLbl(0);
				}else if(hitCounter==5){
					playerCardSeven = pickCard(arr);
					playerSlot7.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+playerCardSeven+".png"))));
					convertCard(playerCardSeven,0);
					eval.updateValue(playerHand, 0);
					removeCard();
					updateTotLbl(0);
				}
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource()==btnStand){

			btnHit.setBounds(900,900,97,25);
		    btnStand.setBounds(900,930,97,25);
		    cpuTurn.setBounds(320, 675, 181, 42);
		    //pause
		    cpuTurn.setBounds(900, 960, 181, 42);
		}
	}
	public void loadArrayList(){
		arr.clear();
		for(int i=1;i<=13;i++){
			arr.add("C"+i);
		}
		for(int i=1;i<=13;i++){
			arr.add("S"+i);
		}
		for(int i=1;i<=13;i++){
			arr.add("D"+i);
		}
		for(int i=1;i<=13;i++){
			arr.add("H"+i);
		}
		playerHand.clear();
		cpuHand.clear();
	}

	int cardIndex;

	private String pickCard(ArrayList<String> array){
		cardIndex=(int)(Math.random()*arr.size());
		return array.get(cardIndex);
	}
	private void removeCard(){
		String a = arr.remove(cardIndex);
	}
	private void convertCard(String card,int turn){
		String cardString = card.substring(1,card.length());
		Integer cardNumber = Integer.valueOf(cardString);
		if(turn==0){
			playerHand.add(cardNumber);
		}else{
			cpuHand.add(cardNumber);
		}
	}



	private void updateTotLbl(int turn){
		if(turn==0){
			String total=eval.getPlayerTotal(0)+" / ";
			for(int i=1;i<5;i++){
				if(eval.getPlayerTotal(i)>0 && eval.getPlayerTotal(i)<22){
					total = total+eval.getPlayerTotal(i)+" / ";
				}
			}
			total = total.substring(0,total.length()-2);
			if(eval.blackJack(0)){
				total = "21";
			}
			playerTotLbl.setText(totLbl+total);
		}
	}
	
}

