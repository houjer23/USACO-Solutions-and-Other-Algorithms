import java.io.*;
import java.util.*;

public class Why_Did_the_Cow_Cross_the_Road {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		List<Integer> chickens = new ArrayList<>();
		for (int i = 0; i < C; i ++)
		{
			chickens.add(Integer.parseInt(br.readLine()));
		}
		Time[] times = new Time[N];
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			Time temp = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			times[i] = temp;
		}
		Collections.sort(chickens);
		Arrays.sort(times);
		int answer = 0;
		for (int i = 0; i < N; i ++)
		{
			int start = 0;
			int end = chickens.size() - 1;
			while (start < end)
			{
				int middle = (start + end) / 2;
				if (chickens.get(middle) >= times[i].start)
				{
					end = middle;
				}
				else
				{
					start = middle + 1;
				}
			}
			if (chickens.get(start) >= times[i].start && chickens.get(start) <= times[i].end)
			{
				answer ++;
				chickens.remove(start);
			}
			if (chickens.size() == 0)
			{
				break;
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
		pw.println(answer);
		pw.close();
	}
	public static class Time implements Comparable<Time>{
		int start;
		int end;
		
		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Time t2) {
			return this.end - t2.end;
		}
		public String toString() {
			return start + " " + end;
		}
	}
}
