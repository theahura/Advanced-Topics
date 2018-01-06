/**
 * The application that runs the Silver Dollar game
 * 
 * @author Amol Kapoor
 * @version 1.0
 */

 import java.util.Scanner;

public class SilverDollarApp 
{
	/**
	 * An initialization of the Scanner class for user input
	 */
	private static Scanner input = new Scanner(System.in);
	
	/**
	 * An initialization of the strip of coins to be used for the game
	 */
    private static CoinStrip coins = new CoinStrip(); 
    
    /**
     * Runs our game, gives prompts, calls inputs, etc. etc. 
     * @param args
     */
    public static void main(String [] args)
    { 	   
        /**
         * Keeps track of which players turn it is
         */
    	boolean TurnIndex = true; 
    	 
		//Starting input prompts 
    	System.out.println("Welcome to the Silver Dollar Game!");
    	System.out.println("Here is your coinstrip: \n");
      System.out.println(coins);
      System.out.println(coins.GetRuler());
        
        
        while (!GameOver())
        {
        	//Player One
        	if (TurnIndex)
        	{
        		TurnIndex = false; 

        		if (!GetInput(1))
        		{
        			System.out.println("Congrats Player 2, it's your turn because Player 1 is an idiot.");
        		}
        	}
        	//Player Two
        	else 
        	{
        		TurnIndex = true; 
        		if (!GetInput(2))
        		{
        			System.out.println("Congrats Player 1, it's your turn because Player 2 is an idiot.");
        		}
        	}
        	
			//Prints coinstrip
        	System.out.println("\n End of round.");
        	System.out.println("Here is your coinstrip: \n");
            System.out.println(coins);
            System.out.println(coins.GetRuler());
        }        
        
        if (TurnIndex)
        	System.out.println("PLAYER 2 WINS!");
        else 
        	System.out.println("PLAYER 1 WINS!");
    }
    
    /**
     * Checks to see if all the coins are on the far left slots
     * @return: Returns whether the game is over or not
	  * @post: if true, game ends and winner is declared; if false, game continues
	  */
    public static boolean GameOver()
    {
        /**
         * Keeps track of current status of the game
         */
    	boolean GameOver = true; 
        
    	for (int i = 0; i < coins.GetCoinNum(); i++)
    	{
    		if (!coins.GetSlot(i))
    			GameOver = false; 
    	}
    	
    	return GameOver; 
    }
    
    /**
     * Gets the input of the player, and checks to make sure that input is valid.
     * 
     * @param PlayerNum: The player whose turn it is
     * @return: False is a non-successful input, resulting in a punishment for the player. True allows the game to continue. 
     * @post: Player input is used to move coins  
	  */
    public static boolean GetInput(int PlayerNum)
    {
    	/**
    	 * Keeps track of whether the player makes a mistake
    	 */
    	boolean GetsPunished = false; 
    	
		System.out.println("Player " + PlayerNum + ", select a slot with a coin:");
		
		/**
		 * The slot with a coin that the player selects
		 */
		int SelectedCoin; 
		
		while(!input.hasNextInt()) 
		{
	           System.out.println("Please enter a valid integer.");
	           input.next();
	    }
		
		SelectedCoin = input.nextInt();
			
		//Makes sure the selected coin is within the strip/is actually a coin
    	try 
    	{
    		assert SelectedCoin < coins.GetStripSize() : "You selected a slot that doesn't exist, you dolt. You lose a turn."; 
    		assert coins.GetSlot(SelectedCoin) : "You selected a slot without a coin, you dolt. Try again."; 
		}
		catch (AssertionError e)
		{
			System.out.println(e.getMessage());
			GetsPunished = true; 
		}
		
    	if (GetsPunished)
    		return false; 
    	
		System.out.println("Player " + PlayerNum + ", select a empty slot for the selected coin:");
		
		/** 
		 * The slot that is selected to move the coin to. 
		 */
		int SelectedSlot; 
		
		while(!input.hasNextInt()) 
		{
	           System.out.println("Please enter a valid integer.");
	           input.next();
	    }
		
		SelectedSlot = input.nextInt();
		
		//makes sure the slot that the coin is moving to is to the left of the coin/is empty
    	try 
    	{
    		assert SelectedSlot < SelectedCoin : "You selected a slot that isn't to the left of the coin, you dolt. You lose a turn."; 
    		assert !coins.GetSlot(SelectedSlot) : "You selected a slot with a coin, you dolt. Try again."; 
    	}
		catch (AssertionError e)
		{
			System.out.println(e.getMessage());
			GetsPunished = true; 
		}
    	
    	if (GetsPunished)
    		return false; 
    	
    	//calls the move check
    	if (!ChecknMove(SelectedCoin, SelectedSlot))
    		return false;
    	
    	return true; 
    }
    
    /**
     * Checks whether the coin is passing over another coin while trying to move. 
     * @param CoinSlot: Where the coin starts
     * @param MoveSpot: Where it is supposed to go
     * @return: False means there is a coin in between, true means there isn't.
     * @pre: There isn't a coin in between coinspot and movetospot
     * @pre: Both CoinSpot and Movetospot are within the strip length
     * @pre: MovetoSpot is to the left of Coinspot
     * @post: calls the actual switch in the coinstrip class, resulting in the values switching spots
     */
    public static boolean ChecknMove(int CoinSlot, int MoveSpot)
    {
    	for (int i = CoinSlot; i > MoveSpot; i--)
    	{
    		if (coins.GetSlot(i))
    		{
    			System.out.println("You can't go over another coin, you dolt. You lose this turn.");
    			return false; 
    		}
    	}
    	
    	coins.MoveCoin(CoinSlot, MoveSpot);
    	return true; 
    }
}
