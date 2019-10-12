package backtracking;

import java.util.Scanner;

public class NQueen {
	public static int arr[];
	public static int rs = 0;
	public static int N;

	public static boolean isPossible(int n) {
		for (int i = 0; i < n; i++) {
			if (arr[i] == arr[n]) // same line
				return false;
			if ((arr[i] - arr[n]) == (n - i)) // up to down diagonal
				return false;
			if ((arr[n] - arr[i]) == (n - i)) // down to up diagonal
				return false;

		}
		return true;
	}

	public static void search(int n) {
		if (n == N)
			rs++;
		else {
			/*
			 * n = column number which is trying. 
			 * arr[n] = queens position in each column
			 */
			for (int i = 0; i < N; i++) {
				arr[n] = i;
				if (isPossible(n))
					search(n + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N];
		search(0);

		System.out.println(rs);
		scan.close();
	}
}
