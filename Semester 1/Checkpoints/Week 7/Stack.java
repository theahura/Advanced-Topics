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
	
	public boolean add(E item)
	{
		return add(item); 		
	}
	
	public E remove()
	{
		E thing = get(size()-1);
		remove(size() - 1);
		return thing;
	}
	
	public E get()
	{
		return get(size() - 1);
	}
	
	public int size()
	{
		return size(); 
	}
	
	public boolean getempty()
	{
		if (size() > 0)
			return true;
		return false; 
	}
}
