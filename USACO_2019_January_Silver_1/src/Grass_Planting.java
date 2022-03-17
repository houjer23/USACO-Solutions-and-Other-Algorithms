import java.io.*;
import java.util.*;

public class Grass_Planting {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("planting.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Integer[] farm = new Integer[N];
		for (int i = 0; i < farm.length; i ++)
		{
			farm[i] = 1;
		}
		int max = 1;
		StringTokenizer st1;
		for (int i = 0; i < N - 1; i ++)
		{
			st1 = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st1.nextToken());
			int num2 = Integer.parseInt(st1.nextToken());
			farm[num1 - 1] += 1;
			farm[num2 - 1] += 1;
			if (farm[num1 - 1] > max)
			{
				max = farm[num1 - 1];
			}
			if (farm[num2 - 1] > max)
			{
				max = farm[num2 - 1];
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
		pw.println(max);
		pw.close();
	}
}