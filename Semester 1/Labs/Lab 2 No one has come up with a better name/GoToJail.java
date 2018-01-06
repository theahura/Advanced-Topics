/**
A place that sends people to jail and activates the player jailed...thing. 
 * @author Amol Kapoor
 * @version 99.99
**/
public class GoToJail extends Place
{
	/**
	creates the gotojail spot
	param Nt = the next place
	**/
	public GoToJail (Place Nt)
	{		
		super("Go To Jail!", 0, true, null, Nt); 
		setFixed(true); 
	}
	
	/**
	Sends the player to jail and activates its jailed functionality
	param p = the player that is affected
	**/
	@Override
	public void Act(Player p)
	{
		System.out.println("You have been sent to jail for 3 turns.");
		
		Place start=this;
		
		while(!start.getName().equals("Jail")) 
		{
			start = start.getNext();
		}
		//for (start = this; start.getName().equals("Jail"); start = start.getNext()) 
		//	System.out.println(start);

		p.SetLocation(start);
		p.setJailed(1);
		//start.Act(p);
	}
}
