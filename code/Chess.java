package bruteforce;

import java.util.Scanner;

public class Chess {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int M;
		int N;
		String chess[];
		char colors[] = {'W', 'B'};
		
		/*
		 * inputs
		 * */
		N = scan.nextInt();
		M = scan.nextInt();
		
		chess = new String[N];
		for (int i = 0; i < N; i++) {
			chess[i] = scan.next();
		}
		
		/*
		 * algorithm
		 * */
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 2; i++) {
			char temp = colors[0];
			colors[0] = colors[1];
			colors[1] = temp;
			
			for (int j = 0; j <= N - 8; j++) {
				for (int k = 0; k <= M - 8; k++) {
					int counter = 0;
					for (int l = j; l < j + 8; l++) {
						for (int m = k; m < k + 8; m++) {
							if(colors[(l + m) % 2] == chess[l].charAt(m))
								counter++;
						}
					}
					if(min > counter)
						min = counter;
				}
			}
		}
		
		System.out.println(min);
		
		
	}

}
