import java.io.*;
import java.util.*;

public class Out_of_Sorts {
	public static class Sort_Num implements Comparable<Sort_Num>{
		int val;
		int index;
		
		public Sort_Num(int val, int index) {
			this.val = val;
			this.index = index;
		}
		
		public int compareTo(Sort_Num s2) {
			if (this.val != s2.val) 
				return this.val - s2.val;
			return this.index - s2.index;
		}
		
		public String toString() {
			return val + " " + index;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("sort.in"));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Sort_Num> num = new ArrayList<Sort_Num>();
		for (int i = 0; i < N; i ++)
		{
			Sort_Num s = new Sort_Num(Integer.parseInt(br.readLine()), i);
			num.add(s);
		}
		int max = 0;
		Collections.sort(num);
		for (int i = 0; i < N; i ++)
		{
			if (num.get(i).index - i + 1 > max)
			{
				max = num.get(i).index - i + 1;
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
		pw.println(max);
		pw.close();
	}
}
