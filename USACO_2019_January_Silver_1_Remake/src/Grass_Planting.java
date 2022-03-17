import java.io.*;
import java.util.*;

public class Grass_Planting {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("planting.in"));
		int N = Integer.parseInt(br.readLine());
		int[] farm = new int[N];
		int max = 0;
		StringTokenizer st;
		for (int i = 0; i < N - 1; i ++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			farm[num1 - 1] += 1;
			farm[num2 - 1] += 1;
			max = Math.max(max, farm[num1 - 1]);
			max = Math.max(max, farm[num2 - 1]);
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
		pw.println(max + 1);
		pw.close();
	}
}
