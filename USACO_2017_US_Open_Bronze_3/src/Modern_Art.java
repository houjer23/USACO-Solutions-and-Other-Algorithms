import java.io.*;
import java.util.*;

public class Modern_Art {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("art.in"));
		int size = Integer.parseInt(br.readLine());
		int[][] art = new int[size][size];
		for (int i = 0; i < size; i++)
		{
			String temp = br.readLine();
			for (int j = 0; j < size; j ++)
			{
				art[i][j] = Integer.parseInt((temp.substring(j, j + 1)));
			}
		}
		Map<Integer, Integer> map1 = new HashMap<>();
		/*
		map1.put(1, 100);
		map1.put(1, 10000);
		System.out.println(map1.get(1));
		System.out.println(map1.containsKey(1));
		*/
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("art.out")));
		pw.println(paints_at_first(size, art));
		pw.close();
	}
	static int paints_at_first(int size, int[][] art){
		Set<Integer> exclude = new HashSet<>();
		for (int i = 1; i <= 9; i++)
		{
			int col_start = 10;
			int col_end = -1;
			int row_start = 10;
			int row_end = -1;
			for (int j = 0; j < size; j++)
			{
				for (int k = 0; k < size; k++)
				{
					if (art[j][k] == i)
					{
						if (k < col_start)
						{
							col_start = k;
						}
						if (col_end < k)
						{
							col_end = k;
						}
						if (j < row_start)
						{
							row_start = j;
						}
						if (row_end < j)
						{
							row_end = j;
						}
					}
				}
			}
			if (col_start == 10)
			{
				continue;
			}
			for (int j = row_start; j <= row_end; j++)
			{
				for (int k = col_start; k <= col_end; k ++)
				{
					if (art[j][k] != i)
					{
						exclude.add(art[j][k]);
					}
				}
			}
		}
		Set<Integer> include = new HashSet<>();
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j ++)
			{
				if (art[i][j] != 0)
				{
					include.add(art[i][j]);
				}
			}
		}
		return include.size() - exclude.size();
	}
}