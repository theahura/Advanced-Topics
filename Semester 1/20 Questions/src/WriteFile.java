
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException; 

public class WriteFile 
{
	private String path; 
	private boolean append_to_file = true;
	
	public WriteFile(String filepath)
	{
		path = filepath;
	}
	
	public WriteFile(String filepath, boolean append)
	{
		path = filepath;
		append_to_file = append; 			
	}
	
	public void WriteToFile (String text) throws IOException 
	{
		FileWriter write = new FileWriter(path, append_to_file);
		PrintWriter print = new PrintWriter(write);
		
		print.printf("%s"+"%n", text); 
		
		print.close(); 
	}
}
