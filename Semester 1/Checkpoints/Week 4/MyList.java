import java.util.*;
 
 
public class MyList extends ArrayList<Integer>
{

    @Override
    public Iterator<Integer> iterator()
    {
        return new MyListIterator(this);
    }
 
}