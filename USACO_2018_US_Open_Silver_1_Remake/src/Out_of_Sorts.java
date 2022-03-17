import java.io.*;
import java.util.*;

public class Out_of_Sorts {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("sort.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
		int N = Integer.parseInt(br.readLine());
		int[] not_sorted = new int[N];
		int[] sorted = new int[N];
		for (int i = 0; i < N; i ++) {
			int cur = Integer.parseInt(br.readLine());
			not_sorted[i] = cur;
			sorted[i] = cur;
		}
		Arrays.sort(sorted);
		int answer = 0;
		for (int i = 0; i < N; i ++) {
			int start = 0;
			int end = sorted.length - 1;
			int sorted_index = 0;
			while (start <= end)
			{
				int middle = (start + end) / 2;
				if (sorted[middle] == not_sorted[i])
				{
					sorted_index = middle;
					break;
				}
				else if (sorted[middle] > not_sorted[i])
				{
					end = middle - 1;
				}
				else
				{
					start = middle + 1;
				}
			}
			if (i - sorted_index + 1 > answer) {
				answer = i - sorted_index + 1;
			}
		}
		pw.println(answer);
		pw.close();
	}
}
