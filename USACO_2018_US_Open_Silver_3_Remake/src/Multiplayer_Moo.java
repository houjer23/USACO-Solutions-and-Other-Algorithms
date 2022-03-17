import java.io.*;
import java.util.*;

public class Multiplayer_Moo {
	public static Map<Integer, Set<Integer>> graph = new HashMap<>();
	public static List<List<Integer>> nums = new ArrayList<>();
	public static int cur_amount;
	public static int cur_amount2;
	public static Map<Integer, Integer> positions = new HashMap<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("multimoo.in"));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] game = new int[N][N];
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j ++)
			{
				game[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max_amount = 0;
		Set<Integer> repeat = new HashSet<>();
		for (int i = 0; i < N; i ++)
		{
			for (int j = 0; j < N; j ++)
			{
				if (!repeat.contains(i * N + j))
				{
					repeat.add(i * N + j);
					nums.add(new ArrayList<>());
					cur_amount = 1;
					dfs(i, j, repeat, game, N);
					nums.get(nums.size() - 1).add(game[i][j]);
					nums.get(nums.size() - 1).add(cur_amount);
					if (cur_amount > max_amount)
					{
						max_amount = cur_amount;
					}
				}
			}
		}
		
		/*System.out.println(nums);
		System.out.println(graph);
		System.out.println(positions);*/
		
		int max_amount2 = 0;
		Set<Integer> repeat2 = new HashSet<>();
		for (int i = 0; i < graph.size(); i ++)
		{
			for (int j : graph.get(i))
			{
				if (!repeat2.contains(i * graph.size() + j))
				{
					cur_amount2 = 0;
					int num1 = nums.get(i).get(0);
					int num2 = nums.get(j).get(0);
					dfs2(num1, num2, i, new HashSet<>(), repeat2);
					if (cur_amount2 > max_amount2)
					{
						max_amount2 = cur_amount2;
					}
				}
			}
		}
		

		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));
		pw.println(max_amount);
		pw.println(max_amount2);
		pw.close();
	}
	public static void dfs(int i, int j, Set<Integer> repeat, int[][] game, int N) {
		positions.put(i * N + j, nums.size() - 1);
		int[][] check = {{i + 1, j}, {i - 1, j}, {i, j + 1}, {i, j - 1}};
		for (int k = 0; k < 4; k ++)
		{
			int new_i = check[k][0];
			int new_j = check[k][1];
			if (new_i >= 0 && new_i < N && new_j >= 0 && new_j < N && !repeat.contains(new_i * N + new_j) && game[new_i][new_j] == game[i][j])
			{
				cur_amount ++;
				repeat.add(new_i * N + new_j);
				dfs(new_i, new_j, repeat, game, N);
			}
			else if (new_i >= 0 && new_i < N && new_j >= 0 && new_j < N && repeat.contains(new_i * N + new_j) && game[new_i][new_j] != game[i][j])
			{
				int first = nums.size() - 1;
				int second = positions.get(new_i * N + new_j);
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
		}
	}
	public static void dfs2(int num1, int num2, int i, Set<Integer> repeat, Set<Integer> repeat2) {
		repeat.add(i);
		cur_amount2 += nums.get(i).get(1);
		for (int k : graph.get(i))
		{
			if ((nums.get(k).get(0) == num1 || nums.get(k).get(0) == num2) && !repeat.contains(k) && !repeat2.contains(i * graph.size() + k))
			{
				repeat2.add(i * graph.size() + k);
				repeat2.add(k * graph.size() + i);
				dfs2(num1, num2, k, repeat, repeat2);
			}
		}
	}
}
