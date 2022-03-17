import java.io.*;
import java.util.*;

public class Cow_Gymnastics {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] ranking_arr = new int[K][N];
		List<Map<Integer, Integer>> ranking = new ArrayList<>();
		for (int i = 0; i < K; i ++)
		{
			st = new StringTokenizer(br.readLine());
			ranking.add(new HashMap<>());
			for (int j = 0; j < N; j ++)
			{
				ranking_arr[i][j] = Integer.parseInt(st.nextToken());
				ranking.get(i).put(ranking_arr[i][j], j);
			}
		}
		int answer = 0;
		for (int i = 0; i < N - 1; i ++)
		{
			for (int j = i + 1; j < N; j ++)
			{
				int flag = 1;
				for (int k = 1; k < K; k ++)
				{
					if (ranking.get(k).get(ranking_arr[0][i]) > ranking.get(k).get(ranking_arr[0][j]))
					{
						flag = 0;
						break;
					}
				}
				if (flag == 1)
				{
					answer ++;
				}
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
		pw.println(answer);
		pw.close();
	}
}
