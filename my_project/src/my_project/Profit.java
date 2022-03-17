package my_project;

import java.util.ArrayList;

public class Profit {
	int profitMax(ArrayList<Integer> list)
	{
		int profit = 0;
		int max = 0;
		for (int i = 0; i < list.size(); i++)
		{
			for (int x = i + 1; x < list.size(); x++)
			{
				if(list.get(max) <= list.get(x))
				{
					max = list.get(x);
				}
			}
			if(list.get(max) - list.get(i) >= profit)
			{
				profit = list.get(max) - list.get(i);
			}
		}
		return profit;
	}
}
