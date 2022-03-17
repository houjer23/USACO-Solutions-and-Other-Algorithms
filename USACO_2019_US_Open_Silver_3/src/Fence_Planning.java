import java.io.*;
import java.util.*;

public class Fence_Planning {
	public static List<Integer> perimeters = new ArrayList<>();
	public static int[] cur_points = new int[4];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] points = new int[N][2];
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int i = 0; i < M; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken()) - 1;
			int second = Integer.parseInt(st.nextToken()) - 1;
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
		
		Set<Integer> repeat = new HashSet<>();
		for (int i = 0; i < N; i ++)
		{
			if (!repeat.contains(i))
			{
				cur_points[0] = 0;
				cur_points[1] = Integer.MAX_VALUE;
				cur_points[2] = 0;
				cur_points[3] = Integer.MAX_VALUE;
				repeat.add(i);
				dfs(points, graph, i, repeat); 
				perimeters.add((cur_points[0] - cur_points[1]) * 2 + (cur_points[2] - cur_points[3]) * 2);
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
		pw.println(Collections.min(perimeters));
		pw.close();
	}
	public static void dfs(int[][] points, Map<Integer, Set<Integer>> graph, int cur, Set<Integer> repeat) {
		if (points[cur][0] > cur_points[0])
		{
			cur_points[0] = points[cur][0];
		}
		if (points[cur][0] < cur_points[1])
		{
			cur_points[1] = points[cur][0];
		}
		if (points[cur][1] > cur_points[2])
		{
			cur_points[2] = points[cur][1];
		}
		if (points[cur][1] < cur_points[3])
		{
			cur_points[3] = points[cur][1];
		}
		if (graph.containsKey(cur))
		{
			for (int next : graph.get(cur))
			{
				if (!repeat.contains(next))
				{
					repeat.add(next);
					dfs(points, graph, next, repeat);
				}
			}
		}
		//System.out.println(cur_points[0] + " " + cur_points[1] + " " + cur_points[2] + " " + cur_points[2]);
	}
}
