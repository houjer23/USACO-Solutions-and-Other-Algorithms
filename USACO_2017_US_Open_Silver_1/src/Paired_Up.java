import java.io.*;
import java.util.*;

public class Paired_Up {
	public static class Cow implements Comparable<Cow>{
		int id;
		int num;
		
		public Cow(int id, int num) {
			this.id = id;
			this.num = num;
		}
		
		public int compareTo(Cow c2) {
			return this.id - c2.id;
		}
		
		public String toString() {
			return id + " " + num;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Cow> cows = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int cow_num = Integer.parseInt(st.nextToken());
			int cow_id = Integer.parseInt(st.nextToken());
			Cow cur = new Cow(cow_id, cow_num);
			cows.add(cur);
		}
		Collections.sort(cows);
		//System.out.println(cows);
		int i = 0;
		int j = N - 1;
		int answer = 0;
		while (i <= j)
		{
			//System.out.println(cows.get(i) + " " + cows.get(j));
			if (cows.get(i).id + cows.get(j).id > answer)
			{
				answer = cows.get(i).id + cows.get(j).id;
			}
			if (cows.get(i).num > cows.get(j).num)
			{
				cows.set(i, new Cow(cows.get(i).id, cows.get(i).num - cows.get(j).num));
				j --;
			}
			else if (cows.get(i).num < cows.get(j).num)
			{
				cows.set(j, new Cow(cows.get(j).id, cows.get(j).num - cows.get(i).num));
				i ++;
			}
			else
			{
				i ++;
				j --;
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
		pw.println(answer);
		pw.close();
	}

}
