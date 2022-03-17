import java.io.*;
import java.util.*;

public class The_Great_Revegetation {
	public static int wrong = 0;
	public static Map<Integer, Set<Integer>> same = new HashMap<>();
	public static Map<Integer, Set<Integer>> diff = new HashMap<>();
	public static Map<Integer, Integer> result = new HashMap<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i ++)
		{
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			if ("S".equals(temp))
			{
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				if (!same.containsKey(first))
				{
					same.put(first, new HashSet<>());
				}
				same.get(first).add(second);
				if (!same.containsKey(second))
				{
					same.put(second, new HashSet<>());
				}
				same.get(second).add(first);
			}
			else if ("D".equals(temp))
			{
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				if (!diff.containsKey(first))
				{
					diff.put(first, new HashSet<>());
				}
				diff.get(first).add(second);
				if (!diff.containsKey(second))
				{
					diff.put(second, new HashSet<>());
				}
				diff.get(second).add(first);
			}
		}
		//System.out.println(same);
		//System.out.println(diff);
		
		int num = 0;
		for (int i = 1; i <= N; i ++)
		{
			if (!result.containsKey(i))
			{
				dfs(0, i);
				num ++;
			}
			//System.out.println(repeat);
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		if (wrong == 1)
		{
			pw.println(0);
		}
		else
		{
			String answer = "1";
			for (int i = 0; i < num; i ++)
			{
				answer += "0";
			}
			pw.println(answer);
		}
		pw.close();
	}
	public static void dfs(int value, int num) {
		result.put(num, value);
		if (same.containsKey(num))
		{
			for (int next : same.get(num))
			{
				if (result.containsKey(next))
				{
					if (result.get(next) != value)
					{
						wrong = 1;
						return;
					}
				}
				else
				{
					dfs(value, next);
				}
			}
		}
		if (diff.containsKey(num))
		{
			for (int next : diff.get(num))
			{
				int next_value = 1 - value;
				if (result.containsKey(next))
				{
					if (result.get(next) != next_value)
					{
						wrong = 1;
						return;
					}
				}
				else
				{
					dfs(next_value, next);
				}
			}
		}
		//System.out.println(result);
	}
}
