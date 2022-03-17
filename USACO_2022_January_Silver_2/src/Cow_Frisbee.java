import java.io.*;
import java.util.*;

public class Cow_Frisbee {
	public static class Cow{
		int index;
		int num;
		
		public Cow(int index, int num) {
			this.index = index;
			this.num = num;
		}
		
		public String toString() {
			return num + " " + index;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		//int[] cows = new int[N];
		List<Cow> cows = new ArrayList<>();
		for (int i = 0; i < N; i ++) {
			int cur = Integer.parseInt(st.nextToken());
			//cows[i] = cur;
			Cow c = new Cow(i + 1, cur);
			cows.add(c);
		}
		long answer = 0;
		for (int i = 1; i <= N; i ++) {
			int cur_cow_index = -1;
			for (int j = 0; j < N; j ++) {
				if (cows.get(j).num == i) {
					cur_cow_index = j;
					break;
				}
			}
			if (cur_cow_index - 1 >= 0)
				answer += Math.abs(cows.get(cur_cow_index).index - cows.get(cur_cow_index - 1).index) + 1;
			if (cur_cow_index + 1 < cows.size())
				answer += Math.abs(cows.get(cur_cow_index).index - cows.get(cur_cow_index + 1).index) + 1;
			cows.remove(cur_cow_index);
		}
		System.out.println(answer);
	}
	public static int binary_search(List<Cow> nums, int val){
		int start = 0;
		int end = nums.size() - 1;
		while (start <= end)
		{
			//System.out.println(start + " " + end + " " + val);
			int middle = (start + end) / 2;
			if (nums.get(middle).num == val)
			{
				return middle;
			}
			else if (nums.get(middle).num > val)
			{
				end = middle - 1;
			}
			else
			{
				start = middle + 1;
			}
		}
		return -1;
	}
}
