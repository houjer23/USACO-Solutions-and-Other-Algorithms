import java.io.*;
import java.util.*;

public class Icy_Perimeter {
	public static int max_perimeter = 0;
	public static int max_area = 0;
	public static int cur_perimeter = 0;
	public static int cur_area = 0;
	public static String[] machine;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
		int N = Integer.parseInt(br.readLine());
		machine = new String[N];
		for (int i = 0; i < N; i ++) {
			machine[i] = br.readLine();
		}
		Set<Integer> repeat = new HashSet<>();
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < N; j ++) {
				if (machine[i].charAt(j) == '.') {
					repeat.add(i * N + j);
					continue;
				}
				if (!repeat.contains(i * N + j)) {
					cur_perimeter = 0;
					cur_area = 1;
					dfs(repeat, i, j, N);
					if (cur_area > max_area || (cur_area == max_area && cur_perimeter < max_perimeter)) {
						max_area = cur_area;
						max_perimeter = cur_perimeter;
					}
				}
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		pw.println(max_area + " " + max_perimeter);
		pw.close();
	}
	public static void dfs(Set<Integer> repeat, int cur_i, int cur_j, int N) {
		repeat.add(cur_i * N + cur_j);
		int[][] next = {{cur_i - 1, cur_j}, {cur_i + 1, cur_j}, {cur_i, cur_j - 1}, {cur_i, cur_j + 1}};
		for (int i = 0; i < 4; i ++) {
			int next_i = next[i][0];
			int next_j = next[i][1];
			boolean in_machine = next_i >= 0 && next_i < N && next_j >= 0 && next_j < N;
			if (!in_machine || machine[next_i].charAt(next_j) == '.') {
				cur_perimeter ++;
			}
			if (in_machine && machine[next_i].charAt(next_j) == '#' && !repeat.contains(next_i * N + next_j)) {
				cur_area ++;
				dfs(repeat, next_i, next_j, N);
			}
		}
	}
}
