import java.io.*;
import java.util.*;

public class Stuck_in_a_Rut {
	public static class Cow {
		int x;
		int y;
		int stop = 0;
		int index;
		boolean hit = false;
		
		public Cow(int x, int y, int index) {
			this.x = x;
			this.y = y;
			this.index = index;
		}
		
		public String toString() {
			return x + " " + y + " " + stop;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Cow> move_up = new ArrayList<>();
		List<Cow> move_right = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String move_position = st.nextToken();
			Cow new_cow = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
			if (move_position.equals("E")) {
				move_right.add(new_cow);
			} else {
				move_up.add(new_cow);
			}
		}
		Collections.sort(move_up, new Comparator<Cow>() {
			public int compare(Cow c1, Cow c2) {
				return c1.x - c2.x;
			}
		});
		Collections.sort(move_right, new Comparator<Cow>() {
			public int compare(Cow c1, Cow c2) {
				return c1.y - c2.y;
			}
		});
		for (int i = 0; i < move_up.size(); i ++) {
			for (int j = 0; j < move_right.size(); j ++) {
				Cow cur_up = move_up.get(i);
				Cow cur_right = move_right.get(j);
				if (cur_right.hit == true) {
					continue;
				}
				if (cur_right.y >= cur_up.y && cur_right.x <= cur_up.x) {
					if (cur_up.x - cur_right.x > cur_right.y - cur_up.y) {
						cur_right.hit = true;
						cur_up.stop += cur_right.stop + 1;
					} else if (cur_up.x - cur_right.x < cur_right.y - cur_up.y) {
						cur_up.hit = true;
						cur_right.stop += cur_up.stop + 1;
						break;
					}
				}
			}
		}
		int[] answer = new int[N];
		for (int i = 0; i < move_up.size(); i ++) {
			answer[move_up.get(i).index] = move_up.get(i).stop;
		}
		for (int i = 0; i < move_right.size(); i ++) {
			answer[move_right.get(i).index] = move_right.get(i).stop;
		}
		for (int i = 0; i < N; i ++) {
			System.out.println(answer[i]);
		}
	}
}
