package Game;

import java.util.*;
import java.io.*;

public class Boardgame {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("changeNumber.in"));
		int size = Integer.parseInt(br.readLine());
		System.out.println(size);
		int[][] matrix = new int[size][size];
		StringTokenizer st;
		for (int i = 0; i < size; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int changeNumber = Integer.parseInt(br.readLine());
		if (matrix[row - 1][col - 1] != changeNumber)
		{
			changeMatrix(matrix, row, col, changeNumber, size);
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("changNumber.out")));
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				if (j + 1 == size)
				{
					pw.print(matrix[i][j]);
				}
				else
				{
					pw.print(matrix[i][j] + " ");
				}
			}
			if (i < size - 1)
			{
				pw.println();
			}
		}
		pw.close();
	}
	static int[][] changeMatrix(int[][] matrix, int row, int col, int changeNumber, int size){
		int number = matrix[row - 1][col - 1];
		matrix[row - 1][col - 1] = changeNumber;
		if (row - 2 >= 0 && matrix[row - 2][col - 1] == number)
		{
			changeMatrix(matrix, row - 1, col, changeNumber, size);
		}
		if (row + 1 <= size && matrix[row][col - 1] == number)
		{
			changeMatrix(matrix, row + 1, col, changeNumber, size);
		}
		if (col - 2 >= 0 && matrix[row - 1][col - 2] == number)
		{
			changeMatrix(matrix, row, col - 1, changeNumber, size);
		}
		if (col + 1 <= size && matrix[row - 1][col] == number)
		{
			changeMatrix(matrix, row, col + 1, changeNumber, size);
		}
		return matrix;
	}
}
