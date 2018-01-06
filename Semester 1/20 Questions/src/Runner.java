import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * The process works like this: you will need a Binary Tree where the value of each node 
 * contains a question and the branches represent the answer to that question. For example: if the question is 
 * “Is it a plant?” then all the nodes to the right represent the line of questioning if it is indeed a plant, 
 * while all the nodes to the left represent the questions for if it is not a plant.
 
Your algorithm to code the game should look like this:

-       Look at the current node (which will be the root node to start).

-       If the pointer is not null, output the question it contains and get an answer.

-       If the answer is yes, move to the current node’s right branch.

-       If the answer is no, move to the current node’s left branch.

-       If the branch you want to move to is null, ask the user to enter a description of the item they 
		are thinking of and store that as the description at add it to the tree.

-       Go back to the beginning and repeat.
 
Things to implement:
 
-       A reset option to clear all data from the game.

-       A way for the game to remember what data it has even after it has been closed. To do this you’re going to need to do some quick research on file input and output. Use a helper .txt file to store and retrieve your information. (Hint – you might want to consider traversals when deciding how to store your information.)

 */


public class Runner 
{
	/**
	 * Root of the tree
	 */
	private static Tree root; 
	
	/**
	 * Path of the memory file
	 */
	private static String path; 
	
	/**
	 * All the info in the file
	 */
	private static ArrayList<String> datastore; 
	
	/**
	 * Writes to file
	 */
	private static WriteFile data; 
	
	/**
	 * Reads file
	 */
	private static ReadFile read; 
	
	/**
	 * Input
	 */
	static Scanner keyboard = new Scanner(System.in); 
		
	public static void main (String [] args) throws IOException
	{
		//Initializing a lot of things!
		datastore = new ArrayList <String> (); 
		
		datastore.add(null);

		path = System.getProperty("user.dir") + "\\test.txt";
		data = new WriteFile(path, true);
		read = new ReadFile(path);
		 
		root = new Tree();
		
		Tree left = new Tree();
		Tree right = new Tree ();
		
		root.setLeft(left); 	
		root.setRight(right); 
		
		String[] file = read.StoreFile(); 
		
		//Checks if there is already memory
		if (file.length > 0)
		{
			System.out.println("Do you want to use the previous save file? Y/N");
			if (keyboard.nextLine().equalsIgnoreCase("y"))
			{
				//Builds tree from data
				BuildTree(root, file, 1); 
				System.out.println(root.getVal());
				System.out.println("Think of an object...");
				Run(root);
			}
			else
			{
				System.out.println("Welcome to 20 Plus Questions! The computer will try to read your mind!");
				
				String start = "Computer"; 
				
				data.WriteToFile(start);
				
				root.setVal("a " + start); 
		
				System.out.println("Type reset at any prompt to clear the board. Type stop to end the game.");
				
				System.out.println("Think of an object...");
				
				Run(root);
			}

		}
		else
		{
			PrintWriter writer = new PrintWriter(path);
			writer.print("");
			writer.close();
			
			System.out.println("Welcome to 20 Plus Questions! The computer will try to read your mind!");
			
			String start = "Computer"; 
			
			data.WriteToFile(start);
			
			root.setVal("a " + start); 
	
			System.out.println("Type reset at any prompt to clear the board. Type stop to end the game.");
			
			System.out.println("Think of an object...");
			
			Run(root);
		}
	}
	
