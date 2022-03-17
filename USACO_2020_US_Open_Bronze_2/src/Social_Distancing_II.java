import java.io.*;
import java.util.*;

public class Social_Distancing_II {
	public static class Cow implements Comparable<Cow>{
		int posi;
		int id;
		
		public Cow(int posi, int id) {
			this.posi = posi;
			this.id = id;
		}
		
		public int compareTo(Cow c2) {
			return this.posi - c2.posi;
		}
		
		public String toString() {
			return posi + " " + id;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("socdist2.in"));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Cow[] cows_arr = new Cow[N];
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			Cow c = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			cows_arr[i] = c;
		}
		Arrays.sort(cows_arr);
		int r = Integer.MAX_VALUE;
		for (int i = 0; i < N; i ++)
		{
			if (cows_arr[i].id == 0)
			{
				if (i != 0 && cows_arr[i - 1].id == 1)
				{
					if (cows_arr[i].posi - cows_arr[i - 1].posi - 1 < r)
					{
						r = cows_arr[i].posi - cows_arr[i - 1].posi - 1;
					}
				}
			}
		}
		int pairs = 0;
		Set<Integer> repeat = new HashSet<>();
		for (int i = 0; i < N; i ++)
		{
			if (cows_arr[i].id == 1 && !repeat.contains(cows_arr[i].posi))
			{
				int cur = i;
				pairs ++;
				while (true)
				{
					if (cur + 1 >= N)
					{
						break;
					}
					if (cows_arr[cur + 1].id == 0)
					{
						cur ++;
						continue;
					}
					if (cows_arr[cur].posi + r >= cows_arr[cur + 1].posi)
					{
						repeat.add(cows_arr[cur + 1].posi);
						cur ++;
						continue;
					}
					else
					{
						break;
					}
				}
			}
		}
		//System.out.println(pairs);
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("socdist2.out")));
		pw.println(pairs);
		pw.close();
	}
}
