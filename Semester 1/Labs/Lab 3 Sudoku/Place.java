import java.util.Vector;

/**
 * Place class. Stores the value of the soduku spot, the possible values it can hold, 
 * its location on the grid. Initialized with location and a value (-1 for no value)
 * @author Amol
 * @version infinite
 */
public class Place 
{
	/**
	 * Stores the value of the place
	 */
	private int value;
	
	/**
	 * Stores the possible values this place can hold if it is empty (holds -1 )
	 */
	private Vector <Integer> possiblenums; 
	
	/**
	 * stores the location in the grid
	 */
	private int row;
	private int column; 
	
	
	private boolean onstack; 
	/**
	 * Initializes the place
	 * @param a the value of the place
	 * @param r the row in the game board
	 * @param c the column in the game board
	 */
	public Place(int a, int r, int c)
	{
		if (a > 0)
		{
			value = a;
			possiblenums = new Vector<Integer> ();

		}
		else 
		{
			possiblenums = new Vector<Integer> ();
		}
		
		row = r; 
		column = c; 
	}
	
	/**
	 * Adds a number to the list of possible numbers
	 * @param a the number that is added to the list
	 */
	public void updatepossiblenums(int a) {	possiblenums.add(a); }
	
	/**
	 * Pulls the top number that could be placed here
	 * @return the top num on the list of possible nums
	 */
	public int getPossibleNum() { return possiblenums.get(0); }
	
	/**
	 * gets rid of the entire list
	 */
	public void clearpossiblenums() { possiblenums.clear(); }
	
	/**
	 * removes the first possiblenum on the list
	 */
	public void removepossiblenum() { possiblenums.remove(0); }
	
	/**
	 * gets the size of the possible numbers
	 */
	public int getPossiblenumssize() { return possiblenums.size(); }
	
	/**
	 * sets the value of the place
	 */
	public void setVal(int a) {	value = a;	}
	
	/**
	 * gets the value of the place
	 * @return value of the place
	 */
	public int getVal() { return value; }
	
	/**
	 * Gets the row of the place
	 * @return row
	 */
	public int getRow() {return row; }
	
	/**
	 * Gets the column  of the place
	 * @return column
	 */
	public int getColumn() { return column; }
	
	/**
	 * Sets whether this place should modify its possiblenum list (if its currently on the action stack)
	 * @param what to set the value of whether it is on the action stack to
	 */
	public void setStack(boolean a) {onstack = a; }
	
	/**
	 * Gets whether the place is on the stack
	 * @return whether the place is on the stack
	 */
	public boolean getStack() { return onstack;} 
	
	
}
