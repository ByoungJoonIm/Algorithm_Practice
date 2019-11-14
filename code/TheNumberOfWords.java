package string;

import java.util.Scanner;

public class TheNumberOfWords {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine().trim();
		int cnt = 1;
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ')
				cnt++;
		}
		
		if(str.length() == 0)
			cnt = 0;
		
		System.out.println(cnt);
		
		scan.close();
	}
}
