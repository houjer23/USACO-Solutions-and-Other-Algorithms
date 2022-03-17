import java.io.*;
import java.util.*;

public class Bovine_Genomics {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] spotty = new String[N];
		String[] plain = new String[N];
		for (int i = 0; i < N; i ++)
		{
			spotty[i] = br.readLine();
		}
		for (int i = 0; i < N; i ++)
		{
			plain[i] = br.readLine();
		}
		int answer = 0;
		for (int i = 0; i < M - 2; i ++)
		{
			for (int j = i + 1; j < M - 1; j ++)
			{
				for (int k = j + 1; k < M; k ++)
				{
					Set<String> spotty_set = new HashSet<>();
					Set<String> plain_set = new HashSet<>();
					for (int l = 0; l < N; l ++)
					{
						String new_spotty = Character.toString(spotty[l].charAt(i)) + Character.toString(spotty[l].charAt(j)) + Character.toString(spotty[l].charAt(k));
						String new_plain = Character.toString(plain[l].charAt(i)) + Character.toString(plain[l].charAt(j)) + Character.toString(plain[l].charAt(k));
						spotty_set.add(new_spotty);
						plain_set.add(new_plain);
					}
					int flag = 0;
					for (String temp : spotty_set)
					{
						if (plain_set.contains(temp))
						{
							flag = 1;
							break;
						}
					}
					if (flag == 0)
					{
						answer ++;
					}
				}
			}
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
		pw.println(answer);
		pw.close();
	}

}
