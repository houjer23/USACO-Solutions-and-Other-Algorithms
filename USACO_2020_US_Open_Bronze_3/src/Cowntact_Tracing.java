import java.io.*;
import java.util.*;

public class Cowntact_Tracing {
	public static class Infect implements Comparable<Infect>{
		int t;
		int x;
		int y;
		
		public Infect(int t, int x, int y) {
			this.t = t;
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Infect i2) {
			return this.t - i2.t;
		}
		
		public String toString() {
			return t + " " + x + " " + y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("tracing.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		String cows = br.readLine();
		Infect[] infects = new Infect[T];
		for (int i = 0; i < T; i ++)
		{
			st = new StringTokenizer(br.readLine());
			Infect c = new Infect(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
			infects[i] = c;
		}
		Arrays.sort(infects);
		int x = 0;
		List<Integer> K = new ArrayList<>();
		Set<Integer> repeat = new HashSet<>();
		for (int i = 0; i < N; i ++)
		{
			if (cows.charAt(i) == '0')
			{
				continue;
			}
			for (int j = 0; j < N; j ++)
			{
				Map<Integer, Integer> infected = new HashMap<>();
				String temp_cows = "";
				for (int k = 0; k < N; k ++)
				{
					temp_cows = temp_cows + "0";
				}
				infected.put(i, 0);
				temp_cows = temp_cows.substring(0, i) + "1" + temp_cows.substring(i + 1);
				int k = 0;
				while (k < T && !(infects[k].x == i || infects[k].y == i))
				{
					k ++;
				}
				if (j != 0)
				{
					if (infects[k].x == i)
					{
						infected.put(infects[k].y, 0);
						temp_cows = temp_cows.substring(0, infects[k].y) + "1" + temp_cows.substring(infects[k].y + 1);
					}
					else
					{
						infected.put(infects[k].x, 0);
						temp_cows = temp_cows.substring(0, infects[k].x) + "1" + temp_cows.substring(infects[k].x + 1);
					}
					infected.put(i, 1);
				}
				while (k < T)
				{
					if (temp_cows.charAt(infects[k].x) == '1' && temp_cows.charAt(infects[k].y) == '1')
					{
						if (infected.get(infects[k].x) < j)
						{
							infected.put(infects[k].x, infected.get(infects[k].x) + 1);
						}
						if (infected.get(infects[k].y) < k)
						{
							infected.put(infects[k].y, infected.get(infects[k].y) + 1);
						}
					}
					else if (temp_cows.charAt(infects[k].x) == '1')
					{
						if (infected.get(infects[k].x) < j)
						{
							infected.put(infects[k].y, 0);
							temp_cows = temp_cows.substring(0, infects[k].y) + "1" + temp_cows.substring(infects[k].y + 1);
							infected.put(infects[k].x, infected.get(infects[k].x) + 1);
						}
					}
					else if (temp_cows.charAt(infects[k].y) == '1')
					{
						if (infected.get(infects[k].y) < j)
						{
							infected.put(infects[k].x, 0);
							temp_cows = temp_cows.substring(0, infects[k].x) + "1" + temp_cows.substring(infects[k].x + 1);
							infected.put(infects[k].y, infected.get(infects[k].y) + 1);
						}
					}
					k ++;
				}
				if (temp_cows.equals(cows))
				{
					if (!repeat.contains(i))
					{
						x += 1;
						repeat.add(i);
					}
					K.add(j);
				}
			}
		}
		//System.out.println(x);
		String answer = "";
		answer = String.valueOf(x) + " " + Collections.min(K) + " ";
		if (Collections.max(K) == N - 1)
		{
			answer = answer + "Infinity";
		}
		else
		{
			answer = answer + Collections.max(K);
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tracing.out")));
		pw.println(answer);
		pw.close();
	}
}
