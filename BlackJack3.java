import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class BlackJack3 implements ActionListener{
 
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlackJack3 window = new BlackJack3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BlackJack3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private JButton btnStartGame;
	private JButton btnRules;
	private JButton btnQuit;
	
	private void initialize() {
		frame = new JFrame("Blackjack");
		frame.setBounds(100, 100, 400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnStartGame = new JButton("Start Game");
		frame.getContentPane().add(btnStartGame);
		
		btnRules = new JButton("Rules");
		frame.getContentPane().add(btnRules);
		
		btnQuit = new JButton("Quit");
		frame.getContentPane().add(btnQuit);
		
		ImageIcon blackJLogo = new ImageIcon("src/graphics/pic.png");
		JLabel iconLabel = new JLabel(blackJLogo);
		frame.add(iconLabel);
		
		frame.setLayout(new FlowLayout());
		
		btnStartGame.addActionListener(this);
		btnRules.addActionListener(this);
		btnQuit.addActionListener(this);
	}
	private Rules rule;
	private JButton back;
	private JFrame rulesFrame;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnStartGame){
			frame.setVisible(false);
			MainGame play = new MainGame();
			frame.dispose();
		}
		if(e.getSource()==btnRules){
			frame.setVisible(false);
			rulesFrame = new JFrame("Blackjack - Rules");
			rulesFrame.setBounds(100, 100, 800, 500);
			rulesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			rulesFrame.setVisible(true);
			
			rulesFrame.getContentPane().setLayout(null);
			back = new JButton("Back");
			back.setBounds(350,380,97, 25);
			rulesFrame.getContentPane().add(back);
			back.addActionListener(this);
			
			rule = new Rules();
			rule.setBounds(0, 13, 800, 500);
			rulesFrame.getContentPane().add(rule);
		}
		if(e.getSource()==btnQuit){
			frame.setVisible(false);
		    frame.dispose();
		}
		if(e.getSource()==back){
			rulesFrame.setVisible(false);
			rulesFrame.dispose();
			BlackJack3 screen = new BlackJack3();
			screen.frame.setVisible(true);
		}
	}

}
