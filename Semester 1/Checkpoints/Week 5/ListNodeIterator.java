
import java.util.*;
 
 
public class ListNodeIterator<E> implements Iterator<ListNode<E>>
{
     
    private LinkedList list;
    private ListNode curr;
     
    public ListNodeIterator (LinkedList thelist)
    {
        list = thelist;
        curr = thelist.getListNode(0);
    }
     
    public boolean hasNext()
    {
        return curr.getNext() != null;
    }
     
    public ListNode next()
    {
        if(!hasNext())
            throw new Error("Nothing left!");
        else
        {
        	curr = curr.getNext(); 
            return curr;
        }
    }

	@Override
	public void remove() 
	{
		// TODO Auto-generated method stub
	}
    
}