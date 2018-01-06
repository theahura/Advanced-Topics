/**
 * A datastructure that manages an array in the form of a strip of coins. 
 * Each spot in the array can either be empty or contain one coin.
 * 
 * @author Amol Kapoor
 * @version 1.0
 */
public class CoinStrip 
{
	/**
	 * The array that holds our coins
	 */
    private boolean[] StripSlots;
    
    /** 
     * The amount of coins
     */
    private int Coins = 0; 
    

    /**
     * Creates a new coinstrip randomly from 4-100. 
     * Populates the coinstrip with coins by flipping a coin; if its heads, it will place a coin on 
     * that spot of the strip. 
     * 
     * @post: a coinstrip populated randomly with coins, a value of the number of coins stored in the var coins
     */
    public CoinStrip()
    {
        StripSlots = new boolean[(int) (Math.random() * 97)+4];
        
        for (int i = 0; i < StripSlots.length; i++)
        {
            if (StripSlots[i] == false && Math.random() < .5)
            {
                StripSlots[i] = true;
                Coins++;
            }
        }
    }
    
    /**
     * Returns the strip of coins, with empty spaces represented as 
     * [ ] and spaces with coins represented as [o]
     * 
     * @return: a string representing the value of the coinstrip
     */
    public String toString()
    {
        String returnstring = "";
        
        for (boolean a : StripSlots)
        {
            if (a)
                returnstring = returnstring + "[o]";
            else
                returnstring = returnstring + "[ ]";
                
        }
        
        return returnstring; 
    }
    
    /**
     * Creates a ruler to make it easier to determine which space a coin is in
     * @return: Returns a ruler that has an int per slot in the coinstrip
     */
    public String GetRuler()
    {
    	String Ruler = "";
    	
    	for (int i = 0; i < StripSlots.length; i++)
    	{
    		if (i < 10)
    		{
    			Ruler += " " + i + " ";
    		}
    		else if (i >= 10 && i < 100)
    		{
    			Ruler += " " + i; 
    		}
    		else 
    			Ruler += i; 
    	}
    	
    	return Ruler; 
    }
    
    /**
     * 
     * @return: returns the number of coins in the coinstrip
     */
    public int GetCoinNum()
    {
    	return Coins; 
    }
    
    /**
     * 
     * @return: the size of the strip of coins
     */
    public int GetStripSize()
    {
    	return StripSlots.length; 
    }
    
    /**
     * 
     * @param Index: The index of the strip we are searching
     * @return: The value at the index of the param Index
     */
    public boolean GetSlot(int Index)
    {
    	return StripSlots[Index];
    }
    
    /**
     * Moves coin from the coinspot to the movespot.
     * @param CoinSpot: The coin that is selected
     * @param MovetoSpot: The place where that coin is being moved.
     * @pre: There isn't a coin in between coinspot and movetospot
     * @pre: Both CoinSpot and Movetospot are within the strip length
     * @pre: MovetoSpot is to the left of Coinspot
     * @post: the values of coinspot and movetospot on the coinstrip switch. 
     */
    public void MoveCoin(int CoinSpot, int MovetoSpot)
    {
    	StripSlots[CoinSpot] = false;
    	StripSlots[MovetoSpot] = true;
    }
}
