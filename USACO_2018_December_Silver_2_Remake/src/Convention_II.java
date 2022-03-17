import java.io.*;
import java.util.*;

public class Convention_II {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Cow[] cows = new Cow[N];
		for (int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			Cow cur = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			cows[i] = cur;
		}
		Arrays.sort(cows);
		int cur_time = cows[0].start;
		TreeSet<Cow> waiting = new TreeSet<>();
		int next = 1;
		List<Cow> sequence = new ArrayList<>();
		sequence.add(cows[0]);
		int i = 0;
		while (next < N) {
			//System.out.println(waiting);
			//System.out.println(sequence);
			boolean no_cow = true;
			cur_time += sequence.get(i).time;
			while (next < cows.length && cows[next].start <= cur_time) {
				no_cow = false;
				cows[next].wait = true;
				waiting.add(cows[next]);
				next ++;
			}
			Cow cur_cow = waiting.pollLast();
			if (cur_cow != null) sequence.add(cur_cow);
			if (no_cow && next < cows.length) {
				cur_time = cows[next].start;
				sequence.add(cows[next]);
				next ++;
				i ++;
			}
			i ++;
			//System.out.println(waiting);
			//System.out.println(sequence);
		}
		cur_time = sequence.get(0).start;
		int answer = 0;
		for (i = 0; i < N - 1; i ++) {
			cur_time += sequence.get(i).time;
			if (sequence.get(i + 1).wait && cur_time - sequence.get(i + 1).start > answer) {
				answer = cur_time - sequence.get(i + 1).start;
			} else {
				cur_time = sequence.get(i + 1).start;
			}
		}
		/*
		while (next < N) {
			cur_time += sequence.get(i).time;
			boolean no_cow = true;
			System.out.println(sequence + " " + waiting + " " + cur_time + " " + next);
			while (next < cows.length && cows[next].start <= cur_time) {
				no_cow = false;
				cows[next].wait = true;
				waiting.add(cows[next]);
				next ++;
			}
			Cow cur_cow = waiting.pollLast();
			sequence.add(cur_cow);
			if (cur_cow.wait && cur_time - cur_cow.start > answer) {
				answer = cur_time - cur_cow.start;
			}
			i ++;
			if (no_cow && next < cows.length) {
				i = 0;
				cur_time = cows[next].start;
				sequence = new ArrayList<>();
				sequence.add(cows[next]);
				next ++;
			}
			System.out.println(next);
		}
		*/
		pw.println(answer);
		pw.close();
	}
	public static class Cow implements Comparable<Cow>{
		int start;
		int time;
		boolean wait = false;
		
		public Cow(int start, int time) {
			this.start = start;
			this.time = time;
		}
		
		public int compareTo(Cow c2) {
			return this.start - c2.start;
		}
		
		public String toString() {
			return start + " " + time + " " + wait;
		}
	}
}
