import java.io.*;
import java.util.*;

public class Cow_Tipping {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
		int N = Integer.parseInt(br.readLine());
		String[] field = new String[N];
		for (int i = 0; i < N; i ++)
		{
			field[i] = br.readLine();
		}
		int times = 0;
		for (int i = N - 1; i >= 0; i --)
		{
			for (int j = N - 1; j >= 0; j --)
			{
				if (field[i].charAt(j) == '1')
				{
					field = flip(field, i, j);
					times += 1;
					/*System.out.println(i + " " + j);
					for (int k = 0; k < N; k ++)
					{
						System.out.println(field[k]);
					}
					System.out.println();*/
					
				}
				if (field[j].charAt(i) == '1')
				{
					field = flip(field, j, i);
					times += 1;
					/*System.out.println(j + " " + i);
					for (int k = 0; k < N; k ++)
					{
						System.out.println(field[k]);
					}
					System.out.println();*/
				}
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
		pw.println(times);
		pw.close();
	}
	
	public static String[] flip(String[] field, int row, int col) {
		for (int i = 0; i <= row; i ++)
		{
			String cur = "";
			for (int j = 0; j <= col; j ++)
			{
				if (field[i].charAt(j) == '1')
				{
					cur = cur + "0";
				}
				else
				{
					cur = cur + "1";
				}
			}
			//System.out.println(cur);
			cur = cur + field[i].substring(col + 1);
			field[i] = cur;
		}
		return field;
	}
}

