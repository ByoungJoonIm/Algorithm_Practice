
/*
 concept ref : http://comganet.github.io/dp/2016/06/03/dp-1003
 examples : 4 items and 14kg
 coreect value : 300
 
4 14
2 40
5 110
10 200
3 50
 
4 15
2 40
4 60
6 80
8 100
 
 
 */

import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		// kanpsack2();
		kanpsack1();
	}

	//used 2 dimension array
	public static void kanpsack2() {
		// input
		Scanner scan = new Scanner(System.in);
		int N; // the number of items
		int W; // total amount

		int Ws[]; // weighs of each items
		int Vs[]; // values of each items
		int d[][];

		N = scan.nextInt();
		W = scan.nextInt();

		Ws = new int[N + 1];
		Vs = new int[N + 1];
		d = new int[N + 1][W + 1];
		for (int i = 1; i <= N; i++) {
			Ws[i] = scan.nextInt();
			Vs[i] = scan.nextInt();
		}

		// algorithm
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= W; j++) {
				if (Ws[i] > j)
					d[i][j] = d[i - 1][j];
				else
					d[i][j] = Integer.max(d[i - 1][j], d[i][j - Ws[i]] + Vs[i]);
			}
		}

		System.out.println(d[N][W]);
	}

	//used 1 dimension array
	public static void kanpsack1() {
		Scanner scan = new Scanner(System.in);

		int N; // the number of items
		int W; // total weight

		int d[];
		int weights[];
		int values[];

		N = scan.nextInt();
		W = scan.nextInt();

		weights = new int[N + 1];
		values = new int[N + 1];
		d = new int[W + 1];

		for (int i = 1; i <= N; i++) {
			weights[i] = scan.nextInt();
			values[i] = scan.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			for (int j = weights[i]; j <= W; j++) {
				d[j] = Integer.max(d[j], d[j - weights[i]] + values[i]);
			}
		}
		System.out.println(d[W]);
	}
}
