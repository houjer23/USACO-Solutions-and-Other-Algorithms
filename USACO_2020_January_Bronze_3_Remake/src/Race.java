import java.io.*;
import java.util.*;

public class Race {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("race.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		List<Integer> answer = new ArrayList<>();
		int max_num = 1;
		int max = 0;
		while (max_num < K)
		{
			max_num += max + 1;
			max ++;
		}
		for (int i = 0; i < N; i ++)
		{
			int num = Integer.parseInt(br.readLine());
			if (max <= num)
			{
				answer.add(max);
				continue;
			}
			int cur_times = num;
			int cur_sum = (1 + num) * num / 2;
			int cur = cur_times;
			while (cur_sum < K)
			{
				if (cur_sum + (cur + 1) + cur_sum < K)
				{
					cur_sum += cur + 1;
					cur ++;
					cur_times ++;
				}
				else
				{
					//System.out.println(cur_sum);
					cur_sum += (num + (cur_times - 1)) * (cur - num) / 2;
					int diff = K - cur_sum;
					if (((double) diff/cur_times) % 1 == 0)
					{
						diff = diff/cur_times;
					}
					else
					{
						diff = diff/cur_times + 1;
					}
					//System.out.println(cur_sum + " " + cur_times + " " + diff);
					cur_times = cur_times + (cur_times - num) + diff;
					answer.add(cur_times);
					break;
				}
			}
		}
		
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));
		for (int i = 0; i < N; i ++)
		{
			pw.println(answer.get(i));
		}
		pw.close();
	}
}