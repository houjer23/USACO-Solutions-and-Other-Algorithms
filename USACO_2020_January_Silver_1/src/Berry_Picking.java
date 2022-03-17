import java.io.*;
import java.util.*;

public class Berry_Picking {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("berries.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] berries = new int[N];
		int max = 0;
		for (int i = 0; i < N; i ++) {
			berries[i] = Integer.parseInt(st.nextToken());
			if (berries[i] > max) {
				max = berries[i];
			}
		}
		int answer = 0;
		for (int i = 1; i <= max; i ++) {
			answer = Math.max(answer, check(berries, i, K / 2));
		}
		pw.println(answer);
		pw.close();
	}
	public static int check(int[] items, int limit, int baskets) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(10, Collections.reverseOrder());
		for (int x : items) {
			pq.offer(x);
		}
		for (int i = 0; i < baskets; i++) {
			if (pq.size() == 0) {
				return -1;
			}
			int next = pq.poll();
			if (next < limit) {
				return -1;
			}
			if (next > limit) {
				pq.offer(next - limit);
			}
		}
		int bessie = 0;
		int current_basket = 0;
		while (pq.size() > 0 && current_basket < baskets) {
			int next = pq.poll();
			current_basket++;
			if (next > limit) {
				bessie += limit;
				pq.offer(next-limit);
			} else {
				bessie += next;
			}
		}
		return bessie;
	}
}
