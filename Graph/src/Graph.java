import java.io.*;
import java.util.*;

public class Graph {
	public static void main(String[] args) throws IOException{
		int n = 5;
		int[][] edgelist = {{1,2,6},{2,3,1},{3,5,9},{5,1,4},{4,2,2}};
		Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
		for (int i = 0; i < edgelist.length; i ++)
		{
			int first = edgelist[i][0];
			int second = edgelist[i][1];
			int weight = edgelist[i][2];
			if (!graph.containsKey(first))
			{
				graph.put(first, new HashMap<>());
			}
			graph.get(first).put(second, weight);
			if (!graph.containsKey(second))
			{
				graph.put(second, new HashMap<>());
			}
			graph.get(second).put(first, weight);
		}
		System.out.println(graph);
		//dfs(graph, 1, new HashSet<>());
		bfs(graph, 1);
	}
	public static void dfs(Map<Integer, Map<Integer, Integer>> graph, int start, Set<Integer> repeat){
		if (repeat.contains(start))
		{
			return;
		}
		else
		{
			System.out.println(start);
			repeat.add(start);
		}
		for (int next : graph.get(start).keySet())
		{
			dfs(graph, next, repeat);
		}
	}
	public static void bfs(Map<Integer, Map<Integer, Integer>> graph, int start){
		Deque<Integer> queue = new ArrayDeque<>();
		queue.offerLast(start);
		Set<Integer> repeat = new HashSet<>();
		while (queue.size() != 0)
		{
			int cur = queue.pollFirst();
			if (repeat.contains(cur))
			{
				continue;
			}
			repeat.add(cur);
			System.out.println(cur);
			for (int next : graph.get(cur).keySet())
			{
				queue.offerLast(next);
			}
		}
	}
}
