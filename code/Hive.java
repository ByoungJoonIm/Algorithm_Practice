package mathmatics;

import java.util.Scanner;

public class Hive {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int cnt = 1;
		
		N--;
		while(N > 0)
			N -= 6 * cnt++;
		
		System.out.println(cnt);
	}

}
