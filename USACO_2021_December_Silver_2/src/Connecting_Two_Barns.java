import java.io.*;
import java.util.*;

public class Connecting_Two_Barns {
	public static List<Integer> cur_group;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Map<Integer, Set<Integer>> path = new HashMap<>();
			Set<Integer> nums_set = new HashSet<>();
			for (int j = 0; j < M; j ++) {
				st = new StringTokenizer(br.readLine());
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				if (!path.containsKey(num1)) {
					path.put(num1, new HashSet<>());
				}
				if (!path.containsKey(num2)) {
					path.put(num2, new HashSet<>());
				}
				path.get(num1).add(num2);
				path.get(num2).add(num1);
				nums_set.add(num1);
				nums_set.add(num2);
			}
			List<Integer> nums = new ArrayList<>();
			for (int temp : nums_set) {
				nums.add(temp);
			}
			Collections.sort(nums);
			find_answer(N, M, path, nums);
		}
	}
	public static void find_answer(int N, int M, Map<Integer, Set<Integer>> path, List<Integer> nums) {
		//System.out.println(path);
		//System.out.println(nums);
		List<List<Integer>> group = new ArrayList<>();
		Set<Integer> repeat = new HashSet<>();
		for (int i = 0; i < nums.size(); i ++) {
			if (repeat.contains(nums.get(i))) {
				continue;
			}
			cur_group = new ArrayList<>();
			cur_group.add(nums.get(i));
			cur_group.add(nums.get(i));
			find_group(repeat, nums.get(i), path);
			group.add(cur_group);
		}
		int start = 1;
		if (group.size() != 0 && group.get(0).get(0) == 1) {
			start = group.get(0).get(1);
			group.remove(0);
		}
		int end = N;
		if (group.size() != 0 && group.get(group.size() - 1).get(1) == N) {
			end = group.get(group.size() - 1).get(0);
			group.remove(group.size() - 1);
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < group.size(); i ++) {
			int cur_answer = 0;
			cur_answer += (group.get(i).get(0) - start) * (group.get(i).get(0) - start);
			cur_answer += (end - group.get(i).get(1)) * (end - group.get(i).get(1));
			answer = Math.min(answer, cur_answer);
			//System.out.println(cur_answer);
		}
		int middle = (start + end) / 2;
		int cur_answer = (middle - start) * (middle - start) + (end - middle) * (end - middle);
		answer = Math.min(answer, cur_answer);
		System.out.println(answer);
		//System.out.println(start + " " + end);
		//System.out.println(group);
	}
	public static void find_group(Set<Integer> repeat, int cur, Map<Integer, Set<Integer>> path) {
		repeat.add(cur);
		Set<Integer> cur_path = path.get(cur);
		for (int temp : cur_path) {
			if (repeat.contains(temp)) {
				continue;
			}
			cur_group.set(0, Math.min(cur_group.get(0), temp));
			cur_group.set(1, Math.max(cur_group.get(1), temp));
			repeat.add(temp);
			find_group(repeat, temp, path);
		}
	}
}
