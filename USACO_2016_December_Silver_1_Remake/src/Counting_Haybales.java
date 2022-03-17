import java.io.*;
import java.util.*;

public class Counting_Haybales {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i ++)
		{
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		for (int i = 0; i < Q; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int num1 = binary_search_num_1(nums, Integer.parseInt(st.nextToken()));
			int num2 = binary_search_num_2(nums, Integer.parseInt(st.nextToken()));
			if (num1 == -1 || num2 == -1)
			{
				pw.println(0);
			}
			else
			{
				pw.println(num2 - num1 + 1);
			}
		}
		pw.close();
	}
	public static int binary_search_num_1(int[] nums, int val){
		int start = 0;
		int end = nums.length - 1;
		while (start < end)
		{
			int middle = (start + end) / 2;
			if (nums[middle] >= val)
			{
				end = middle;
			}
			else
			{
				start = middle + 1;
			}
		}
		if (nums[start] >= val)
		{
			return start;
		}
		else
		{
			return -1;
		}
	}
	public static int binary_search_num_2(int[] nums, int val){
		int start = 0;
		int end = nums.length - 1;
		while (start < end)
		{
			int middle = (start + end + 1) / 2;
			if (nums[middle] > val)
			{
				end = middle - 1;
			}
			else
			{
				start = middle;
			}
		}
		if (nums[start] <= val)
		{
			return start;
		}
		else
		{
			return -1;
		}
	}
}
