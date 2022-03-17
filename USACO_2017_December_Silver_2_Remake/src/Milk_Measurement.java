import java.io.*;
import java.util.*;

public class Milk_Measurement {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		TreeMap<Integer, List<Integer>> days = new TreeMap<>();
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken());
			int cur = Integer.parseInt(st.nextToken());
			int change = Integer.parseInt(st.nextToken());
			days.put(id, new ArrayList<>(Arrays.asList(cur, change)));
		}
		TreeMap<Integer, Set<Integer>> find_max = new TreeMap<>();
		Map<Integer, Integer> cows = new HashMap<>();
		Set<Integer> preset = new HashSet<>();
		int answer = 0;
		for (int cur : days.keySet())
		{
			int cur_num = days.get(cur).get(0);
			int cur_num_produce = days.get(cur).get(1);
			if (!cows.containsKey(cur_num))
			{
				cows.put(cur_num, G);
			}
			int before = cows.get(cur_num);
			cows.put(cur_num, cows.get(cur_num) + cur_num_produce);
			int after = cows.get(cur_num);
			if (find_max.containsKey(before) && find_max.get(before).size() == 1)
			{
				find_max.remove(before);
			}
			else if (find_max.containsKey(before))
			{
				find_max.get(before).remove(cur_num);
			}
			if (!find_max.containsKey(after))
			{
				find_max.put(after, new HashSet<>());
			}
			find_max.get(after).add(cur_num);
			Set<Integer> tempset = find_max.get(find_max.lastKey());
			if (preset.size() == 0)
			{
				answer ++;
				Set<Integer> newset = new HashSet<>();
				for (int i : tempset)
				{
					newset.add(i);
				}
				preset = newset;
			}
			else if (tempset.size() != preset.size())
			{
				answer ++;
				Set<Integer> newset = new HashSet<>();
				for (int i : tempset)
				{
					newset.add(i);
				}
				preset = newset;
			}
			else
			{
				for (int i : tempset)
				{
					if (!preset.contains(i))
					{
						answer ++;
						Set<Integer> newset = new HashSet<>();
						for (int j : tempset)
						{
							newset.add(j);
						}
						preset = newset;
						break;
					}
				}
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		pw.println(answer);
		pw.close();
	}
}
