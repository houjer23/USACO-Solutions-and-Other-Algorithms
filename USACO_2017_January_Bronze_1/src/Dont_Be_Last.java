import java.io.*;
import java.util.*;

public class Dont_Be_Last {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> cows = new HashMap<>();
		StringTokenizer st;
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			if (!cows.containsKey(name))
			{
				cows.put(name, 0);
			}
			int temp = cows.get(name) + Integer.parseInt(st.nextToken());
			cows.replace(name, temp);
		}
		System.out.println(cows);
		int min = 1000;
		int tie = 0;
		for (int next : cows.values())
		{
			if (next < min)
			{
				min = next;
			}
		}
		int sec_min = 1000;
		int i = 0;
		int min_name_num = -1;
		for (int next : cows.values())
		{
			if (next > min && next < sec_min)
			{
				tie = 0;
				sec_min = next;
				min_name_num = i;
			}
			else if (next == sec_min)
			{
				tie = 1;
			}
			i ++;
		}
		i = 0;
		String name = "";
		for (String next : cows.keySet())
		{
			if (min_name_num == i)
			{
				name = next;
			}
			i ++;
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
		if (tie == 1 || N == 0 || sec_min == 1000)
		{
			pw.println("Tie");
		}
		else
		{
			pw.println(name);
		}
		pw.close();
	}
}
