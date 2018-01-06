
public class Runner 
{
	
	public static void main (String [] args)
	{
		char [] a = {' ', ' ', ' ', '3', ' ', ' ', '9', ' ', ' '};
		char [] b = {' ', '5', '2', ' ', ' ', ' ', '4', ' ', ' '};
		char [] c = {'6', ' ', ' ', '8', ' ', ' ', ' ', ' ', '1'};
		char [] d = {' ', '2', ' ', '4', '9', ' ', ' ', ' ', ' '};
		char [] e = {' ', ' ', '5', ' ', '1', ' ', '3', ' ', ' '};
		char [] f = {' ', ' ', ' ', ' ', '6', '3', ' ', '5', ' '};		
		char [] g = {'7', ' ', ' ', ' ', ' ', '9', ' ', ' ', '8'};
		char [] h = {' ', ' ', '4', ' ', ' ', ' ', '5', '9', ' '};
		char [] i = {' ', ' ', '8', ' ', ' ', '2', ' ', ' ', ' '};

		char [] [] z = {a, b, c, d, e, f, g, h, i};
		GameBoard q = new GameBoard(z);
		
		//System.out.println(q.canPlace(0, 5, 3));
		//System.out.println(q.get(0, 1).getVal());
		//q.printBoard();
		if (q.solver(0, 0))
		{
			System.out.println("SOLVED!!!");
			q.printBoard(); 
		}
		else
			System.out.println("Unsolvable");
	}
}
