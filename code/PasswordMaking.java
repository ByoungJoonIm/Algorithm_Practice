package backtracking;

import java.util.HashSet;
import java.util.Scanner;

public class PasswordMaking {
	static HashSet<Character> vowelSet = new HashSet<Character>();
	static HashSet<Character> chs = new HashSet<Character>();
	static StringBuilder strb = new StringBuilder();
	static int L;
	
	public static boolean isPossible(String str){
		int cons = 0;	//자음
		int vowel = 0;	//모음
		
		for (int i = 0; i < str.length(); i++) {
			if(cons >= 2 && vowel >= 1)
				return true;
			if(vowelSet.contains(str.charAt(i)))
				vowel++;
			else
				cons++;
		}
		
		return cons >= 2 && vowel >= 1;
	}
	
	public static void search(char start){
		if(strb.length() == L && isPossible(strb.toString())){
			System.out.println(strb);
		} else{
			for (char c = start; c <= 'z'; c++) {
				if(chs.contains(c)){
					int len = strb.length();
					strb.append(c);
					search((char)(c + 1));
					strb.delete(len, strb.length());
				}
			}	
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int C;

		vowelSet.add('a');
		vowelSet.add('e');
		vowelSet.add('i');
		vowelSet.add('o');
		vowelSet.add('u');
		
		L = scan.nextInt();
		C = scan.nextInt();
		scan.nextLine();
		String chInputs = scan.nextLine();
		
		for (int i = 0; i < C; i++) {
			chs.add(chInputs.split(" ")[i].charAt(0));
		}
		
		search('a');
		scan.close();
	}
}
