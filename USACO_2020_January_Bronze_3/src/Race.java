import java.io.*;
import java.util.*;

public class Race {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("race.in"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());;
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] X = new int[N];
		
		for (int i = 0; i < N; i++)
		{
			X[i] = Integer.parseInt(br.readLine());
		}
		
		/*
		System.out.println(K + " " + N);
		for (int i = 0; i < N; i ++)
		{
			System.out.println(X[i]);
		}
		*/
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));
		X = race(K, N, X);
		for (int i = 0; i < N; i ++)
		{
			pw.println(X[i]);
		}
		pw.close();
	}
	static int[] race(int K, int N, int[] X){
		int num = 0;
		int sum = 0;
		ArrayList<Integer> total_result = new ArrayList<>();
		while (K > sum)
		{
			num ++;
			sum = sum + num;
		}
		// System.out.println(num + " " + sum);
		total_result.add(num);
		int last = num;
		for (int i = num - 1; i > 0; i --)
		{
			while (true)
			{
				int x;
				if (i == last)
					x = ((1 + last) * last / 2);
				else
					if (i == last - 1)
						x = ((1 + last) * last / 2) + last - 1;
					else
						x = ((1 + last) * last / 2) + ((i + last - 1) * (last - i) / 2);
				if (x > K)
				{
					last --;
					//System.out.println(i + " " + last);
				}
				else
				{
					if (i == last)
					{
						double check = (double) (K - x) / last;
						if ((check - (int) check) != 0)
							total_result.add(0, last + ((K - x) / last) + 1);
						else
							total_result.add(0, last + ((K - x) / last));
					}
					else
					{
						double check = (double) (K - x) / last;
						if ((check - (int) check) != 0)
							total_result.add(0, last + (last - i) + ((K - x) / last) + 1);
						else
							total_result.add(0, last + (last - i) + ((K - x) / last));
					}
					//System.out.println(i + " " + last + " " + x + " " + last + (last - i) + ((K - x) / last));
					//System.out.println(i + " " + x + " " + (K - x) / last + " " + last);
					break;
				}
			}
		}
		int[] result = new int[N];
		//System.out.println(total_result);
		for (int i = 0; i < N; i ++)
		{
			if (X[i] >= num)
			{
				result[i] = num;
			}
			else
			{
				result[i] = total_result.get(X[i] - 1);
			}
		}
		return result;
	}
}
