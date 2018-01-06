import java.util.Iterator;

public class LinkedList<E> extends AbstractList<E>
{
    private ListNode<E> head;
     
    private void add(ListNode<E> node)
    {
        if(head == null)
        {
            head = node;
            return;
        }
        else
        {
            add(node, head);
        }
         
        //Not great iterative version - let's forget this.
        /*for(ListNode curr = head; curr != null; curr = curr.getNext())
        {
            if(curr.getNext() == null)
            {
                curr.setNext(node);
            }
         
        }*/
    }
     
    public int size()
    {
        return size(head); 
    }
     
    private int size(ListNode<E> node)
    {
        if(node == null)
        {
            return 0;
        }
        else
        {
            return 1 + size(node.getNext());
        }
    }
     
    private void add(ListNode<E> node, ListNode<E> curr)
    {
        //(SP)[B]ase Case
        if(curr.getNext() == null)
        {
            curr.setNext(node);
        }
        else
        {
            add(node, curr.getNext());
        }
     
    }
     
    public void add(E item)
    {
        add(new ListNode<E>(item));
    }
     
    public String toString()
    {
        String toReturn = "";
        for(ListNode<E> curr = head; curr != null; curr = curr.getNext())
        {
            toReturn += curr.toString();           
        }
        return toReturn;
    }
 
    public static void main(String [] args)
    {
        LinkedList<Integer> list = new LinkedList();
        list.add(8);
        list.add(3);
        list.add(2);
        System.out.println(list);
        System.out.println(list.size());
    }

	@Override
	public void clear() 
	{
		head.setNext(null);
		head = null; 
	}

	@Override
	public E remove(E value) 
	{
		for(ListNode curr = head; curr.getNext().getNext() != null; curr = curr.getNext())
        {
			if (curr.getNext().getItem() == value)
			{
				ListNode store = curr.getNext();
				curr.setNext(curr.getNext().getNext());
				return (E) curr.getNext().getItem(); 
			}
        }
		return null;
	}

	@Override
	public int indexOf(E value) 
	{
		int index = 0; 
		for(ListNode curr = head; curr != null; curr = curr.getNext())
        {
			index ++; 
			if (curr.getItem() == value)
			{
				return index; 
			}
        }
		return -1;
	}

	@Override
	public int lastIndexOf(E value) 
	{
		int index = 0; 
		int returnval = -1;
		for(ListNode curr = head; curr != null; curr = curr.getNext())
        {
			index ++;
			if (curr.getItem() == value)
			{
				returnval = index; 
			}
        }
		return returnval;
	}

	@Override
	public E get(int i) 
	{
		int index = 0; 
		for(ListNode curr = head; curr != null; curr = curr.getNext())
        {
			index ++;
			if (index == i)
			{
				return (E) curr.getItem();
			}
        }
		return null;
	}

	@Override
	public E set(int i, E o) 
	{
		int index = 0; 
		
		ListNode newnode = new ListNode(o);
		
		for(ListNode curr = head; curr.getNext().getNext() != null; curr = curr.getNext())
        {
			index ++;
			if (index == i-1)
			{
				ListNode store = curr.getNext().getNext(); 
				
				curr.setNext(newnode); 
				
				newnode.setNext(store);
				
				return (E) store.getItem();
			}
        }
		return null;
	}

	@Override
	public void add(int i, E o) 
	{
		int index = 0; 
		
		ListNode newnode = new ListNode(o);
		
		for(ListNode curr = head; curr.getNext() != null; curr = curr.getNext())
        {
			index ++;
			if (index == i)
			{
				ListNode store = curr.getNext(); 
				
				curr.setNext(newnode); 
				newnode.setNext(store);
			}
        }
	}

	@Override
	public E remove(int i) 
	{
		int index = 0; 
		
		for(ListNode curr = head; curr.getNext().getNext() != null; curr = curr.getNext())
        {
			index ++;
			if (index == i-1)
			{
				ListNode store = curr.getNext().getNext(); 
				ListNode returnedstore = curr.getNext();
				curr.setNext(store); 
				
				return (E) returnedstore.getItem(); 
			}
        }
		return null;
	}

	@Override
	//WHY DOES THIS RETURN NULL?
	public Iterator<E> iterator() 
	{
		
		return null;
	}
 
	public ListNode getListNode(int i)
	{
		int index = 0;
		for(ListNode curr = head; curr != null; curr = curr.getNext())
        {
			index++;
			if (index == i)
			{
				return curr;
			}
        }
		
		return null; 
	}
}