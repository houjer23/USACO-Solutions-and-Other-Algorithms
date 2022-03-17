import java.io.*;
import java.util.*;

public class Searching_for_Soulmates {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] cows = new int[N][2];
		for (int i = 0; i < N; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cows[i][0] = Integer.parseInt(st.nextToken());
			cows[i][1] = Integer.parseInt(st.nextToken());
			//System.out.println(cows[i][0] + " " + cows[i][1]);
		}
		for (int i = 0; i < N; i ++) {
			//System.out.println("IN");
			System.out.println(find_answer(cows[i][0], cows[i][1]));
		}
	}
	public static int find_answer(int first, int second) {
		//System.out.println("In");
		if (first == second) {
			return 0;
		}
		int min_step = Integer.MAX_VALUE;
		int steps = 0;
		while (first != second) {
			//System.out.println(first + " " + second);
			while (first > second) {
				//System.out.println(first + " " + second);
				if (first % 2 == 1) {
					first ++;
					steps ++;
				}
				first /= 2;
				steps ++;
			}
			
			if (min_step > steps + (second - first)) {
				min_step = steps + (second - first);
			}
			//System.out.println(first + " " + second + " " + steps + " " + min_step);
			//System.out.println(first + " " + second);
			while (second > first) {
				if (min_step > steps + (second - first)) {
					min_step = steps + (second - first);
				}
				if (second % 2 == 1) {
					second --;
					steps ++;
				}
				second /= 2;
				steps ++;
			}
		}
		return min_step;
	}
}
