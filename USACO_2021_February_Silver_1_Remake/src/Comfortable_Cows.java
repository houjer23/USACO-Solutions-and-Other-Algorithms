import java.io.*;
import java.util.*;

public class Comfortable_Cows {
	static int cur_answer = 0;
	public static int[][] neighbors = new int[3000][3000];
	public static boolean[][] cows = new boolean[3000][3000];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] answer = new int[N];
		StringTokenizer st;
		for (int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			int pos_i = Integer.parseInt(st.nextToken()) + 1000;
			int pos_j = Integer.parseInt(st.nextToken()) + 1000;
			cur_answer --;
			if (!cows[pos_i][pos_j]) {
				dfs(pos_i, pos_j);
			}
			answer[i] = cur_answer;
		}
		for (int i = 0; i < N; i ++) {
			System.out.println(answer[i]);
		}
	}
	public static void dfs(int i, int j) {
		if (cows[i][j]) {
			return;
		}
		int[][] next = {{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};
		cows[i][j] = true;
		cur_answer ++;
		if (neighbors[i][j] == 3) {
			for (int k = 0; k < 4; k ++) {
				dfs(next[k][0], next[k][1]);
			}
		}
		for (int k = 0; k < 4; k ++) {
			int next_i = next[k][0];
			int next_j = next[k][1];
			neighbors[next_i][next_j] ++;
			if (cows[next_i][next_j] && neighbors[next_i][next_j] == 3) {
				int[][] add = {{next_i - 1, next_j}, {next_i + 1, next_j}, {next_i, next_j - 1}, {next_i, next_j + 1}};
				for (int l = 0; l < 4; l ++) {
					dfs(add[l][0], add[l][1]);
				}
			}
		}
	}
}
