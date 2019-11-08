package mathmatics;

import java.util.Scanner;

public class Fraction {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int n = (int)((-1 + Math.sqrt(- 7 + 8 * N)) / 2 + 1);
		int an = (n * (n - 1) + 2) / 2;	
		int distance = N - an + 1;
		
		if(n % 2 == 0)
			System.out.println(distance + "/" + (n + 1 - distance));
		else
			System.out.println((n + 1 - distance) + "/" + distance);
		scan.close();
	}
}
