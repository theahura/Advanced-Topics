/*
 * Place Object:


 */

/**
 *  Place class that acts as a list node, contains all functionality for places including prompts for purchasing. All functioning
 *  happens in Act(), which is extended to 'special' places that can have different functionality
 *  
 *  What is it’s value?
	Is it fixed?
	What is it’s name?
	Who (if anyone) owns it? (There are actually 4 different scenarios here! 
	Player 1 owns it, Player 2 owns it, it is unowned, or it can’t be owned.)
 *  
 *  @author Amol Kapoor
  	@version 99.9
 */

import java.util.Scanner;
import java.util.Vector;


public class Place 
{
	/**
	 * Name of the place
	 */
	private String name;
	
	/**
	 * Cost of the place
	 */
	private int cost;
	
	/**
	 * Owner of the place
	 */
	private Player owner;
	
	/**
	 * Whether the place is 'fixed'
	 */
	private boolean fixed; 
	
	/**
	 * List Node functionality
	 */
	private Place next;
	
	/**
	 * Tracks inputs
	 */
	private static Scanner keyboard;
	
	private static Vector<Player> onspot = new Vector<Player>();

	/**
	 * Constructor used for go class only
	 * @param n = Name 
	 * @param c = Cost
	 */
	public Place (String n, int c)
	{
		name = n;
		cost = c;		
		fixed = false;
		owner = null;
		keyboard = new Scanner(System.in);
	}
	
	/**
	 * Used for most other Places that are instantiated in Pingopoly runner
	 * @param n = Name
	 * @param c = Cost
	 * @param Nt = Next ListNode
	 */
	public Place (String n, int c, Place Nt)
	{
		name = n;
		cost = c;		
		fixed = false;
		owner = null;
		keyboard = new Scanner(System.in);
		next = Nt; 
	}
	
	/**
	 * Constructor used when player wants to create own place
	 * @param n = Name
	 * @param c = Cost
	 * @param f = Fixed
	 * @param p = Owner
	 * @param Nt = Next ListNode
	 */
	public Place (String n, int c, boolean f, Player p, Place Nt)
	{
		name = n; 
		fixed = f; 
		
		if (fixed)
			cost = 2*c; 
		else
			cost = c; 
		
		owner = p;
		keyboard = new Scanner(System.in);
		
		next = Nt; 
	}
 
	/**
	 * Main functionality, determines what happens to player p when he/she lands on the square
	 * Prompts user to buy, pay rent, or create a new area
	 * @param p = Player to do things to
	 */
	public void Act(Player p)
	{
		//if there is some owner, prompts to create new space/takes rent from them
		if (owner != null)
		{
			System.out.println("You landed on " + name + ", owned by " + owner.getName() + ", that costs " + cost + ".");
			//prompts to create an adjacent property
			if (p.getName().equals(owner.getName()) )
			{
				//if they have the money, of course
				if (p.getMoney() >= 100)
				{
					System.out.println("Do you want to build an adjacent property for a minimum of $100? You have " + p.getMoney() + ". Y/N");
					if (getYN())
					{
						System.out.println("Input a name (not Go or Jail).");
				         String s = "";
				         
				         s = keyboard.next();
				         keyboard.nextLine();
				         while(s.equalsIgnoreCase("Go") && s.equalsIgnoreCase("Jail")) 
				         {
				            System.out.println("Please enter a valid String.");
				            s = keyboard.next();
				            keyboard.nextLine();
				         }
						 
				         String newname = s; 
				         
						 System.out.println("Input a cost; keep in mind the cost doubles if you choose to fix the property, and the starting price has to be greater than $100. You have " + p.getMoney() + ". Don't overspend...");
							 
						 int newcost = getNewCost(p);
							 
						if (newcost*2 < p.getMoney())
						{
							System.out.println("Do you want this property fixed? Y/N");
								 
							 boolean newFixed = getYN();
							 
							 Place newPlace = new Place (newname, newcost, newFixed, p, getNext());
								 
							 setNext(newPlace);
								 
							 System.out.println("Congrats! You now own " + newPlace.getName());
								 
							 p.ChangeMoneyBy(-newPlace.getCost());
						 }
						else
						{
							 Place newPlace = new Place (newname, newcost, false, p, getNext());

							System.out.println("You can't fix your new property.");
							 System.out.println("Congrats! You now own " + newPlace.getName());
							 p.ChangeMoneyBy(-newPlace.getCost());

						 }
					 
					}
					else
						System.out.println("Alright then.");
				}
				else
				{
					System.out.println("You landed on your own square but don't have enough money to expand. Too bad.");
				}
			}
			//prompts to take rent
			else 
			{
				System.out.println("You have to pay $" + (int) (.1 * cost) + ".");
				p.ChangeMoneyBy((int) (-.1*cost));
				owner.ChangeMoneyBy((int) (.1*cost));
				System.out.println("You now have $" + p.getMoney() + ".");
			}
		}
		//if no owner, prompts to buy
		else
		{
			System.out.println("You landed on " + name + ", currently unowned, that costs " + cost + ".");
			if (p.getMoney() >= cost)
			{
				System.out.println("Do you, " + p.getName() + ", want to buy the property? You have " + p.getMoney() + ". Y/N");
				if (getYN())
				{
					p.ChangeMoneyBy(cost*-1);
					owner = p; 
					System.out.println("You now own " + name + ". Congrats! You have " + p.getMoney() + " left.");	
				}
				else
					System.out.println("Alright then.");
			
			}
			else
			{
				System.out.println("You only have " + p.getMoney() + ". Too bad.");
			}
		}
	}
	 
