import java.io.*;
import java.util.*;

public class Cow_Evolution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("evolution.in"));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<String>> ability = new ArrayList<>();
		ArrayList<Integer> num = new ArrayList<>();
		
		StringTokenizer st;
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			num.add(Integer.parseInt(st.nextToken()));
			
			ArrayList<String> temp = new ArrayList<>();
			for (int j = 0; j < num.get(i); j++)
			{
				temp.add(st.nextToken());
			}
			ability.add(temp);
		}
		
		/*
		for (int i = 0; i < N; i ++)
		{
			System.out.print(num.get(i) + " ");
			
			for (int j = 0; j < num.get(i); j ++)
			{
				System.out.print(ability.get(i).get(j) + " ");
			}
			System.out.println();
		}
		*/
		
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("evolution.out")));
		
		pw.println(determine(N, ability, num));
		pw.close();
	}
	static String determine(int N, ArrayList<ArrayList<String>> ability, ArrayList<Integer> num){
		Set<ArrayList<String>> group = new HashSet<>();
		ArrayList<ArrayList<String>> group_arr = new ArrayList<>();
		for (int i = 0; i < N; i++)
		{
			if (num.get(i) >= 2)
			{
				for (int j = 0; j < num.get(i) - 1; j ++)
				{
					for (int k = j + 1; k < num.get(i); k ++)
					{
						ArrayList<String> temp = new ArrayList<>();
						temp.add(ability.get(i).get(j));
						temp.add(ability.get(i).get(k));
						group.add(temp);
					}
				}
			}
		}
		for (ArrayList<String> i : group)
		{
			group_arr.add(i);
		}
		
		int flag3 = 0;
		for (int i = 0; i < group_arr.size(); i ++)
		{
			for (int time = 0; time < 2; time ++)
			{
				int flag2 = 0;
				for (int j = 0; j < N; j ++)
				{
					for (int k = 0; k < num.get(j); k ++)
					{
						if (ability.get(j).get(k).equals(group_arr.get(i).get(time)))
						{
							int flag = 0;
							for (int l = 0; l < num.get(j); l ++)
							{
								if (time == 0)
								{
									if (ability.get(j).get(l).equals(group_arr.get(i).get(1)))
									{
										flag = 1;
										break;
										//System.out.println(ability.get(j) + " " + group_arr.get(i).get(time) + " " + group_arr.get(i).get(1));
									}
								}
								else
								{
									if (ability.get(j).get(l).equals(group_arr.get(i).get(0)))
									{
										flag = 1;
										break;
										//System.out.println(ability.get(j) + " " + group_arr.get(i).get(time) + " " + group_arr.get(i).get(0));
									}
								}
							}
							if (flag == 0)
							{						
								flag2 = 1;
							}
							break;
						}
					}
					if (flag2 == 1)
					{
						break;
					}
				}
				if (flag2 == 0)
				{
					break;
				}
				else
				{
					if (time == 1)
					{
						flag3 = 1;
					}
				}
			}
			if (flag3 == 1)
			{
				return "no";
			}
		}
		return "yes";
		
		/*
		for (ArrayList<String> i : group)
		{
			int check = 0;
			for (ArrayList<String> j : group)
			{
				for (int k = 0; k < j.size(); k ++)
				{
					if ()
				}
			}
		}
		*/
		   
	}
}
