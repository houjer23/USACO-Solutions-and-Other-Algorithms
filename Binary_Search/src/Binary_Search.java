import java.io.*;
import java.util.*;

public class Binary_Search {
	public static void main(String[] args) throws IOException{
		
		int[] nums = {1, 2, 2, 3, 4, 5, 5, 6, 7};
		
		System.out.println(binary_search_repeating_last_greater_or_equal_nums(nums, 2));
		
	}
	static int binary_search(int[] nums, int val){
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) // ???
		{
			int middle = (start + end) / 2; // ???
			if (nums[middle] == val) // ??
			{
				return middle;
			}
			else if (nums[middle] > val)
			{
				end = middle - 1; // ???
			}
			else
			{
				start = middle + 1; // ???
			}
		}
		return -1;
	}
	static int binary_search_repeating_nums(int[] nums, int val){
		int start = 0;
		int end = nums.length - 1;
		while (start < end) // ???
		{
			int middle = (start + end) / 2; // ???
			if (nums[middle] >= val)
			{
				end = middle; // ???
			}
			else
			{
				start = middle + 1; // ???
			}
		}
		if (nums[start] == val)
		{
			return start;
		}
		else
		{
			return -1;
		}
	}
	static int binary_search_repeating_last_nums(int[] nums, int val){
		int start = 0;
		int end = nums.length - 1;
		while (start < end) // ???
		{
			int middle = (start + end + 1) / 2; // ???
			if (nums[middle] > val)
			{
				end = middle - 1; // ???
			}
			else
			{
				start = middle; // ???
			}
		}
		if (nums[start] == val)
		{
			return start;
		}
		else
		{
			return -1;
		}
	}
	static int binary_search_repeating_last_smaller_or_equal_nums(int[] nums, int val){
		int start = 0;
		int end = nums.length - 1;
		while (start < end) // ???
		{
			int middle = (start + end + 1) / 2; // ???
			if (nums[middle] > val)
			{
				end = middle - 1; // ???
			}
			else
			{
				start = middle; // ???
			}
		}
		if (nums[start] <= val)
		{
			return start;
		}
		else
		{
			return -1;
		}
	}
	static int binary_search_repeating_last_greater_or_equal_nums(int[] nums, int val){
		int start = 0;
		int end = nums.length - 1;
		while (start < end) // ???
		{
			int middle = (start + end) / 2; // ???
			if (nums[middle] >= val)
			{
				end = middle; // ???
			}
			else
			{
				start = middle + 1; // ???
			}
		}
		if (nums[start] >= val)
		{
			return start;
		}
		else
		{
			return -1;
		}
	}
}
