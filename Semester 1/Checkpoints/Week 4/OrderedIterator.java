import java.util.*;
 
 
public class OrderedIterator implements Iterator<String>
{
     
    private MyList list;
    private int curr;
     
    public MyListIterator(Iterator a)
    {
	 	 while (a.hasNext())
		 {
		 	list.add(a.next());
		 }

        curr = 0;
    }
     
    public boolean hasNext()
    {
        return curr < list.size()-1;
    }
     
    public Integer next()
    {
        if(!hasNext())
            throw new Error("Nothing left!");
        else
        {
            curr++;
            return Character(list.get(curr - 1));
        }
    }
     
    @Override
    public void remove()
    {
    	list.remove(curr);
    }
     

}