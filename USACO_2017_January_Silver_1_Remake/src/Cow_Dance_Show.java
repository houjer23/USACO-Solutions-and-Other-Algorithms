import java.io.*;
import java.util.*;

public class Cow_Dance_Show {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T_max = Integer.parseInt(st.nextToken());
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < N; i ++)
		{
			nums.add(Integer.parseInt(br.readLine()));
		}
		int answer = 0;
		for (int i = 1; i < N; i ++)
		{
			int flag = 0;
			PriorityQueue<Integer> K = new PriorityQueue<>();
			for (int j = 0; j < i; j ++)
			{
				K.add(nums.get(j));
			}
			for (int j = i; j < N; j ++)
			{
				if (K.peek() + nums.get(j) > T_max)
				{
					flag = 1;
					break;
				}
				K.add(K.peek() + nums.get(j));
				K.remove();
			}
			if (flag == 0)
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
