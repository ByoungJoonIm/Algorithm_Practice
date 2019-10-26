package dynamicProgramming;

import java.util.Scanner;

public class EasyStairsNumber {
	/*
	 *    0 1 2 3 4 5 6 7 8 9
	 * 0 
	 * 1  0 1 1 1 1 1 1 1 1 1
	 * 2  1 1 2 2 2 2 2 2 2 2
	 * 3  1 3 3 4 4 4 4 4 3 2
	 * N
	 * 
	 * */
	
	
	public static void main(String[] args) {
		final int divNum = 1000000000;
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		long d[][] = new long[N + 1][10];
		
		for (int i = 1; i < 10; i++)
			d[1][i] = 1;
		for (int i = 2; i <= N; i++) {
			d[i][0] = d[i - 1][1];
			for (int j = 1; j < 9; j++)
				d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % divNum;
			d[i][9] = d[i - 1][8];
		}
		
		long sum = 0;
		for (int i = 0; i < 10; i++)
			sum = (sum + d[N][i]) % divNum;
		
		System.out.println(sum);
		scan.close();
	}
}