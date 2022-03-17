import java.io.*;
import java.util.*;

public class Rest_Stops {
	public static class Grass implements Comparable<Grass>{
		int position;
		int value;
		
		public Grass(int position, int value) {
			this.position = position;
			this.value = value;
		}
		
		public int compareTo(Grass g2) {
			return g2.value - this.value;
		}
		
		public String toString() {
			return position + " " + value;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int F_speed = Integer.parseInt(st.nextToken());
		int N_speed = Integer.parseInt(st.nextToken());
		int speed_diff = F_speed - N_speed;
		Grass[] grasses = new Grass[N];
		for (int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			grasses[i] = new Grass(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(grasses);
		long grass_collected = 0;
		int cur_position = 0;
		int prev_position = 0;
		for (int i = 0; i < N; i ++) {
			if (grasses[i].position <= cur_position) {
				continue;
			}
			prev_position = cur_position;
			cur_position = grasses[i].position;
			grass_collected += (long) (cur_position - prev_position) * (long) speed_diff * (long) grasses[i].value;
		}
		pw.println(grass_collected);
		pw.close();
	}
}
