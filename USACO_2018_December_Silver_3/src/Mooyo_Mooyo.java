import java.io.*;
import java.util.*;

public class Mooyo_Mooyo {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("mooyomooyo.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String[] graph = new String[N];
		for (int i = 0; i < N; i ++)
		{
			graph[i] = br.readLine();
		}
		int loop = 1;
		while (loop != 0)
		{
			loop = 0;
			Set<Integer> repeat = new HashSet<>();
			for (int i = 0; i < N; i ++)
			{
				for (int j = 0; j < 10; j ++)
				{
					if (graph[i].charAt(j) != '0' && !repeat.contains(i * 10 + j))
					{
						repeat.add(i * 10 + j);
						List<Integer> nums = dfs(graph, i, j, N, repeat, new ArrayList<>());
						if (nums.size() >= K)
						{
							loop ++;
							for (int k = 0; k < nums.size(); k ++)
							{
								int cur_i = nums.get(k) / 10;
								int cur_j = nums.get(k) % 10;
								graph[cur_i] = graph[cur_i].substring(0, cur_j) + '0' + graph[cur_i].substring(cur_j + 1);
							}
						}
					}
				}
			}
			graph = move_down(graph, N);
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
		for (int i = 0; i < N; i ++)
		{
			pw.println(graph[i]);
		}
		pw.close();
	}
	public static List<Integer> dfs(String[] graph, int i, int j, int N, Set<Integer> repeat, List<Integer> nums) {
		char cur = graph[i].charAt(j);
		nums.add(i * 10 + j);
		int[][] next = {{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};
		for (int k = 0; k < 4; k ++)
		{
			int next_i = next[k][0];
			int next_j = next[k][1];
			if (next_i < N && next_i >= 0 && next_j < 10 && next_j >= 0 && graph[next_i].charAt(next_j) == cur && !repeat.contains(next_i * 10 + next_j))
			{
				repeat.add(next_i * 10 + next_j);
				dfs(graph, next_i, next_j, N, repeat, nums);
			}
		}
		return nums;
	}
	public static String[] move_down(String[] graph, int N) {
		for (int j = 0; j < 10; j ++)
		{
			List<Character> nums = new ArrayList<>();
			for (int i = N - 1; i >= 0; i --)
			{
				if (graph[i].charAt(j) != '0')
				{
					nums.add(graph[i].charAt(j));
				}
			}
			int k = 0;
			for (int i = N - 1; i >= 0; i --)
			{
				if (k < nums.size())
				{
					graph[i] = graph[i].substring(0, j) + nums.get(k) + graph[i].substring(j + 1);
				}
				else
				{
					graph[i] = graph[i].substring(0, j) + '0' + graph[i].substring(j + 1);
				}
				k ++;
			}
		}
		return graph;
	}
}
