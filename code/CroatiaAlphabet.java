package string;

import java.util.Scanner;

public class CroatiaAlphabet {
	public static void theBetterSolution(){
		Scanner scan = new Scanner(System.in);
		String target[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String str = scan.nextLine();
		
		for (int i = 0; i < target.length; i++)
			str = str.replace(target[i], "a");
		System.out.println(str.length());
		scan.close();
	}
	
	public static void solution(){
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		char before2 = ' ';
		char before1 = ' ';
		int cnt = 0;
		
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch == '='){
				if(before1 == 'c' || before1 == 's')
					cnt--;
				if(before1 == 'z'){
					cnt--;
					if(before2 == 'd')
						cnt--;
				}
			}
			if(ch == '-'){
				if(before1 == 'c' || before1 == 'd')
					cnt--;
			}
			if(ch == 'j'){
				if(before1 == 'l' || before1 == 'n')
					cnt--;
			}
			
			cnt++;
			before2 = before1;
			before1 = ch;
		}
		
		System.out.println(cnt);
		scan.close();
	}
	
	public static void main(String[] args) {
		theBetterSolution();
//		solution();
	}
}
