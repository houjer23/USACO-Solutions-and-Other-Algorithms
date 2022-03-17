package my_project;

import java.util.ArrayList;

public class List {
	int findMinIndex(ArrayList<Integer> list)
	{
		int min = 0;
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(min) > list.get(i))
			{
				min = i;
			}
		}
		return min;
	}
}