import java.io.*;
import java.util.*;

public class Sort{
	public static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException{
		list = new ArrayList<>();
		for (int i = 0; i < 10; i ++)
		{
			list.add((int) (Math.random() * 100));
		}
		System.out.println(list);
		quick_sort(0, list.size() - 1);
		System.out.println(list);
	}
	
	static ArrayList<Integer> selection_sort(ArrayList<Integer> list){
		for (int i = 0; i < list.size(); i ++)
		{
			int min = Integer.MAX_VALUE;
			int pos = -1;
			for (int j = i; j < list.size(); j ++)
			{
				if (list.get(j) < min)
				{
					min = list.get(j);
					pos = j;
				}
			}
			list.set(pos, list.get(i));
			list.set(i, min);
		}
		return list;
	}
	
	static ArrayList<Integer> insertion_sort(ArrayList<Integer> list){
		for (int i = 1; i < list.size(); i ++)
		{
			for (int j = i - 1; j >= 0; j --)
			{
				if (list.get(j) < list.get(i))
				{
					list.add(j + 1, list.get(i));
					list.remove(i + 1);
					break;
				}
				else if (j == 0)
				{
					list.add(0, list.get(i));
					list.remove(i + 1);
				}
			}
		}
		return list;
	}
	
	static ArrayList<Integer> bubble_sort(ArrayList<Integer> list){
		for (int i = list.size(); i > 0; i --)
		{
			int change = 0;
			for (int j = 0; j < i - 1; j ++)
			{
				if (list.get(j) > list.get(j + 1))
				{
					int first = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, first);
					change ++;
				}
			}
			if (change == 0)
			{
				break;
			}
		}
		return list;
	}
	static void quick_sort(int start, int end){
		if (start >= end)
		{
			return;
		}
		int i = start + 1;
		int j = end;
		while (i < j && i <= end && j >= start)
		{
			if (list.get(i) < list.get(start))
			{
				i ++;
				continue;
			}
			if (list.get(j) > list.get(start))
			{
				j --;
				continue;
			}
			int temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}
		if (i > end || j < start || list.get(i) >= list.get(start))
		{
			int temp2 = list.get(i - 1);
			list.set(i - 1, list.get(start));
			list.set(start, temp2);
			quick_sort(start, i - 2);
			quick_sort(i, end);
		}
		else
		{
			int temp2 = list.get(j);
			list.set(j, list.get(start));
			list.set(start, temp2);
			quick_sort(start, i - 1);
			quick_sort(i + 1, end);
		}
		//System.out.println(list);
	}
	static ArrayList<Integer> merge_sort(ArrayList<Integer> list){
		if (!(list.size() == 1))
		{
			ArrayList<Integer> list1 = new ArrayList<Integer>(list.subList(0, list.size() / 2));
			ArrayList<Integer> list2 = new ArrayList<Integer>(list.subList(list.size() / 2, list.size()));
			//System.out.println(list1 + " " + list2);
			ArrayList<Integer> list1_1 = merge_sort(list1);
			ArrayList<Integer> list2_1 = merge_sort(list2);
			//System.out.println(list1_1 + " " + list2_1);
			ArrayList<Integer> list3 = new ArrayList<Integer>();
			int i = 0;
			int j = 0;
			while (i < list1_1.size() && j < list2_1.size())
			{
				if (list1_1.get(i) > list2_1.get(j))
				{
					list3.add(list2_1.get(j));
					j ++;
				}
				else
				{
					list3.add(list1_1.get(i));
					i ++;
				}
			}
			if (i == list1_1.size())
			{
				for (int k = j; k < list2_1.size(); k ++)
				{
					list3.add(list2_1.get(k));
				}
			}
			else
			{
				for (int k = i; k < list1_1.size(); k ++)
				{
					list3.add(list1_1.get(k));
				}
			}
			//System.out.println(list3);
			return list3;
		}
		else
		{
			return list;
		}
	}

}
