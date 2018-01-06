import java.util.Vector;

/**
 * 3. Create a data structure called Top10. It should act like a vector, only it limits itself to 10 objects. 
 * It should utilize generics, but ensure that all elements are capable of being compared 
 * (HINT - use Comparable interface). The 10 objects that the Top10 holds, are the 10 GREATEST objects that it 
 * has been given. For example, if the Top10 was holding type Integer as follows: 34, 23, 21, 19, 15, 11, 9, 6, 5, 2 
 * and you added the number 30, the 30 would be put in index 1, and the rest of the numbers shuffled down. 2 would be 
 * removed.
 * 
 * You only need to implement appropriate constructor(s), an add method, and a toString method.
 * @author Amol Kapoor
 * @version 1.0
 */
public class Top10 <E extends Comparable>
{
	/**
	 * What stores our top 10 things
	 */
	private Vector<E> Nums = new Vector<E>(10);
	
	/**
	 * Constuctor that sorts an object array by the compareTo interface
	 * @param a: An object array less than 10 in length that is converted to the Vector Nums
	 */
	public Top10 (Object[] a)
	{
		assert a.length < 11; 
		
		//sorts from largest to smallest
		for (int i = 0; i < a.length; i++)
		{
			Object temp = a[i];
			int store = i; 
			
			for (int z = 0; z < a.length; z++)
			{
				if (((E)a[z]).compareTo((E)temp) > 0)
				{
					store = z; 
					temp = a[z];
				}
			}
			
			a[store] = a[i];
			a[i] = temp; 	
		}
		
		for (int i = 0; i < a.length; i++)
		{
			Nums.set(i, (E) a[i]);
		}
	}
	
	/**
	 * Finds first spot in vector where obj is greater than the object already there, and then adds it to that spot
	 * Thing at last spot is eliminated.  
	 * @param obj: An object of type E
	 */
	public void add (E obj)
	{
		for (int i = 0; i < Nums.size(); i++)
		{
			if (obj.compareTo(Nums.get(i)) > 0)
			{
				Nums.add(i, obj);
				Nums.remove(Nums.size()-1);
				break;
			}
		}
	}
	
	/**
	 * @return: String version of the vector of things. 
	 */
	public String toString()
	{
		String store = "";
		for (int i = 0; i < Nums.size(); i++)
		{
			store += " [" + Nums.get(i) + "] ";
		}
		
		return store; 
	}
	

}