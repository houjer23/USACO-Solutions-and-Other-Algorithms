import java.io.*;
import java.util.*;

public class Back_and_Forth {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
		ArrayList<Integer> barn1 = new ArrayList<>();
		ArrayList<Integer> barn2 = new ArrayList<>();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++)
		{
			barn1.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++)
		{
			barn2.add(Integer.parseInt(st.nextToken()));
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
		pw.println(backforth(barn1, barn2));
		pw.close();
	}
	static int backforth(ArrayList<Integer> barn1, ArrayList<Integer> barn2){
		int change = 0;
		ArrayList<Integer> barn1_1 = new ArrayList<>();
		ArrayList<Integer> barn2_1 = new ArrayList<>();
		int change1;
		ArrayList<Integer> barn1_2 = new ArrayList<>();
		ArrayList<Integer> barn2_2 = new ArrayList<>();
		int change2;
		ArrayList<Integer> barn1_3 = new ArrayList<>();
		ArrayList<Integer> barn2_3 = new ArrayList<>();
		int change3;
		ArrayList<Integer> barn1_4 = new ArrayList<>();
		ArrayList<Integer> barn2_4 = new ArrayList<>();
		int change4;
		Set<Integer> result = new HashSet<>();
		for (int i = 0; i < 10; i ++)
		{
			change1 = change;
			barn1_1.removeAll(barn1_1);
			barn2_1.removeAll(barn2_1);
			for (int j = 0; j < 10; j++)
			{
				barn1_1.add(barn1.get(j));
				barn2_1.add(barn2.get(j));
			}
			barn2_1.add(barn1_1.get(i));
			change1 -= barn1_1.get(i);
			barn1_1.remove(i);
			for (int j = 0; j < 11; j ++)
			{
				change2 = change1;
				barn1_2.removeAll(barn1_2);
				barn2_2.removeAll(barn2_2);
				for (int k = 0; k < 9; k++)
				{
					barn1_2.add(barn1_1.get(k));
					barn2_2.add(barn2_1.get(k));
				}
				barn2_2.add(barn2_1.get(9));
				barn2_2.add(barn2_1.get(10));
				
				barn1_2.add(barn2_2.get(j));
				change2 += barn2_2.get(j);
				barn2_2.remove(j);
				for (int k = 0; k < 10; k++)
				{
					change3 = change2;
					barn1_3.removeAll(barn1_3);
					barn2_3.removeAll(barn2_3);
					for (int l = 0; l < 10; l++)
					{
						barn1_3.add(barn1_2.get(l));
						barn2_3.add(barn2_2.get(l));
					}
					barn2_3.add(barn1_3.get(k));
					change3 -= barn1_3.get(k);
					barn1_3.remove(k);
					for (int l = 0; l < 10; l++)
					{
						change4 = change3;
						barn1_4.removeAll(barn1_4);
						barn2_4.removeAll(barn2_4);
						for (int m = 0; m < 9; m++)
						{
							barn1_4.add(barn1_3.get(m));
							barn2_4.add(barn2_3.get(m));
						}
						barn2_4.add(barn2_3.get(9));
						barn2_4.add(barn2_3.get(10));
						
						barn1_4.add(barn2_4.get(l));
						change4 += barn2_4.get(l);
						barn2_4.remove(l);
						
						result.add(change4);
					}
				}
			}
		}
	    return result.size();
	}
}
