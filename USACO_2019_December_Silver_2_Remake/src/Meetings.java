import java.io.*;
import java.util.*;

public class Meetings {
	public static class Cow implements Comparable<Cow>{
		int posi;
		int weight;
		int direction;
		
		public Cow(int posi, int weight, int direction) {
			this.posi = posi;
			this.weight = weight;
			this.direction = direction;
		}
		
		public int compareTo(Cow c2) {
			return this.posi - c2.posi;
		}
		
		public String toString() {
			return posi + " " + weight + " " + direction;
		}
	}
	public static class Time implements Comparable<Time>{
		int time_cost;
		int weight;
		
		public Time(int time_cost, int weight) {
			this.time_cost = time_cost;
			this.weight = weight;
		}
		
		public int compareTo(Time t2) {
			return this.time_cost - t2.time_cost;
		}
		
		public String toString() {
			return time_cost + " " + weight;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("meetings.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		List<Cow> move_left = new ArrayList<>();
		List<Cow> move_right = new ArrayList<>();
		List<Cow> total = new ArrayList<>();
		int weight_sum = 0;
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int cur_weight = Integer.parseInt(st.nextToken());
			int cur_posi = Integer.parseInt(st.nextToken());
			int cur_direction = Integer.parseInt(st.nextToken());
			weight_sum += cur_weight;
			Cow cur = new Cow(cur_posi, cur_weight, cur_direction);
			total.add(cur);
			if (cur_direction == 1)
			{
				move_right.add(cur);
			}
			else
			{
				move_left.add(cur);
			}
		}
		Collections.sort(total);
		Collections.sort(move_left);
		Collections.sort(move_right);
		int[][] out = new int[N][2];
		int to_right = 0;
		for (int i = 0; i < N; i ++)
		{
			if (total.get(i).direction == 1)
			{
				to_right ++;
			}
			out[i][0] = to_right;
		}
		int to_left = 0;
		for (int i = N - 1; i >= 0; i --)
		{
			if (total.get(i).direction == -1)
			{
				to_left ++;
			}
			out[i][1] = to_left;
		}
		
		Map<Integer, Cow> move_left_map = new HashMap<>();
		Map<Integer, Cow> move_right_map = new HashMap<>();
		for (int i = 0; i < move_right.size(); i ++)
		{
			move_right_map.put(i, move_right.get(i));
		}
		for (int i = move_left.size() - 1; i >= 0; i --)
		{
			move_left_map.put(move_left.size() - i - 1, move_left.get(i));
		}
		
		Time[] times = new Time[N];
		for (int i = 0; i < N; i ++)
		{
			if (total.get(i).direction == -1)
			{
				if (out[i][0] == out[i][1])
				{
					times[i] = new Time(L - move_right_map.get(0).posi, total.get(i).weight);
				}
				else if (out[i][0] < out[i][1])
				{
					times[i] = new Time(move_left_map.get(out[i][1] - out[i][0] - 1).posi, total.get(i).weight);
				}
				else
				{
					times[i] = new Time(L - move_right_map.get(out[i][0] - out[i][1]).posi, total.get(i).weight);
				}
			}
			else
			{
				if (out[i][0] == out[i][1])
				{
					times[i] = new Time(move_left_map.get(0).posi, total.get(i).weight);
				}
				else if (out[i][0] < out[i][1])
				{
					times[i] = new Time(move_left_map.get(out[i][1] - out[i][0]).posi, total.get(i).weight);
				}
				else
				{
					times[i] = new Time(L - move_right_map.get(out[i][0] - out[i][1] - 1).posi, total.get(i).weight);
				}
			}
		}
		Arrays.sort(times);
		int final_time = -1;
		int cur_weight = 0;
		for (int i = 0; i < times.length; i ++)
		{
			cur_weight += times[i].weight;
			if (cur_weight * 2 >= weight_sum)
			{
				final_time = times[i].time_cost;
				break;
			}
		}
		
		int i = 0;
		int j = 0;
		int num_to_right = 0;
		int answer = 0;
		boolean move_j = true;
		while (total.get(i).direction == -1)
		{
			i ++;
		}
		j = i;
		while (j < N)
		{
			if (move_j)
			{
				while (j < N && total.get(j).posi - total.get(i).posi <= final_time * 2)
				{
					if (total.get(j).direction == 1)
					{
						num_to_right ++;
					}
					else
					{
						answer += num_to_right;
					}
					j ++;
				}
				move_j = false;
			}
			else
			{
				while (total.get(j).posi - total.get(i).posi > final_time * 2)
				{
					if (total.get(i).direction == 1)
					{
						num_to_right --;
					}
					i ++;
				}
				move_j = true;
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
		pw.println(answer);
		pw.close();
	}

}
