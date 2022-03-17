import java.io.*;
import java.util.*;

public class Spaced_Out {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];
		for (int i = 0; i < N; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j ++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int final_answer1 = 0;
		for (int col = 0; col < N; col ++) {
			int cur_answer1 = 0;
			int cur_answer2 = 0;
			for (int row = 0; row < N; row ++) {
				if (row % 2 == 0) {
					cur_answer1 += graph[row][col];
				} else {
					cur_answer2 += graph[row][col];
				}
			}
			final_answer1 += Math.max(cur_answer1, cur_answer2);
		}
		int final_answer2 = 0;
		for (int row = 0; row < N; row ++) {
			int cur_answer1 = 0;
			int cur_answer2 = 0;
			for (int col = 0; col < N; col ++) {
				if (col % 2 == 0) {
					cur_answer1 += graph[row][col];
				} else {
					cur_answer2 += graph[row][col];
				}
			}
			final_answer2 += Math.max(cur_answer1, cur_answer2);
		}
		System.out.println(Math.max(final_answer1, final_answer2));
	}
}
