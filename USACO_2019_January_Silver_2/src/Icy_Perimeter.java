import java.io.*;
import java.util.*;

public class Icy_Perimeter {
	public static int final_area = 0;
	public static int final_perimeter = 0;
	public static int area = 0;
	public static int perimeter = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
		int N = Integer.parseInt(br.readLine());
		String[] graph = new String[N];
		for (int i = 0; i < N; i ++)
		{
			graph[i] = br.readLine();
		}
		Set<Integer> repeat = new HashSet<>();
		for (int i = 0; i < N; i ++)
		{
			for (int j = 0; j < N; j ++)
			{
				if (graph[i].charAt(j) == '#' && !repeat.contains(i * N + j))
				{
					area = 0;
					perimeter = 0;
					repeat.add(i * N + j);
					dfs(graph, i, j, N, repeat);
					if (final_area < area)
					{
						final_area = area;
						final_perimeter = perimeter;
					}
					else if (final_area == area && perimeter < final_perimeter)
					{
						final_perimeter = perimeter;
					}
				}
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		pw.println(final_area + " " + final_perimeter);
		pw.close();
	}
	public static void dfs(String[] graph, int i, int j, int N, Set<Integer> repeat) {
		area ++;
		int[][] next = {{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};
		int find_perimeter = 0;
		for (int k = 0; k < 4; k ++)
		{
			int next_i = next[k][0];
			int next_j = next[k][1];
			if (next_i < N && next_i >= 0 && next_j < N && next_j >= 0 && graph[next_i].charAt(next_j) == '#')
			{
				find_perimeter ++;
				int temp = next_i * N + next_j;
				if (!repeat.contains(temp))
				{
					repeat.add(temp);
					dfs(graph, next_i, next_j, N, repeat);
				}
			}
		}
		perimeter += 4 - find_perimeter;
	}
}
