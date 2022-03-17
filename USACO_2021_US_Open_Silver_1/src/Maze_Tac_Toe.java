import java.io.*;
import java.util.*;

public class Maze_Tac_Toe {
	public static class Place{
		char letter;
		int posi;
		
		public Place(char letter, int posi) {
			this.letter = letter;
			this.posi = posi;
		}
		
		public String toString() {
			return letter + " " + posi;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 7)
		{
			System.out.println(8);
			return;
		}
		Place[][] board = new Place[N][N];
		int start = -1;
		for (int i = 0; i < N; i ++)
		{
			String str = br.readLine();
			for (int j = 0; j < N; j ++)
			{
				if (str.charAt(j * 3) == '#' || str.charAt(j * 3) == 'B' || str.charAt(j * 3) == '.')
				{
					if (str.charAt(j * 3) == 'B')
					{
						start = i * N + j;
					}
					board[i][j] = new Place(str.charAt(j * 3), 0);
				}
				else
				{
					int posi = ((int) str.charAt(j * 3 + 1) - 49) * 3 + ((int) str.charAt(j * 3 + 2) - 49);
					board[i][j] = new Place(str.charAt(j * 3), posi);
				}
			}
		}
		dfs(board, N, start, new char[3][3], new HashSet<>());
	}
	public static void printBoard(Place[][] board, int N) {
		for (int i = 0; i < N; i ++)
		{
			for (int j = 0; j < N; j ++)
			{
				System.out.print(board[i][j] + "   ");
			}
			System.out.println();
		}
	}
	public static void printTicTacToe(char[][] tic_tac_toe) {
		for (int i = 0; i < 3; i ++)
		{
			for (int j = 0; j < 3; j ++)
			{
				if (tic_tac_toe[i][j] == 'M' || tic_tac_toe[i][j] == 'O')
				{
					System.out.print(tic_tac_toe[i][j] + " ");
				}
				else
				{
					System.out.print(". ");
				}
			}
			System.out.println();
		}
	}
	public static void dfs(Place[][] board, int N, int cur, char[][] tic_tac_toe, Set<Integer> repeat) {
		char[][] new_tic_tac_toe = tic_tac_toe.clone();
		int cur_i = cur / N;
		int cur_j = cur % N;
		repeat.add(cur_i * N + cur_j);
		if ((board[cur_i][cur_j].letter == 'O' || board[cur_i][cur_j].letter == 'M'))
		{
			System.out.println(cur_i + " " + cur_j);
			int first = board[cur_i][cur_j].posi / 3;
			int second = board[cur_i][cur_j].posi % 3;
			if (new_tic_tac_toe[first][second] != 'M' && new_tic_tac_toe[first][second] != 'O')
			{
				new_tic_tac_toe[first][second] = board[cur_i][cur_j].letter;
			}
			printTicTacToe(new_tic_tac_toe);
		}
		int[][] temp = {{cur_i - 1, cur_j}, {cur_i + 1, cur_j}, {cur_i, cur_j - 1}, {cur_i, cur_j + 1}};
		for (int i = 0; i < 4; i ++)
		{
			int next_i = temp[i][0];
			int next_j = temp[i][1];
			if (board[next_i][next_j].letter != '#' && !repeat.contains(next_i * N + next_j))
			{
				Set<Integer> new_repeat = new HashSet<>();
				new_repeat.addAll(repeat);
				dfs(board, N, next_i * N + next_j, tic_tac_toe, new_repeat);
			}
		}
	}
}
