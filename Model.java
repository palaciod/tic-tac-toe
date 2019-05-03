package code;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.JButton;

public class Model {
	private HashMap<Point,JButton> board;
	private Player player1;
	private ArrayList<Point> tracker;
	
	/**
	 * A composition relationship that creates a HashMap<Point, JButton> and an ArrayList<Point>. The HashMap is the board for the UI. I made the tracker to 
	 * keep track of where the Xs and Os are on the board. The tracker is the data structure that handles the three_in_row method. 
	 */
	public Model() {
		board = new HashMap<Point,JButton>();
		tracker = new ArrayList<Point>();
	}
	
	/**
	 * Associates the JButton to the point p within the board. 
	 * @param key - The point on the board.
	 * @param value - The JButton that is used to store the player's string value (X or O).
	 */
	public void add(Point key,JButton value) {
		board.put(key,value);
	}
	
	/**
	 * Adds the points that have been occupied (X or O) by the player. 
	 * @param point - The point that is now occupied by a string value of X or O.
	 */
	public void add_to_tracker(Point point) {
		tracker.add(point);
	}
	/**
	 * This method returns the size of the tracker (ArrayList<Point>). Once the size of the list is equal to or greater than 5, we can now check if there are
	 * three Xs or Os.
	 * @return - Returns the size of the tracker.
	 */
	public int size_of_tracker() {
		return tracker.size();
	}
	/**
	 * Returns the button associated with the point in the argument. Main purpose of this method is to get the only JButton on the left panel ("Enter" JButotn).
	 * Once one of the players has one the game, the text for that JButton is changed from "Enter" to "Try Again?". The point associated with the JButton the left
	 * panel is (3,3);
	 * @param p - The point needed to get the specified JButton.
	 * @return - A JButton associated with point in the argument.
	 */
	public JButton get_button(Point p) {
		return board.get(p);
	}
	/**
	 * Returns the size of the board (HashMap<Point,JButton>). Used maily for testing purposes. 
	 * @return - Size of the board. 
	 */
	public int size() {
		return board.size();
	}
	/**
	 * This method sorts the tracker based on the sort method provided by Java(?). The sort method is based on the merge sort data structure. 
	 */
	public void sort_tracker() {
		
		Collections.sort(tracker, new Comparator<Point>() {

			@Override
			public int compare(Point a, Point b) {
				if(a.x<b.x) {
					return -1;
				}
				if(a.x==b.x) {
					if(a.y==b.y) {
						return 0;
					}
					if(a.y<b.y) {
						return -1;
					}
					if(a.y>b.y) {
						return 1;
					}
				}
				if(a.x>b.x) {
					return 1;
				}
				return 0;
			}
			
			
		});
	}
	
	
	/**
	 * 
	 * This method was made for testing purposes. It's suppose to help determine the output of the tracker.
	 */
	public void print_tracker() {
		int index = 0;
		sort_tracker();
		while(index<tracker.size()) {
			Point local = tracker.get(index);
			System.out.println(local.x+","+local.y);
			index++;
		}
	}
	
	/**
	 * This method grabs the string acquired from the Player class and also 
	 * grabs the point that was just clicked. Upon clicking this method checks the 6 rows
	 * plus the 2 cross rows that will make the player win.
	 * @param xo - A string that can be either "X" or "O". This string is acquired from the player 
	 * class when any of the JButtons on the board is pressed.
	 * @param point - 
	 * @return - A boolean value that determines if the player has won the game.
	 */
	public boolean three_in_row(String xo,Point point) {
		int x = point.x;
		int y = point.y;
		sort_tracker();
		switch(x) {
		case 0:
			String first = board.get(new Point(x,0)).getText();
			String second = board.get(new Point(x,1)).getText();
			String third = board.get(new Point(x,2)).getText();
			
			
			if((first==second)&&(second==third)) {
				return true;
			}
		case 1:
			first = board.get(new Point(x,0)).getText();
			second = board.get(new Point(x,1)).getText();
			third = board.get(new Point(x,2)).getText();
			if((first==second)&&(second==third)) {
				return true;
			}
		case 2:
			first = board.get(new Point(x,0)).getText();
			second = board.get(new Point(x,1)).getText();
			third = board.get(new Point(x,2)).getText();
			if((first==second)&&(second==third)) {
				return true;
			}
		}
		switch(y) {
		case 0: 
			String first = board.get(new Point(0,y)).getText();
			String second = board.get(new Point(1,y)).getText();
			String third = board.get(new Point(2,y)).getText();
			if((first==second)&&(second==third)) {
				return true;
			}
		case 1:
			first = board.get(new Point(0,y)).getText();
			second = board.get(new Point(1,y)).getText();
			third = board.get(new Point(2,y)).getText();
			if((first==second)&&(second==third)) {
				return true;
			}
		case 2: 
			first = board.get(new Point(0,y)).getText();
			second = board.get(new Point(1,y)).getText();
			third = board.get(new Point(2,y)).getText();
			if((first==second)&&(second==third)) {
				return true;
			}
		}
		// The following string are the 
		String fourth = board.get(new Point(0,0)).getText();
		String fifth = board.get(new Point(1,1)).getText();
		String sixth = board.get(new Point(2,2)).getText();
		String seventh = board.get(new Point(2,0)).getText();
		String eigth = board.get(new Point(0,2)).getText();
		if((fourth==fifth)&&(fifth==sixth)) {
			return true;
		}
		if((seventh==fifth)&&(fifth==eigth)) {
			return true;
		}

		return false;
	}
	/**
	 * Once a player has won or the board gets filled the JButtons on the right side of the panel will be deactivated. 
	 */
	public void disable_all() {
		Integer x  = 0;
		Integer y = 0;
		while(x<3){
			while(y<3) {
				Point p = new Point(x,y);
				JButton local_button = board.get(p);
				local_button.setEnabled(false);
				y++;
			 }
			y=0;
			x++;
		 }	
		
	}
	/**
	 * After a game has been completed and the "Try Again?" JButton has been clicked, then the JButtons of the right side of the panel are reactivated. 
	 */
	public void enable_all() {
		Integer x  = 0;
		Integer y = 0;
		while(x<3){
			while(y<3) {
				Point p = new Point(x,y);
				JButton local_button = board.get(p);
				local_button.setEnabled(true);
				y++;
			 }
			y=0;
			x++;
		 }	
	}
	/**
	 * Once the "Try Again?" JButton is clicked JButtons must be cleared of all text, so the game can start over.
	 */
	public void clear_all_button_texts() {
		Integer x  = 0;
		Integer y = 0;
		while(x<3){
			while(y<3) {
				Point p = new Point(x,y);
				JButton local_button = board.get(p);
				local_button.setText("");
				tracker.clear();
				y++;
			 }
			y=0;
			x++;
		 }
	}
	
	
	
	
	

}
