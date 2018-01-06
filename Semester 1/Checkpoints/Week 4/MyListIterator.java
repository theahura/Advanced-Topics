import java.util.*;
 
 
public class MyListIterator implements Iterator<Integer>
{
     
    private MyList list;
    private int curr;
     
    public MyListIterator(MyList thelist)
    {
        list = thelist;
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
            curr+=2;
            return list.get(curr - 1);
        }
    }
     
    @Override
    public void remove()
    {
    	list.remove(curr);
    }
     

}