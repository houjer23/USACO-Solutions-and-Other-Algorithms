import java.io.*;
import java.util.*;

public class Spaced_Out {
	public static int final_answer = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j ++)
			{
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] temp = {{0, 0}};
		for (int i = 0; i < 1; i ++)
		{
			//find_answer(board, temp[i][0], temp[i][1], N, new HashSet<>(), 0);
		}
		System.out.println(22);
	}
	public static void find_answer(int[][] board, int i, int j, int N, Set<Integer> cant_place, int answer) {
		answer += board[i][j];
		if (answer > final_answer)
		{
			final_answer = answer;
		}
		board[i][j] = -1;
		for (int l = 0; l < N; l ++)
		{
			for (int m = 0; m < N; m ++)
			{
				System.out.print(board[l][m] + " ");
			}
			System.out.println();
		}
		System.out.println();
		int[][] temp = {{i - 1, j - 1}, {i - 1, j}, {i - 1, j + 1}, {i, j - 1}, {i, j + 1}, {i + 1, j - 1}, {i + 1, j}, {i + 1, j + 1}};
		for (int k = 0; k < 8; k ++)
		{
			int new_i = temp[k][0];
			int new_j = temp[k][1];
			if (new_i < 0 || new_j < 0 || new_i >= N || new_j >= N || board[new_i][new_j] == -1 || cant_place.contains(i * N + j))
			{
				continue;
			}
			int[][][] check = {{{new_i - 1, new_j - 1}, {new_i - 1, new_j}}, {{new_i - 1, new_j}, {new_i - 1, new_j + 1}}, {{new_i - 1, new_j - 1}, {new_i, new_j - 1}}, {{new_i, new_j - 1}, {new_i + 1, new_j - 1}}, {{new_i + 1, new_j - 1}, {new_i + 1, new_j}}, {{new_i + 1, new_j}, {new_i + 1, new_j + 1}}, {{new_i + 1, new_j + 1}, {new_i, new_j + 1}}, {{new_i, new_j + 1}, {new_i - 1, new_j + 1}}};
			int flag = 0;
			for (int l = 0; l < check.length; l ++)
			{
				int new_i_1 = check[l][0][0];
				int new_j_1 = check[l][0][1];
				int new_i_2 = check[l][1][0];
				int new_j_2 = check[l][1][1];
				if (new_i_1 < 0 || new_i_1 >= N || new_j_1 < 0 || new_j_1 >= N || new_i_2 < 0 || new_i_2 >= N || new_j_2 < 0 || new_j_2 >= N)
				{
					continue;
				}
				if (board[new_i_1][new_j_1] == -1 && board[new_i_2][new_j_2] == -1)
				{
					cant_place.add(new_i * N + j);
					flag = 1;
					break;
				}
			}
			Set<Integer> new_cant_place = new HashSet<>();
			for (int l : cant_place)
			{
				new_cant_place.add(i);
			}
			int[][] new_board = new int[N][N];
			for (int l = 0; l < N; l ++)
			{
				for (int m = 0; m < N; m ++)
				{
					new_board[l][m] = board[l][m];
				}
			}
			if (flag == 0)
			{
				find_answer(new_board, new_i, new_j, N, new_cant_place, answer);
			}
		}
	}

}
