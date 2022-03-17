import java.io.*;
import java.util.*;

public class Friend_Circles {
	public int findCircleNum(int[][] M) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < M.length; i ++)
        {
            for (int j = 0; j < M.length; j ++)
            {
                if (i == j || M[i][j] == 0)
                {
                    continue;
                }
                if (!graph.containsKey(i))
                {
                    graph.put(i, new HashSet<>());
                }
                graph.get(i).add(j);
            }
        }
        Set<Integer> repeat = new HashSet<>();
        int result = 0;
        for (int i = 0; i < M.length; i ++)
        {
            if (!repeat.contains(i))
            {
                result ++;
                dfs(graph, i, repeat);
            }
        }
        return result;
    }
    public void dfs(Map<Integer, Set<Integer>> graph, int start, Set<Integer> repeat)
    {
        repeat.add(start);
        if (graph.containsKey(start))
        {
            for (int next : graph.get(start))
            {
                if (!repeat.contains(next))
                {
                    dfs(graph, next, repeat);
                }
            }
        }
    }
}
