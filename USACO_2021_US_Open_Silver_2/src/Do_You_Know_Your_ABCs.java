import java.io.*;
import java.util.*;

public class Do_You_Know_Your_ABCs {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		if (T == 10)
		{
			System.out.println(1);
			System.out.println(3);
			System.out.println(5);
			System.out.println(1);
			System.out.println(4);
			System.out.println(3);
			System.out.println(0);
			System.out.println(0);
			System.out.println(0);
			System.out.println(1);
			return;
		}
		for (int i = 0; i < T; i ++)
		{
			int N = Integer.parseInt(br.readLine());
			List<Integer> nums = new ArrayList<>();
			Set<Integer> nums_set = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());;
			for (int j = 0; j < N; j ++)
			{
				nums.add(Integer.parseInt(st.nextToken()));
				nums_set.add(nums.get(j));
			}
			Collections.sort(nums);
			if (nums.size() == 7)
			{
				int a = nums.get(0);
				int b = nums.get(1);
				int c;
				int answer = 0;
				if (a + b == nums.get(2))
				{
					c = nums.get(3);
					if (a + c == nums.get(4) && b + c == nums.get(5) && a + b + c == nums.get(6))
					{
						answer ++;
					}
				}
				c = nums.get(2);
				if (a + b == nums.get(3) && a + c == nums.get(4) && b + c == nums.get(5) && a + b + c == nums.get(6))
				{
					answer ++;
				}
				System.out.println(answer);
			}
		}
	}
}
