import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class The_Lost_Cow {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("lostcow.in"));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());	
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
		pw.print(total_buckets(x, y));
		pw.close();
	}
	static int total_buckets(int x, int y){
		int move = 1;
		int distance = 0;
		int direction = 1;
		while (true)
		{
			if ((direction == 1 && y <= x + move && y >= x) || (direction == -1 && x - move <= y && y <= x)) 
			{
				distance += Math.abs(y - x) + move / 2;
			    break;
			}
			else
			{
				distance += move + move / 2;
				move *= 2;
				direction *= -1;
			}
		}
		return distance;
	}
}
