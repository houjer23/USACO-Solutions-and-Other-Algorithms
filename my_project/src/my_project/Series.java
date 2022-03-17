package my_project;

import java.util.ArrayList;

public class Series {
	public static void main(String[] args) {
		findn(5);
     }
	static int findn(int n)
	{
		ArrayList<Integer> series = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
		{
			if (i == 0 || i == 1)
			{
				series.add(1);
			}
			else
			{
				series.add(series.get(i - 1) + series.get(i - 2));
			}
		}
		return series.get(n - 1);
	}
	static int getSum(int n)
	{
		if(n == 1)
		{
			return 1;
		}
		else
		{
			return n + getSum(n - 1);
		}
	}
	static int getProduct(int n)
	{
		if(n == 1)
		{
			return 1;
		}
		else
		{
			return n * getSum(n - 1);
		}
	}
	static int getFib(int n)
	{
		if(n == 1 || n == 2)
		{
			return 1;
		}
		return getFib(n - 1) + getFib(n - 2);
	}
}
