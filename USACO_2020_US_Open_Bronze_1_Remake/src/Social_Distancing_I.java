import java.io.*;
import java.util.*;

public class Social_Distancing_I {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("socdist1.in"));
		int N = Integer.parseInt(br.readLine());
		String cows = br.readLine();
		List<Integer> space = new ArrayList<>();
		int i = 0;
		while (i < N)
		{
			if (i == 0)
			{
				if (cows.charAt(0) == '0')
				{
					while (i < N && cows.charAt(i) != '1')
					{
						i ++;
					}
					if (i == N)
					{
						space.add(N - 1);
						break;
					}
					if (i == N - 1)
					{
						space.add((i - 0 + 1) / 2);
						break;
					}
					space.add(i);
					i ++;
				}
				else
				{
					i ++;
				}
				continue;
			}
			int start = i;
			while (i < N && cows.charAt(i) == '0')
			{
				i ++;
			}
			if (i == N)
			{
				if (space.size() == 0)
				{
					space.add((N - 1 - 0 + 1) / 2);
				}
				else
				{
					space.add(N - 1 - start);
				}
				break;
			}
			if (space.size() == 0 && i == N - 1)
			{
				space.add((i - start + 1) / 3);
			}
			space.add((i - start + 1) / 2);
			i ++;
		}
		int max1 = -1;
		int max2 = -1;
		if (space.size() == 1)
		{
			max2 = space.get(0);
		}
		else
		{
			for (i = 0; i < space.size(); i ++)
			{
				if (space.get(i) > max2)
				{
					if (space.get(i) > max1)
					{
						max2 = max1;
						max1 = space.get(i);
					}
					else
					{
						max2 = space.get(i);
					}
				}
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));
		pw.println(max2);
		pw.close();
	}
}
