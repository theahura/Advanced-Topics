
/**
 	The Pingopoly runner class/Gameboard class: 
 	
    If you run out of money - one property is destroyed and 50% of its value is added to that player’s money. If that property is fixed, the player simply loses ownership. 

	If you land on a property that you own, you can “expand” and build a new adjacent property. The player gets to name the property and invest the initial value.
	
	If you land on a property someone else owns, you must pay them 10% of the value of the property.

	To build a property that is “fixed,” it is double the cost. So a fixed property with a value of $1000 would cost $2000 to build. 

	Each player should start with a certain amount of money (play around with different values - you might want to start small so the game actually will end quickly, for testing purposes). 
  	
  	@author Amol Kapoor
  	@version 99.9
 */
import java.util.Scanner;
import java.util.Vector;

public class Pingopoly 
{
	/*
	 * GO! - Purple Mediterranean Avenue $60 - Community Chest - Purple Baltic Avenue $60 - 
	 * Income Tax Pay 10% or $200 - Reading Railroad $200 Light blue Oriental Avenue $100 - 
	 * Chance - Light blue Vermont Avenue $100 Light blue Connecticut $120 - Jail - 
*/
	//Could have instantiated this with a loop but I wanted all the original monopoly places	
	private static Go go = new Go();
	private static Place Boardwalk = new Place("Boardwalk", 400, go); 
	private static Place ParkPlace = new Place("ParkPlace", 350, Boardwalk);
	private static Place PenAve = new Place("Pensylvania Avenue", 320, ParkPlace);
	private static RemovePlayer removeplayer = new RemovePlayer(PenAve);
	private static Place NCaroAve = new Place("North Carolina Avenue", 300, removeplayer);
	private static Place PacifAve = new Place("Pacific Avenue", 300, NCaroAve);
	
	private static GoToJail gotojail = new GoToJail(PacifAve);
	
	private static Place MarvGard = new Place("Marvin Gardens", 280, gotojail);
	private static Place VentnorAve = new Place("Ventnor Avenue", 260, MarvGard);
	private static Place AtlanticAve = new Place("Atlantic Avenue", 260, VentnorAve);
	private static Place IllinoisAve = new Place("Illinois Avenue", 240, AtlanticAve);
	private static Place IndianaAve = new Place("Indiana Avenue", 220, IllinoisAve);
	private static Place KentuckAve = new Place("Kentucky Avenue", 220, IndianaAve);
	
	private static FreeParking freeparking = new FreeParking(KentuckAve);
	
	private static Place NYAve = new Place("New York Avenue", 200, freeparking);
	private static Place TennAve = new Place("Tennessee Avenue", 180, NYAve);
	private static Place StJames = new Place("St James Place", 180, TennAve);
	private static Place VirginAve = new Place("Virginia Avenue", 160, StJames);
	private static Place StatesAve = new Place("States Avenue", 140, VirginAve);
	private static Place StCharles = new Place("St Charles Place", 140, StatesAve);
	
	private static Jail jail = new Jail(StCharles);
	
	private static Place ConnAve = new Place("Connecticut Avenue", 140, jail);
	private static Place VermAve = new Place("Vermont Avenue", 120, ConnAve);
	private static Place OrientAve = new Place("Oriental Avenue", 80, VermAve);
	private static Remove remove = new Remove(OrientAve);
	private static Place BaltAve = new Place("Baltic Avenue", 60, remove);
	private static Place MeditAve = new Place("Mediterranean Avenue", 220, BaltAve);

	
	
