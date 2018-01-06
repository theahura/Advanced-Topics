/**
 * The Remove 'special' place that removes a random place from the game
 * @author Amol Kapoor
 * @version 99.99
 */

import java.util.Vector;


public class Remove extends Place
{
	/**
	 * Everything is set except for the next input, initialized in Pingopoly
	 * @param Nt = next ListNode
	 */
	public Remove (Place Nt)
	{
		super("Remove", 0, true, null, Nt); 
	}
	
	/**
	 * Remove functionality
	 * @param p = The player that lands on the spot
	 */
	@Override
	public void Act(Player p)
	{
		Place start = this; 
		
		boolean NotFixed = false; 
		
		int totalnum = 0;
		
		Place go = start; 
		
		Vector <Integer> notfixed = new Vector<Integer>();
		
		//cycles through all spots to make sure there is something that can be removed
		while (!start.getNext().getName().equals("Remove")) 
		{
			totalnum++;
			
			if (start.getNext().getName().equals("Go"))
			{
				go = start.getNext(); 
			}
			
			if (!start.getFixed())
			{
				//stores the 'board locations' (taken as distance from the Remove square)
				NotFixed = true; 
				notfixed.add(totalnum);
			}
				
			start = start.getNext();
		}
		
		//This had a random glitch at one point where it just refused to enter this loop for no reason. Couldn't replicate
		if (NotFixed)
		{
			
			System.out.println("You landed on the remove square. A random property is now being removed...");

			//randomly picks a spot thats notfixed
			int rand = (int) (Math.random() * notfixed.size());
						
			//cycles to one before the chosen spot
			for (int i = 0; i < notfixed.get(rand)-1; start = start.getNext(), i++);
			
			if (start.getNext().getOwner() != null)
			System.out.println(start.getNext().getName() + " owned by " + start.getNext().getOwner().getName() + " was just removed from the game!");
			else
				System.out.println(start.getNext().getName() + " owned by no one was just removed from the game!");

			Vector <Player> a = GetPlayersOnSpot();
			
			for (int i = 0; i < a.size(); i++)
			{
				if (a.get(i).getLocation().getName().equals(start.getNext().getName()))
				{
					a.get(i).SetLocation(go);
				}
			}
			
			//removes it
			start.setNext(start.getNext().getNext());
		}
		else
			System.out.println("You landed on the remove square; all properties are fixed...");


	}
}
