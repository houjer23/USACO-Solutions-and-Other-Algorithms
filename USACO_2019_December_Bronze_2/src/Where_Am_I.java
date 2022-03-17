import java.io.*;
import java.util.*;

public class Where_Am_I {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
		int k = Integer.parseInt(br.readLine());
		String color = br.readLine();
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
		pw.println(find_K(color, k));
		pw.close();
	}
	static int find_K(String color, int k){
		
		Set<String> result = new HashSet<>();
		
		for (int i = 1; i <= k; i ++)
		{
			int flag = 0;
			result = new HashSet<>();
			for (int j = 0; j <= k - i; j ++)
			{
				if (result.contains(color.substring(j, j + i)))
				{
					flag = 1;
					break;
				}
				else
				{
					result.add(color.substring(j, j + i));
				}
			}
			if (flag == 0)
			{
				return i;
			}
		}
		return 0;
	}
}
