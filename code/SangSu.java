package string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SangSu {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		String a = st.nextToken();
		String b = st.nextToken();
		String reverseA = "";
		String reverseB = "";
		
		for (int i = 0; i < a.length(); i++) {
			reverseA += a.charAt(a.length() -1 - i);
			reverseB += b.charAt(b.length() -1 - i);
		}
		int intA = Integer.parseInt(reverseA);
		int intB = Integer.parseInt(reverseB);
		
		if(intA > intB)
			System.out.println(intA);
		else
			System.out.println(intB);
		
		scan.close();
	}
}
