import java.io.*;
import java.util.*;

public class Sleepy_Cow_Herding {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("herding.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i ++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);
		/*
		for (int i = 0; i < nums.length; i ++) {
			System.out.println(nums[i]);
		}*/
		int min_move = Integer.MAX_VALUE;
		int max_move = 0;
		int i = 0;
		int j = 1;
		while (i < N) {
			while (j < N - 1 && nums[j] - nums[i] + 1 < N) {
				j ++;
			}
			if (nums[j] - nums[i] + 1 < N) {
				break;
			}
			int cur_move;
			if (nums[j] - nums[i] + 1 == N) {
				cur_move = N - (j - i + 1);
			} else {
				cur_move = N - (j - i);
			}
			if (min_move > cur_move) {
				min_move = cur_move;
			}
			if (max_move < cur_move) {
				max_move = cur_move;
			}
			i ++;
		}
		pw.println(min_move);
		pw.println(max_move);
		pw.close();
	}
}
