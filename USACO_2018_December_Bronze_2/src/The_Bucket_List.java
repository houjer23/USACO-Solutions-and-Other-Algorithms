import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class The_Bucket_List {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("blist.in"));
		int size = Integer.parseInt(br.readLine());
		int[][] bucket = new int[size][3];
		StringTokenizer st;
		for (int i = 0; i < size; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
			{
				bucket[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
		pw.print(total_buckets(size, bucket));
		pw.close();
	}
	static int total_buckets(int size, int[][] bucket){
		int max = 0;
		int bucket_sum = 0;
		int bucket_sum_max = 0;
		for (int i = 0; i < size; i ++)
		{
			if (bucket[i][1] > max)
			{
				max= bucket[i][1];
			}
		}
		for (int i = 1; i <= max; i ++)
		{
			for (int j = 0; j < size; j ++)
			{
				if (bucket[j][0] <= i && bucket[j][1] >= i)
				{
					bucket_sum += bucket[j][2];
				}
			}
			if (bucket_sum > bucket_sum_max)
			{
				bucket_sum_max = bucket_sum;
			}
			bucket_sum = 0;
		}
		return bucket_sum_max;
	}
}
