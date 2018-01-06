import java.util.Vector;


public class Stack<E> extends Vector<E>
{
	public Stack ()
	{
		super();
	}
	
	public Stack(int s)
	{
		super(s);
	}
	
	public boolean push(E item)
	{
		return add(item); 		
	}
	
	public E pop()
	{
		E thing = peek();
		remove(size() - 1);
		return thing;
	}
	
	public E peek()
	{
		return get(size() - 1);
	}
	
	public boolean getempty()
	{
		if (size() > 0)
			return true;
		return false; 
	}
}
