import java.io.*;
import java.util.*;

public class Swapity_Swap {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("swap.in"));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] swap = new int[2][2];
		st = new StringTokenizer(br.readLine());
		swap[0][0] = Integer.parseInt(st.nextToken());
		swap[0][1] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		swap[1][0] = Integer.parseInt(st.nextToken());
		swap[1][1] = Integer.parseInt(st.nextToken());
		
		/*
		System.out.println(N + " " + K);
		for (int i = 0; i < 2; i ++)
		{
			System.out.println(swap[i][0] + " " + swap[i][1]);
		}
		*/
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
		
		int[] cow = new int[N];
		cow = exchange(N, K, swap);
		for (int i = 0; i < N; i ++)
		{
			pw.println(cow[i]);
		}
		pw.close();
	}
	static int[] exchange(int N, int K, int[][] swap){
		int[] cow = new int[N];
		for (int i = 0; i < N; i ++)
		{
			Map<Integer, Integer> position_map = new HashMap<>();
			ArrayList<Integer> position = new ArrayList<>();
			position_map.put(i, 0);
			position.add(i);
			if ((i < swap[0][0] - 1 && i < swap[1][0] - 1) || (i > swap[0][1] - 1 && i > swap[1][1] - 1))
			{
				cow[i] = i + 1;
			}
			else
			{
				int num = 0;
				int last_posi = i;
				while (true)
				{
					if (num == K)
					{
						cow[last_posi] = i + 1;
						break;
					}
					int first_posi;
					int final_posi = 0;
					if (last_posi >= swap[0][0] - 1 && last_posi <= swap[0][1] - 1)
						first_posi = (swap[0][0] - 1 + swap[0][1] - (last_posi + 1));
					else
						first_posi = last_posi;
					if (first_posi >= swap[1][0] - 1 && first_posi <= swap[1][1] - 1)
						final_posi = swap[1][0] - 1 + swap[1][1] - first_posi - 1;
					else
						final_posi = first_posi;
					if (position_map.containsKey(final_posi))
					{
						int start = position_map.get(final_posi);
						//cow[position.get(K % (num + 1 - start))] = i + 1;
						cow[position.get((K - start) % (num + 1 - start) + start)] = i + 1;
						break;
					}
					position_map.put(final_posi, num + 1);
					position.add(final_posi);
					last_posi = final_posi;
					num ++;
				}
			}
		}
		return cow;
	}
}
