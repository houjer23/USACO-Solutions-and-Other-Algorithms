import java.io.*;
import java.util.*;

public class The_Bovine_Shuffle {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> shuffle = new HashMap<>();
		int[] shuffle_list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i ++)
		{
			int cur = Integer.parseInt(st.nextToken()) - 1;
			shuffle_list[i] = cur;
			if (!shuffle.containsKey(cur))
			{
				shuffle.put(cur, 0);
			}
			shuffle.put(cur, shuffle.get(cur) + 1);
		}
		int answer = 0;
		Deque <Integer> dq = new ArrayDeque<Integer>();
		for (int i = 0; i < N; i ++)
		{
			if (!shuffle.containsKey(i))
			{
				dq.add(i);
				answer ++;
			}
		}
		while (dq.size() != 0)
		{
			int cur = shuffle_list[dq.pollFirst()];
			shuffle.put(cur, shuffle.get(cur) - 1);
			if (shuffle.get(cur) == 0)
			{
				dq.add(cur);
				answer ++;
			}
		}
		pw.println(N - answer);
		pw.close();
	}

}
