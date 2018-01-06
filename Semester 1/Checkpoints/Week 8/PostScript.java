
public class PostScript 
{
	private String stackin;
	private Stack<Character> one; 
	private Stack<Character> two; 
	
 	public PostScript(String in)
 	{
 		stackin = in; 
 		for (int i = 0; i < stackin.length(); i++)
 		{
 			one.add(stackin.charAt(i));
 		}
 	}
 	
 	public void dofunction()
 	{
 		Character store = one.get();
 			 switch (store) 
 			 { 
 			 	case   '+' : one.remove(); one.add(Integer.toString( Integer.parseInt(two.remove( + "") + Integer.parseInt(two.remove() + ""))).charAt(0)) ;  break;
 			 	case   '-' : one.remove(); one.add(Integer.toString( Integer.parseInt(two.remove( + "") - Integer.parseInt(two.remove() + ""))).charAt(0)) ;  break;
 			 	case   '/' : one.remove(); one.add(Integer.toString( Integer.parseInt(two.remove( + "") / Integer.parseInt(two.remove() + ""))).charAt(0)) ;  break;
 			 	case   '*' : one.remove(); one.add(Integer.toString( Integer.parseInt(two.remove( + "") * Integer.parseInt(two.remove() + ""))).charAt(0)) ;  break;
 			 }
 			 
		 	two.add(one.remove());
 	}
}
