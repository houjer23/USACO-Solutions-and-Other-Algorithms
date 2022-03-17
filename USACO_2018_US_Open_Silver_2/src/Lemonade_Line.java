import java.io.*;
import java.util.*;

public class Lemonade_Line {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		int N = Integer.parseInt(br.readLine());
		int[] cows = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i ++) {
			cows[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cows);
		List<Integer> line = new ArrayList<>();
		for (int i = N - 1; i >= 0; i --) {
			if (line.size() <= cows[i]) {
				line.add(cows[i]);
			}
		}
		pw.println(line.size());
		pw.close();
	}
}
