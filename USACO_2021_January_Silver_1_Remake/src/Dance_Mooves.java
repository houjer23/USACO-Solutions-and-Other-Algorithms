import java.io.*;
import java.util.*;

public class Dance_Mooves {
	public static List<Set<Integer>> reach = new ArrayList<>();
	public static List<Set<Integer>> group_reach = new ArrayList<>();
	public static int[] from_and_to;
	public static void main(String[] args) throws IOException{
		// change reach to List
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] end = new int[N];
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i ++) {
			reach.add(new HashSet<>());
			reach.get(i).add(i);
			end[i] = i;
		}
		for (int i = 0; i < K; i ++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken()) - 1;
			int num2 = Integer.parseInt(st.nextToken()) - 1;
			reach.get(end[num1]).add(num2);
			reach.get(end[num2]).add(num1);
			int temp = end[num1];
			end[num1] = end[num2];
			end[num2] = temp;
		}
		from_and_to = new int[N];
		for (int i = 0; i < N; i ++) {
			from_and_to[end[i]] = i;
		}
		boolean[] repeat = new boolean[N];
		List<List<Integer>> group = new ArrayList<>();
		for (int i = 0; i < N; i ++) {
			if (!repeat[i]) {
				List<Integer> cur_group = new ArrayList<>();
				Set<Integer> cur_group_reach = new HashSet<>();
				int cur = i;
				while (!repeat[cur]) {
					for (int k : reach.get(cur)) {
						cur_group_reach.add(k);
					}
					repeat[cur] = true;
					cur_group.add(cur);
					cur = from_and_to[cur];
				}
				//find_group(repeat, i, cur_group, cur_group_reach);
				group.add(cur_group);
				group_reach.add(cur_group_reach);
			}
		}
		int[] answer = new int[N];
		for (int i = 0; i < group.size(); i ++) {
			for (int j = 0; j < group.get(i).size(); j ++) {
				answer[group.get(i).get(j)] = group_reach.get(i).size();
			}
		}
		StringBuilder outStr = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            outStr.append(answer[i]).append('\n');
        }
        System.out.print(outStr);
	}
	/*
	public static void find_group(boolean[] repeat, int cur, List<Integer> cur_group, Set<Integer> cur_group_reach) {
		if (repeat[cur]) {
			return;
		}
		for (int k : reach.get(cur)) {
			cur_group_reach.add(k);
		}
		repeat[cur] = true;
		cur_group.add(cur);
		find_group(repeat, from_and_to[cur], cur_group, cur_group_reach);
	}
	*/
}
