import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest 
{
	public static void main(String[] args) 
	{
		try 
		{
			FileWriter writer = new FileWriter("poem.txt");
			writer.write("Roses are red d d dd");	
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(new java.io.File("poem.txt").getAbsolutePath());
	}

}
