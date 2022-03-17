import java.io.*;
import java.util.*;

public class Why_Did_the_Cow_Cross_the_Road_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < B; i ++)
		{
			nums.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(nums);
		List<Integer> new_nums = new ArrayList<>();
		new_nums.add(nums.get(0) - 1);
		for (int i = 0; i < B - 1; i ++)
		{
			new_nums.add(nums.get(i + 1) - nums.get(i) - 1);
		}
		new_nums.add(N - nums.get(B - 1));
		for (int i = 0; i < new_nums.size(); i ++)
		{
			if (new_nums.get(i) >= K)
			{
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
				pw.println(0);
				pw.close();
				return;
			}
		}
		int answer = Integer.MAX_VALUE;
		int cur_result = new_nums.get(0) + new_nums.get(1) + 1;
		int i = 0;
		int j = 1;
		while (true)
		{
			if (cur_result < K)
			{
				j ++;
				if (j == new_nums.size())
				{
					break;
				}
				cur_result += new_nums.get(j) + 1;
			}
			else
			{
				while (cur_result >= K)
				{
					if (answer > j - i)
					{
						answer = j - i;
					}
					cur_result -= new_nums.get(i) + 1;
					i ++;
				}
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
		pw.println(answer);
		pw.close();
	}
}
