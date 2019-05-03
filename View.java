package code;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Contains the variables and methods for representing the game in a graphical user interface consisting of 
 * a game board, controls, and information to display.
 * @author Daniel Palacio
 *
 */
public class View implements Runnable{
	private Model m;
	private Player player1;
	private Player player2;
	/**
	 * Initializes the {@code View} with a reference to the {@code Model} model,{@code Model} first player, and {@code Player} second player.
	 * @param _m - The instance of the {@code Model} that holds the information to be displayer and the methods to change the information.
	 * @param _player1 - The instance of the first player.
	 * @param _player2 -  The instance of the second player.
	 */
	public View(Model _m,Player _player1,Player _player2) {
		m = _m;
		player1 = _player1;
		player2 = _player2;
	}
	/**
	 * Adds the instances of the JButtons to the right side of the panel. Iterates through all possible points from (0,0) to (2,2) and assigns them the {@code OnclickListener}. Adds the point as key and JButton as value 
	 * in the {@code Model}. 
	 * @param panel -  The right {@code JPanel} in the {@code JFrame}.
	 */
	public void populate_board(JPanel panel) {
		Integer x  = 0;
		 Integer y = 0;
		 while(x<3){
			 while(y<3) {
				 JButton jb =new JButton();
				 Point p = new Point(x,y);
				 jb.addActionListener(new OnClickListener(m,jb,p,player1,player2));
				 panel.add(jb);
				 m.add(p, jb);
				 y++;
			 }
			 y=0;
			 x++;
		 }	
	}
	/**
	 * Creates the instance of the left panel in the JFrame. The left is responsible for handling the information
	 * of both players. Creates the {@code JText} for the names of both players. 
	 * @param info_panel
	 */
	public void setup_info_panel(JPanel info_panel) {
		info_panel.setLayout(new GridLayout(3,0));
		JTextField player1_text = new JTextField();
		JTextField player2_text = new JTextField();
		info_panel.add(player1_text);
		info_panel.add(player2_text);
		JButton jb = new JButton("Enter");
		jb.addActionListener(new EnterListener(m,jb,player1_text,player2_text,player1,player2));
		info_panel.add(jb);
		m.add(new Point(3,3),jb);
		
	}

	@Override
	public void run() {
		JFrame window = new JFrame("Tic Tac Toe");
		JPanel info_panel = new JPanel();
		JPanel board =  new JPanel();
		board.setLayout(new GridLayout(3,3));
		window.setLayout(new GridLayout(0,2));
		window.add(info_panel);
		populate_board(board);
		window.add(board);
		
		setup_info_panel(info_panel);
		// Below are methods make window visible and functioning 
		
		window.setFocusable(true);
		window.setVisible(true);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
