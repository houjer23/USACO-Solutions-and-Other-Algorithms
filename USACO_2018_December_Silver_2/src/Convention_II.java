import java.io.*;
import java.util.*;

public class Convention_II {
	public static class Cow implements Comparable<Cow>{
		int start;
		int time;
		int index;
		
		public Cow(int start, int time, int index) {
			this.start = start;
			this.time = time;
			this.index = index;
		}
		
		public int compareTo(Cow c2) {
			if (this.start == c2.start)
				return this.index - c2.index;
			return this.start - c2.start;
		}
		
		public String toString() {
			return start + " " + time + " " + index;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Cow> cows = new ArrayList<Cow>();
		StringTokenizer st;
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			Cow c = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i + 1);
			cows.add(c);
		}
		Collections.sort(cows);
		int eating = cows.get(0).start + cows.get(0).time;
		ArrayList<Cow> prepare = new ArrayList<Cow>();
		int j = 1;
		int waiting_time = 0;
		for (int i = 1; i < N; i ++)
		{
			while (j < N && cows.get(j).start < eating)
			{
				if (prepare.size() == 0)
				{
					prepare.add(cows.get(j));
				}
				else if (cows.get(j).index > prepare.get(0).index)
				{
					prepare.add(0, cows.get(j));
				}
				else if (cows.get(j).index < prepare.get(prepare.size() - 1).index)
				{
					prepare.add(cows.get(j));
				}
				else
				{
					int start = 0;
					int end = prepare.size() - 1;
					while (start < end)
					{
						int meddle = (start + end) / 2;
						if (prepare.get(meddle).index < cows.get(j).index)
						{
							end = meddle;
						}
						else
						{
							start = meddle + 1;
						}
					}
					prepare.add(start, cows.get(j));
				}
				j ++;
			}
			if (prepare.size() != 0)
			{
				if (eating - prepare.get(prepare.size() - 1).start > waiting_time)
				{
					waiting_time = eating - prepare.get(prepare.size() - 1).start;
				}
				eating += prepare.get(prepare.size() - 1).time;
				prepare.remove(prepare.size() - 1);
			}
			else
			{
				eating = cows.get(i).time + cows.get(i).start;
				j = i + 1;
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
		pw.println(waiting_time);
		pw.close();
	}
}
