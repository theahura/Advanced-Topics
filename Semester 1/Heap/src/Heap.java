import java.util.List;
import java.util.Vector;


public class Heap<E extends Comparable>
{
	Vector<Comparable> data; 
	
	/* Make a new empty heap */
	public Heap()
	{
		data = new Vector<Comparable>();
	}

	/* Make a new Heap and then add all elements in itemsToAdd */
	public Heap(List<E> itemsToAdd)
	{
		data = new Vector<Comparable>(itemsToAdd.size());
		for (int i = 0; i < itemsToAdd.size(); i++)
		{
			add(itemsToAdd.get(i));
		}
	}

	/* Use heapUp to add item to the appropriate place in the heap */
	public void add(E item)
	{
		data.add(item);
		heapUp(data.size() - 1);
	}
	
	/* Remove the root. Replace root with the last element and heapDown */
	public E remove()
	{
		E store = (E) data.get(0);
		data.set(0, data.get(data.size()-1));
		data.setSize(data.size()-1);
		if (data.size() > 1)
			heapDown(0);
		
		return store; 
	}
		
	/* Returns the index of the parent value of i */
	private int parent(int i)
	{
		return (i-1)/2;
	}
	
	/* Returns the index of the left child of i */
	private int left(int i)
	{
		return 2*i + 1; 
	}
	
	/* Returns the index of the right child of i */
	private int right(int i)
	{
		return 2*(i+1);
	}
	
	/* Take value at leaf and heap it up through the tree */
	private void heapUp(int leaf)
	{
		int root = parent(leaf); 
		Comparable value = data.get(leaf);
		while (leaf > 0 && (value.compareTo(data.get(root)) < 0))
		{
			data.set(leaf, data.get(root));
			leaf = root;
			root = parent(leaf);
		}
		data.set(leaf, value);
	}
	
	/* Take the root and heap it down the tree */
	private void heapDown(int root)
	{
		int heapSize = data.size(); 
		Comparable value = data.get(0);
		while (root < heapSize)
		{
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if (right(root) < heapSize && data.get(childpos+1).compareTo(data.get(childpos)) < 0)
				{
					childpos++;
				}
				
				if (data.get(childpos).compareTo(value) < 0)
				{
					data.set(root, data.get(childpos));
					root = childpos; 
				}
				else
				{
					data.set(root, value);
					return;
				}
			}
		}
	}
	
	/* Builds a heap and uses it to perform a Heap Sort on toSort. The method should return a sorted array of the elements contained within toSort. */
	public static Comparable[] heapSort(Comparable[] toSort)
	{		
		List <Comparable> store = new List<Comparable>(); 
		for (int i = 0; i < toSort.length; i++)
		{
			store.add(toSort[i]);
		}
		
		Heap<Comparable> heapdata = new Heap<Comparable>(store);
		
		
		while (true)
		{
			boolean sorted = true; 
			for (int i = 0; i < toSort.length-1; i++)
			{
				if (toSort[i].compareTo(toSort[i+1]) > 0)
				{
					sorted = false;
					break;
				}
			}
			
			if (sorted)
				break;
			
			toSort[0] = heapdata.remove(); 
		}
		
		return toSort; 
	}
}
