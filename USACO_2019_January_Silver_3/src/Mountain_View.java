import java.io.*;
import java.util.*;

public class Mountain_View {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
		int N = Integer.parseInt(br.readLine());
		List<Mountain> mountains = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			Mountain m = new Mountain(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			mountains.add(m);
		}
		Collections.sort(mountains);
		//System.out.println(mountains);
		int i = 0;
		while (i < mountains.size()) {
			int j = i + 1;
			while (j < mountains.size() && mountains.get(j).start < mountains.get(i).end) {
				if (mountains.get(j).end <= mountains.get(i).end) {
					mountains.remove(j);
					j --;
				}
				j ++;
			}
			i ++;
		}
		//System.out.println(mountains);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
		pw.println(mountains.size());
		pw.close();
	}
	public static class Mountain implements Comparable<Mountain>{
		int vertex_x;
		int vertex_y;
		int start;
		int end;
		
		public Mountain(int vertex_x, int vertex_y) {
			this.vertex_x = vertex_x;
			this.vertex_y = vertex_y;
			this.start = vertex_x - vertex_y;
			this.end = vertex_y + vertex_x;
		}
		
		public int compareTo(Mountain m2) {
			return this.start - m2.start;
		}
		
		public String toString() {
			return start + " " + end;
		}
	}
}
