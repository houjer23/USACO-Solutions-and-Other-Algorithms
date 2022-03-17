import java.io.*;
import java.util.*;

public class Block_Game {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
		int size = Integer.parseInt(br.readLine());
		int[] solution = new int[26];
		Arrays.fill(solution, 0);
		int[] check = new int[26];
		Arrays.fill(check, 0);
		StringTokenizer st;
		for (int i = 0; i < size; i ++)
		{
			st = new StringTokenizer(br.readLine());
			String word1 = st.nextToken();
			String word2 = st.nextToken();
			char[] char1 = word1.toCharArray();
			char[] char2 = word2.toCharArray();
			Set<Integer> repeat = new HashSet<>();
			for (int j = 0; j < char1.length; j ++)
			{
				for (int k = 0; k < char2.length; k ++)
				{
					if (char1[j] == char2[k] && !(repeat.contains(k)))
					{
						check[char1[j] - 97] += 1;
						repeat.add(k);
						break;
					}
				}
			}		
			for (int j = 0; j < char1.length; j ++)
			{
				solution[char1[j] - 97] += 1;
				//System.out.println((int) char1[j] - 97 + " " + (char) char1[j] + " " + solution[char1[j] - 97]);
			}
			for (int j = 0; j < char2.length; j ++)
			{
				solution[char2[j] - 97] += 1;
				//System.out.println((int) char2[j] - 97 + " " + (char) char2[j] + " " + solution[char2[j] - 97]);
			}
		}
		for (int j = 0; j < 26; j ++)
		{
			solution[j] -= check[j];
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
		for (int i = 0; i < 26; i ++)
		{
			pw.println(solution[i]);
		}
		pw.close();
	}
}
