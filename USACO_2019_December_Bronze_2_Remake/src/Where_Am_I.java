import java.io.*;
import java.util.*;

public class Where_Am_I {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
		int N = Integer.parseInt(br.readLine());		
		String farms = br.readLine();
		
		int answer = 0;
		for (int i = 0; i < N; i ++)
		{
			int flag = 1;
			for (int j = 0; j < N - i - 1; j ++)
			{
				for (int k = j + 1; k < N - i; k ++)
				{
					//System.out.println(farms.substring(j, j + i + 1) + " " + farms.substring(k, k + i + 1) + " " + farms.substring(j, j + i + 1).equals(farms.substring(k, k + i + 1)));
					if (farms.substring(j, j + i + 1).equals(farms.substring(k, k + i + 1)))
					{
						flag = 0;
						break;
					}
				}
				if (flag == 0)
				{
					break;
				}
			}
			if (flag == 1)
			{
				answer = i + 1;
				break;
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
		pw.println(answer);
		pw.close();
	}
}
