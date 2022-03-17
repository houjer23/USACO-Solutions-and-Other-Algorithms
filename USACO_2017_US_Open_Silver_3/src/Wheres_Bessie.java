import java.io.*;
import java.util.*;

public class Wheres_Bessie {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("where.in"));
		int N = Integer.parseInt(br.readLine());
		char[][] graph = new char[N][N];
		for (int i = 0; i < N; i ++)
		{
			String temp = br.readLine();
			for (int j = 0; j < N; j ++)
			{
				graph[i][j] = temp.charAt(j);
			}
		}
		
		List<List<Integer>> answers = new ArrayList<>();
		for (int i = 0; i < N; i ++)
		{
			for (int j = 0; j < N; j ++)
			{
				for (int k = i; k < N; k ++)
				{
					for (int l = j; l < N; l ++)
					{
						char num1 = ' ';
						char num2 = ' ';
						int num1_time = 0;
						int num2_time = 0;
						int flag = 0;
						Set<Integer> repeat = new HashSet<>();
						for (int m = i; m <= k; m ++)
						{
							if (flag == 1)
							{
								break;
							}
							for (int n = j; n <= l; n ++)
							{
								if (!repeat.contains(m * N + n))
								{
									if (num1_time == 0)
									{
										num1 = graph[m][n];
										num1_time ++;
									}
									else if (num2_time == 0)
									{
										if (graph[m][n] == num1)
										{
											num1_time ++;
										}
										else
										{
											num2 = graph[m][n];
											num2_time ++;
										}
									}
									else
									{
										if (graph[m][n] == num1)
										{
											num1_time ++;
										}
										else if (graph[m][n] == num2)
										{
											num2_time ++;
										}
										else
										{
											flag = 1;
											break;
										}
									}
									if (num1_time > 1 && num2_time > 1)
									{
										flag = 1;
										break;
									}
									repeat.add(m * N + n);
									dfs(graph, repeat, N, i, j, k, l, m, n, graph[m][n]);
								}
							}
						}
						if (flag == 0 && !(num1 == ' ' || num2 == ' ') && (num1_time >= 2 || num2_time >= 2))
						{
							List<Integer> temp = new ArrayList<>();
							temp.add(i * N + j);
							temp.add(k * N + l);
							answers.add(temp);
						}
					}
				}
			}
		}
		Set<Integer> wrong = new HashSet<>();
		for (int i = 0; i < answers.size(); i ++)
		{
			for (int j = 0; j < answers.size(); j ++)
			{
				if (i == j || wrong.contains(j))
				{
					continue;
				}
				if (answers.get(i).get(0) / N <= answers.get(j).get(0) / N && answers.get(i).get(1) / N >= answers.get(j).get(1) / N && answers.get(i).get(0) % N <= answers.get(j).get(0) % N && answers.get(i).get(1) % N >= answers.get(j).get(1) % N)
				{
					wrong.add(j);
				}
			}
		}
		
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
		pw.println(answers.size() - wrong.size());
		pw.close();
	}
	public static void dfs (char[][] graph, Set<Integer> repeat, int N, int left, int top, int right, int bottom, int m, int n, char cur) {
		int[][] check = {{m + 1, n}, {m - 1, n}, {m, n + 1}, {m, n - 1}};
		for (int i = 0; i < 4; i ++)
		{
			int next_m = check[i][0];
			int next_n = check[i][1];
			if (next_m >= left && next_m <= right && next_n >= top && next_n <= bottom && !repeat.contains(next_m * N + next_n) && graph[next_m][next_n] == cur)
			{
				repeat.add(next_m * N + next_n);
				dfs(graph, repeat, N, left, top, right, bottom, next_m, next_n, cur);
			}
		}
	}
}
