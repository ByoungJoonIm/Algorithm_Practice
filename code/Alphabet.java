package backtracking;

import java.util.HashSet;
import java.util.Scanner;

public class Alphabet {
	static int R;
	static int C;
	static char chs[][];
	static HashSet<Character> alpha = new HashSet<Character>();
	static int max = 0;

	private static void search(int n, int i, int j) {
		alpha.add(chs[i][j]);
		if (i - 1 >= 0)
			if (!alpha.contains(chs[i - 1][j]))
				search(n + 1, i - 1, j);
		if (i + 1 < R)
			if (!alpha.contains(chs[i + 1][j]))
				search(n + 1, i + 1, j);
		if (j - 1 >= 0)
			if (!alpha.contains(chs[i][j - 1]))
				search(n + 1, i, j - 1);
		if (j + 1 < C)
			if (!alpha.contains(chs[i][j + 1]))
				search(n + 1, i, j + 1);
		alpha.remove(chs[i][j]);
		if (n > max)
			max = n;

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		R = scan.nextInt();
		C = scan.nextInt();

		chs = new char[R][C];
		for (int i = 0; i < R; i++) {
			String temp = scan.next();
			for (int j = 0; j < C; j++) {
				chs[i][j] = temp.charAt(j);
			}
		}

		search(1, 0, 0);
		System.out.println(max);
		scan.close();
	}

}
