import java.io.*;
import java.util.*;

public class Mad_Scientist {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
		
		int N = Integer.parseInt(br.readLine());
		
		String A_str = br.readLine();
		String B_str = br.readLine();
		
		char[] A = A_str.toCharArray();
		char[] B = B_str.toCharArray();
		
		/*
		System.out.println(N);
		for (int i = 0; i < N; i ++)
		{
			System.out.println(A[i] + " " + B[i]);
		}
		*/
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
		
		pw.println(solution(N, A, B));
		pw.close();
	}
	static int solution(int N, char[] A, char[] B){
		int times = 0;
		int start = 0;
		for (int i = 0; i < N; i ++)
		{
			if (A[i] == B[i])
			{
				start = i + 1;
				break;
			}
		}
		if (start != 1)
		{
			times = 1;
		}
		int check = 0;
		for (int i = start; i < N; i ++)
		{
			if (check != 0 && A[i] == B[i])
			{
				//System.out.println(A[i] + " " + B[i] + " " + i);
				times += 1;
				check = 0;
			}
			else
			{
				check ++;
				if (A[i] == B[i])
				{
					check = 0;
				}
			}
		}
		//System.out.println(times);
		return times;
	}
}
