import java.io.*;
import java.util.*;

public class MooTube {
	public static int answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
		for (int i = 0; i < N - 1; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			if (!graph.containsKey(first))
			{
				graph.put(first, new HashMap<>());
			}
			graph.get(first).put(second, value);
			if (!graph.containsKey(second))
			{
				graph.put(second, new HashMap<>());
			}
			graph.get(second).put(first, value);
		}
		List<Integer> answers = new ArrayList<>();
		for (int i = 0; i < Q; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int video = Integer.parseInt(st.nextToken());
			answer = 0;
			dfs(K, video, Integer.MAX_VALUE, graph, new HashSet<>());
			answers.add(answer);
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		for (int i = 0; i < answers.size(); i ++)
		{
			pw.println(answers.get(i));
		}
		pw.close();
	}
	public static void dfs(int K, int cur_video, int min_value, Map<Integer, Map<Integer, Integer>> graph, Set<Integer> repeat) {
		repeat.add(cur_video);
		for (Integer i : graph.get(cur_video).keySet())
		{
			if (repeat.contains(i))
			{
				continue;
			}
			if (graph.get(cur_video).get(i) < K) {
				continue;
			}
			int cur_min = Math.min(graph.get(cur_video).get(i), min_value);
			if (cur_min >= K)
			{
				answer ++;
			}
			dfs(K, i, cur_min, graph, repeat);
		}
	}
}
