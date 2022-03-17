import java.io.*;
import java.util.*;

public class Stuck_in_a_Rut {
	public static void main(String[] args) throws IOException{
		InputStream is = System.in;
        OutputStream os = System.out;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> nums = new ArrayList<>();
        List<String> direction = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i ++)
        {
        	st = new StringTokenizer(br.readLine());
        	direction.add(st.nextToken());
        	List<Integer> temp = new ArrayList<>();
        	temp.add(Integer.parseInt(st.nextToken()));
        	temp.add(Integer.parseInt(st.nextToken()));
        	nums.add(temp);
        }
        
        int i = 0;
        Map<String, Integer> eatten = new HashMap<>();
        List<Integer> answer = new ArrayList<Integer>(Collections.nCopies(N, 0));
        while (i < 10000)
        {
        	for (int j = 0; j < N; j ++)
        	{
        		if (direction.get(j).equals("Q"))
        		{
        			continue;
        		}
        		if (eatten.containsKey(String.valueOf(nums.get(j).get(0)) + " " + String.valueOf(nums.get(j).get(1))) && eatten.get(String.valueOf(nums.get(j).get(0)) + " " + String.valueOf(nums.get(j).get(1))) != i)
        		{
        			direction.set(j, "Q");
        		}
        		else
        		{
        			eatten.put(String.valueOf(nums.get(j).get(0)) + " " + String.valueOf(nums.get(j).get(1)), i);
        			if (direction.get(j).equals("N"))
        			{
        				nums.get(j).set(1, nums.get(j).get(1) + 1);
        			}
        			else
        			{
        				nums.get(j).set(0, nums.get(j).get(0) + 1);
        			}
        			answer.set(j, answer.get(j) + 1);
        		}
        	}
        	i ++;
        }
        /*
        List<List<Integer>> N_remain = new ArrayList<>();
        List<Integer> N_remain_posi = new ArrayList<>();
        List<List<Integer>> E_remain = new ArrayList<>();
        List<Integer> E_remain_posi = new ArrayList<>();
        
        for (int j = 0; j < N; j ++)
        {
        	if (direction.get(j).equals("N"))
        	{
        		N_remain.add(nums.get(j));
        		N_remain_posi.add(j);
        	}
        	if (direction.get(j).equals("E"))
        	{
        		E_remain.add(nums.get(j));
        		E_remain_posi.add(j);
        	}
        }
        
        for (int j = 0; j < N_remain.size(); j ++)
        {
        	int check = 0;
        	int cur_answer = Integer.MAX_VALUE;
        	for (int k = 0; k < E_remain.size(); k ++)
        	{
        		if (N_remain.get(j).get(0) - E_remain.get(k).get(0) < E_remain.get(k).get(1) - N_remain.get(j).get(1) && E_remain.get(k).get(1) - N_remain.get(j).get(1) < cur_answer)
        		{
        			check = 1;
        			cur_answer = E_remain.get(k).get(1) - N_remain.get(j).get(1);
        		}
        	}
        	if (check == 1)
        	{
        		answer.set(N_remain_posi.get(j), 10000 + cur_answer);
        	}
        }
        
        for (int j = 0; j < E_remain.size(); j ++)
        {
        	int check = 0;
        	int cur_answer = Integer.MAX_VALUE;
        	for (int k = 0; k < N_remain.size(); k ++)
        	{
        		if (N_remain.get(k).get(0) - E_remain.get(j).get(0) > E_remain.get(j).get(1) - N_remain.get(k).get(1) && N_remain.get(k).get(0) - E_remain.get(j).get(0) < cur_answer)
        		{
        			check = 1;
        			cur_answer = N_remain.get(k).get(0) - E_remain.get(j).get(0);
        		}
        	}
        	if (check == 1)
        	{
        		answer.set(E_remain_posi.get(j), 10000 + cur_answer);
        	}
        }
        */
        
        
        for (int j = 0; j < N; j ++)
        {
        	if (answer.get(j) == 10000)
        	{
        		System.out.println("Infinity");
        	}
        	else
        	{
        		System.out.println(answer.get(j));
        	}
        }
	}
}
