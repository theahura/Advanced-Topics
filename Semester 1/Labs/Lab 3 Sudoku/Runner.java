/**
 * Runs the soduku solver
 * @author akapoor
 * @version blah
 */
public class Runner 
{
	/**
	 * Runs the soduku solver, populating the board with args
	 * @param args a set of strings that determines the starting population of the board
	 */
	public static void main (String [] args)
	{

		char [] [] z = new char [9] [9];

		
		for (int i = 0; i < args.length; i++)
		{
			for (int q = 0; q < args[i].length(); q++)
			{
				z[i][q] = args[i].charAt(q);
			}
		}
		
		
		GameBoard q = new GameBoard(z);
		
		if (q.solver())
		{
			System.out.println("SOLVED!!!");
			q.printBoard(); 
		}
		else
			System.out.println("Unsolvable");
	}
}
