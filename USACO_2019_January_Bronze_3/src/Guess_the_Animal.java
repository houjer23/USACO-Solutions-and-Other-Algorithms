import java.io.*;
import java.util.*;

public class Guess_the_Animal {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("guess.in"));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<String>> trait = new ArrayList<>();
		ArrayList<String> name = new ArrayList<>();
		ArrayList<Integer> num = new ArrayList<>();
		
		StringTokenizer st;
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			name.add(st.nextToken());
			num.add(Integer.parseInt(st.nextToken()));
			
			ArrayList<String> temp = new ArrayList<>();
			for (int j = 0; j < num.get(i); j++)
			{
				temp.add(st.nextToken());
			}
			trait.add(temp);
		}
		
		/*
		for (int i = 0; i < N; i ++)
		{
			System.out.print(name.get(i) + " ");
			System.out.print(num.get(i) + " ");
			
			for (int j = 0; j < num.get(i); j ++)
			{
				System.out.print(trait.get(i).get(j) + " ");
			}
			System.out.println();
		}
		*/
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));
		
		pw.println(max_yes(N, trait, name, num));
		pw.close();
	}
	static int max_yes(int N, ArrayList<ArrayList<String>> trait, ArrayList<String> name, ArrayList<Integer> num){
		int max_yes = 0;
		for (int i = 0; i < N; i ++)
		{
			Set<String> item = new HashSet<>();
			for (int j = 0; j < num.get(i); j ++)
			{
				item.add(trait.get(i).get(j));
			}
			int max_one_index = 0;
			int max_one_num = 0;
			int same = 0;
			for (int j = 0; j < N; j ++)
			{
				for (int k = 0; k < num.get(j); k ++)
				{
					if (j == i)
					{
						break;
					}
					if (item.contains(trait.get(j).get(k)))
					{
						same += 1;
					}
				}
				if (same > max_one_num)
				{
					max_one_index = j;
					max_one_num = same;
				}
				same = 0;
			}
			//System.out.println(name.get(i) + " " + max_one_num + " " + max_one_index);
			if (max_one_num + 1 > max_yes)
			{
				max_yes = max_one_num + 1;
			}
		}
		return max_yes;
	}
}
