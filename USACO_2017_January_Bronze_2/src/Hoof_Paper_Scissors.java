import java.io.*;
import java.util.*;

public class Hoof_Paper_Scissors {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("hps.in"));
		int N = Integer.parseInt(br.readLine());
		int[][] game = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			game[i][0] = Integer.parseInt(st.nextToken());
			game[i][1] = Integer.parseInt(st.nextToken());
		}
		int won = 0;
		int[][] num = {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};
		for (int i = 0; i < 6; i ++)
		{
			int cur_won = 0;
			for (int j = 0; j < N; j ++)
			{
				if (game[j][0] == num[i][0] && game[j][1] == num[i][1])
				{
					cur_won += 1;
				}
				else if (game[j][0] == num[i][1] && game[j][1] == num[i][2])
				{
					cur_won += 1;
				}
				else if (game[j][0] == num[i][2] && game[j][1] == num[i][0])
				{
					cur_won += 1;
				}
			}
			if (cur_won > won)
			{
				won = cur_won;
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		pw.println(won);
		pw.close();
	}
}
