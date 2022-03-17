import java.io.*;
import java.util.*;

public class Cities_and_States {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
		Map<String, Map<String, Integer>> relation = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i ++)
		{
			st = new StringTokenizer(br.readLine());
			String state_1 = st.nextToken();
			String state_code_1 = state_1.substring(0, 2);
			String state_code_2 = st.nextToken();
			//System.out.println(state_code_1 + " " + state_code_2);
			if (!relation.containsKey(state_code_2))
			{
				Map<String, Integer> temp = new HashMap<>();
				temp.put(state_code_1, 1);
				relation.put(state_code_2, temp);
			}
			else
			{
				if (relation.get(state_code_2).containsKey(state_code_1))
				{
					int temp = relation.get(state_code_2).get(state_code_1) + 1;
					relation.get(state_code_2).put(state_code_1, temp);
				}
				else
				{
					relation.get(state_code_2).put(state_code_1, 1);
				}
			}
		}
		//System.out.println(relation);
		int answer = 0;
		for (String str1 : relation.keySet())
		{
			Map<String, Integer> cur = relation.get(str1);
			for (String str2 : cur.keySet())
			{
				if (relation.containsKey(str2) && relation.get(str2).containsKey(str1) && !str1.equals(str2))
				{
					answer += cur.get(str2) * relation.get(str2).get(str1);
				}
			}
		}
		answer /= 2;
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
		pw.println(answer);
		pw.close();
	}

}
