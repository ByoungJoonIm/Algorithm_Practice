package dynamicProgramming;

import java.util.Scanner;

public class Fibonacci {
	private static int fibo1(int n){
		if(n < 3)
			return 1;
		return fibo1(n-1) + fibo1(n-2);
	}
	
	private static long fibo2(int n){
		if(n < 3)
			return 1;
		long arr[] = new long[n+1];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		for (int i = 3; i < n + 1; i++)
			arr[i] = arr[i-1] + arr[i-2];
		
		return arr[n];
	}
	
	private static long fibo3(int n){
		if(n < 3)
			return 1;
		long a = 1;
		long b = 1;
		long c = 2;
		
		for (int i = 3; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		
		return c;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		System.out.println(fibo2(N));
		System.out.println(fibo3(N));
		
		
		scan.close();
	}

}
