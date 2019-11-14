package string;

import java.util.Scanner;

public class FindingAlphabet {
	public static void main(String[] args) {
		final int alphabetLen = 26;
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		int alphabets[] = new int[alphabetLen];
		
		for (int i = 0; i < alphabetLen; i++)
			alphabets[i] = -1;
		
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';
			if(alphabets[index] < 0)
				alphabets[index] = i;
		}
		
		for (int i = 0; i < alphabetLen; i++)
			System.out.print(alphabets[i] + " ");
	}
}
