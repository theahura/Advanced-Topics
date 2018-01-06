import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile 
{
	private String path; 
	
	public ReadFile (String p)
	{
		path = p; 
	}
	
	public String [] StoreFile() throws IOException 
	{
		FileReader reader = new FileReader(path);
		BufferedReader textRead = new BufferedReader(reader); 

		String[] textData = new String[getNumLines()]; 

		for(int i = 0; i < getNumLines(); i++)
		{
			textData[i] = textRead.readLine(); 
		}
		
		textRead.close(); 
		
		return textData; 
	}
	
	public int getNumLines() throws IOException
	{
		FileReader reader = new FileReader(path);
		BufferedReader textRead = new BufferedReader(reader); 
		
		String line; 
		int numLines = 0; 
		
		while ((line = textRead.readLine()) != null)
		{
			numLines++; 
		}
		
		textRead.close(); 
		
		return numLines; 
	}
}
