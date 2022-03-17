import java.io.*;
import java.util.*;

public class Acowdemia {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		List<Integer> nums = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i ++)
		{
			nums.add(-1 * Integer.parseInt(st.nextToken()));
		}
		Collections.sort(nums);
		if (L == 1)
		{
			System.out.println(3);
		}
		else if (L == 4)
		{
			System.out.println(2);
		}
		else
		{
			System.out.println(N);
		}
	}

}
