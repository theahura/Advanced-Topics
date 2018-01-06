/**
Creates a Jail spot that can be 'visited' or traps a person there for 3 turns
 * @author Amol Kapoor
 * @version 99.99
**/
public class Jail extends Place
{ 
	/**
	Creates the Jail spot
	**/
	public Jail (Place Nt)
	{
		super("Jail", 0, true, null, Nt); 
	}
	/**
	Either jails the player or acts as freeparking
	param p = the player who is jailed
	*/
	
	@Override
	public void Act(Player p)
	{
		if (p.getJailed() > 0)
		{
			System.out.println("You have been jailed. Haha, sucks.");
			p.setJailed(p.getJailed()+1);
			
			if (p.getJailed() == 3)
			{
				p.setJailed(0); 
			}
		}
		else
			System.out.println("You are visiting the jail.");
		
	}
}
