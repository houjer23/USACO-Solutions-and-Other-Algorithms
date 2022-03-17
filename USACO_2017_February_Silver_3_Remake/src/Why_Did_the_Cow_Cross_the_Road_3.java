import java.io.*;
import java.util.*;

public class Why_Did_the_Cow_Cross_the_Road_3 {
	public static List<Integer> total_cows = new ArrayList<>();
	public static int cur_cows = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("countcross.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		Map<Integer, Set<Integer>> roads = new HashMap<>();
		for (int i = 0; i < R; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int first = (Integer.parseInt(st.nextToken()) - 1) * N + (Integer.parseInt(st.nextToken()) - 1);
			int second = (Integer.parseInt(st.nextToken()) - 1) * N + (Integer.parseInt(st.nextToken()) - 1);
			if (!roads.containsKey(first))
			{
				roads.put(first, new HashSet<>());
			}
			roads.get(first).add(second);
			if (!roads.containsKey(second))
			{
				roads.put(second, new HashSet<>());
			}
			roads.get(second).add(first);
		}
		int[][] farm = new int[N][N];
		int[] cows = new int[K];
		for (int i = 0; i < K; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			farm[x][y] = 1;
			cows[i] = x * N + y;
		}
		Set<Integer> repeat = new HashSet<>();
		for (int i = 0; i < K; i ++)
		{
			if (!repeat.contains(cows[i]))
			{
				cur_cows = 1;
				repeat.add(cows[i]);
				dfs(roads, repeat, cows[i], N, farm);
				total_cows.add(cur_cows);
			}
		}
		int answer = 0;
		for (int i = 0; i < total_cows.size(); i ++)
		{
			for (int j = i + 1; j < total_cows.size(); j ++)
			{
				answer += total_cows.get(i) * total_cows.get(j);
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
		pw.println(answer);
		pw.close();
	}
	public static void dfs(Map<Integer, Set<Integer>> roads, Set<Integer> repeat, int cur, int N, int[][] farm) {
		int x = cur / N;
		int y = cur % N;
		int[][] new_cows = {{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}};
		for (int i = 0; i < 4; i ++)
		{
			int new_x = new_cows[i][0];
			int new_y = new_cows[i][1];
			if (new_x >= 0 && new_x < N && new_y >= 0 && new_y < N && !repeat.contains(new_x * N + new_y))
			{
				if (roads.containsKey(cur) && roads.get(cur).contains(new_x * N + new_y))
				{
					continue;
				}
				if (farm[new_x][new_y] == 1)
				{
					cur_cows += 1;
				}
				repeat.add(new_x * N + new_y);
				dfs(roads, repeat, new_x * N + new_y, N, farm);
			}
		}
	}

}
