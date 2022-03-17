package my_project;

public class averagegrade {
	public static void main(String[] args) {
		int[] arr = new int[9];
		arr[0] = 45;
		arr[1] = 69;
		arr[2] = 36;
		arr[3] = 98;
		arr[4] = 78;
		arr[5] = 56;
		arr[6] = 85;
		arr[7] = 90;
		arr[8] = 12;
        System.out.println(calcAverage(arr));
     }  
	public static double calcAverage(int[] arr) {
		int sum = 0;
		int num = 0;
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] >= 60)
			{
				sum += arr[i];
			}
		}
		return ((double) sum) / num;
	}
}
