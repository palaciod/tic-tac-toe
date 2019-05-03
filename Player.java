package code;

/**
 * Contains the variables and methods for a player to navigate a tic-tac-toe game. 
 * @author Daniel Palacio
 *
 * {@code String}: name - The string value inserted in the JText within the left side of the JFrame.
 * {@code String}: xo - The string value that will either be X or O. First player will always be X and second player will be O.
 * {@code boolean}: turn - Stores the boolean value of the player's status. 
 */
public class Player {
	private String name;
	private String xo;
	private boolean turn;
	/**
	 * Gives the Player a name, input value (X or O), and turn status. 
	 * <b>Note:<b> The player's turn status is automatically set to true, this will change based on the input value of the player. X will always go first and
	 * O will always go second. The value changes within the EnterListener class where once the "Enter" button is clicked it sets the O player witht he boolean 
	 * value of false.
	 * @param _name - The string of the first textbox within the left panel that holds the name of the player.
	 * @param _xo - The string of the second textbox within the left panel that holds input value(X or O) of the player.
	 */
	public Player(String _name,String _xo) {
		name = _name;
		xo = _xo;
		turn = true;
	}
	
	/**
	 * Returns the input value(X or O) of the player.
	 * @return -  {@code String}: Input value (X or O) of the Player
	 */
	public String get_xo() {
		return xo;
	}
	
	/**
	 * Returns the name of the player.
	 * @return - {@code String}: Returns the name of the player.
	 */
	public String get_name() {
		return name;
	}
	
	/**
	 * Assigns the name for the player, which is inputed in the first {@code JText}: textbox of the left panel.
	 * @param new_name - Sets the name of the player to that of the argument.
	 */
	public void set_name(String new_name) {
		name = new_name;
	}
	
	/**
	 * Assigns the input value(X or O) for the player.
	 * @param new_xo
	 */
	public void set_xo(String new_xo) {
		xo = new_xo;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean get_turn_status() {
		return turn;
	}
	
	/**
	 * 
	 * @param bool
	 */
	public void set_turn_status(boolean bool) {
		turn = bool;
	}
	
	

}