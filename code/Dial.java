package string;

import java.util.Scanner;

public class Dial {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String numbers = scan.nextLine();
		int time = 0;
		
		for (int i = 0; i < numbers.length(); i++) {
			char ch = numbers.charAt(i);
			if(ch < 'P')
				time += (ch - 'A') / 3 + 3;
			else if(ch < 'T')		//7
				time += 8;
			else if(ch < 'W')		//8
				time += 9;
			else					//9
				time += 10;
		}
		System.out.println(time);
		
		scan.close();
	}
}
