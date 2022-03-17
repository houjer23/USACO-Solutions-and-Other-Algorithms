import java.io.*;
import java.util.*;

public class Paired_Up {
	public static class Cow implements Comparable<Cow>{
		int milk;
		int num;
		
		public Cow(int milk, int num) {
			this.milk = milk;
			this.num = num;
		}
		
		public int compareTo(Cow c2) {
			return this.milk - c2.milk;
		}
		
		public String toString() {
			return milk + " " + num;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Cow> cows = new ArrayList<>();
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int milk = Integer.parseInt(st.nextToken());
			Cow c = new Cow(milk, num);
			cows.add(c);
		}
		Collections.sort(cows);
		int i = 0;
		int j = N - 1;
		int answer = 0;
		while (i <= j)
		{
			if (cows.get(i).milk + cows.get(j).milk > answer)
			{
				answer = cows.get(i).milk + cows.get(j).milk;
			}
			if (cows.get(i).num < cows.get(j).num)
			{
				Cow c = new Cow(cows.get(j).milk, cows.get(j).num - cows.get(i).num);
				i ++;
				cows.set(j, c);
			}
			else if (cows.get(i).num > cows.get(j).num)
			{
				Cow c = new Cow(cows.get(i).milk, cows.get(i).num - cows.get(j).num);
				j --;
				cows.set(i, c);
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
