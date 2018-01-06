/**
 * The tree class. Nature is fun.
 * @author Amol
 * @version infinite
 */
public class Tree
{
	/**
	 * Left tree
	 */
	private Tree left;
	/**
	 * Right tree
	 */
	private Tree right;
	/**
	 * Value of the tree
	 */
	private String value; 

	/**
	 * Creates tree with both left and right set
	 * @param v value
	 * @param rv right value
	 * @param lv left value
	 */
	public Tree (String v, String rv, String lv)
	{
		left = new Tree (lv);
		right = new Tree (rv); 
		value = v;  
	}
	
	/**
	 * Creates tree with just its own value
	 * @param v value 
	 */
	public Tree(String v)
	{
		left = new Tree(); 
		right = new Tree(); 
		value = v; 
	}

	/**
	 * Creates a tree with nothing
	 */
	public Tree ()
	{
		left = null;
		right = null; 
		value = null; 
	}
	
	//Modifiers
	public void setLeft (Tree a) { left = a; } 
	
	public void setRight (Tree a) { right = a; }
	
	public void setVal (String v) { value = v; }; 
	
	//Accessors
	public Tree getLeft() { return left; }
	
	public Tree getRight() { return right;}
	
	public String getVal() { return value;} 
}
