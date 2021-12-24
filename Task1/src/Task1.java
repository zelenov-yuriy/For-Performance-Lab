public class Task1 
{
	public static int increase(int p1, int n, int m)
	{
		int p2 = 0;
		m--;
		
		if(p1+m < n)
			p2 = p1 + m;
		else
		{
			m -= (n - p1);
			p2 = m % n;
		}
		return p2;
	}
	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		
		int[] array = new int[n];
		for(int i=0; i<n; i++)
			array[i] = i+1;
		
		int p1 = 0;
		int p2 = Task1.increase(p1, n, m);
		
		while(p2 != 0) 
		{
			System.out.print(array[p1]);
			p1 = p2;
			p2 = Task1.increase(p1, n, m);
		}
		
		System.out.println(array[p1]);
	}
}
