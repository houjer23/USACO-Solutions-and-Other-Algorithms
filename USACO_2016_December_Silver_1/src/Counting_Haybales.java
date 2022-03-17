import java.io.*;
import java.util.*;

public class Counting_Haybales {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[] position = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i ++)
		{
			position[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] num = new int[Q][2];
		for (int i = 0; i < Q; i ++)
		{
			st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}
		
		/*
		System.out.println(N + " " + Q);
		for (int i = 0; i < N; i ++)
		{
			System.out.print(position[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < Q; i ++)
		{
			System.out.println(num[i][0] + " " + num[i][1]);
		}
		*/
		
		position = find_result(N, Q, position, num);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		for (int i = 0; i < Q; i ++)
		{
			pw.println(position[i]);
		}
		pw.close();
	}
	static int[] find_result(int N, int Q, int[] position, int[][] num){
		int[] result = new int[Q];
		Arrays.sort(position);
		for (int i = 0; i < Q; i ++)
		{
			int start = 0;
			int end = N - 1;
			while (start < end)
			{
				int middle = (start + end) / 2;
				if (position[middle] >= num[i][0])
				{
					end = middle;
				}
				else
				{
					start = middle + 1;
				}
			}
			
			int start2 = 0;
			end = N - 1;
			while (start2 < end)
			{
				int middle = (start2 + end + 1) / 2;
				if (position[middle] > num[i][1])
				{
					end = middle - 1;
				}
				else
				{
					start2 = middle;
				}
			}
			if (num[i][0] > position[N - 1])
			{
				result[i] = 0;
			}
			else
			{
				result[i] = start2 - start + 1;
			}
			//System.out.println(result[i]);
		}
		return result;
	}
}
