import java.io.*;
import java.util.*;

public class Moocast {
	public static int answer = 0;
	public static int reached = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<List<Integer>> cows = new ArrayList<>();
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			cows.add(new ArrayList<>());
			cows.get(i).add(Integer.parseInt(st.nextToken()));
			cows.get(i).add(Integer.parseInt(st.nextToken()));
			cows.get(i).add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < N; i ++)
		{
			reached = 0;
			List<Integer> cur_cow = cows.get(i);
			Set<Integer> repeat = new HashSet<>();
			max_distance(cows, cur_cow, repeat, i);
			if (reached > answer)
			{
				answer = reached;
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		pw.println(answer);
		pw.close();
	}
	public static void max_distance(List<List<Integer>> cows, List<Integer> cur_cow, Set<Integer> repeat, int cur) {
		reached ++;
		repeat.add(cur);
		for (int i = 0; i < cows.size(); i ++)
		{
			if (repeat.contains(i))
			{
				continue;
			}
			double cur_distance = Math.pow(cur_cow.get(0) - cows.get(i).get(0), 2) + Math.pow(cur_cow.get(1) - cows.get(i).get(1), 2);
			if (cur_cow.get(2) * cur_cow.get(2) >= cur_distance)
			{
				List<Integer> new_cow = cows.get(i);
				max_distance(cows, new_cow, repeat, i);
			}
		}
	}
}
