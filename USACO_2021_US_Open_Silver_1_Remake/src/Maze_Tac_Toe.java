import java.io.*;
import java.util.*;

public class Maze_Tac_Toe {
	public static Set<String> answer = new HashSet<>();
	public static Set<String> possible_answer = new HashSet<>();
	public static String[][] board;
	public static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new String[N][N];
		int start_i = -1;
		int start_j = -1;
		StringTokenizer st;
		for (int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			String cur = st.nextToken();
			for (int j = 0; j < N; j ++) {
				String add = cur.substring(j * 3, j * 3 + 3);
				board[i][j] = add;
				if (add.equals("BBB")) {
					start_i = i;
					start_j = j;
				}
			}
		}
		set_possible_answers();
		String empty_tic = ".........";
		dfs(empty_tic, start_i, start_j, new boolean[N][N][4]);
		System.out.println(answer.size());
		//System.out.println(answer);
	}
	
	public static void dfs(String tic, int cur_i, int cur_j, boolean[][][] repeat) {
		if (board[cur_i][cur_j].charAt(0) == 'O' || board[cur_i][cur_j].charAt(0) == 'M') {
			int change_index = (board[cur_i][cur_j].charAt(1) - 49) * 3 + ((int) board[cur_i][cur_j].charAt(2) - 49);
			if (tic.charAt(change_index) == '.') {
				tic = tic.substring(0,change_index) + board[cur_i][cur_j].charAt(0) + tic.substring(change_index + 1);
			}
		}
		if (possible_answer.contains(tic)) {
			answer.add(tic);
			return;
		}
		int[][] next = {{cur_i + 1, cur_j}, {cur_i - 1, cur_j}, {cur_i, cur_j + 1}, {cur_i, cur_j - 1}};
		for (int i = 0; i < 4; i ++) {
			int next_i = next[i][0];
			int next_j = next[i][1];
			if (!board[next_i][next_j].equals("###") && repeat[cur_i][cur_j][i] == false) {
				repeat[cur_i][cur_j][i] = true;
				dfs(tic, next_i, next_j, repeat);
				repeat[cur_i][cur_j][i] = false;
			}
		}
	}
	
	public static void set_possible_answers() {
		char[] choice = {'M', 'O', '.'};
		char[] cur_answer = new char[9];
		for (int i = 0; i < 3; i ++) {
			cur_answer[0] = choice[i];
			for (int j = 0; j < 3; j ++) {
				cur_answer[1] = choice[j];
				for (int k = 0; k < 3; k ++) {
					cur_answer[2] = choice[k];
					for (int l = 0; l < 3; l ++) {
						cur_answer[3] = choice[l];
						for (int m = 0; m < 3; m ++) {
							cur_answer[4] = choice[m];
							for (int n = 0; n < 3; n ++) {
								cur_answer[5] = choice[n];
								for (int o = 0; o < 3; o ++) {
									cur_answer[6] = choice[o];
									for (int p = 0; p < 3; p ++) {
										cur_answer[7] = choice[p];
										for (int q = 0; q < 3; q ++) {
											cur_answer[8] = choice[q];
											String cur_answer_string = String.valueOf(cur_answer);
											check_answer(cur_answer_string);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static void check_answer(String tic) {
		int[][] posibility = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
		for (int i = 0; i < 8; i ++) {
			int pt1 = posibility[i][0];
			int pt2 = posibility[i][1];
			int pt3 = posibility[i][2];
			if (tic.charAt(pt1) == 'M' && tic.charAt(pt2) == 'O' && tic.charAt(pt3) == 'O') {
				possible_answer.add(tic);
				return;
			}
			if (tic.charAt(pt1) == 'O' && tic.charAt(pt2) == 'O' && tic.charAt(pt3) == 'M') {
				possible_answer.add(tic);
				return;
			}
		}
	}
}
