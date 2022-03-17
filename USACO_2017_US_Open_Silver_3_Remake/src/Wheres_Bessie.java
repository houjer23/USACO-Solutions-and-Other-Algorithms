import java.io.*;
import java.util.*;

public class Wheres_Bessie {
	public static int N;
	public static String[] board;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("where.in"));
		N = Integer.parseInt(br.readLine());
		board = new String[N];
		for (int i = 0; i < N; i ++)
		{
			board[i] = br.readLine();
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
						//System.out.println((i * N + j) + " " + (k * N + l) + "  " + i  + " " + j + " " + k + " " + l);
						char color1 = '1';
						int color1_times = 0;
						char color2 = '2';
						int color2_times = 0;
						Set<Integer> repeat = new HashSet<>();
						boolean work = true;
						for (int m = i; m <= k; m ++)
						{
							for (int n = j; n <= l; n ++)
							{
								if (repeat.contains(m * N + n))
								{
									continue;
								}
								if (color1 == '1')
								{
									color1_times ++;
									color1 = board[m].charAt(n);
								}
								else if (color1 == board[m].charAt(n))
								{
									color1_times ++;
								}
								else if (color2 == '2')
								{
									color2 = board[m].charAt(n);
									color2_times ++;
								}
								else if (color2 == board[m].charAt(n))
								{
									color2_times ++;
								}
								else
								{
									work = false;
									break;
								}
								if (color1_times > 1 && color2_times > 1)
								{
									work = false;
									break;
								}
								int[] top_left = {i, j};
								int[] bottom_right = {k, l};
								int[] cur = {m, n};
								dfs(top_left, bottom_right, cur, repeat, board[m].charAt(n));
							}
							if (!work)
							{
								break;
							}
						}
						if (work && ((color1_times == 1 && color2_times > 1) || (color2_times == 1 && color1_times > 1)))
						{
							List<Integer> answer = new ArrayList<>();
							answer.add(i);
							answer.add(j);
							answer.add(k);
							answer.add(l);
							answers.add(answer);
						}
					}
				}
			}
		}
		int wrong = 0;
		for (int i = 0; i < answers.size(); i ++)
		{
			for (int j = 0; j < answers.size(); j ++)
			{
				if (i == j)
				{
					continue;
				}
				if (answers.get(i).get(0) >= answers.get(j).get(0) && answers.get(i).get(1) >= answers.get(j).get(1) && answers.get(i).get(2) <= answers.get(j).get(2) && answers.get(i).get(3) <= answers.get(j).get(3))
				{
					wrong ++;
					break;
				}
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
		pw.println(answers.size() - wrong);
		pw.close();
	}
	public static void dfs(int[] top_left, int[] bottom_right, int[] cur, Set<Integer> repeat, char color) {
		int i = cur[0];
		int j = cur[1];
		int[][] next = {{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};
		for (int k = 0; k < 4; k ++)
		{
			int next_i = next[k][0];
			int next_j = next[k][1];
			if (next_i < top_left[0] || next_i > bottom_right[0] || next_j < top_left[1] || next_j > bottom_right[1] || repeat.contains(next_i * N + next_j) || board[next_i].charAt(next_j) != color)
			{
				continue;
			}
			repeat.add(next_i * N + next_j);
			dfs(top_left, bottom_right, next[k], repeat, color);
		}
	}
}
