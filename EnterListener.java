package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
/**
 * Contains the variables and methods for when the Enter JButton is click upon. This class handles the storage of the information of both players. After 
 * clicking on the button the text is reset to "Try Again?" and now handles the restart of the game.
 * @author Daniel Palacio
 *
 */
public class EnterListener implements ActionListener {
	private Model m;
	private JTextField player1_text;
	private JTextField player2_text;
	private Player player1;
	private Player player2;
	private JButton jb;
	/**
	 * Initializes the button's reference by the parameter passed into it. Has a association relationship with the arguments in the paramter.
	 * @param _m - Instance of the {@code Model} that stores the information of the players.
	 * @param _jb -  The instance of the Enter{@code JButton}.  
	 * @param player_one_text - The instance of the {@code JText} that holds the first player's name.
	 * @param player_two_text -  The instance of the {@code Model} that holds the second player's name.
	 * @param _player1 - The instance of the first {@code Player}.
	 * @param _player2 -  The instance of the second {@code Model}.
	 */
	public EnterListener(Model _m, JButton _jb,JTextField player_one_text,JTextField player_two_text,Player _player1,Player _player2) {
		m = _m;
		player1_text = player_one_text;
		player2_text = player_two_text;
		player1 = _player1;
		player2 = _player2;
		jb = _jb;
	}
	
	/**
	 * Checks whether either of the two JTexts are empty and prohibits either player from storing information. If both JTexts are filled, then both players
	 * store the names. The first/top JText will always be assigned X and be the first to make a move. The second JText will always be assigned O and be 
	 * the second to make a move. Lastly, the {@code JButton} text will be set to "Try Again?". The last if statement checks if the JButton has that text value
	 * reset the board. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if((!player1_text.getText().isEmpty())&&(!player2_text.getText().isEmpty())) {
			String name  = player1_text.getText();
			String name2 = player2_text.getText();
			String o = "O";
			String x = "X";
			player1.set_name(name);
			player1.set_xo(x);
			player1.set_turn_status(true);
			player2.set_name(name2);
			player2.set_xo(o);
			player2.set_turn_status(false);
			System.out.println("---> This is printing from player get_name method: "+player1.get_name()+" This is xo: "+ player1.get_xo());
			System.out.println("---> This is printing from player2 get_name method: "+player2.get_name()+" This is xo: "+ player2.get_xo());
			jb.setText("Try Again?");
		}else {
			System.out.println("The text field must be filled out.");
		}
		if(jb.getText().equals("Try Again?")) {
			m.clear_all_button_texts();
			m.enable_all();
		}

	}

}
