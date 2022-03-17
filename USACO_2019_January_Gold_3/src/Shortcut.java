import java.io.*;
import java.util.*;

public class Shortcut {
	public static long answer = 0;
	public static class Pasture implements Comparable<Pasture>{
		Pasture prev;
		List<Pasture> next;
		long dist;
		int position;
		String route;
		public Pasture(long dist, int position) {
			this.dist = dist;
			this.position = position;
			prev = null;
			next = new ArrayList<>();
			this.route = "";
		}
		public int compareTo(Pasture p2) {
			if (this.dist == p2.dist) {
				return this.route.compareTo(p2.route);
			}
			return (int) (this.dist - p2.dist);
		}
		public String toString() {
			return position + "";
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("shortcut.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shortcut.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] num_cows = new int[N];
		for (int i = 0; i < N; i ++) {
			num_cows[i] = Integer.parseInt(st.nextToken());
		}
		Map<Integer, Map<Integer, Long>> graph = new HashMap<>();
		for (int i = 0; i < M; i ++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken()) - 1;
			int num2 = Integer.parseInt(st.nextToken()) - 1;
			Long num3 = Long.parseLong(st.nextToken());
			if (!graph.containsKey(num1)) {
				graph.put(num1, new HashMap<>());
			}
			if (!graph.containsKey(num2)) {
				graph.put(num2, new HashMap<>());
			}
			if (graph.get(num1).containsKey(num2) && num3 > graph.get(num1).get(num2)) {
				continue;
			}
			graph.get(num1).put(num2, num3);
			graph.get(num2).put(num1, num3);
		}
		Set<Integer> repeat = new HashSet<>();
		Pasture root = new Pasture(0, 0);
		PriorityQueue<Pasture> queue = new PriorityQueue<>();
		Set<Pasture> pastures = new HashSet<>();
		root.route = "1";
		pastures.add(root);
		queue.offer(root);
		while (queue.size() > 0 && repeat.size() < N) {
			Pasture cur = queue.poll();
			if (repeat.contains(cur.position)) {
				continue;
			}
			pastures.add(cur);
			repeat.add(cur.position);
			for (int temp : graph.get(cur.position).keySet()) {
				if (repeat.contains(temp)) {
					continue;
				}
				long new_dist = cur.dist + graph.get(cur.position).get(temp);
				Pasture new_pasture = new Pasture(new_dist, temp);
				new_pasture.prev = cur;
				int new_position = new_pasture.position + 1;
				new_pasture.route = new_position + "," + cur.route;
				//System.out.println(new_pasture.route);
				queue.offer(new_pasture);
			}
		}
		for (Pasture temp : pastures) {
			//System.out.println(temp.position + " " + temp.prev);
			Pasture prev = temp.prev;
			if (prev != null) {
				prev.next.add(temp);
			}
		}
		dfs(root, T, num_cows);
		pw.println(answer);
		pw.close();
	}
	public static long dfs(Pasture cur, int T, int[] num_cows) {
		if (cur == null) {
			return 0;
		}
		long cows_after = num_cows[cur.position];
		//System.out.println(cur.position + " " + cur.dist + " " + cur.next);
		for (Pasture temp : cur.next) {
			cows_after += dfs(temp, T, num_cows);
		}
		//System.out.println(answer + " " + cows_after + " " + cur.position);
		answer = Math.max(answer, (long) cows_after * (cur.dist - (long) T));
		return cows_after;
	}
}