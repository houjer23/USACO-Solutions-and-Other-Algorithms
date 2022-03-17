import java.io.*;
import java.util.*;

public class Cowntagion {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		StringTokenizer st;
		for (int i = 0; i < N - 1; i ++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			if (!graph.containsKey(num1)) {
				graph.put(num1, new HashSet<>());
			}
			if (!graph.containsKey(num2)) {
				graph.put(num2, new HashSet<>());
			}
			graph.get(num1).add(num2);
			graph.get(num2).add(num1);
		}
		int answer = 0;
		for (int i = 1; i <= N; i ++) {
			int spread = graph.get(i).size();
			if (i == 1) {
				spread ++;
			}
			int cur_spread = 1;
			int cur_answer = spread - 1;
			while (cur_spread < spread) {
				cur_spread *= 2;
				cur_answer ++;
			}
			answer += cur_answer;
		}
		System.out.println(answer);
	}
}
