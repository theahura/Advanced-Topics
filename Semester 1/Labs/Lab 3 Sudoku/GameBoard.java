/**
 * The gameboard/solver
 * @author Amol
 * @version 10000001
 */

import java.util.Vector;

/*
 * Devise a SudokuBoard class to support manipulations like:
	void place(r,c,n) // place numeral n at position (r,c)
	void print() // print out the board
	int get(r,c) // return the numeral at position (r,c)
	void remove(r,c) // remove the numeral at position (r,c)
	bool canPlace(r,c,n) // true if the board would allow placing n at (r,c)
	bool solved() // true if there are no blank spots on the board
 */
public class GameBoard 
{
	/**
	 * The Game board
	 */
	private Vector<Vector <Place> > board; 
	
	/**
	 * The acting stack
	 */
	private Stack<Place> act;

	/**
	 * Initializes the game board
	 * @param in 9 * 9 array of chars
	 */
	public GameBoard(char [] [] in)
	{
		act = new Stack<Place>();
		board = new Vector<Vector <Place>>();
		for (int a = 0; a < in.length; a++)
		{
			Vector<Place> z = new Vector<Place>();
			board.add(z);
			for(int b = 0; b < in[a].length; b++)
			{
				 char store = in[a] [b]; 
				 
				 Place p = new Place(Character.getNumericValue(store),  a, b);
			     board.get(a).add(p); 	 
			}
		}
	}
	
	public void place(int r, int c, int n)	{ board.get(r).get(c).setVal(n);	}
	
	/**
	 * Gets a place
	 * @param r row of the place
	 * @param c column of the place
	 * @return the place
	 */
	public Place get(int r, int c) {	return board.get(r).get(c);		}
	
	/**
	 * Sets a place value to -1
	 * @param r row of the place
	 * @param c column of the place
	 */
	public void remove(int r, int c) { board.get(r).get(c).setVal(-1); }
	
	
	/**
	 * Checks if it can place a number at a given place
	 * @param r row for the given place
	 * @param c column for the given place
	 * @param n the number that is being checked
	 * @return if n can be placed or not
	 */
	public boolean canPlace(int r, int c, int n) 
	{ 
		boolean Placeable = true;
		
		if (board.get(r).get(c).getVal() > 0)
		{
			//System.out.println("Val set");
			return false; 
		}
		
		for (int i = 0; i < board.size(); i++)
		{
			if (board.get(i).get(c).getVal() == n)
			{
				//System.out.println(i + " " + c);
				//System.out.println("FALSE " + board.get(i).get(c).getVal() + " equals " + n);
				Placeable = false;
			}
		}
		
		for (int i = 0; i < board.get(0).size(); i++)
		{
			if (board.get(r).get(i).getVal() == n)
			{
				////System.out.println("PROBLEM HERE");
				Placeable = false;
			}
		}
		
		//gets the starting spot of the box
		int rbox = (r/3) * 3;
		int cbox = (c/3) * 3;
		
		for (int i = 0; i < 3; i++)
		{
			for (int a = 0; a < 3; a++)
			{
				if (board.get(rbox + i).get(cbox+ a).getVal() == n)
				{
					//System.out.println(rbox + i );
					//System.out.println(cbox + a );
					//System.out.println("PROBLEM HERE");

					Placeable = false; 
				}
			}
		}
		
		return Placeable; 
	}
	
	/**
	 * Prints the board
	 * @pre board is 9 * 9
	 */
	public void printBoard()
	{
		System.out.println("  ___________________________________");

		for (int i = 0; i < board.size(); i++)
		{			
			if (i % 3 == 0)
			System.out.println(" |___________|___________|___________|");
			
			System.out.println(" |  _  _  _  |  _  _  _  |  _  _  _  |");

			
			for (int a = 0; a < board.get(i).size(); a++)
			{
				if (a % 3 == 0)
				{
					System.out.print( " | " );
				}
				System.out.print("!" + board.get(i).get(a).getVal() + "!");
				
			}
			System.out.print(" |");
			System.out.println();
		}
		System.out.println(" |___________|___________|___________|");
		System.out.println(" |______________Sudoku_______________|");

	}
	
	/**
	 * Checks if the board is solved
	 * @return if every spot on the board is filled
	 */
	public boolean solved()
	{
		for (int i = 0; i < board.size(); i++)
		{
			for (int a = 0; a < board.get(i).size(); a++)
			{
				if (board.get(i).get(a).getVal() <= 0)
					return false; 
			}
		}
		return true; 
	}
	
	/**
	 * Solves the soduku board
	 * @return whether the thing is solved or not/whether it goes down or up a level in the recursive stack
	 */
	public boolean solver()
	{
		boolean Wrong = true; 
		
		if (solved())
		{
				return true; 
		}
		else
		{
			//Clears all of the possible num lists of the things NOT on the action stack
			for (int i = 0; i < board.size(); i++)
			{
				for (int a = 0; a < board.get(i).size(); a++)
				{
					if (!board.get(i).get(a).getStack() )
					{
						board.get(i).get(a).clearpossiblenums(); 
					}
				}
			}
			
			printBoard();
			//the least constrained place
			int r = 0;
			int c = 0; 			
			
			//finds the least constrained
			for (int i = 0; i < board.size(); i++)
			{
				for (int a = 0; a < board.get(i).size(); a++)
				{
					if (board.get(i).get(a).getVal() <= 0)
					{
						for (int b = 1; b < 10; b++)
						{						
							//System.out.println(b);
							//updates the possible numbers for a given place
							if (canPlace(i, a, b))
							{
								//System.out.println("Can Place: " + b + " in spot " + i + " " + a);
								//System.out.println(board.get(i).get(a).getPossiblenumssize());
								board.get(i).get(a).updatepossiblenums(b);
								Wrong = false;
							}
						}
						//updates most constrained spot
						if (board.get(r).get(c).getVal() > 0)
						{
							r = i;
							c = a;
						}
						else if (board.get(r).get(c).getPossiblenumssize() > board.get(i).get(a).getPossiblenumssize())
						{
							r = i;
							c = a;
						}
					}
				}
			}
			
			//if the spot it finds as most constrained can't actually place anything there was a mistake
			if (board.get(r).get(c).getPossiblenumssize() == 0)
			Wrong = true; 
			
			//sends the function back up a level
			if (Wrong)
			{
				System.out.println("Something went wrong");
				return false;
			}
			
			//sets the most constrained spot to one of the possible numbers, and adds it to the 'stack'
			board.get(r).get(c).setStack(true);
			board.get(r).get(c).setVal(board.get(r).get(c).getPossibleNum()); 
			
			//goes through and determines whether to go down another level or back up; creates the recursive stack
			while (!solver())
			{
				//if the level below failed, try again with a new possible num
				if (board.get(r).get(c).getPossiblenumssize() != 1)
				{
					board.get(r).get(c).removepossiblenum();
					board.get(r).get(c).setVal(board.get(r).get(c).getPossibleNum()); 
				}
				//send it back up another level
				else 
				{
					board.get(r).get(c).setVal(0);
					board.get(r).get(c).setStack(false);
					return false;
				}
			}
			
			return true;
		}
	}
}
		
	