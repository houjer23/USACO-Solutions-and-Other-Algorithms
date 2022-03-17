import java.io.*;
import java.util.*;

public class My_Cow_Ate_My_Homework {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("homework.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
		int N = Integer.parseInt(br.readLine());
		int[] grades = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i ++)
		{
			grades[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> k_values = new ArrayList<>();
		double answer = 0;
		int sum = grades[N - 1];
		int smallest = grades[N - 1];
		for (int i = N - 2; i > 0; i --)
		{
			sum += grades[i];
			if (grades[i] < smallest)
			{
				smallest = grades[i];
			}
			double cur_answer = (double) (sum - smallest) / (N - i - 1);
			if (cur_answer - answer > 0.0000000001)
			{
				k_values = new ArrayList<>();
				answer = cur_answer;
				k_values.add(i);
			}
			else if (Math.abs(cur_answer - answer) < 0.0000000001)
			{
				k_values.add(i);
			}
		}
		for (int i = k_values.size() - 1; i >= 0; i --)
		{
			pw.println(k_values.get(i));
		}
		pw.close();
	}
}