	/**
	 * Runs the 20Qs
	 * @param t: current node in the tree
	 * @return: boolean for recursion stack
	 * @throws IOException: Java made me
	 */
	public static boolean Run(Tree t) throws IOException
	{			
		System.out.println("Is it " + t.getVal() + "? Y/N");
		
		String response = keyboard.nextLine();
		
		//Calls prompt per input to see if they're stopping or resetting
		if (!Prompt(response))
		{
			return false; 
		}
		else if (response.equalsIgnoreCase("Y"))
		{	
			//If prompt is true, goes right
			if (t.getRight().getVal() != null)
			{
				return Run(t.getRight());
			}
			else
			{
				System.out.println("HA I GOT IT! Lets play again! Think of an object?");
				return Run(root);
			}
		}
		else 
		{
			//If prompt is false, goes left
			if (t.getLeft().getVal() != null)
			{
				return Run(t.getLeft());
			}
			//Adds to the tree
			else  		
			{
				//Adds the object
				System.out.println("Darn, you stumped me. What was the object you were thinking of? It was a _____________.");
				
				String object = keyboard.nextLine(); 
				
				if (!Prompt(object)) 
				{
					return false; 
				}
				else
				{
					object = "a " + object;  	
				}
				//Adds the differentiating node
				System.out.println("What is one trait that differentiates your object from " + t.getVal() + "? It is ___________.");
				
				String trait = keyboard.nextLine();  
				
				if (!Prompt(trait))
				{
					return false; 
				}
				//Shuffles the tree
				Tree left = new Tree(t.getVal());
				Tree right = new Tree (object);
				
				t.setLeft(left);
				t.setRight(right); 
				t.setVal(trait);
				
				System.out.println("Think of a new object...");

				PrintWriter writer = new PrintWriter(path);
				
			    writer.print("");
				writer.close();
				
				StoreHelper(root); 
				
				return Run(root);
			}	
		}
	}
	
	/**
	 * Prompts per input if the player wants to restart or not
	 * @param response: If the answer is yes or no
	 * @param root: Root of the tree
	 * @return: Recursion 
	 * @throws IOException: Java made me
	 */
	public static boolean Prompt(String response) throws IOException
	{
		//Kills game
		if (response.equalsIgnoreCase("stop"))
		{
			System.out.println("Thank you for playing!");
			return false; 
		}
		//Resets initializations
		else if (response.equalsIgnoreCase("reset"))
		{
			PrintWriter writer = new PrintWriter(path);
			writer.print("");
			writer.close();
			
			Tree left = new Tree();
			Tree right = new Tree ();
			
			root.setLeft(left); 	
			root.setRight(right); 
			
			System.out.println("Welcome to 20 Plus Questions! The computer will try to read your mind! Think of an object, to start off your game. Your object is a __________.");
			
			String store = keyboard.nextLine(); 
						
			root.setVal("a " + store); 

			System.out.println("Type reset at any prompt to clear the board. Type stop to end the game.");
			
			System.out.println("Think of a new object...");
			
			return Run(root);
		}
		
		return true; 
	}
	/**
	 * Builds the tree from file input using x2 and x2+1
	 * @param t: Current tree (node) that is built
	 * @param data: The data used from the file
	 * @param index: Where in the data from the file is it
	 */
	public static void BuildTree(Tree t, String[] data, int index)
	{
		if (index < data.length)
		{
			System.out.println(index);
			System.out.println(data[index]);
			t.setVal(data[index]);
			
			Tree right = new Tree();
			Tree left = new Tree();
			
			t.setLeft(left);
			t.setRight(right);
			
			
			BuildTree(t.getLeft(), data, index*2);
			
			BuildTree(t.getRight(), data, index*2+1);
		}
	}
	
	/**
	 * Helps store the tree
	 * @param t: the tree it is on
	 * @throws IOException: Java made me
	 */
	public static void StoreHelper(Tree t)throws IOException
	{
		Store(t, 1);
		
		for (int i = 0; i < datastore.size(); i++)
		{
			System.out.println(datastore.get(i) + "HI!");
			data.WriteToFile(datastore.get(i));
		}
	}
	
	/**
	 * Stores each node in the tree using x2 and x2+1 set up
	 * @param t: The tree it is recursing on
	 * @param index: the index of the data
	 * @throws IOException: Java made me
	 */
	public static void Store (Tree t, int index) throws IOException
	{ 
		while (datastore.size()-1 < index)
		{
			datastore.add(null);
		}
		
		datastore.set(index, t.getVal());
		
		if (t.getLeft().getVal() != null)
		Store(t.getLeft(), index*2);
		
		if (t.getRight().getVal() != null)
		Store(t.getRight(), index*2+1);		
	}
}
