import java.io.*;
import java.util.*;

public class Linked_List {
	public static class Node {
		int val;
		Node next;
		public Node (int val) {
			this.val = val;
			next = null;
		}
	}
	public static void main(String[] args) throws IOException {
		Node head = create_linked_list(100);
		print_linked_list(head);
	}
	public static Node create_linked_list(int N) {
		Node head = new Node(1);
		Node prev = head;
		for (int i = 2; i <= N; i ++)
		{
			Node cur = new Node(i);
			prev.next = cur;
			prev = cur;
		}
		return head;
	}
	public static void print_linked_list(Node head) {
		Node cur = head;
		while (cur != null)
		{
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
}
