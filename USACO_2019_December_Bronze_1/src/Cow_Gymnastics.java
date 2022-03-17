import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Cow_Gymnastics {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> gym = new ArrayList<>();
		for (int i = 0; i < K; i++)
		{
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> temp = new ArrayList<>();
			for (int j = 0; j < N; j++)
			{
				temp.add(Integer.parseInt(st.nextToken()));
			}
			gym.add(temp);
		}
		
		/*
		for (int i = 0; i < K; i++)
		{
			for (int j = 0; j < N; j++)
			{
				System.out.print(gym.get(i).get(j) + " ");
				if (j == K)
				{
					System.out.println();
				}
			}
		}
		*/

		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
		pw.print(consistent_pairs(K, N, gym));
		pw.close();
	}
	static int consistent_pairs(int K, int N, ArrayList<ArrayList<Integer>> gym){
		ArrayList<Integer> num = new ArrayList<>();
		int start = 0;
		int pairs = 0;
		int determine = 0;
		gym.get(0).get(1); // 0, 1
		for (int i = 1; i <= N; i ++)
		{
			for (int j = 0; j < K; j ++)
			{
				for (int x = 0; x < N; x ++)
				{
					if (gym.get(j).get(x) == i)
					{
						start = x;
						break;
					}
				}
				if (j == 0)
				{
					for (int y = start + 1; y < N; y++)
					{
						num.add(gym.get(j).get(y));
					}
				}
				else
				{
					for (int x = 0; x < num.size(); x++)
					{
						for (int y = start + 1; y < N; y ++)
						{
							if (num.get(x) == gym.get(j).get(y))
							{
								determine = 1;
								break;
							}
						}
						if (determine == 0)
						{
							num.remove(x);
							x -= 1;
						}
						else
						{
							determine = 0;
						}
					}
				}
			}
			pairs += num.size();
			num.removeAll(num);
		}
		return pairs;
	}
}
