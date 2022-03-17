import java.io.*;
import java.util.*;

public class Daisy_Chains {
	public static void main(String[] args) throws IOException{
		InputStream is = System.in;
        OutputStream os = System.out;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; i ++)
        {
        	nums.add(Integer.parseInt(st.nextToken()));
        }
        int answer = 0;
        for (int i = 1; i <= N; i ++)
        {
        	for (int j = 0; j <= N - i; j ++)
        	{
        		if (i == 1)
        		{
        			answer ++;
        			continue;
        		}
        		int k = j + (i - 1);
    			int sum = 0;
    			Set<Integer> contains = new HashSet<>();
    			for (int l = j; l <= k; l ++)
    			{
    				contains.add(nums.get(l));
    				sum += nums.get(l);
    			}
    			if ((double) sum / i == (int) (double) sum / i && contains.contains(sum / i))
    			{
    				answer += 1;
    			}
        	}
        }
        os.write(String.valueOf(answer).getBytes());
	}

}
