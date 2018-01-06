/**
The players; stores their money, name, current location, and if they are jailed
 * @author Amol Kapoor
 * @version 99.99
**/

public class Player 
{
	/**
	The amount of money the player has
	**/
	private int money; 
	
	/**
	The players name
	**/
	private String PlayName; 
	/**
	The players location
	**/
	private Place Location; 
	
	/**
	Whether the player is still jailed; interacts with the Jail class
	**/
	private int jailed; 
	
	
	/**
	Creates the player
	param m = the starting money
	param P = name
	param start = starting place (go)
	**/
	public Player (int m, String P, Place start)
	{
		PlayName = P;
		money = m; 
		Location = start; 
		jailed = 0;
	}
	
	/**
	Changes money of the player
	param a = money, if negative a, takes away money
	**/
	public void ChangeMoneyBy (int a)
	{
		money += a; 
	}
	
	/**
	Gets the player name
	return the players name
	**/
	public String getName()
	{
		return PlayName;
	}
	
	/**
	Gets money
	return current player money
	**/
	public int getMoney()
	{
		return money; 
	}
	
	/**
	Sets the player location
	param p = the place that is being set
	**/
	public void SetLocation(Place p)
	{
		Location = p; 
	}
	
	/**
	Gets the player location
	return the current player location
	**/
	public Place getLocation()
	{
		return Location; 
	}
	
	
	/**
	Gets whether the player should be jailed
	return the amount of time its jailed/if its jailed
	**/
	public int getJailed()
	{
		return jailed; 
	}
	
	/**
	Sets if the player is jailed/keeps track of how long its jailed
	param b = activates jailed function
	**/
	public void setJailed(int b)
	{
		jailed = b; 
	}
}
