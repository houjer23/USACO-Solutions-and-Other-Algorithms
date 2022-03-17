package my_project;

public class Matrix {
	int[][] change(int[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			matrix[matrix.length - i - 1][i] = 0;
		}
		return matrix;
	}
	boolean check(String[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			for(int x = 0; x < matrix[0].length; x++)
			{
				if(matrix[i][x].equals("O"))
				{
					for(int k = 0; k < matrix[0].length; k++)
					{
						if(matrix[i][k].equals("O"))
						{
							return false;
						}
					}
					for(int k = 0; k < matrix.length; k++)
					{
						if(matrix[k][x].equals("O"))
						{
							return false;
						}
					}
					int diff = x - i;
					for(int k = 0; k < matrix.length; k++)
					{
						if(k + diff > 0 && k + diff< matrix[0].length && matrix[k][k + diff].equals("O") && k != i)
						{
							return false;
						}
					}
					int sum = i + x;
					for(int k = 0; k < matrix.length; k++)
					{
						if(sum - k > 0 && sum - k < matrix[0].length && matrix[k][sum - k].equals("O") && k != i)
						{
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
