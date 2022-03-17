import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Mixing_Milk {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
		int[] total_volume = new int[3];
		int[] volume = new int[3];
		StringTokenizer st;
		for (int i = 0; i < 3; i++)
		{
			st = new StringTokenizer(br.readLine());
			total_volume[i] = Integer.parseInt(st.nextToken());
			volume[i] = Integer.parseInt(st.nextToken());
		}
		/*
		for (int i = 0; i < 3; i++)
		{
			System.out.print(total_volume[i] + " ");
			System.out.println(volume[i]);
		}
		*/
		volume = mix(total_volume, volume);
		/*
		for (int i = 0; i < 3; i++)
		{
			System.out.println(volume[i]);
		}
		*/
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
		pw.println(volume[0]);
		pw.println(volume[1]);
		pw.print(volume[2]);
		pw.close();
	}
	static int[] mix(int[] total_volume, int[] volume){
		for(int i = 0; i < 100; i++)
		{
			if (i % 3 == 0)
			{
				volume[1] = volume[0] + volume[1];
				volume[0] = 0;
				if (volume[1] > total_volume[1])
				{
					volume[0] = volume[1] - total_volume[1];
					volume[1] = total_volume[1];
				}
			}
			else if (i % 3 == 1)
			{
				volume[2] = volume[1] + volume[2];
				volume[1] = 0;
				if (volume[2] > total_volume[2])
				{
					volume[1] = volume[2] - total_volume[2];
					volume[2] = total_volume[2];
				}
			}
			else
			{
				volume[0] = volume[2] + volume[0];
				volume[2] = 0;
				if (volume[0] > total_volume[0])
				{
					volume[2] = volume[0] - total_volume[0];
					volume[0] = total_volume[0];
				}
			}
		}
		return volume;
	}
}