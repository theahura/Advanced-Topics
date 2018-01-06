public class ListNode<E>
{
    private ListNode<E> next;
    private E item;
     
     
    public ListNode(E data)
    {
        item = data;
         
        //Redundant
        next = null;
     
    }
     
    public ListNode(E data, ListNode n)
    {
        item = data;
        next = n;
    }
     
    //Modifier
    public void setNext(ListNode newNext)
    {
        next = newNext;
    }
     
    //Accessors
    public ListNode getNext() { return next; }
    public E getItem() { return item; }
     
    public String toString()
    {
        return "| " + item.toString() + " | ->";
    }
     
     
     
     
     
     
 
}