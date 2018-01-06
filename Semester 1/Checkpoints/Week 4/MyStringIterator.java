import java.util.*;
 
 
public class MyStringIterator implements Iterator<String>
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