	private static Vector<Player> PlayerList = new Vector <Player> ();
	/**
	 * Runs pingopoly
	 * @param args
	 */
	public static void main(String [] args)
	{ 
		//Just making sure the board connects to itself
		go.setNext(MeditAve);
		
		Scanner keyboard = new Scanner(System.in);
		//prints rules
		System.out.println("Welcome to Pingopoly.");
		System.out.println("The rules are simple: the game is monopoly, but with some stuff added."); 
		System.out.println("All the same rules, except if you land on another persons' property, you pay 10% the price of the property."); 
		System.out.println("If you land on a removespace, the game board modifies by removing one property."); 
		System.out.println("If you land on your own property, you can add a new space.");
		System.out.println("For more questions, see Mr. Burkhart.");
		
		System.out.println("Choose the number of players:");
		
	     int i = keyboard.nextInt(); 
	    while (i == 0)
	    {
	        System.out.println("Please enter a valid integer that is not zero.");
	        i = keyboard.nextInt();
	    }
	    
		boolean Copied = true; 

        for (int a = 0; a < i; a++)
        {
			//prompts users for names, which are used for rest of the game
			System.out.println("Player " + a + ", choose your name. "); 
			String s = "";
			s = keyboard.next();
		    keyboard.nextLine();
		      
			while (Copied == true && PlayerList.size() > 0)
			{
				for (int b = 0; b < PlayerList.size(); b++)
				{
				      if (s.equalsIgnoreCase(PlayerList.get(b).getName())) 
				      {
				         Copied = true;
				         break;
				      }
				      else
				    	  Copied = false;
				}
				
				if (Copied && PlayerList.size() > 0)
				{
					System.out.println("Your name matches someone else. Please choose again.");
		            s = keyboard.next();
		            keyboard.nextLine();
				}
			}
		    
			Player one = new Player (1000, s, go);
			PlayerList.add(one);
        }
	   
	   //to make this multiplayer, store player names in an array and dynamically add by asking user how many players he/she wants
	   //and then prompting name creation for each
	   
	  //would have to change Place ownership from bool to int though, and link each 'owner int' to a player instantiation. 
	   
	   boolean Gameover = false; 
	   
	   PrintBoard(PlayerList);
	   
	   int store = 0; 
	   
	   //Running loop 
	   while (!Gameover)
	   {
		   int playerturn = store % PlayerList.size();
		   
		   ChangeLocation(PlayerList.get(playerturn));
		   		 
		   PlayerList.get(playerturn).getLocation().Act(PlayerList.get(playerturn)); 
		   
		   PrintBoard(PlayerList); 
		   
		   //Checks that the player isn't in negative money
		  int check = CheckMoneys(PlayerList);
		  
		  if (check != 0)
		  {
			  System.out.println("CONGRADULATIONS " + PlayerList.get(check-1).getName() + ", YOU HAVE WON!");
			  Gameover = true; 
		  }
		  
		  store++;
		  
	   }
	}
	/**
	 * Checks to make sure there are no negative money values, and if there are, removes the first property owned by the player. 
	 * Can be made multiplayer if it takes in an array
	 * 
	 * @param one = Player one
	 * @param two = Player two
	 * @return = if either player wins or the game continues
	 */
	private static int CheckMoneys(Vector<Player> PList)
	{
		if (PList.size() == 1)
			return 1; 
		
		for (int i = 0; i < PList.size(); i++)
		{
			if (PList.get(i).getMoney() < 0)
			{
				Place start; 
				for (start = go; ((start.getNext().getOwner() != null && start.getNext().getOwner().getName().equals(PList.get(i).getName())) || start.getNext().getName().equals("Go")); start = start.getNext());
				
				
				if (!start.getNext().getName().equals("Go"))
				{
					PList.get(i).ChangeMoneyBy(start.getNext().getCost()/2);
					
					if (start.getNext().getFixed())
					start.getNext().setOwner(null);
					else
					start.setNext(start.getNext().getNext());
				}
				else
				{
					PlayerList.remove(i);
					i--; 
				}
			}
		}

		return 0; 
	}
	
	/**
	 * Automates the rolling function for the player, unless the player is jailed
	 * @param p = the player that rolls
	 */
	private static void ChangeLocation (Player p)
	{
		int Roll = (int) (Math.random() * 11) + 2;
		Place start = p.getLocation();
		if (p.getJailed() == 0)
		{
			System.out.println(p.getName() + ", you rolled " + Roll);
			start = p.getLocation().getNext();
			
			for (int i = 0; i < Roll-1; i++)
			{
				
				if (start.getName().equals("Go") )
				{
					start.Act(p);
				}
				
				start = start.getNext();
			}
		}		
		p.SetLocation(start);	
	}
	
	/**
	 * Prints out all of the places using the four corners of the board as starting points. Can be made multiplayer if it took in an array of players
	 * @param one = the first player (to determine its location)
	 * @param two = the second player (to determine its location)
	 */
	private static void PrintBoard(Vector<Player> Plist)
	{		
		Place start = go;
		
		//for some reason this didn't work as a forloop
		
		while(!start.getNext().getName().equals("Go")) 
		{
			if (start.getName().equals("Jail") || start.getName().equals("FreeParking") || start.getName().equals("Go To Jail!"))
				System.out.println();
			
			start.ClearPlayersOnSpot(); 
			
			for (int i = 0; i < PlayerList.size(); i++)
			{
				if (PlayerList.get(i).getLocation().getName().equals(start.getName()))
				{
					start.AddPlayerOnSpot(PlayerList.get(i));
				}
			}
						
			System.out.println(start);
			
			start = start.getNext();
		}

	}
}
