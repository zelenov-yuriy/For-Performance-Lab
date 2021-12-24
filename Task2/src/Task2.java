import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Task2 
{
	public static void main(String[] args) 
	{	
		try 
		{
			String fileName1 = args[0];		
			Path path1 = Paths.get(fileName1);
			Scanner scanner1 = new Scanner(path1);
			float centerX = scanner1.nextFloat();
			float centerY = scanner1.nextFloat();
			float radius = scanner1.nextFloat();
			scanner1.close();
		
			String fileName2 = args[1];
			Path path2 = Paths.get(fileName2);
			Scanner scanner2 = new Scanner(path2);
			while(scanner2.hasNext())
			{
				float pointX = scanner2.nextFloat();
				float pointY = scanner2.nextFloat();
				float distanceX = (pointX - centerX) * (pointX - centerX);
				float distanceY = (pointY - centerY) * (pointY - centerY);
				float distance = distanceX + distanceY;
				distance = (float)Math.sqrt(distance);
				if(distance < radius)
					System.out.println("1");
				else if(distance == radius)
					System.out.println("0");
				else 
					System.out.println("2");
			}
			scanner2.close();
		}
		catch(IOException e) { e.printStackTrace(); }
	}
}
