package my_project;

public class deletea {
	public static void main(String[] args) {  
        System.out.println(deleteA("xfaeaxfggeWGSaaf"));
     }  
	public static String deleteA(String str) {
		for (int i = 0; i < str.length(); i++)
		{
			if (str.substring(i,i+1).equals("a"))
			{
				str = str.substring(0, i) + str.substring(i + 1, str.length());
			}
		}
		return str;
	}
}