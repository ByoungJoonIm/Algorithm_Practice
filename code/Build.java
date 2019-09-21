package bruteforce;

import java.util.Scanner;
public class Build {

	public static void main(String[] args) {
		/*
		 * inputs
		 * */
		Scanner scan = new Scanner(System.in);
		int N;
		int rs[];
		int rank[];
		
		int weights[];
		int talls[];
		
		N = scan.nextInt();
		rs = new int[N];
		weights = new int[N];
		talls = new int[N];
		rank = new int[N];
		
		for (int i = 0; i < N; i++) {
			weights[i] = scan.nextInt();
			talls[i] = scan.nextInt();
		}
		
		/*
		 * algorithm
		 * */
		for (int i = 0; i < N; i++) {
			int k = 0;
			for (int j = 0; j < N; j++) {
				if(weights[i] < weights[j] && talls[i] < talls[j])
					rank[i]++;
			}
		}
		for (int i = 0; i < N; i++)
			System.out.print(rank[i] + 1 + " ");
		scan.close();
	}
}
