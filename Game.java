package code;

import javax.swing.SwingUtilities;

/**
 * Main class for the tic-tac-toe game. It creates a new Game and View object upon invoking the main method. The view is added to the game and the game is started
 * {@code Game} game - the instance of tic-tac-toe that controls all internal game logic
 * @author Daniel Palacio
 *
 */

public class Game {
	
	
	/**
	 * Creates the model object that handles in-game logic and the GUI (View object) associated with Model. Two players are created with empty strings that
	 * will eventually be replaced by the name of the player and what string value it will use (X or O).
	 * @param args - Not used.
	 */
	public static void main(String[]args) {
		Model m = new Model();
		Player player = new Player("","");
		Player player2 = new Player("","");
		SwingUtilities.invokeLater(new View(m,player,player2));
	}

}
