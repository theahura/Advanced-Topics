/**
A place that does literally nothing. 
 * @author Amol Kapoor
 * @version 99.99
**/
public class FreeParking extends Place
{
/**
  Creates the freeparking place with FreeParking as the name
  param Nt = the next place
**/
	public FreeParking (Place Nt)
	{
		super("FreeParking", 0, true, null, Nt); 
	}
	
	/**
	Overrides to make sure it does nothing. 
	param p = the player that nothing happens to
	**/
	@Override
	public void Act(Player p)
	{
		System.out.println("You landed on Freeparking!");
	}
}
