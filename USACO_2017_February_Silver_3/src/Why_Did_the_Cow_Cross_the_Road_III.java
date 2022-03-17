import java.io.*;
import java.util.*;

public class Why_Did_the_Cow_Cross_the_Road_III {
	public static List<Integer> answers = new ArrayList<>();
	public static int cur_answer = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("countcross.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		Map<Integer, Set<Integer>> road = new HashMap<>();
		for (int i = 0; i < R; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int first = (Integer.parseInt(st.nextToken()) - 1) * N + (Integer.parseInt(st.nextToken()) - 1);
			int second = (Integer.parseInt(st.nextToken()) - 1) * N + (Integer.parseInt(st.nextToken()) - 1);
			if (!road.containsKey(first))
			{
				road.put(first, new HashSet<>());
			}
			road.get(first).add(second);
			if (!road.containsKey(second))
			{
				road.put(second, new HashSet<>());
			}
			road.get(second).add(first);
		}
				
		int[][] farm = new int[N][N];
		for (int i = 0; i < N; i ++)
		{
			Arrays.fill(farm[i], 0);
		}
		for (int i = 0; i < K; i ++)
		{
			st = new StringTokenizer(br.readLine());
			farm[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		
		Set<Integer> repeat = new HashSet<>();
		for (int i = 0; i < N; i ++)
		{
			for (int j = 0; j < N; j ++)
			{
				if (!repeat.contains(i * N + j) && farm[i][j] == 1)
				{
					repeat.add(i * N + j);
					cur_answer = 1;
					dfs(farm, road, i, j, N, repeat);
					answers.add(cur_answer);
				}
			}
		}
		int final_answer = 0;
		for (int i = 0; i < answers.size() - 1; i ++)
		{
			for (int j = i + 1; j < answers.size(); j ++)
			{
				final_answer = final_answer + answers.get(i) * answers.get(j);
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
		pw.println(final_answer);
		pw.close();
	}
	public static void dfs(int[][] farm, Map<Integer, Set<Integer>> road, int i, int j, int N, Set<Integer> repeat) {
		int[][] check = {{i + 1, j}, {i - 1, j}, {i, j + 1}, {i, j - 1}};
		for (int k = 0; k < 4; k ++)
		{
			int next_i = check[k][0];
			int next_j = check[k][1];
			if (next_i >= 0 && next_i < N && next_j >= 0 && next_j < N && !repeat.contains(next_i * N + next_j))
			{
				if (road.containsKey(i * N + j) && road.get(i * N + j).contains(next_i * N + next_j))
				{ 
					continue;
				}
				repeat.add(next_i * N + next_j);
				if (farm[next_i][next_j] == 1)
				{
					cur_answer += 1;
				}
				dfs(farm, road, next_i, next_j, N, repeat);
			}
		}
	}
}
