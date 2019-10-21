package dynamicProgramming;

import java.util.Scanner;

public class Tile01 {
	private static int getTile(int N){
		final int divNum = 15746;
		if(N < 3)
			return N;
		
		int tile[] = new int[N + 1];		
		tile[1] = 1;
		tile[2] = 2;
		for (int i = 3; i < N + 1; i++)
			tile[i] = (tile[i - 1] + tile[i - 2]) % divNum;
		
		return tile[N];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		System.out.println(getTile(N));
		scan.close();
	}
}
