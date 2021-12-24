import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Task4 
{
	public static void main(String[] args) 
	{
		String fileName = args[0];		
		Path path = Paths.get(fileName);
		ArrayList<Integer> list = new ArrayList<Integer>();
		try 
		{
			Scanner scanner = new Scanner(path);
			while(scanner.hasNext())
			{
				list.add(scanner.nextInt());
			}
			scanner.close();
			list.sort(Comparator.naturalOrder());
			Integer[] array = list.toArray(new Integer[0]);			
			int arr[] = new int[array.length];
			for(int i=0; i<arr.length; i++)
				arr[i] = array[i].intValue();			
			int count = 0;
			int result = arr.length / 2;
			boolean ready = false;
			while(!ready)
			{
				for(int i=0; i<arr.length; i++)
				{
					if(arr[i] < arr[result])
					{
						arr[i]++;
						count++;
					}
					else if(arr[i] > arr[result])
					{
						arr[i]--;
						count++;
					}
				}
				ready = check(arr);
			}
			System.out.println(count);
		}
		catch(IOException e) { e.printStackTrace(); }
	}
	private static boolean check(int[] arr)
	{
		boolean result = true;
		for(int i=0; i<arr.length-1; i++)
			if(arr[i] != arr[i+1])
			{
				result = false;
				break;
			}
		return result;
	}
}
