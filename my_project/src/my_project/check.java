package my_project;

public class check {
	public static void main(String[] args) {
		
     }  
	public static boolean checkDistant(int[] arr, int num) {
		int start = 0;
		for (int x = 0; x < arr.length; x++)
		{
			if (arr[x] == 1)
			{
				start = x;
				break;
			}
		}
		int lastIndex = start;
		for (int i = start + 1; i < arr.length; i++)
		{
			if (arr[i] == 1)
			{
				if ( i - lastIndex - 1 < num)
				{
					return false;
				}
				lastIndex = i;
			}
		}
		return true;
	}
}
