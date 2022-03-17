import java.io.*;
import java.util.*;

public class Redistributing_Gifts {
	public static int[][] preference;
	public static boolean[] in_position;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		preference = new int[N][N];
		for (int i = 0; i < N; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j ++) {
				preference[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		in_position = new boolean[N];
		for (int i = 0; i < N; i ++) {
			Arrays.fill(in_position, false);
			in_position[i] = true;
			System.out.println(find(i, i));
		}
	}
	public static int find(int s, int x) {
		int answer = 0;
		for (int i = 0; i < preference.length; i ++) {
			if (preference[x][i] - 1 == s) {
				return preference[x][i];
			}
			if (preference[x][i] - 1 == x) {
				break;
			}
			if (in_position[preference[x][i] - 1]) {
				continue;
			}
			in_position[preference[x][i] - 1] = true;
			if (find(s, preference[x][i] - 1) > 0) {
				return preference[x][i];
			}
		}
		return answer;
	}
}
