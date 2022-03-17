import java.io.*;
import java.util.*;

public class prefix_sum {
	public static void main(String[] args) throws IOException {
		int[] arr_1D = {1, 2, 3, 4, 5, 6};
		oneDemension(arr_1D);
		System.out.println();
		int[][] arr_2D = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		twoDemension(arr_2D);
	}
	public static void oneDemension(int[] arr_1D) {
		int[] arr_prefix_sum = new int[arr_1D.length + 1];
		for (int i = 1; i <= arr_1D.length; i ++)
		{
			arr_prefix_sum[i] = arr_prefix_sum[i - 1] + arr_1D[i - 1];
		}
		for (int i = 1; i < arr_prefix_sum.length; i ++)
		{
			System.out.print(arr_prefix_sum[i] + " ");
		}
	}
	public static void twoDemension(int[][] arr_2D) {
		int[][] arr_prefix_sum = new int[arr_2D.length + 1][arr_2D[0].length + 1];
		for (int i = 1; i <= arr_2D.length; i ++)
		{
			for (int j = 1; j <= arr_2D[0].length; j ++)
			{
				arr_prefix_sum[i][j] = arr_prefix_sum[i - 1][j] + arr_prefix_sum[i][j - 1] - arr_prefix_sum[i - 1][j - 1] + arr_2D[i - 1][j - 1];
			}
		}
		for (int i = 1; i <= arr_2D.length; i ++)
		{
			for (int j = 1; j <= arr_2D[0].length; j ++)
			{
				System.out.print(arr_prefix_sum[i][j] + " ");
			}
			System.out.println();
		}
	}
}
