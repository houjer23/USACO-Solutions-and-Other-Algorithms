import java.io.*;
import java.util.*;

public class Snow_Boots {
	public static int num_shoes = Integer.MAX_VALUE;
	public static boolean[][] repeat;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[] tiles = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < tiles.length; i ++) {
			tiles[i] = Integer.parseInt(st.nextToken());
		}
		int[][] shoes = new int[B][2];
		for (int i = 0; i < B; i ++) {
			st = new StringTokenizer(br.readLine());
			shoes[i][0] = Integer.parseInt(st.nextToken());
			shoes[i][1] = Integer.parseInt(st.nextToken());
		}
		repeat = new boolean[N][B];
		dfs(tiles, shoes, N, B, 0, 0);
		pw.println(num_shoes);
		pw.close();
	}
	public static void dfs(int[] tiles, int[][] shoes, int N, int B, int cur_tile, int cur_shoe) {
		if (repeat[cur_tile][cur_shoe]) {
			return;
		}
		repeat[cur_tile][cur_shoe] = true;
		if (shoes[cur_shoe][1] + cur_tile >= N - 1) {
			if (cur_shoe < num_shoes) {
				num_shoes = cur_shoe;
			}
			return;
		}
		for (int i = 1; i <= shoes[cur_shoe][1]; i ++) {
			if (tiles[cur_tile + i] <= shoes[cur_shoe][0]) {
				dfs(tiles, shoes, N, B, cur_tile + i, cur_shoe);
			}
		}
		for (int i = cur_shoe + 1; i < B; i ++) {
			if (tiles[cur_tile] <= shoes[i][0]) {
				dfs(tiles, shoes, N, B, cur_tile, i);
			}
		}
	}
}
