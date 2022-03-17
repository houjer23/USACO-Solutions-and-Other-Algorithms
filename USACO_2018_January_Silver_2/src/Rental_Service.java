import java.io.*;
import java.util.*;

public class Rental_Service {
	public static class Cow implements Comparable<Cow>{
		long gallon;
		
		public Cow(long gallon) {
			this.gallon = gallon;
		}
		
		public int compareTo(Cow c2) {
			return (int) (c2.gallon - this.gallon);
		}
	}
	public static class Shop implements Comparable<Shop>{
		long gallon;
		long cent;
		
		public Shop(long gallon, long cent) {
			this.gallon = gallon;
			this.cent = cent;
		}
		
		public int compareTo(Shop s2) {
			return (int) (s2.cent - this.cent);
		}
	}
	public static class Rent implements Comparable<Rent>{
		long cent;
		
		public Rent(long cent) {
			this.cent = cent;
		}
		
		public int compareTo(Rent r2) {
			return (int) (r2.cent - this.cent);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("rental.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		Cow[] cows = new Cow[N];
		for (int i = 0; i < N; i ++)
		{
			Cow c = new Cow(Long.parseLong(br.readLine()));
			cows[i] = c;
		}
		Arrays.sort(cows);
		Shop[] shops = new Shop[M];
		for (int i = 0; i < M; i ++)
		{
			st = new StringTokenizer(br.readLine());
			Shop s = new Shop(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			shops[i] = s;
		}
		Arrays.sort(shops);
		Rent[] rents = new Rent[R];
		for (int i = 0; i < R; i ++)
		{
			Rent r = new Rent(Long.parseLong(br.readLine()));
			rents[i] = r;
		}
		Arrays.sort(rents);
		int milk = 0;
		long left = shops[0].gallon;
		int line = 0;
		long total_cent = 0;
		for (int i = 0; i < N; i ++)
		{
			if (milk >= M)
			{
				line = i;
				break;
			}
			long cow_gallon = cows[i].gallon;
			long cent = 0;
			while (cow_gallon >= left)
			{
				cent += left * shops[milk].cent;
				cow_gallon -= left;
				milk += 1;
				if (milk >= M)
				{
					break;
				}
				left = shops[milk].gallon;
			}
			if (milk < M)
			{
				cent += cow_gallon * shops[milk].cent;
				left -= cow_gallon;
			}
			if (N - 1 - i < R)
			{
				if (rents[N - 1 - i].cent >= cent)
				{
					line = i;
					break;
				}
				else
				{
					total_cent += cent;
				}
			}
			else
			{
				total_cent += cent;
			}
			if (i == N - 1)
			{
				line = N;
			}
		}
		int j = 0;
		for (int i = line; i < N; i ++)
		{
			if (j >= R)
			{
				break;
			}
			total_cent += rents[j].cent;
			j ++;
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
		pw.println(total_cent);
		pw.close();
	}
}
