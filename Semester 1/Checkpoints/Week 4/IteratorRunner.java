
public class IteratorRunner 
{
	public static void main (String[] args)
	{

		 MyList a = new MyList(); 	
		 a.add(1);
		 a.add(2);
		 a.add(1);
		 a.add(2);
		 a.add(1);
		 a.add(2);
		 a.add(1);
		 a.add(1);
		 for (Integer obj : a)
		 {
			 System.out.println(obj);
		 }
	}
}
