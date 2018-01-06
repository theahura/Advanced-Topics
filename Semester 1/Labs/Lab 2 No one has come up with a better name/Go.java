/**
 * Adds 200 dollars to the player money
 * @author Amol Kapoor
 * @version 99.99
 */
public class Go extends Place
{
	/** 
	 * Next listnode is set on run
	 * Everything else is set
	 */
	public Go ()
	{
		super("Go", 0); 
	}
	
	/**
	 * Adds 200 dollars
	 * @param p = the player that gets money
	 */
	@Override
	public void Act(Player p)
	{
		System.out.println("You passed go. Collect 200 dollars.");
		p.ChangeMoneyBy(200);
		System.out.println("You now have $" + p.getMoney() + ".");
	}
}
