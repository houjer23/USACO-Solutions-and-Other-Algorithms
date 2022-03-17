import java.io.*;
import java.util.*;

public class Square_Pasture {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("square.in"));
		StringTokenizer st;
		int[][] posi = new int[4][2];
		st = new StringTokenizer(br.readLine());
		posi[0][0] = Integer.parseInt(st.nextToken());
		posi[0][1] = Integer.parseInt(st.nextToken());
		posi[1][0] = Integer.parseInt(st.nextToken());
		posi[1][1] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		posi[2][0] = Integer.parseInt(st.nextToken());
		posi[2][1] = Integer.parseInt(st.nextToken());
		posi[3][0] = Integer.parseInt(st.nextToken());
		posi[3][1] = Integer.parseInt(st.nextToken());
		//System.out.println(posi[0][0] + " " + posi[0][1] + " " + posi[1][0] + " " + posi[1][1]);
		//System.out.println(posi[2][0] + " " + posi[1][1] + " " + posi[3][0] + " " + posi[3][1]);
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
		pw.println(find_square(posi));
		pw.close();
	}
	static int find_square(int[][] posi){
		int[] left_b = new int[2];
		int[] right_t = new int[2];
		if (posi[0][0] < posi[2][0])
		{
			left_b[0] = posi[0][0];
		}
		else
		{
			left_b[0] = posi[2][0];
		}
		if (posi[0][1] < posi[2][1])
		{
			left_b[1] = posi[0][1];
		}
		else
		{
			left_b[1] = posi[2][1];
		}
		if (posi[1][0] > posi[3][0])
		{
			right_t[0] = posi[1][0];
		}
		else
		{
			right_t[0] = posi[3][0];
		}
		if (posi[1][1] > posi[3][1])
		{
			right_t[1] = posi[1][1];
		}
		else
		{
			right_t[1] = posi[3][1];
		}
		if (Math.abs(left_b[0] - right_t[0]) > Math.abs(left_b[1] - right_t[1]))
		{
			return (left_b[0] - right_t[0]) * (left_b[0] - right_t[0]);
		}
		else
		{
			return (left_b[1] - right_t[1]) * (left_b[1] - right_t[1]);
		}
	}
}
