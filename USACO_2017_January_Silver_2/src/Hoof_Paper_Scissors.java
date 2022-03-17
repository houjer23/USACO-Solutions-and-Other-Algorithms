import java.io.*;
import java.util.*;

public class Hoof_Paper_Scissors {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("hps.in"));
		int N = Integer.parseInt(br.readLine());
		int s = 0;
		int h = 0;
		int p = 0;
		List<Character> win = new ArrayList<>();
		for (int i = 0; i < N; i ++)
		{
			String cur = br.readLine();
			char cur_char = cur.charAt(0);
			if (cur_char == 'S')
			{
				h ++;
				win.add('H');
			}
			else if (cur_char == 'P')
			{
				s ++;
				win.add('S');
			}
			else
			{
				p ++;
				win.add('P');
			}
		}
		//System.out.println(win);
		int answer = 0;
		int num_s = 0;
		int num_h = 0;
		int num_p = 0;
		if (win.get(0) == 'S')
		{
			num_s ++;
		}
		else if (win.get(0) == 'P')
		{
			num_p ++;
		}
		else
		{
			num_h ++;
		}
		for (int i = 1; i <= N; i ++)
		{
			int num_s_right = s - num_s;
			int num_h_right = h - num_h;
			int num_p_right = p - num_p;
			//System.out.println("S: " + num_s + " " + num_s_right + " H: " + num_h + " " + num_h_right + " P: " + num_p + " " + num_p_right);
			int[][] test = {{num_s, num_h_right}, {num_s, num_p_right}, {num_h, num_p_right}, {num_h, num_s_right}, {num_p, num_s_right}, {num_p, num_h_right}};
			for (int j = 0; j < 6; j ++)
			{
				int num1 = test[j][0];
				int num2 = test[j][1];
				if (num1 + num2 > answer)
				{
					answer = num1 + num2;
					//System.out.println(num1 + " " + num2);
				}
			}
			if (i == N)
			{
				break;
			}
			if (win.get(i) == 'S')
			{
				num_s ++;
			}
			else if (win.get(i) == 'P')
			{
				num_p ++;
			}
			else
			{
				num_h ++;
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		pw.println(answer);
		pw.close();
	}
}
