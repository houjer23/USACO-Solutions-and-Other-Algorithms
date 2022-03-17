import java.io.*;
import java.util.*;

public class Milk_Visits {
	public static Map<Integer, Set<Integer>> link = new HashMap<>();
	public static List<Set<Integer>> answers = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, Set<Integer>> farms = new HashMap<>();
		String milks = br.readLine();
		for (int i = 0; i < N - 1; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			if (!farms.containsKey(first))
			{
				farms.put(first, new HashSet<>());
			}
			farms.get(first).add(second);
			if (!farms.containsKey(second))
			{
				farms.put(second, new HashSet<>());
			}
			farms.get(second).add(first);
		}
		Set<Integer> used = new HashSet<>();
		for (int i = 1; i <= N; i ++)
		{
			if (!used.contains(i))
			{
				link.put(i, new HashSet<>());
				route(i, i, used, milks, farms);
				answers.add(link.get(i));
			}
			else
			{
				for (int temp : link.get(i))
				{
					answers.add(link.get(temp));
					break;
				}
			}
		}
		//System.out.println(link);
		//System.out.println(answers);
		int[] final_answers = new int[M];
		for (int i = 0; i < M; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			char milk = st.nextToken().charAt(0);
			if (answers.get(start - 1).contains(end) && milks.charAt(start - 1) != milk)
			{
				final_answers[i] = 0;
			}
			else
			{
				final_answers[i] = 1;
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
		for (int i = 0; i < final_answers.length; i ++)
		{
			pw.print(final_answers[i]);
		}
		pw.close();
	}
	public static void route(int first, int cur, Set<Integer> used, String milks, Map<Integer, Set<Integer>> farms){
		if (milks.charAt(cur - 1) != milks.charAt(first - 1))
		{
			return;
		}
		used.add(cur);
		if (!link.containsKey(cur))
		{
			link.put(cur, new HashSet<>());
		}
		link.get(cur).add(first);
		link.get(first).add(cur);
		for (int temp : farms.get(cur))
		{
			if (!used.contains(temp))
			{
				route(first, temp, used, milks, farms);
			}
		}
	}
}
