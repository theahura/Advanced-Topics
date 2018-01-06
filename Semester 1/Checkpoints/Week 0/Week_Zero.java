/* 
 * Design a data structure to represent a combination lock. When the
lock is constructed, it is provided with an arbitrary length array of integers
between 0 and 25 specifying a combination (if no combination is provided,
9  0  21  0 is the default). Initially, it is locked. Two methods—press
and reset—provide a means of entering a combination: press enters the next
integer to be used toward matching the combination, while reset re-readies
the lock for accepting the first integer of the combination. Only when press is
used to match the last integer of the combination does the lock silently unlock.
Mismatched integers require a call to the reset method before the combination
can again be entered. The isLocked method returns true if and only if the lock
is locked. The lock method locks and resets the lock. In the unlocked state only
the isLocked and lock methods have effect. 

 * 
 */
public class Week_Zero 
{
	private int [] combo; 
	private boolean lock;
	private int index; 
	
	public Week_Zero(int [] setting)
	{
		combo = setting; 
		lock = true; 
	}
	
	public Week_Zero()
	{
		combo = new int [4];
		combo[0] = 9;
		combo[1] = 0;
		combo[2] = 21; 
		combo[3] = 0;
		
		lock = true; 
	}
	
	public void Press(int input)
	{
		if (!lock)
		{
			if (input == combo[index])
				index++;
			//not sure if the next part is needed; instructions were unclear as to whether it gets called in the method or 
			//if reset needs to be called externally; if the second, just comment the next two lines. 
			else 
				Reset(); 
			
			if (index == combo.length)
				lock = false; 
		}
	}
	
	public void Reset()
	{
		if (!lock)
		index = 0; 
	}
	
	public boolean isLocked()
	{
		if (lock)
			return true; 
		return false; 
	}
	
	public void Lock()
	{
		lock = true; 
		Reset(); 
	}
}
