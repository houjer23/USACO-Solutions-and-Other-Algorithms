import java.io.*;
import java.util.*;

public class Painting_the_Barn {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] barn = new int[1001][1001];
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			barn[x1 + 1][y1 + 1] += 1;
			barn[x1 + 1][y2 + 1] -= 1;
			barn[x2 + 1][y1 + 1] -= 1;
			barn[x2 + 1][y2 + 1] += 1;
		}
		int answer = 0;
		for (int i = 1; i < barn.length; i ++)
		{
			for (int j = 1; j < barn.length; j ++)
			{
				barn[i][j] = barn[i - 1][j] + barn[i][j - 1] - barn[i - 1][j - 1] + barn[i][j];
				if (barn[i][j] == K)
				{
					answer ++;
				}
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
		pw.println(answer);
		pw.close();
	}

}
