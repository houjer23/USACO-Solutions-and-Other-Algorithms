import java.io.*;
import java.util.*;

public class The_Cow_Signal {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String[] board = new String[M];
		for (int i = 0; i < M; i ++)
		{
			board[i] = br.readLine();
			//System.out.println(board[i]);
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
		board = enlarge(M, N, K, board);
		for (int i = 0; i < M * K; i ++)
		{
			pw.println(board[i]);
		}
		pw.close();
	}
	static String[] enlarge(int M, int N, int K, String[] board){
		String[] new_board = new String[M * K];
		for (int i = 0; i < M; i ++)
		{
			String str = board[i];
			char[] char_arr = str.toCharArray();
			char[] new_char_arr = new char[N * K];
			for (int j = 0; j < N; j ++)
			{
				for (int k = 0; k < K; k ++)
				{
					new_char_arr[j * K + k] = char_arr[j];
				}
			}
			String new_str = String.valueOf(new_char_arr);
			for (int j = 0; j < K; j ++)
			{
				new_board[i * K + j] = new_str;
			}
		}
		return new_board;
	}
}
