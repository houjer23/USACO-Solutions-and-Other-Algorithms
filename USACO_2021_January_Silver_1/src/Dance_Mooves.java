import java.io.*;
import java.util.*;

public class Dance_Mooves {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] position = new int[5][4];
        for (int i = 0; i < K; i ++)
        {
        	st = new StringTokenizer(br.readLine());
        	position[i][0] = Integer.parseInt(st.nextToken());
        	position[i][1] = Integer.parseInt(st.nextToken());
        }
        String dance = "";
        List<Set<Integer>> nums = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i ++)
        {
        	dance = dance + Integer.toString(i);
        	nums.add(new HashSet<>());
        	nums.get(i - 1).add(i);
        	answer.add(0);
        }
        Set<String> repeat = new HashSet<>();
        repeat.add(dance);
        while (true) {
        	for (int i = 0; i < K; i ++)
        	{
        		char temp = dance.charAt(position[i][0] - 1);
        		dance = dance.substring(0, position[i][0] - 1) + dance.charAt(position[i][1] - 1) + dance.substring(position[i][0], N);
        		dance = dance.substring(0, position[i][1] - 1) + temp + dance.substring(position[i][1], N);
        		if (!nums.get(position[i][0] - 1).contains((int) (dance.charAt(position[i][0] - 1)) - 48))
        		{
        			nums.get(position[i][0] - 1).add((int) (dance.charAt(position[i][0] - 1)) - 48);
        			answer.set((int) (dance.charAt(position[i][0] - 1)) - 49, answer.get((int) (dance.charAt(position[i][0] - 1)) - 49) + 1);
        		}
        		if (!nums.get(position[i][1] - 1).contains((int) (dance.charAt(position[i][1] - 1)) - 48))
        		{
        			nums.get(position[i][1] - 1).add((int) (dance.charAt(position[i][1] - 1)) - 48);
        			answer.set((int) (dance.charAt(position[i][1] - 1)) - 49, answer.get((int) (dance.charAt(position[i][1] - 1)) - 49) + 1);
        		}
        	}
        	if (repeat.contains(dance))
        	{
        		break;
        	}
        }
        for (int i = 0; i < N; i ++)
        {
        	System.out.println(answer.get(i) + 1);
        }
	}
        
	

}
