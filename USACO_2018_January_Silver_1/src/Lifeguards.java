import java.io.*;
import java.util.*;

public class Lifeguards {
	public static class Cow implements Comparable<Cow>{
		int time;
		int index;
		
		public Cow(int time, int index) {
			this.time = time;
			this.index = index;
		}
		
		public int compareTo(Cow c2) {
			return this.time - c2.time;
		}
		
		public String toString() {
			return time + " " + index;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
		int N = Integer.parseInt(br.readLine());
		List<Cow> cows = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			Cow c = new Cow(Integer.parseInt(st.nextToken()), i);
			cows.add(c);
			c = new Cow(Integer.parseInt(st.nextToken()), i);
			cows.add(c);
		}
		Collections.sort(cows);
		Set<Integer> cur = new HashSet<Integer>();
		int[] answers = new int[N];
		int prev = 0;
		int total = 0;
		for (int i = 0; i < cows.size(); i ++)
		{
			if (cur.size() == 1)
			{
				for (int temp : cur)
				{
					answers[temp] += cows.get(i).time - prev;
				}
			}
			if (cur.size() != 0)
			{
				total += cows.get(i).time - prev;
			}
			if (cur.contains(cows.get(i).index))
			{
				cur.remove(cows.get(i).index);
			}
			else
			{
				cur.add(cows.get(i).index);
			}
			prev = cows.get(i).time;
		}
		int answer = 0;
		for (int i = 0; i < N; i ++)
		{
			answer = Math.max(answer, total - answers[i]);
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		pw.println(answer);
		pw.close();
	}
}
