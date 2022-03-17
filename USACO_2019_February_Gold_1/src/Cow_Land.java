import java.io.*;
import java.util.*;

public class Cow_Land {
	public static Map<Integer, Set<Integer>> routes_map;
	public static Map<Integer, TreeNode> num_to_treenode;
	public static int tot = 0;
	public static TreeNode[] rank;
	public static int[] enjoyments;
	public static Segment_Tree segment_tree;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cowland.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		enjoyments = new int[N];
		for (int i = 0; i < N; i ++) {
			enjoyments[i] = Integer.parseInt(st.nextToken());
		}
		routes_map = new HashMap<>();
		for (int i = 0; i < N - 1; i ++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			if (!routes_map.containsKey(num1))
				routes_map.put(num1, new HashSet<>());
			if (!routes_map.containsKey(num2))
				routes_map.put(num2, new HashSet<>());
			routes_map.get(num1).add(num2);
			routes_map.get(num2).add(num1);
		}
		//System.out.println(routes_map);
		TreeNode root = new TreeNode();
		num_to_treenode = new HashMap<>();
		tree_build(root, 1, 1, new HashSet<>());
		rank = new TreeNode[N];
		tree_decomposition(root, root, new HashSet<>());
		segment_tree = new Segment_Tree();
		
		/*
		for (int j = 0; j < rank.length; j ++) {
			System.out.print(rank[j]);
		}
		System.out.println();
		for (int j = 0; j < rank.length; j ++) {
			System.out.print(segment_tree.segment_tree[j] + " ");
		}
		System.out.println("\n");
		*/


		List<Integer> answers = new ArrayList<>();
		for (int i = 0; i < Q; i ++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());
			if (num1 == 1) {
				num2 = num_to_treenode.get(num2).dfn - 1;
				segment_tree.update(num2, num3);
			} else {
				answers.add(tree_path_sum(num_to_treenode.get(num2), num_to_treenode.get(num3)));
			}
		}
		//System.out.println(answers);
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowland.out")));
		for (int i = 0; i < answers.size(); i ++) {
			pw.println(answers.get(i));
		}
		pw.close();
	}
	
	public static int tree_build(TreeNode u, int dep, int num, Set<Integer> repeat) {
		repeat.add(num);
		num_to_treenode.put(num, u);
		u.attraction_number = num;
		u.hson = new TreeNode();
		u.hson.size = 0;
		u.deep = dep;
		u.size = 1;
		for (int temp : routes_map.get(num)) {
			if (repeat.contains(temp)) {
				continue;
			}
			TreeNode son = new TreeNode();
			son.father = u;
			u.size += tree_build(son, dep + 1, temp, repeat);
			if (son.size > u.hson.size)
				u.hson = son;
		}
		return u.size;
	}
	public static void tree_decomposition(TreeNode u, TreeNode top, Set<Integer> repeat) {
		int u_num = u.attraction_number;
		repeat.add(u_num);
		u.top = top;
		rank[tot] = u;
		tot ++;
		u.dfn = tot;
		if (u.hson.size != 0) {
			tree_decomposition(u.hson, top, repeat);
			for (int temp : routes_map.get(u_num)) {
				if (repeat.contains(temp)) {
					continue;
				}
				if (num_to_treenode.get(temp) != u.hson) {
					tree_decomposition(num_to_treenode.get(temp), num_to_treenode.get(temp), repeat);
				}
			}
		}
	}
	public static int tree_path_sum(TreeNode u, TreeNode v) {
		tot = 0;
		while (u.top != v.top) {
			if (u.top.deep < v.top.deep) {
				TreeNode temp = u;
				u = v;
				v = temp;
			}
			tot ^= segment_tree.sumRange(u.top.dfn - 1, u.dfn - 1);
			u = u.top.father;
		}
		tot ^= segment_tree.sumRange(v.dfn - 1, u.dfn - 1);
		return tot;
	}
	
	
	public static class TreeNode {
		TreeNode hson;
		int deep;
		int size;
		TreeNode father;
		TreeNode top;
		int dfn;
		int attraction_number;
		
		public TreeNode() {}
		
		public String toString() {
			return enjoyments[attraction_number - 1] + " ";
		}
	}
	
	public static class Segment_Tree {
		int[] segment_tree;
		public Segment_Tree() {
	        segment_tree = new int[4 * rank.length + 1];
	        build_helper(0, rank.length - 1, 0);
	    }
		public void build_helper(int start, int end, int tree_index) {
	        if (start == end) {
	            segment_tree[tree_index] = enjoyments[rank[start].attraction_number - 1];
	            return;
	        }
	        int middle = (start + end) / 2;
	        build_helper(start, middle, tree_index * 2 + 1);
	        build_helper(middle + 1, end, tree_index * 2 + 2);
	        segment_tree[tree_index] = segment_tree[tree_index * 2 + 1] ^ segment_tree[tree_index * 2 + 2];
	    }
		public void update(int index, int val) {
	        update_helper(index, val, 0, 0, rank.length - 1);
	        enjoyments[rank[index].attraction_number - 1] = val;
	    }
	    public void update_helper(int index, int val, int tree_index, int start, int end) {
	        segment_tree[tree_index] = (segment_tree[tree_index] ^ enjoyments[rank[index].attraction_number - 1]) ^ val;
	        if (start == end) {
	            return;
	        }
	        int middle = (start + end) / 2; 
	        if (start <= index && middle >= index) {
	            update_helper(index, val, tree_index * 2 + 1, start, middle);
	        } else {
	            update_helper(index, val, tree_index * 2 + 2, middle + 1, end);
	        }
	    }
	    public int sumRange(int left, int right) {
	    	if (left == right) {
	    		return enjoyments[rank[left].attraction_number - 1];
	    	}
	    	if (left > right) {
	    		return sum_range_helper(0, rank.length - 1, 0, right, left);
		    }
	        return sum_range_helper(0, rank.length - 1, 0, left, right);
	    }
	    
	    public int sum_range_helper(int start, int end, int tree_index, int left, int right) {
	        if (left <= start && right >= end) {
	            return segment_tree[tree_index];
	        }
	        int middle = (start + end) / 2;
	        if (right <= middle) {
	            return sum_range_helper(start, middle, tree_index * 2 + 1, left, right);
	        } else if (left > middle) {
	            return sum_range_helper(middle + 1, end, tree_index * 2 + 2, left, right);
	        } else {
	            int go_left = sum_range_helper(start, middle, tree_index * 2 + 1, left, middle);
	            int go_right = sum_range_helper(middle + 1, end, tree_index * 2 + 2, middle + 1, right);
	            return go_left ^ go_right;
	        }
	    }
	}
}