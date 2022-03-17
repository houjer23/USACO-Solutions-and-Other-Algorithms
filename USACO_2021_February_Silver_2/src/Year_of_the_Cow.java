import java.io.*;
import java.util.*;

public class Year_of_the_Cow {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		TreeSet<Integer> travel = new TreeSet<>();
		for (int i = 0; i < N; i ++)
		{
			int num = Integer.parseInt(br.readLine());
			travel.add(num + (12 - num % 12));
		}
		List<Integer> distance = new ArrayList<>();
		int prev = 0;
		for (int cur : travel)
		{
			distance.add(cur - prev);
			prev = cur;
		}
		Collections.sort(distance);
		int answer = 0;
		for (int i = 0; i < distance.size(); i ++)
		{
			if (i < distance.size() - K + 1)
			{
				answer += distance.get(i);
			}
			else
			{
				answer += 12;
			}
		}
		System.out.println(answer);
	}
}
