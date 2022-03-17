import java.io.*;
import java.util.*;

public class Photoshoot {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("photo.in"));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] b = new int[N - 1];
		for (int i = 0; i < N - 1; i ++)
		{
			b[i] = Integer.parseInt(st.nextToken());
		}
		int[] answer = new int[N];
		for (int i = 1; i <= b[0]; i ++)
		{
			Set<Integer> repeat = new HashSet<>();
			int[] a = new int[N];
			a[0] = i;
			repeat.add(i);
			for (int j = 1; j < N; j ++)
			{
				int cur = b[j - 1] - a[j - 1];
				if (cur <= 0 || repeat.contains(cur))
				{
					break;
				}
				a[j] = cur;
				repeat.add(cur);
			}
			if (repeat.size() == N)
			{
				answer = a;
				break;
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
		for (int i = 0; i < N; i ++)
		{
			if (i == N - 1)
			{
				pw.print(answer[i]);
			}
			else
			{
				pw.print(answer[i] + " ");
			}
		}
		pw.println();
		pw.close();
	}
}
