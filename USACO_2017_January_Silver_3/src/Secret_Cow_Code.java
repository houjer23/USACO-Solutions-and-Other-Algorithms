import java.io.*;
import java.util.*;

public class Secret_Cow_Code {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		long index = Long.parseLong(st.nextToken()) - 1;
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
		pw.println(find(s, index));
		pw.close();
	}
	public static char find(String s, long index) {
		if (index < s.length())
		{
			return s.charAt((int) index);
		}
		long length = s.length();
		while (2 * length <= index) 
		{
			length *= 2;
		}
		if (length == index) 
		{
			return find(s, length - 1);
		}
		return find(s, index - length - 1);
	}
}
