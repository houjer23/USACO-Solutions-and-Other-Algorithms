import java.io.*;
import java.util.*;

public class Why_Did_the_Cow_Cross_the_Road {
	public static class Cow implements Comparable<Cow>{
		int start;
		int end;
		
		public Cow(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Cow c2) {
			return this.end - c2.end;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		Cow[] cows = new Cow[(int) N];
		ArrayList<Integer> chickens = new ArrayList<>();
		for (int i = 0; i < C; i ++)
		{
			chickens.add(Integer.parseInt(br.readLine()));
		}
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			Cow c = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			cows[i] = c;
		}
		Collections.sort(chickens);
		Arrays.sort(cows);
		/*
		for (int i = 0; i < C; i ++)
		{
			System.out.println(chickens[i]);
		}
		for (int i = 0; i < N; i ++)
		{
			System.out.println(cows[i].start + " " + cows[i].end);
		}
		*/
		
		int pairs = 0;
		for (int i = 0; i < N; i ++)
		{
			if (chickens.size() == 0)
			{
				break;
			}
			int start = 0;
			int end = chickens.size() - 1;
			if (cows[i].start > chickens.get(chickens.size() - 1))
			{
				continue;
			}
			while (start < end)
			{
				int middle = (start + end) / 2;
				if (cows[i].start > chickens.get(middle))
				{
					start = middle + 1;
				}
				else
				{
					end = middle;
				}
			}
			if (cows[i].end >= chickens.get(start))
			{
				chickens.remove(start);
				pairs ++;
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
		pw.println(pairs);
		pw.close();
	}
}
