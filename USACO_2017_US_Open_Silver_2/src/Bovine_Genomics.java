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
			//System.out.println(spotty[i]);
		}
		for (int i = 0; i < N; i ++)
		{
			plain[i] = br.readLine();
			//System.out.println(plain[i]);
		}
		int result = 0;
		for (int i = 0; i < M - 2; i ++)
		{
			for (int j = i + 1; j < M - 1; j ++)
			{
				for (int k = j + 1; k < M; k ++)
				{
					//System.out.println(spotty[0].charAt(i) + " " + spotty[0].charAt(j) + " " + spotty[0].charAt(k));
					Set<String> spotty_set = new HashSet<>();
					Set<String> plain_set = new HashSet<>();
					for (int l = 0; l < N; l ++)
					{
						char[] cur = new char[3];
						cur[0] = spotty[l].charAt(i);
						cur[1] = spotty[l].charAt(j);
						cur[2] = spotty[l].charAt(k);
						spotty_set.add(String.valueOf(cur));
						cur = new char[3];
						cur[0] = plain[l].charAt(i);
						cur[1] = plain[l].charAt(j);
						cur[2] = plain[l].charAt(k);
						plain_set.add(String.valueOf(cur));
					}
					//System.out.println(spotty_set + " " + i + " " + j + " " + k);
					int flag = 0;
					for (String element : spotty_set){
						if (plain_set.contains(element))
						{
							//System.out.println(element);
							flag = 1;
							break;
						}
					}
					if (flag == 0)
					{
						result ++;
					}
				}
			}
		}
		
		
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
		pw.println(result);
		pw.close();
	}
}
