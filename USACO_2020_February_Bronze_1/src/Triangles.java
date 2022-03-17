import java.io.*;
import java.util.*;

public class Triangles {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] triangle = new int[N][2];
		
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			triangle[i][0] = Integer.parseInt(st.nextToken());
			triangle[i][1] = Integer.parseInt(st.nextToken());
		}
		
		/*
		System.out.println(N);
		for (int i = 0; i < N; i ++)
		{
			System.out.println(triangle[i][0] + " " + triangle[i][1]);
		}
		*/
		
		
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
		
		pw.println(max_area(N, triangle));
		pw.close();
	}
	static int max_area(int N, int[][] triangle){
		int area = 0;
		for (int i = 0; i < N; i ++)
		{
			int max_x = 0;
			for (int j = 0; j < N; j ++)
			{
				if (!(j == i))
				{
					if (triangle[i][1] == triangle[j][1])
					{
						if (Math.abs(triangle[j][0] - triangle[i][0]) > max_x)
						{
							max_x = Math.abs(triangle[j][0] - triangle[i][0]);
						}
					}
				}
			}
			int max_y = 0;
			for (int j = 0; j < N; j ++)
			{
				if (!(j == i))
				{
					if (triangle[i][0] == triangle[j][0])
					{
						if (Math.abs(triangle[j][1] - triangle[i][1]) > max_y)
						{
							max_y = Math.abs(triangle[j][1] - triangle[i][1]);
						}
					}
				}
			}
			if (max_x * max_y > area)
			{
				area = max_x * max_y;
			}
		}
		return area;
	}
}
