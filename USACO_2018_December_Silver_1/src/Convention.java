import java.io.*;
import java.util.*;

public class Convention {
	public static int N;
	public static int M;
	public static int C;
	public static int[] arrival;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("convention.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arrival = new int[N];
		for (int i = 0; i < N; i ++) {
			arrival[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrival);
		pw.println(binary_serch(0, arrival[arrival.length - 1]));
		pw.close();
	}
	public static int binary_serch(int start, int end) {
		if (start == end) {
			return start;
		}
		int middle = (start + end) / 2;
		if (check(middle)) {
			return binary_serch(start, middle);
		} else {
			return binary_serch(middle + 1, end);
		}
	}
	public static boolean check(int wait_time) {
		int buses = 1;
		int first = arrival[0];
		int first_index = 0;
		for (int i = 1; i < N; i ++)
		{
			if (arrival[i] - first > wait_time || i + 1 - first_index > C)
			{
				buses += 1;
				first = arrival[i];
				first_index = i;
			}
		}
		return (buses <= M);
	}
}
