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
	private JLabel cpuTurn;
	private JLabel bust;
	private JLabel cpuBust;
	private JLabel playerTotLbl;
	private JLabel cpuTotLbl;
	private JLabel cpuWins;
	private JLabel cpuHit;
	private JLabel cpuStand;
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

		bust = new JLabel("Your total is over 21! Bust!");
		bust.setBounds(900, 990, 164, 25);
		frame.getContentPane().add(bust);

		cpuWins = new JLabel("CPU wins!");
		cpuWins.setBounds(900, 1020, 63, 22);
		frame.getContentPane().add(cpuWins);

		cpuTotLbl = new JLabel("");
		cpuTotLbl.setBounds(900, 1050, 112, 42);
		frame.getContentPane().add(cpuTotLbl);

		cpuHit = new JLabel("CPU hits");
		cpuHit.setBounds(900, 1080, 56, 16);
		frame.getContentPane().add(cpuHit);

		cpuStand = new JLabel("CPU stands");
		cpuStand.setBounds(900, 1080, 73, 22);
		frame.getContentPane().add(cpuStand);

		cpuBust = new JLabel("CPU total is over 21! You win!");
		cpuBust.setBounds(900, 1100, 181, 25);
		frame.getContentPane().add(cpuBust);
		
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
	private String cpuCardThree;
	private String cpuCardFour;
	private String cpuCardFive;
	private String cpuCardSix;
	private String cpuCardSeven;
	private ArrayList<String> arr = new ArrayList<String>();
	private ArrayList<Integer> playerHand = new ArrayList<Integer>();
	private ArrayList<Integer> cpuHand = new ArrayList<Integer>();
	private int hitCounter = 0;
	private int cpuHitCounter = 0;
	private Evaluator eval;	
	private int playerHigh;
	private int cpuHigh;

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
				cpuHitCounter = 0;
				btnHit.setBounds(295,700,97,25);
				btnStand.setBounds(400,700,97,25);
				bust.setBounds(900, 990, 164, 25);
				cpuWins.setBounds(900, 1020, 63, 22);
				cpuTurn.setBounds(900, 960, 181, 42);
				cpuTotLbl.setBounds(900, 1050, 112, 42);
				cpuHit.setBounds(900, 1080, 56, 16);
				cpuStand.setBounds(900, 1080, 73, 22);
				cpuBust.setBounds(900, 1100, 181, 25);

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
					checkBust(0);
				}else if(hitCounter==2){
					playerCardFour = pickCard(arr);
					playerSlot4.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+playerCardFour+".png"))));
					convertCard(playerCardFour,0);
					eval.updateValue(playerHand, 0);
					removeCard();
					updateTotLbl(0);
					checkBust(0);
				}else if(hitCounter==3){
					playerCardFive = pickCard(arr);
					playerSlot5.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+playerCardFive+".png"))));
					convertCard(playerCardFive,0);
					eval.updateValue(playerHand, 0);
					removeCard();
					updateTotLbl(0);
					checkBust(0);
				}else if(hitCounter==4){
					playerCardSix = pickCard(arr);
					playerSlot6.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+playerCardSix+".png"))));
					convertCard(playerCardSix,0);
					eval.updateValue(playerHand, 0);
					removeCard();
					updateTotLbl(0);
					checkBust(0);
				}else if(hitCounter==5){
					playerCardSeven = pickCard(arr);
					playerSlot7.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+playerCardSeven+".png"))));
					convertCard(playerCardSeven,0);
					eval.updateValue(playerHand, 0);
					removeCard();
					updateTotLbl(0);
					checkBust(0);
				}
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource()==btnStand){
			//hide start game btn
			String high = eval.getHighest()+"";
			playerTotLbl.setText(totLbl+high);
			playerHigh = eval.getHighest();
			comRun();
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
	public void removeCard(){
		arr.remove(cardIndex);
	}
	public void convertCard(String card,int turn){
		String cardString = card.substring(1,card.length());
		Integer cardNumber = Integer.valueOf(cardString);
		if(turn==0){
			playerHand.add(cardNumber);
		}else{
			cpuHand.add(cardNumber);
		}
	}
	public void updateTotLbl(int turn){
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
		if(turn==1){
			String total=eval.getCpuTotal(0)+" / ";
			for(int i=1;i<5;i++){
				if(eval.getCpuTotal(i)>0 && eval.getCpuTotal(i)<22){
					total = total+eval.getCpuTotal(i)+" / ";
				}
			}
			total = total.substring(0,total.length()-2);
			if(eval.blackJack(1)){
				total = "21";
			}
			cpuTotLbl.setText(totLbl+total);
		}
	}
	public void comRun(){
		new Thread(){
			public void run(){
				try{
					btnHit.setBounds(900,900,97,25);
					btnStand.setBounds(900,930,97,25);
					System.out.println("e");//
					cpuTurn.setBounds(320, 675, 181, 42);
					Thread.sleep(3000);
					System.out.println("f");//
					cpuSlot1.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+cpuCardOne+".png"))));
					updateTotLbl(1);
					cpuTotLbl.setBounds(12, 111, 112, 42);
					Thread.sleep(2000);
					while(eval.getCpuTotal(0)<17 && !eval.blackJack(1)){
						cpuHit.setBounds(364, 49, 56, 16);
						cpuHitCounter++;
						Thread.sleep(2000);
						cpuHit.setBounds(900, 1080, 56, 16);
						Thread.sleep(500);
						if(cpuHitCounter==1){
							cpuCardThree = pickCard(arr);
							cpuSlot3.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+cpuCardThree+".png"))));
							convertCard(cpuCardThree,1);
							eval.updateValue(cpuHand, 1);
							removeCard();
							updateTotLbl(1);
						}else if(cpuHitCounter==2){
							cpuCardFour = pickCard(arr);
							cpuSlot4.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+cpuCardFour+".png"))));
							convertCard(cpuCardFour,1);
							eval.updateValue(cpuHand, 1);
							removeCard();
							updateTotLbl(1);
						}else if(cpuHitCounter==3){
							cpuCardFive = pickCard(arr);
							cpuSlot5.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+cpuCardFive+".png"))));
							convertCard(cpuCardFive,1);
							eval.updateValue(cpuHand, 1);
							removeCard();
							updateTotLbl(1);
						}else if(cpuHitCounter==4){
							cpuCardSix = pickCard(arr);
							cpuSlot6.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+cpuCardSix+".png"))));
							convertCard(cpuCardSix,1);
							eval.updateValue(cpuHand, 1);
							removeCard();
							updateTotLbl(1);
						}else if(cpuHitCounter==5){
							cpuCardSeven = pickCard(arr);
							cpuSlot7.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+cpuCardSeven+".png"))));
							convertCard(cpuCardSeven,1);
							eval.updateValue(cpuHand, 1);
							removeCard();
							updateTotLbl(1);
						}
					}
					if(eval.blackJack(1)||(eval.getCpuTotal(0)>=17&&eval.getCpuTotal(0)<=21)){
						cpuStand.setBounds(357, 50, 73, 22);
						Thread.sleep(1000);
					}
					if(eval.getCpuTotal(0)>21){
						cpuTurn.setBounds(900, 960, 181, 42);
						cpuBust.setBounds(318, 657, 181, 25);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}.start();
	}
	public void checkBust(final int turn){
		new Thread(){
			public void run(){
				try{
					if(turn==0 && eval.getPlayerTotal(0)>21){
						btnHit.setBounds(900,900,97,25);
						btnStand.setBounds(900,930,97,25);
						bust.setBounds(326,676,164,25);
						btnNewGame.setBounds(1100, 340, 97, 25);
						Thread.sleep(2000);
						cpuSlot1.setIcon(new ImageIcon(ImageIO.read( new File("src/graphics/"+cpuCardOne+".png"))));
						updateTotLbl(1);
						cpuTotLbl.setBounds(12, 111, 112, 42);
						cpuWins.setBounds(374, 708, 63, 22);
						btnNewGame.setBounds(340, 340, 97, 25);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}.start();
	}

}
