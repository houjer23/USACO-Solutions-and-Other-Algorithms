import java.io.*;
import java.util.*;

public class MooBuzz {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
		int N = Integer.parseInt(br.readLine());
		int prev_num = 0;
		while (true)
		{
			int cur_num_3 = N / 3;
			int cur_num_5 = N / 5;
			int cur_num_15 = N / 15;
			int cur_num = cur_num_3 + cur_num_5 - cur_num_15;
			if (cur_num - prev_num == 0)
			{
				break;
			}
			N += cur_num - prev_num;
			prev_num = cur_num;
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
		pw.println(N);
		pw.close();
	}
}
