package code;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Contains the variables and methods for whenever one of the JButtons are clicked on the right panel. This class handles the 
 * player's string values (Name, Input value) and the player's turn status.
 * @author Daniel Palacio
 *
 */
public class OnClickListener implements ActionListener{
	private Model m;
	private Point p;
	private JButton jb;
	private Player player1;
	private Player player2;
	private Point point;
	/**
	 * Initializes the button's reference by the parameter passed into it. Has a association relationship with the arguments in the paramter. 
	 * @param _m - Instance of the {@code Model} currently holding the data of the game.
	 * @param _jb - Instance of the {@code JButton} currently being clicked.
	 * @param _point - Instance of the {@code Point} mapped to the JButton. 
	 * @param _player1 - Instance of the {@code Player} first player.
	 * @param _player2 - Instance of the {@code Player} second player.
	 */
	public OnClickListener(Model _m,JButton _jb,Point _point,Player _player1,Player _player2) {
		m = _m;
		jb = _jb;
		player1 = _player1;
		player2 = _player2;
		point = _point;
	}
	/**
	 * Checks if the board game gets filled. When it gets filled it'll disable the right panel and print out "Draw!" in the console.
	 */
	public void draw() {
		if(m.size_of_tracker()==9) {
			System.out.println("Draw!");
			m.disable_all();
			m.get_button(new Point(3,3)).setText("Try Again?");// Not necessary? 
		}
	}
	/**
	 * Once the JButton has been clicked we check the status of both players. If true then we set the current JButtons text to the input value associated
	 * with the player. After we set the player's turn status to false. The JButton's point on the board will be added to the tracker within model. 
	 * If the size of the tracker is 5 or greater, we check if the player has a row with 3 of it's input value (X or O). Lastly, if true then the console 
	 * prints out the player's input value with the string "wins!". 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(jb.getText());
		if((player1.get_turn_status())&&(jb.getText().isEmpty())) {
			jb.setText(player1.get_xo());
			player1.set_turn_status(false);
			player2.set_turn_status(true);
			m.add_to_tracker(point);
			if(m.size_of_tracker()>=5) {
				if(m.three_in_row(player1.get_xo(), point)) {
					System.out.println(player1.get_xo()+" wins!");
					m.disable_all();
					m.get_button(new Point(3,3)).setText("Try Again?");
				}
			}
			draw();
			return;
		}
		if((player2.get_turn_status())&&(jb.getText().isEmpty())) {
			jb.setText(player2.get_xo());
			player2.set_turn_status(false);
			player1.set_turn_status(true);
			m.add_to_tracker(point);
			if(m.size_of_tracker()>=5) {
				if(m.three_in_row(player1.get_xo(), point)) {
					System.out.println(player2.get_xo()+" wins!");
					m.disable_all();
					m.get_button(new Point(3,3)).setText("Try Again?");
				}
			}
			draw();
			return;
		}
	}

}
