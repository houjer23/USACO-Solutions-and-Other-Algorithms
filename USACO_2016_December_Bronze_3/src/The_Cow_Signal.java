import java.io.*;
import java.util.*;

public class The_Cow_Signal {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String[] signal = new String[M];
		for (int i = 0; i < M; i ++)
		{
			signal[i] = br.readLine();
		}
		
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
		
		String[] signal3 = convert(signal, M, N, K);
		for (int i = 0; i < M * K; i ++)
		{
			pw.println(signal3[i]);
		}
		pw.close();
	}
	static String[] convert(String[] signal, int M, int N, int K){
		
		String[] signal2 = new String[M * K];
		
		for (int i = 0; i < M; i ++)
		{
			signal2[i * K] = "";
			for (int j = 0; j < N; j ++)
			{
				String str = signal[i].substring(j, j + 1);
				for (int k = 0; k < K; k ++)
				{
					signal2[i * K] += str;
				}
			}
			for (int j = 1; j < K; j ++)
			{
				signal2[i * K + j] = signal2[i * K];
			}
		}
		return signal2;
	}
}
