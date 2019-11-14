package string;

import java.util.Scanner;

public class SumOfNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		String numbers = scan.next();
		int sum = 0;
		
		for (int i = 0; i < N; i++)
			sum += ((int)numbers.charAt(i) - '0');
		
		System.out.println(sum);
		scan.close();
	}
}
