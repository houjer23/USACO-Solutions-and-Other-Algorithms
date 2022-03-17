import java.io.*;
import java.util.*;

public class Teleportation {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		int N = Integer.parseInt(br.readLine());
		int[][] teleports = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			teleports[i][0] = Integer.parseInt(st.nextToken());
			teleports[i][1] = Integer.parseInt(st.nextToken());
		}
		TreeMap<Integer, Integer> profits = new TreeMap<>();
		long worst = 0;
		for (int i = 0; i < N; i ++) {
			int a = teleports[i][0];
			int b = teleports[i][1];
			worst += Math.abs(a - b);
			int profit_start_pt;
			int profit_end_pt;
			if (Math.abs(a - b) <= Math.abs(a)) {
				continue;
			} else if ((a <= 0 && b < a) || (a >= 0 && b > a)) {
				profit_start_pt = 2 * a;
				profit_end_pt = 2 * b - 2 * a;
			} else {
				profit_start_pt = 0;
				profit_end_pt = 2 * b;
			}
			if (!profits.containsKey(profit_start_pt)) {
				profits.put(profit_start_pt, 0);
			}
			if (!profits.containsKey(profit_end_pt)) {
				profits.put(profit_end_pt, 0);
			}
			if (!profits.containsKey(b)) {
				profits.put(b, 0);
			}
			profits.put(profit_start_pt, profits.get(profit_start_pt) + 1);
			profits.put(b, profits.get(b) - 2);
			profits.put(profit_end_pt, profits.get(profit_end_pt) + 1);
		}
		long max_profit = Integer.MIN_VALUE;
		long cur_profit = 0;
		long profit_change_rate = 0;
		long prev = profits.firstKey();
		for (int temp : profits.keySet()) {
			cur_profit += (temp - prev) * profit_change_rate;
			profit_change_rate += profits.get(temp);
			if (cur_profit > max_profit) {
				max_profit = cur_profit;
			}
			prev = temp;
		}
		pw.println(worst - max_profit);
		pw.close();
	}
}
