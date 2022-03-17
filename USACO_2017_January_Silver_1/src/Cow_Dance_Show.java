import java.io.*;
import java.util.*;

public class Cow_Dance_Show {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		List<Integer> cows = new ArrayList<>();
		for (int i = 0; i < N; i ++)
		{
			cows.add(Integer.parseInt(br.readLine()));
		}
		int answer = 0;
		for (int i = 1; i <= N; i ++)
		{
			int flag = 1;
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
			for (int j = 0; j < i; j ++)
			{
				queue.offer(cows.get(j));
			}
			for (int j = i; j < N; j ++) 
			{
				int temp = (int) queue.peek() + cows.get(j);
				if (temp > T)
				{
					flag = 0;
					break;
				}
				queue.poll();
				queue.offer(temp);
			}
			if (flag == 1)
			{
				answer = i;
				break;
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
		pw.println(answer);
		pw.close();
	}
}
