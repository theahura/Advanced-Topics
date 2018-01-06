/**
 * The Remove player 'special' place that removes a random place owned by the specific player from the game
 * @author Amol Kapoor
 * @version 99.99
 */


import java.util.Vector;


public class RemovePlayer extends Place
{
	/**
	Creates the remove player spot
	place Nt = next place
	**/
	public RemovePlayer (Place Nt)
	{
		super("Remove Player Spot", 0, true, null, Nt); 
	}
	
	
	/**
	Removes a spot that is owned by the player
	param p = the player who's spot is being removed
	**/
	@Override
	public void Act(Player p)
	{
		Place start = this; 
		
		boolean NotFixed = false; 
		
		int totalnum = 0;
		
		Vector <Integer> notfixed = new Vector<Integer>();

		
		while (!start.getNext().getName().equals("Remove Player Spot")) 
		{
			totalnum++;
									
			if (!start.getFixed() && start.getOwner() != null && start.getOwner().getName().equals(p.getName()))
			{
				NotFixed = true; 
				notfixed.add(totalnum);
			}
				
			start = start.getNext();
		}


		if (NotFixed)
		{
			int rand = (int) (Math.random() * notfixed.size());
			
			for (int i = 0; i < notfixed.get(rand) - 1; start = start.getNext(), i++);

			System.out.println("You landed on the remove player square. A random player property is now being removed...");
			
			System.out.println(start.getNext().getName() + " owned by " + start.getNext().getOwner().getName() + " was just removed from the game!");
		
			start.setNext(start.getNext().getNext());
		}
		else
			System.out.println("You landed on the remove player square; all the players properties are fixed...");
	}
}
