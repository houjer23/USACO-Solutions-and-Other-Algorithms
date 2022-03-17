import java.io.*;
import java.util.*;

public class Moocast {
	static int answer = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		int N = Integer.parseInt(br.readLine());
		
		int[][] cows = new int[N][3];
		StringTokenizer st;
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			cows[i][0] = Integer.parseInt(st.nextToken());
			cows[i][1] = Integer.parseInt(st.nextToken());
			cows[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < cows.length; i ++)
		{
			dfs(cows, i, new HashSet<>(), new HashSet<>(Arrays.asList(String.valueOf(cows[i][0]) + " " + String.valueOf(cows[i][1]))));
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		pw.println(answer);
		pw.close();
	}
	public static void dfs(int[][] cows, int cur, Set<String> repeat, Set<String> reached) {
		if (reached.size() > answer)
		{
			answer = reached.size();
		}
		for (int i = 0; i < cows.length; i ++)
		{
			if (i != cur && !repeat.contains(String.valueOf(cows[cur][0]) + " " + String.valueOf(cows[cur][1]) + " " + String.valueOf(cows[i][0]) + " " + String.valueOf(cows[i][1])) && cows[cur][2] > distance(cows[cur][0], cows[cur][1], cows[i][0], cows[i][1]))
			{
				repeat.add(String.valueOf(cows[cur][0]) + " " + String.valueOf(cows[cur][1]) + " " + String.valueOf(cows[i][0]) + " " + String.valueOf(cows[i][1]));
				reached.add(String.valueOf(cows[i][0]) + " " + String.valueOf(cows[i][1]));
				dfs(cows, i, repeat, reached);
			}
		}
	}
	public static double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Double.valueOf((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)));
	}
}
