import java.io.*;
import java.util.*;

public class Teleportation {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
		int N = Integer.parseInt(br.readLine());
		int[][] cow = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			cow[i][0] = Integer.parseInt(st.nextToken());
			cow[i][1] = Integer.parseInt(st.nextToken());
		}
		long worest = 0;
		TreeMap<Integer, Integer> teleport = new TreeMap<>();
		for (int i = 0; i < N; i ++)
		{
			int a = cow[i][0];
			int b = cow[i][1];
			int point1;
			int point2;
			worest += Math.abs(a - b);
			if (Math.abs(a) >= Math.abs(a - b))
			{
				continue;
			}
			else if ((b < a && a <= 0) || (b > a && a >= 0))
			{
				point1 = 2 * b - 2 * a;
				point2 = 2 * a;
			}
			else
			{
				point1 = 2 * b;
				point2 = 0;
			}
			if (!teleport.containsKey(point1))
			{
				teleport.put(point1, 0);
			}
			if (!teleport.containsKey(point2))
			{
				teleport.put(point2, 0);
			}
			if (!teleport.containsKey(b))
			{
				teleport.put(b, 0);
			}
			teleport.put(point1, teleport.get(point1) + 1);
			teleport.put(point2, teleport.get(point2) + 1);
			teleport.put(b, teleport.get(b) - 2);
		}
		long max_y = 0;
		long slope = 0;
		long cur_y = 0;
		int last = teleport.firstKey();
		for (int i : teleport.keySet())
		{
			cur_y += slope * (i - last);
			slope += teleport.get(i);
			last = i;
			if (cur_y > max_y)
			{
				max_y = cur_y;
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		pw.println(worest - max_y);
		pw.close();
	}
}
