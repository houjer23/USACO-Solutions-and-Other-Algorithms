import java.io.*;
import java.util.*;

public class Comfortable_Cows {
	public static int num_answer = 0;
	public static int[][] pasture = new int[3000][3000];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) + 1000;
			int y = Integer.parseInt(st.nextToken()) + 1000;
			if (pasture[x][y] == 2)
			{
				num_answer --;
			}
			pasture[x][y] = 1;
			check(x, y);
			System.out.println(num_answer);
		}
		/*
		for (int i = 1000; i < 1006; i ++)
		{
			for (int j = 999; j < 1005; j ++)
			{
				System.out.print(pasture[i][j]);
			}
			System.out.println();
		}
		*/
	}
	public static void check(int x, int y) {
		int[][] around = {{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}};
		for (int j = 0; j < 4; j ++)
		{
			int cur_x = around[j][0];
			int cur_y = around[j][1];
			if (pasture[cur_x][cur_y] == 0)
			{
				continue;
			}
			int adjacent = 0;
			int[] not_adjacent = new int[2];
			int[][] new_around = {{cur_x - 1, cur_y}, {cur_x + 1, cur_y}, {cur_x, cur_y - 1}, {cur_x, cur_y + 1}};
			for (int k = 0; k < 4; k ++)
			{
				int new_cur_x = new_around[k][0];
				int new_cur_y = new_around[k][1];
				if (pasture[new_cur_x][new_cur_y] == 1 || pasture[new_cur_x][new_cur_y] == 2)
				{
					adjacent ++;
				}
				else
				{
					not_adjacent[0] = new_cur_x;
					not_adjacent[1] = new_cur_y;
				}
			}
			if (adjacent == 3)
			{
				pasture[not_adjacent[0]][not_adjacent[1]] = 2;
				num_answer ++;
				check(not_adjacent[0], not_adjacent[1]);
			}
		}
	}
}
