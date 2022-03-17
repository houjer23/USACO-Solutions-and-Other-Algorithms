import java.io.*;
import java.util.*;

public class Year_of_the_Cow {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dates = new int[N];
		for (int i = 0; i < N; i ++) {
			dates[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(dates);
		List<List<Integer>> travel = new ArrayList<>();
		for (int i = 0; i < N; i ++) {
			int start = dates[i] / 12 * 12;
			int end = (dates[i] / 12 + 1) * 12;
			if (i == 0 || travel.get(travel.size() - 1).get(0) != start) {
				List<Integer> new_travel = new ArrayList<>();
				new_travel.add(start);
				new_travel.add(end);
				travel.add(new_travel);
			}
		}
		List<Integer> difference = new ArrayList<>();
		difference.add(travel.get(0).get(0));
		for (int i = 0; i < travel.size() - 1; i ++) {
			difference.add(travel.get(i + 1).get(0) - travel.get(i).get(1));
		}
		Collections.sort(difference);
		int answer = travel.size() * 12;
		for (int i = 0; i < difference.size() - K + 1; i ++) {
			answer += difference.get(i);
		}
		//System.out.println(difference);
		System.out.println(answer);
	}
}
