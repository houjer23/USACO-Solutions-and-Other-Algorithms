import java.io.*;
import java.util.*;

public class Meetings {
	public static class Cow implements Comparable<Cow>{
		double posi;
		int weight;
		
		public Cow(double posi, int weight) {
			this.posi = posi;
			this.weight = weight;
		}
		
		public int compareTo(Cow c2) {
			return Double.compare(this.posi, c2.posi);
		}
		
		public String toString() {
			return posi + " " + weight;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("meetings.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		List<Cow> left = new ArrayList<>();
		List<Cow> right = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int cur_weight = Integer.parseInt(st.nextToken());
			int cur_posi = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			sum += cur_weight;
			Cow cur = new Cow(cur_posi, cur_weight);
			if (direction == 1)
			{
				right.add(cur);
			}
			else
			{
				left.add(cur);
			}
		}
		sum /= 2;
		Collections.sort(left);
		Collections.sort(right);
		//System.out.println(left);
		//System.out.println(right);
		int reached = 0;
		int answer = 0;
		if (left.size() != 0 && right.size() != 0)
		{
			while (reached < sum)
			{
				double min_distance = Integer.MAX_VALUE;
				int[] cur = new int[2];
				int cur_right = 0;
				int cur_left = 0;
				while (cur_right < right.size() && cur_left < left.size())
				{
					if (right.get(cur_right).posi >= left.get(cur_left).posi)
					{
						cur_left ++;
					}
					else
					{
						double cur_distance = ((double) left.get(cur_left).posi - right.get(cur_right).posi) / 2;
						if (cur_distance < min_distance)
						{
							min_distance = cur_distance;
						}
						cur_right ++;
					}
				}
				if (min_distance == Integer.MAX_VALUE)
				{
					break;
				}
				min_distance = Math.min(min_distance, Math.min(left.get(0).posi, 5 - right.get(right.size() - 1).posi));
				Map<Double, Integer> check = new HashMap<>();
				for (int i = 0; i < right.size(); i ++)
				{
					right.set(i, new Cow(right.get(i).posi + min_distance, right.get(i).weight));
					check.put(right.get(i).posi, i);
					if (right.get(i).posi >= L)
					{
						reached += right.get(i).weight;
						right.remove(i);
					}
				}
				//System.out.println(check);
				int cur_meet = 0;
				List<Cow> left_add = new ArrayList<>();
				for (int i = 0; i < left.size(); i ++)
				{
					if (check.containsKey(left.get(i).posi - min_distance))
					{
						int right_meet = check.get(left.get(i).posi - min_distance);
						right.add(new Cow(left.get(i).posi - min_distance, left.get(i).weight));
						left_add.add(right.get(right_meet));
						right.remove(right_meet - cur_meet);
						left.remove(i);
						i --;
						cur_meet ++;
						
					}
					else if (left.get(i).posi <= 0)
					{
						reached += right.get(i).weight;
						left.remove(i);
					}
					else
					{
						left.set(i, new Cow(left.get(i).posi - min_distance, left.get(i).weight));
					}
				}
				//System.out.println(left_add);
				for (int i = 0; i < left_add.size(); i ++)
				{
					left.add(left_add.get(i));
				}
				Collections.sort(left);
				Collections.sort(right);
				//System.out.println("Left: " + left + "  Right:" + right);
				answer += cur_meet;
				//System.out.println(left + " " + right + " " + cur_meet);
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
		pw.println(answer);
		pw.close();
	}
}