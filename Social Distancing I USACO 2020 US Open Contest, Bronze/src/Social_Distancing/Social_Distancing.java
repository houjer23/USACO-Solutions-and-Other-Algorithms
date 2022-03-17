package Social_Distancing;

import java.util.*;
import java.io.*;

public class Social_Distancing {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("socdist1.in"));
		int size = Integer.parseInt(br.readLine());
		String farm = br.readLine();
		char[] farmChars = farm.toCharArray();
		farm = insert(farmChars, size);
		//System.out.println(farm);
		farmChars = farm.toCharArray();
		int minspace = findMinSpace(farmChars, size);
		//System.out.println(minspace);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));
		pw.print(minspace);
		pw.close();
	}
	static String insert(char[] farmChars, int size){
		int start = 0;
		int space = 0;
		for (int i = 0; i < size; i++)
		{
			if (farmChars[i] == '1')
			{
				start = i;
				if (i >= 2)
				{
					farmChars[0] = '1';
				}
				break;
			}
			if (i == size - 1)
			{
				farmChars[0] = '1';
			}
		}
		for (int i = start; i < size; i++)
		{
			if (i == size - 1 && farmChars[i] == '0' && space >= 1)
			{
				farmChars[i] = '1';
			}
			else if (farmChars[i] == '1')
			{
				if (space <= 2)
				{
					space = 0;
				}
				else
				{
					farmChars[i - 1 - space / 2] = '1';
					space = 0;
				}
			}
			else
			{
				space++;
			}
		}
		return String.valueOf(farmChars);
	}
	static int findMinSpace(char[] farmChars, int size){
		int start = 0;
		int first = 0;
		int minspace = size - 1;
		if (farmChars[0] == '1')
		{
			start = 1;
			first = 0;
		}
		else
		{
			start = 2;
			first = 1;
		}
		for (int i = start; i < size; i++)
		{
			if (farmChars[i] == '1')
			{
				if (i - first < minspace)
				{
					minspace = i - first;
				}
				first = i;
			}
		}
		return minspace;
	}
}