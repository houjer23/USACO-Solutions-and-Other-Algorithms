import java.io.*;
import java.util.*;

public class Word_Processor {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("word.in"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<String> answer = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		answer.add(st.nextToken());
		int cur_size = answer.get(0).length();
		for (int i = 0; i < N - 1; i ++)
		{
			String cur = st.nextToken();
			if (cur_size + cur.length() <= K)
			{
				cur_size += cur.length();
				answer.set(answer.size() - 1, answer.get(answer.size() - 1) + " " + cur);
			}
			else
			{
				answer.add(cur);
				cur_size = cur.length();
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
		for (int i = 0; i < answer.size(); i ++)
		{
			pw.println(answer.get(i));
		}
		pw.close();
	}
}
