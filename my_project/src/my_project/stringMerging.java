package my_project;

public class stringMerging {
	public static void main(String[] args) {  
        System.out.println(merge("aeffx", "bcd"));
     }  
	public static String merge(String str1, String str2) {
		for (int i = 0; i < str2.length(); i++)
		{
			for (int x = 0; x < str1.length(); x++)
			{
				if (str2.substring(i).compareTo(str1.substring(x,x+1)) < 0)
				{
					str1 = str1.substring(0, x) + str2.substring(x, x+1) + str1.substring(x, str1.length());
				}
			}

		}
		return str1;
	}

}