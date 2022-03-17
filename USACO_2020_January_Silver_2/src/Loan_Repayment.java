import java.io.*;
import java.util.*;

public class Loan_Repayment {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("loan.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		long start = 1;
		long end = (long) Math.pow(10, 12);
		while (start < end) {
			System.out.println(start + " " + end);
			long middle = (start + end) / 2 + 1;
			if (check(N, K, M, middle)) {
				start = middle;
			} else {
				end = middle - 1;
			}
		}
		pw.println(start);
		pw.close();
	}
	public static boolean check(long N, long K, long M, long X) {
		long days = 0;
		long left = N;
		while (left > 0) {
			long G = N - left;
			long Y = (N - G) / X;
			if (Y < M) {
				days += left / M;
				if (left % M != 0) {
					days ++;
				}
				break;
			}
			left -= Y;
			days ++;
		}
		System.out.println(X + "    " + days);
		if (days <= K) {
			return true;
		} else {
			return false;
		}
	}
}
