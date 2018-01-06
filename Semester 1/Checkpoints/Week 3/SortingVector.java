import java.util.Comparator;

/**
 * Extend the Vector class we made in class with a new object called 
 * SortingVector. Design a method called sort that takes in a 
 * Comparator of type E. Choose whichever sorting algorithm you would 
 * like and implement a sort using the Comparator.
 * 
 * @author Amol Kapoor
 *
 */

//Didnt have the Vector class we wrote in class. 
public class SortingVector <E extends Comparable> implements Comparator
{
	private Object[] Stuff; 
	
	public SortingVector(E [] A)
	{
		Stuff = A; 
	}
	
	public Object[] Sort(Comparator <E> Comp)
	{
		for (int i = 0; i < Stuff.length; i++)
		{
			Object temp = Stuff[i];
			int store = i; 
			
			for (int z = 0; z < Stuff.length; z++)
			{
				if (compare((E)Stuff[z], (E)temp) > 0)
				{
					store = z; 
					temp = Stuff[z];
				}
			}
			
			Stuff[store] = Stuff[i];
			Stuff[i] = temp; 	
		}
		
		return Stuff; 
	}
	

	@Override
	public int compare(Object arg0, Object arg1) 
	{
		E Obj1 = (E) arg0; 
		E Obj2 = (E) arg1; 
		return Obj1.compareTo(Obj2);
	}
	
}
