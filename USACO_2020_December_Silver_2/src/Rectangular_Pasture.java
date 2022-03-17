import java.io.*;
import java.util.*;

public class Rectangular_Pasture {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Position[] pos = new Position[N];
		for (int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			Position cur = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			pos[i] = cur;
		}
		Arrays.sort(pos, new Comparator<Position>() {
			public int compare(Position p1, Position p2) {
				return p1.x - p2.x;
			}
		});
		int[][] position_at_circumstance = new int[N][N];
		for (int i = N - 1; i >= 0; i --) {
			int cur_y = pos[i].y;
			int cur_y_pos = 0;
			for (int j = i - 1; j >= 0; j --) {
				if (pos[j].y < cur_y) {
					cur_y_pos ++;
				}
				position_at_circumstance[j][i] = cur_y_pos;
			}
		}
		/*for (int i = 0; i < N; i ++) {
			for (int j = 0; j < N; j ++) {
				System.out.print(position_at_circumstance[i][j] + " ");
			}
			System.out.println();
		}*/
		long answer = 0;
		for (int i = 0; i < N; i ++) {
			answer ++;
			int tot = 1;
			int front_y_pos = 0;
			for (int j = i + 1; j < N; j ++) {
				tot ++;
				int add_pos = position_at_circumstance[i][j];
				if (add_pos <= front_y_pos) {
					front_y_pos ++;
				}
				if (add_pos < front_y_pos) {
					answer += (tot - front_y_pos) * (add_pos + 1);
				} else {
					answer += (tot - add_pos) * (front_y_pos + 1);
				}
			}
		}
		System.out.println(answer + 1);
	}
	public static class Position{
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return x + " " + y + ",";
		}
	}
	public static int binary_search_last_greater_or_equal_nums(List<Integer> nums, int val){
		int start = 0;
		int end = nums.size() - 1;
		while (start < end) // ???
		{
			int middle = (start + end) / 2; // ???
			if (nums.get(middle) >= val)
			{
				end = middle; // ???
			}
			else
			{
				start = middle + 1; // ???
			}
		}
		if (nums.get(start) >= val)
		{
			return start;
		}
		else
		{
			return nums.size();
		}
	}
}
