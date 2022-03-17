import java.io.*;
import java.util.*;

public class Do_You_Know_Your_ABCs {
	public static void main(String[] args) throws IOException{
        InputStream is = System.in;
        OutputStream os = System.out;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        List<Integer> nums = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 7; i ++)
        {
        	nums.add(Integer.parseInt(st.nextToken()));
        }
        
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int i = 0; i < 7; i ++)
        {
        	if (nums.get(i) < min)
        	{
        		min = nums.get(i);
        		min_index = i;
        	}
        }
        nums.remove(min_index);
        int second_min = Collections.min(nums);
        int max = Collections.max(nums);
        int third_min = max - second_min - min;
        
        os.write(String.valueOf(min).getBytes());
        os.write(" ".getBytes());
        os.write(String.valueOf(second_min).getBytes());
        os.write(" ".getBytes());
        os.write(String.valueOf(third_min).getBytes());
    }
}
