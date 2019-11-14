package string;

import java.util.Scanner;

public class WordStudy {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int histogram[] = new int[26];
		String str = scan.nextLine().toLowerCase();
		
		for (int i = 0; i < str.length(); i++)
			histogram[str.charAt(i) - 'a']++;
		
		int maxIndex = 0;
		int max = histogram[0];
		boolean isDuplication = false;
		
		for (int i = 1; i < 26; i++) {
			if(histogram[i] == max)
				isDuplication = true;
			else if(histogram[i] > max){
				max = histogram[i];
				maxIndex = i;
				isDuplication = false;
			}
		}
		
		char rs;
		if( isDuplication )
			rs = '?';
		else
			rs = (char)(maxIndex + 'A');
		
		System.out.println(rs);
		scan.close();
		
	}
}
