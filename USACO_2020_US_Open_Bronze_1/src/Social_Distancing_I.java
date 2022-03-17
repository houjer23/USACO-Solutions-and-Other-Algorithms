import java.util.*;
import java.io.*;

public class Social_Distancing_I {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("socdist1.in"));
		int size = Integer.parseInt(br.readLine());
		String farm = br.readLine();
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));
		pw.print(insert(farm, size));
		pw.close();
	}
	static int insert(String farm, int size){
		char[] farmChars = farm.toCharArray();
		int last = -1;
		int first_longest_distance = 0;
		int second_longest_distance = 0;
		int first_zero = 0;
		int last_zero = 0;
		int minspace = size - 1;
		List<Integer> space = new ArrayList<>();
		
		int flag = 0;
		for (int i = 0; i < size; i ++)
		{
			if (farmChars[i] == '1')
			{
				flag = 1;
				break;
			}
		}
		if (flag == 0)
		{
			return size - 1;
		}
		for (int i = 0; i < size; i ++)
		{
			if (farmChars[i] == '1')
			{
				if (i != 0 && last != -1)
				{
					space.add(i - last - 1);
					last = i;
				}
				else if (last == -1)
				{
					first_zero = i;
					last = i;
				}
			}
			if (i == size - 1 && farmChars[i] == '0')
			{
				last_zero = size - last - 1;
			}
		}
		for (int i = 0; i < space.size(); i ++)
		{
			if (space.get(i) < minspace)
			{
				minspace = space.get(i) + 1;
			}
		}
		if (!(space.size() == 1 && first_zero == 0 && last_zero == 0))
		{
			for (int i = 0; i < space.size(); i++)
			{
				if ((space.get(i) + 1) / 2 > first_longest_distance)
				{
					second_longest_distance = first_longest_distance;
					first_longest_distance = (space.get(i) + 1) / 2;
				}
				else if ((space.get(i) + 1) / 2 > second_longest_distance)
				{
					second_longest_distance = (space.get(i) + 1) / 2;
				}
			}
			if (first_zero > first_longest_distance)
			{
				second_longest_distance = first_longest_distance;
				first_longest_distance = first_zero;
			}
			else if (first_zero > second_longest_distance)
			{
				second_longest_distance = first_zero;
			}
			if (last_zero > first_longest_distance)
			{
				second_longest_distance = first_longest_distance;
				first_longest_distance = last_zero;
			}
			else if (last_zero > second_longest_distance)
			{
				second_longest_distance = last_zero;
			}
		}
		/*
		for (int i = 0; i < space.size(); i ++)
		{
			System.out.println(space.get(i));
		}
		*/
		int maxspace = 0;
		for (int i = 0; i < space.size(); i ++)
		{
			if (maxspace < space.get(i))
			{
				maxspace = space.get(i);
			}
		}
		if ((maxspace + 1) / 3 > second_longest_distance)
		{
			second_longest_distance = (maxspace + 1) / 3;
		}
		if (first_zero / 2 > second_longest_distance)
		{
			second_longest_distance = first_zero / 2;
		}
		if (last_zero / 2 > second_longest_distance)
		{
			second_longest_distance = last_zero / 2;
		}
		if (second_longest_distance < minspace)
		{
			minspace = second_longest_distance;
		}
		return minspace;
	}
}