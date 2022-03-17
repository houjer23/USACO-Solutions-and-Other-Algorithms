package my_project;

public class pyramid {
	public static void main(String[] args) {
		for (int i = 0; i <= 9; i++)
		{
			for (int k = 1; k <= 9 - i; k++)
			{
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++)
			{
				System.out.print("* ");
			}
			System.out.println("* ");
		}
		}
}
