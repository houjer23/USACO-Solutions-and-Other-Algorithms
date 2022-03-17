import java.io.*;
import java.util.*;

public class No_Time_to_Paint {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		String paint_string = br.readLine();
		int[] paint = new int[N];
		for (int i = 0; i < N; i ++) {
			paint[i] = (int) paint_string.charAt(i) - 65;
		}
		
		int[] front = new int[N];
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(paint[0]);
		int answer = 1;
		front[0] = answer;
		for (int i = 1; i < N; i ++) {
			if (stack.peek() < paint[i]) {
				answer ++;
				stack.push(paint[i]);
			} else {
				while (stack.size() > 0 && stack.peek() > paint[i]) {
					stack.pop();
				}
				if (stack.size() == 0 || stack.peek() < paint[i]) {
					stack.push(paint[i]);
					answer ++;
				}
			}
			front[i] = answer;
		}
		
		int[] back = new int[N];
		stack = new ArrayDeque<Integer>();
		stack.push(paint[N - 1]);
		answer = 1;
		back[N - 1] = answer;
		for (int i = N - 2; i >= 0; i --) {
			if (stack.peek() < paint[i]) {
				answer ++;
				stack.push(paint[i]);
			} else {
				while (stack.size() > 0 && stack.peek() > paint[i]) {
					stack.pop();
				}
				if (stack.size() == 0 || stack.peek() < paint[i]) {
					stack.push(paint[i]);
					answer ++;
				}
			}
			back[i] = answer;
		}
		/*
		for (int i = 0; i < N; i ++) {
			System.out.print(front[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < N; i ++) {
			System.out.print(back[i] + " ");
		}
		System.out.println();
		*/
		for (int i = 0; i < Q; i ++) {
			st = new StringTokenizer(br.readLine());
			int start_empty = Integer.parseInt(st.nextToken()) - 2;
			int end_empty = Integer.parseInt(st.nextToken());
			if (start_empty > end_empty) {
				System.out.println(0);
			} else {
				answer = 0;
				if (start_empty >= 0)
					answer += front[start_empty];
				//System.out.print(answer + " ");
				if (end_empty < N)
					answer += back[end_empty];
				System.out.println(answer);
			}
		}
	}
	public static int find_answer(int start, int end, int[] paint) {
		//System.out.println("START: " + start + " END: " + end);
		if (end < start) {
			return 0;
		}
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(paint[start]);
		int answer = 1;
		for (int i = start + 1; i <= end; i ++) {
			if (stack.peek() < paint[i]) {
				answer ++;
				stack.push(paint[i]);
			} else {
				while (stack.size() > 0 && stack.peek() > paint[i]) {
					stack.pop();
				}
				if (stack.size() == 0 || stack.peek() < paint[i]) {
					stack.push(paint[i]);
					answer ++;
				}
			}
			//System.out.print(paint[i] + " Answer: " + answer + " " + stack + ",  ");
		}
		return answer;
	}
}
