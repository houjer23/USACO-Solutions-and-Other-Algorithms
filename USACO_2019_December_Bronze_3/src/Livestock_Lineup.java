import java.io.*;
import java.util.*;

public class Livestock_Lineup {
	public static List<List<String>> answer = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
		int N = Integer.parseInt(br.readLine());	
		StringTokenizer st;
		Map<String, Set<String>> graph = new HashMap<>();
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			String first = st.nextToken();
			for (int j = 0; j < 4; j ++)
			{
				st.nextToken();
			}
			String second = st.nextToken();
			if (!graph.containsKey(first))
			{
				graph.put(first, new HashSet<>());
			}
			graph.get(first).add(second);
			if (!graph.containsKey(second))
			{
				graph.put(second, new HashSet<>());
			}
			graph.get(second).add(first);
		}
		System.out.println(graph);		
		List<List<String>> ordering = new ArrayList<>();
		
		permutation(new ArrayList<String>(Arrays.asList("Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue")), new ArrayList<>());
		
		List<String> final_answer = new ArrayList<>();
		for (int i = 0; i < answer.size(); i ++)
		{
			int flag = 1;
			for (int j = 0; j < 8; j ++)
			{
				if (j == 0 || j == 7)
				{
					if (graph.containsKey(answer.get(i).get(j)))
					{
						if (graph.get(answer.get(i).get(j)).size() == 2)
						{
							flag = 0;
							break;
						}
						else
						{
							if (j == 0 && !graph.get(answer.get(i).get(j)).contains(answer.get(i).get(j + 1)))
							{
								flag = 0;
								break;
							}
							if (j == 7 && !graph.get(answer.get(i).get(j)).contains(answer.get(i).get(j - 1)))
							{
								flag = 0;
								break;
							}
						}
					}
				}
				else if (graph.containsKey(answer.get(i).get(j)))
				{
					int flag2 = 1;
					for (String temp : graph.get(answer.get(i).get(j)))
					{
						if (!temp.equals(answer.get(i).get(j + 1)) && !temp.equals(answer.get(i).get(j - 1)))
						{
							flag2 = 0;
							break;
						}
					}
					if (flag2 == 0)
					{
						flag = 0;
						break;
					}
				}
			}
			if (flag == 1)
			{
				if (final_answer.size() == 0)
				{
					final_answer = answer.get(i);
				}
				else
				{
					for (int j = 0; j < 8; j ++)
					{
						if (final_answer.get(j).compareTo(answer.get(i).get(j)) < 0)
						{
							break;
						}
						if (final_answer.get(j).compareTo(answer.get(i).get(j)) > 0)
						{
							final_answer = answer.get(i);
							break;
						}
					}
				}
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
		for (int i = 0; i < 8; i ++)
		{
			pw.println(final_answer.get(i));
		}
		pw.close();
	}
	public static void permutation(List<String> cows_not_used, List<String> temp_answer) {
		//System.out.println(temp_answer.size());
		if (temp_answer.size() == 8)
		{
			List<String> final_answer = new ArrayList<>();
			for (int i = 0; i < 8; i ++)
			{
				final_answer.add(temp_answer.get(i));
			}
			answer.add(final_answer);
			//System.out.println(final_answer);
			return;
		}
		for (int i = 0; i < cows_not_used.size(); i ++)
		{
			String temp = cows_not_used.get(i);
			temp_answer.add(temp);
			cows_not_used.remove(i);
			permutation(cows_not_used, temp_answer);
			temp_answer.remove(temp);
			cows_not_used.add(i, temp);
		}
	}
}