	//Modifier
	/**
	 * ListNode functionality
	 * @param newNext = next spot
	 */
	public void setNext(Place newNext)
	{
	    next = newNext;
	}

	/**
	 * Changes owner
	 * @param p = new owner
	 */
	public void setOwner(Player p)
	{
		owner = p;
	}
	    //Accessors
	/**
	 * Gets the next ListNode
	 * @return = next Place on board
	 */
	public Place getNext() { return next; }
	
	/**
	 * Determines whether the place is fixed or not for remove and removeplayer classes
	 * @return = whether place is 'fixed' 
	 */
	public boolean getFixed() {return fixed;}
	
	/**
	Sets fixed
	**/
	public void setFixed(boolean b) { fixed = b;	}
	/**
	 * Gets the name; used for most equality calculations
	 * @return = name of the place
	 */
	public String getName() { return name; }
	
	/**
	 * Gets the owner
	 * @return = owner of the place
	 */
	public Player getOwner() { return owner;}
	
	/**
	 * Gets the cost
	 * @return = cost of the place
	 */
	public int getCost() { return cost;}
	     
	/**
	 * Changes System.out.print
	 * Standardizes basic output of a place, and determines if a player is on the spot
	 */
	public String toString()
	{
		String s = " | " + name;
		
		for (int i = 0; i < onspot.size(); i ++)
		{
			s = s + " <" + onspot.get(i).getName() + "> ";
		}
		
		return s + " | ";
	}	 
	
	//Input functions
	/**
	 * Promtps user for a yes no input. 
	 * @return true if yes, false if no
	 */
	private boolean getYN()
	{
         String s = "";
         
         s = keyboard.next();
         keyboard.nextLine();
         while(!s.equalsIgnoreCase("Y") && !s.equalsIgnoreCase("N")) 
         {
            System.out.println("Please enter a valid String.");
            s = keyboard.next();
            keyboard.nextLine();
         }
        
      
        if (s.equalsIgnoreCase("Y"))
        	return true; 
        else 
        	return false;
	}
	
	/**
	 * Gets the cost if the player is creating a new property 
	 * @param p = Player that is making new property
	 * @return = the cost the Player does
	 */
	private int getNewCost(Player p)
	{
	     int i;
	     i = keyboard.nextInt();
	    //keyboard.nextInt();
         while(i < 100 || i > p.getMoney()) 
         {
            System.out.println("Please enter a valid integer.");
            i = keyboard.nextInt();
         }
         return i; 
	}
	
	/**
	 * If the player lands on the spot
	 * Used in ToString()
	 * @param p = the player that landed on that spot of the board
	 */
	public void AddPlayerOnSpot (Player p)
	{
		onspot.add(p);
	}
	
	public void ClearPlayersOnSpot()
	{
		onspot.removeAllElements();
	}
	
	public Vector<Player> GetPlayersOnSpot()
	{
		return onspot; 
	}
}
